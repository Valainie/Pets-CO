package DAO.user.model.acquisto;

import DAO.user.model.DAO;
import bean.MetodoDiPagamentoBean;
import bean.PBean;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class metodoPDAO implements DAO {
    private static DataSource ds;

    static {
        try {
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");

            ds = (DataSource) envCtx.lookup("jdbc/GameporiumDB");

        } catch (NamingException e) {
            System.out.println("Error:" + e.getMessage());
        }
    }

    private static final String TABLE_NAME = "Metodo_di_Pagamento";

    public synchronized void customDoSave( String username) throws SQLException {
        MetodoDiPagamentoBean c= new MetodoDiPagamentoBean;
        Connection connection = null;
        PreparedStatement entStatement = null;
        PreparedStatement relStatement = null;

        String insertSQL = "INSERT INTO " + metodoPDAO.TABLE_NAME
                + " (circuito,numCarta,cvv,scadenza) VALUES (?, ?, ?, ?)";

        String insertRel = "INSERT INTO Possiede (User,numCarta) VALUES (?, ?)";

        try {
            connection = ds.getConnection();
            entStatement = connection.prepareStatement(insertSQL);
            entStatement.setString(1, c.getCircuito());
            entStatement.setInt(2, c.getNumCarta());
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

    public synchronized MetodoDiPagamentoBean doRetrieveByKey(Object key) throws SQLException {

        int CodiceMetodo= (int) key;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        MetodoDiPagamentoBean bean = new MetodoDiPagamentoBean();

        String selectSQL = "SELECT * FROM " + metodoPDAO.TABLE_NAME + " WHERE numCarta = ?";

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setInt(1, CodiceMetodo);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                bean.setNumCarta(BigInteger.valueOf((rs.getLong("numCarta"))));
                bean.setCvv(rs.getInt("cvv"));
                bean.setCircuito(((ResultSet) rs).getString("circuito"));
                bean.setScadenza(rs.getString("scadenza"));
                bean.setSecureCode();
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
    public boolean doDelete(int code) throws SQLException {
        return false;
    }

    @Override
    public PBean doRetrieveByKey(int code) throws SQLException {
        return null;
    }

    @Override
    public Collection<PBean> doRetrieveAll(String codice) throws SQLException {
        return null;
    }

    @Override
    public Collection<PBean> doRetrieveByResearch(String ric) throws SQLException {
        return null;
    }
}
