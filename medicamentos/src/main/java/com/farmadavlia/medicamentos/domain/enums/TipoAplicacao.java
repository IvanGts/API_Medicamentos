package com.farmadavlia.medicamentos.domain.enums;


import lombok.Getter;

@Getter
public enum TipoAplicacao {
    ENDOVENOSA("Endovenosa"),
    INTRADERMICA("Intrad\u00E9rmica"),
    INTRAMUSCULAR("Intramuscular"),
    SUBCUTANEA("Subcut\u00E2nea");

    private final String descricao;

    TipoAplicacao(String descricao) {
        this.descricao = descricao;
    }
}
