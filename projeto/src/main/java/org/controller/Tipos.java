package org.controller;

public enum Tipos {
    OBRA("OBRA"),
    SERVENTE("SERVENTE"),
    PEDREIRO("PEDREIRO");

    private final String valor;

    Tipos(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
