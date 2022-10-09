package metodosmain;

import entidades.Cliente;
import entidades.Usuario;
import manipulacao.UsuarioManipulacao;

import java.util.Optional;
import java.util.Scanner;

public class Login {

    public static Usuario login(UsuarioManipulacao usuarioManipulacao){
        Scanner scanner = new Scanner(System.in);

        Usuario usuarioEntrada = new Cliente();

        try{
            while (true) {
                System.out.println("Bem vindo!\nFazer login(1) ou se cadastrar(2)?");
                int opcaoEntrada = scanner.nextInt();
                scanner.nextLine();

                if (opcaoEntrada == 1) {
                    System.out.println("**LOGIN** ");
                    System.out.println("Email:");
                    String loginUsuario = scanner.nextLine();
                    usuarioEntrada.setEmail(loginUsuario);
                    System.out.println("Senha:");
                    String senhaUsuario = scanner.nextLine();
                    usuarioEntrada.setSenha(senhaUsuario);

                    Optional<Usuario> retornoUser = usuarioManipulacao.getUsuariosLista().stream()
                            .filter(login -> (login.getEmail().equals(usuarioEntrada.getEmail()) &&
                                    (login.getSenha().equals(usuarioEntrada.getSenha()))))
                            .findFirst();

                    if (!retornoUser.isEmpty()) {
                        System.out.println("\n"+usuarioEntrada.getEmail() + " Logado com sucesso!");
                    }else {
                        System.out.println("\nUsuário não encontrado. Favor realizar Cadastro.");
                    }

                    break;
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

                    usuarioManipulacao.criarUsuario(usuarioEntrada);

                    break;
                } else {
                    System.out.println("Opção informada não válida. Por favor, digite '1' para metodosmain.Login e '2' para Cadastro");
                }
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }


        scanner.close();
        return usuarioEntrada;
    }
}
