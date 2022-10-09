package entidades;

import interfacesenum.TipoUsuario;

public class Administrador extends Usuario{

    public Administrador() {
        super();
        tipoUsuario = TipoUsuario.ADIMINISTRADOR;
    }

    public Administrador(String nome, int idade, String email, String senha) {
        super(nome, idade, email, senha);
        tipoUsuario = TipoUsuario.ADIMINISTRADOR;
    }
}
