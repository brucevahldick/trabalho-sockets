package org.controller.operacao;

import org.controller.controllers.ControllerInterface;

public interface OperacaoInterface {
    String executaOperacao(ControllerInterface controllerInterface, String[] parametros);
}
