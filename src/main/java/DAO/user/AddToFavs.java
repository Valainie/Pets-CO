package DAO.user;

import DAO.DAO;
import bean.Bean;

import java.sql.SQLException;
import java.util.RandomAccess;

public class AddToFavs implements DAO {
    @Override
    public void doSave(Bean bean) throws SQLException {

    }

    @Override
    public boolean doDelete(Object key) throws SQLException {
        return false;
    }

    @Override
    public Bean doRetrieveByKey(Object key) throws SQLException {
        return null;
    }

    @Override
    public RandomAccess doRetrieveAll(String order) throws SQLException {
        return null;
    }

    public synchronized void Preferiti (){}
}
