package org.controller.controllers;

public interface ControllerInterface {
    String create(String[] parametros);

    String get(String[] parametros);

    String list();

    String delete(String[] parametros);

    String update(String[] parametros);

    String insertPessoa(String[] parametros) throws Exception;

    String deletePessoa(String[] parametros) throws Exception;
}
