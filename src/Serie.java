import java.util.Date;
import java.util.List;

public class Serie extends ItemEntretenimento {
    private int temporadas;
    private int episodios;

    //Construtores
    public Serie() {
        this.id=ItemEntretenimento.contadorId++;
    }

    public Serie(int temporadas, int episodios) {
        this.id=ItemEntretenimento.contadorId++;
        this.temporadas = temporadas;
        this.episodios = episodios;
    }

    public Serie(String nome, String genero, int temporadas, int episodios) {
        super(nome, genero);
        this.temporadas = temporadas;
        this.episodios = episodios;
    }

    public Serie(String nome, String genero, String sinopse, Date anoLancamento, int classificacao, double critica, String plataforma, List<Avaliacao> avaliacoes, int temporadas, int episodios) {
        super(nome, genero, sinopse, anoLancamento, classificacao, critica, plataforma, avaliacoes);
        this.temporadas = temporadas;
        this.episodios = episodios;
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
