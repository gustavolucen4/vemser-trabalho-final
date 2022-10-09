package metodosmain.interacao;

import entidades.*;
import interfacesenum.TipoUsuario;
import manipulacao.AvaliacaoManipulacao;
import manipulacao.ItemManipulacao;
import manipulacao.UsuarioManipulacao;

import java.util.Optional;
import java.util.Scanner;

public class Atualizar {

    public static void atualizarFilme(Integer index,ItemManipulacao itemManipulacao, Scanner scanner){

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
        System.out.println("Duração fo filme (Minutos):");
        filme.setDuracao(scanner.nextLine());

        itemManipulacao.editarItemEntretenimento(index ,filme);

    }

    public static void atualizarSerie(Integer index,ItemManipulacao itemManipulacao, Scanner scanner){

        Filme filme = new Filme();
        System.out.println("Nome do filme: ");
        filme.setNome(scanner.nextLine());
        System.out.println("Genero do filme:");
        filme.setGenero(scanner.nextLine());
        System.out.println("Sinopse:");
        filme.setSinopse(scanner.nextLine());
        System.out.println("Ano de lançamento:");
        filme.setClassificacao(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Plataforma de streaming:");
        filme.setPlataforma(scanner.nextLine());
        System.out.println("Duração fo filme (Minutos):");
        filme.setDuracao(scanner.nextLine());

        itemManipulacao.editarItemEntretenimento(index ,filme);

    }

    public static void atualizarAvaliacao(ItemManipulacao itemManipulacao, AvaliacaoManipulacao avaliacaoManipulacao, Usuario usuario, Integer index, Scanner scanner){
        Avaliacao procurarAvaliacao = avaliacaoManipulacao.getAvaliacoes().get(index);

        if(procurarAvaliacao.getUsuario().getEmail().equals(usuario.getEmail())){
            Avaliacao avaliacao = new Avaliacao();

            System.out.println("Digite a nota do filme (0 a 10):");
            avaliacao.setNota(scanner.nextDouble());
            scanner.nextLine();

            System.out.println("Deixe seu comentário sobre o filme:");
            avaliacao.setComentario(scanner.nextLine());

            avaliacaoManipulacao.editarAvaliacoes(index, avaliacao);
        }
    }

    public static void tornarClienteAdmin(UsuarioManipulacao usuarioManipulacao, String emailCliente, Usuario admin){
        Optional<Usuario> usuario = usuarioManipulacao.getUsuariosLista().stream()
                .filter(user -> user.getEmail().equalsIgnoreCase(emailCliente))
                .findFirst();

        if (usuario.isPresent()){
            admin.setUsuarioAdmin(usuario.get());
            System.out.println(usuario.get().getEmail()+" agora é um administrador!");
        }else {
            System.out.println("Usuario não encontrado");
        }
    }


    public static void atualizarQualquerUsuario(UsuarioManipulacao usuarioManipulacao, String emailCliente, Usuario admin, Scanner scanner){

        Optional<Usuario> usuario = usuarioManipulacao.getUsuariosLista().stream()
                .filter(user -> user.getEmail().equalsIgnoreCase(emailCliente))
                .findFirst();

        if (admin.getTipoUsuario().equals(TipoUsuario.ADIMINISTRADOR) && usuario.isPresent()){

            Usuario usuarioEntrada = usuario.get();

            System.out.println("Preencha os seguintes dados: ");
            System.out.println("\nNome: ");
            String nome = scanner.nextLine();
            usuarioEntrada.setNome(nome);

            System.out.println("\nIdade: ");
            int idade = scanner.nextInt();
            scanner.nextLine();
            usuarioEntrada.setIdade(idade);

            System.out.println("Email: ");
            String email = scanner.nextLine();
            usuarioEntrada.setEmail(email);

            System.out.println("\nSenha: ");
            String senha = scanner.nextLine();
            usuarioEntrada.setSenha(senha);

            usuarioManipulacao.editarUsuario(usuarioEntrada.getId(), usuarioEntrada);

        }else {
            System.out.println("Usuario não encontrado");
        }
    }

    public static void atualizarUsuario(UsuarioManipulacao usuarioManipulacao, Usuario usuarioLogado, Scanner scanner){

        if (usuarioLogado != null){
            Usuario usuarioEntrada = usuarioLogado;

            System.out.println("Preencha os seguintes dados: ");
            System.out.println("\nNome: ");
            String nome = scanner.nextLine();
            usuarioEntrada.setNome(nome);

            System.out.println("\nIdade: ");
            int idade = scanner.nextInt();
            scanner.nextLine();
            usuarioEntrada.setIdade(idade);

            System.out.println("Email: ");
            String email = scanner.nextLine();
            usuarioEntrada.setEmail(email);

            System.out.println("\nSenha: ");
            String senha = scanner.nextLine();
            usuarioEntrada.setSenha(senha);

            usuarioManipulacao.editarUsuario(usuarioLogado.getIdade(), usuarioEntrada);
        }else {
            System.out.println("Usuario não encontrado");
        }
    }

}
