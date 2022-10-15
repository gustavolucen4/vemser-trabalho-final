package com.dbc.model;

import com.dbc.enums.TipoUsuario;
import com.dbc.interfaces.Impressao;

public  class Usuario implements Impressao {

    private Integer id;
    private String nome;
    private Integer idade;
    private String email;
    private String senha;

    protected TipoUsuario tipoUsuario;

    //Construtores
    public Usuario(Integer id, String nome, int idade, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.senha = senha;
    }

    //GETTERS AND SETTERS

    public Usuario() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    //GETTERS AND SETTERS
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoUsuario getTipoUsuario(){
        return this.tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public void imprimir() {
        System.out.println("--------------"
                + "\nNome: "+getNome()
                + "\nIdade: "+getIdade()
                + "\nEmail: "+getEmail()
                + "\nTipo de usuário: "+this.tipoUsuario.getDescricao()
                + "\n--------------");
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", tipoUsuario=" + tipoUsuario +
                '}';
    }
}
