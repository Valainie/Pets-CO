package controller.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.user.UserDAO;
import bean.Bean;

@WebServlet(name = "AdminClientServlet", value = "/AdminClientServlet")
public class AdminClientServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    static UserDAO model=new UserDAO();

    public AdminClientServlet(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String op=request.getParameter("operation");
        int operation=Integer.parseInt(op);
        System.out.println("Sono nella adminClienteServlet");
        if(operation==3) {
            System.out.println("operation: "+operation);
            String codC=request.getParameter("username");
            try {
                model.doDelete(codC);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return;
        }
        else{	Collection<Bean> bc = null;
            try {
                bc= (Collection<Bean>) model.doRetrieveAll("username");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println(bc);

            request.setAttribute("elencoClienti", bc);

            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}