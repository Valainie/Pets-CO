package DAO.acquisto;

import DAO.DAO;
import bean.Bean;
import bean.PBean;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Collection;

public class PaymentModel implements DAO {
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


    @Override
    public void doSave(Bean bean) throws SQLException {

    }

    @Override
    public Bean doDelete(String code) throws SQLException {
        return null;
    }

    @Override
    public PBean doRetrieveByKey(Object code) throws SQLException {
        return null;
    }

    @Override
    public Collection<Bean> doRetrieveAll(String order) throws SQLException {
        return null;
    }

    @Override
    public Collection<Bean> doRetrieveByResearch(String ric) throws SQLException {
        return null;
    }
}
