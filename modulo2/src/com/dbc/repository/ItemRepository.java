package com.dbc.repository;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.interfaces.Repositorio;
import com.dbc.model.Filme;
import com.dbc.model.ItemEntretenimento;
import com.dbc.model.Serie;

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


    public Filme adicionarFilme(Filme filme) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            Integer proximoId = this.getProximoId(con);
            filme.setId(proximoId);

            String sql = "INSERT INTO ITEM_ENTRETENIMENTO\n" +
                    "(id_item_entretenimento , nome, tipo, genero, sinopse, ano_lancamento, classificacao, plataforma, duracao)\n" +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)\n";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, filme.getId());
            stmt.setString(2, filme.getNome());
            stmt.setString(3, filme.getTipo());
            stmt.setString(4, filme.getGenero());
            stmt.setString(5, filme.getSinopse());
            stmt.setString(6, filme.getAnoLancamento());
            stmt.setInt(7, filme.getClassificacao());
            stmt.setString(8, filme.getPlataforma());
            stmt.setString(9, filme.getDuracao());

            int res = stmt.executeUpdate();
            System.out.println("adicionarItem.res=" + res);
            return filme;
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

    public Serie adicionarSerie(Serie serie) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            Integer proximoId = this.getProximoId(con);
            serie.setId(proximoId);

            String sql = "INSERT INTO ITEM_ENTRETENIMENTO\n" +
                    "(id_item_entretenimento , nome, tipo, genero, sinopse, ano_lancamento, classificacao, plataforma, temporadas, episodios)\n" +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)\n";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, serie.getId());
            stmt.setString(2, serie.getNome());
            stmt.setString(3, serie.getTipo());
            stmt.setString(4, serie.getGenero());
            stmt.setString(5, serie.getSinopse());
            stmt.setString(6, serie.getAnoLancamento());
            stmt.setInt(7, serie.getClassificacao());
            stmt.setString(8, serie.getPlataforma());
            stmt.setInt(9, serie.getTemporadas());
            stmt.setInt(9, serie.getEpisodios());

            int res = stmt.executeUpdate();
            System.out.println("adicionarItem.res=" + res);
            return serie;
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


    public boolean editarFilme(Integer id, Filme filme) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE ITEM_ENTRETENIMENTO SET \n");

            if (filme.getNome() != null){
                sql.append("nome = ?, ");
            }
            if (filme.getGenero() != null) {
                sql.append("genero = ?, ");
            }
            if (filme.getSinopse() != null) {
                sql.append("sinopse = ?, ");
            }
            if (filme.getAnoLancamento() != null) {
                sql.append("ano_lancamento = ?, ");
            }
            if (filme.getClassificacao() != null) {
                sql.append("classificacao = ?, ");
            }
            if (filme.getPlataforma() != null) {
                sql.append("plataforma = ?, ");
            }
            if (filme.getDuracao() != null) {
                sql.append("duracao = ?, ");
            }

            sql.deleteCharAt(sql.length() - 1); //remove o ultimo ','
            sql.append(" WHERE id_item_entretenimento = ? ");

            PreparedStatement stmt = con.prepareStatement(sql.toString());

            int index = 1;

            if (filme.getNome() != null){
                stmt.setString(index++, filme.getNome());
            }
            if (filme.getGenero() != null) {
                stmt.setString(index++, filme.getGenero());
            }
            if (filme.getSinopse() != null) {
                stmt.setString(index++, filme.getSinopse());
            }
            if (filme.getAnoLancamento() != null) {
                stmt.setString(index++, filme.getAnoLancamento());
            }
            if (filme.getClassificacao() != null) {
                stmt.setInt(index++, filme.getClassificacao());
            }
            if (filme.getPlataforma() != null) {
                stmt.setString(index++, filme.getPlataforma());
            }
            if (filme.getDuracao() != null) {
                stmt.setString(index++, filme.getDuracao());
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

    public boolean editarSerie(Integer id, Serie serie) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE ITEM_ENTRETENIMENTO SET \n");

            if (serie.getNome() != null){
                sql.append("nome = ?, ");
            }
            if (serie.getGenero() != null) {
                sql.append("genero = ?, ");
            }
            if (serie.getSinopse() != null) {
                sql.append("sinopse = ?, ");
            }
            if (serie.getAnoLancamento() != null) {
                sql.append("ano_lancamento = ?, ");
            }
            if (serie.getClassificacao() != null) {
                sql.append("classificacao = ?, ");
            }
            if (serie.getPlataforma() != null) {
                sql.append("plataforma = ?, ");
            }
            if (serie.getTemporadas() != null) {
                sql.append("temporadas = ?, ");
            }
            if (serie.getEpisodios() != null) {
                sql.append("episodios = ?, ");
            }

            sql.deleteCharAt(sql.length() - 1); //remove o ultimo ','
            sql.append(" WHERE id_item_entretenimento = ? ");

            PreparedStatement stmt = con.prepareStatement(sql.toString());

            int index = 1;

            if (serie.getNome() != null){
                stmt.setString(index++, serie.getNome());
            }
            if (serie.getGenero() != null) {
                stmt.setString(index++, serie.getGenero());
            }
            if (serie.getSinopse() != null) {
                stmt.setString(index++, serie.getSinopse());
            }
            if (serie.getAnoLancamento() != null) {
                stmt.setString(index++, serie.getAnoLancamento());
            }
            if (serie.getClassificacao() != null) {
                stmt.setInt(index++, serie.getClassificacao());
            }
            if (serie.getPlataforma() != null) {
                stmt.setString(index++, serie.getPlataforma());
            }
            if (serie.getTemporadas() != null) {
                stmt.setInt(index++, serie.getTemporadas());
            }
            if (serie.getEpisodios() != null) {
                stmt.setInt(index++, serie.getEpisodios());
            }

            stmt.setInt(index, id);

            // Executa-se a consulta
            int res = stmt.executeUpdate();
            System.out.println("editarSerie.res=" + res);

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
            Statement stmt =con.createStatement();

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
}
