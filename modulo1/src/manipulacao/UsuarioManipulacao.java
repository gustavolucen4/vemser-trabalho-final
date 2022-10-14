package manipulacao;

import entidades.Usuario;
import interfacesenum.TipoUsuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioManipulacao {

    private List<Usuario> usuariosLista;

    public List<Usuario> getUsuariosLista(){
        return usuariosLista;
    }

    public UsuarioManipulacao() {
        usuariosLista = new ArrayList<>();
    }


    public boolean criarUsuario(Usuario usuario){
        this.usuariosLista.add(usuario);
        return true;
    }

    public boolean listarUsuarios(){
        if (usuariosLista != null){
            usuariosLista.forEach(us -> us.imprimir());
            return true;
        }else {
            System.out.println("Lista vazia!");
            return false;
        }
    }

    public boolean editarUsuario(Integer index, Usuario usuarioAtualizado){
        if (usuariosLista.get(index) != null){
            Usuario usuario = usuariosLista.get(index);

            if (usuarioAtualizado.getNome() != null){
                usuario.setNome(usuarioAtualizado.getNome());
            }

            if (usuarioAtualizado.getEmail() != null){
                usuario.setEmail(usuarioAtualizado.getEmail());
            }

            if (usuarioAtualizado.getIdade() != null){
                usuario.setIdade(usuarioAtualizado.getIdade());
            }

            if (usuarioAtualizado.getSenha() != null){
                usuario.setSenha(usuarioAtualizado.getSenha());
            }

            return true;
        }else {
            System.out.println("Index não encontrado!");
            return false;
        }
    }

    public boolean deletarUsuario(Integer index) {

        if(usuariosLista.get(index) != null){
            usuariosLista.remove(usuariosLista.get(index));
            return true;
        } else {
            System.out.println("Index não encontrado!");
            return false;
        }
    }

}
