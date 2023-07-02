package DAO.product;

import DAO.DAO;
import bean.Bean;
import bean.CiboBean;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class CuraDAO implements DAO {
    private static final String TABLE_NAME = "Prodotto";
    private static DataSource ds;

    static {
        try {
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");

            ds = (DataSource) envCtx.lookup("jdbc/storage");

        } catch (NamingException e) {
            System.out.println("Error:" + e.getMessage());
        }
    }
    @Override
    public void doSave(Bean bean) throws SQLException {

    }

    @Override
    public boolean doDelete(Object key) throws SQLException {
        return false;
    }

    @Override
    public Bean doRetrieveByKey(Object categoria) throws SQLException {
        String code = (String) categoria;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        CiboBean bean = new CiboBean();

        String selectSQL = "SELECT * FROM " + CuraDAO.TABLE_NAME + " WHERE Categoria = ? ";

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setString(1, code);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                bean.setCodice(rs.getInt("Codice"));
                bean.setCategoria(rs.getString("Categoria"));
                bean.setImmagine(rs.getString("Immagine"));
                bean.setNome(rs.getString("Nome"));
                bean.setDisponibilita(rs.getInt("disponibilita"));
                bean.setPrezzo(rs.getFloat("prezzo"));
                bean.setDescrizioneBreve(rs.getString("DescrizioneBreve"));
                bean.setDescrizioneLunga(rs.getString("DescrizioneLunga"));
                bean.setNovita(rs.getBoolean("novita"));
                bean.setOfferta(rs.getBoolean("offerta"));
            }

        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } finally {
                if (connection != null)
                    connection.close();
            }
        }
        return bean;
    }

    @Override
    public Collection<Bean> doRetrieveAll(String order) throws SQLException {
        return null;
    }
    public synchronized void doUpdate(String column, int code, Object value) throws SQLException
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String selectSQL = "UPDATE "+ CuraDAO.TABLE_NAME + " as p SET "+column+"=? WHERE p.Codice="+code;

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);

            if(value instanceof String) {
                String val = (String) value;
                preparedStatement.setString(1, val);
            }
            if(value instanceof Integer) {
                int val= (Integer) value;
                preparedStatement.setInt(1, val);
            }
            if(value instanceof Double) {
                double val=(Double) value;
                preparedStatement.setDouble(1, val);
            }
            if(value instanceof Boolean) {
                boolean val=(Boolean) value;
                preparedStatement.setBoolean(1, val);
            }

            preparedStatement.executeUpdate();
            connection.commit();
        }

        finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } finally {
                if (connection != null)
                    connection.close();
            }
        }
    }

}
