package com.farmadavlia.medicamentos.domain.enums;


import lombok.Getter;

@Getter
public enum TipoAplicacao {
    ENDOVENOSA("Endovenosa"),
    INTRADERMICA("Intrad\u00E9rmica"),
    INTRAMUSCULAR("Intramuscular"),
    SUBCUTANEA("Subcut\u00E2nea");

    private final String descricaoAplicacao;

    TipoAplicacao(String descricao) {
        this.descricaoAplicacao = descricao;
    }

    public String getDescricaoAplicacao(){
        return descricaoAplicacao;
    }

}
