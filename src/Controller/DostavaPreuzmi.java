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

/**
 * Servlet implementation class DostavaPreuzmi
 */

public class DostavaPreuzmi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DostavaPreuzmi() {
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
		System.out.println("Ulazak u servlet DostavaPreuzmi.");
		ServletContext ctx = getServletContext();
		
		Dostavljac dostavljac = (Dostavljac) session.getAttribute("dostavljac");
		String preuzmi = request.getParameter("preuzmi");
		
		List<Porudzbina> sve_porudzbine = InstanceOPH.getInstance().getListaPorudzbina();
		ctx.setAttribute("sve_porudzbine", sve_porudzbine);
		sve_porudzbine = (List<Porudzbina>) ctx.getAttribute("sve_porudzbine");
		
		Korisnik kori = new Korisnik();
		List<Porudzbina> lista_dostava = InstanceOPH.getInstance().getDostava(dostavljac.getUser_name()).getDostavljac_porudzbine();
		ctx.setAttribute("lista_dostava", lista_dostava);
		lista_dostava = (List<Porudzbina>) ctx.getAttribute("lista_dostava");
		
		if(dostavljac != null)
		{
			if(preuzmi != null)
			{
				for(Porudzbina p:sve_porudzbine)
				{
					if(preuzmi.equals(p.getPorudzbina_datumivrijeme()))
					{
						if(p.getPorudzbina_dostavljac().getName().equals(""))
						{
							if(!(p.getPorudzbina_status().equals("Otkazano")))
							{
								if(dostavljac.getDostavljac_porudzbine().isEmpty())
								{
									System.out.println("usao");
									p.setPorudzbina_dostavljac(dostavljac);
									p.setPorudzbina_status("Dostava u toku");
									lista_dostava.add(p);
									dostavljac.setDostavljac_porudzbine(lista_dostava);
									InstanceOPH.getInstance().getDostava(dostavljac.getUser_name()).setDostavljac_porudzbine(lista_dostava);
									InstanceOPH.getInstance().saveToFile();
									ctx.setAttribute("lista_dostava", null);
									ctx.setAttribute("sve_porudzbine", sve_porudzbine);
									System.out.println("stavio porudzbinu u dostavljaca");
									break;
								} else
								{
									System.out.println("Vec imate jednu narudzbu!");
								}
							}
						}
					}
				}
				response.sendRedirect("vozila_preuzmi.jsp");
			}
		}
	}

}
