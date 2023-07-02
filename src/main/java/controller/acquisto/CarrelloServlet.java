package controller.acquisto;

import DAO.acquisto.Cart;
import DAO.product.PModelDS;
import bean.Carrello;
import bean.PBean;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;

@WebServlet(name = "CarrelloServlet", value = "/CarrelloServlet")
public class CarrelloServlet extends HttpServlet implements Serializable {
    private static final long serialVersionUID = 1L;
    static PModelDS model= new PModelDS();


    public CarrelloServlet() {
        super();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Cart cart = (Cart)request.getSession().getAttribute("cart");
        if(cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
            session.setAttribute("cartcardinality", cart.cartCardinality());
            session.setAttribute("totale", cart.getTotale());
        }

        int quant=Integer.parseInt (request.getParameter("quantita"));
        int id=Integer.parseInt(request.getParameter("codice"));


        try {
            PBean b = (PBean) model.doRetrieveByKey(id);
            Carrello bce=new Carrello(b,quant);
            if(b.getDisponibilita()>=quant)
            {
                if(cart.cartContains(bce)) {
                    cart.setQuant(bce, quant);
                }
                else cart.addProduct(bce);
            }
            session.setAttribute("cart", cart);
            session.setAttribute("cartcardinality", cart.cartCardinality());
            session.setAttribute("totale", cart.getTotale());
        }

        catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }

        Collection<Carrello> bce = cart.getProducts();
        session.setAttribute("cartitems", bce);

        response.setStatus(200);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }
}
