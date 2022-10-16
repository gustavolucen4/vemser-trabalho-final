package com.dbc.service;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.repository.IndicacaoRepository;

public class IndicacaoService {

    private IndicacaoRepository indicacaoRepository;

    public IndicacaoService() {
        this.indicacaoRepository = new IndicacaoRepository();
    }

    public void adcionarIndicacao (Integer idUsuario, String nomeItem){
        try{
            boolean adicionou = indicacaoRepository.indicar(idUsuario, nomeItem);
            System.out.println("Indicação feita ? :"+adicionou);
        }catch (BancoDeDadosException ex){
            System.out.println("ERRO: "+ex.getMessage());
        }
    }
}
