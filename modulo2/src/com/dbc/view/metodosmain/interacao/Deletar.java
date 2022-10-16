package com.dbc.view.metodosmain.interacao;

import com.dbc.model.Usuario;
import com.dbc.service.AvaliacaoService;
import com.dbc.service.ItemService;
import entidades.Usuario;
import interfacesenum.TipoUsuario;
import manipulacao.AvaliacaoManipulacao;
import manipulacao.ItemManipulacao;
import manipulacao.UsuarioManipulacao;

public class Deletar {
    public static void deletarItemEntretenimento(Integer index, ItemService itemService){
        itemService.removerItemEntretenimento(index);
    }

    public static void deletarAvaliacao(Integer index, Usuario usuario, AvaliacaoService avaliacaoService){
        avaliacaoService.removerAvaliacao(index,usuario.getId());
    }

    public static void deletarQualquerUsuario(Integer index, UsuarioManipulacao usuarioManipulacao, Usuario usuario){

        if (usuarioManipulacao.getUsuariosLista().get(index) != null
                && usuario.getTipoUsuario().getDescricao().equals(TipoUsuario.ADIMINISTRADOR.getDescricao())){

            usuarioManipulacao.deletarUsuario(index);
            System.out.println("Usuario deletado.");

        }else{
            System.out.println("Usuario não encontrado.");
        }
    }
}
