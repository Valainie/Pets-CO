package controller.catalogo;

import bean.ProdottoCatalogo;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Catalogo {
    private ArrayList<ProdottoCatalogo> cat = new ArrayList<>();
    private static DataSource ds;

    public Catalogo()
    {
        int codice;
        String tipo;
        String descrizioneBreve;
        String descrizioneLunga;
        String immagine;
        float prezzo;

        try {
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");

            ds = (DataSource) envCtx.lookup("jdbc/storage");

        } catch (NamingException e) {
            System.out.println("Error:" + e.getMessage());
        }
        try {
            PreparedStatement ps = ds.getConnection().prepareStatement(
                    "Select * from Prodotto");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                codice = rs.getInt("Codice");
                tipo = rs.getString("Tipo");
                descrizioneBreve = rs.getString("DescrizioneBreve");
                descrizioneLunga = rs.getString("DescrizioneLunga");
                immagine = rs.getString("Immagine");
                prezzo = rs.getFloat("Prezzo");

                cat.add(new ProdottoCatalogo(codice, tipo, descrizioneBreve, descrizioneLunga, immagine, prezzo));
            }

            ps.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }}

    public ArrayList<ProdottoCatalogo> getCat() {
        return cat;
    }

}





