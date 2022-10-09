package testes;

import entidades.Avaliacao;
import entidades.Cliente;
import entidades.ItemEntretenimento;
import entidades.Usuario;
import manipulacao.AvaliacaoManipulacao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AvaliacaoManipulacaoTest {

    private AvaliacaoManipulacao avaliacaoManipulacao;
    private Avaliacao avaliacao;
    private Usuario usuario;
    private ItemEntretenimento itemEntretenimento;

    @BeforeEach
    public void init(){
        avaliacaoManipulacao = new AvaliacaoManipulacao();
        avaliacao = new Avaliacao();
        usuario = new Cliente();
        itemEntretenimento = new ItemEntretenimento("Duro de matar", "Ação");
    }

    @Test
    public void deveTestarAdiconarAvaliacao(){

        avaliacao.setItemEntretenimento(avaliacao.getItemEntretenimento());
        avaliacao.setNota(7.5);
        avaliacao.setComentario("Muito bom!");

        boolean adicionarAvaliacao = avaliacaoManipulacao.criarAvaliacao(avaliacao);

        assertTrue (adicionarAvaliacao);
    }

    @Test
    public void deveTestarListarAvaliacao(){

        boolean listarAvaliacoes = avaliacaoManipulacao.listarAvaliacoes();

        assertTrue (listarAvaliacoes);
    }

    @Test
    public void deveTestarEditarAvaliacao(){

        avaliacaoManipulacao.criarAvaliacao(new Avaliacao());

        usuario.setNome("Gaby");
        avaliacao.setUsuario(usuario);
        avaliacao.setItemEntretenimento(itemEntretenimento);
        avaliacao.setNota(7.5);
        avaliacao.setComentario("Muito bom!");

        boolean editarAvaliacoes = false;
        editarAvaliacoes = avaliacaoManipulacao.editarAvaliacoes(0,avaliacao);

        assertTrue (editarAvaliacoes);
    }

    @Test
    public void deveTestarDeletarAvaliacao(){

        avaliacaoManipulacao.criarAvaliacao(new Avaliacao());

        boolean deletarAvaliacoes = false;
        deletarAvaliacoes = avaliacaoManipulacao.deletarAvaliacoes(0);

        assertTrue (deletarAvaliacoes);

    }

}
