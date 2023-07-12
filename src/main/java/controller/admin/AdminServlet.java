package controller.admin;

import DAO.product.AccessorioDAO;
import DAO.product.CiboDAO;
import DAO.product.CuraDAO;
import DAO.product.PModelDS;
import bean.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

@WebServlet(name = "AdminServlet", value = "/AdminServlet")
public class AdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    static PModelDS model=new PModelDS();
    CiboDAO modelcd=new CiboDAO();

    static CuraDAO modelcu=new CuraDAO();
    static AccessorioDAO modelad=new AccessorioDAO();

    public AdminServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String op=request.getParameter("operation");
        int operation=Integer.parseInt(op);
        //Elimina prodotto
        if(operation==3) {
            int codP=Integer.parseInt(request.getParameter("Codice"));
            try {
                model.doDelete(codP);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            response.sendRedirect("productoperation.jsp?operation=4");
            return;
        }

        //Aggiungi prodotto
        else if(operation==1) {
            PBean p =new PBean();
            int codP=Integer.parseInt(request.getParameter("Codice"));
            Collection<Bean> bpr = null;
            try {
                bpr=model.doRetrieveAll("Codice");
            } catch (SQLException e) {
                e.printStackTrace();
            }

            ArrayList<Integer> codici =new ArrayList<Integer>();
            for(Bean bean :bpr) {
                codici.add(((PBean) bean).getCodice());
            }
            if(codici.contains(codP)) {
                response.sendRedirect("productoperation.jsp?operation=1&isPreso=true");
                return;
            }
            String immagine=request.getParameter("Immagine");
            String nome=request.getParameter("Nome");
            String descrizioneBreve=request.getParameter("descrizioneBreve");
            String descrizioneLunga=request.getParameter("descrizioneLunga");
            String disponibilita=request.getParameter("Disponibilita");
            String prezzo=request.getParameter("prezzo");
            String novita=request.getParameter("novita");
            System.out.println(novita);
            String offerta=request.getParameter("offerta");
            System.out.println(offerta);

            p.setCodice();
            p.setDescrizioneBreve(descrizioneBreve);
            p.setDescrizioneLunga(descrizioneLunga);
            p.setDisponibilita(Integer.parseInt(disponibilita));
            p.setNovita(Boolean.parseBoolean(novita));
            p.setOfferta(Boolean.parseBoolean(offerta));
            p.setPrezzo(new Float(prezzo));
            p.setNome(nome);
            p.setImmagine(immagine);
            System.out.println(p.toString());


            String nomeCat=request.getParameter("Categoria");
            if (nomeCat.equalsIgnoreCase("Cura")) {
                p.setCategoria(String.valueOf(1));

                CuraBean cu=new CuraBean();

                cu.setCodice(codP);
                cu.setDescrizioneBreve(descrizioneBreve);
                cu.setDescrizioneLunga(descrizioneLunga);
                cu.setDisponibilita(Integer.parseInt(disponibilita));
                cu.setNovita(Boolean.parseBoolean(novita));
                cu.setOfferta(Boolean.parseBoolean(offerta));
                cu.setPrezzo(new Float(prezzo));
                cu.setNome(nome);
                cu.setImmagine(immagine);
                System.out.println(cu.toString());

                try {
                    model.doSave(p);
                    modelcu.doSave(cu);
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }

            }
            else if(nomeCat.equalsIgnoreCase("Accessorio")) {
                p.setCategoria(String.valueOf(2));

                AccessorioBean a=new AccessorioBean();

                String desCat=request.getParameter("sceltaa");
                a.setDescrizioneCategoria(desCat);
                a.setCodice(codP);
                a.setCategoria(nomeCat);
                try {
                    model.doSave(p);
                    modelad.doSave(a);
                    System.out.println(a.toString());
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            else if(nomeCat.equalsIgnoreCase("Cibo")) {
                p.setCategoria(String.valueOf(3));

                AccessorioBean cb=new AccessorioBean();

                String desCat=request.getParameter("sceltaa");
                cb.setDescrizioneCategoria(desCat);
                cb.setCodice(codP);
                cb.setCategoria(nomeCat);
                try {
                    model.doSave(p);
                    modelcd.doSave(cb);
                    System.out.println(cb.toString());
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            response.sendRedirect("productoperation.jsp?operation=1&isPreso=false");
            return;

            //modifica prodotto
        }
        else if(operation ==2) {
            PBean bp= new PBean();
            int codP=Integer.parseInt(request.getParameter("Codice"));
            try {
                bp= (PBean) model.doRetrieveByKey(codP);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            String titolo=request.getParameter("titolo");
            if(!titolo.equals(bp.getNome())) {
                try {
                    model.doUpdate("titolo", codP, titolo);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            String descrizioneB=request.getParameter("descrizioneBreve");
            if(!descrizioneB.equals(bp.getDescrizioneBreve())) {
                try {
                    model.doUpdate("descrizione", codP, descrizioneB);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            String descrizioneL=request.getParameter("descrizioneLunga");
            if(!descrizioneL.equals(bp.getDescrizioneLunga())) {
                try {
                    model.doUpdate("descrizione", codP, descrizioneL);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            String prezzo=request.getParameter("prezzo");
            Float price=new Float(prezzo);
            if((price)!=(bp.getPrezzo())) {
                try {
                    model.doUpdate("prezzo", codP, price);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            String quantita=request.getParameter("disponibilita");
            if(Integer.parseInt(quantita)!=bp.getDisponibilita()) {
                try {
                    model.doUpdate("disponibilita", codP, quantita);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            String novita=request.getParameter("novita");
            System.out.println(novita);
            if(Boolean.parseBoolean(novita)!=bp.isNovita()) {
                try {
                    model.doUpdate("novita", codP, Boolean.parseBoolean(novita));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            String offerta=request.getParameter("offerta");
            System.out.println(offerta);
            if(Boolean.parseBoolean(offerta)!=bp.isOfferta()) {
                try {
                    model.doUpdate("offerta", codP, Boolean.parseBoolean(offerta));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            String foto=request.getParameter("Immagine");
            if(!foto.equals(bp.getImmagine())) {
                try {
                    model.doUpdate("foto", codP, foto);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            String nomeCat=request.getParameter("Categoria");
            if (nomeCat.equalsIgnoreCase("Cura")) {
                CuraBean cu= new CuraBean();
                try {
                    cu= (CuraBean) modelcu.doRetrieveByKey(codP);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                String desCat=request.getParameter("descrizioneCategoriaCura");
                if(!desCat.equals(cu.getDescrizioneCategoria())) {
                    try {
                        modelcu.doUpdate("descrizioneCategoria", codP, desCat);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
            nomeCat=request.getParameter("Categoria");
            if (nomeCat.equalsIgnoreCase("cibo")) {
                CiboBean ci= new CiboBean();
                try {
                    ci= (CiboBean) modelcd.doRetrieveByKey(codP);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                String desCat=request.getParameter("descrizioneCategoriaCibo");
                if(!desCat.equals(ci.getDescrizioneCategoria())) {
                    try {
                        modelcd.doUpdate("descrizioneCategoria", codP, desCat);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
            else {
                String desCat=request.getParameter("Categoria");
                AccessorioBean ba= new AccessorioBean();
                try {
                    ba= (AccessorioBean) modelad.doRetrieveByKey(codP);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                if(!desCat.equals(ba.getDescrizioneCategoria())) {
                    try {
                        modelad.doUpdate("Categoria", codP, desCat);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

            }
            response.sendRedirect("productoperation.jsp?operation=2");
            return;

        }
        //Visualizza catalogo
        else if(operation==4){
            System.out.println("retrieve all");
            Collection <Bean> bpr = null;
            try {
                bpr=model.doRetrieveAll("codiceProdotto");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            request.setAttribute("elencoProdotti", bpr);

            return;
        }
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
