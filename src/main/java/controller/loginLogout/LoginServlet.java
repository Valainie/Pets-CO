package controller.loginLogout;

import DAO.admin.Admin;
import DAO.user.UserDAO;
import bean.AdminBean;
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
        AdminBean amministratore = new AdminBean();
        String email = "";
        String pass = "";
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
            cm = new UserDAO();
            am = new Admin();
            cliente = cm.doRetrieveByUserPass(email, pass);
            amministratore = am.doRetrieveByUserPass(email, pass);

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        if (!Objects.equals(cliente.getPassword(), "") && !Objects.equals(cliente.getEmail(), ""))
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
            response.sendRedirect("userLogged.jsp?loginSuccess=true");
        }
        if (!Objects.equals(amministratore.getPassword(), "") && !Objects.equals(amministratore.getUsername(), ""))
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
            response.sendRedirect("/AdminJSP/adminpage.jsp?loginSuccess=true");
        }
        else if (amministratore.getUsername() == "" && cliente.getUsername() == "")
        {
            request.setAttribute("loginFail", true);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/invalidLogin.jsp?loginFail=true");
            dispatcher.forward(request, response);
        }

    }

}