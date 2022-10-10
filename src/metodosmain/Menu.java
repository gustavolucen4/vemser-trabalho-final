package metodosmain;

import entidades.*;
import manipulacao.AssistidosManipulacao;
import manipulacao.AvaliacaoManipulacao;
import manipulacao.ItemManipulacao;
import manipulacao.UsuarioManipulacao;
import metodosmain.interacao.*;

import java.util.Scanner;

public class Menu {

    public static void menuAdmin(UsuarioManipulacao usuarioManipulacao, ItemManipulacao itemManipulacao, AvaliacaoManipulacao avaliacaoManipulacao, Usuario usuario, Scanner scanner){

        Filtro filtro = new Filtro();
        int listaSelecionada = 0;

        System.out.println("**Menu Admin**");
        while (listaSelecionada != 9){

            int metodoSelecionado = 0;

            System.out.println("[1] Listar Todos os Itens de Entretenimento.");
            System.out.println("[2] Listar Todos as Avaliações.");
            System.out.println("[3] Lista Todos os Usuarios.");
            System.out.println("[4] Pedir indicação de filme.");
            System.out.println("[9] Sair.");


            listaSelecionada = scanner.nextInt();
            //scanner.nextLine();

            switch (listaSelecionada){
                case 1 -> {
                    System.out.println("Todos os filmes/series");
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
                                System.out.println("Criar filme[1] ou serie[2] ?");
                                itemSelecionado = scanner.nextInt();
                                scanner.nextLine();
                                if (itemSelecionado == 1){
                                    //Criar filme
                                    Criar.criarFilme(itemManipulacao, scanner);

                                }else if (itemSelecionado == 2) {
                                    //Criar Serie
                                    Criar.criarSerie(itemManipulacao, scanner);
                                }
                            }
                            case 2 -> {
                                System.out.println("Atualizar filme[1] ou serie[2] ?");
                                itemSelecionado = scanner.nextInt();
                                scanner.nextLine();
                                if (itemSelecionado == 1){
                                    //Atualizar filme
                                    System.out.println("Digite o id/index que deseja atualizar");
                                    Integer index = scanner.nextInt();
                                    scanner.nextLine();
                                    Atualizar.atualizarFilme(index ,itemManipulacao, scanner);

                                }else if (itemSelecionado == 2) {
                                    //Atualizar Serie
                                    System.out.println("Digite o id/index que deseja atualizar");
                                    Integer index = scanner.nextInt();
                                    scanner.nextLine();
                                    Atualizar.atualizarSerie(index ,itemManipulacao, scanner);
                                }
                            }
                            case 3 -> {
                                System.out.println("Deletar filme/serie !");
                                    //Deletar filme/serie
                                    System.out.println("Digite o id/index que deseja deletar");
                                    Integer index = scanner.nextInt();
                                    scanner.nextLine();
                                    Deletar.deletarItemEntretenimento(index,itemManipulacao);
                            }
                            case 9 -> {
                                System.out.println("<---");
                            }
                            default -> {
                                System.err.println("Opção inválida!!");
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


                        metodoSelecionado = scanner.nextInt();


                        switch (metodoSelecionado){
                            case 1 -> {
                                System.out.println("Criar Avaliação");
                                    //Criar Avaliação
                                    itemManipulacao.listarItemEntretenimento();
                                    System.out.println("Digite o index do filme que deseja avaliar:");
                                    Integer index = scanner.nextInt();
                                    Criar.criarAvaliacao(itemManipulacao, avaliacaoManipulacao, usuario, index, scanner);
                            }
                            case 2 -> {
                                System.out.println("Atualizar avaliação");
                                    avaliacaoManipulacao.listarAvaliacoes();
                                    //Atualizar avaliação
                                    System.out.println("Digite o id/index que deseja atualizar");
                                    Integer index = scanner.nextInt();
                                    scanner.nextLine();
                                    Atualizar.atualizarAvaliacao(itemManipulacao, avaliacaoManipulacao, usuario, index, scanner);
                            }
                            case 3 -> {
                                System.out.println("Deletar avaliação !");
                                //Deletar avaliação
                                System.out.println("Digite o id/index que deseja deletar");
                                Integer index = scanner.nextInt();
                                Deletar.deletarAvaliacao(index, avaliacaoManipulacao);
                            }
                            case 9 -> {
                                System.out.println("<---");
                            }
                            default -> {
                                System.err.println("Opção inválida!!");
                            }
                        }

                    }

                }
                case 3 -> {
                    usuarioManipulacao.listarUsuarios();

                    while (metodoSelecionado != 9){

                        System.out.println("[1] Tornar usuário adiministrador.");
                        System.out.println("[2] Atualizar usuário.");
                        System.out.println("[3] Excluir usuário.");
                        System.out.println("[9] Voltar.");

                        metodoSelecionado = scanner.nextInt();

                        switch (metodoSelecionado){
                            case 1 -> {
                                System.out.println("Tornar usuário adiministrador");
                                //Criar Avaliação
                                usuarioManipulacao.listarUsuarios();
                                System.out.println("Digite o email do cliente que deseja tornar administrador:");
                                String email = scanner.next();
                                Atualizar.tornarClienteAdmin(usuarioManipulacao, email, usuario);
                            }
                            case 2 -> {
                                System.out.println("Atualizar usuário");
                                usuarioManipulacao.listarUsuarios();
                                //Atualizar Usuario
                                System.out.println("Digite email do usuário que deseja atualizar");
                                String email = scanner.next();
                                scanner.nextLine();
                                Atualizar.atualizarQualquerUsuario(usuarioManipulacao, email, usuario, scanner);
                            }
                            case 3 -> {
                                System.out.println("Deletar usuário !");
                                //Deletar Usuario
                                usuarioManipulacao.listarUsuarios();
                                System.out.println("Digite o id/index que deseja deletar");
                                Integer index = scanner.nextInt();
                                Deletar.deletarQualquerUsuario(index, usuarioManipulacao, usuario);
                            }
                            case 9 -> {
                                System.out.println("<---");
                            }
                            default -> {
                                System.err.println("Opção inválida!!");
                            }
                        }
                    }

                }
                case 4 -> {
                    scanner.nextLine();
                    Buscar.buscarItens(itemManipulacao, filtro, scanner);
                }
                case 9 -> {
                    System.out.println("Você saiu!");
                }
                default -> {
                    System.err.println("Opção invalida, digite novamente.");
                }
            }
        }
    }


    //
    public static void menuCliente(AssistidosManipulacao assistidosManipulacao, ItemManipulacao itemManipulacao, AvaliacaoManipulacao avaliacaoManipulacao, Usuario usuarioLogado, Scanner scanner){
        Filtro filtro = new Filtro();

        int listaSelecionada = 0;

        while (listaSelecionada != 9) {

            int metodoSelecionado = 0;

            System.out.println("**Menu Cliente**");
            System.out.println("[1] Buscar filmes e series");
            System.out.println("[2] Itens assistidos");
            System.out.println("[3] Avaliações");
            System.out.println("[9] Sair!");


            listaSelecionada = scanner.nextInt();
            scanner.nextLine();

            switch (listaSelecionada) {
                case 1 -> {
                    Buscar.buscarItens(itemManipulacao, filtro, scanner);
                }
                case 2 -> {
                    System.out.println("[1] Listar itens assistidos");
                    System.out.println("[2] Marcar item assistido");
                    System.out.println("[3] Deletar itens assistidos");
                    System.out.println("[9] Voltar");

                    metodoSelecionado = scanner.nextInt();
                    scanner.nextLine();
                    switch (metodoSelecionado) {
                        case 1 -> {
                            assistidosManipulacao.listarAssistidos();
                        }
                        case 2 -> {
                            itemManipulacao.listarItemEntretenimento();
                            System.out.println("Qual o ID do item que deseja marcar como assistido?");
                            Integer marcarAssistido = scanner.nextInt();
                            scanner.nextLine();
                            assistidosManipulacao.marcarAssistido(marcarAssistido);
                            assistidosManipulacao.listarAssistidos();
                        }
                        case 3 -> {
                            assistidosManipulacao.listarAssistidos();
                            System.out.println("Qual o ID do item assistido que deseja excluir?");
                            Integer excluirAssistido = scanner.nextInt();
                            scanner.nextLine();
                            assistidosManipulacao.deletarAssistido(excluirAssistido);

                        }
                        case 9 -> {
                            System.out.println("<---");
                        }
                        default -> System.err.println("ID não localizado.");
                    }
                }
                case 3 -> {
                    System.out.println("[1] Listar avaliações");
                    System.out.println("[2] Adicionar avaliações");
                    System.out.println("[3] Editar avaliações");
                    System.out.println("[4] Deletar avaliações");
                    System.out.println("[9] Voltar");
                    int opcaoMenuClienteAvaliacoes = scanner.nextInt();
                    scanner.nextLine();
                    switch (opcaoMenuClienteAvaliacoes) {
                        case 1 -> {
                            avaliacaoManipulacao.listarAvaliacoes();
                        }
                        case 2 -> {
                            avaliacaoManipulacao.listarAvaliacoes();

                            System.out.println("Criar Avaliação");
                            //Criar Avaliação
                            itemManipulacao.listarItemEntretenimento();
                            System.out.println("Digite o index do filme que deseja avaliar:");
                            Integer index = scanner.nextInt();
                            Criar.criarAvaliacao(itemManipulacao, avaliacaoManipulacao, usuarioLogado, index, scanner);
                        }
                        case 3 -> {
                            avaliacaoManipulacao.listarAvaliacoes();

                            System.out.println("Atualizar avaliação");
                            avaliacaoManipulacao.listarAvaliacoes();
                            //Atualizar avaliação
                            System.out.println("Digite o id/index que deseja atualizar");
                            Integer index = scanner.nextInt();
                            scanner.nextLine();
                            Atualizar.atualizarAvaliacao(itemManipulacao, avaliacaoManipulacao, usuarioLogado, index, scanner);
                        }
                        case 4 -> {

                            System.out.println("Deletar avaliação !");
                            //Deletar avaliação
                            System.out.println("Digite o id/index que deseja deletar");
                            Integer index = scanner.nextInt();
                            Deletar.deletarAvaliacao(index, avaliacaoManipulacao);
                        }
                        case 9 -> {
                            System.out.println("<---");
                        }
                        default -> {
                            System.err.println("ID não localizado.");
                        }
                    }
                }
                case 9 -> {
                    System.out.println("Você Saiu!");
                }
            }
        }
    }
}
