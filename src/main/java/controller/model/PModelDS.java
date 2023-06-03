package controller.model;

import bean.PBean;
import com.mysql.cj.xdevapi.AddStatement;
import com.mysql.cj.xdevapi.DbDoc;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

public class PModelDS implements PModel {
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

    @Override
    public void doSave(PBean product) throws SQLException {

        PreparedStatement ps =ds.getConnection().prepareStatement(
                "Insert into Prodotto"+
               "(Codice,Categoria,Nome,DescrizioneBreve,DescrizioneLunga,Immagine,Prezzo,novita,offerta) VALUES (?,?,?,?,?,?,?,?,?)");
        try {
            ps.setInt(1, product.getCodice());
            ps.setInt(2,product.getCategoria());
            ps.setString(3, product.getNome());
            ps.setString(4, product.getDescrizioneBreve());
            ps.setString(5, product.getDescrizioneLunga());
            ps.setString(6, product.getImmagine());
            ps.setFloat(7, product.getPrezzo());
            ps.setBoolean(8, product.getNovita());
            ps.setBoolean(9, product.getOfferta());



            int rs = ps.executeUpdate();
        } finally {
            try {
                if (ds != null)
                    ps.close();
            } finally {
                if (ps != null)
                    ps.close();
            }
        }
    }

    @Override
    public boolean doDelete(int code) throws SQLException {

//SO CHE PRODOTTO NON HO PIU, QUINDI DO IL, CODICE E MI CANCELLA IL PRODOTTO DAL CATALOGO
        PreparedStatement ps1 =ds.getConnection().prepareStatement(
                "DELETE from Prodotto Where Codice=?");
        try {
            ps1.setInt(1, code);
            int rs = ps1.executeUpdate();
        } finally {
            try {
                if (ds != null)
                    ps1.close();
            } finally {
                if (ps1 != null)
                    ps1.close();
            }
        }
        return false;
    }

    @Override
    public PBean doRetrieveByKey(int codice) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        PBean bean = new PBean();

        String selectSQL = "SELECT * FROM Prodotto WHERE Codice = ?";

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setInt(1, codice);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
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
                product.add((DbDoc) bean);
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
    public Collection<PBean> doRetrieveAll(String codice) throws SQLException {
        String order = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        Collection<PBean> products = new LinkedList<PBean>();

        String selectSQL = "SELECT * FROM Prodotto";

        if (order != null && !order.equals("")) {
            selectSQL += " ORDER BY" + order;
        }

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
                product.add((DbDoc) bean);
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
        return products;
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

    public synchronized Collection<PBean> doRetrieveByTipo(String tipo, Object value) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        Collection<PBean> product = new LinkedList<PBean>();

        String selectSQL = "SELECT * FROM " + PModelDS.TABLE_NAME + " WHERE Categoria=? ";

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);

            if(value instanceof String) {
                String val = (String) value;
                String param="%"+val;
                preparedStatement.setString(1, param);
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



    public synchronized Collection<PBean> doRetrieveByTipo(String tipo) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        Collection<PBean> product = new LinkedList<PBean>();

        String selectSQL = "SELECT * FROM " + PModelDS.TABLE_NAME +" as p JOIN "+ tipo +" as t on p.Codice=t.Tipo";
        System.out.println(selectSQL);
        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                PBean bean = new PBean();

                bean.setCodice(rs.getInt("Codice"));
                bean.setNome(rs.getString("Nome"));
                bean.setDescrizioneBreve(rs.getString("DescrizioneBreve"));
                bean.setDescrizioneLunga(rs.getString("DescrizioneLunga"));
                //bean.setDisponibilita(rs.getInt("disponibilita"));
                bean.setImmagine(rs.getString("Immagine"));
                bean.setPrezzo(rs.getFloat("prezzo"));
                //bean.setOfferta(rs.getBoolean("offerta"));
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

    public synchronized Collection<PBean> doRetrieveByResearch(String ric) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        Collection<PBean> product = new LinkedList<PBean>();
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

