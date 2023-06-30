package controller.acquisto;

import DAO.acquisto.AcquistoDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "JsonRetrievaOrderServlet", value = "/JsonRetrievaOrderServlet")
public class JsonRetrievaOrderServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    static AcquistoDAO om =new AcquistoDAO();

    public JsonRetrievaOrderServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
