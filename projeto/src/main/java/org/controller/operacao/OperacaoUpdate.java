package org.controller.operacao;

import org.controller.controllers.ControllerInterface;

public class OperacaoUpdate implements OperacaoInterface {
    @Override
    public String executaOperacao(ControllerInterface controllerInterface, String[] parametros) {
        return controllerInterface.update(parametros);
    }
}
