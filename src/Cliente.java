import java.util.List;

public class Cliente extends Usuario {
    private List <ItemEntretenimento> assistidos;
    private List<Avaliacao> avaliacoes;


    //Construtores
    public Cliente() {
    }

    public Cliente(String nome, int idade, String email, String idioma, String senha, List<ItemEntretenimento> assistidos, List<Avaliacao> avaliacoes) {
        super(nome, idade, email, idioma, senha);
        this.assistidos = assistidos;
        this.avaliacoes = avaliacoes;
    }

    public Cliente(List<ItemEntretenimento> assistidos, List<Avaliacao> avaliacoes) {
        this.assistidos = assistidos;
        this.avaliacoes = avaliacoes;
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
