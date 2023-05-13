package model;

import bean.UserBean;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    static Connection currentCon = null;
    static ResultSet rs = null;
    private static DataSource ds;
    private UserDAO(){}

    static {
        try {
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");

            ds = (DataSource) envCtx.lookup("jdbc/storage");

        } catch (NamingException e) {
            System.out.println("Error:" + e.getMessage());
        }
    }


    public static UserBean login(String email, String password) {
        UserBean bean = new UserBean();
        PreparedStatement stmt = null;
        try {
            currentCon = ds.getConnection();
            stmt = currentCon.prepareStatement(
                    "SELECT * from Cliente where Email = ? AND Password = ?");

            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (!rs.next()) {
                System.out.println("Sorry, you are not a registered user! Please sign up first");
            } else {
                String user = rs.getString("Nome");
                bean.setNome(user);

                System.out.println("Welcome " + user);
                bean.setValid(true);
            }
            System.out.println(bean.isValid());
            return bean;
        } catch (Exception ex) {
            System.out.println("Log In failed: An Exception has occurred! " + ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    System.err.println(e);
                }
                rs = null;
            }


            if (currentCon != null) {
                try {
                    currentCon.close();
                } catch (Exception e) {
                    System.err.println(e);
                }
                currentCon = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                    System.err.println(e);
                }
            }

            }

            return (bean);
        }
    }

