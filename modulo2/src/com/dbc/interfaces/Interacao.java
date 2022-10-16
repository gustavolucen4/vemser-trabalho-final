package com.dbc.interfaces;

import com.dbc.exceptions.BancoDeDadosException;

public interface Interacao {
    public boolean marcarAssistido(Integer idItem, Integer idUsuario) throws BancoDeDadosException;
    public boolean incluirIndicacao(String nomeFilme);
}
