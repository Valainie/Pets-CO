package product;

import DAO.user.model.DAO;
import bean.PBean;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Collection;

public class PaymentModel implements DAO {
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

    @Override
    public Collection<PBean> doRetrieveByResearch(String ric) throws SQLException {
        return null;
    }
}
