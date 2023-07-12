package controller.acquisto;

import DAO.acquisto.Cart;
import DAO.product.PModelDS;
import bean.Carrello;
import bean.PBean;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

@WebServlet(name = "UpdateCarrelloServlet", value = "/UpdateCarrelloServlet")
public class UpdateCarrelloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    static PModelDS model = new PModelDS();

    public UpdateCarrelloServlet() {
        super();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {HttpSession session = request.getSession();
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        String remid = request.getParameter("rimuovibtn");
        int newQuant = Integer.parseInt(request.getParameter("quantita"));
        int refProd = Integer.parseInt(request.getParameter("productId"));

        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
            session.setAttribute("cartcardinality", cart.cartCardinality());
            session.setAttribute("totale", cart.getTotale());
        }

        try {

            if (remid != null) {
                int remId = Integer.parseInt(remid);
                PBean b = (PBean) model.doRetrieveByKey(remId);
                Carrello bce = new Carrello(b);
                cart.deleteProduct(bce);
            }

            else {
                PBean b1 =(PBean) model.doRetrieveByKey(refProd);
                Carrello bce1 = new Carrello(b1);
                cart.refresh(bce1, newQuant);
            }

            session.setAttribute("cart", cart);
            session.setAttribute("cartcardinality", cart.cartCardinality());
            session.setAttribute("totale", cart.getTotale());

        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }

        Collection<Carrello> bce = cart.getProducts();
        session.setAttribute("cartitems", bce);

        response.setStatus(200);

        RequestDispatcher dispatcher = request.getRequestDispatcher("cart.jsp");
        dispatcher.forward(request, response);
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }
}
