package com.dbc.service;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Usuario;
import com.dbc.repository.UsuarioRepository;

import java.util.List;

public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public UsuarioService() {
        usuarioRepository = new UsuarioRepository();
    }

    public void adicionarUsuario(Usuario usuario) {
        try {
            Usuario usuarioAdicionado = usuarioRepository.adicionar(usuario);
            System.out.println("Usuário adicionado com sucesso! " + usuarioAdicionado);
            System.out.println();
        } catch (BancoDeDadosException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    public void removerUsuario(Integer id) {
        try {
            boolean removido = usuarioRepository.remover(id);
            System.out.println("Usuário foi deletado com sucesso ?: " + removido + " com o id: " + id);

        } catch (BancoDeDadosException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    public void editarUsuario(Integer id, Usuario usuario) {
        try {
            boolean editado = usuarioRepository.editar(id, usuario);
            System.out.println("Usuário foi editado com sucesso ?: " + editado + " com o id: " + id);
        } catch (BancoDeDadosException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    public void tornarUsuarioAdmin(Integer id) {
        try {
            boolean editado = usuarioRepository.tornarUsuarioAdmin(id);
            System.out.println("Usuário agora é um administrador?: " + editado);
        } catch (BancoDeDadosException e) {
            System.out.println("ERRO: "+e.getMessage());
        }
    }

    public void listarUsuarios() {
        try {
            List<Usuario> listar = usuarioRepository.listar();
            listar.forEach(Usuario::imprimir);
        } catch (BancoDeDadosException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    public Usuario pegarUsuario(Integer id){
        try{
            return usuarioRepository.pegar(id);
        }catch (BancoDeDadosException ex){
            System.out.println("ERRO: "+ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }

    public Usuario verificarUsuario(Usuario usuario){
        try{
            System.out.println("Buscando usuário......\n");
            return usuarioRepository.pegarLogin(usuario);

        }catch (BancoDeDadosException ex){
            System.out.println("ERRO: "+ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }
}
