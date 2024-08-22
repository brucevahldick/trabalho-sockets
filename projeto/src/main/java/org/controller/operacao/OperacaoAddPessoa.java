package org.controller.operacao;

import org.controller.controllers.ControllerInterface;

public class OperacaoAddPessoa implements OperacaoInterface{
    @Override
    public String executaOperacao(ControllerInterface controllerInterface, String[] parametros) throws Exception {
        return controllerInterface.insertPessoa(parametros);
    }
}
