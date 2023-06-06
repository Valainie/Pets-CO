package controller.acquisto;

import bean.PBean;

import java.sql.SQLException;
import java.util.ArrayList;

public class Carrello  {
    double quantita;
    float prezzoTot;
    private ArrayList<Carrello> cart = new ArrayList<>();



    public void addToCart(PBean product) throws SQLException {

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

    public void addProduct(PBean doRetrieveByKey) {
    }
}


