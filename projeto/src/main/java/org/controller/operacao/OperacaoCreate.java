package org.controller.operacao;

import org.controller.controllers.ControllerInterface;
import org.exceptions.ArgumentosInsuficientesException;

public class OperacaoCreate implements OperacaoInterface {

    static final int numeroParametros = 5;

    @Override
    public String executaOperacao(ControllerInterface controllerInterface, String[] parametros) throws ArgumentosInsuficientesException {
        if (parametros.length < numeroParametros) {
            throw new ArgumentosInsuficientesException(numeroParametros);
        }
        return controllerInterface.create(parametros);
    }
}
