package entidades;

import java.util.List;

public class Filme extends ItemEntretenimento {
    private String duracao;

    //Construtores
    public Filme() {
        this.id=ItemEntretenimento.contadorId++;
    }

    public Filme(String duracao) {
        this.id=ItemEntretenimento.contadorId++;
        this.duracao = duracao;
    }

    public Filme(String nome, String genero, String duracao) {
        super(nome, genero);
        this.duracao = duracao;
    }

    public Filme(String nome, String genero, String sinopse, String anoLancamento, int classificacao, String plataforma, String duracao) {
        super(nome, genero, sinopse, anoLancamento, classificacao, plataforma);
        this.duracao = duracao;
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
