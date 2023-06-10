package DAO.product;

import DAO.DAO;
import bean.Bean;
import bean.PBean;
import com.mysql.cj.xdevapi.AddStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class PModelDS implements DAO {
    private static final String TABLE_NAME= "Prodotto";
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

    private AddStatement product;
    private Object codice;




    @Override
    public void doSave(Bean bean) throws SQLException {

    }

    @Override
    public boolean doDelete(Object key) throws SQLException {
        int code=(int) codice;
        System.out.println(code);
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int result = 0;

        String deleteSQL = "DELETE FROM " + PModelDS.TABLE_NAME + " WHERE Codice = ?";

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setInt(1, code);
            result = preparedStatement.executeUpdate();
            System.out.println(deleteSQL);
            connection.commit();

        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } finally {
                if (connection != null)
                    connection.close();
            }
        }
        return (result != 0);
    }

    @Override
    public Bean doRetrieveByKey(Object key) throws SQLException {
        return null;
    }

    public Bean doRetrieveAll(String codice) throws SQLException {
        String order = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        Collection<PBean> products = new LinkedList<PBean>();

        String selectSQL = "SELECT * FROM Prodotto";

        if (order != null && !order.equals("")) {
            selectSQL += " ORDER BY" + order;
        }

        PBean bean = null;
        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                bean = new PBean();
                bean.setCodice(rs.getInt("Codice"));
                bean.setCategoria(rs.getInt("Categoria"));
                bean.setNome(rs.getString("Nome"));
                bean.setDescrizioneLunga(rs.getString("Immagine"));
                bean.setDescrizioneBreve(rs.getString("DescrizioneBreve"));
                bean.setDescrizioneLunga(rs.getString("DescrizioneLunga"));
                bean.setDisponibilita(rs.getInt("disponibilita"));
                bean.setPrezzo(rs.getFloat("Prezzo"));
                bean.setNovita(rs.getBoolean("novita"));
                bean.setOfferta(rs.getBoolean("offerta"));
                product.add(String.valueOf(bean));
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



    public synchronized Collection<PBean> doRetrieveByBool(String no, boolean b) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        Collection<PBean> product = new LinkedList<PBean>();

        String selectSQL = "SELECT * FROM " + PModelDS.TABLE_NAME + " WHERE " + no +"= ? ORDER BY Codice";

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setBoolean(1, b);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                PBean bean = new PBean();
                bean.setCodice(rs.getInt("Codice"));
                bean.setCategoria(rs.getInt("Categoria"));
                bean.setNome(rs.getString("Nome"));
                bean.setDescrizioneLunga(rs.getString("Immagine"));
                bean.setDescrizioneBreve(rs.getString("DescrizioneBreve"));
                bean.setDescrizioneLunga(rs.getString("DescrizioneLunga"));
                bean.setDisponibilita(rs.getInt("disponibilita"));
                bean.setPrezzo(rs.getFloat("Prezzo"));
                bean.setNovita(rs.getBoolean("novita"));
                bean.setOfferta(rs.getBoolean("offerta"));
                product.add(bean);
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
        return product;
    }

    public synchronized Collection<Bean> doRetrieveByTipo(String tipo, Object value) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        Collection<PBean> product = new LinkedList<PBean>();

        String selectSQL = "SELECT * FROM " + PModelDS.TABLE_NAME + " WHERE Categoria=? ";

        PBean bean = null;
        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);

            if (value instanceof String) {
                String val = (String) value;
                String param = "%" + val;
                preparedStatement.setString(1, param);
            }
            if (value instanceof Integer) {
                int val = (Integer) value;
                preparedStatement.setInt(1, val);
            }
            if (value instanceof Double) {
                double val = (Double) value;
                preparedStatement.setDouble(1, val);
            }
            if (value instanceof Boolean) {
                Boolean val = (Boolean) value;
                preparedStatement.setBoolean(1, val);
            }

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                bean = new PBean();
                bean.setCodice(rs.getInt("Codice"));
                bean.setCategoria(rs.getInt("Categoria"));
                bean.setNome(rs.getString("Nome"));
                bean.setDescrizioneLunga(rs.getString("Immagine"));
                bean.setDescrizioneBreve(rs.getString("DescrizioneBreve"));
                bean.setDescrizioneLunga(rs.getString("DescrizioneLunga"));
                bean.setDisponibilita(rs.getInt("disponibilita"));
                bean.setPrezzo(rs.getFloat("Prezzo"));
                bean.setNovita(rs.getBoolean("novita"));
                bean.setOfferta(rs.getBoolean("offerta"));
                product.add(bean);
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
        return (Collection<Bean>) bean;
    }



    public synchronized Collection<Bean> doRetrieveByTipo(String tipo) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        Collection<Bean> product = new LinkedList<>();

        String selectSQL = "SELECT * FROM " + PModelDS.TABLE_NAME + " as p JOIN " + tipo + " as t on p.Codice=t.Tipo";
        System.out.println(selectSQL);
        PBean bean = null;
        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                bean = new PBean();

                bean.setCodice(rs.getInt("Codice"));
                bean.setNome(rs.getString("Nome"));
                bean.setDescrizioneBreve(rs.getString("DescrizioneBreve"));
                bean.setDescrizioneLunga(rs.getString("DescrizioneLunga"));
                bean.setDisponibilita(rs.getInt("Disponibilita"));
                bean.setImmagine(rs.getString("Immagine"));
                bean.setPrezzo(rs.getFloat("prezzo"));
                bean.setOfferta(rs.getBoolean("Offerta"));
                product.add(bean);
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
        return Collections.singleton(bean);
    }

    public synchronized Collection<Bean> doRetrieveByResearch(String ric) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        Collection<Bean> product = new LinkedList<Bean>();
        String selectSQL = "SELECT * FROM " + PModelDS.TABLE_NAME + " WHERE MATCH (Nome, DescrizioneBreve) AGAINST ('"+ric+"')";

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                PBean bean = new PBean();
                bean.setCodice(rs.getInt("Codice"));
                bean.setCategoria(rs.getInt("Categoria"));
                bean.setNome(rs.getString("Nome"));
                bean.setDescrizioneLunga(rs.getString("Immagine"));
                bean.setDescrizioneBreve(rs.getString("DescrizioneBreve"));
                bean.setDescrizioneLunga(rs.getString("DescrizioneLunga"));
                bean.setDisponibilita(rs.getInt("disponibilita"));
                bean.setPrezzo(rs.getFloat("Prezzo"));
                bean.setNovita(rs.getBoolean("novita"));
                bean.setOfferta(rs.getBoolean("offerta"));
                product.add(bean);
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
        return product;
    }

    public synchronized void doUpdate(String column, int code, Object value) throws SQLException
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String selectSQL = "UPDATE "+ PModelDS.TABLE_NAME + " as p SET "+column+"= ? WHERE p.Codice="+code;

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
                Boolean val=(Boolean) value;
                preparedStatement.setBoolean(1, val);
            }
            if(value instanceof BigDecimal) {
                BigDecimal val=(BigDecimal) value;
                preparedStatement.setBigDecimal(1, val);
            }
            System.out.println(preparedStatement);
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

