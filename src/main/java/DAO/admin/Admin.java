package DAO.admin;

import DAO.DAO;
import bean.AdminBean;
import bean.Bean;

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

public class Admin implements DAO {

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

    private static final String TABLE_NAME = "Admin";

    @Override
    public void doSave(Bean admin) throws SQLException {
        AdminBean a = (AdminBean) admin;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String insertSQL = "INSERT INTO " + Admin.TABLE_NAME
                + " (Recapito,Username,Password,Nome,Cognome) VALUES (?, ?, ?, ?, ?)";

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setString(1, a.getRecapito());
            preparedStatement.setString(2, a.getUsername());
            preparedStatement.setString(3, a.getPassword());
            preparedStatement.setString(4, a.getNome());
            preparedStatement.setString(5, a.getCognome());
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
    public boolean doDelete(Object code) throws SQLException {
        String username=(String) code;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        int result = 0;

        String deleteSQL = "DELETE FROM " + Admin.TABLE_NAME + " WHERE username = ?";

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setString(1, username);

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
    public Collection<Bean> doRetrieveByKey(Object codice) throws SQLException {
        String username=(String) codice;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        AdminBean b = new AdminBean();

        String selectSQL = "SELECT * FROM " + Admin.TABLE_NAME + " WHERE username = ?";

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setString(1, username);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                b.setRecapito(rs.getString("Recapito"));
                b.setUsername(rs.getString("Username"));
                b.setPassword(rs.getString("Password"));
                b.setNome(rs.getString("Nome"));
                b.setCognome(rs.getString("Cognome"));
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
        return null;
    }

    @Override
    public Collection<Bean> doRetrieveAll(String order) throws SQLException {
         Connection connection = null;
        PreparedStatement preparedStatement = null;

        Collection<Bean> Amministratore = new LinkedList<Bean>();

        String selectSQL = "SELECT * FROM " + Admin.TABLE_NAME;

        if (order != null && !order.equals("")) {
            selectSQL += " ORDER BY " + order;
        }

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                AdminBean bean = new AdminBean();
                bean.setRecapito(rs.getString("Recapito"));
                bean.setUsername(rs.getString("Username"));
                bean.setPassword(rs.getString("Password"));
                bean.setCognome(rs.getString("Nome"));
                bean.setNome(rs.getString("Cognome"));

                Amministratore.add(bean);
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
        return  Amministratore;
    }

    public synchronized AdminBean doRetrieveByUserPass(String user, String pass) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        AdminBean bean = new AdminBean();

        String selectSQL = "SELECT * FROM " + Admin.TABLE_NAME + " WHERE Username = ? AND `Password` = ?";

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, pass);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                bean.setRecapito(rs.getString("Recapito"));
                bean.setUsername(rs.getString("Username"));
                bean.setPassword(rs.getString("Password"));
                bean.setCognome(rs.getString("Nome"));
                bean.setNome(rs.getString("Cognome"));
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
}