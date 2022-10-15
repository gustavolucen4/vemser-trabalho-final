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
        usuario.setTipoUsuario(TipoUsuario.ADIMINISTRADOR);
        usuario.setSenha("1234");
        usuario.setIdade(50);

        Usuario usuario2 = new Usuario();
        usuario2.setNome("Chris");
        usuario2.setEmail("Chris@hotmail.com");
        usuario2.setSenha("1344");
        usuario2.setIdade(12);


     //  usuarioService.adicionarUsuario(usuario);

         usuarioService.removerUsuario(12);


        //  usuarioService.editarUsuario(9,usuario2);

       usuarioService.listarUsuarios();

    }
}