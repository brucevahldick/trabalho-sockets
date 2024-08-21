package org.controller.enums;

public enum Tipo {
    OBRA("OBRA"),
    SERVENTE("SERVENTE"),
    PEDREIRO("PEDREIRO");

    private final String valor;

    Tipo(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
