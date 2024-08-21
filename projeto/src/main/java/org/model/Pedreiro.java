package org.model;

public class Pedreiro extends Pessoa {
    private String cargo;

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return super.toString() + "Pedreiro{" +
                "cargo='" + cargo + '\'' +
                '}';
    }
}
