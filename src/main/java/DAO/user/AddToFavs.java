package DAO.user;

import DAO.DAO;
import DAO.acquisto.AcquistoDAO;
import bean.AcquistoBean;
import bean.Bean;
import bean.PreferitiBean;

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

public class AddToFavs implements DAO {
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
    private static final String TABLE_NAME = "Preferiti";
    public synchronized void doCustomSave(Bean preferiti, String username) throws SQLException {
        PreferitiBean pb = (PreferitiBean) preferiti;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement relStatement = null;

        String selectSQL = "SELECT Codice FROM Prodotto as p JOIN Cliente as c on p.Codice=? and c.Username=?";

        String insertRel = "INSERT INTO Preferiti (Username,CodiceProdotto) VALUES (?, ?)";

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setInt(1, pb.getCodiceProdotto());
            preparedStatement.setString(2, pb.getUsername());

            relStatement = connection.prepareStatement(insertRel);
            relStatement.setString(1, pb.getUsername());
            relStatement.setInt(2, pb.getCodiceProdotto());

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
    public void doSave(Bean bean) throws SQLException {

    }

    @Override
     public synchronized boolean doDelete(Object codice) throws SQLException {
        int code=(int) codice;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        int result = 0;

        String deleteSQL = "DELETE FROM " + AddToFavs.TABLE_NAME + " WHERE Username = ?";

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
    public synchronized  Collection<Bean> doRetrieveByKey(Object username) throws SQLException {
        int code=(int) username;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        PreferitiBean bean = new PreferitiBean();
        Collection<Bean> preferiti= new LinkedList<>();

        String selectSQL = "SELECT * FROM " + AddToFavs.TABLE_NAME + " WHERE Username = ?";

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setInt(1, code);
            preferiti.add(bean);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                bean.setCodiceProdotto(rs.getInt("CodiceProdotto"));
                bean.setUsername(rs.getString("Username"));
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
        return preferiti;
    }

    @Override
    public Collection<Bean> doRetrieveAll(String order) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        System.out.println(order);
        Collection<Bean> Preferiti = new LinkedList<Bean>();

        String selectSQL = "SELECT * FROM " + AddToFavs.TABLE_NAME + " WHERE Username = ?";


        if (order != null && !order.equals("")) {
            selectSQL += " ORDER BY " + order;
        }

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                PreferitiBean bean = new PreferitiBean();

                bean.setCodiceProdotto(rs.getInt("CodiceProdotto"));
                bean.setUsername(rs.getString("UserName"));

                Preferiti.add(bean);
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
        return Preferiti;
    }    }

