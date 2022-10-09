import entidades.Cliente;
import entidades.Filtro;
import entidades.Usuario;
import manipulacao.AssistidosManipulacao;
import manipulacao.AvaliacaoManipulacao;
import manipulacao.ItemManipulacao;
import manipulacao.UsuarioManipulacao;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        AssistidosManipulacao assistidosManipulacao = new AssistidosManipulacao();
        AvaliacaoManipulacao avaliacaoManipulacao = new AvaliacaoManipulacao();
        ItemManipulacao itemManipulacao = new ItemManipulacao();
        UsuarioManipulacao usuarioManipulacao= new UsuarioManipulacao();

        Usuario usuarioCadastro = new Cliente();

        Filtro filtro = new Filtro();

        System.out.println("TESTEEEEEEEEEEEEEEEE");

        //Metodo preencher listas DB
        PreencherLista.preencherFilmes(itemManipulacao);


        //Metodo login usuario/adim
        System.out.println("Bem vindo!\nFazer login(1) ou se cadastrar(2)?");
        int opcaoEntrada = scanner.nextInt();

        if (opcaoEntrada == 1){
            System.out.println("\nLOGIN: ");
            System.out.println("\nEmail:");
            String loginUsuario = scanner.nextLine();
            usuarioCadastro.setEmail(loginUsuario);
            System.out.println("\nSenha:");
            String senhaUsuario = scanner.nextLine();
            usuarioCadastro.setSenha(senhaUsuario);

            usuarioManipulacao.getUsuariosLista().stream()
                    .filter(login -> login.getEmail().equals(usuarioCadastro.getEmail() && login.getSenha().equals(usuarioCadastro.getSenha()))

        }
        if (opcaoEntrada==2) {
            System.out.println("Preencha os seguintes dados para realizar o cadastro: ");

            System.out.println("\nNome: ");
            String nome = scanner.nextLine();
            usuarioCadastro.setNome(nome);

            System.out.println("\nIdade: ");
            int idade = scanner.nextInt();
            scanner.nextLine();
            usuarioCadastro.setIdade(idade);

            System.out.println("Email: ");
            String email = scanner.nextLine();
            usuarioCadastro.setEmail(email);

            System.out.println("\nSenha: ");
            String senha = scanner.nextLine();
            usuarioCadastro.setSenha(senha);

        } else {
            System.out.println("Opção informada não válida. Por favor, digite '1' para Login e '2' para Cadastro");
        }




        //if(usuarioManipulacao)





        //Menu do Cliente

        System.out.println("");


        System.out.println("Menu Cliente:");
        System.out.println("[1] Itens assistidos");
        System.out.println("[2] Avaliações");


        int opcaoMenuCliente = scanner.nextInt();

        switch (opcaoMenuCliente) {
            case 1 -> {
                System.out.println("[1] Listar itens assistidos");
                System.out.println("[2] Marcar item assistido");
                System.out.println("[3] Editar itens assistidos");
                System.out.println("[4] Deletar itens assistidos");
                int opcaoMenuClienteItensAssistidos = scanner.nextInt();
                switch (opcaoMenuClienteItensAssistidos) {

                }
            }
            case 2 -> {
                System.out.println("[1] Listar avaliações");
                System.out.println("[2] Adicionar avaliações");
                System.out.println("[3] Editar avaliações");
                System.out.println("[4] Deletar avaliações");
            }
        }

        /*if (opcaoMenuCliente == 1) {
            assistidosManipulacao.getAssistidos();
        } else if (opcaoMenuCliente == 2) {
            System.out.println("Qual ");
            String marcarAssistido = scanner.nextLine();
                filtro
            }*/
    }







    //Menu do Admin


}
