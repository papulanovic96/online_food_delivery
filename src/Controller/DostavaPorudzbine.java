package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import Model.Porudzbina;
import Model.Vozila;

/**
 * Servlet implementation class DostavaPorudzbine
 */

public class DostavaPorudzbine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DostavaPorudzbine() {
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
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		System.out.println("Ulazak u servlet DostavaPorudzbine.");
		ServletContext ctx = getServletContext();
		
		Dostavljac dostavljac = (Dostavljac) session.getAttribute("dostavljac");
		
		String dostavi = request.getParameter("dostavi");
		
		Korisnik kori = new Korisnik();
		
		List<Porudzbina> lista_dostava = InstanceOPH.getInstance().getDostava(dostavljac.getUser_name()).getDostavljac_porudzbine();
		ctx.setAttribute("lista_dostava", lista_dostava);
		lista_dostava = (List<Porudzbina>) ctx.getAttribute("lista_dostava");
		
		List<Vozila> vozila = InstanceOPH.getInstance().getListaVozila();
		ctx.setAttribute("vozila", vozila);
		vozila = (List<Vozila>) ctx.getAttribute("vozila");
		
		List<Porudzbina> dostavljene =  (List<Porudzbina>) ctx.getAttribute("dostavljene");
		if(dostavljene == null)
		{
			dostavljene = new ArrayList<Porudzbina>();
		}
		
		if(dostavljac != null)
		{
			if(dostavi != null)
			{
				for(Porudzbina p:lista_dostava)
				{
					if(dostavi.equals(p.getPorudzbina_datumivrijeme()))
					{
						//stavi na dostavljeno i onemoguci dalji rad sa porudzbinom *valjda tako treba
						System.out.println("Pikiro sam porudzbinu.");
						p.setPorudzbina_status("Dostavljeno");
						Vozila v = dostavljac.getDostavljac_vozilo();
						for(Vozila s:vozila)
						{
							s.setUpotreba_vozila("Slobodno");
							break;
						}
						dostavljene.add(p);
						dostavljac.getDostavljac_porudzbine().clear();
						InstanceOPH.getInstance().saveToFile();
						ctx.setAttribute("dostavljene", dostavljene);
						break;
					}
				}
				response.sendRedirect("preuzete.jsp");
			}
		}
		
	}

}
