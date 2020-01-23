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


import Model.Administrator;
import Model.Artikal;
import Model.InstanceOPH;
import Model.Restoran;
import Model.Vozila;

/**
 * Servlet implementation class AdminCreate
 */

public class AdminCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCreate() {
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
		ServletContext ctx = getServletContext();
		Administrator admin = (Administrator) session.getAttribute("admin");
		System.out.println("I did it all.");
		
		//artikli
		
		String naziv_artikla = request.getParameter("naziv_artikla");
		Double cjena_artikla = null;
		Integer kolicina_artikla = null;
		String kolicina_g_ml = request.getParameter("kolicina_grami_mililitri");
		String opis_artikla = request.getParameter("opis_artikla");
		String tip_artikla = request.getParameter("tip_artikla");
		String restoran_u_artiklu = request.getParameter("restoran_artikal");
		
		//restorani
		List<Restoran> restorani = InstanceOPH.getInstance().getListaRestorana();
		ctx.setAttribute("restorani", restorani);
		restorani = (List<Restoran>) ctx.getAttribute("restorani");
		
		List<Artikal> artikli = InstanceOPH.getInstance().getListaArtikala();
		ctx.setAttribute("artikli", artikli);
		artikli = (List<Artikal>) ctx.getAttribute("artikli");
		//vozila
		String marka_vozila = request.getParameter("marka_vozila");
		String model_vozila = request.getParameter("model_vozila");
		String tip_vozila = request.getParameter("tip_vozila");
		String reg_vozila = request.getParameter("registracija_vozila");
		Integer godiste_vozila = null;
		String upotreba_vozila = "";
		String napomena_vozila = request.getParameter("napomena_vozila");
		if(admin != null)
		{
			boolean provjera = false;
			if(naziv_artikla != null)
			{
				Restoran resto = new Restoran();
				for(Restoran r:restorani)
				{
					if(r.getRestoran_naziv().equals(restoran_u_artiklu))
					{
						resto = r;
						break;
					}
				}
				Artikal artikal = new Artikal();
				artikal.setNaziv_artikla(naziv_artikla);
				kolicina_artikla = Integer.parseInt(request.getParameter("kolicina_artikla"));
				cjena_artikla = Double.parseDouble(request.getParameter("cjena_artikla"));
				artikal.setKolicina_artikla(kolicina_artikla);
				artikal.setArtikal_kolicina_vr(kolicina_g_ml);
				artikal.setJedinicna_cjena(cjena_artikla);
				artikal.setOpis_artikla(opis_artikla);
				artikal.setArtikal_tip(tip_artikla);
				artikal.setRestoran_artikal(resto);
				
				
				
				if(tip_artikla.equals("jelo"))
				{
					if(resto.getLista_jela().isEmpty())
					{
						List<Artikal> jela_listica = new ArrayList<Artikal>();
						resto.setLista_jela(jela_listica);
						resto.getLista_jela().add(artikal);
					}
					for(Artikal x:resto.getLista_jela())
					{
						if(x.getNaziv_artikla().equals(artikal.getNaziv_artikla()))
						{
							System.out.println("Nema izmjene!");
							break;
						} else
						{
							if(resto.getLista_jela() == null)
							{
								List<Artikal> jela_listica = new ArrayList<Artikal>();
								resto.setLista_jela(jela_listica);
								resto.getLista_jela().add(artikal);
								break;
							} else
							{
								resto.getLista_jela().add(artikal);
								break;
							}
						}
					}
					
					
				} else
				{
					if(resto.getLista_pica().isEmpty())
					{
						List<Artikal> pica_listica = new ArrayList<Artikal>();
						resto.setLista_pica(pica_listica);
						resto.getLista_pica().add(artikal);
					}
					for(Artikal x:resto.getLista_pica())
					{
						if(x.getNaziv_artikla().equals(artikal.getNaziv_artikla()))
						{
							System.out.println("Nema izmjene!");
							break;
						} else
						{
							if(resto.getLista_pica() == null)
							{
								List<Artikal> pica_listica = new ArrayList<Artikal>();
								resto.setLista_pica(pica_listica);
								resto.getLista_pica().add(artikal);
								break;
							} else
							{
								resto.getLista_pica().add(artikal);
								break;
							}
						}
					}
				}
				
				for(Artikal a: InstanceOPH.getInstance().getListaArtikala())
				{
					if(a.getNaziv_artikla().equals(naziv_artikla))
					{
						System.out.println("postoji artikal " + a.getNaziv_artikla());
						provjera = true;
						break;
					}
				}
				if(provjera)
				{
					System.out.println("Pokusaj opet!");
					response.sendRedirect("dodavanje_artikala.jsp");
				}else
				{
					artikli.add(artikal);
					
					ctx.setAttribute("artikal", artikal);
					System.out.println("artikal: "+ artikal.getNaziv_artikla());
					InstanceOPH.getInstance().saveToFile();
					
					ctx.setAttribute("artikli", artikli);
					provjera = false;
					response.sendRedirect("artikli.jsp");
				}
		} else if(model_vozila != null)
		{
			Vozila vozilo = new Vozila();
			vozilo.setModel_vozila(model_vozila);
			vozilo.setMarka_vozila(marka_vozila);
			godiste_vozila = Integer.parseInt(request.getParameter("godiste_vozila"));
			vozilo.setGod_proizvodnje_vozila(godiste_vozila);
			vozilo.setTip_vozila(tip_vozila);
			vozilo.setRegistracija_vozila(reg_vozila);
			upotreba_vozila = request.getParameter("upotreba_vozila");
			vozilo.setUpotreba_vozila(upotreba_vozila);
			vozilo.setNapomena(napomena_vozila);
			
			for(Vozila v: InstanceOPH.getInstance().getListaVozila())
			{
				if(v.getMarka_vozila().equals(model_vozila))
				{
					System.out.println("postoji auto " + v.getMarka_vozila());
					provjera = true;
					break;
				}
			}
			if(provjera)
			{
				System.out.println("Pokusaj opet!");
				response.sendRedirect("dodavanje_vozila.jsp");
			}else
			{
				InstanceOPH.getInstance().addVozilo(vozilo);
				ctx.setAttribute("vozilo", vozilo);
				System.out.println("vozilo: "+ vozilo.getMarka_vozila());
				InstanceOPH.getInstance().saveToFile();
				provjera = false;
				response.sendRedirect("vozila.jsp");
			}
		}
		} else
		{
			response.sendRedirect("index_admin.jsp");
		}
	}

}
