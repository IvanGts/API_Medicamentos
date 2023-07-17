package com.farmadavlia.medicamentos.service.impl;

import com.farmadavlia.medicamentos.domain.dto.MedicamentoDTO;
import com.farmadavlia.medicamentos.domain.dto.MedicamentoInjetavelDTO;
import com.farmadavlia.medicamentos.domain.models.MedicamentoEntity;
import com.farmadavlia.medicamentos.mapper.MedicamentoMapper;
import com.farmadavlia.medicamentos.repository.MedicamentoRepository;
import com.farmadavlia.medicamentos.service.MedicamentoService;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MedicamentoServiceImpl implements MedicamentoService {


    @Autowired
    private MedicamentoRepository medicamentoRepository;

    @Autowired
    private MedicamentoMapper medicamentoMapper;

    @Override
    public MedicamentoDTO salvarMedicamentoNaoInjetavel(MedicamentoDTO medicamentoDTO) {


        MedicamentoEntity medicamento = MedicamentoEntity.builder()
                .idMedicamento(medicamentoDTO.getId())
                .nomeMedicamento(medicamentoDTO.getNomeMedicamento())
                .descricao(medicamentoDTO.getDescricao())
                .preco(medicamentoDTO.getPreco())
                .precoComDesconto(medicamentoDTO.getPrecoComDesconto())
                .marca(medicamentoDTO.getMarca())
                .fabricante(medicamentoDTO.getFabricante())
                .tipoAplicacao("Medicamento não injetável").build();
        medicamento.getPreco().doubleValue();
        medicamento.getPrecoComDesconto().doubleValue();
        medicamentoRepository.save(medicamento);
        return new MedicamentoDTO(medicamento);
    }

    @Override
    public MedicamentoInjetavelDTO salvarMedicamentoInjetavel(MedicamentoInjetavelDTO medicamentoInjetavelDTO) {
        String tipoAplicacao = medicamentoInjetavelDTO.getTipoAplicacao();

        MedicamentoEntity medicamentoInjetavel = MedicamentoEntity.builder()
                .idMedicamento(medicamentoInjetavelDTO.getId())
                .nomeMedicamento(medicamentoInjetavelDTO.getNomeMedicamento())
                .descricao(medicamentoInjetavelDTO.getDescricao())
                .preco(medicamentoInjetavelDTO.getPreco())
                .precoComDesconto(medicamentoInjetavelDTO.getPrecoComDesconto())
                .marca(medicamentoInjetavelDTO.getMarca())
                .fabricante(medicamentoInjetavelDTO.getFabricante())
                .tipoAplicacao(medicamentoInjetavelDTO.getTipoAplicacao())
                .build();

        String tipoAplicacaoNormalizado = medicamentoMapper.normalizarTexto(medicamentoInjetavel.getTipoAplicacao());
        switch (medicamentoInjetavel.getTipoAplicacao()){
            case "Endovenosa":
            case "Intradérmica":
            case "Intramuscular":
            case "Subcutânea":
                medicamentoRepository.save(medicamentoInjetavel);
                return medicamentoInjetavelDTO;
            default:
                throw new RuntimeException("Categoria não existe ");
        }


    }

    @Override
    public MedicamentoDTO atualizarMedicamento(Long id, BigDecimal preco, BigDecimal precoComDesconto) {
        Optional<MedicamentoEntity> optionalMedicamento = medicamentoRepository.findById(id);
        if (optionalMedicamento.isPresent()){
            MedicamentoEntity medicamento = optionalMedicamento.get();

            if (precoComDesconto != null) {
                medicamento.setPrecoComDesconto(precoComDesconto);
            }
            medicamento.setPreco(preco);
            MedicamentoEntity medicamentoAtualizado = medicamentoRepository.save(medicamento);
            return new MedicamentoDTO(medicamentoAtualizado);
        }

        throw new RuntimeException("Medicamento não encontrado com o ID: " + id);
    }

    @Override
    public Page<MedicamentoDTO> listarMedicamentos(Pageable pageable) {
        Page<MedicamentoEntity> medicamentos = medicamentoRepository.findAll(pageable);
            Page<MedicamentoDTO> medicamentoPaginadoDTO = medicamentos.map(m -> {
                MedicamentoDTO medicamentoDTO = new MedicamentoDTO();
                medicamentoDTO.setId(m.getIdMedicamento());
                medicamentoDTO.setNomeMedicamento(m.getNomeMedicamento());
                medicamentoDTO.setDescricao(m.getDescricao());
                medicamentoDTO.setPreco(m.getPreco());
                medicamentoDTO.setMarca(m.getMarca());
                medicamentoDTO.setPrecoComDesconto(m.getPrecoComDesconto());
                medicamentoDTO.setFabricante(m.getFabricante());
                medicamentoDTO.setTipoAplicacao(m.getTipoAplicacao());
                medicamentoDTO.getPreco();
                medicamentoDTO.getPrecoComDesconto();
                return medicamentoDTO;
        });
        return medicamentoPaginadoDTO;
    }


    public MedicamentoDTO deletarMedicamento(Long id) {
        Optional<MedicamentoEntity> medicamentoOptional = medicamentoRepository.findById(id);

        if (medicamentoOptional.isPresent()) {
            MedicamentoEntity medicamento = medicamentoOptional.get();
            medicamentoRepository.deleteById(id);

            MedicamentoDTO medicamentoDTO = new MedicamentoDTO();
            BeanUtils.copyProperties(medicamento, medicamentoDTO);

            return medicamentoDTO;
        } else {
            throw new RuntimeException("Medicamento não encontrado com o ID: " + id);
        }
    }

    public List<MedicamentoDTO> buscarMedicamentoPorFiltro(String marca, String fabricante, BigDecimal precoMenorQue, BigDecimal precoMaiorQue) {
        List<MedicamentoEntity> medicamentos = medicamentoRepository.findAll();

        List<MedicamentoEntity> medicamentosFiltrados = medicamentos.stream()
                .filter(medicamento -> marca == null || medicamento.getMarca().equalsIgnoreCase(marca))
                .filter(medicamento -> fabricante == null || medicamento.getFabricante().equalsIgnoreCase(fabricante))
                .filter(medicamento -> precoMenorQue == null || medicamento.getPreco().compareTo(precoMenorQue) < 0)
                .filter(medicamento -> precoMaiorQue == null || medicamento.getPreco().compareTo(precoMaiorQue) > 0)
                .collect(Collectors.toList());

        return medicamentoMapper.converterMedicamentoEntityToDtoList(medicamentosFiltrados);
    }

}
