package com.dbc.interfaces;

// import entidades.ItemEntretenimento;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.ItemEntretenimento;

public interface Interacao {
    public boolean marcarAssistido(Integer idItem, Integer idUsuario) throws BancoDeDadosException;
    public boolean incluirIndicacao(String nomeFilme);
}
