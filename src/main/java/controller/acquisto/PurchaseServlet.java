package controller.acquisto;

import DAO.acquisto.AcquistoDAO;
import DAO.acquisto.Cart;
import DAO.acquisto.MetodoPDAO;
import bean.AcquistoBean;
import bean.Bean;
import bean.MetodoDiPagamentoBean;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Collection;

@WebServlet(name = "PurchaseServlet", value = "/PurchaseServlet")
public class PurchaseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    static AcquistoDAO ad=new AcquistoDAO();
    static MetodoPDAO pm=new MetodoPDAO();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PurchaseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    HttpSession session=request.getSession();
    AcquistoBean a = new AcquistoBean();

    String username=request.getParameter("username");
    String jsonAddress=request.getParameter("jsonaddress");
    String importo=request.getParameter("importo");
    String metodo=request.getParameter("metodoselect");

    Cart cart=(Cart) session.getAttribute("cart");
    String statoProdotti = cart.formatStatoProdotti();

		try {
        a.setCodiceAcquisto(ad.getMaxOrderCode()+1);
        a.setIndirizzoSpedizione(jsonAddress);
        a.setDataOrdine(LocalDate.now());
        a.setDataSpedizione(LocalDate.now().plusDays(3));
        a.setImporto(new BigDecimal(importo));
        a.setStatoProdotti(statoProdotti);

        @SuppressWarnings("unchecked")
        Collection<Bean> ba=(Collection<Bean>) session.getAttribute("metodi");
        for (Bean bean : ba)
        {
            if (((MetodoDiPagamentoBean) bean).getSecureCode().equals(metodo))
            {
                a.setMetodo(((MetodoDiPagamentoBean) bean).getNumCarta());
                break;
            }
        }

        System.out.println(a);
        ad.customDoSave(a, username);

    }
		catch (SQLException e) {
        e.printStackTrace();
    }

		session.removeAttribute("cart");
		session.removeAttribute("cartitems");
		session.removeAttribute("cartcardinality");
		session.removeAttribute("totale");
		session.removeAttribute("iva");

		response.sendRedirect("/homePage.jsp?orderDone=true");
}
}
