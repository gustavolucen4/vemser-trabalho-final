package com.dbc.view.metodosmain.interacao;

import com.dbc.model.*;
import com.dbc.service.AvaliacaoService;
import com.dbc.service.ItemService;

import java.util.Scanner;

public class Criar {
    public static void criarFilme(ItemService itemService, Scanner scanner){

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
            System.out.println("Duração do filme (Minutos):");
            filme.setDuracao(scanner.nextLine());

            itemService.adicionarItemEntretenimento(filme);

    }

    public static void criarSerie(ItemService itemService, Scanner scanner){

        Serie serie = new Serie();
        System.out.println("Nome da série: ");
        serie.setNome(scanner.nextLine());
        System.out.println("Genero do série:");
        serie.setGenero(scanner.nextLine());
        System.out.println("Sinopse:");
        serie.setSinopse(scanner.nextLine());
        System.out.println("Ano de lançamento:");
        serie.setAnoLancamento(scanner.nextLine());
        System.out.println("Classificação");
        serie.setClassificacao(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Plataforma de streaming:");
        serie.setPlataforma(scanner.nextLine());
        System.out.println("Número de temporadas:");
        serie.setTemporadas(scanner.nextInt());
        System.out.println("Total de episódios:");
        serie.setEpisodios(scanner.nextInt());

        itemService.adicionarItemEntretenimento(serie);
    }

    public static void criarAvaliacao(AvaliacaoService avaliacaoService, Usuario usuario, Integer index, Scanner scanner){

        Avaliacao avaliacao = new Avaliacao();

        System.out.println("Digite a nota do item (0 a 10):");
        avaliacao.setNota(scanner.nextDouble());
        scanner.nextLine();

        System.out.println("Deixe seu comentário sobre o item:");
        avaliacao.setComentario(scanner.nextLine());

        avaliacaoService.adicionarAvaliacao(avaliacao, usuario.getId(), index);
    }
}
