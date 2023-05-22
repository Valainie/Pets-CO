package controller.servlet;

import controller.user.UserController;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static DataSource ds;
    static {
        try {
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");

            ds = (DataSource) envCtx.lookup("jdbc/storage");

        } catch (NamingException e) {
            System.err.println("Error:" + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();


            String cf = request.getParameter("Codice Fiscale");
            String n = request.getParameter("Username");
            String p = request.getParameter("Password");
            String no = request.getParameter("Nome");
            String c = request.getParameter("Cognome");
            int tel = Integer.parseInt(request.getParameter("Telefono"));
            String mail = request.getParameter("Email");
            int fax = Integer.parseInt(request.getParameter("Fax"));
            int civ = Integer.parseInt(request.getParameter("Civico"));
            String via = request.getParameter("Via");
            int cap = Integer.parseInt(request.getParameter("Cap"));
            String det = request.getParameter("Dettagli");

            UserController controller = new UserController();
            boolean result = controller.register(cf, n, p, no, c, tel, mail, fax, civ, via, cap, det);
            if (!result) {
                System.out.println("you are registered already");
                response.sendRedirect("userLogged.jsp");

           }
            out.close();
        }catch(NumberFormatException e){
            System.out.println("????" + e);
            response.sendRedirect("invalidLogin.jsp");


        }
    }
}
