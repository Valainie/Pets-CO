package controller.admin;

import DAO.admin.Admin;
import DAO.user.UserDAO;
import bean.AdminBean;
import bean.UserBean;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AdminLoginServlet", value = "/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession newSession = request.getSession(true);

        AdminBean amministratore = new AdminBean();
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
        Admin am;

        try
        {
            am = new Admin();
            amministratore = am.doRetrieveByUserPass(email, pass);

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

      if ((amministratore.getPassword()!= "") && (amministratore.getEmail()!= ""))
        {

            newSession.setAttribute("currentSessionUser", amministratore);
            newSession.setAttribute("accessDone", true);

            if (rem != null)
            {
                savePass = new Cookie("savePass", pass);
                saveMail = new Cookie("saveMail", email);
                savePass.setMaxAge(50000);
                saveMail.setMaxAge(50000);
                response.addCookie(savePass);
                response.addCookie(saveMail);
            }

            newSession.setAttribute("isAdmin", true);
            request.setAttribute("loginSuccess", true);
           response.sendRedirect("homePage.jsp");
        }
       if (amministratore.getEmail() == "" )
        {
            request.setAttribute("loginFail", true);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("userJSP/invalidLogin.jsp");
            dispatcher.forward(request, response);
            System.out.println("boh");
        }

    }
}

