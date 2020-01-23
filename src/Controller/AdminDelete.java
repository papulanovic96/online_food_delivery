package Controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Administrator;
import Model.Artikal;
import Model.InstanceOPH;
import Model.Restoran;
import Model.Vozila;

/**
 * Servlet implementation class AdminDelete
 */

public class AdminDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDelete() {
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
		Administrator admin = (Administrator) session.getAttribute("admin");
		ServletContext ctx = getServletContext();
		
		String obrisi = request.getParameter("obrisi");
		
		if(admin != null)
		{
			List<Artikal> artikli = InstanceOPH.getInstance().getListaArtikala();
			ctx.setAttribute("artikli", artikli);
			artikli = (List<Artikal>) ctx.getAttribute("artikli");
			
			for(Artikal artikal:artikli)
			{
				if(artikal.getNaziv_artikla().equals(obrisi))
				{
					InstanceOPH.getInstance().deleteArtikal(artikal);
					artikal.setArtikal_kolicina_vr("---");
					artikal.setArtikal_tip("obrisan");
					artikal.setJedinicna_cjena(-1.0);
					artikal.setKolicina_artikla(-1);
					artikal.setOpis_artikla("---");
					InstanceOPH.getInstance().addArtikal(artikal);
					InstanceOPH.getInstance().saveToFile();
					ctx.setAttribute("artikli", artikli);
					response.sendRedirect("artikli.jsp");
					break;
				}
			}
			
			List<Vozila> vozila = InstanceOPH.getInstance().getListaVozila();
			ctx.setAttribute("vozila", vozila);
			vozila = (List<Vozila>) ctx.getAttribute("vozila");
			
			for(Vozila vozilo:vozila)
			{
				if(vozilo.getModel_vozila().equals(obrisi))
				{
					InstanceOPH.getInstance().deleteVozilo(vozilo);
					vozilo.setGod_proizvodnje_vozila(-1);
					vozilo.setNapomena("---");
					vozilo.setRegistracija_vozila("---");
					vozilo.setTip_vozila("obrisan");
					vozilo.setUpotreba_vozila("Slobodan");
					InstanceOPH.getInstance().addVozilo(vozilo);
					InstanceOPH.getInstance().saveToFile();
					ctx.setAttribute("vozila", vozila);
					response.sendRedirect("vozila.jsp");
					break;
				}
			}
			List<Restoran> restorani = InstanceOPH.getInstance().getListaRestorana();
			ctx.setAttribute("restorani", restorani);
			restorani = (List<Restoran>) ctx.getAttribute("restorani");
			
			for(Restoran restoran:restorani)
			{
				if(restoran.getRestoran_naziv().equals(obrisi))
				{
					InstanceOPH.getInstance().deleteRestoran(restoran);
					/*List<Artikal> jela = restoran.getLista_jela();
					List<Artikal> pica = restoran.getLista_pica();
					List<Artikal> artikliX = InstanceOPH.getInstance().getListaArtikala();
					Iterator<Artikal> it = artikliX.iterator();
					while(it.hasNext())
					{
						Artikal a = (Artikal) it.next();
						if(jela.contains(a))
						{
							InstanceOPH.getInstance().deleteArtikal(a);
							a.setArtikal_kolicina_vr("---");
							a.setArtikal_tip("obrisan");
							a.setJedinicna_cjena(-1.0);
							a.setKolicina_artikla(-1);
							a.setOpis_artikla("---");
							InstanceOPH.getInstance().addArtikal(a);
							InstanceOPH.getInstance().saveToFile();
							ctx.setAttribute("artikli", artikli);
							break;
						} else if(pica.contains(a))
						{
							InstanceOPH.getInstance().deleteArtikal(a);
							a.setArtikal_kolicina_vr("---");
							a.setArtikal_tip("obrisan");
							a.setJedinicna_cjena(-1.0);
							a.setKolicina_artikla(-1);
							a.setOpis_artikla("---");
							InstanceOPH.getInstance().addArtikal(a);
							InstanceOPH.getInstance().saveToFile();
							ctx.setAttribute("artikli", artikli);
							break;
						}
					}*/
					restoran.setLista_jela(null);
					restoran.setLista_pica(null);
					restoran.setRestoran_adresa("---");
					restoran.setRestoran_kategorija("obrisan");
					InstanceOPH.getInstance().addRestoran(restoran);
					InstanceOPH.getInstance().saveToFile();
					ctx.setAttribute("restorani", restorani);
					response.sendRedirect("restorani.jsp");
					break;
				}
			}
		} else
		{
			response.sendRedirect("index_admin.jsp");
		}
	}

}