package com.dbc.repository;

import com.dbc.enums.TipoUsuario;
import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.interfaces.Repositorio;
import com.dbc.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemRepository implements Repositorio<Integer, ItemEntretenimento> {
    @Override
    public Integer getProximoId(Connection connection) throws BancoDeDadosException {
        try {
            String sql = "SELECT SEQ_ITEM_ENTRETENIMENTO.nextval mysequence from DUAL";
            Statement stmt = connection.createStatement();
            ResultSet res = stmt.executeQuery(sql);

            if (res.next()) {
                return res.getInt("mysequence");
            }

            return null;
        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        }
    }

    @Override
    public ItemEntretenimento adicionar(ItemEntretenimento item) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            Integer proximoId = this.getProximoId(con);
            item.setId(proximoId);

            String sql = "INSERT INTO ITEM_ENTRETENIMENTO\n" +
                    "(id_item_entretenimento , nome, tipo, genero, sinopse, ano_lancamento, classificacao, plataforma)\n" +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?)\n";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, item.getId());
            stmt.setString(2, item.getNome());
            stmt.setString(3, item.getTipo());
            stmt.setString(4, item.getGenero());
            stmt.setString(5, item.getSinopse());
            stmt.setString(6, item.getAnoLancamento());
            stmt.setInt(7, item.getClassificacao());
            stmt.setString(8, item.getPlataforma());

            int res = stmt.executeUpdate();
            System.out.println("adicionarItem.res=" + res);
            return item;
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

    @Override
    public boolean remover(Integer id) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            String sql = "DELETE FROM ITEM_ENTRETENIMENTO WHERE id_item_entretenimento = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);

            // Executa-se a consulta
            int res = stmt.executeUpdate();
            System.out.println("removerItemPorId.res=" + res);

            return res > 0;
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

    @Override
    public boolean editar(Integer id, ItemEntretenimento item) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE ITEM_ENTRETENIMENTO SET \n");

            if (item.getNome() != null){
                sql.append("nome = ? ,");
            }
            if (item.getGenero() != null) {
                sql.append("genero = ?,");
            }
            if (item.getSinopse() != null) {
                sql.append("sinopse = ? ,");
            }
            if (item.getAnoLancamento() != null) {
                sql.append("ano_lancamento = ? ,");
            }
            if (item.getClassificacao() != null) {
                sql.append("classificacao = ? ,");
            }
            if (item.getPlataforma() != null) {
                sql.append("plataforma = ? ,");
            }

            sql.deleteCharAt(sql.length() - 1); //remove o ultimo ','
            sql.append(" WHERE id_item_entretenimento = ? ");

            PreparedStatement stmt = con.prepareStatement(sql.toString());

            int index = 1;

            if (item.getNome() != null){
                stmt.setString(index++, item.getNome());
            }
            if (item.getGenero() != null) {
                stmt.setString(index++, item.getGenero());
            }
            if (item.getSinopse() != null) {
                stmt.setString(index++, item.getSinopse());
            }
            if (item.getAnoLancamento() != null) {
                stmt.setString(index++, item.getAnoLancamento());
            }
            if (item.getClassificacao() != null) {
                stmt.setInt(index++, item.getClassificacao());
            }
            if (item.getPlataforma() != null) {
                stmt.setString(index++, item.getPlataforma());
            }

            stmt.setInt(index, id);

            // Executa-se a consulta
            int res = stmt.executeUpdate();
            System.out.println("editarFilme.res=" + res);

            return res > 0;
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

    @Override
    public List<ItemEntretenimento> listar() throws BancoDeDadosException {
        List<ItemEntretenimento> itemEntretenimentos = new ArrayList<>();
        Connection con = null;

        try{
            con = ConexaoBancoDeDados.getConnection();
            Statement stmt = con.createStatement();

            String sql = "SELECT * FROM ITEM_ENTRETENIMENTO";
            ResultSet res = stmt.executeQuery(sql);

            while (res.next()){
                ItemEntretenimento item = new ItemEntretenimento();
                item.setId(res.getInt("id_item_entretenimento"));
                item.setNome(res.getString("nome"));
                item.setTipo(res.getString("tipo"));
                item.setGenero(res.getString("genero"));
                item.setSinopse(res.getString("sinopse"));
                item.setAnoLancamento(res.getString("ano_lancamento"));
                item.setClassificacao(res.getInt("classificacao"));
                item.setPlataforma(res.getString("plataforma"));

                itemEntretenimentos.add(item);
            }

        }catch (SQLException ex){
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
        return itemEntretenimentos;
    }

    public List<ItemEntretenimento> filtrarItens(Filtro filtro) throws BancoDeDadosException {
        List<ItemEntretenimento> itemEntretenimentos = new ArrayList<>();
        Connection con = null;

        try{
            con = ConexaoBancoDeDados.getConnection();

            StringBuilder sql = new StringBuilder();

            sql.append("SELECT * FROM ITEM_ENTRETENIMENTO ");
            sql.append("WHERE UPPER(tipo) = ? AND UPPER(genero) = ? AND classificacao <= ?");

            PreparedStatement stmt = con.prepareStatement(sql.toString());

            stmt.setString(1, filtro.getTipo().toUpperCase());
            stmt.setString(2, filtro.getGenero().toUpperCase());
            stmt.setInt(3, filtro.getClassificacao());

            ResultSet res = stmt.executeQuery();

            while (res.next()){
                ItemEntretenimento item = new ItemEntretenimento();
                item.setId(res.getInt("id_item_entretenimento"));
                item.setNome(res.getString("nome"));
                item.setTipo(res.getString("tipo"));
                item.setGenero(res.getString("genero"));
                item.setSinopse(res.getString("sinopse"));
                item.setAnoLancamento(res.getString("ano_lancamento"));
                item.setClassificacao(res.getInt("classificacao"));
                item.setPlataforma(res.getString("plataforma"));

                itemEntretenimentos.add(item);
            }

        }catch (SQLException ex){
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
        return itemEntretenimentos;
    }

    public Double mediaAvaliacoes(Integer id) throws BancoDeDadosException{
        Double media = null;
        Connection con = null;

        try {
            con = ConexaoBancoDeDados.getConnection();

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT AVG(nota) as media FROM AVALIACAO \n");
            sql.append("WHERE id_item_entretenimento = ? ");

            PreparedStatement stmt = con.prepareStatement(sql.toString());

            stmt.setInt(1, id);

            ResultSet res = stmt.executeQuery();

            media = res.getDouble("media");

        }catch (SQLException ex){
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
        return media;
    }

    public ItemEntretenimento pegar(Integer id) throws BancoDeDadosException {
        Connection conn = null;
        ItemEntretenimento item = new ItemEntretenimento();

        try {
            conn = ConexaoBancoDeDados.getConnection();
            String sql = "SELECT * FROM ITEM_ENTRETENIMENTO WHERE id_usuario = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet res = stmt.executeQuery();

            item.setId(res.getInt("id_item_entretenimento"));
            item.setNome(res.getString("nome"));
            item.setTipo(res.getString("tipo"));
            item.setGenero(res.getString("genero"));
            item.setSinopse(res.getString("sinopse"));
            item.setAnoLancamento(res.getString("ano_lancamento"));
            item.setClassificacao(res.getInt("classificacao"));
            item.setPlataforma(res.getString("plataforma"));

            System.out.println("Pegar Item: " + res.getInt("id_item_entretenimento"));

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
        return item;
    }
}
