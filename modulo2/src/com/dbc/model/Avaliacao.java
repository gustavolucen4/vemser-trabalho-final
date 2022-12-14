package com.dbc.model;

import com.dbc.interfaces.Impressao;

public class Avaliacao implements Impressao {

    private Usuario usuario;
    private ItemEntretenimento itemEntretenimento;
    private Double nota;
    private String comentario;


    //Construtores
    public Avaliacao() {
    }

    public Avaliacao(Usuario usuario, ItemEntretenimento itemEntretenimento, Double nota, String comentario) {
        this.usuario = usuario;
        this.itemEntretenimento = itemEntretenimento;
        this.nota = nota;
        this.comentario = comentario;
    }

    public Avaliacao(Double nota, String comentario) {
        this.nota = nota;
        this.comentario = comentario;
    }

    //GETTERS AND SETTERS
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ItemEntretenimento getItemEntretenimento() {
        return itemEntretenimento;
    }

    public void setItemEntretenimento(ItemEntretenimento itemEntretenimento) {
        this.itemEntretenimento = itemEntretenimento;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public void imprimir() {
        System.out.println("\u001B[33m" + "-------------------------\n" +
                "Avaliacao{" +
                "Usuario=" + usuario.getEmail() +
                " Usuario id=" + usuario.getId() +
                ", Item =" + itemEntretenimento.getNome() +
                ", Item id=" + itemEntretenimento.getId() +
                ", nota=" + nota +
                ", comentario='" + comentario + '\'' +
                '}' +
                "\n-------------------------" + "\u001B[0m");
    }

}
