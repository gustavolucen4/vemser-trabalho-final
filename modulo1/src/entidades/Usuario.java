package entidades;

import interfacesenum.Impressao;
import interfacesenum.TipoUsuario;

public abstract class Usuario implements Impressao {

    static Integer contadorId = 0;
    private Integer id;
    private String nome;
    private Integer idade;
    private String email;
    private String senha;

    protected TipoUsuario tipoUsuario;

    //Construtores
    public Usuario(String nome, int idade, String email, String senha) {
        this.id = contadorId++;
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.senha = senha;
        tipoUsuario = TipoUsuario.CLIENTE;
    }

    public Usuario() {
        this.id = contadorId++;
        tipoUsuario = TipoUsuario.CLIENTE;
    }

    public Integer getId() {
        return id;
    }

    //GETTERS AND SETTERS
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoUsuario getTipoUsuario(){
        return this.tipoUsuario;
    }

    public void setUsuarioAdmin(Usuario cliente){
        if(this.tipoUsuario.equals(TipoUsuario.ADIMINISTRADOR)){
            cliente.tipoUsuario = TipoUsuario.ADIMINISTRADOR;
        }
    }

    @Override
    public void imprimir() {
        System.out.println("--------------"
                + "\nNome: "+getNome()
                + "\nIdade: "+getIdade()
                + "\nEmail: "+getEmail()
                + "\nTipo de usuário: "+this.tipoUsuario.getDescricao()
                + "\n--------------");
    }

}
