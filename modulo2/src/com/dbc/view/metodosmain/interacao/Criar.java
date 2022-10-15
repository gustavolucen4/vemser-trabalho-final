package com.dbc.view.metodosmain.interacao;

import entidades.*;
import manipulacao.AvaliacaoManipulacao;
import manipulacao.ItemManipulacao;

import java.util.Scanner;

public class Criar {
    public static void criarFilme(ItemManipulacao itemManipulacao, Scanner scanner){

            Filme filme = new Filme();
            System.out.println("Nome do filme: ");
            filme.setNome(scanner.nextLine());
            System.out.println("Genero do filme:");
            filme.setGenero(scanner.nextLine());
            System.out.println("Sinopse:");
            filme.setSinopse(scanner.nextLine());
            System.out.println("Ano de lançamento:");
            filme.setAnoLancamento(scanner.nextLine());
            System.out.println("Classificação");
            filme.setClassificacao(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Plataforma de streaming:");
            filme.setPlataforma(scanner.nextLine());
            System.out.println("Duração fo filme (Minutos):");
            filme.setDuracao(scanner.nextLine());

            itemManipulacao.criarItemEntretenimento(filme);

    }

    public static void criarSerie(ItemManipulacao itemManipulacao, Scanner scanner){

        Serie serie = new Serie();
        System.out.println("Nome do série: ");
        serie.setNome(scanner.nextLine());
        System.out.println("Genero do série:");
        serie.setGenero(scanner.nextLine());
        System.out.println("Sinopse:");
        serie.setSinopse(scanner.nextLine());
        System.out.println("Ano de lançamento:");
        serie.setClassificacao(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Plataforma de streaming:");
        serie.setPlataforma(scanner.nextLine());
        System.out.println("Número de temporadas:");
        serie.setTemporadas(scanner.nextInt());
        System.out.println("Total de episódios:");
        serie.setEpisodios(scanner.nextInt());

        itemManipulacao.criarItemEntretenimento(serie);
    }

    public static void criarAvaliacao(ItemManipulacao itemManipulacao, AvaliacaoManipulacao avaliacaoManipulacao, Usuario usuario, Integer index, Scanner scanner){

        ItemEntretenimento itemEntretenimento = itemManipulacao.getEntretenimentoList().get(index);

        if(itemEntretenimento != null){
            Avaliacao avaliacao = new Avaliacao();
            avaliacao.setUsuario(usuario);
            avaliacao.setItemEntretenimento(itemEntretenimento);

            System.out.println("Digite a nota do item (0 a 10):");
            avaliacao.setNota(scanner.nextDouble());
            scanner.nextLine();

            System.out.println("Deixe seu comentário sobre o item:");
            avaliacao.setComentario(scanner.nextLine());

            avaliacaoManipulacao.criarAvaliacao(avaliacao);
        }
    }
}
