package com.dbc.view.metodosmain;

import com.dbc.model.Filtro;
import com.dbc.model.Usuario;
import com.dbc.service.AssistidosService;
import com.dbc.service.AvaliacaoService;
import com.dbc.service.ItemService;
import com.dbc.service.UsuarioService;
import com.dbc.view.metodosmain.interacao.Atualizar;
import com.dbc.view.metodosmain.interacao.Buscar;
import com.dbc.view.metodosmain.interacao.Criar;
import com.dbc.view.metodosmain.interacao.Deletar;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menus {

    public static void menuAdmin(UsuarioService usuarioService, ItemService itemService, AvaliacaoService avaliacaoService, Usuario usuario, Scanner scanner){

        Filtro filtro = new Filtro();
        int listaSelecionada = 0;

        System.out.println("**Menu Admin**");
        while (listaSelecionada != 9){

            try{
                int metodoSelecionado = 0;

                System.out.println("[1] Listar Todos os Itens de Entretenimento.");
                System.out.println("[2] Listar Todos as Avaliações.");
                System.out.println("[3] Lista Todos os Usuarios.");
                System.out.println("[4] Pedir indicação de filme.");
                System.out.println("[9] Voltar.");

                listaSelecionada = scanner.nextInt();
                //scanner.nextLine();

                switch (listaSelecionada){
                    case 1 -> {
                        System.out.println("Todos os filmes/series");
                        itemService.listarItens();

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
                                        Criar.criarFilme(itemService, scanner);

                                    }else if (itemSelecionado == 2) {
                                        //Criar Serie
                                        Criar.criarSerie(itemService, scanner);
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
                                        Atualizar.atualizarFilme(index , itemService, scanner);

                                    }else if (itemSelecionado == 2) {
                                        //Atualizar Serie
                                        System.out.println("Digite o id/index que deseja atualizar");
                                        Integer index = scanner.nextInt();
                                        scanner.nextLine();
                                        Atualizar.atualizarSerie(index, itemService, scanner);
                                    }
                                }
                                case 3 -> {
                                    System.out.println("Deletar filme/serie !");
                                    //Deletar filme/serie
                                    System.out.println("Digite o id/index que deseja deletar");
                                    Integer index = scanner.nextInt();
                                    scanner.nextLine();
                                    Deletar.deletarItemEntretenimento(index, itemService);
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
                        avaliacaoService.listarAvaliacoes();

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
                                    itemService.listarItens();
                                    System.out.println("Digite o index do filme que deseja avaliar:");
                                    Integer index = scanner.nextInt();
                                    Criar.criarAvaliacao(avaliacaoService, usuario, index, scanner);
                                }
                                case 2 -> {
                                    System.out.println("Atualizar avaliação");
                                    avaliacaoService.listarAvaliacoes();
                                    //Atualizar avaliação
                                    System.out.println("Digite os id/index pertencente a publicação: ");
                                    System.out.println("Id do item: ");
                                    Integer idItem = scanner.nextInt();
                                    System.out.println("Id do usuário");
                                    Integer idUsuario = scanner.nextInt();
                                    scanner.nextLine();

                                    Atualizar.atualizarAvaliacao(avaliacaoService, idUsuario, idItem, scanner);
                                }
                                case 3 -> {
                                    System.out.println("Deletar avaliação !");
                                    //Deletar avaliação
                                    System.out.println("Digite os id/index pertencente a publicação: ");
                                    System.out.println("Id do item: ");
                                    Integer idItem = scanner.nextInt();
                                    System.out.println("Id do usuário");
                                    Integer idUsuario = scanner.nextInt();
                                    Deletar.deletarAvaliacao(idUsuario, idItem, avaliacaoService);
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
                        usuarioService.listarUsuarios();

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
                                    usuarioService.listarUsuarios();
                                    System.out.println("Digite o Id do cliente que deseja tornar administrador:");
                                    Integer idUsuario = scanner.nextInt();
                                    Atualizar.tornarClienteAdmin(usuarioService, idUsuario, usuario);
                                }
                                case 2 -> {
                                    System.out.println("Atualizar usuário");
                                    usuarioService.listarUsuarios();
                                    //Atualizar Usuario
                                    System.out.println("Digite o id do usuário que deseja atualizar");
                                    Integer idUsuario = scanner.nextInt();
                                    scanner.nextLine();
                                    Atualizar.atualizarQualquerUsuario(usuarioService, idUsuario, usuario, scanner);
                                }
                                case 3 -> {
                                    System.out.println("Deletar usuário !");
                                    //Deletar Usuario
                                    usuarioService.listarUsuarios();
                                    System.out.println("Digite o id/index que deseja deletar");
                                    Integer index = scanner.nextInt();
                                    Deletar.deletarQualquerUsuario(index, usuarioService, usuario);
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
                        Buscar.buscarItens(itemService, filtro, scanner);
                    }
                    case 9 -> {
                        System.out.println("<---");
                    }
                    default -> {
                        System.err.println("Opção invalida, digite novamente.");
                    }
                }
            }catch (InputMismatchException ex){
                System.err.println("Erro na digitação");
                scanner.nextLine();
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }


    //
    public static void menuCliente(AssistidosService assistidosService, ItemService itemService, AvaliacaoService avaliacaoService, Usuario usuarioLogado, Scanner scanner){
        Filtro filtro = new Filtro();

        int listaSelecionada = 0;

        while (listaSelecionada != 9) {

            try{

                int metodoSelecionado = 0;

                System.out.println("**Menu Cliente**");
                System.out.println("[1] Buscar filmes e series");
                System.out.println("[2] Itens assistidos");
                System.out.println("[3] Avaliações");
                System.out.println("[9] Voltar!");


                listaSelecionada = scanner.nextInt();
                //scanner.nextLine();

                switch (listaSelecionada) {
                    case 1 -> {
                        Buscar.buscarItens(itemService, filtro, scanner);
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
                                assistidosService.listarAssistidos(usuarioLogado.getId());
                            }
                            case 2 -> {
                                itemService.listarItens();
                                System.out.println("Qual o ID do item que deseja marcar como assistido?");
                                Integer marcarAssistido = scanner.nextInt();
                                scanner.nextLine();
                                assistidosService.marcarAssistido(usuarioLogado.getId(),marcarAssistido);
                            }
                            case 3 -> {
                                assistidosService.listarAssistidos(usuarioLogado.getId());
                                System.out.println("Qual o ID do item assistido que deseja excluir?");
                                Integer excluirAssistido = scanner.nextInt();
                                scanner.nextLine();
                                assistidosService.deletarAssistidos(excluirAssistido, usuarioLogado.getId());
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
                                avaliacaoService.listarAvaliacoesUsuario(usuarioLogado.getId());
                            }
                            case 2 -> {
                                System.out.println("Criar Avaliação");
                                //Criar Avaliação
                                itemService.listarItens();
                                System.out.println("Digite o index do filme que deseja avaliar:");
                                Integer index = scanner.nextInt();
                                Criar.criarAvaliacao(avaliacaoService, usuarioLogado, index, scanner);
                            }
                            case 3 -> {
                                avaliacaoService.listarAvaliacoesUsuario(usuarioLogado.getId());
                                System.out.println("Atualizar avaliação");
                                //Atualizar avaliação
                                System.out.println("Digite o id/index que deseja atualizar");
                                Integer index = scanner.nextInt();
                                scanner.nextLine();
                                Atualizar.atualizarAvaliacao(avaliacaoService, usuarioLogado.getId(), index, scanner);
                            }
                            case 4 -> {

                                System.out.println("Deletar avaliação !");
                                //Deletar avaliação
                                System.out.println("Digite o id/index que deseja deletar");
                                Integer index = scanner.nextInt();
                                Deletar.deletarAvaliacao(index, usuarioLogado.getId(), avaliacaoService);
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
                        System.out.println("<---");
                    }
                }
            }catch (InputMismatchException ex){
                System.err.println("Erro na digitação");
                scanner.nextLine();
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}
