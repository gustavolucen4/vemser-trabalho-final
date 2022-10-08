import java.util.Date;
import java.util.List;

public class ItemEntretenimento implements Impressao {

    static Integer contadorId=0;
    protected Integer id;
    private String nome;
    private String genero;
    private String sinopse;
    private Date anoLancamento;
    private Integer classificacao;
    private String plataforma;
    private List <Avaliacao> avaliacoes;


    //Construtores
    public ItemEntretenimento() {
        id=contadorId++;
    }

    public ItemEntretenimento(String nome, String genero) {
        this.id=contadorId++;
        this.nome = nome;
        this.genero = genero;
    }

    public ItemEntretenimento(String nome, String genero, String sinopse, Date anoLancamento, Integer classificacao, double critica, String plataforma, List<Avaliacao> avaliacoes) {
        this.id=contadorId++;
        this.nome = nome;
        this.genero = genero;
        this.sinopse = sinopse;
        this.anoLancamento = anoLancamento;
        this.classificacao = classificacao;
        this.plataforma = plataforma;
        this.avaliacoes = avaliacoes;
    }

    //GETTERS AND SETTERS

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public Date getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Date anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public Integer getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Integer classificacao) {
        this.classificacao = classificacao;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }
    public void adicionarAvaliacao(Avaliacao avaliacao){
        this.avaliacoes.add(avaliacao);
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    @Override
    public void imprimir() {
        System.out.println("Nome: "+getNome()
        + "\nGênero: "+getGenero()
        + "\nLançamento: " + getAnoLancamento()
        + "\nClassificação Indicativa: " + getClassificacao()
        + "\nSinopse: "+getSinopse()
        + "\nOnde Assistir? "+getPlataforma()
        + "\nAvaliação dos Usuários: "+ getAvaliacoes());

    }
}
