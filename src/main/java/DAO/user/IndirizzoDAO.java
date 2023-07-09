package DAO.user;

import DAO.DAO;
import bean.Bean;
import bean.IndirizzoBean;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

public class IndirizzoDAO implements DAO {
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
    private static final String TABLE_NAME = "indirizzo";


    @Override
    public void doSave(Bean indirizzo) throws SQLException {
        IndirizzoBean c=(IndirizzoBean) indirizzo;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String insertSQL = "INSERT INTO " + IndirizzoDAO.TABLE_NAME
                + " (codiceInridizzo,via,civico,citta,cap) VALUES (?, ?, ?, ?, ?)";

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setInt(1, c.getCodiceIndirizzo());
            preparedStatement.setString(2, c.getVia());
            preparedStatement.setInt(3, c.getCivico());
            preparedStatement.setString(4, c.getCittà());
            preparedStatement.setInt(5, c.getCap());
            preparedStatement.executeUpdate();
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
    public boolean doDelete(Object codice) throws SQLException {
        int code=(int) codice;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        int result = 0;

        String deleteSQL = "DELETE FROM " + IndirizzoDAO.TABLE_NAME + " WHERE codiceIndirizzo = ?";

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setInt(1, code);

            result = preparedStatement.executeUpdate();

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
    public Collection<Bean> doRetrieveByKey(Object key) throws SQLException {

        int codiceIndirizzo= (int) key;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        IndirizzoBean bean = new IndirizzoBean();
        Collection<Bean> Bean= new LinkedList<>();

        String selectSQL = "SELECT * FROM " + IndirizzoDAO.TABLE_NAME + " WHERE codiceIndirizzo = ?";

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setInt(1, codiceIndirizzo);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                bean.setCodiceIndirizzo(rs.getInt("codiceIndirizzo"));
                bean.setCittà(rs.getString("citta"));
                bean.setVia((rs.getString("via")));
                bean.setCivico(rs.getInt("civico"));
                bean.setCap(rs.getInt("cap"));
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
    
    @Override
    public Collection<Bean> doRetrieveAll(String order) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        Collection<Bean> Indirizzo = new LinkedList<Bean>();

        String selectSQL = "SELECT * FROM " + IndirizzoDAO.TABLE_NAME;

        if (order != null && !order.equals("")) {
            selectSQL += " ORDER BY " + order;
        }

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                IndirizzoBean bean = new IndirizzoBean();

                bean.setCodiceIndirizzo(rs.getInt("codiceIndirizzo"));
                bean.setVia((rs.getString("via")));
                bean.setCivico(rs.getInt("civico"));
                bean.setCittà(rs.getString("citta"));
                bean.setCap(rs.getInt("cap"));
                Indirizzo.add(bean);
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
        return Indirizzo;
    }
}

