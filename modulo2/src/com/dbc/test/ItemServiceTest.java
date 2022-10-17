//package com.dbc.test;
//
//import com.dbc.model.ItemEntretenimento;
//import com.dbc.service.ItemService;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//public class ItemServiceTest {
//
//    ItemService itemService;
//
//    @BeforeEach
//    public void setUp() {
//        itemService = new ItemService();
//
//    }
//
//    @Test
//    public void testarAdicionarItem() {
//        ItemEntretenimento itemEntretenimento = new ItemEntretenimento();
//        itemEntretenimento.setNome("Velozes e Furiosos");
//        itemEntretenimento.setTipo("Filme");
//        itemEntretenimento.setGenero("Ação");
//        itemEntretenimento.setSinopse("Carros em corrida");
//        itemEntretenimento.setAnoLancamento("2011");
//        itemEntretenimento.setClassificacao(16);
//        itemEntretenimento.setPlataforma("Filmes torrent");
//
//        // itemService.adicionarItemEntretenimento(itemEntretenimento);
//
//        ItemEntretenimento itemBuscado = itemService.pegar(6);
//
//        Assertions.assertEquals(itemBuscado.getNome(), itemEntretenimento.getNome());
//        Assertions.assertEquals(itemBuscado.getTipo(), itemEntretenimento.getTipo());
//        Assertions.assertEquals(itemBuscado.getGenero(), itemEntretenimento.getGenero());
//        Assertions.assertEquals(itemBuscado.getSinopse(), itemEntretenimento.getSinopse());
//        Assertions.assertEquals(itemBuscado.getAnoLancamento(), itemEntretenimento.getAnoLancamento());
//        Assertions.assertEquals(itemBuscado.getClassificacao(), itemEntretenimento.getClassificacao());
//        Assertions.assertEquals(itemBuscado.getPlataforma(), itemEntretenimento.getPlataforma());
//
//
//    }
//
//    @Test
//    public void testarRemoverItem() {
//        ItemEntretenimento itemEntretenimento2 = new ItemEntretenimento();
//        itemEntretenimento2.setNome("Hulk");
//        itemEntretenimento2.setTipo("Filme");
//        itemEntretenimento2.setGenero("Ação");
//        itemEntretenimento2.setSinopse("Um homem que se vira um monstro");
//        itemEntretenimento2.setAnoLancamento("2012");
//        itemEntretenimento2.setClassificacao(18);
//        itemEntretenimento2.setPlataforma("Filmes torrent hd");
//
//        //  itemService.adicionarItemEntretenimento(itemEntretenimento2);
//
//        //    itemService.removerItemEntretenimento(7);
//        ItemEntretenimento itemApagado = itemService.pegar(7);
//
//        Assertions.assertNull(itemApagado.getId());
//
//
//    }
//
//    @Test
//    public void testarEditarItem() {
//        ItemEntretenimento itemEntretenimento3 = new ItemEntretenimento();
//        itemEntretenimento3.setNome("Clube de luta");
//        itemEntretenimento3.setTipo("Filme");
//        itemEntretenimento3.setGenero("Luta");
//        itemEntretenimento3.setSinopse("Um filme de brigas de rua");
//        itemEntretenimento3.setAnoLancamento("2009");
//        itemEntretenimento3.setClassificacao(18);
//        itemEntretenimento3.setPlataforma("Filmes torrent hd");
//
//        ItemEntretenimento itemEntretenimentoEdit = new ItemEntretenimento();
//        itemEntretenimentoEdit.setNome("Batman");
//        itemEntretenimentoEdit.setGenero("Suspense");
//        itemEntretenimentoEdit.setSinopse("Um homem que luta contra os crimes de gothan");
//        itemEntretenimentoEdit.setAnoLancamento("2022");
//        itemEntretenimentoEdit.setClassificacao(18);
//        itemEntretenimentoEdit.setPlataforma("Cinema");
//
//        //   itemService.adicionarItemEntretenimento(itemEntretenimento3);
//
//        // itemService.editarItemEntretenimento(9,itemEntretenimentoEdit);
//
//        ItemEntretenimento itemQueFoiAtualizado = itemService.pegar(9);
//
//        Assertions.assertEquals(itemQueFoiAtualizado.getNome(), itemEntretenimentoEdit.getNome());
//        Assertions.assertEquals(itemQueFoiAtualizado.getGenero(), itemEntretenimentoEdit.getGenero());
//        Assertions.assertEquals(itemQueFoiAtualizado.getSinopse(), itemEntretenimentoEdit.getSinopse());
//        Assertions.assertEquals(itemQueFoiAtualizado.getAnoLancamento(), itemEntretenimentoEdit.getAnoLancamento());
//        Assertions.assertEquals(itemQueFoiAtualizado.getClassificacao(), itemEntretenimentoEdit.getClassificacao());
//        Assertions.assertEquals(itemQueFoiAtualizado.getPlataforma(), itemEntretenimentoEdit.getPlataforma());
//
//
//    }
//}
