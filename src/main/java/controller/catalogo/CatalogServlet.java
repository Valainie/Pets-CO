package controller.catalogo;

import DAO.product.Catalogo;
import bean.ProdottoCatalogo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CatalogServlet", value = "/CatalogServlet")
public class CatalogServlet extends HttpServlet {
    private Catalogo catalogo = new Catalogo();
    private String title;


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (catalogo == null) {
            response.sendError(response.SC_NOT_FOUND,
                    "Missing Items.");
            return;
        }
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String docType =
                "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
                        "Transitional//EN\">\n";
        out.println(docType +
                "<HTML>\n" +
                "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                "<H1 ALIGN=\"CENTER\">" + title + "</H1>"); //cambiare per il progetto come si deve
        ProdottoCatalogo item;
        for(int i=0; i<catalogo.getCat().size(); i++) {
            out.println("<HR>");
            item = catalogo.getCat().get(i);
            if (item == null) {
                out.println("<FONT COLOR=\"RED\">" +
                        "Unknown item ID " + catalogo.getCat().get(i).getCodice() +
                        "</FONT>");
            } else {
                out.println();
                String formURL =
                        "OrderPage";
                // Pass URLs that reference own site through encodeURL.
                formURL = response.encodeURL(formURL);
                out.println
                        ("<FORM ACTION=\"" + formURL + "\">\n" +
                                "<INPUT TYPE=\"HIDDEN\" NAME=\"itemID\" " +
                                "       VALUE=\"" + item.getCodice() + "\">\n" +
                                "<H2>"+item.getTipo()+"\">\n"+
                                ","+ item.getDescrizioneBreve() +
                                " ($" + item.getPrezzo() + ")</H2>\n" +
                                "<P>\n<CENTER>\n" +
                                "<INPUT TYPE=\"SUBMIT\" " +
                                "VALUE=\"Add to Shopping Cart\">\n" +
                                "</CENTER>\n<P>\n</FORM>");
            }
        }
        out.println("<HR>\n</BODY></HTML>");
    }
}
