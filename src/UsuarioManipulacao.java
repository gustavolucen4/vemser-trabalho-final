import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioManipulacao {

    private List<Usuario> usuarios;

    public UsuarioManipulacao() {
        usuarios = new ArrayList<>();
    }

    public void adicionarUsuario(Usuario usuario){
        this.usuarios.add(usuario);
    }

    public void listarUsuarios(){
        usuarios.forEach(us -> us.imprimir());
    }

    public void editarUsuario(Integer index, Usuario usuarioAtualizado){
        Usuario usuario = usuarios.get(index);

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
    }

    public void removerUsuario(Integer index) {
        Optional<Usuario> usuario = usuarios.stream()
                .filter(user -> user.getId().equals(index))
                .findFirst();

        if(usuario.isPresent()){
            usuarios.remove(usuario);
        }
    }
}
