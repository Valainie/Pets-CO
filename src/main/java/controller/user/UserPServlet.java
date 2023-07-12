package controller.user;

import DAO.acquisto.MetodoPDAO;
import DAO.user.UserDAO;
import bean.Bean;
import bean.MetodoDiPagamentoBean;
import bean.UserBean;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;


/*SERVLET CHE SERVE A METTERE IL METODO DI PAGAMENTO DEL CLIENTE*/

@WebServlet(name = "UserPServlet", value = "/UserPServlet")
public class UserPServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    static UserDAO model=new UserDAO();
    static MetodoPDAO pm =new MetodoPDAO();

    /*SERVLET CHE SERVE A METTERE IL METODO DI PAGAMENTO DEL CLIENTE*/

   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //prende la carta predefinita
        String card="newcard";
        HttpSession session = request.getSession();
        UserBean c = (UserBean) session.getAttribute("currentSessionUser");
        String pred = Long.toString(c.getCartaPred());
        String securecode = pred.substring(pred.length() - 4);
        Collection<Bean> bo=null;

        bo= (Collection<Bean>) session.getAttribute("metodi");

        //lo esegue quando l'utente aggiunge una carta da order
        if (request.getParameter(card) != null)
        {
            String ncSecure = request.getParameter(card);
            for (Bean b : bo)
            {
                if (((MetodoDiPagamentoBean) b).getPin().equals(ncSecure))
                {
                    session.setAttribute("userFavSecureCode", ((MetodoDiPagamentoBean) b).getPin());
                    session.setAttribute("userFavCircuito", ((MetodoDiPagamentoBean) b).getCircuito());
                    break;
                }
            }

        }

        if (request.getParameter(card) == null)
        {
            for (Bean b : bo)
            {
                if (((MetodoDiPagamentoBean) b).getPin().equals(securecode))
                {
                    session.setAttribute("userFavSecureCode", ((MetodoDiPagamentoBean) b).getPin());
                    session.setAttribute("userFavCircuito", ((MetodoDiPagamentoBean) b).getCircuito());
                    break;
                }
            }
        }


        response.setStatus(200);
    }

    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("POST");
        if(request.getParameter("doGetPlease")!= null)
        {
            doGet(request, response);
            return;
        }

        HttpSession session = request.getSession();
        UserBean c = (UserBean) session.getAttribute("currentSessionUser");
        String username = c.getUsername();
        String securecode = request.getParameter("securecode");
        Collection<Bean> bo=null;

        bo=(Collection<Bean>) session.getAttribute("metodi");

        for (Bean b : bo)
        {
            if (((MetodoDiPagamentoBean) b).getPin().equals(securecode))
            {
                session.setAttribute("userFavSecureCode", ((MetodoDiPagamentoBean) b).getPin());
                session.setAttribute("userFavCircuito", ((MetodoDiPagamentoBean) b).getCircuito());
             try {
                    model.doUpdateCard("cartaPred", username, ((MetodoDiPagamentoBean) b).getNumCarta());
                } catch (SQLException e) {
                 e.printStackTrace();
                }
                break;
            }
        }


        response.setStatus(200);
    }


}