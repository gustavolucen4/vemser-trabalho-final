package com.dbc.view.metodosmain.interacao;

import com.dbc.exceptions.OpcaoInvalidaException;
import com.dbc.exceptions.UsuarioInvalidoException;
import com.dbc.model.Cliente;
import com.dbc.model.Usuario;
import com.dbc.service.UsuarioService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Login {

    public static Usuario login(UsuarioService usuarioService, Scanner scanner){

        Usuario usuarioEntrada = new Cliente();
        Usuario resultadoUser = null;

        System.out.println("**Bem vindo!**");
        while (true) {
            try {

                System.out.println("Fazer login(1) ou se cadastrar(2)?");
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
                        System.out.println("Usuário não encontrado. Favor realizar Cadastro.");
                    }

                }else if (opcaoEntrada == 2) {
                    System.out.println("Preencha os seguintes dados para realizar o cadastro: ");

                    System.out.println("Nome: ");
                    String nome = scanner.nextLine();
                    usuarioEntrada.setNome(nome);

                    System.out.println("Idade: ");
                    int idade = scanner.nextInt();
                    scanner.nextLine();
                    usuarioEntrada.setIdade(idade);

                    System.out.println("Email: ");
                    String email = scanner.nextLine();
                    usuarioEntrada.setEmail(email);

                    System.out.println("Senha: ");
                    String senha = scanner.nextLine();
                    usuarioEntrada.setSenha(senha);

                    usuarioService.adicionarUsuario(usuarioEntrada);
                    resultadoUser = usuarioService.verificarUsuario(usuarioEntrada);
                    break;

                } else {
                    throw new OpcaoInvalidaException("Opção informada inválida!");
                }
            }catch (InputMismatchException ex){
                scanner.nextLine();
                System.err.println("Por favor, digite um valor válido!!");
            }catch (OpcaoInvalidaException ex){
                System.err.println(ex.getMessage());
            }
            catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }

        if (resultadoUser == null){
            throw new UsuarioInvalidoException("Usuario inválido");
        }else {
            return resultadoUser;
        }
    }
}
