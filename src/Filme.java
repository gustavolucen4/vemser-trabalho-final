import java.util.Date;
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

    public Filme(String nome, String genero, String subgenero, String duracao) {
        super(nome, genero, subgenero);
        this.duracao = duracao;
    }

    public Filme(String nome, String genero, String subgenero, String sinopse, Date anoLancamento, int classificacao, double critica, String plataforma, List<Avaliacao> avaliacoes, String duracao) {
        super(nome, genero, subgenero, sinopse, anoLancamento, classificacao, critica, plataforma, avaliacoes);
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
