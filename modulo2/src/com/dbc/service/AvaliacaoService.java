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
            System.out.println("Avaliação adicionado com succeso!");
        } catch (BancoDeDadosException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    public void listarAvaliacoes(Integer idUsuario) {
        try {
            List<Avaliacao> avaliacaoList = avaliacaoRepository.listarAvaliacoesUsuario(idUsuario);
            avaliacaoList.forEach(System.out::println);
        } catch (BancoDeDadosException e) {
            throw new RuntimeException(e.getCause());
        }
    }


}
