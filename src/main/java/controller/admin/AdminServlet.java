package controller.admin;

import DAO.product.PModelDS;
import bean.Bean;
import bean.PBean;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "AdminServlet", value = "/AdminServlet")
public class AdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    static PModelDS model=new PModelDS();

    public AdminServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String op = request.getParameter("operation");
        int operation = Integer.parseInt(op);
        //Elimina prodotto
        PBean bp = null;
        if (operation == 3) {
            int codP = Integer.parseInt(request.getParameter("codiceProdotto"));
            try {
                model.doDelete(codP);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            response.sendRedirect("productoperation.jsp?operation=4");
            return;
        }

        //Aggiungi prodotto
        else if (operation == 1) {
            PBean p = new PBean();
            int codP = Integer.parseInt(request.getParameter("Codice"));
            ArrayList<Bean> bpr = null;
            try {
                bpr = (ArrayList<Bean>) model.doRetrieveAll("Codice");
            } catch (SQLException e) {
                e.printStackTrace();
            }

            ArrayList<Integer> codici = new ArrayList<Integer>();
            for (Bean bean : bpr) {
                codici.add(((PBean) bean).getCodice());
            }
            if (codici.contains(codP)) {
                response.sendRedirect("productoperation.jsp?operation=1&isPreso=true");
                return;
            }
            String nome = request.getParameter("Nome");
            String descrizioneLunga = request.getParameter("DescrizioneLunga");
            String descrizioneBreve = request.getParameter("DescrizioneBreve");
            String prezzo = request.getParameter("Prezzo");
            String quantita = request.getParameter("quantita");
            String novita = request.getParameter("novita");
            System.out.println(novita);
            String offerta = request.getParameter("offerta");
            System.out.println(offerta);
            String immagine = request.getParameter("Immagine");


            p.setCodice(codP);
            p.setDescrizioneLunga(descrizioneLunga);
            p.setDescrizioneBreve(descrizioneBreve);
            p.setDisponibilita(Integer.parseInt(quantita));
            p.setNovita(Boolean.parseBoolean(novita));
            p.setOfferta(Boolean.parseBoolean(offerta));
            p.setPrezzo(new Float(prezzo));
            p.setNome(nome);
            p.setImmagine(immagine);
            System.out.println(p.toString());

            try {
                model.doSave(p);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            response.sendRedirect("productoperation.jsp?operation=1&isPreso=false");
            return;

            //modifica prodotto
        } else if (operation == 2) {
            bp = new PBean();
            int codP = Integer.parseInt(request.getParameter("codiceProdotto"));
            try {
                bp = (PBean) model.doRetrieveByKey(codP);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            String titolo = request.getParameter("titolo");
            if (!titolo.equals(bp.getNome())) {
                try {
                    model.doUpdate("titolo", codP, titolo);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

        String descrizioneBreve = request.getParameter("descrizioneBreve");
        if (!descrizioneBreve.equals(bp.getDescrizioneBreve())) {
            try {
                model.doUpdate("DescrizioneBreve", codP, descrizioneBreve);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        String descrizioneLunga = request.getParameter("descrizioneLunga");
         if (!descrizioneBreve.equals(bp.getDescrizioneBreve())) {
                    try {
                        model.doUpdate("DescrizioneLunga", codP, descrizioneLunga);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
        String prezzo = request.getParameter("prezzo");
        Float price = new Float(prezzo);
        if ((price) != (bp.getPrezzo())) {
            try {
                model.doUpdate("prezzo", codP, price);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        String quantita = request.getParameter("disponibilita");
        if (Integer.parseInt(quantita) != bp.getDisponibilita()) {
            try {
                model.doUpdate("disponibilita", codP, quantita);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        String novita = request.getParameter("novita");
        System.out.println(novita);
        if (Boolean.parseBoolean(novita) != bp.isNovita()) {
            try {
                model.doUpdate("novita", codP, Boolean.parseBoolean(novita));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        String offerta = request.getParameter("offerta");
        System.out.println(offerta);
        if (Boolean.parseBoolean(offerta) != bp.isOfferta()) {
            try {
                model.doUpdate("offerta", codP, Boolean.parseBoolean(offerta));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        String pic = request.getParameter("pic");
        if (!pic.equals(bp.getImmagine())) {
            try {
                model.doUpdate("foto", codP, pic);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        response.sendRedirect("productoperation.jsp?operation=2");
        return;
    }
        //Visualizza catalogo
        else if(operation==3){
            System.out.println("retrieve all");
            ArrayList <Bean> bpr = null;
            try {
                bpr= (ArrayList<Bean>) model.doRetrieveAll("Codice");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            request.setAttribute("elencoProdotti", bpr);

            return;
        }
    }

}
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
