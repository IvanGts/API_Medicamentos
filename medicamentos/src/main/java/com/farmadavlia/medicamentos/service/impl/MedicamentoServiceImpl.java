package com.farmadavlia.medicamentos.service.impl;

import com.farmadavlia.medicamentos.domain.dto.InformacoesInjetaveisDTO;
import com.farmadavlia.medicamentos.domain.dto.MedicamentoDTO;
import com.farmadavlia.medicamentos.domain.models.InformacoesInjetaveisEntity;
import com.farmadavlia.medicamentos.domain.models.MedicamentoEntity;
import com.farmadavlia.medicamentos.mapper.MedicamentoMapper;
import com.farmadavlia.medicamentos.repository.MedicamentoRepository;
import com.farmadavlia.medicamentos.service.MedicamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class MedicamentoServiceImpl implements MedicamentoService {


    @Autowired
    private MedicamentoRepository medicamentoRepository;

    @Autowired
    private MedicamentoMapper medicamentoMapper;

    @Override
    public MedicamentoDTO salvarMedicamentoNaoInjetavel(MedicamentoDTO medicamentoDTO) {
        MedicamentoEntity medicamentoEntity = new MedicamentoEntity();
        MedicamentoEntity medicamento = MedicamentoEntity.builder()
                .idMedicamento(medicamentoDTO.getId())
                .nomeMedicamento(medicamentoDTO.getNomeMedicamento())
                .descricao(medicamentoDTO.getDescricao())
                .preco(medicamentoDTO.getPreco())
                .precoComDesconto(medicamentoDTO.getPrecoComDesconto())
                .marca(medicamentoDTO.getMarca())
                .fabricante(medicamentoDTO.getFabricante()).build();
        medicamentoRepository.save(medicamento);
        return new MedicamentoDTO(medicamento);
    }

    @Override
    public MedicamentoDTO salvarMedicamentoInjetavel(MedicamentoDTO medicamentoInjetavelDTO, InformacoesInjetaveisDTO informacoesInjetaveisDTO) {
        MedicamentoEntity medicamentoEntity = new MedicamentoEntity();
        MedicamentoEntity medicamentoInjetavel = MedicamentoEntity.builder()
                .idMedicamento(medicamentoInjetavelDTO.getId())
                .nomeMedicamento(medicamentoInjetavelDTO.getNomeMedicamento())
                .descricao(medicamentoInjetavelDTO.getDescricao())
                .preco(medicamentoInjetavelDTO.getPreco())
                .precoComDesconto(medicamentoInjetavelDTO.getPrecoComDesconto())
                .marca(medicamentoInjetavelDTO.getMarca())
                .fabricante(medicamentoInjetavelDTO.getFabricante())
                .informacoesInjetaveisEntity(InformacoesInjetaveisEntity.builder()
                .tipoAplicacao(informacoesInjetaveisDTO.getTipoAplicacao())
                .build()).build();

        medicamentoRepository.save(medicamentoInjetavel);

        return new MedicamentoDTO(medicamentoInjetavel);
    }

    @Override
    public List<MedicamentoEntity> listarMedicamentos() {
        return null;
    }

    @Override
    public MedicamentoDTO buscarMedicamentoPorId(Long id) {
        return null;
    }

    @Override
    public MedicamentoDTO buscarMedicamentoPorFiltro(String marca, String fabricante, BigDecimal preco) {
        return null;
    }

}
