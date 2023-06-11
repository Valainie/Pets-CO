package DAO.acquisto;

import DAO.DAO;
import bean.Bean;
import bean.PBean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.RandomAccess;

public class Carrello implements DAO {
    double quantita;
    float prezzoTot;
    private ArrayList<Carrello> cart = new ArrayList<>();



    public void addToCart(Bean product) throws SQLException {

    }

    
    public boolean deleteFromCart(int code) throws SQLException {
        return false;
    }

    
    public PBean showCart(int code) throws SQLException {
        return null;
    }

    public boolean getTot(int code) throws SQLException {
        return false;
    }


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
}


