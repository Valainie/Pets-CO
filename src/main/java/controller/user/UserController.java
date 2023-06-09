package controller.user;

import DAO.user.UserDAO;
import bean.UserBean;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserController {
    private static DataSource ds;

    public boolean register(String cf, String username,String password,String nome,String cognome, int telefono, String email,int fax, int civico, String via, int cap, String dettagli) {

            try {
                Context initCtx = new InitialContext();
                Context envCtx = (Context) initCtx.lookup("java:comp/env");

                ds = (DataSource) envCtx.lookup("jdbc/storage");

            } catch (NamingException e) {
                System.out.println("Error:" + e.getMessage());
            }
        

        try {
            PreparedStatement ps =ds.getConnection().prepareStatement(
                    "Select Email from Cliente Where Email=?");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return false;
            } else {
                PreparedStatement ps1 = ds.getConnection().prepareStatement(
                        "insert into Cliente values(?,?,?,?,?,?,?,?,?,?,?,?)");

                ps1.setString(1, cf);
                ps1.setString(2, username);
                ps1.setString(3, password);
                ps1.setString(4, nome);
                ps1.setString(5, cognome);
                ps1.setInt(6, telefono);
                ps1.setString(7, email);
                ps1.setInt(8, fax);
                ps1.setInt(9, civico);
                ps1.setString(10, via);
                ps1.setInt(11, cap);
                ps1.setString(12, dettagli);

                int rs1 = ps.executeUpdate();
                if (rs1 > 0) {
                    rs.close();
                    return true;
                }
                ps.close();
                ps1.close();
            }

        } catch (Exception e) {
            System.err.println(e);
        }

        return false;
    }

    public UserBean login( String email, String password) {
        try {

            UserBean user = UserDAO.login(email, password);

            return user.isValid() ? user : null;
        } catch (Exception exception) {
            System.err.println(exception);
        }
        return null;
    }
}




