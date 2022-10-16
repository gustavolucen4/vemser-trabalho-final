package com.dbc.repository;

import com.dbc.exceptions.BancoDeDadosException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class IndicacaoRepository {

    public boolean indicar(Integer idUsuario, String nomeItem) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            String sql = "INSERT INTO INDICACAO\n" +
                    "(id_usuario, nome_item)\n" +
                    "VALUES(?, ?)";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, idUsuario);
            stmt.setString(2, nomeItem);

            // Executa-se a consulta
            int res = stmt.executeUpdate();

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

}
