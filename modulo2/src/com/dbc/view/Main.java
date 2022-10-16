package com.dbc.view;

import com.dbc.enums.TipoUsuario;
import com.dbc.model.Usuario;
import com.dbc.service.AssistidosService;
import com.dbc.service.AvaliacaoService;
import com.dbc.service.ItemService;
import com.dbc.service.UsuarioService;
import com.dbc.view.metodosmain.Menus;
import com.dbc.view.metodosmain.interacao.Login;

import java.util.InputMismatchException;
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
            try{
                //Metodo login usuario/adim
                System.out.println("Entrar[1] Sair[2] !!");
                int stop = scanner.nextInt();
                scanner.nextLine();

                if (stop == 2){
                    break;
                }

                usuarioLogado = Login.login(usuarioService, scanner);
                System.out.println(usuarioLogado.getTipoUsuario().getDescricao());


                if (usuarioLogado.getTipoUsuario().getDescricao().equals(TipoUsuario.CLIENTE.getDescricao())) {
                    //Menu do Cliente
                    Menus.menuCliente(assistidosService, itemService, avaliacaoService, usuarioLogado, scanner);
                } else {
                    //Menu do Admin
                    Menus.menuAdmin(usuarioService, itemService, avaliacaoService, usuarioLogado, scanner);
                }
            }catch (InputMismatchException ex){
                System.err.println("Por favor, digite um valor válido!!");
            }catch (NullPointerException ex){
                System.out.println(ex.getMessage());
            }finally {
                scanner.nextLine();
            }
        }

        scanner.close();
        System.out.println("\u001B[34m" + "Obrigado por utilizar nosso sistema!!" + "\u001B[0m");
    }
}