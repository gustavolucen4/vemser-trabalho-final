package com.dbc.view.metodosmain.interacao;

import entidades.Usuario;
import interfacesenum.TipoUsuario;
import manipulacao.AvaliacaoManipulacao;
import manipulacao.ItemManipulacao;
import manipulacao.UsuarioManipulacao;

public class Deletar {
    public static void deletarItemEntretenimento(Integer index, ItemManipulacao itemManipulacao){
        itemManipulacao.deletarItemEntretenimentoPorIndice(index);
    }

    public static void deletarAvaliacao(Integer index, AvaliacaoManipulacao avaliacaoManipulacao){
        avaliacaoManipulacao.deletarAvaliacoes(index);
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
