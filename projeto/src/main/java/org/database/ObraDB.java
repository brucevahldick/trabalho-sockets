package org.database;

import org.model.Obra;
import org.model.Pessoa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObraDB {
    private Map<String, Obra> obras = new HashMap<>();

    private static ObraDB obraDB;

    private ObraDB() {
    }

    public static ObraDB getInstance() {
        if (obraDB == null) {
            obraDB = new ObraDB();
        }
        return obraDB;
    }

    public boolean create(Obra obra) {
        if (find(obra.getNome()) != null) {
            return false;
        }
        obras.put(obra.getNome(), obra);
        return true;
    }

    public boolean update(Obra obra) {
        Obra obraMapeada = find(obra.getNome());
        if (obraMapeada == null) {
            return false;
        }
        delete(obraMapeada.getNome());
        obras.put(obra.getNome(), obra);
        return true;
    }

    public Obra find(String nome) {
        return obras.get(nome);
    }

    public void delete(String nome) {
        obras.remove(nome);
    }

    public List<Obra> list() {
        return (List<Obra>) obras.values();
    }

    public void addPessoaToObra(String nome, Pessoa pessoa) {
        Obra obra = find(nome);
        obra.addPessoa(pessoa);
    }

    public void removePessoaFromObra(String nome, Pessoa pessoa) {
        Obra obra = find(nome);
        obra.removePessoa(pessoa);
    }
}
