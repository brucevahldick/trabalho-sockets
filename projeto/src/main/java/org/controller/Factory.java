package org.controller;

import org.controller.controllers.ControllerInterface;
import org.controller.controllers.ObraController;
import org.controller.controllers.PedreiroController;
import org.controller.controllers.ServenteController;
import org.controller.enums.Operacao;
import org.controller.enums.Tipo;
import org.controller.operacao.*;

import java.util.HashMap;
import java.util.Map;

public class Factory {

    private Map<Tipo, ControllerInterface> controllerInterfaceMap = new HashMap<>();
    private Map<Operacao, OperacaoInterface> operacaoInterfaceMap = new HashMap<>();

    public Factory() {
        controllerInterfaceMap.put(Tipo.OBRA, new ObraController());
        controllerInterfaceMap.put(Tipo.PEDREIRO, new PedreiroController());
        controllerInterfaceMap.put(Tipo.SERVENTE, new ServenteController());

        operacaoInterfaceMap.put(Operacao.INSERT, new OperacaoCreate());
        operacaoInterfaceMap.put(Operacao.UPDATE, new OperacaoUpdate());
        operacaoInterfaceMap.put(Operacao.GET, new OperacaoGet());
        operacaoInterfaceMap.put(Operacao.DELETE, new OperacaoDelete());
        operacaoInterfaceMap.put(Operacao.LIST, new OperacaoList());
    }

    public ControllerInterface getController(String tipo) {
        try {
            return controllerInterfaceMap.get(Tipo.valueOf(tipo));
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public OperacaoInterface getOperacao(String operacao) {
        try {
            return operacaoInterfaceMap.get(Operacao.valueOf(operacao));
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
