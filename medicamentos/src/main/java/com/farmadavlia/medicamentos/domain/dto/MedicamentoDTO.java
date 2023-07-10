package com.farmadavlia.medicamentos.domain.dto;

import com.farmadavlia.medicamentos.domain.enums.TipoAplicacao;
import com.farmadavlia.medicamentos.domain.models.MedicamentoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class MedicamentoDTO {
    private Long id;
    private String nomeMedicamento;
    private String descricao;
    private BigDecimal preco;
    private BigDecimal precoComDesconto;
    private String marca;
    private String fabricante;

    private TipoAplicacao tipoAplicacao;
    public MedicamentoDTO(MedicamentoEntity medicamentoEntity) { // permite a criação de uma instância da entidade apartidir
        BeanUtils.copyProperties(medicamentoEntity, this);
    }
}
