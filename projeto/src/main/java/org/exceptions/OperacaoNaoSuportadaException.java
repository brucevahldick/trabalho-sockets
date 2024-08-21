package org.exceptions;

public class OperacaoNaoSuportadaException extends Exception {
    public OperacaoNaoSuportadaException() {
        super("Operação não suportada pelo servidor.");
    }
}
