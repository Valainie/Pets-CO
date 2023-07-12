package controller.loginLogout;

import DAO.user.UserDAO;
import  bean.UserBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet()
    {
        super();
    }


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession newSession = request.getSession(true);

        UserBean cliente = new UserBean();
        String email;
        String pass;
        String rem = request.getParameter("remember");

        Cookie[] cookies = request.getCookies();

        if (cookies != null)
        {
            for (Cookie cookie : cookies)
            {
                if (cookie.getName().equals("savePass"))
                {
                    pass = cookie.getValue();
                }
                if (cookie.getName().equals("savemail"))
                {
                    email = cookie.getValue();
                }
            }
        }

        pass = request.getParameter("pw");
        email = request.getParameter("mail");


        Cookie savePass;
        Cookie saveMail;
        UserDAO cm;

        try
        {
            cm = new UserDAO();
            cliente = cm.doRetrieveByUserPass(email, pass);

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        if ((!"".equals(cliente.getPassword()))&& (!"".equals(cliente.getEmail())))
        {
            newSession.setAttribute("currentSessionUser", cliente);
            newSession.setAttribute("accessDone", true);

            if (rem != null)
            {
                savePass = new Cookie("savePass", pass);
                saveMail = new Cookie("saveUser", email);
                savePass.setMaxAge(50000);
                saveMail.setMaxAge(50000);
                response.addCookie(savePass);
                response.addCookie(saveMail);
            }

            request.setAttribute("loginSuccess", true);
            response.sendRedirect("userJSP/userLogged.jsp");
        }

         if ( cliente.getEmail() == "")
        {
            request.setAttribute("loginFail", true);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("userJSP/invalidLogin.jsp");
            dispatcher.forward(request, response);
            System.out.println("boh");
        }

    }

}