public class Usuario {
    private String nome;
    private int idade;
    private String email;
    private String idioma;
    private String senha;

    //Construtores
    public Usuario(String nome, int idade, String email, String idioma, String senha) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.idioma = idioma;
        this.senha = senha;
    }

    public Usuario() {
    }

    //GETTERS AND SETTERS
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
