package DAO.product;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import DAO.DAO;
import bean.Bean;
import bean.PBean;

public class PModelDS implements DAO {
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

    private Object codice;


    @Override
    public synchronized  void doSave(Bean product) throws SQLException {
        PBean p = (PBean) product;

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String insertSQL = "INSERT INTO " + PModelDS.TABLE_NAME
                + " (Codice, Categoria, Immagine, Nome, disponibilita, prezzo, DescrizioneLunga, DescrizioneBreve, novita, offerta, IVA) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setInt(1, p.getCodice());
            preparedStatement.setString(2, p.getCategoria());
            preparedStatement.setString(3, p.getImmagine());
            preparedStatement.setString(4, p.getNome());
            preparedStatement.setInt(5, p.getDisponibilita());
            preparedStatement.setBigDecimal(6, BigDecimal.valueOf(p.getPrezzo()));
            preparedStatement.setString(7, p.getDescrizioneBreve());
            preparedStatement.setString(8, p.getDescrizioneLunga());
            preparedStatement.setBoolean(9, p.isNovita());
            preparedStatement.setBoolean(10, p.isOfferta());
            preparedStatement.setInt(11,p.getIVA());


            preparedStatement.executeUpdate();

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
    }


    @Override
    public synchronized boolean doDelete(Object key) throws SQLException {
        int code = (int) codice;
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
    public synchronized  Collection<Bean> doRetrieveByKey(Object key) throws SQLException {
        int code = (int) codice;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        PBean bean = new PBean();
        Collection <Bean> Bean = new LinkedList<>();

        String selectSQL = "SELECT * FROM " + PModelDS.TABLE_NAME + " WHERE Codice = ?";

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setInt(1, code);

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
                bean.setIVA(rs.getInt("IVA"));

                Bean.add(bean);
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
        return Bean;
    }
/*LA JSON JsonRevtrieveForHomeServlet PRENDE DA QUI GLI ATRIBUTI DELLA TABELLA PRODOTTO NECESSARI PER IL CATALOGO/HOME PAGE*/
    public synchronized Collection<PBean> doRetrieveHome() throws SQLException{
        String order = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        Collection<PBean> product = new LinkedList<>();

        String selectSQL = "SELECT Codice,Immagine,Nome,Disponibilita,prezzo,DescrizioneBreve FROM Prodotto ";

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
                bean.setImmagine(rs.getString("Immagine"));
                bean.setNome(rs.getString("Nome"));
                bean.setDescrizioneBreve(rs.getString("DescrizioneBreve"));
                bean.setDisponibilita(rs.getInt("disponibilita"));
                bean.setPrezzo(rs.getFloat("prezzo"));
                bean.setIVA(22);

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

    public synchronized Collection<Bean> doRetrieveAll(String codice) throws SQLException {
        String order = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        Collection<Bean> product = new LinkedList<Bean>();

        String selectSQL = "SELECT * FROM Prodotto";

        PBean bean = null;
        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                bean = new PBean();
                bean.setCodice(rs.getInt("Codice"));
                bean.setCategoria(rs.getString("Categoria"));
                bean.setNome(rs.getString("Nome"));
                bean.setImmagine(rs.getString("Immagine"));
                bean.setDescrizioneBreve(rs.getString("DescrizioneBreve"));
                bean.setDescrizioneLunga(rs.getString("DescrizioneLunga"));
                bean.setDisponibilita(rs.getInt("disponibilita"));
                bean.setPrezzo(rs.getFloat("Prezzo"));
                bean.setNovita(rs.getBoolean("novita"));
                bean.setOfferta(rs.getBoolean("offerta"));
                bean.setIVA(rs.getInt("IVA"));

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


    public synchronized Collection<PBean> doRetrieveByBool(String no, boolean b) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        Collection<PBean> product = new LinkedList<PBean>();

        String selectSQL = "SELECT * FROM " + PModelDS.TABLE_NAME + " WHERE " + no + "= ? ORDER BY Codice";

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setBoolean(1, b);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                PBean bean = new PBean();
                bean.setCodice(rs.getInt("Codice"));
                bean.setCategoria(rs.getString("Categoria"));
                bean.setNome(rs.getString("Nome"));
                bean.setImmagine(rs.getString("Immagine"));
                bean.setDescrizioneBreve(rs.getString("DescrizioneBreve"));
                bean.setDescrizioneLunga(rs.getString("DescrizioneLunga"));
                bean.setDisponibilita(rs.getInt("disponibilita"));
                bean.setPrezzo(rs.getFloat("Prezzo"));
                bean.setNovita(rs.getBoolean("novita"));
                bean.setOfferta(rs.getBoolean("offerta"));
                bean.setIVA(rs.getInt("IVA"));

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

        Collection<Bean> product = new LinkedList<Bean>();

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
                bean.setCategoria(rs.getString("Categoria"));
                bean.setNome(rs.getString("Nome"));
                bean.setImmagine(rs.getString("Immagine"));
                bean.setDescrizioneBreve(rs.getString("DescrizioneBreve"));
                bean.setDescrizioneLunga(rs.getString("DescrizioneLunga"));
                bean.setDisponibilita(rs.getInt("disponibilita"));
                bean.setPrezzo(rs.getFloat("Prezzo"));
                bean.setNovita(rs.getBoolean("novita"));
                bean.setOfferta(rs.getBoolean("offerta"));
                bean.setIVA(rs.getInt("IVA"));

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
                bean.setCategoria(rs.getString("Categoria"));
                bean.setNome(rs.getString("Nome"));
                bean.setDescrizioneBreve(rs.getString("DescrizioneBreve"));
                bean.setDescrizioneLunga(rs.getString("DescrizioneLunga"));
                bean.setDisponibilita(rs.getInt("Disponibilita"));
                bean.setImmagine(rs.getString("Immagine"));
                bean.setPrezzo(rs.getFloat("prezzo"));
                bean.setOfferta(rs.getBoolean("Offerta"));
                bean.setIVA(rs.getInt("IVA"));

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

    public synchronized Collection<Bean> doRetrieveByResearch(String ric) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        Collection<Bean> product = new LinkedList<Bean>();
        String selectSQL = "SELECT * FROM " + PModelDS.TABLE_NAME + " WHERE MATCH (Nome, DescrizioneBreve) AGAINST ('" + ric + "')";

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                PBean bean = new PBean();
                bean.setCodice(rs.getInt("Codice"));
                bean.setCategoria(rs.getString("Categoria"));
                bean.setNome(rs.getString("Nome"));
                bean.setDescrizioneLunga(rs.getString("Immagine"));
                bean.setDescrizioneBreve(rs.getString("DescrizioneBreve"));
                bean.setDescrizioneLunga(rs.getString("DescrizioneLunga"));
                bean.setDisponibilita(rs.getInt("disponibilita"));
                bean.setPrezzo(rs.getFloat("Prezzo"));
                bean.setNovita(rs.getBoolean("novita"));
                bean.setOfferta(rs.getBoolean("offerta"));
                bean.setIVA(rs.getInt("IVA"));

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

    public synchronized void doUpdate(String column, int code, Object value) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String selectSQL = "UPDATE " + PModelDS.TABLE_NAME + " as p SET " + column + "= ? WHERE p.Codice=" + code;

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);

            if (value instanceof String) {
                String val = (String) value;
                preparedStatement.setString(1, val);
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
            if (value instanceof BigDecimal) {
                BigDecimal val = (BigDecimal) value;
                preparedStatement.setBigDecimal(1, val);
            }
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
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
    }

    public void Naviga (String tag, int codice){

        }

}

