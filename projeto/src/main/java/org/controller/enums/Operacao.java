package org.controller.enums;

public enum Operacao {
    INSERT("INSERT"),
    DELETE("DELETE"),
    UPDATE("UPDATE"),
    GET("GET"),
    LIST("LIST");

    private final String valor;

    Operacao(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
