package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Dostavljac;
import Model.InstanceOPH;
import Model.Korisnik;
import Model.Vozila;

/**
 * Servlet implementation class DostavaVozilo
 */

public class DostavaVozilo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DostavaVozilo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ServletContext ctx = getServletContext();
		
		Dostavljac dostavljac = (Dostavljac) session.getAttribute("dostavljac");
		
		String zauzmi_vozilo = request.getParameter("zauzmi_vozilo");
		
		List<Vozila> vozila = InstanceOPH.getInstance().getListaVozila();
		ctx.setAttribute("vozila", vozila);
		vozila = (List<Vozila>) ctx.getAttribute("vozila");
		
		if(dostavljac != null)
		{
			if(zauzmi_vozilo != null)
			{
				for(Vozila v:vozila)
				{
					if(v.getModel_vozila().equals(zauzmi_vozilo))
					{
						v.setUpotreba_vozila("Zauzeto");
						dostavljac.setDostavljac_vozilo(v);
						break;
					}
				}
				
				response.sendRedirect("preuzete.jsp");
			}
		}
	}

}
