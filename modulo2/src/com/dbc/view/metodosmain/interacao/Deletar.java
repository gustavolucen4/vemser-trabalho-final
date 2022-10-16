package com.dbc.view.metodosmain.interacao;

import com.dbc.enums.TipoUsuario;
import com.dbc.model.Usuario;
import com.dbc.service.AvaliacaoService;
import com.dbc.service.ItemService;
import com.dbc.service.UsuarioService;

public class Deletar {
    public static void deletarItemEntretenimento(Integer index, ItemService itemService){
        itemService.removerItemEntretenimento(index);
    }

    public static void deletarAvaliacao(Integer idUsuario, Integer index, AvaliacaoService avaliacaoService){
        avaliacaoService.removerAvaliacao(idUsuario, index);
    }

    public static void deletarQualquerUsuario(Integer index, UsuarioService usuarioService, Usuario usuario){

        if (usuarioService.pegarUsuario(index) != null
                && usuario.getTipoUsuario().getDescricao().equals(TipoUsuario.ADMINISTRADOR.getDescricao())){

            usuarioService.removerUsuario(index);
            System.out.println("Usuario deletado.");

        }else{
            System.out.println("Usuario não encontrado.");
        }
    }
}
