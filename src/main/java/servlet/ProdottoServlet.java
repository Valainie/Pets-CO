package servlet;

import prodotti.PModelDS;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ProdottoServlet", value = "/ProdottoServlet")
public class ProdottoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public ProdottoServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PModelDS productModel = new PModelDS();
        try {
            request.setAttribute("products", productModel.doRetrieveAll(request.getParameter("Codice")));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("prodotto.jsp").forward(request, response);
    }
}
