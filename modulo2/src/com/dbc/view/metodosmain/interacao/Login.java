package com.dbc.view.metodosmain.interacao;

import com.dbc.model.Cliente;
import com.dbc.model.Usuario;
import com.dbc.service.UsuarioService;

import java.util.Scanner;

public class Login {

    public static Usuario login(UsuarioService usuarioService, Scanner scanner){

        Usuario usuarioEntrada = new Cliente();
        Usuario resultadoUser = null;

        try{
            while (true) {
                System.out.println("Bem vindo!\nFazer login(1) ou se cadastrar(2)?");
                int opcaoEntrada = scanner.nextInt();
                scanner.nextLine();

                if (opcaoEntrada == 1) {
                    System.out.println("**LOGIN** ");
                    System.out.println("Email:");
                    usuarioEntrada.setEmail(scanner.nextLine());
                    System.out.println("Senha:");
                    usuarioEntrada.setSenha(scanner.nextLine());

                    Usuario usuarioEncontrado = usuarioService.verificarUsuario(usuarioEntrada);

                    if (usuarioEncontrado.getEmail() != null && usuarioEncontrado.getSenha() != null) {
                        System.out.println("\n"+usuarioEntrada.getEmail() + " Logado com sucesso!");
                        resultadoUser = usuarioEncontrado;
                        break;
                    }else {
                        System.out.println("\nUsuário não encontrado. Favor realizar Cadastro.");
                    }

                }
                if (opcaoEntrada == 2) {
                    System.out.println("Preencha os seguintes dados para realizar o cadastro: ");

                    System.out.println("\nNome: ");
                    String nome = scanner.nextLine();
                    usuarioEntrada.setNome(nome);

                    System.out.println("\nIdade: ");
                    int idade = scanner.nextInt();
                    scanner.nextLine();
                    usuarioEntrada.setIdade(idade);

                    System.out.println("Email: ");
                    String email = scanner.nextLine();
                    usuarioEntrada.setEmail(email);

                    System.out.println("\nSenha: ");
                    String senha = scanner.nextLine();
                    usuarioEntrada.setSenha(senha);

                    usuarioService.adicionarUsuario(usuarioEntrada);
                    resultadoUser = usuarioService.verificarUsuario(usuarioEntrada);
                    break;

                } else {
                    System.err.println("Opção informada não válida. Por favor, digite '1' para metodosmain.interacao.Login e '2' para Cadastro");
                }
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        return resultadoUser;
    }
}
