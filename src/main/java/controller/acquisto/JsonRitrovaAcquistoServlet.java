package controller.acquisto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import DAO.acquisto.AcquistoDAO;
import bean.AccessorioBean;
import bean.AcquistoBean;
import bean.Bean;
import com.google.gson.Gson;


@WebServlet(name = "JsonRitrovaAcquistoServlet", value = "/JsonRitrovaAcquistoServlet")
public class JsonRitrovaAcquistoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    static AcquistoDAO ad =new AcquistoDAO();
    public JsonRitrovaAcquistoServlet(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
AcquistoBean ba= new AcquistoBean();
        String username= request.getParameter("username");
        String jsonBean = null;
        try {
            ba =ad.doRetrieveByKey(username);
            jsonBean= new Gson().toJson(ba);
            System.out.println(jsonBean);
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
