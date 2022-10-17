//package com.dbc.test;
//
//import com.dbc.model.Usuario;
//import com.dbc.service.UsuarioService;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//public class UsuarioServiceTest {
//    UsuarioService usuarioService;
//
//    @BeforeEach
//    public void setUp() {
//        usuarioService = new UsuarioService();
//
//    }
//
//    @Test
//    public void testarAdicionarUsuario() {
//        Usuario usuario = new Usuario();
//        usuario.setNome("Monster");
//        usuario.setEmail("Monster@hotmail.com");
//        usuario.setIdade(24);
//        usuario.setSenha("1268");
//
//
//        // usuarioService.adicionarUsuario(usuario);
//        Usuario usuarioPegado = usuarioService.pegarUsuario(17);
//
//
//        Assertions.assertEquals(usuarioPegado.getId(), 17);
//        Assertions.assertEquals(usuarioPegado.getNome(), usuario.getNome());
//        Assertions.assertEquals(usuarioPegado.getEmail(), usuario.getEmail());
//        Assertions.assertEquals(usuarioPegado.getIdade(), usuario.getIdade());
//        Assertions.assertEquals(usuarioPegado.getSenha(), usuario.getSenha());
//        Assertions.assertEquals(usuarioPegado.getTipoUsuario(), usuario.getTipoUsuario());
//
//
//    }
//
//
//    @Test
//    public void testarRemoverUsuario() {
//        Usuario usuario2 = new Usuario();
//        usuario2.setNome("Ryu");
//        usuario2.setEmail("Ryu@hotmail.com");
//        usuario2.setIdade(30);
//        usuario2.setSenha("1268aa");
//
//        // usuarioService.adicionarUsuario(usuario2);
//
//        // usuarioService.removerUsuario(18);
//        Usuario usuarioRemovido = usuarioService.pegarUsuario(18);
//
//        Assertions.assertNull(usuarioRemovido.getId());
//
//
//    }
//
//    @Test
//    public void testarEditarUsuario() {
//        Usuario usuario3 = new Usuario();
//        usuario3.setNome("Tiago");
//        usuario3.setEmail("Tiago@hotmail.com");
//        usuario3.setIdade(22);
//        usuario3.setSenha("13aa");
//
//        Usuario usuarioEdit = new Usuario();
//        usuarioEdit.setNome("Julio");
//        usuarioEdit.setEmail("Julio@hotmail.com");
//        usuarioEdit.setIdade(30);
//        usuarioEdit.setSenha("1829");
//
//        //  usuarioService.adicionarUsuario(usuario3);
//
//        //   usuarioService.editarUsuario(19,usuarioEdit);
//
//        Usuario usuarioQueFoiAtualizado = usuarioService.pegarUsuario(19);
//
//        Assertions.assertEquals(usuarioQueFoiAtualizado.getNome(), usuarioEdit.getNome());
//        Assertions.assertEquals(usuarioQueFoiAtualizado.getEmail(), usuarioEdit.getEmail());
//        Assertions.assertEquals(usuarioQueFoiAtualizado.getIdade(), usuarioEdit.getIdade());
//        Assertions.assertEquals(usuarioQueFoiAtualizado.getSenha(), usuarioEdit.getSenha());
//
//
//    }
//}
