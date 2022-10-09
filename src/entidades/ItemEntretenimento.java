package entidades;

import interfacesenum.Impressao;

import java.util.ArrayList;
import java.util.List;

public class ItemEntretenimento implements Impressao {

    static Integer contadorId=0;
    protected Integer id;
    protected String tipo;
    private String nome;
    private String genero;
    private String sinopse;
    private String anoLancamento;
    private Integer classificacao;
    private String plataforma;
    private List <Avaliacao> avaliacoes;


    //Construtores
    public ItemEntretenimento() {
        id=contadorId++;
        avaliacoes = new ArrayList<>();
    }

    public ItemEntretenimento(String nome, String genero) {
        this.id=contadorId++;
        this.nome = nome;
        this.genero = genero;
        avaliacoes = new ArrayList<>();
    }

    public ItemEntretenimento(String nome, String genero, String sinopse, String anoLancamento, Integer classificacao, String plataforma) {
        this.id=contadorId++;
        this.nome = nome;
        this.genero = genero;
        this.sinopse = sinopse;
        this.anoLancamento = anoLancamento;
        this.classificacao = classificacao;
        this.plataforma = plataforma;
        avaliacoes = new ArrayList<>();
    }

    //GETTERS AND SETTERS

    public Integer getId() {
        return id;
    }

    public String getTipo(){
        return tipo;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
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

    public String getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(String anoLancamento) {
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
        System.out.println("--------------------------------------"
        + "\nId: "+getId()
        + "\nNome: "+getNome()
        + "\nGênero: "+getGenero()
        + "\nLançamento: " + getAnoLancamento()
        + "\nClassificação Indicativa: " + getClassificacao()
        + "\nSinopse: "+getSinopse()
        + "\nOnde Assistir? "+getPlataforma()
        + "\nAvaliação dos Usuários: "+ getAvaliacoes()
        + "\n--------------------------------------");
    }
}
