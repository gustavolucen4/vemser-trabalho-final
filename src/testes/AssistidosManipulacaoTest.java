package testes;

import entidades.Avaliacao;
import entidades.Filme;
import entidades.ItemEntretenimento;
import manipulacao.AssistidosManipulacao;
import manipulacao.ItemManipulacao;
import metodosmain.interacao.Deletar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssistidosManipulacaoTest {

    @BeforeEach
    public void init() {
    }


    @Test
    public void deveTestarMarcarAssistidos() {
        AssistidosManipulacao assistidosManipulacao;
        ItemEntretenimento itemEntretenimento;
        ItemManipulacao itemManipulacao;
        List<AssistidosManipulacao> assistidosManipulacaoList;
        itemManipulacao = new ItemManipulacao();
        assistidosManipulacao = new AssistidosManipulacao(itemManipulacao);
        itemEntretenimento = new ItemEntretenimento("Duro de matar", "Ação");

        itemManipulacao.criarItemEntretenimento(itemEntretenimento);
        boolean assistidos = assistidosManipulacao.marcarAssistido(0);

        assertTrue(assistidos);
    }


    @Test
    public void deveTestarDeletarAssistidosPorIndice() {

        ItemEntretenimento itemEntretenimento = new Filme("nome1", "genero1", "60");
        ItemManipulacao itemManipulacao = new ItemManipulacao();

//        List<AssistidosManipulacao> assistidosList = new ArrayList<>();

        AssistidosManipulacao assistidosManipulacao = new AssistidosManipulacao(itemManipulacao);
        itemManipulacao.criarItemEntretenimento(itemEntretenimento);


        // metodos

        boolean verificar = assistidosManipulacao.deletarAssistido(0);

        //asserts
        assertFalse(verificar);
    }

    @Test
    public void deveTestarListarAssistidos() {
        AssistidosManipulacao assistidosManipulacao;
        ItemEntretenimento itemEntretenimento;
        ItemManipulacao itemManipulacao;
        List<AssistidosManipulacao> listaAssistidos;
        itemManipulacao = new ItemManipulacao();
        assistidosManipulacao = new AssistidosManipulacao(itemManipulacao);
        itemEntretenimento = new ItemEntretenimento("Duro de matar", "Ação");

        boolean assistidos = assistidosManipulacao.listarAssistidos();

        assertTrue(assistidos);
    }

    @Test
    public void deveTestarIncluirIndicacao() {
        AssistidosManipulacao assistidosManipulacao;
        ItemEntretenimento itemEntretenimento;
        ItemManipulacao itemManipulacao;
        List<AssistidosManipulacao> listaAssistidos;
        itemManipulacao = new ItemManipulacao();
        assistidosManipulacao = new AssistidosManipulacao(itemManipulacao);
        itemEntretenimento = new ItemEntretenimento("Duro de matar", "Ação");

        boolean inclusaoIndicacao = assistidosManipulacao.incluirIndicacao(itemEntretenimento);

        assertTrue(inclusaoIndicacao);
    }
}
