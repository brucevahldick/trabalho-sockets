package org.controller.controllers;

import org.database.PedreiroDB;
import org.model.Pedreiro;

import java.util.List;

public class PedreiroController implements ControllerInterface {
    @Override
    public String create(String[] parametros) {
        Pedreiro pedreiro = formatData(parametros);
        if (PedreiroDB.getInstance().create(pedreiro)) {
            return "Pedreiro criado com sucesso.";
        }
        return "Pedreiro com este cpf já existe.";
    }

    @Override
    public String get(String[] parametros) {
        Pedreiro pedreiro = PedreiroDB.getInstance().find(parametros[2]);
        if (pedreiro != null) {
            return pedreiro.toString();
        }
        return "Pedreiro não encontrado.";
    }

    @Override
    public String list() {
        List<Pedreiro> pedreiros = PedreiroDB.getInstance().list();
        return pedreiros.toString();
    }

    @Override
    public String delete(String[] parametros) {
        PedreiroDB.getInstance().delete(parametros[2]);
        return "Pedreiro removido.";
    }

    @Override
    public String update(String[] parametros) {
        Pedreiro pedreiro = formatData(parametros);
        if (PedreiroDB.getInstance().update(pedreiro)) {
            return "Pedreiro editado com sucesso.";
        }
        return "Pedreiro não encontrado.";
    }

    private Pedreiro formatData(String[] parametros) {
        Pedreiro pedreiro = new Pedreiro();
        // todo criar objeto
        return pedreiro;
    }
}
