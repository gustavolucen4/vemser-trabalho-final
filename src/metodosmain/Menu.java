package metodosmain;

import manipulacao.AvaliacaoManipulacao;
import manipulacao.ItemManipulacao;
import manipulacao.UsuarioManipulacao;

import java.util.Scanner;

public class Menu {

    public static void menuAdmin(UsuarioManipulacao usuarioManipulacao, ItemManipulacao itemManipulacao, AvaliacaoManipulacao avaliacaoManipulacao){
        Scanner scanner = new Scanner(System.in);

        int listaSelecionada = 0;

        System.out.println("**Menu Admin**");
        while (listaSelecionada != 9){

            int metodoSelecionado = 0;

            System.out.println("[1] Listar Todos os Itens de Entretenimento.");
            System.out.println("[2] Listar Todos as Avaliações.");
            System.out.println("[3] Lista Todos os Usuarios.");
            System.out.println("[9] Sair.");

            listaSelecionada = scanner.nextInt();

            switch (listaSelecionada){
                case 1 -> {
                    itemManipulacao.listarItemEntretenimento();

                    while (metodoSelecionado != 9){

                        int itemSelecionado = 0;

                        System.out.println("[1] Criar novo Item de Entretenimento.");
                        System.out.println("[2] Atualizar um item.");
                        System.out.println("[3] Excluir um item.");
                        System.out.println("[9] Voltar.");

                        metodoSelecionado = scanner.nextInt();

                        switch (metodoSelecionado){
                            case 1 -> {
                                System.out.println("Criar filme ou serie ?");
                            }
                        }
                    }


                }
                case 2 -> {
                    avaliacaoManipulacao.listarAvaliacoes();

                    while (metodoSelecionado != 9){
                        System.out.println("[1] Criar nova avaliação.");
                        System.out.println("[2] Atualizar avaliação.");
                        System.out.println("[3] Excluir uma avaliação.");
                        System.out.println("[9] Voltar.");
                    }

                }
                case 3 -> {
                    usuarioManipulacao.listarUsuarios();

                    while (metodoSelecionado != 9){
                        System.out.println("[1] Tornar usuário adiministrador.");
                        System.out.println("[2] Atualizar usuário.");
                        System.out.println("[3] Excluir usuario.");
                        System.out.println("[9] Voltar.");
                    }

                }
                default -> {
                    System.out.println("Opção invalida, digite novamente.");
                }
            }
        }
    }


    //

}
