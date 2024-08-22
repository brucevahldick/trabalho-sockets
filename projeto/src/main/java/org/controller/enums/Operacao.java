package org.controller.enums;

public enum Operacao {
    INSERT("INSERT"),
    DELETE("DELETE"),
    UPDATE("UPDATE"),
    GET("GET"),
    LIST("LIST"),
    INSERTP("INSERTP"),
    DELETEP("DELETEP");

    private final String valor;

    Operacao(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
