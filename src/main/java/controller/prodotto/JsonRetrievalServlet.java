package controller.prodotto;

import DAO.product.AccessorioDAO;
import DAO.product.CiboDAO;
import DAO.product.CuraDAO;
import DAO.product.PModelDS;
import bean.AccessorioBean;
import bean.CiboBean;
import bean.CuraBean;
import bean.PBean;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

@WebServlet(name = " JsonRetrievalServlet", value = "/ JsonRetrievalServlet")
public class                                                                                                                                                                     JsonRetrievalServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    static PModelDS model=new PModelDS();
    static CiboDAO cd=new CiboDAO();

    static CuraDAO cu=new CuraDAO();
    static AccessorioDAO ad=new AccessorioDAO();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PBean bp;
        CuraBean cb = new CuraBean();
        CiboBean ci = new CiboBean();
        AccessorioBean ab = new AccessorioBean();
        String codProd= request.getParameter("codice");
        String jsonBean = null;
        try {
            bp = (PBean) model.doRetrieveByKey(Integer.parseInt(codProd));
            if (Objects.equals(bp.getCategoria(), "cibo")) {
                ci = (CiboBean) cd.doRetrieveByKey(Integer.parseInt(codProd));
                jsonBean = new Gson().toJson(ci);
            }
            else if (Objects.equals(bp.getCategoria(), "cura")) {
                cb = (CuraBean) cu.doRetrieveByKey(Integer.parseInt(codProd));
                jsonBean = new Gson().toJson(cb);
            }
            else{
                ab =(AccessorioBean) ad.doRetrieveByKey(Integer.parseInt(codProd));
                jsonBean                                = new Gson().toJson(ab);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (jsonBean != null) {
            response.getWriter().write(jsonBean);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }
}
