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

    public void create(Pedreiro pedreiro) {
        pedreiros.put(pedreiro.getCpf(), pedreiro);
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
