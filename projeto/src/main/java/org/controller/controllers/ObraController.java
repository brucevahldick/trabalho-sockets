package org.controller.controllers;

import org.database.ObraDB;
import org.model.Obra;

import java.util.List;

public class ObraController implements ControllerInterface {
    @Override
    public String create(String[] parametros) {
        Obra obra = formatData(parametros);
        if (ObraDB.getInstance().create(obra)) {
            return "Obra criada com sucesso.";
        }
        return "Obra com este nome já existe.";
    }

    @Override
    public String get(String[] parametros) {
        Obra obra = ObraDB.getInstance().find(parametros[2]);
        if (obra != null) {
            return obra.toString();
        }
        return "Obra não encontrada.";
    }

    @Override
    public String list() {
        List<Obra> obras = ObraDB.getInstance().list();
        return obras.toString();
    }

    @Override
    public String delete(String[] parametros) {
        ObraDB.getInstance().delete(parametros[2]);
        return "Obra removida.";
    }

    @Override
    public String update(String[] parametros) {
        Obra obra = formatData(parametros);
        if (ObraDB.getInstance().update(obra)) {
            return "Obra editada com sucesso.";
        }
        return "Obra não encontrada.";
    }

    private Obra formatData(String[] parametros) {
        Obra obra = new Obra();
        // todo criar objeto
        return obra;
    }
}
