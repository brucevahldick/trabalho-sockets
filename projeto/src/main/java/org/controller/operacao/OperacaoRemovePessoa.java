package org.controller.operacao;

import org.controller.controllers.ControllerInterface;
import org.exceptions.ArgumentosInsuficientesException;

public class OperacaoRemovePessoa implements OperacaoInterface {

    static final int numeroParametros = 4;

    @Override
    public String executaOperacao(ControllerInterface controllerInterface, String[] parametros) throws Exception {
        if (parametros.length < numeroParametros) {
            throw new ArgumentosInsuficientesException(numeroParametros);
        }
        return controllerInterface.deletePessoa(parametros);
    }
}
