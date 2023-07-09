package controller.user;

import DAO.acquisto.AcquistoDAO;
import DAO.user.AddToFavs;
import bean.AcquistoBean;
import bean.PreferitiBean;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "JsonRetrieebPreferitiServlet", value = "/JsonRetrieebPreferitiServlet")
public class JsonRetrieebPreferitiServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    static AddToFavs ad =new AddToFavs();
    public JsonRetrieebPreferitiServlet(){
        super();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PreferitiBean pb= new PreferitiBean();
        String username= request.getParameter("username");
        String jsonBean = null;
        try {
            pb = (PreferitiBean) ad.doRetrieveByKey(username);
            jsonBean= new Gson().toJson(pb);
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
