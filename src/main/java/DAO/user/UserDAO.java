package DAO.user;

import DAO.DAO;
import bean.Bean;
import bean.UserBean;

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

public class UserDAO implements DAO {

    static Connection currentCon = null;
    static ResultSet rs = null;
    private static DataSource ds;
    public UserDAO(){}

    static {
        try {
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");

            ds = (DataSource) envCtx.lookup("jdbc/storage");

        } catch (NamingException e) {
            System.out.println("Error:" + e.getMessage());
        }
    }
    private static final String TABLE_NAME = "Cliente";



    public static boolean register(String cf, String username, String password, String nome, String cognome, int telefono, String email){
        UserBean bean = new UserBean();
        PreparedStatement stmt=null;
        try {
            PreparedStatement ps = ds.getConnection().prepareStatement(
                    "Select Email from Cliente Where Email=?");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return false;
            } else {
                PreparedStatement ps1 = ds.getConnection().prepareStatement(
                        "insert into Cliente values(?,?,?,?,?,?,?)");

                ps1.setString(1, cf);
                ps1.setString(2, username);
                ps1.setString(3, password);
                ps1.setString(4, nome);
                ps1.setString(5, cognome);
                ps1.setInt(6, telefono);
                ps1.setString(7, email);

                int rs1 = ps.executeUpdate();
                if (rs1 > 0) {
                    rs.close();
                    return true;
                }
            }

            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

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
                String user = rs.getString("Username");
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

    @Override
    public void doSave(Bean cliente) throws SQLException {
        UserBean c=(UserBean) cliente;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String insertSQL = "INSERT INTO " + UserDAO.TABLE_NAME
                + " (Cf,Username,Cliente.Password,Nome,Cognome,Telefono,Email) VALUES (?, ?, ?, ?, ?, ?,?)";

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setString(1, c.getCf());
            preparedStatement.setString(2, c.getUsername());
            preparedStatement.setString(3, c.getPassword());
            preparedStatement.setString(1, c.getNome());
            preparedStatement.setString(2, c.getCognome());
            preparedStatement.setInt(5, c.getTel());
            preparedStatement.setString(6, String.valueOf(c.getCartaPred()));

            preparedStatement.executeUpdate();
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
    public boolean doDelete(Object codice) throws SQLException {
        String username=(String) codice;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        int result = 0;

        String deleteSQL = "DELETE FROM " + UserDAO.TABLE_NAME + " WHERE Username = ?";

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setString(1, username);

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
    public synchronized Collection<Bean> doRetrieveByKey(Object user) throws SQLException {

        String username=(String) user;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        UserBean bean = new UserBean();
        Collection<Bean>Bean = new LinkedList<>();

        String selectSQL = "SELECT * FROM " + UserDAO.TABLE_NAME + " WHERE username = ?";

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setString(1, username);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                bean.setCf(rs.getString("Cf"));
                bean.setUsername(rs.getString("Username"));
                bean.setPassword(rs.getString("Password"));
                bean.setNome(rs.getString("Nome"));
                bean.setCognome(rs.getString("Cognome"));
                bean.setTel(rs.getInt("Telefono"));
                bean.setEmail(rs.getString("Email"));
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

        ArrayList<Bean> Cliente = new ArrayList<>();

        String selectSQL = "SELECT * FROM " + UserDAO.TABLE_NAME;

        if (order != null && !order.equals("")) {
            selectSQL += " ORDER BY " + order;
        }

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                UserBean bean = new UserBean();

                bean.setCf(rs.getString("Cf"));
                bean.setUsername(rs.getString("Username"));
                bean.setPassword(rs.getString("Password"));
                bean.setNome(rs.getString("Nome"));
                bean.setCognome(rs.getString("Cognome"));
                bean.setTel(rs.getInt("Telefono"));
                bean.setEmail(rs.getString("Email"));
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
        return Cliente;
    }

    public synchronized UserBean doRetrieveByEmail(String email) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        UserBean bean = new UserBean();

        String selectSQL = "SELECT * FROM " + UserDAO.TABLE_NAME + " WHERE Email = ?";

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setString(1, email);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                bean.setCf(rs.getString("Cf"));
                bean.setUsername(rs.getString("Username"));
                bean.setPassword(rs.getString("Password"));
                bean.setNome(rs.getString("Nome"));
                bean.setCognome(rs.getString("Cognome"));
                bean.setTel(rs.getInt("Telefono"));
                bean.setEmail(rs.getString("Email"));
            }
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
        return bean;
    }

    public synchronized UserBean doRetrieveByUserPass(String user, String pass) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        UserBean bean = new UserBean();

        String selectSQL = "SELECT * FROM " + UserDAO.TABLE_NAME + " WHERE Username = ? AND Password = ?";

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, pass);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                bean.setCf(rs.getString("Cf"));
                bean.setUsername(rs.getString("Username"));
                bean.setPassword(rs.getString("Password"));
                bean.setNome(rs.getString("Nome"));
                bean.setCognome(rs.getString("Cognome"));
                bean.setTel(rs.getInt("Telefono"));
                bean.setEmail(rs.getString("Email"));
                bean.setCartaPred(rs.getString("CartaPred"));

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
    public synchronized void doUpdate(String column1, String column2, String column3, String column4, String column5,String column6, String column7, String username) throws SQLException
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String selectSQL ="UPDATE "+UserDAO.TABLE_NAME+" SET Cf=? Username=?,Password=?,Nome=?, Cognome=?, Telefono=?, Email=? WHERE username='"+username+"'";


        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setString(1, column1);
            preparedStatement.setString(2, column2);
            preparedStatement.setString(3, column3);
            preparedStatement.setString(4, column4);
            preparedStatement.setString(5, column5);
            preparedStatement.setString(6,column6);
            preparedStatement.setString(7,column7);



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


    //questo metodo deve permettere l'update della carta che lìutente possiede


   public synchronized void doUpdateCard(String column, String username, Object value) throws SQLException
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String selectSQL = "UPDATE "+ UserDAO.TABLE_NAME + " as c SET "+column+"= ? WHERE c.Username= ?";

		try {
				connection = ds.getConnection();
				preparedStatement = connection.prepareStatement(selectSQL);

				if(value instanceof String) {
					String val = (String) value;
					preparedStatement.setString(1, val);
					preparedStatement.setString(2, username);
				}
				if(value instanceof Long) {
					long val= (Long) value;
					preparedStatement.setLong(1, val);
					preparedStatement.setString(2, username);
				}

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
