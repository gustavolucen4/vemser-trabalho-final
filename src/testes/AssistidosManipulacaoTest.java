package testes;


import entidades.Filme;
import entidades.ItemEntretenimento;
import manipulacao.AssistidosManipulacao;
import manipulacao.ItemManipulacao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

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
        itemManipulacao = new ItemManipulacao();
        assistidosManipulacao = new AssistidosManipulacao(itemManipulacao);
        itemEntretenimento = new ItemEntretenimento("Duro de matar", "Ação");

        itemManipulacao.criarItemEntretenimento(itemEntretenimento);
        boolean assistidos = assistidosManipulacao.marcarAssistido(0);

        assertTrue(assistidos);
    }


    @Test
    public void deveTestarListarAssistidos() {
        ItemManipulacao itemManipulacao = new ItemManipulacao();
        itemManipulacao.criarItemEntretenimento(new Filme("Duro de matar 2", "Ação", "120"));
        AssistidosManipulacao assistidosManipulacao = new AssistidosManipulacao(itemManipulacao);
        assistidosManipulacao.marcarAssistido(0);

        boolean verificar = assistidosManipulacao.listarAssistidos();

        assertTrue(verificar);
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
