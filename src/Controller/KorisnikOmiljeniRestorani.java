package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Artikal;
import Model.InstanceOPH;
import Model.Korisnik;
import Model.Restoran;

/**
 * Servlet implementation class KorisnikOmiljeniRestorani
 */

public class KorisnikOmiljeniRestorani extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KorisnikOmiljeniRestorani() {
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
		
		Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");
		
		String omiljeni = request.getParameter("omiljeni");
		
		List<Restoran> restorani = InstanceOPH.getInstance().getListaRestorana();
		ctx.setAttribute("restorani", restorani);
		restorani = (List<Restoran>) ctx.getAttribute("restorani");
		
		List<Restoran> omiljeni_restorani = (List<Restoran>) ctx.getAttribute("omiljeni_restorani");
		System.out.println(omiljeni_restorani.size());
		
		List<Restoran> svi_omiljeni = InstanceOPH.getInstance().getListaOmiljenihRestorana();
		ctx.setAttribute("svi_omiljeni", svi_omiljeni);
		svi_omiljeni = (List<Restoran>) ctx.getAttribute("svi_omiljeni");
		
		if(svi_omiljeni == null)
		{
			svi_omiljeni = new ArrayList<Restoran>();
		}
		
		if(omiljeni_restorani == null)
		{
			omiljeni_restorani = new ArrayList<Restoran>();
		}
		Restoran temp = new Restoran();
		if(korisnik != null)
		{
			if(omiljeni != null)
			{
				for(Restoran resto:restorani)
				{
					if(omiljeni.equals(resto.getRestoran_naziv()))
					{
						temp = InstanceOPH.getInstance().getRestoran(resto.getRestoran_naziv());
						
						ctx.setAttribute("restoran", temp);
						break;
					}
				}
				if(korisnik.getOmiljeni_restorani()==null) {
					korisnik.setOmiljeni_restorani(new ArrayList<Restoran>());
				ctx.setAttribute("omiljeni_restorani", new ArrayList());
				}
				
				if(korisnik.getOmiljeni_restorani().isEmpty())
				{	
					ctx.setAttribute("omiljeni_restorani", new ArrayList<>());
					
					omiljeni_restorani.add(temp);
					korisnik.setOmiljeni_restorani(omiljeni_restorani);
					
					InstanceOPH.getInstance().saveToFile();
					ctx.setAttribute("omiljeni_restorani", omiljeni_restorani);
					ctx.setAttribute("svi_omiljeni", svi_omiljeni);
					session.setAttribute("korisnik", korisnik);
					System.out.println("nema");
				} else
				{
					for(Restoran r:omiljeni_restorani)
					{
						if(r.getRestoran_naziv().equals(temp.getRestoran_naziv()))
						{
							System.out.println("Vec postoji ovaj restoran u listi omiljenih!");
						} else
						{
							omiljeni_restorani.add(temp);
							korisnik.setOmiljeni_restorani(omiljeni_restorani);
							InstanceOPH.getInstance().saveToFile();
							ctx.setAttribute("omiljeni_restorani", omiljeni_restorani);
							ctx.setAttribute("svi_omiljeni", svi_omiljeni);
							session.setAttribute("korisnik", korisnik);
							System.out.println("ima");
							break;
						}
					}
				}
				
				response.sendRedirect("omiljeni.jsp");
			}
		}
		
	} 

}
