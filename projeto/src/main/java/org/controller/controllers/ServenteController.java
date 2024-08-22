package org.controller.controllers;

import org.database.PessoaDB;
import org.exceptions.OperacaoNaoSuportadaException;
import org.model.Pessoa;
import org.model.Servente;

import java.util.List;

public class ServenteController implements ControllerInterface {
    @Override
    public String create(String[] parametros) {
        Servente servente = formatData(parametros);
        if (PessoaDB.getInstance().create(servente)) {
            return "Servente criado.";
        }
        return "Pessoa com este cpf já existe.";
    }

    @Override
    public String get(String[] parametros) {
        Pessoa pessoa = PessoaDB.getInstance().find(parametros[2]);
        if (pessoa instanceof Servente) {
            return pessoa.toString();
        }
        return "Servente não encontrado.";
    }

    @Override
    public String list() {
        List<Pessoa> pessoas = PessoaDB.getInstance().list();
        StringBuilder mensagemRetorno = new StringBuilder();
        for (Pessoa pessoa : pessoas) {
            if (pessoa instanceof Servente) {
                mensagemRetorno.append(pessoa);
            }
        }
        return mensagemRetorno.toString();
    }

    @Override
    public String delete(String[] parametros) {
        Pessoa pessoa = PessoaDB.getInstance().find(parametros[2]);
        if ((pessoa instanceof Servente) && (PessoaDB.getInstance().delete(parametros[2]))) {
            return "Servente removido.";
        }
        return "Servente não encontrado.";
    }

    @Override
    public String update(String[] parametros) {
        Servente servente = formatData(parametros);
        if (PessoaDB.getInstance().update(servente)) {
            return "Servente atualizado.";
        }
        return "Servente não encontrado";
    }

    @Override
    public String insertPessoa(String[] parametros) throws OperacaoNaoSuportadaException {
        throw new OperacaoNaoSuportadaException();
    }

    @Override
    public String deletePessoa(String[] parametros) throws OperacaoNaoSuportadaException {
        throw new OperacaoNaoSuportadaException();
    }

    private Servente formatData(String[] parametros) {
        Servente servente = new Servente();
        servente.setCpf(parametros[2]);
        servente.setNome(parametros[3]);
        servente.setEndereco(parametros[4]);
        servente.setFuncao(parametros[5]);
        return servente;
    }
}
