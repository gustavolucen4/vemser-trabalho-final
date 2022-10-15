package com.dbc.view;

import com.dbc.enums.TipoUsuario;
import com.dbc.model.Usuario;
import com.dbc.service.UsuarioService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UsuarioService usuarioService = new UsuarioService();
        Scanner scanner = new Scanner(System.in);

        Usuario usuario = new Usuario();
        usuario.setNome("Mario");
        usuario.setEmail("Mario@hotmail.com");
        usuario.setTipoUsuario(TipoUsuario.ADMINISTRADOR);
        usuario.setSenha("1234");
        usuario.setIdade(50);

        Usuario usuario2 = new Usuario();
        usuario2.setNome("Iori");
        usuario2.setTipoUsuario(TipoUsuario.CLIENTE);
        usuario2.setEmail("Iori@hotmail.com");
        usuario2.setSenha("2222");
        usuario2.setIdade(23);


      //    usuarioService.adicionarUsuario(usuario2);

       // usuarioService.removerUsuario(13);


        //  usuarioService.editarUsuario(9,usuario2);

       usuarioService.listarUsuarios();

    }
}