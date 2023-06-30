package DAO;

import bean.Bean;

import java.sql.SQLException;
import java.util.Collection;

public interface DAO {
    public void doSave(Bean bean) throws SQLException;

    public boolean doDelete(Object key) throws SQLException;

    public Bean doRetrieveByKey(Object key) throws SQLException;

    public Collection<Bean> doRetrieveAll(String order) throws SQLException;
}





