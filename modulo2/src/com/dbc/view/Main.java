package com.dbc.view;

import com.dbc.enums.TipoUsuario;
import com.dbc.model.Usuario;
import com.dbc.service.AssistidosService;
import com.dbc.service.AvaliacaoService;
import com.dbc.service.ItemService;
import com.dbc.service.UsuarioService;
import com.dbc.view.metodosmain.interacao.Login;

import java.awt.*;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        ItemService itemService = new ItemService();
        UsuarioService usuarioService = new UsuarioService();
        AssistidosService assistidosService = new AssistidosService();
        AvaliacaoService avaliacaoService = new AvaliacaoService();

        Usuario usuarioLogado = null;

        while (true) {
            //Metodo login usuario/adim
            System.out.println("Entrar[1] Sair[2] !!");
            int stop = scanner.nextInt();

            if (stop == 2){
                break;
            }

            usuarioLogado = Login.login(usuarioService, scanner);
            System.out.println(usuarioLogado.getTipoUsuario().getDescricao());


            if (usuarioLogado.getTipoUsuario().getDescricao().equals(TipoUsuario.CLIENTE.getDescricao())) {
                //Menu do Cliente
                Menu.menuCliente(assistidosService, itemService, avaliacaoService, usuarioLogado, scanner);
                System.out.println("cliente");
            } else {
                //Menu do Admin
                //Menu.menuAdmin(usuarioManipulacao, itemManipulacao, avaliacaoManipulacao, usuarioLogado, scanner);
            }
        }

        System.out.println("Obrigado por utilizar nosso sistema!!");
    }
}