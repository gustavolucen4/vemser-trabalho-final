import entidades.Usuario;
import interfacesenum.TipoUsuario;
import manipulacao.AssistidosManipulacao;
import manipulacao.AvaliacaoManipulacao;
import manipulacao.ItemManipulacao;
import manipulacao.UsuarioManipulacao;
import metodosmain.Menu;
import metodosmain.PreencherLista;
import metodosmain.interacao.Login;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        ItemManipulacao itemManipulacao = new ItemManipulacao();
        UsuarioManipulacao usuarioManipulacao = new UsuarioManipulacao();
        AssistidosManipulacao assistidosManipulacao = new AssistidosManipulacao(itemManipulacao);
        AvaliacaoManipulacao avaliacaoManipulacao = new AvaliacaoManipulacao();

        Usuario usuarioLogado;

        //Metodo preencher listas DB
        PreencherLista.preencherFilmes(itemManipulacao);
        PreencherLista.preencherSeries(itemManipulacao);
        PreencherLista.preencherAdmins(usuarioManipulacao);
        PreencherLista.preencherClientes(usuarioManipulacao);


        while (true) {
        //Metodo login usuario/adim
        usuarioLogado = Login.login(usuarioManipulacao, scanner);
        System.out.println(usuarioLogado.getTipoUsuario().getDescricao());


            if (usuarioLogado.getTipoUsuario().getDescricao().equals(TipoUsuario.CLIENTE.getDescricao())) {
                //Menu do Cliente
                Menu.menuCliente(assistidosManipulacao, itemManipulacao, avaliacaoManipulacao, usuarioLogado, scanner);
            } else {
                //Menu do Admin
                Menu.menuAdmin(usuarioManipulacao, itemManipulacao, avaliacaoManipulacao, usuarioLogado, scanner);
            }
        }
    }
}