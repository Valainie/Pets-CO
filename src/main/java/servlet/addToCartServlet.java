package servlet;

import bean.PBean;
import prodotti.Item;
import prodotti.PModelDS;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "addToCartServlet", value = "/addToCartServlet")
public class addToCartServlet extends HttpServlet {
    private static DataSource ds;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) {
            doPost_DisplayCart(request, response);
        } else {
            if (action.equalsIgnoreCase("buy")) {
                try {
                    doPost_Buy(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            } else if (action.equalsIgnoreCase("remove")) {
                doPost_Remove(request, response);
            }
        }
    }
    protected void doPost_DisplayCart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("cart.jsp").forward(request, response);
    }

    protected void doPost_Remove(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        ArrayList<Item> cart = (ArrayList<Item>) session.getAttribute("cart");
        int index = isExisting(Integer.parseInt(request.getParameter("id")), cart);
        cart.remove(index);
        session.setAttribute("cart", cart);
        response.sendRedirect("cart");
    }
    protected void doPost_Buy(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        PModelDS productModel = new PModelDS();
        HttpSession session = request.getSession();
        if (session.getAttribute("cart") == null) {
            ArrayList<Item> cart = new ArrayList<Item>();
            cart.add(new Item((PBean) productModel.doRetrieveAll(request.getParameter("Codice")), 1));
            session.setAttribute("cart", cart);
        } else {
            ArrayList<Item> cart = (ArrayList<Item>) session.getAttribute("cart");
            int index = isExisting(Integer.parseInt(request.getParameter("id")), cart);
            if (index == -1) {
                cart.add(new Item((PBean) productModel.doRetrieveAll(request.getParameter("Codice")), 1));
            } else {
                int quantity = cart.get(index).getQuantity() + 1;
                cart.get(index).setQuantity(quantity);
            }
            session.setAttribute("cart", cart);
        }
        response.sendRedirect("cart");
    }

    private int isExisting(int codice, ArrayList<Item> cart) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getProduct().getCodice()==codice) {
                return i;
            }
        }
        return -1;
    }


}


