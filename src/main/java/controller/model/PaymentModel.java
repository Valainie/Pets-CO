package controller.model;

import bean.PBean;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Collection;

public class PaymentModel implements PModel{
    private static DataSource ds;

    static {

    }

    private static final String TABLE_NAME = "metodoPagamento";
    @Override
    public void doSave(PBean product) throws SQLException {

    }

    @Override
    public boolean doDelete(int code) throws SQLException {
        return false;
    }

    @Override
    public PBean doRetrieveByKey(int code) throws SQLException {
        return null;
    }

    @Override
    public Collection<PBean> doRetrieveAll(String order) throws SQLException {
        return null;
    }
}
