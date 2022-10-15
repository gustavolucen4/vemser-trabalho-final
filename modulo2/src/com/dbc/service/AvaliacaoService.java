package com.dbc.service;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Avaliacao;
import com.dbc.repository.AvaliacaoRepository;

import java.util.List;

public class AvaliacaoService {
    AvaliacaoRepository avaliacaoRepository;

    public AvaliacaoService() {
        avaliacaoRepository = new AvaliacaoRepository();
    }

    public void adicionarAvaliacao(Avaliacao avaliacao, Integer idUsuario, Integer idItem) {
        try {
            avaliacaoRepository.adicionar(avaliacao, idUsuario, idItem);
            System.out.println("Avaliação adicionado com sucesso!");
        } catch (BancoDeDadosException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    public void listarAvaliacoes() {
        try {
            List<Avaliacao> avaliacaoList = avaliacaoRepository.listarAvaliacoes();
            avaliacaoList.forEach(Avaliacao::imprimir);
        } catch (BancoDeDadosException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e.getCause());
        }
    }

    public void listarAvaliacoesUsuario(Integer idUsuario) {
        try {
            List<Avaliacao> avaliacaoList = avaliacaoRepository.listarAvaliacoesUsuario(idUsuario);
            avaliacaoList.forEach(Avaliacao::imprimir);
        } catch (BancoDeDadosException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    public void removerAvaliacao(Integer idUsuario, Integer idItem){
        try{
            boolean conseguiuRemover = avaliacaoRepository.remover(idUsuario, idItem);
        }catch (BancoDeDadosException ex){
            System.out.println("ERRO: "+ex.getMessage());
        }
    }

    public void editarAvaliacao(Avaliacao avaliacao, Integer idUsuario, Integer idItem){
        try{
            boolean conseguiEditar = avaliacaoRepository.editar(avaliacao, idUsuario, idItem);
            System.out.println("Avaliação editada!!");
        }catch (BancoDeDadosException ex){
            System.out.println("ERRO: "+ex.getMessage());
        }
    }
}
