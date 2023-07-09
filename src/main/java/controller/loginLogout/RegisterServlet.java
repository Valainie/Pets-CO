package controller.loginLogout;

import DAO.user.UserDAO;
import bean.Bean;
import bean.UserBean;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Collection;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RegisterServlet()
    {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        {
            UserDAO cm = new UserDAO();
            ;
            UserBean cliente = new UserBean();
            UserBean testCliente = null;


            String user = request.getParameter("user");
            String pass = request.getParameter("pass");
            String mail = request.getParameter("mail");
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String check = request.getParameter("check");

            try {
                testCliente = (UserBean) cm.doRetrieveByKey(user);
                testCliente = cm.doRetrieveByEmail(mail);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            assert testCliente != null;
            String testUser = testCliente.getUsername();
            String testMail = testCliente.getEmail();

            if (!testUser.equals("") || !testMail.equals("")) {
                if (!testUser.equals(""))
                    request.setAttribute("userPresent", true);

                if (!testMail.equals(""))
                    request.setAttribute("mailPresent", true);

                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/register.jsp");
                dispatcher.forward(request, response);
            }


            if (check != null) {
                cliente.setNome(name);
                cliente.setCognome(surname);
                cliente.setUsername(user);
                cliente.setPassword(pass);
                cliente.setEmail(mail);

                try {
                    cm.doSave(cliente);
                    System.out.println(cliente);
                } catch (SQLException e) {
                    request.setAttribute("notRegistered", true);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/register.jsp");
                    dispatcher.forward(request, response);
                    e.printStackTrace();
                }

                request.setAttribute("registered", true);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/homePage.jsp");
                dispatcher.forward(request, response);
            } else {
                request.setAttribute("notRegistered", true);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/register.jsp");
                dispatcher.forward(request, response);
            }

        }
    }
}