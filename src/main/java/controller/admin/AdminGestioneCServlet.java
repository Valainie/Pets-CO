package controller.admin;

import DAO.user.UserDAO;
import bean.Bean;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
/*aDMIN GESTISCE I CLIENTI*/
@WebServlet(name = "AdminGestioneCServlet", value = "/AdminGestioneCServlet")
public class AdminGestioneCServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    static UserDAO model=new UserDAO();
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
        else{	ArrayList<Bean> bc = null;
            try {
                bc= (ArrayList<Bean>) model.doRetrieveAll("Username");
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
