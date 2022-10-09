package entidades;

public class Administrador extends Usuario{

    public Administrador() {
        super();
        setUsuarioAdmin(this);
    }

    public Administrador(String nome, int idade, String email, String senha) {
        super(nome, idade, email, senha);
        setUsuarioAdmin(this);
    }


}
