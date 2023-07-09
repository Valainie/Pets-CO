package controller.user;

import DAO.user.UserDAO;
import bean.UserBean;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "JsonRetrieveClienteServlet", value = "/JsonRetrieveClienteServlet")
public class  JsonRetrieveClienteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    static UserDAO ud=new UserDAO();

        public JsonRetrieveClienteServlet(){
         super();
         }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("sono nella JsonRetrievalClienteServlet");
        UserBean bc=new UserBean();
        String username= request.getParameter("user");
        String jsonBean = null;
        try {
            bc = (UserBean) ud.doRetrieveByKey(username);
            System.out.println(bc);
            jsonBean= new Gson().toJson(bc);

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
