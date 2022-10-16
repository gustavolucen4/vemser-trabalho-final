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

    public void listarUsuarios() {
        try {
            List<Usuario> listar = usuarioRepository.listar();
            listar.forEach(System.out::println);
        } catch (BancoDeDadosException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    public void pegarUsuario(Integer id){
        try{
            Usuario usuario = usuarioRepository.pegar(id);
            usuario.imprimir();
        }catch (BancoDeDadosException ex){
            System.out.println("ERRO: "+ex.getMessage());
            ex.printStackTrace();
        }
    }

    public Usuario verificarUsuario(Usuario usuario){
        try{
            return usuarioRepository.pegarLogin(usuario);

        }catch (BancoDeDadosException ex){
            System.out.println("ERRO: "+ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }
}
