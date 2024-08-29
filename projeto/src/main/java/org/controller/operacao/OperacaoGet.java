package org.controller.operacao;

import org.controller.controllers.ControllerInterface;
import org.exceptions.ArgumentosInsuficientesException;

public class OperacaoGet implements OperacaoInterface {

    static final int numeroParametros = 3;

    @Override
    public String executaOperacao(ControllerInterface controllerInterface, String[] parametros) throws ArgumentosInsuficientesException {
        if (parametros.length < numeroParametros) {
            throw new ArgumentosInsuficientesException(numeroParametros);
        }
        return controllerInterface.get(parametros);
    }
}
