public abstract class Filtro implements Buscador {
    public String tipo;
    public String genero;
    public int classificacao;

    //Construtores
    public Filtro() {
    }

    public Filtro(String tipo, String genero, int classificacao) {
        this.tipo = tipo;
        this.genero = genero;
        this.classificacao = classificacao;
    }

    //GETTERS AND SETTERS
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }
}
