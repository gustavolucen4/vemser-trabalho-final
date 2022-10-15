package com.dbc.repository;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Avaliacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AvaliacaoRepository {

    private UsuarioRepository usuarioRepository;
    private ItemRepository itemRepository;


    public Avaliacao adicionar(Avaliacao avaliacao, Integer usuarioId, Integer itemId) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            String sql = "INSERT INTO AVALIACAO\n" +
                    "(id_usuario, id_item_entretenimento, nota, comentario)\n" +
                    "VALUES(?, ?, ?, ?)\n";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, usuarioId);
            stmt.setInt(2, itemId);
            stmt.setDouble(3, avaliacao.getNota());
            stmt.setString(4, avaliacao.getComentario());

            int res = stmt.executeUpdate();
            System.out.println("Avaliaçao adcionada!! - " + res);
            return avaliacao;
        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Avaliacao> listarAvaliacoesUsuario (Integer idUsuario) throws BancoDeDadosException {

        List<Avaliacao> avaliacoes = new ArrayList<>();
        Connection con = null;

        try{
            con = ConexaoBancoDeDados.getConnection();

            StringBuilder sql = new StringBuilder();

            sql.append("SELECT * FROM AVALIACAO a ");
            sql.append("INNER JOIN ITEM_ENTRETENIMENTO ie ON (ie.id_item_entretenimento = a.id_item_entretenimento) ");
            sql.append("WHERE id_usuario = ? ");

            PreparedStatement stmt = con.prepareStatement(sql.toString());

            stmt.setInt(1, idUsuario);

            ResultSet res = stmt.executeQuery();

            while (res.next()){
                Avaliacao aval = new Avaliacao();
                aval.setUsuario(usuarioRepository.pegar(res.getInt("id_usuario")));
                aval.setItemEntretenimento(itemRepository.pegar(res.getInt("id_item_entretenimento")));
                aval.setNota(res.getDouble("nota"));
                aval.setComentario(res.getString("comentario"));

                avaliacoes.add(aval);
            }

        }catch (
                SQLException ex){
            throw new BancoDeDadosException(ex.getCause());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return avaliacoes;
    }

    public boolean remover(Integer id) throws BancoDeDadosException {
        return false;
    }

    public boolean editar(Integer id, Avaliacao avaliacao) throws BancoDeDadosException {
        return false;
    }

    public List<Avaliacao> listar() throws BancoDeDadosException {
        return null;
    }
}
