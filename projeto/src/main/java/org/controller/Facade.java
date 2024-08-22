package org.controller;

import org.controller.controllers.ControllerInterface;
import org.controller.operacao.OperacaoInterface;
import org.exceptions.OperacaoNaoSuportadaException;
import org.exceptions.TipoNaoSuportadoException;

public class Facade {

    private ControllerInterface controllerInterface;
    private String[] parametros;
    private Factory factory;

    private Factory getFactory() {
        if (factory == null) {
            factory = new Factory();
        }
        return factory;
    }

    public Facade(String[] parametros) throws Exception {
        this.parametros = parametros;
    }

    public String executarOperacao() {
        try {
            controllerInterface = getFactory().getController(parametros[1]);
            if (controllerInterface == null) {
                throw new TipoNaoSuportadoException();
            }
            OperacaoInterface operacaoInterface = getFactory().getOperacao(parametros[0]);
            if (operacaoInterface == null) {
                throw new OperacaoNaoSuportadaException();
            }
            return operacaoInterface.executaOperacao(controllerInterface, parametros);
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
