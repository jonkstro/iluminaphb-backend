package com.iluminaphb.main.models.enums;

public enum TipoUsuario {
    
    ADMIN("admin"),
    USER("user");

    String tipo;

    TipoUsuario(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

}
