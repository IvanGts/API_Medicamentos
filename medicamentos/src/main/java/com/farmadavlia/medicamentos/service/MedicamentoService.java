package com.farmadavlia.medicamentos.service;


import com.farmadavlia.medicamentos.domain.dto.InformacoesInjetaveisDTO;
import com.farmadavlia.medicamentos.domain.dto.MedicamentoDTO;
import com.farmadavlia.medicamentos.domain.models.InformacoesInjetaveisEntity;
import com.farmadavlia.medicamentos.domain.models.MedicamentoEntity;

import java.math.BigDecimal;
import java.util.List;

public interface MedicamentoService {

//    MedicamentoDTO salvarMedicamentoNaoInjetavel(Long id, String nomeMedicamento, String descricao, double preco,
//                                                 double precoComDesconto, String Marca, String fabricante);

    MedicamentoDTO salvarMedicamentoNaoInjetavel(MedicamentoDTO medicamentoDTO);

    MedicamentoDTO salvarMedicamentoInjetavel(MedicamentoDTO medicamentoInjetavelDTO,
                                              InformacoesInjetaveisDTO informacoesInjetaveisDTO);

    List<MedicamentoEntity> listarMedicamentos();

    MedicamentoDTO buscarMedicamentoPorId(Long id);

    MedicamentoDTO buscarMedicamentoPorFiltro(String marca, String fabricante, BigDecimal preco);

}
