package org.model;

import java.util.ArrayList;

public class Obra {
    private int valor;
    private int tamanho;
    private String nome;
    private ArrayList<Pessoa> pessoas = new ArrayList<>();

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Pessoa> getPessoas() {
        return pessoas;
    }

    public void addPessoa(Pessoa pessoa) {
        pessoas.add(pessoa);
    }

    public void removePessoa(Pessoa pessoa) {
        pessoas.remove(pessoa);
    }
}
