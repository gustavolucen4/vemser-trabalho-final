package com.dbc.enums;

public enum TipoUsuario {
    CLIENTE("cliente"),
    ADIMINISTRADOR("adiministrador");

    private String descricao;

    TipoUsuario(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }
}
