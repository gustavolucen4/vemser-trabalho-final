package com.dbc.model;

public class Filme extends ItemEntretenimento {
    private String duracao;

    //Construtores
    public Filme() {
        this.id=ItemEntretenimento.contadorId++;
        tipo = "filme";
    }

    public Filme(String duracao) {
        this.id=ItemEntretenimento.contadorId++;
        this.duracao = duracao;
        tipo = "filme";
    }

    public Filme(String nome, String genero, String duracao) {
        super(nome, genero);
        this.duracao = duracao;
        tipo = "filme";
    }

    public Filme(String nome, String genero, String sinopse, String anoLancamento, int classificacao, String plataforma, String duracao) {
        super(nome, genero, sinopse, anoLancamento, classificacao, plataforma);
        this.duracao = duracao;
        tipo = "filme";
    }


    public boolean indicar(){
        return true;
    }

    //GETTER AND SETTER
    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

}
