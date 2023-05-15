package servlet;

import catalogo.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CatalogServlet", value = "/CatalogServlet")
public class CatalogServlet extends HttpServlet {
    private ProdottoCatalogo[] items;
    private String[] itemIDs;
    private String title;
    protected void setItems(String[] itemIDs) {
        this.itemIDs = itemIDs;
        items = new ProdottoCatalogo[][itemIDs.length];
        for(int i=0; i<items.length; i++) {
            items[i] = Catalogo.getProdotto(itemIDs[codice]);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
