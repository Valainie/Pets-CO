package controller.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.product.PModelDS;
import bean.Bean;
import bean.PBean;


@WebServlet(name = "SingleProductServlet", value = "/SingleProductServlet")
public class SingleProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    PModelDS pm=new PModelDS();

    public SingleProductServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String numProd = request.getParameter("selProd");
        String selCat =request.getParameter("selCat");
        Bean bg = new PBean();

        if (Integer.parseInt(selCat) == 1)
        {
            PModelDS gm = new PModelDS();
            try
            {
                bg = gm.doRetrieveByKey(Integer.parseInt(numProd));
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }

            request.setAttribute("gioco", bg);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/productpage.jsp");
            dispatcher.forward(request, response);
        }

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

