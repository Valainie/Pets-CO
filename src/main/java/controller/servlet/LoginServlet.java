package controller.servlet;

import bean.UserBean;
import controller.user.UserController;

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
           UserController controller = new UserController();
            UserBean bean = controller.login(mail,p);
            if (bean == null) {
                response.sendRedirect("invalidLogin.jsp");
            }
            else{
                request.getSession().setAttribute("name", bean.getNome());

            response.sendRedirect("userLogged.jsp");
            }

        } catch (Exception exception) {
            System.err.println(exception);
        }
    }
}
