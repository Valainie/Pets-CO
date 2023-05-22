package controller.prodotti;

import bean.PBean;

import java.sql.SQLException;
import java.util.ArrayList;

public class Carrello implements Cart {
    double quantita;
    float prezzoTot;
    private ArrayList<Carrello> cart = new ArrayList<>();



    @Override
    public void addToCart(PBean product) throws SQLException {

    }

    @Override
    public boolean deleteFromCart(int code) throws SQLException {
        return false;
    }

    @Override
    public PBean showCart(int code) throws SQLException {
        return null;
    }

    @Override
    public boolean getTot(int code) throws SQLException {
        return false;
    }
}


