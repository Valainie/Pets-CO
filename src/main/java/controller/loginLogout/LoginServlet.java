package controller.loginLogout;

import DAO.user.UserDAO;
import  bean.UserBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String mail = request.getParameter("Email");
            String p=request.getParameter("Password");
           UserDAO controller = new UserDAO();
            UserBean bean = UserDAO.login(mail,p);
            if (bean == null) {
                System.out.println("puttana eva");
                response.sendRedirect("userJSP/invalidLogin.jsp");
            }
            else{
                request.getSession().setAttribute("name", bean.getNome());

            response.sendRedirect("userJSP/userLogged.jsp");
            }

        } catch (Exception exception) {
            System.err.println(exception);
        }
    }
}
