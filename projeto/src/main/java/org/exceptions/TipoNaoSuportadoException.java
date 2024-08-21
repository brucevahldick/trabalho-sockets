package org.exceptions;

public class TipoNaoSuportadoException extends Exception {
    public TipoNaoSuportadoException() {
        super("Tipo não suportado pelo servidor.");
    }
}
