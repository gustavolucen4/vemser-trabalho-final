package com.dbc.service;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.exceptions.OpcaoInvalidaException;
import com.dbc.model.Filtro;
import com.dbc.model.ItemEntretenimento;
import com.dbc.repository.ItemRepository;

import java.util.List;

public class ItemService {

    private ItemRepository itemRepository;

    public ItemService() {
        itemRepository = new ItemRepository();
    }

    public void adicionarItemEntretenimento(ItemEntretenimento itemEntretenimento){
        try{
            if (itemEntretenimento.getNome() == null || itemEntretenimento.getTipo() == null || itemEntretenimento.getClassificacao() == null){
                throw new OpcaoInvalidaException("Dados invalidos.");
            }
            ItemEntretenimento itemAdicionado = itemRepository.adicionar(itemEntretenimento);
            System.out.println("Item adicionado com sucesso!");

        } catch (BancoDeDadosException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex){
            System.out.println("ERRO: "+ex.getMessage());
        }
    }

    public void listarItens(){
        try{
            List<ItemEntretenimento> itens = itemRepository.listar();
            itens.forEach(item -> {
                if (calcularAvaliacao(item.getId()) == 0){
                    item.setMediaAvaliacoes(null);
                }else {
                    item.setMediaAvaliacoes(calcularAvaliacao(item.getId()));
                }
            });
            itens.forEach(ItemEntretenimento::imprimir);

        }catch (BancoDeDadosException ex){
            System.out.println("ERRO: "+ex.getMessage());
        }
    }

    public void editarItemEntretenimento(Integer id, ItemEntretenimento itemEntretenimento){
        try{
            boolean conseguiuEditar = itemRepository.editar(id, itemEntretenimento);
        }catch (BancoDeDadosException ex){
            System.out.println("ERRO: "+ex.getMessage());
        }
    }

    public void removerItemEntretenimento(Integer id) {
        try{
            boolean conseguiuRemover = itemRepository.remover(id);
            System.out.println("Item com id "+id+" removido? " + conseguiuRemover);
        }catch (BancoDeDadosException ex){
            System.out.println("ERRO: "+ex.getMessage());
        }
    }

    public boolean filtrarItemEntretenimento(Filtro filtro){
        try{
            if (filtro != null) {
                List<ItemEntretenimento> resultado = itemRepository.filtrarItens(filtro);

                resultado.forEach(item -> {
                    if (calcularAvaliacao(item.getId()) == 0){
                        item.setMediaAvaliacoes(null);
                    }else {
                        item.setMediaAvaliacoes(calcularAvaliacao(item.getId()));
                    }
                });

                resultado.forEach(ItemEntretenimento::imprimir);
                return true;
            }
        } catch (BancoDeDadosException ex) {
            System.out.println("ERRO: "+ex.getMessage());
        }
        return false;
    }

    public Double calcularAvaliacao(Integer id){
        try{
            return itemRepository.calcularAvaliacoes(id);
        } catch (BancoDeDadosException ex) {
            System.out.println("ERRO: "+ex.getMessage());
        }
        return null;
    }

    public ItemEntretenimento pegarItem(Integer id) {
        try {
            ItemEntretenimento item = itemRepository.pegar(id);
            if (calcularAvaliacao(item.getId()) == 0){
                item.setMediaAvaliacoes(null);
            }else {
                item.setMediaAvaliacoes(calcularAvaliacao(item.getId()));
            }

            return item;
        } catch (BancoDeDadosException ex) {
            System.out.println("ERRO: "+ex.getMessage());
        }
        return null;
    }

}
