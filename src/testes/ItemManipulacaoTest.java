package testes;

import entidades.Avaliacao;
import entidades.Filtro;
import entidades.ItemEntretenimento;
import manipulacao.ItemManipulacao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ItemManipulacaoTest {

    @BeforeEach
    public void init(){}

    @Test
    public void deveRetornarlistarMediaAvaliacao() {
        ItemManipulacao itemManipulacao;
        ItemEntretenimento novoItem;
        Avaliacao avaliacao1;
        Avaliacao avaliacao2;
        novoItem = new ItemEntretenimento("Durinho de Matar", "Terror");
        itemManipulacao = new ItemManipulacao();
        avaliacao1 = new Avaliacao();
        avaliacao2 = new Avaliacao();
        avaliacao1.setNota(10.0);
        avaliacao2.setNota(10.0);
        novoItem.adicionarAvaliacao(avaliacao1);
        novoItem.adicionarAvaliacao(avaliacao2);
        itemManipulacao.criarItemEntretenimento(novoItem);

        boolean resultado = true;

        Double media = itemManipulacao.listarMediaAvaliacao(0);

        if (media == null){
            resultado = false;
        }

        assertTrue(resultado);
        assertEquals(media, 10.0);
    }

    @Test
    public void deveRetornarFiltroEntretenimento(){
        final int CLASSIFICACAO_FILME1 = 18;
        ItemManipulacao itemManipulacao;
        ItemEntretenimento novoItem;
        ItemEntretenimento novoItem2;
        Avaliacao avaliacao1;
        Avaliacao avaliacao2;
        novoItem = new ItemEntretenimento("Durinho de Matar", "Terror");
        novoItem2 = new ItemEntretenimento("Durinho de Matar 2", "Terror");
        itemManipulacao = new ItemManipulacao();
        avaliacao1 = new Avaliacao();
        avaliacao2 = new Avaliacao();
        avaliacao1.setNota(10.0);
        avaliacao2.setNota(10.0);
        novoItem.adicionarAvaliacao(avaliacao1);
        novoItem.adicionarAvaliacao(avaliacao2);
        novoItem.setClassificacao(CLASSIFICACAO_FILME1);
        novoItem.setTipo("entidades.Filme");
        novoItem2.setClassificacao(10);
        novoItem2.setTipo("entidades.Filme");
        itemManipulacao.criarItemEntretenimento(novoItem);
        itemManipulacao.criarItemEntretenimento(novoItem2);

        boolean verificar = true;

        List<ItemEntretenimento> retorno = itemManipulacao.filtrarItemEntretenimento(new Filtro("entidades.Filme", "Terror", 15));
        retorno.forEach(item -> item.imprimir());
        if(retorno == null){
            verificar = false;
        }

        assertTrue(verificar);
    }

    @Test
    public void deveTestarDeletarItemEntretenimentoPorIndice(){
        ItemManipulacao itemManipulacao;
        ItemEntretenimento novoItem;
        Avaliacao avaliacao1;
        Avaliacao avaliacao2;
        novoItem = new ItemEntretenimento("Durinho de Matar", "Terror");
        itemManipulacao = new ItemManipulacao();
        avaliacao1 = new Avaliacao();
        avaliacao2 = new Avaliacao();
        avaliacao1.setNota(10.0);
        avaliacao2.setNota(10.0);
        novoItem.adicionarAvaliacao(avaliacao1);
        novoItem.adicionarAvaliacao(avaliacao2);
        Integer index = 0;
        itemManipulacao.criarItemEntretenimento(novoItem);

        boolean verificar = itemManipulacao.deletarItemEntretenimentoPorIndice(index);

        assertTrue(verificar);
    }

    @Test
    public void deveTestarListarItemEntretenimento(){
        ItemManipulacao itemManipulacao;
        ItemEntretenimento novoItem;
        ItemEntretenimento novoItem2;
        Avaliacao avaliacao1;
        Avaliacao avaliacao2;
        novoItem = new ItemEntretenimento("Durinho de Matar", "Terror");
        novoItem2 = new ItemEntretenimento("Durinho de Matar 2", "Terror");
        itemManipulacao = new ItemManipulacao();
        avaliacao1 = new Avaliacao();
        avaliacao2 = new Avaliacao();
        avaliacao1.setNota(10.0);
        avaliacao2.setNota(10.0);
        novoItem.adicionarAvaliacao(avaliacao1);
        novoItem.adicionarAvaliacao(avaliacao2);

        boolean listarItemEntretenimento = itemManipulacao.listarItemEntretenimento();

        assertTrue(listarItemEntretenimento);

    }


    @Test
    public void deveTestarEditarItemEntretenimento(){
        ItemManipulacao itemManipulacao;
        ItemEntretenimento novoItem;
        ItemEntretenimento novoItem2;
        Avaliacao avaliacao1;
        Avaliacao avaliacao2;
        novoItem = new ItemEntretenimento("Durinho de Matar", "Terror");
        novoItem2 = new ItemEntretenimento("Durinho de Matar 2", "Terror");
        itemManipulacao = new ItemManipulacao();
        avaliacao1 = new Avaliacao();
        avaliacao2 = new Avaliacao();
        avaliacao1.setNota(10.0);
        avaliacao2.setNota(10.0);
        novoItem.adicionarAvaliacao(avaliacao1);
        novoItem.adicionarAvaliacao(avaliacao2);

        itemManipulacao.criarItemEntretenimento(new ItemEntretenimento());

        novoItem.setNome("Um filme diferente");
        novoItem.setGenero("Comédia");
        novoItem.setSinopse("balblalblalblalalalal");
        novoItem.setAnoLancamento("2022");
        novoItem.setClassificacao(18);
        novoItem.setPlataforma("Youtube");

        boolean resultado = itemManipulacao.editarItemEntretenimento(0, novoItem);

        System.out.println("Item " + novoItem.getId() + " editado!");
        assertTrue (resultado);
    }

}
