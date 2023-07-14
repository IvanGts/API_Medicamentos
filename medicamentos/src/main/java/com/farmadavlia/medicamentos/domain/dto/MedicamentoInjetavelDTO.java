package com.farmadavlia.medicamentos.domain.dto;

import com.farmadavlia.medicamentos.domain.enums.TipoAplicacao;
import com.farmadavlia.medicamentos.domain.models.MedicamentoEntity;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class MedicamentoInjetavelDTO extends MedicamentoDTO {

    @OneToOne
    private String tipoAplicacao;

}