package org.controller;

import java.util.HashMap;
import java.util.Map;

public class ControllerFactory {

    private Map<Tipos, ControllerInterface> controllerInterfaceMap = new HashMap<>();

    public ControllerFactory() {
        controllerInterfaceMap.put(Tipos.OBRA, new ObraController());
        controllerInterfaceMap.put(Tipos.PEDREIRO, new PedreiroController());
        controllerInterfaceMap.put(Tipos.SERVENTE, new ServenteController());
    }

    public ControllerInterface getController(String tipo) {
        try {
            return controllerInterfaceMap.get(Tipos.valueOf(tipo));
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
