package testes;

import entidades.ItemEntretenimento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssistidosManipulacaoTest {

    private AssistidosManipulacao assistidosManipulacao;
    private ItemEntretenimento itemEntretenimento;


    @BeforeEach
    public void init(){
        assistidosManipulacao = new AssistidosManipulacao();
        itemEntretenimento = new ItemEntretenimento("Duro de matar", "Ação");
    }

    @Test
    public void deveTestarMarcarAssistidos(){

        boolean assistidos = assistidosManipulacao.marcarAssistido(itemEntretenimento);

        assertTrue(assistidos);
    }

    @Test
    public void deveTestarDeletarAssistidos(){
        assistidosManipulacao.marcarAssistido(itemEntretenimento);

        boolean assistidos = assistidosManipulacao.deletarAssistido(itemEntretenimento.getId());

        assertTrue(assistidos);
    }
    @Test
    public void deveTestarListarAssistidos(){

        boolean assistidos = assistidosManipulacao.listarAssistidos();

        assertTrue(assistidos);
    }

    @Test
    public void deveTestarIncluirIndicacao(){

        boolean inclusaoIndicacao = assistidosManipulacao.incluirIndicacao(itemEntretenimento);

        assertTrue(inclusaoIndicacao);
    }

}