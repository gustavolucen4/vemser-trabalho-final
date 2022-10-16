package com.dbc.view.metodosmain.interacao;

import com.dbc.model.Filtro;
import com.dbc.service.ItemService;

import java.util.Scanner;

public class Buscar {
    public static void buscarItens(ItemService itemService, Filtro filtro, Scanner scanner){
        while (true) {
            System.out.println("O que você deseja assistir hoje? \nFilme ou Série.");
            filtro.setTipo(scanner.nextLine());
            System.out.println("Escolha um gênero: \nAcao, Romance, Fantasia, Animacao, Ficcao");
            filtro.setGenero(scanner.nextLine());
            System.out.println("Qual a Classificação Indicativa desejada? (10,12,14,16 ou 18)");
            filtro.setClassificacao(scanner.nextInt());
            scanner.nextLine();

            if (itemService.filtrarItemEntretenimento(filtro)){
                break;
            }else{
                System.out.println("Nenhum item encontrado");
                System.out.println("Procurar novamente ? sim[1] não[2]");
                int confirmacao = scanner.nextInt();
                if (confirmacao != 1){
                    System.out.println("<---");
                    break;
                }
            }
        }
    }
}
