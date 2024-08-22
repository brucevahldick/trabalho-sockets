package org.controller.controllers;

import org.database.PessoaDB;
import org.exceptions.OperacaoNaoSuportadaException;
import org.model.Pedreiro;
import org.model.Pessoa;

import java.util.Collection;

public class PedreiroController implements ControllerInterface {
    @Override
    public String create(String[] parametros) {
        Pedreiro pedreiro = formatData(parametros);
        if (PessoaDB.getInstance().create(pedreiro)) {
            return "Pedreiro criado.";
        }
        return "Pessoa com este cpf já existe.";
    }

    @Override
    public String get(String[] parametros) {
        Pessoa pessoa = PessoaDB.getInstance().find(parametros[2]);
        if (pessoa instanceof Pedreiro) {
            return pessoa.toString();
        }
        return "Pedreiro não encontrado.";
    }

    @Override
    public String list() {
        Collection<Pessoa> pessoas = PessoaDB.getInstance().list();
        StringBuilder mensagemRetorno = new StringBuilder();
        for (Pessoa pessoa : pessoas) {
            if (pessoa instanceof Pedreiro) {
                mensagemRetorno.append(pessoa);
            }
        }
        return mensagemRetorno.toString();
    }

    @Override
    public String delete(String[] parametros) {
        Pessoa pessoa = PessoaDB.getInstance().find(parametros[2]);
        if ((pessoa instanceof Pedreiro) && (PessoaDB.getInstance().delete(parametros[2]))) {
            return "Pedreiro removido.";
        }
        return "Pedreiro não encontrado.";
    }

    @Override
    public String update(String[] parametros) {
        Pedreiro pedreiro = formatData(parametros);
        if (PessoaDB.getInstance().update(pedreiro)) {
            return "Pedreiro atualizado.";
        }
        return "Pedreiro não encontrado.";
    }

    @Override
    public String insertPessoa(String[] parametros) throws OperacaoNaoSuportadaException {
        throw new OperacaoNaoSuportadaException();
    }

    @Override
    public String deletePessoa(String[] parametros) throws OperacaoNaoSuportadaException {
        throw new OperacaoNaoSuportadaException();
    }

    private Pedreiro formatData(String[] parametros) {
        Pedreiro pedreiro = new Pedreiro();
        pedreiro.setCpf(parametros[2]);
        pedreiro.setNome(parametros[3]);
        pedreiro.setEndereco(parametros[4]);
        pedreiro.setCargo(parametros.length > 5 ? parametros[5] : null);
        return pedreiro;
    }
}
