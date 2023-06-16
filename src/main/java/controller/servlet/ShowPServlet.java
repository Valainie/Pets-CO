package controller.servlet;

import bean.Bean;
import bean.PBean;
import DAO.product.PModelDS;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

@WebServlet(name = "ShowPServlet", value = "/ShowPServlet")
public class ShowPServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    static PModelDS model=new PModelDS();

    public ShowPServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        //home
        if (request.getAttribute("home") != null)
        {
            try {
                Collection <PBean> bpo= model.doRetrieveByBool("offerta",true);
                request.setAttribute("offerteHome", bpo);
                Collection <PBean> bpn= model.doRetrieveByBool("novita",true);
                request.setAttribute("novitaHome", bpn);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return;
        }
        //home

        Collection<Bean> bpr;

        String cat=request.getParameter("categoria");
        String val=request.getParameter("value");
        String at=request.getParameter("attribute");
        String ric=request.getParameter("searchtxt");

        try {
            if(ric!=null) {
                bpr=model.doRetrieveByResearch(ric);
                session.setAttribute("listaRisultati", bpr);
            }

            if (at!=null && val!=null) {
                if (cat == null || cat.equals("")) {
                    bpr= model.doRetrieveByTipo(at, val);
                    session.setAttribute("listaRisultati", bpr);
                }}
            else{
                bpr=model.doRetrieveByTipo(cat);
                session.setAttribute("listaRisultati", bpr);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
