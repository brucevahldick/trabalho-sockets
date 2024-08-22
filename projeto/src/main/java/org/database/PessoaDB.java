package org.database;

import org.model.Pessoa;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PessoaDB {
    private Map<String, Pessoa> pessoas = new HashMap<>();

    private static PessoaDB pessoaDB;

    private PessoaDB() {
    }

    public static PessoaDB getInstance() {
        if (pessoaDB == null) {
            pessoaDB = new PessoaDB();
        }
        return pessoaDB;
    }

    public boolean create(Pessoa pessoa) {
        if (find(pessoa.getCpf()) != null) {
            return false;
        }
        pessoas.put(pessoa.getCpf(), pessoa);
        return true;
    }

    public boolean update(Pessoa pessoa) {
        Pessoa pessoaMapeada = find(pessoa.getCpf());
        if ((pessoaMapeada == null) || (pessoaMapeada.getClass() != pessoa.getClass())) {
            return false;
        }
        delete(pessoaMapeada.getCpf());
        pessoas.put(pessoa.getCpf(), pessoa);
        return true;
    }

    public Pessoa find(String cpf) {
        return pessoas.get(cpf);
    }

    public boolean delete(String cpf) {
        return pessoas.remove(cpf) != null;
    }

    public Collection<Pessoa> list() {
        return pessoas.values();
    }
}
