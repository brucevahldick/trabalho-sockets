package org.database;

import org.model.Pedreiro;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PedreiroDB {
    private Map<String, Pedreiro> pedreiros = new HashMap<>();

    private static PedreiroDB pedreiroDB;

    private PedreiroDB() {
    }

    public static PedreiroDB getInstance() {
        if (pedreiroDB == null) {
            pedreiroDB = new PedreiroDB();
        }
        return pedreiroDB;
    }

    public boolean create(Pedreiro pedreiro) {
        if (find(pedreiro.getCpf()) != null) {
            return false;
        }
        pedreiros.put(pedreiro.getCpf(), pedreiro);
        return true;
    }

    public boolean update(Pedreiro pedreiro) {
        Pedreiro pedreiroMapeado = find(pedreiro.getCpf());
        if (pedreiroMapeado == null) {
            return false;
        }
        delete(pedreiroMapeado.getCpf());
        pedreiros.put(pedreiro.getCpf(), pedreiro);
        return true;
    }

    public Pedreiro find(String cpf) {
        return pedreiros.get(cpf);
    }

    public void delete(String cpf) {
        pedreiros.remove(cpf);
    }

    public List<Pedreiro> list() {
        return (List<Pedreiro>) pedreiros.values();
    }
}
