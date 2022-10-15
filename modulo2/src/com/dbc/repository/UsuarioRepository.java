package com.dbc.repository;

import com.dbc.enums.TipoUsuario;
import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.interfaces.Repositorio;
import com.dbc.model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository implements Repositorio<Integer, Usuario> {

    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        String sql = "SELECT SEQ_USUARIO.nextval mysequence from DUAL";

        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);

        if (resultSet.next()) {
            return resultSet.getInt("mysequence");
        }

        return null;
    }

    @Override
    public Usuario adicionar(Usuario usuario) throws BancoDeDadosException {
        Connection conn = null;

        try {
            conn = ConexaoBancoDeDados.getConnection();
            Integer proximoId = this.getProximoId(conn);
            usuario.setId(proximoId);

            String sql = "INSERT INTO USUARIO\n" +
                    "(id_usuario, nome, idade, email, senha, tipo_usuario)\n" +
                    "VALUES(?, ?, ?, ?, ?, ?)\n";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, usuario.getId());
            stmt.setString(2, usuario.getNome());
            stmt.setInt(3, usuario.getIdade());
            stmt.setString(4, usuario.getEmail());
            stmt.setString(5, usuario.getSenha());
            stmt.setString(6, usuario.getTipoUsuario().getDescricao());

            int res = stmt.executeUpdate();

            System.out.println("Adicionar Usuário: " + res);
            return usuario;

        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.getCause();
            }
        }
    }

    @Override
    public boolean remover(Integer id) throws BancoDeDadosException {
        Connection conn = null;

        try {
            conn = ConexaoBancoDeDados.getConnection();
            String sql = "DELETE FROM USUARIO WHERE id_usuario = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            int res = stmt.executeUpdate();
            System.out.println("Remover Usuário: " + res);
            return res > 0;

        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean editar(Integer id, Usuario usuario) throws BancoDeDadosException {
        Connection conn = null;
        try {
            conn = ConexaoBancoDeDados.getConnection();
            StringBuilder sql = new StringBuilder();

            sql.append("UPDATE USUARIO SET ");
            sql.append(" nome = ?,");
            sql.append(" idade = ?,");
            sql.append(" email = ?,");
            sql.append(" senha = ?");
            sql.append(" WHERE id_usuario = ? ");

            PreparedStatement stmt = conn.prepareStatement(sql.toString());

            stmt.setString(1, usuario.getNome());
            stmt.setInt(2, usuario.getIdade());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getSenha());

            stmt.setInt(5, id);

            int res = stmt.executeUpdate();

            System.out.println("Editar Usuário: " + res);

            return res > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Usuario> listar() throws BancoDeDadosException {
        List<Usuario> usuarioList = new ArrayList<>();

        Connection conn = null;

        try {
            conn = ConexaoBancoDeDados.getConnection();
            Statement stmt = conn.createStatement();

            String sql = "SELECT * FROM USUARIO";

            ResultSet res = stmt.executeQuery(sql);

            while (res.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(res.getInt("id_usuario"));
                usuario.setNome(res.getString("nome"));
                usuario.setIdade(res.getInt("idade"));
                usuario.setEmail(res.getString("email"));
                usuario.setSenha(res.getString("senha"));
                if (res.getString("tipo_usuario").equalsIgnoreCase("administrador")) {
                    usuario.setTipoUsuario(TipoUsuario.ADMINISTRADOR);

                }else {
                    usuario.setTipoUsuario(TipoUsuario.CLIENTE);
                }
               usuarioList.add(usuario);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return usuarioList;
    }


    public Usuario pegar(Integer id) throws BancoDeDadosException {
        Connection conn = null;
        Usuario usuario = new Usuario();

        try {
            conn = ConexaoBancoDeDados.getConnection();
            String sql = "SELECT * FROM USUARIO WHERE id_usuario = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet res = stmt.executeQuery();

            while (res.next()){
                usuario.setId(res.getInt("id_usuario"));
                usuario.setNome(res.getString("nome"));
                usuario.setIdade(res.getInt("idade"));
                usuario.setEmail(res.getString("email"));
                usuario.setSenha(res.getString("senha"));
                if (res.getString("tipo_usuario").equalsIgnoreCase("administrador")) {
                    usuario.setTipoUsuario(TipoUsuario.ADMINISTRADOR);

                }else {
                    usuario.setTipoUsuario(TipoUsuario.CLIENTE);
                }
            }

            System.out.println("Usuário consultado!!");

        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return usuario;
    }
}
