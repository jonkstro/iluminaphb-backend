package com.iluminaphb.main.models.enums;

public enum TipoSolicitacao {

    LAMPADA_QUEIMADA("Lâmpada queimada"),
    LAMPADA_PISCANDO("Lâmpada piscando"),
    INSTALAR_LAMPADA("Instalar luminaria");

    String tipo;

    TipoSolicitacao(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

}
