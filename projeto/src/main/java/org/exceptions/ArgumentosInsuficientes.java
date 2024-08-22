package org.exceptions;

public class ArgumentosInsuficientes extends Exception {
    public ArgumentosInsuficientes(Integer numeroArgumentos) {
        super("Argumentos Insuficientes. Quantidade necessaria para a operação: " + numeroArgumentos);
    }
}
