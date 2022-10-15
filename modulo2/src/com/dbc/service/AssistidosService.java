package com.dbc.service;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.ItemEntretenimento;
import com.dbc.repository.AssistidosRepository;

import java.util.List;

public class AssistidosService {

    private AssistidosRepository assistidosRepository;

    public AssistidosService() {
        this.assistidosRepository = new AssistidosRepository();
    }

    public void listarAssistidos (Integer idUsuario){
       List<ItemEntretenimento> lista = null;
        try{
            lista = assistidosRepository.listarAssistidos(idUsuario);
            lista.forEach(x -> x.imprimir());
        }catch (BancoDeDadosException ex){
            System.out.println("ERRO: "+ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void deletarAssistidos (Integer idItem, Integer idUsuario){
        try{
            boolean conseguiuDeletar = assistidosRepository.deletarAssistido(idItem, idUsuario);
            System.out.println("Removido de assistido? "+conseguiuDeletar);
        }catch (BancoDeDadosException ex){
            System.out.println("ERRO: "+ex.getMessage());
        }
    }

    public void marcarAssistido (Integer idUsuario, Integer idItem){
        try{
            boolean marcouAssistodo = assistidosRepository.marcarAssistido(idUsuario, idItem);
            System.out.println("Foi marcado como assistido ? :"+marcouAssistodo);
        }catch (BancoDeDadosException ex){
            System.out.println("ERRO: "+ex.getMessage());
        }
    }
}
