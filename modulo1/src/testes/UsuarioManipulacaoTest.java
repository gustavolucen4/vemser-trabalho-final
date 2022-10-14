package testes;

import entidades.Cliente;
import entidades.Usuario;
import manipulacao.UsuarioManipulacao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UsuarioManipulacaoTest {

    private UsuarioManipulacao usuarioManipulacao;
    private Usuario usuario;

    @BeforeEach
    public void init(){
        usuarioManipulacao = new UsuarioManipulacao();
        usuario = new Cliente();
    }

    @Test
    public void deveTestarAdicionarUsuario(){
        usuario.setNome("Gaby");
        usuario.setEmail("gaby@email.com");

        boolean resultado = usuarioManipulacao.criarUsuario(usuario);

        assertTrue(resultado);

    }

    @Test
    public void deveTestarListarUsuario(){

        boolean listaUsuarios = usuarioManipulacao.listarUsuarios();

        assertTrue(listaUsuarios);
    }

    @Test
    public void deveTestarEditarUsuario(){
        usuarioManipulacao.criarUsuario(new Cliente("Gaby", 21, "gaby@email.com","VemSer@2022" ));

        usuario.setNome("Gabriela");
        usuario.setIdade(23);
        usuario.setEmail("gabriela@email.com");
        usuario.setSenha("VemSer@10Edicao");

        boolean edicaoUsuario = usuarioManipulacao.editarUsuario(0,usuario);

        assertTrue(edicaoUsuario);
    }

    @Test
    public void deveTestarDeletarUsuario(){
        usuarioManipulacao.criarUsuario(new Cliente("gustavo", 21, "gustavo@gmail", "123456711"));
        usuarioManipulacao.criarUsuario(new Cliente("Pedro", 50, "pedro@gmail", "444422756"));

        usuarioManipulacao.listarUsuarios();
        System.out.println("---------------");

        boolean verificar = false;
        verificar = usuarioManipulacao.deletarUsuario(0);

        usuarioManipulacao.listarUsuarios();

        assertTrue(verificar);

    }
}
