package controller.user;

import DAO.user.UserDAO;
import bean.UserBean;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "EditUserServlet", value = "/EditUserServlet")
public class EditUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    UserDAO ud=new UserDAO();


    public EditUserServlet() {
        super();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        UserBean cliente = new UserBean();


        cliente= (UserBean) session.getAttribute("currentSessionUser");
        String lastUser=cliente.getUsername();
        String cf = request.getParameter("Cf");
        String user = request.getParameter("username");
        String pass = request.getParameter("pass");
        String nome = request.getParameter("nome");
        String cognome = request.getParameter("cognome");
        String telefono=request.getParameter("telefono");
        String mail = request.getParameter("mail");


        try
        {
            ud.doUpdate(cf,user,pass,nome,cognome,telefono, mail,lastUser);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        cliente.setCf(cf);
        cliente.setNome(nome);
        cliente.setUsername(user);
        cliente.setPassword(pass);
        cliente.setCognome(cognome);
        cliente.setTel(Integer.parseInt(telefono));
        cliente.setEmail(mail);
        session.setAttribute("currentSessionUser", cliente);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/home.jsp?editDone=true");
        dispatcher.forward(request, response);
    }
    }

