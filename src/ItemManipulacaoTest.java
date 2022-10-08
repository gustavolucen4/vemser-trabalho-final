import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ItemManipulacaoTest {
    private ItemManipulacao itemManipulacao;

    @BeforeEach
    public void init(){
        itemManipulacao = new ItemManipulacao();
    }

    @Test
    public void deveRetornarMelhoresAvaliacoes() {
        Avaliacao avaliacao1 = new Avaliacao();
        avaliacao1.setNota(10.0);

        Avaliacao avaliacao2 = new Avaliacao();
        avaliacao2.setNota(10.0);

        List<Avaliacao> avaliacaoList = new ArrayList<>();
        avaliacaoList.add(avaliacao1);
        avaliacaoList.add(avaliacao2);


        List<Avaliacao> retorno = itemManipulacao.filtrarMelhoresAvaliacoes();

        assertEquals(retorno, avaliacaoList);
    }
}
