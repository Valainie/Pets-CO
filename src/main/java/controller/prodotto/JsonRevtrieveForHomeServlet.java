package controller.prodotto;

import DAO.product.PModelDS;
import bean.CiboBean;
import bean.PBean;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

@WebServlet(name = "JsonRevtrieveForHomeServlet", value = "/JsonRevtrieveForHomeServlet")
public class JsonRevtrieveForHomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    static PModelDS model=new PModelDS();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PBean bp;
        String codProd= request.getParameter("codice");
        String jsonBean = null;

        try {
            bp = (PBean) model.doRetrieveHome(codProd);
                jsonBean = new Gson().toJson(bp);
            } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (jsonBean != null) {
            response.getWriter().write(jsonBean);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }
}
