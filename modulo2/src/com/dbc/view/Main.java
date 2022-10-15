package com.dbc.view;

import com.dbc.enums.TipoUsuario;
import com.dbc.model.*;
import com.dbc.service.AssistidosService;
import com.dbc.service.AvaliacaoService;
import com.dbc.service.ItemService;
import com.dbc.service.UsuarioService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AvaliacaoService avaliacaoService = new AvaliacaoService();
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

       //usuarioService.listarUsuarios();

        //usuarioService.pegarUsuario(1);

        //avaliacaoService.adicionarAvaliacao(new Avaliacao(9.5 ,"Triste"), 1, 2);
        //avaliacaoService.editarAvaliacao(new Avaliacao(9.0, "Muito bom para chorar."), 1, 2);
    }
}