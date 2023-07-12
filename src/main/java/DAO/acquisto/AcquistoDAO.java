package DAO.acquisto;

import DAO.DAO;
import bean.AcquistoBean;
import bean.Bean;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedList;

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
    private static final String TABLE_NAME = "Acquisto";



    public synchronized void customDoSave(Bean acquisto, String username) throws SQLException {

        AcquistoBean a=(AcquistoBean) acquisto;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement relStatement = null;

        String insertSQL = "INSERT INTO " + AcquistoDAO.TABLE_NAME
                + " (codiceAcquisto,indirizzoSpedizione, dataOrdine, dataSpedizione, importo, statoProdotti, metodo) VALUES (?, ?, ?, ?, ?, ?, ?)";

        String insertRel = "INSERT INTO Effettua(username,codiceAcquisto) VALUES (?, ?)";

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setInt(1, a.getCodiceAcquisto());
            preparedStatement.setString(2, a.getIndirizzoSpedizione());
            preparedStatement.setDate(3, Date.valueOf(a.getDataOrdine()));
            preparedStatement.setDate(4, Date.valueOf(a.getDataSpedizione()));
            preparedStatement.setBigDecimal(5, a.getImporto());
            preparedStatement.setString(6, a.getStatoProdotti());
            preparedStatement.setLong(7, a.getMetodo());
            preparedStatement.executeUpdate();

            relStatement = connection.prepareStatement(insertRel);
            relStatement.setString(1, username);
            relStatement.setLong(2, a.getCodiceAcquisto());
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


    @Override
    public synchronized void doSave(Bean bean) throws SQLException {

    }

    @Override
    public synchronized boolean doDelete(Object codice) throws SQLException {
        int code=(int) codice;
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
    public synchronized Collection<Bean>  doRetrieveByKey(Object username) throws SQLException {

        int code=(int) username;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Collection<Bean> Bean = new LinkedList<>();

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
                bean.setDataOrdine(rs.getDate("dataOrdine").toLocalDate());
                bean.setDataSpedizione(rs.getDate("dataSpedizione").toLocalDate());
                bean.setImporto(rs.getBigDecimal("importo"));
                bean.setStatoProdotti(rs.getString("statoProdotti"));
                bean.setMetodo(rs.getLong("metodo"));
                bean.setSecureCode();
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
    public synchronized Collection<Bean> doRetrieveAll(String order) throws SQLException {
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

                bean.setCodiceAcquisto(rs.getInt("codiceOrdine"));
                bean.setIndirizzoSpedizione(rs.getString("indirizzoSpedizione"));
                bean.setDataOrdine(rs.getDate("dataOrdine").toLocalDate());
                bean.setDataSpedizione(rs.getDate("dataSpedizione").toLocalDate());
                bean.setImporto(rs.getBigDecimal("importo"));
                bean.setStatoProdotti(rs.getString("statoProdotti"));
                bean.setMetodo(rs.getLong("metodo"));
                bean.setUsername(rs.getString("username"));
                bean.setSecureCode();
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

    public synchronized Collection<Bean> doRetrieveByUser(String user) throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        Collection<Bean> Acquisto = new LinkedList<Bean>();

        String selectSQL = "SELECT * FROM " + AcquistoDAO.TABLE_NAME +" as a JOIN Effettua as e on a.codiceAcquisto=e.codiceAcquisto WHERE username=?";
        selectSQL += " ORDER BY dataOrdine";
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
                bean.setDataOrdine(rs.getDate("dataAcquisto").toLocalDate());
                bean.setDataSpedizione(rs.getDate("dataSpedizione").toLocalDate());
                bean.setImporto(rs.getBigDecimal("importo"));
                bean.setStatoProdotti(rs.getString("statoProdotti"));
                bean.setMetodo(rs.getLong("metodo"));
                bean.setUsername(rs.getString("username"));
                bean.setSecureCode();
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

    public synchronized Collection<Bean> doRetrieveByDateFrom(LocalDate da) throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        Collection<Bean> Acquisto = new LinkedList<Bean>();

        String selectSQL = "SELECT * FROM " + AcquistoDAO.TABLE_NAME + " as a JOIN Effettua as e on e.codiceAcquisto=a.codiceAcquisto WHERE dataOrdine >='" + da+"'";

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);
            System.out.println(selectSQL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                AcquistoBean bean = new AcquistoBean();

                bean.setCodiceAcquisto(rs.getInt("codiceAcquisto"));
                bean.setIndirizzoSpedizione(rs.getString("indirizzoSpedizione"));
                bean.setDataOrdine(rs.getDate("dataOrdine").toLocalDate());
                bean.setDataSpedizione(rs.getDate("dataSpedizione").toLocalDate());
                bean.setImporto(rs.getBigDecimal("importo"));
                bean.setStatoProdotti(rs.getString("statoProdotti"));
                bean.setMetodo(rs.getLong("metodo"));
                bean.setUsername(rs.getString("username"));
                bean.setSecureCode();
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

        String selectSQL = "SELECT * FROM " + AcquistoDAO.TABLE_NAME + " as a JOIN Effettua as e on e.codiceAcquisto=a.codiceAcquisto WHERE dataOrdine <='" + a +"'";
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
                bean.setImporto(rs.getBigDecimal("importo"));
                bean.setStatoProdotti(rs.getString("statoProdotti"));
                bean.setMetodo(rs.getLong("metodo"));
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

        String selectSQL = "SELECT * FROM " + AcquistoDAO.TABLE_NAME + " as a JOIN Effettua as e on e.codiceAcquisto=a.codiceAcquisto  WHERE dataOrdine between '" + da + "' and '" + a + "'";

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                AcquistoBean bean = new AcquistoBean();

                bean.setCodiceAcquisto(rs.getInt("codiceAcquisto"));
                bean.setIndirizzoSpedizione(rs.getString("indirizzoSpedizione"));
                bean.setDataOrdine(rs.getDate("dataOrdine").toLocalDate());
                bean.setDataSpedizione(rs.getDate("dataSpedizione").toLocalDate());
                bean.setImporto(rs.getBigDecimal("importo"));
                bean.setStatoProdotti(rs.getString("statoProdotti"));
                bean.setMetodo(rs.getLong("metodo"));
                bean.setUsername(rs.getString("username"));
                bean.setSecureCode();
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

        String selectSQL = "SELECT * FROM " + AcquistoDAO.TABLE_NAME + " as a JOIN Effettua as e on a.codiceAcquisto=e.codiceAcquisto WHERE username= ? and dataOrdine between '" + da + "' and '" + a + "'";

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
                bean.setImporto(rs.getBigDecimal("importo"));
                bean.setStatoProdotti(rs.getString("statoProdotti"));
                bean.setMetodo(rs.getLong("metodo"));
                bean.setUsername(rs.getString("username"));
                bean.setSecureCode();
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

        int maxOrderCode=0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String selectSQL = "SELECT MAX(codiceAcquisto) FROM "+ AcquistoDAO.TABLE_NAME +";";
        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);

            ResultSet rs = preparedStatement.executeQuery();
            connection.commit();
            if (rs.next()) {
                maxOrderCode = rs.getInt("MAX(codiceOrdine)");
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

        return maxOrderCode;
    }


}

