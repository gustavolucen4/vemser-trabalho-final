import java.util.Date;
import java.util.List;

public class ItemEntretenimento {

    static int contadorId=0;
    protected Integer id;
    private String nome;
    private String genero;
    private String subgenero;
    private String sinopse;
    private Date anoLancamento;
    private int classificacao;
    private double critica;
    private String plataforma;
    private List <Avaliacao> avaliacoes;


    //Construtores
    public ItemEntretenimento() {
        id=contadorId++;
    }

    public ItemEntretenimento(String nome, String genero, String subgenero) {
        this.id=contadorId++;
        this.nome = nome;
        this.genero = genero;
        this.subgenero = subgenero;
    }

    public ItemEntretenimento(String nome, String genero, String subgenero, String sinopse, Date anoLancamento, int classificacao, double critica, String plataforma, List<Avaliacao> avaliacoes) {
        this.id=contadorId++;
        this.nome = nome;
        this.genero = genero;
        this.subgenero = subgenero;
        this.sinopse = sinopse;
        this.anoLancamento = anoLancamento;
        this.classificacao = classificacao;
        this.critica = critica;
        this.plataforma = plataforma;
        this.avaliacoes = avaliacoes;
    }

    //GETTERS AND SETTERS

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getSubgenero() {
        return subgenero;
    }

    public void setSubgenero(String subgenero) {
        this.subgenero = subgenero;
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

    public int getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public double getCritica() {
        return critica;
    }

    public void setCritica(double critica) {
        this.critica = critica;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(Avaliacao avaliacao) {
        this.avaliacoes.add(avaliacao);
    }
}
