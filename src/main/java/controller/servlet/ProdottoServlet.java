package controller.servlet;

import bean.PBean;
import controller.prodotti.Carrello;
import controller.model.PModel;
import controller.model.PModelDS;
import prodotti.ProductModelDM;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ProdottoServlet", value = "/ProdottoServlet")
public class ProdottoServlet extends HttpServlet {

    static boolean isDataSource = true;

    static PModel model;

    static {
        if (isDataSource) {
            model = new PModelDS();
        } else {
            model = (PModel) new ProductModelDM();
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Carrello cart = (Carrello) request.getSession().getAttribute("cart");
        if(cart == null) {
            cart = new Carrello();
            request.getSession().setAttribute("cart", cart);
        }

        String action = request.getParameter("action");

        try {
            if (action != null) {
                if (action.equalsIgnoreCase("addC")) {
                    int codice = Integer.parseInt(request.getParameter("codice"));
                    cart.addProduct(model.doRetrieveByKey(codice));
                } else if (action.equalsIgnoreCase("deleteC")) {
                    int codice = Integer.parseInt(request.getParameter("codice"));
                } else if (action.equalsIgnoreCase("read")) {
                    int codice = Integer.parseInt(request.getParameter("codice"));
                    request.removeAttribute("product");
                    request.setAttribute("product", model.doRetrieveByKey(codice));
                } else if (action.equalsIgnoreCase("delete")) {
                    int id = Integer.parseInt(request.getParameter("codice"));
                    model.doDelete(id);
                } else if (action.equalsIgnoreCase("insert")) {
                    String tipo = request.getParameter("nome");
                    String description = request.getParameter("description");
                    float prezzo = Integer.parseInt(request.getParameter("prezzo"));
                    int quantity = Integer.parseInt(request.getParameter("quantity"));

                    PBean bean = new PBean();
                    bean.setTipo(tipo);
                    bean.setDescrizioneLunga(description);
                    bean.setPrezzo(prezzo);
                    model.doSave(bean);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }

        request.getSession().setAttribute("cart", cart);
        request.setAttribute("cart", cart);


        String sort = request.getParameter("sort");

        try {
            request.removeAttribute("products");
            request.setAttribute("products", model.doRetrieveAll(sort));
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ProductView.jsp");
        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
