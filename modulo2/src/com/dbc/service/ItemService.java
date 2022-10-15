package com.dbc.service;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Avaliacao;
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
            ItemEntretenimento itemAdicionado = itemRepository.adicionar(itemEntretenimento);
            System.out.println("Item adicionado com succeso!");

        } catch (BancoDeDadosException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex){
            System.out.println("ERRO: "+ex.getMessage());
        }
    }

    public void listarItens(){
        try{
            List<ItemEntretenimento> itens = itemRepository.listar();
            itens.forEach(x -> x.imprimir());

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
            System.out.println("Item removido? " + conseguiuRemover + "| com id=" + id);
        }catch (BancoDeDadosException ex){
            System.out.println("ERRO: "+ex.getMessage());
        }
    }

    public List<ItemEntretenimento> filtrarItemEntretenimento(Filtro filtro){
        try{
            if (filtro != null) {
                List<ItemEntretenimento> resultado = itemRepository.filtrarItens(filtro);
                return resultado;
            }
        } catch (BancoDeDadosException ex) {
            System.out.println("ERRO: "+ex.getMessage());
        }
        return null;
    }

    public void mediaAvaliacao(Integer id){
        try{
            Double media = itemRepository.mediaAvaliacoes(id);
        } catch (BancoDeDadosException ex) {
            System.out.println("ERRO: "+ex.getMessage());
        }
    }


}
