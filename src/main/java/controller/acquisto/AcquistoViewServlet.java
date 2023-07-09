package controller.acquisto;

import DAO.acquisto.AcquistoDAO;
import DAO.user.UserDAO;
import bean.Bean;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Collection;
import java.util.stream.Collectors;

@WebServlet(name = "AcquistoViewServlet", value = "/AcquistoViewServlet")
public class AcquistoViewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    static AcquistoDAO ad = new AcquistoDAO();
    static UserDAO ud=new UserDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String dataDa = request.getParameter("dataDa");
        String dataA = request.getParameter("dataA");
        String ordine = request.getParameter("ordinebtn");
        Collection<Bean> ba = null;

        System.out.println("Ecco l'ordine"+ordine);


        if (ordine == null) {
            if (dataDa != null && dataDa != "" && (username == "" || username == null) && (dataA == "" || dataA == null)) {
                try {
                    ba = ad.doRetrieveByDateFrom(LocalDate.parse(dataDa));
                    System.out.println("retrieve by DateFrom:" + ba);
                    session.setAttribute("listaOrdini", ba);
                    response.setStatus(200);
                    return;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (dataA != null && dataA != "" && (username == "" || username == null) && (dataDa==null || dataDa=="")) {
                try {
                    ba = ad.doRetrieveByDateTo(LocalDate.parse(dataA));
                    session.setAttribute("listaOrdini", ba);
                    System.out.println("retrieve by DateTo:" + ba);
                    response.setStatus(200);
                    return;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (username != null && username != "" && (dataDa == null || dataDa == "") && (dataA == "" || dataA == null)) {
                try {
                    ba = ad.doRetrieveByUser(username);
                    session.setAttribute("listaOrdini", ba);
                    System.out.println("retrieve by username:" + ba);
                    Collection<Bean> temp = ba.stream().distinct().collect(Collectors.toList());
                    session.setAttribute("listaOrdini", temp);
                    response.setStatus(200);
                    return;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (dataDa != null && dataA != null && dataDa!="" && dataA!="") {
                if (username != null && username!="") {
                    try {
                        ba = ad.doRetrieveByUserBetweenDate(LocalDate.parse(dataDa), LocalDate.parse(dataA), username);
                        session.setAttribute("listaOrdini", ba);
                        System.out.println("retrieve by username betweendate:" + ba);
                        response.setStatus(200);
                        return;
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        ba = ad.doRetrieveByDateBetween(LocalDate.parse(dataDa), LocalDate.parse(dataA));
                        session.setAttribute("listaOrdini", ba);
                        System.out.println("retrieve by dataDa e  dataA:" + ba);
                        response.setStatus(200);
                        return;
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }

            if ((username == null || username=="") && (dataDa==null||dataDa=="") && (dataA==null||dataA=="")) {
                System.out.println("lista totale");
                try {
                    ba = ad.doRetrieveAll("codiceOrdine");
                    session.setAttribute("listaOrdini", ba);
                    System.out.println("retrieve by all:" + ba);
                    Collection<Bean> temp = ba.stream().distinct().collect(Collectors.toList());
                    session.setAttribute("listaOrdini", temp);

                } catch (SQLException e) {
                    e.printStackTrace();
                }
                response.setStatus(200);
            }
        }

		else{
			try {
				ba=ud.doRetrieveByKey(ordine);
				session.setAttribute("cliente",ba);

				System.out.println(ordine);

				RequestDispatcher rd=request.getRequestDispatcher("order.jsp");
				rd.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);

    }
}
