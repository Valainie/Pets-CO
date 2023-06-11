package DAO.acquisto;

import DAO.DAO;
import bean.Bean;
import bean.MetodoDiPagamentoBean;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.RandomAccess;

public class MetodoPDAO implements DAO {
    private static DataSource ds;

    static {
        try {
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");

            ds = (DataSource) envCtx.lookup("jdbc/PetsECo");

        } catch (NamingException e) {
            System.out.println("Error:" + e.getMessage());
        }
    }

    private static final String TABLE_NAME = "Metodo_di_Pagamento";
    public synchronized void customDoSave(MetodoDiPagamentoBean pagamento, String username) throws SQLException {
        MetodoDiPagamentoBean c= (MetodoDiPagamentoBean) pagamento;
        Connection connection = null;
        PreparedStatement entStatement = null;
        PreparedStatement relStatement = null;

        String insertSQL = "INSERT INTO " + MetodoPDAO.TABLE_NAME
                + " (circuito,numCarta,cvv,scadenza) VALUES (?, ?, ?, ?)";

        String insertRel = "INSERT INTO Possiede(User,numCarta) VALUES (?, ?)";

        try {
            connection = ds.getConnection();
            entStatement = connection.prepareStatement(insertSQL);
            entStatement.setString(1, c.getCircuito());
            entStatement.setLong(2, c.getNumCarta());
            entStatement.setInt(3, c.getCvv());
            entStatement.setString(4, c.getScadenza());
            entStatement.executeUpdate();

            relStatement = connection.prepareStatement(insertRel);
            relStatement.setString(1, username);
            relStatement.setLong(2, c.getNumCarta());
            relStatement.executeUpdate();

            connection.commit();
        } finally {
            try {
                if (entStatement != null && relStatement!= null)
                {
                    entStatement.close();
                    relStatement.close();
                }
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
    public boolean doDelete(Object codice) throws SQLException {
        long code=(long) codice;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        int result = 0;

        String deleteSQL = "DELETE FROM " + MetodoPDAO.TABLE_NAME + " WHERE numCarta = ?";

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setLong(1, code);

            result = preparedStatement.executeUpdate();
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

        int CodiceMetodo= (int) key;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        MetodoDiPagamentoBean bean = new MetodoDiPagamentoBean();

        String selectSQL = "SELECT * FROM " + MetodoPDAO.TABLE_NAME + " WHERE numCarta = ?";

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setInt(1, CodiceMetodo);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                bean.setNumCarta((rs.getInt("numCarta")));
                bean.setCvv(rs.getInt("cvv"));
                bean.setCircuito(rs.getString("circuito"));
                bean.setScadenza(rs.getString("scadenza"));
                bean.setPin();
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
    public RandomAccess doRetrieveAll(String order) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        ArrayList<MetodoPDAO> pagamento = new ArrayList<MetodoPDAO>();

        String selectSQL = "SELECT * FROM " + MetodoPDAO.TABLE_NAME;

        if (order != null && !order.equals("")) {
            selectSQL += " ORDER BY " + order;
        }

        MetodoDiPagamentoBean bean = null;
        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                bean = new MetodoDiPagamentoBean();

                bean.setNumCarta((rs.getInt("numCarta")));
                bean.setCvv(rs.getInt("cvv"));
                bean.setCircuito(rs.getString("circuito"));
                bean.setScadenza(rs.getString("scadenza"));
                bean.setPin();
                pagamento.add(new MetodoPDAO());
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
        return pagamento;
    }
    public synchronized Collection<Bean> doRetrieveByUser(String user) throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        Collection<Bean> Pagamento = new LinkedList<Bean>();

        String selectSQL = "SELECT * FROM " + MetodoPDAO.TABLE_NAME +" as p JOIN Possiede as po on p.numCarta=po.numCarta WHERE User=?";

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setString(1, user);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                MetodoDiPagamentoBean bean = new MetodoDiPagamentoBean();

                bean.setCircuito(rs.getString("circuito"));
                bean.setNumCarta(rs.getInt("numCarta"));
                bean.setCvv(rs.getInt("cvv"));
                bean.setScadenza(rs.getString("scadenza"));
                bean.setPin();
                bean.add();
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
        return Pagamento;
    }
}