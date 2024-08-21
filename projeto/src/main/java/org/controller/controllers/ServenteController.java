package org.controller.controllers;

import org.database.ServenteDB;
import org.model.Servente;

import java.util.List;

public class ServenteController implements ControllerInterface {
    @Override
    public String create(String[] parametros) {
        Servente servente = formatData(parametros);
        if (ServenteDB.getInstance().create(servente)) {
            return "Servente criado com sucesso.";
        }
        return "Servente com este cpf já existe.";
    }

    @Override
    public String get(String[] parametros) {
        Servente servente = ServenteDB.getInstance().find(parametros[2]);
        if (servente != null) {
            return servente.toString();
        }
        return "Servente não encontrado.";
    }

    @Override
    public String list() {
        List<Servente> serventes = ServenteDB.getInstance().list();
        return serventes.toString();
    }

    @Override
    public String delete(String[] parametros) {
        ServenteDB.getInstance().delete(parametros[2]);
        return "Servente removido.";
    }

    @Override
    public String update(String[] parametros) {
        Servente servente = formatData(parametros);
        if (ServenteDB.getInstance().update(servente)) {
            return "Servente editado com sucesso.";
        }
        return "Servente não encontrado";
    }

    private Servente formatData(String[] parametros) {
        Servente servente = new Servente();
        // todo criar objeto
        return servente;
    }
}
