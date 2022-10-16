package com.dbc.view.metodosmain.interacao;

import com.dbc.model.ItemEntretenimento;
import com.dbc.model.Usuario;
import com.dbc.service.ItemService;
import entidades.*;
import manipulacao.AvaliacaoManipulacao;
import manipulacao.ItemManipulacao;

import java.util.Scanner;

public class Criar {
    public static void criarFilme(ItemService itemService, Scanner scanner){

        ItemEntretenimento itemEntretenimento = new ItemEntretenimento();
        System.out.println("Nome do filme: ");
        itemEntretenimento.setNome(scanner.nextLine());
        System.out.println("Genero do filme:");
        itemEntretenimento.setGenero(scanner.nextLine());
        System.out.println("Sinopse:");
        itemEntretenimento.setSinopse(scanner.nextLine());
        System.out.println("Classificação:");
        itemEntretenimento.setClassificacao(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Ano de lançamento:");
        itemEntretenimento.setAnoLancamento(scanner.nextLine());
        System.out.println("Plataforma de streaming:");
        itemEntretenimento.setPlataforma(scanner.nextLine());
        System.out.println("Duração do filme (Minutos):");
        itemEntretenimento.setDuracao(scanner.nextLine());

        itemService.adicionarItemEntretenimento(itemEntretenimento);

    }

    public static void criarSerie(ItemService itemService, Scanner scanner){

        ItemEntretenimento itemEntretenimento = new ItemEntretenimento();
        System.out.println("Nome do série: ");
        itemEntretenimento.setNome(scanner.nextLine());
        System.out.println("Genero do série:");
        itemEntretenimento.setGenero(scanner.nextLine());
        System.out.println("Sinopse:");
        itemEntretenimento.setSinopse(scanner.nextLine());
        System.out.println("Ano de lançamento:");
        itemEntretenimento.setAnoLancamento(scanner.next());
        scanner.nextLine();
        System.out.println("Plataforma de streaming:");
        itemEntretenimento.setPlataforma(scanner.nextLine());
        System.out.println("Número de temporadas:");
        itemEntretenimento.setTemporadas(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Total de episódios:");
        itemEntretenimento.setEpisodios(scanner.nextInt());
        scanner.nextLine();

        itemService.adicionarItemEntretenimento(itemEntretenimento);
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
