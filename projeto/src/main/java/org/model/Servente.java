package org.model;

public class Servente extends Pessoa {
    private String funcao;

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @Override
    public String toString() {
        return super.toString() + "Servente{" +
                "funcao='" + funcao + '\'' +
                '}';
    }
}
