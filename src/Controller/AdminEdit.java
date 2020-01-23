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

import Model.Administrator;
import Model.Artikal;
import Model.InstanceOPH;
import Model.Restoran;
import Model.Vozila;

/**
 * Servlet implementation class AdminEdit
 */

public class AdminEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminEdit() {
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
		String izmjeni = request.getParameter("izmjeni");
		String izmjeni_artikal = request.getParameter("izmjeni_artikal");
		String izmjeni_vozilo = request.getParameter("izmjeni_vozilo");

		if(izmjeni != null)
		{
			if(admin != null)
			{
				List<Restoran> restorani = InstanceOPH.getInstance().getListaRestorana();
				ctx.setAttribute("restorani", restorani);
				restorani = (List<Restoran>) ctx.getAttribute("restorani");
				
				Restoran restoran = new Restoran();
				boolean obrisan_restoran = false;
				for(Restoran rest:restorani)
				{
					if(rest.getRestoran_naziv().equals(izmjeni))
					{
						if(!rest.getRestoran_kategorija().equals("obrisan"))
						{
							restoran = InstanceOPH.getInstance().getRestoran(rest.getRestoran_naziv());
							restorani.remove(rest);
							break;
						} else
						{
							obrisan_restoran = true;
							break;
						}
					}
				}
				if(!obrisan_restoran)
				{
					ctx.setAttribute("restorani", restorani);
					String naziv = restoran.getRestoran_naziv();
					String adresa = restoran.getRestoran_adresa();
					String kategorija = restoran.getRestoran_kategorija();
					
					ctx.setAttribute("restoran", restoran);
					request.setAttribute("naz", naziv);
					request.setAttribute("adr", adresa);
					request.setAttribute("kat", kategorija);
					
					System.out.println("izmjenjen");
					RequestDispatcher disp = request.getRequestDispatcher("izmjena_restorani.jsp");
					disp.forward(request, response);
				} else
				{
					System.out.println("Restoran je obrisan!");
					RequestDispatcher disp = request.getRequestDispatcher("index_admin.jsp");
					disp.forward(request, response);
				}
				
				
			} else
			{
				response.sendRedirect("index_admin.jsp");
			}
		} else
		{
			System.out.println("Nema izmjene restorana!");
		}
		

		if(izmjeni_artikal != null)
		{
			if(admin != null)
			{
				List<Artikal> artikli = InstanceOPH.getInstance().getListaArtikala();
				ctx.setAttribute("artikli", artikli);
				artikli = (List<Artikal>) ctx.getAttribute("artikli");
				
				Artikal art = new Artikal();
				boolean obrisan = false;
				for(Artikal artikal:artikli)
				{
					if(artikal.getNaziv_artikla().equals(izmjeni_artikal))
					{
						if(!artikal.getArtikal_tip().equals("obrisan"))
						{
							art = InstanceOPH.getInstance().getArtikal(artikal.getNaziv_artikla());
							artikli.remove(artikal);
							break;
						} else
						{
							obrisan = true;
							break;
						}
						
					}
				}
				if(!obrisan)
				{
					ctx.setAttribute("artikli", artikli);
					String naziv = art.getNaziv_artikla();
					Double cjena = art.getJedinicna_cjena();
					Integer kolicina = art.getKolicina_artikla();
					String opis = art.getOpis_artikla();
					String kol_kpa = art.getArtikal_kolicina_vr();
					String tipic = art.getArtikal_tip();
					String resto_zzz = art.getRestoran_artikal_STRING();
					
					ctx.setAttribute("artikal", art);
					request.setAttribute("naz", naziv);
					request.setAttribute("cje", cjena);
					request.setAttribute("nst", kolicina);
					request.setAttribute("ops", opis);
					request.setAttribute("kpa", kol_kpa);
					request.setAttribute("tip", tipic);
					request.setAttribute("res", resto_zzz);
					
					RequestDispatcher disp = request.getRequestDispatcher("izmjena_artikala.jsp");
					disp.forward(request, response);
				} else
				{
					System.out.println("Artikal je obrisan!");
					RequestDispatcher disp = request.getRequestDispatcher("index_admin.jsp");
					disp.forward(request, response);
				}
				
				
			} else
			{
				response.sendRedirect("index_admin.jsp");
			}
		} else
		{
			System.out.println("Nema izmjene artikla!");
		}
		

		if(izmjeni_vozilo != null)
		{
			if(admin != null)
			{
				List<Vozila> vozila = InstanceOPH.getInstance().getListaVozila();
				ctx.setAttribute("vozila", vozila);
				vozila = (List<Vozila>) ctx.getAttribute("vozila");
				
				Vozila voz = new Vozila();
				boolean obrisano_vozilo = false;
				for(Vozila vozilo:vozila)
				{
					if(vozilo.getModel_vozila().equals(izmjeni_vozilo))
					{
						if(!vozilo.getTip_vozila().equals("obrisan"))
						{
							voz = InstanceOPH.getInstance().getVozilo(vozilo.getModel_vozila());
							vozila.remove(vozilo);
							break;
						} else
						{
							obrisano_vozilo = true;
							break;
						}
						
					}
				}
				if(!obrisano_vozilo)
				{
					ctx.setAttribute("vozila", vozila);
					String model = voz.getModel_vozila();
					String marka = voz.getMarka_vozila();
					String registracija = voz.getRegistracija_vozila();
					Integer godina = voz.getGod_proizvodnje_vozila();
					String tip = voz.getTip_vozila();
					String napomena = voz.getNapomena();
					String upotreba = voz.isUpotreba_vozila();
					
					ctx.setAttribute("vozilo", voz);
					request.setAttribute("mod", model);
					request.setAttribute("mar", marka);
					request.setAttribute("god", godina);
					request.setAttribute("tip", tip);
					request.setAttribute("reg", registracija);
					request.setAttribute("upo", upotreba);
					request.setAttribute("nap", napomena);
					
					RequestDispatcher disp = request.getRequestDispatcher("izmjena_vozila.jsp");
					disp.forward(request, response);
				} else
				{
					System.out.println("Vozilo je obrisano!");
					RequestDispatcher disp = request.getRequestDispatcher("index_admin.jsp");
					disp.forward(request, response);
				}
				
				
			} else
			{
				response.sendRedirect("index_admin.jsp");
			}
		} else
		{
			System.out.println("Nema izmjene vozila!");
		}
		
	}

}
