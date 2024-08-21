package org.controller.operacao;

import org.controller.controllers.ControllerInterface;

public class OperacaoDelete implements OperacaoInterface {
    @Override
    public String executaOperacao(ControllerInterface controllerInterface, String[] parametros) {
        return controllerInterface.delete(parametros);
    }
}
