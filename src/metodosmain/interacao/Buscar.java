package metodosmain.interacao;

import entidades.Filtro;
import entidades.ItemEntretenimento;
import manipulacao.ItemManipulacao;

import java.util.List;
import java.util.Scanner;

public class Buscar {
    public static void buscarItens(ItemManipulacao itemManipulacao, Filtro filtro, Scanner scanner){
        while (true) {
            System.out.println("O que você deseja assistir hoje? \nFilme ou Série.");
            filtro.setTipo(scanner.nextLine());
            System.out.println("Escolha um gênero: \nAcao, Romance, Fantasia, Animacao, Ficcao");
            filtro.setGenero(scanner.nextLine());
            System.out.println("Qual a Classificação Indicativa desejada? (10,12,14,16 ou 18)");
            filtro.setClassificacao(scanner.nextInt());
            scanner.nextLine();

            List<ItemEntretenimento> resultado = itemManipulacao.filtrarItemEntretenimento(filtro);

            if (resultado != null){
                System.out.println("buscando...");
                resultado.forEach(item -> item.imprimir());
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
