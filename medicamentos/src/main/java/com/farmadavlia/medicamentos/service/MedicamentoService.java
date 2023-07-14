package com.farmadavlia.medicamentos.service;


import com.farmadavlia.medicamentos.domain.dto.MedicamentoDTO;
import com.farmadavlia.medicamentos.domain.dto.MedicamentoInjetavelDTO;
import com.farmadavlia.medicamentos.domain.models.MedicamentoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;

public interface MedicamentoService {

    MedicamentoDTO salvarMedicamentoNaoInjetavel(MedicamentoDTO medicamentoDTO);

    MedicamentoInjetavelDTO salvarMedicamentoInjetavel(MedicamentoInjetavelDTO medicamentoInjetavelDTO);

    MedicamentoDTO atualizarMedicamento(Long id, BigDecimal preco, BigDecimal precoComDesconto);

    Page<MedicamentoDTO> listarMedicamentos(Pageable pageable);

    List<MedicamentoDTO> buscarMedicamentoPorFiltro(String marca, String fabricante, BigDecimal precoMenorQue,
                                             BigDecimal precoMaiorQue);

    MedicamentoDTO deletarMedicamento(Long id);


}
