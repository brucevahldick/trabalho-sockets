package org.controller.operacao;

import org.controller.controllers.ControllerInterface;
import org.exceptions.ArgumentosInsuficientes;

public class OperacaoDelete implements OperacaoInterface {

    static final int numeroParametros = 3;

    @Override
    public String executaOperacao(ControllerInterface controllerInterface, String[] parametros) throws ArgumentosInsuficientes {
        if (parametros.length < numeroParametros) {
            throw new ArgumentosInsuficientes(numeroParametros);
        }
        return controllerInterface.delete(parametros);
    }
}
