package com.farmadavlia.medicamentos.domain.dto;

import com.farmadavlia.medicamentos.domain.enums.TipoAplicacao;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InformacoesInjetaveisDTO {
    private Long id;
    private TipoAplicacao tipoAplicacao;
}
