package controller.user;

import DAO.acquisto.MetodoPDAO;
import bean.Bean;
import bean.MetodoDiPagamentoBean;
import bean.PBean;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

@WebServlet(name = "PaymentServlet", value = "/PaymentServlet")
public class PaymentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    static MetodoPDAO pm =new MetodoPDAO();

    public PaymentServlet() {
        super();
    }

    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username=request.getParameter("Username");
        String securecode=request.getParameter("pin");
        Collection<Bean> bo=null;

        if(username!=null && request.getParameter("retrieve") != null) {
            try {
                bo=pm.doRetrieveByUser(username);
                session.setAttribute("metodi", bo);
                response.setStatus(200);

                if (bo.isEmpty())
                    session.removeAttribute("metodi");

                return;
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(request.getParameter("remove") != null)
        {
            try {
                bo=(Collection<Bean>) session.getAttribute("metodi");

                for (Bean b : bo)
                {
                    if (((MetodoDiPagamentoBean) b).getPin().equals(securecode))
                    {
                        pm.doDelete(((MetodoDiPagamentoBean) b).getNumCarta());
                        break;
                    }
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        response.setStatus(200);


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        MetodoDiPagamentoBean metodo = new MetodoDiPagamentoBean();
        @SuppressWarnings("unchecked")
        Collection<PBean> bo=(Collection<PBean>) session.getAttribute("metodi");

        if(request.getParameter("insert")!= null)
        {
            metodo.setNumCarta(Integer.parseInt(request.getParameter("numero")));
            metodo.setCvv(Integer.parseInt(request.getParameter("cvv")));
            metodo.setCircuito(request.getParameter("circuito"));
            metodo.setScadenza(request.getParameter("scadenza"));
            metodo.setPin();
            try {
                pm.customDoSave(metodo, request.getParameter("username"));
            } catch (SQLException e) {
                if (request.getParameter("isOrder") != null)
                {
                    response.sendRedirect("");
                }
                if (request.getParameter("isOrder") != null)
                {
                    response.sendRedirect("");
                    e.printStackTrace();
                }
                return;
            }

            if (request.getParameter("") != null)
            {
                response.sendRedirect("" + metodo.getPin());
                return;
            }
            if (request.getParameter("isOrder") == null)
            {
                response.sendRedirect("");
            }

        }
        if (bo.isEmpty())
            session.removeAttribute("metodi");

        response.setStatus(200);
    }

}
