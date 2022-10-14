package com.dbc.view;

import com.dbc.enums.TipoUsuario;
import com.dbc.model.Usuario;

import java.awt.*;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);


        Usuario usuarioLogado;



//        itemManipulacao.listarItemEntretenimento();
//        while (true) {
//        //Metodo login usuario/adim
//        usuarioLogado = Login.login(usuarioManipulacao, scanner);
//        System.out.println(usuarioLogado.getTipoUsuario().getDescricao());
//
//
//            if (usuarioLogado.getTipoUsuario().getDescricao().equals(TipoUsuario.CLIENTE.getDescricao())) {
//                //Menu do Cliente
//                Menu.menuCliente(assistidosManipulacao, itemManipulacao, avaliacaoManipulacao, usuarioLogado, scanner);
//            } else {
//                //Menu do Admin
//                Menu.menuAdmin(usuarioManipulacao, itemManipulacao, avaliacaoManipulacao, usuarioLogado, scanner);
//            }
//        }
    }
}