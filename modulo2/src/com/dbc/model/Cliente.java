package com.dbc.model;

import com.dbc.enums.TipoUsuario;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {
    private List<ItemEntretenimento> assistidos;
    private List<Avaliacao> avaliacoes;


    //Construtores
    public Cliente() {
        super();
        tipoUsuario = TipoUsuario.CLIENTE;
    }

    public Cliente(Integer id, String nome, int idade, String email, String senha) {
        super(id, nome, idade, email, senha);
        tipoUsuario = TipoUsuario.CLIENTE;
        this.assistidos = new ArrayList<>();
        this.avaliacoes = new ArrayList<>();
    }


    //GETTERS AND SETTERS
    public List<ItemEntretenimento> getAssistidos() {
        return assistidos;
    }

    public void setAssistidos(List<ItemEntretenimento> assistidos) {
        this.assistidos = assistidos;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }
}
