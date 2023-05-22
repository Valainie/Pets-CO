package controller.model;

import bean.PBean;

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

public class PModelDS implements PModel {
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

    @Override
    public void doSave(PBean product) throws SQLException {

        PreparedStatement ps =ds.getConnection().prepareStatement(
                "Insert into Prodotto"+
               "(Codice,Tipo,DescrizioneBreve,DescrizioneLunga,Immagine,Prezzo) VALUES (?,?,?,?,?,?)");
        try {
            ps.setInt(1, product.getCodice());
            ps.setString(2, product.getTipo());
            ps.setString(3, product.getDescrizioneBreve());
            ps.setString(4, product.getDescrizioneLunga());
            ps.setString(5, product.getImmagine());
            ps.setFloat(6, product.getPrezzo());

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
                bean.setTipo(rs.getString("Tipo"));
                bean.setDescrizioneBreve(rs.getString("DescrizioneBreve"));
                bean.setDescrizioneLunga(rs.getString("DescrizioneLunga"));
                bean.setImmagine(rs.getString("Immagine"));
                bean.setPrezzo(rs.getFloat("Prezzo"));
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
                bean.setTipo(rs.getString("Tipo"));
                bean.setDescrizioneBreve(rs.getString("DescizioneBreve"));
                bean.setDescrizioneLunga(rs.getString("DescizioneLunga"));
                bean.setImmagine(rs.getString("Immagine"));
                bean.setPrezzo(rs.getInt("Prezzo"));
                products.add(bean);
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
}

