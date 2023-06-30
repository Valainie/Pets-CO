package DAO.acquisto;

import java.math.BigInteger;
import java.sql.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import DAO.DAO;
import bean.AcquistoBean;
import bean.Bean;

public class AcquistoDAO implements DAO {

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

    public synchronized void customDoSave(Bean acquisto, String username) throws SQLException {

        AcquistoBean o=(AcquistoBean) acquisto;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement relStatement = null;

        String insertSQL = "INSERT INTO " + AcquistoDAO.TABLE_NAME
                + " (codiceAcquisto, indirizzoSpedizione, dataOrdine, dataSpedizione, importo, statoProdotti, metodo) VALUES (?, ?, ?, ?, ?, ?, ?)";

        String insertRel = "INSERT INTO Effettua(username,codiceAcquisto) VALUES (?, ?)";

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setInt(1, o.getCodiceAcquisto());
            preparedStatement.setString(2, o.getIndirizzoSpedizione());
            preparedStatement.setDate(3, Date.valueOf(o.getDataOrdine()));
            preparedStatement.setDate(4, Date.valueOf(o.getDataSpedizione()));
            preparedStatement.setFloat(5, o.getImporto());
            preparedStatement.setString(6, o.getStatoProdotti());
            preparedStatement.setString(7, String.valueOf(o.getMetodo()));
            preparedStatement.executeUpdate();

            relStatement = connection.prepareStatement(insertRel);
            relStatement.setString(1, username);
            relStatement.setLong(2, o.getCodiceAcquisto());
            relStatement.executeUpdate();

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

    private static final String TABLE_NAME = "Acquisto";
    @Override
    public void doSave(Bean bean) throws SQLException {

    }

    @Override
    public boolean doDelete(Object key) throws SQLException {

        int code=(int) key;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        int result = 0;

        String deleteSQL = "DELETE FROM " + AcquistoDAO.TABLE_NAME + " WHERE codiceAcquisto = ?";

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
    public Bean doRetrieveByKey(Object acquisto) throws SQLException {
        int code=(int) acquisto;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        AcquistoBean bean = new AcquistoBean();

        String selectSQL = "SELECT * FROM " + AcquistoDAO.TABLE_NAME + " WHERE codiceAcquisto = ?";

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setInt(1, code);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                bean.setCodiceAcquisto(rs.getInt("codiceAcquisto"));
                bean.setIndirizzoSpedizione(rs.getString("indirizzoSpedizione"));
                bean.setDataOrdine(rs.getDate("dataSpedizione").toLocalDate());
                bean.setDataSpedizione(rs.getDate("dataSpedizione").toLocalDate());
                bean.setImporto(rs.getFloat("importo"));
                bean.setStatoProdotti(rs.getString("statoProdotti"));
                bean.setMetodo(BigInteger.valueOf(rs.getLong("metodo")));

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
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        System.out.println(order);
        Collection<Bean> Acquisto = new LinkedList<>();

        String selectSQL = "SELECT o.codiceAcquisto, o.indirizzoSpedizione, o.dataOrdine, o.dataSpedizione, o.importo, o.statoProdotti, o.metodo, e.username\r\n" +
                " FROM " + AcquistoDAO.TABLE_NAME +" as o JOIN Effettua as e on o.codiceAcquisto=e.codiceAcquisto";

        if (order != null && !order.equals("")) {
            selectSQL += " ORDER BY " + order;
        }

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                AcquistoBean bean = new AcquistoBean();

                bean.setCodiceAcquisto(rs.getInt("codiceAcquisto"));
                bean.setIndirizzoSpedizione(rs.getString("indirizzoSpedizione"));
                bean.setDataOrdine(rs.getDate("dataSpedizione").toLocalDate());
                bean.setDataSpedizione(rs.getDate("dataSpedizione").toLocalDate());
                bean.setImporto(rs.getFloat("importo"));
                bean.setStatoProdotti(rs.getString("statoProdotti"));
                bean.setMetodo(BigInteger.valueOf(rs.getLong("metodo")));
                bean.setUsername(rs.getString("username"));
                Acquisto.add(bean);
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
        return Acquisto;
    }
    public synchronized Collection<Bean> doRetrieveByDateTo(LocalDate a) throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        Collection<Bean> Acquisto = new LinkedList<Bean>();

        String selectSQL = "SELECT * FROM " + AcquistoDAO.TABLE_NAME + " as o JOIN Effettua as e on e.codiceAcquisto=o.codiceAcquisto WHERE dataOrdine <='" + a +"'";
        System.out.println(selectSQL);
        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                AcquistoBean bean = new AcquistoBean();

                bean.setCodiceAcquisto(rs.getInt("codiceAcquisto"));
                bean.setIndirizzoSpedizione(rs.getString("indirizzoSpedizione"));
                bean.setDataOrdine(rs.getDate("dataSpedizione").toLocalDate());
                bean.setDataSpedizione(rs.getDate("dataSpedizione").toLocalDate());
                bean.setImporto(rs.getFloat("importo"));
                bean.setStatoProdotti(rs.getString("statoProdotti"));
                bean.setMetodo(BigInteger.valueOf(rs.getInt("metodo")));
                bean.setUsername(rs.getString("username"));
                Acquisto.add(bean);

                System.out.println(Acquisto);
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
        return Acquisto;
    }

    public synchronized Collection<Bean> doRetrieveByDateBetween(LocalDate da, LocalDate a) throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        Collection<Bean> Acquisto = new LinkedList<Bean>();

        String selectSQL = "SELECT * FROM " + AcquistoDAO.TABLE_NAME + " as o JOIN Effettua as e on e.codiceAcquisto=o.codiceAcquisto WHERE dataOrdine between '" + da + "' and '" + a + "'";

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                AcquistoBean bean = new AcquistoBean();

                bean.setCodiceAcquisto(rs.getInt("codiceAcquisto"));
                bean.setIndirizzoSpedizione(rs.getString("indirizzoSpedizione"));
                bean.setDataOrdine(rs.getDate("dataSpedizione").toLocalDate());
                bean.setDataSpedizione(rs.getDate("dataSpedizione").toLocalDate());
                bean.setImporto(rs.getFloat("importo"));
                bean.setStatoProdotti(rs.getString("statoProdotti"));
                bean.setMetodo(BigInteger.valueOf(rs.getInt("metodo")));
                bean.setUsername(rs.getString("username"));
                Acquisto.add(bean);
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
        return Acquisto;
    }


