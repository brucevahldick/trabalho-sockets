package org.controller;

import org.exceptions.TipoNaoSuportadoException;

public class Facade {

    private ControllerInterface controllerInterface;

    public Facade(String tipo) throws Exception {
        controllerInterface = (new ControllerFactory()).getController(tipo);
        if (controllerInterface == null) {
            throw new TipoNaoSuportadoException();
        }
    }
}
