package org.database;

import org.model.Servente;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServenteDB {
    private Map<String, Servente> serventes = new HashMap<>();

    private static ServenteDB serventeDB;

    private ServenteDB() {
    }

    public static ServenteDB getInstance() {
        if (serventeDB == null) {
            serventeDB = new ServenteDB();
        }
        return serventeDB;
    }

    public void create(Servente servente) {
        serventes.put(servente.getCpf(), servente);
    }

    public Servente find(String cpf) {
        return serventes.get(cpf);
    }

    public void delete(String cpf) {
        serventes.remove(cpf);
    }

    public List<Servente> list() {
        return (List<Servente>) serventes.values();
    }
}
