package controller.prodotto;

import DAO.acquisto.AcquistoDAO;
import DAO.product.AccessorioDAO;
import DAO.product.CiboDAO;
import DAO.product.CuraDAO;
import bean.AccessorioBean;
import bean.CiboBean;
import bean.CuraBean;
import bean.PBean;
import DAO.DAO;
import DAO.product.PModelDS;
import DAO.acquisto.Cart;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

@WebServlet(name = "ProdottoServlet", value = "/ProdottoServlet")
public class ProdottoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    PModelDS pm=new PModelDS();
    CuraDAO cud=new CuraDAO();
    CiboDAO cid= new CiboDAO();
    AccessorioDAO ad=new AccessorioDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String numProd = request.getParameter("selProd");
        String selCat =request.getParameter("selCat");
        CuraBean cb = new CuraBean();
        CiboBean cib= new CiboBean();
        AccessorioBean ba = new AccessorioBean();


        if (Integer.parseInt(selCat) == 1)
        {
            CuraDAO gm = new CuraDAO();
            try
            {
                cb = (CuraBean) cud.doRetrieveByKey(Integer.parseInt(numProd));
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }

            request.setAttribute("cura", cb);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/prodotto.jsp");
            dispatcher.forward(request, response);
        }
        else if (Integer.parseInt(selCat) == 2)
        {
            AccessorioDAO am = new AccessorioDAO();
            try
            {
                ba = (AccessorioBean) ad.doRetrieveByKey(Integer.parseInt(numProd));
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }

            request.setAttribute("accessorio", ba);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/prodotto.jsp");
            dispatcher.forward(request, response);

        }else if (Integer.parseInt(selCat) == 3)
        {
            CiboDAO cd = new CiboDAO();
            try
            {
                cd = (CiboDAO) cid.doRetrieveByKey(Integer.parseInt(numProd));
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }

            request.setAttribute("cibo", cib);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/prodotto.jsp");
            dispatcher.forward(request, response);

        }

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String codP=request.getParameter("codProd");
        AccessorioBean ba = new AccessorioBean();
        CuraBean cu = new CuraBean();
        CiboBean cib= new CiboBean();
        PBean bp=new PBean();

        try {
            bp= (PBean) pm.doRetrieveByKey(Integer.parseInt(codP));
            if (Objects.equals(bp.getCategoria(), "Cura")) {
                cu= (CuraBean) cud.doRetrieveByKey(Integer.parseInt(codP));
                session.setAttribute("prodotto", bp);
                session.setAttribute("cura", cu);
            }
            else if(Objects.equals(bp.getCategoria(), "Accessorio")) {
                ba= (AccessorioBean) ad.doRetrieveByKey(Integer.parseInt(codP));
                session.setAttribute("accessorio", ba);
                session.setAttribute("prodotto", bp);
            }
            else if(Objects.equals(bp.getCategoria(), "Cibo")) {
                cib= (CiboBean) cid.doRetrieveByKey(Integer.parseInt(codP));
                session.setAttribute("Cibo", cib);
                session.setAttribute("prodotto", bp);
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        System.out.println("sono nella post");
    }
}
