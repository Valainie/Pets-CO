package prodotti;

import bean.PBean;

import java.sql.SQLException;

public interface Cart {
    public void addToCart(PBean product) throws SQLException;

    public boolean deleteFromCart(int code) throws SQLException;
    public PBean showCart(int code) throws SQLException;
    public boolean getTot(int code) throws SQLException;


}
