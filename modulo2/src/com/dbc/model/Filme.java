package com.dbc.model;

public class Filme extends ItemEntretenimento {
    private String duracao;

    //Construtores
    public Filme() {
        tipo = "filme";
    }

    public Filme(String duracao) {
        this.duracao = duracao;
        tipo = "filme";
    }

    public Filme(Integer id, String nome, String genero, String duracao) {
        super(id, nome, genero);
        this.duracao = duracao;
        tipo = "filme";
    }

    public Filme(Integer id, String nome, String genero, String sinopse, String anoLancamento, int classificacao, String plataforma, String duracao) {
        super(id, nome, genero, sinopse, anoLancamento, classificacao, plataforma);
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
