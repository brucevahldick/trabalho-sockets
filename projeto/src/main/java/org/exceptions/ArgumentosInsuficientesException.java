package org.exceptions;

public class ArgumentosInsuficientesException extends Exception {
    public ArgumentosInsuficientesException(Integer numeroArgumentos) {
        super("Argumentos Insuficientes. Quantidade necessaria para a operação: " + numeroArgumentos);
    }
}
