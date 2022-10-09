import entidades.Cliente;
import entidades.Filtro;
import entidades.ItemEntretenimento;
import entidades.Usuario;
import interfacesenum.TipoUsuario;
import manipulacao.AssistidosManipulacao;
import manipulacao.AvaliacaoManipulacao;
import manipulacao.ItemManipulacao;
import manipulacao.UsuarioManipulacao;
import metodosmain.Login;
import metodosmain.Menu;
import metodosmain.PreencherLista;
import org.w3c.dom.ls.LSOutput;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        AvaliacaoManipulacao avaliacaoManipulacao = new AvaliacaoManipulacao();
        ItemManipulacao itemManipulacao = new ItemManipulacao();
        UsuarioManipulacao usuarioManipulacao = new UsuarioManipulacao();
        AssistidosManipulacao assistidosManipulacao = new AssistidosManipulacao(itemManipulacao);

        Usuario usuarioLogado = new Cliente();

        Filtro filtro = new Filtro();

        //Metodo preencher listas DB
        PreencherLista.preencherFilmes(itemManipulacao);
        PreencherLista.preencherSeries(itemManipulacao);
        PreencherLista.preencherAdmins(usuarioManipulacao);
        PreencherLista.preencherClientes(usuarioManipulacao);

        usuarioManipulacao.listarUsuarios();
        itemManipulacao.listarItemEntretenimento();


        //Metodo login usuario/adim
        usuarioLogado = Login.login(usuarioManipulacao);


        //if(usuarioManipulacao)
        if (usuarioLogado.getTipoUsuario().equals(TipoUsuario.CLIENTE)) {

        } else {
            Menu.menuAdmin(usuarioManipulacao, itemManipulacao, avaliacaoManipulacao);
        }


        //

        //Menu do Cliente

        System.out.println();


        System.out.println("Menu Cliente:");
        System.out.println("[1] Itens assistidos");
        System.out.println("[2] Avaliações");


        int opcaoMenuCliente = scanner.nextInt();
        scanner.nextLine();

        switch (opcaoMenuCliente) {
            case 1 -> {
                System.out.println("[1] Listar itens assistidos");
                System.out.println("[2] Marcar item assistido");
                System.out.println("[3] Deletar itens assistidos");
                int opcaoMenuClienteItensAssistidos = scanner.nextInt();
                scanner.nextLine();
                switch (opcaoMenuClienteItensAssistidos) {
                    case 1 -> {
                        assistidosManipulacao.listarAssistidos();
                    }
                    case 2 -> {
                        assistidosManipulacao.listarAssistidos();
                        System.out.println("Qual o ID do item que deseja marcar como assistido?");
                        Integer marcarAssistido = scanner.nextInt();
                        scanner.nextLine();
                        assistidosManipulacao.marcarAssistido(marcarAssistido);
                    }
                    case 3 -> {
                        assistidosManipulacao.listarAssistidos();
                        System.out.println("Qual o ID do item assistido que deseja excluir?");
                        Integer excluirAssistido = scanner.nextInt();
                        scanner.nextLine();
                        assistidosManipulacao.deletarAssistido(excluirAssistido);
                    }
                }
            }
            case 2 -> {
                System.out.println("[1] Listar avaliações");
                System.out.println("[2] Adicionar avaliações");
                System.out.println("[3] Editar avaliações");
                System.out.println("[4] Deletar avaliações");
            }
        }


        //Menu do Admin


        //Filtro(Buscar Indicacao)
        while (true) {
            System.out.println("O que você deseja assistir hoje? \n[1]Filme. \n[2]Série.");
            int tipoItemEntretenimento = scanner.nextInt();
            scanner.nextLine();

            if (tipoItemEntretenimento == 1) {
                System.out.println("Escolha um gênero:");
                System.out.println("[1]Ação");
                System.out.println("[2]Romance");
                System.out.println("[3]Fantasia");
                System.out.println("[4]Animação");
                System.out.println("[5]Ficção Cientifica");

                int generoEscolhido = scanner.nextInt();
                switch (generoEscolhido){
                    case 1 -> {
                        filtro.setGenero("Acao");
                    }
                    case 2 -> {
                        filtro.setGenero("Romance");
                    }
                    case 3 -> {
                        filtro.setGenero("Fantasia");
                    }
                    case 4 -> {
                        filtro.setGenero("Animacao");
                    }
                    case 5 -> {
                        filtro.setGenero("Ficcao");
                    }
                }
                System.out.println("Qual a Classificação Indicativa desejada? (10,12,14,16 ou 18)");
                int classificacaoEscolhida = scanner.nextInt();
                scanner.nextLine();
                filtro.setClassificacao(classificacaoEscolhida);

               // ItemEntretenimento buscaFilme = itemManipulacao.filtrarItemEntretenimento();

                    break;
            }
            if (tipoItemEntretenimento == 2) {
                System.out.println("Escolha um gênero:");
                System.out.println("[1]Drama");
                System.out.println("[2]Comédia");
                System.out.println("[3]Suspense");
                System.out.println("[4]Aventura");
                System.out.println("[5]Terror");
                System.out.println("[6]Ação");

                int generoEscolhido = scanner.nextInt();
                switch (generoEscolhido){
                    case 1 -> {
                        filtro.setGenero("Drama");
                    }
                    case 2 -> {
                        filtro.setGenero("Comedia");
                    }
                    case 3 -> {
                        filtro.setGenero("Suspense");
                    }
                    case 4 -> {
                        filtro.setGenero("Aventura");
                    }
                    case 5 -> {
                        filtro.setGenero("Terror");
                    }
                    case 6 -> {
                        filtro.setGenero("Acao");
                    }

                }
                System.out.println("Qual a Classificação Indicativa desejada? (10,12,14,16 ou 18)");
                int classificacaoEscolhida = scanner.nextInt();
                scanner.nextLine();
                filtro.setClassificacao(classificacaoEscolhida);

                //ItemEntretenimento buscaFilme = itemManipulacao.filtrarItemEntretenimento();

                    break;
            } else {
                System.out.println("Opção informada inválida. Favor escolher entre FILME [1] ou SÉRIE [2].");
            }

        }

    }
}