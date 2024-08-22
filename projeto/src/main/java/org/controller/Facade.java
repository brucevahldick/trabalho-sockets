package org.controller;

import org.controller.controllers.ControllerInterface;
import org.controller.operacao.OperacaoInterface;
import org.exceptions.OperacaoNaoSuportadaException;
import org.exceptions.TipoNaoSuportadoException;

public class Facade {

    private ControllerInterface controllerInterface;
    private Factory factory;

    private Factory getFactory() {
        if (factory == null) {
            factory = new Factory();
        }
        return factory;
    }

    public Facade(String tipo) throws Exception {
        controllerInterface = getFactory().getController(tipo);
        if (controllerInterface == null) {
            throw new TipoNaoSuportadoException();
        }
    }

    public String executarOperacao(String operacao, String[] parametros) throws Exception {
        OperacaoInterface operacaoInterface = getFactory().getOperacao(operacao);
        if (operacaoInterface == null) {
            throw new OperacaoNaoSuportadaException();
        }
        return operacaoInterface.executaOperacao(controllerInterface, parametros);
    }
}
