package org.controller.operacao;

import org.controller.controllers.ControllerInterface;

public class OperacaoList implements OperacaoInterface {
    @Override
    public String executaOperacao(ControllerInterface controllerInterface, String[] parametros) {
        return controllerInterface.list();
    }
}
