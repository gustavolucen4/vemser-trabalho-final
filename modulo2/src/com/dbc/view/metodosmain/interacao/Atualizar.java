package com.dbc.view.metodosmain.interacao;


import com.dbc.enums.TipoUsuario;
import com.dbc.model.Avaliacao;
import com.dbc.model.Filme;
import com.dbc.model.Serie;
import com.dbc.model.Usuario;
import com.dbc.service.AvaliacaoService;
import com.dbc.service.ItemService;
import com.dbc.service.UsuarioService;

import java.util.Scanner;

public class Atualizar {

    public static void atualizarFilme(Integer index, ItemService itemService, Scanner scanner){

        Filme filme = new Filme();
        System.out.println("Nome do filme: ");
        filme.setNome(scanner.nextLine());
        System.out.println("Genero do filme:");
        filme.setGenero(scanner.nextLine());
        System.out.println("Sinopse:");
        filme.setSinopse(scanner.nextLine());
        System.out.println("Classificação:");
        filme.setClassificacao(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Ano de lançamento:");
        filme.setAnoLancamento(scanner.nextLine());
        System.out.println("Plataforma de streaming:");
        filme.setPlataforma(scanner.nextLine());
        System.out.println("Duração do filme (Minutos):");
        filme.setDuracao(scanner.nextLine());

        itemService.editarItemEntretenimento(index, filme);
    }

    public static void atualizarSerie(Integer index, ItemService itemService, Scanner scanner) {

        Serie serie = new Serie();
        System.out.println("Nome da Serie: ");
        serie.setNome(scanner.nextLine());
        System.out.println("Genero da Serie:");
        serie.setGenero(scanner.nextLine());
        System.out.println("Sinopse:");
        serie.setSinopse(scanner.nextLine());
        System.out.println("Ano de lançamento:");
        serie.setClassificacao(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Plataforma de streaming:");
        serie.setPlataforma(scanner.nextLine());
        System.out.println("Quantos episodios ?:");
        serie.setEpisodios(scanner.nextInt());
        System.out.println("Quantas Temporadas ?:");
        serie.setTemporadas(scanner.nextInt());

        itemService.editarItemEntretenimento(index, serie);
    }

    public static void atualizarAvaliacao(AvaliacaoService avaliacaoService, Integer idUsuario, Integer idItem, Scanner scanner){

        Avaliacao avaliacao = new Avaliacao();

        System.out.println("Digite a nota do filme (0 a 10):");
        avaliacao.setNota(scanner.nextDouble());
        scanner.nextLine();

        System.out.println("Deixe seu comentário sobre o filme:");
        avaliacao.setComentario(scanner.nextLine());

        avaliacaoService.editarAvaliacao(avaliacao, idUsuario, idItem);
    }

    public static void tornarClienteAdmin(UsuarioService usuarioService, Integer idUsuario, Usuario admin) {

        Usuario usuario = usuarioService.pegarUsuario(idUsuario);

        if (usuario != null && admin.getTipoUsuario().equals(TipoUsuario.ADMINISTRADOR)){
            admin.setUsuarioAdmin(usuario);
            usuarioService.tornarUsuarioAdmin(idUsuario);
        }else {
            System.out.println("Usuario não encontrado");
        }
    }


    public static void atualizarQualquerUsuario(UsuarioService usuarioService, Integer idUsuario, Usuario admin, Scanner scanner){

        Usuario usuario = usuarioService.pegarUsuario(idUsuario);

        if (admin.getTipoUsuario().equals(TipoUsuario.ADMINISTRADOR) && usuario != null){

            System.out.println("Preencha os seguintes dados: ");
            System.out.println("\nNome: ");
            String nome = scanner.nextLine();
            usuario.setNome(nome);

            System.out.println("\nIdade: ");
            int idade = scanner.nextInt();
            scanner.nextLine();
            usuario.setIdade(idade);

            System.out.println("Email: ");
            String email = scanner.nextLine();
            usuario.setEmail(email);

            System.out.println("\nSenha: ");
            String senha = scanner.nextLine();
            usuario.setSenha(senha);

            usuarioService.editarUsuario(usuario.getId(), usuario);

        }else {
            System.out.println("Usuario não encontrado");
        }
    }

//    public static void atualizarUsuario(UsuarioManipulacao usuarioManipulacao, Usuario usuarioLogado, Scanner scanner){
//
//        if (usuarioLogado != null){
//            Usuario usuarioEntrada = usuarioLogado;
//
//            System.out.println("Preencha os seguintes dados: ");
//            System.out.println("\nNome: ");
//            String nome = scanner.nextLine();
//            usuarioEntrada.setNome(nome);
//
//            System.out.println("\nIdade: ");
//            int idade = scanner.nextInt();
//            scanner.nextLine();
//            usuarioEntrada.setIdade(idade);
//
//            System.out.println("Email: ");
//            String email = scanner.nextLine();
//            usuarioEntrada.setEmail(email);
//
//            System.out.println("\nSenha: ");
//            String senha = scanner.nextLine();
//            usuarioEntrada.setSenha(senha);
//
//            usuarioManipulacao.editarUsuario(usuarioLogado.getIdade(), usuarioEntrada);
//        }else {
//            System.out.println("Usuario não encontrado");
//        }
//    }
//
//}
//        itemManipulacao.editarItemEntretenimento(index, filme);

    }


