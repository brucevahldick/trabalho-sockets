package org.controller.operacao;

import org.controller.controllers.ControllerInterface;

public class OperacaoCreate implements OperacaoInterface {
    @Override
    public String executaOperacao(ControllerInterface controllerInterface, String[] parametros) {
        return controllerInterface.create(parametros);
    }
}