    public synchronized Collection<Bean> doRetrieveByUserBetweenDate(LocalDate da, LocalDate a, String user) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        Collection<Bean> Acquisto = new LinkedList<Bean>();

        String selectSQL = "SELECT * FROM " + AcquistoDAO.TABLE_NAME + " as o JOIN Effettua as e on o.codiceAcquisto=e.codiceAcquisto WHERE username= ? and dataOrdine between '" + da + "' and '" + a + "'";

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setString(1, user);
            System.out.println(selectSQL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                AcquistoBean bean = new AcquistoBean();

                bean.setCodiceAcquisto(rs.getInt("codiceAcquisto"));
                bean.setIndirizzoSpedizione(rs.getString("indirizzoSpedizione"));
                bean.setDataOrdine(rs.getDate("dataSpedizione").toLocalDate());
                bean.setDataSpedizione(rs.getDate("dataSpedizione").toLocalDate());
                bean.setImporto(rs.getFloat("importo"));
                bean.setStatoProdotti(rs.getString("statoProdotti"));
                bean.setMetodo(BigInteger.valueOf(rs.getInt("metodo")));
                bean.setUsername(rs.getString("username"));
                Acquisto.add(bean);
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
        return Acquisto;
    }

    public synchronized int getMaxOrderCode() throws SQLException {

        int maxAcqCode=0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String selectSQL = "SELECT MAX(codiceAcquisto) FROM "+ AcquistoDAO.TABLE_NAME +";";
        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);

            ResultSet rs = preparedStatement.executeQuery();
            connection.commit();
            if (rs.next()) {
                maxAcqCode = rs.getInt("MAX(codiceAcquisto)");
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

        return maxAcqCode;
    }


}
