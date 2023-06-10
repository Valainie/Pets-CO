package DAO;

import bean.Bean;

import java.sql.SQLException;

public interface DAO {
    public void doSave(Bean bean) throws SQLException;

    public boolean doDelete(Object key) throws SQLException;

    public Bean doRetrieveByKey(Object key) throws SQLException;

    public Bean doRetrieveAll(String order) throws SQLException;
}





