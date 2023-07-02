package controller.acquisto;

import DAO.acquisto.MetodoPDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AcquistoServlet", value = "/AcquistoServlet")
public class AcquistoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    static MetodoPDAO pm=new MetodoPDAO();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcquistoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
