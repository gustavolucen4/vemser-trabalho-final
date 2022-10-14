package entidades;

import java.util.List;

public class Serie extends ItemEntretenimento {
    private int temporadas;
    private int episodios;

    //Construtores
    public Serie() {
        this.id=ItemEntretenimento.contadorId++;
        tipo = "serie";
    }

    public Serie(int temporadas, int episodios) {
        this.id=ItemEntretenimento.contadorId++;
        this.temporadas = temporadas;
        this.episodios = episodios;
        tipo = "serie";
    }

    public Serie(String nome, String genero, int temporadas, int episodios) {
        super(nome, genero);
        this.temporadas = temporadas;
        this.episodios = episodios;
        tipo = "serie";
    }

    public Serie(String nome, String genero, String sinopse, String anoLancamento, int classificacao,String plataforma,int temporadas, int episodios) {
        super(nome, genero, sinopse, anoLancamento, classificacao, plataforma);
        this.temporadas = temporadas;
        this.episodios = episodios;
        tipo = "serie";
    }

    //GETTERS AND SETTERS
    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public int getEpisodios() {
        return episodios;
    }

    public void setEpisodios(int episodios) {
        this.episodios = episodios;
    }


}
