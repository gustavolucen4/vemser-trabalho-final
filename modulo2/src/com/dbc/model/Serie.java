package com.dbc.model;

public class Serie extends ItemEntretenimento {
    private Integer temporadas;
    private Integer episodios;

    //Construtores
    public Serie() {
        tipo = "serie";
    }

    public Serie(Integer temporadas, Integer episodios) {
        this.temporadas = temporadas;
        this.episodios = episodios;
        tipo = "serie";
    }

    public Serie(Integer id, String nome, String genero, Integer temporadas, Integer episodios) {
        super(id, nome, genero);
        this.temporadas = temporadas;
        this.episodios = episodios;
        tipo = "serie";
    }

    public Serie(Integer id, String nome, String genero, String sinopse, String anoLancamento, Integer classificacao,String plataforma,Integer temporadas, Integer episodios) {
        super(id, nome, genero, sinopse, anoLancamento, classificacao, plataforma);
        this.temporadas = temporadas;
        this.episodios = episodios;
        tipo = "serie";
    }

    //GETTERS AND SETTERS
    public Integer getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(Integer temporadas) {
        this.temporadas = temporadas;
    }

    public Integer getEpisodios() {
        return episodios;
    }

    public void setEpisodios(Integer episodios) {
        this.episodios = episodios;
    }


}
