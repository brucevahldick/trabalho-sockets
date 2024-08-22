package org.controller.operacao;

import org.controller.controllers.ControllerInterface;

public class OperacaoRemovePessoa implements OperacaoInterface{
    @Override
    public String executaOperacao(ControllerInterface controllerInterface, String[] parametros) throws Exception {
        return controllerInterface.deletePessoa(parametros);
    }
}
