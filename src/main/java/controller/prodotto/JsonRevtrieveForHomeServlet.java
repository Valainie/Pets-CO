package controller.prodotto;

import DAO.product.PModelDS;
import bean.Bean;
import bean.CiboBean;
import bean.PBean;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Objects;

@WebServlet(name = "JsonRevtrieveForHomeServlet", value = "/JsonRevtrieveForHomeServlet")
public class JsonRevtrieveForHomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    static PModelDS model=new PModelDS();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Collection<PBean> bp;
        String jsonBean = null;

        try {
            bp =  model.doRetrieveHome();
                jsonBean = new Gson().toJson(bp);

            } catch (SQLException e) {
            e.printStackTrace();
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
