package prodotti;

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

public class PModelDS implements PModel{
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

        int result = 0;
        PreparedStatement ps1 =ds.getConnection().prepareStatement(
                "Delete * from Prodotto Where Codice=?");
        
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
    @Override
    public Collection<PBean> doRetrieveAll(String order) throws SQLException {
        return null;
    }
}
