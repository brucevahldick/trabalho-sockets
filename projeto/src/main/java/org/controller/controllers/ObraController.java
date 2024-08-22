package org.controller.controllers;

import org.database.ObraDB;
import org.database.PessoaDB;
import org.model.Obra;
import org.model.Pessoa;

import java.util.List;

public class ObraController implements ControllerInterface {
    @Override
    public String create(String[] parametros) {
        Obra obra = formatData(parametros);
        if (ObraDB.getInstance().create(obra)) {
            return "Obra criada.";
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
        if (ObraDB.getInstance().delete(parametros[2])) {
            return "Obra removida.";
        }
        return "Obra não encontrada.";
    }

    @Override
    public String update(String[] parametros) {
        Obra obra = formatData(parametros);
        if (ObraDB.getInstance().update(obra)) {
            return "Obra atualizada.";
        }
        return "Obra não encontrada.";
    }

    @Override
    public String insertPessoa(String[] parametros) {
        Pessoa pessoa = PessoaDB.getInstance().find(parametros[3]);
        if (pessoa == null) {
            return "Pessoa não encontrada.";
        }
        if (ObraDB.getInstance().addPessoaToObra(parametros[2], pessoa)) {
            return "Pessoa adicionada a obra.";
        }
        return "Obra não encontrada.";
    }

    @Override
    public String deletePessoa(String[] parametros) {
        Pessoa pessoa = PessoaDB.getInstance().find(parametros[3]);
        if (pessoa == null) {
            return "Pessoa não encontrada.";
        }
        if (ObraDB.getInstance().removePessoaFromObra(parametros[2], pessoa)) {
            return "Pessoa removida da obra.";
        }
        return "Obra não encontrada.";
    }

    private Obra formatData(String[] parametros) {
        Obra obra = new Obra();
        obra.setNome(parametros[2]);
        obra.setTamanho(Integer.parseInt(parametros[3]));
        obra.setValor(Integer.parseInt(parametros[4]));
        return obra;
    }
}
