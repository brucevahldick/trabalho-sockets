package org.controller.operacao;

import org.controller.controllers.ControllerInterface;
import org.exceptions.ArgumentosInsuficientes;

public class OperacaoAddPessoa implements OperacaoInterface {

    static final int numeroParametros = 4;

    @Override
    public String executaOperacao(ControllerInterface controllerInterface, String[] parametros) throws Exception {
        if (parametros.length < numeroParametros) {
            throw new ArgumentosInsuficientes(numeroParametros);
        }
        return controllerInterface.insertPessoa(parametros);
    }
}
