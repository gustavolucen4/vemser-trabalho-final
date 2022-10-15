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

        Usuario usuarioLogado;

        int fluxo = 0;

        while (fluxo != 9) {
            //Metodo login usuario/adim
            usuarioLogado = Login.login(usuarioManipulacao, scanner);
            System.out.println(usuarioLogado.getTipoUsuario().getDescricao());


            if (usuarioLogado.getTipoUsuario().getDescricao().equals(TipoUsuario.CLIENTE.getDescricao())) {
                //Menu do Cliente
                Menu.menuCliente(assistidosManipulacao, itemManipulacao, avaliacaoManipulacao, usuarioLogado, scanner);
            } else {
                //Menu do Admin
                Menu.menuAdmin(usuarioManipulacao, itemManipulacao, avaliacaoManipulacao, usuarioLogado, scanner);
            }
        }
    }
    }
}