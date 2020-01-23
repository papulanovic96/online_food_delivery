package Controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

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
import Model.Korisnik;
import Model.Porudzbina;
import Model.Restoran;

/**
 * Servlet implementation class KorisnikKreiranjePorudzbine
 */

public class KorisnikKreiranjePorudzbine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KorisnikKreiranjePorudzbine() {
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
		System.out.println("Ulazak u servlet KorisnikKreiranjePorudzbine.");
		ServletContext ctx = getServletContext();
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	    java.util.Date today = Calendar.getInstance().getTime();        
	    String timeAndDate = df.format(today);
	    
	    Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");
	    String otkazi_porudzbu = request.getParameter("otkazi_porudzbu");
	    
		String poruci = request.getParameter("poruci");
		
		String kolicina_txt = request.getParameter("kolicina");
		HashMap<Artikal, Integer> stavke = new HashMap<Artikal, Integer>();
		
		List<Artikal> artikli = InstanceOPH.getInstance().getListaArtikala();
		ctx.setAttribute("artikli", artikli);
		artikli = (List<Artikal>) ctx.getAttribute("artikli");
		
		Integer kolicina = null;
		
		List<Porudzbina> porudzbine = InstanceOPH.getInstance().getKorisnik(korisnik.getUser_name()).getPorudzbine();
		ctx.setAttribute("porudzbine", porudzbine);
		porudzbine = (List<Porudzbina>) ctx.getAttribute("porudzbine");
		
		HashMap<Artikal, Integer> top_10 = InstanceOPH.getInstance().getListaTop10();
	    ctx.setAttribute("top_10", top_10);
	    top_10 = (HashMap<Artikal, Integer>) ctx.getAttribute("top_10");
		
		List<Porudzbina> sve_porudzbine = InstanceOPH.getInstance().getListaPorudzbina();
		ctx.setAttribute("sve_porudzbine", sve_porudzbine);
		sve_porudzbine = (List<Porudzbina>) ctx.getAttribute("sve_porudzbine");
		
		
		if(porudzbine == null)
		{
			porudzbine = new ArrayList<Porudzbina>();
		}
		
		
		if(korisnik != null)
		{
			
			if(poruci != null)
			{
				Artikal temp = new Artikal();
				for(Artikal artikal:artikli)
				{
					if(artikal.getNaziv_artikla().equals(poruci))
					{
						temp = InstanceOPH.getInstance().getArtikal(artikal.getNaziv_artikla());
						ctx.setAttribute("artikal", temp);
						stavke = (HashMap<Artikal, Integer>) ctx.getAttribute("stavke");
						if(stavke == null)
						{
							stavke = new HashMap<Artikal, Integer>();
						}
						kolicina = Integer.parseInt(kolicina_txt);
						stavke.put(temp, kolicina);
						ctx.setAttribute("stavke", stavke);
						Integer nova_kolicina = temp.getKolicina_artikla() - kolicina;
						if(nova_kolicina < 0)
						{
							System.out.println("Nema ga na stanju!");
							response.sendRedirect("artikli_korisnik.jsp");
						} else
						{
							temp.setKolicina_artikla(nova_kolicina);
							
							if(top_10 == null)
							{
								top_10 = new HashMap<Artikal, Integer>();
							} if(top_10.containsKey(temp))
							{
								int i = top_10.get(temp);
								top_10.remove(temp);
								top_10.put(temp, i+1);
							} if(!top_10.containsKey(temp))
							{
								int broj_jela = 0;
								int broj_pica = 0;
								for(Artikal a:top_10.keySet())
								{
									if(a.getArtikal_tip().equals("jelo"))
									{
										broj_jela += 1;
									} else if(a.getArtikal_tip().equals("pice"))
									{
										broj_pica += 1;
									} else
									{
										System.out.println("wrong type!");
									}
								}
								if(temp.getArtikal_tip().equals("jelo"))
								{
									if(broj_jela < 10)
									{
										top_10.put(temp, 1);
									} else
									{
										System.out.println("Jelo punooooooo");
									}
								} else if(temp.getArtikal_tip().equals("pice"))
								{
									if(broj_pica < 10)
									{
										top_10.put(temp, 1);
									} else
									{
										System.out.println("Pice punooooooo");
									}
								}else
								{
									System.out.println("puno puno sve popunjeno..");
								}
							}
							response.sendRedirect("artikli_korisnik.jsp");
						}
						break;
					}
					
				}
			} else if(poruci == null && otkazi_porudzbu == null)
			{		
					Porudzbina nova_porudzbina = new Porudzbina();
					stavke = (HashMap<Artikal, Integer>) ctx.getAttribute("stavke");
					nova_porudzbina.setLista_stavki(stavke);
					
					nova_porudzbina.setPorudzbina_datumivrijeme(timeAndDate);
					nova_porudzbina.setPorudzbina_kupac(korisnik);
					nova_porudzbina.setPorudzbina_dostavljac(null);
					nova_porudzbina.setPorudzbina_napomena("---");
					nova_porudzbina.setPorudzbina_status("Poruèeno");

					porudzbine.add(nova_porudzbina);
					InstanceOPH.getInstance().addPorudzbina(nova_porudzbina);

					korisnik.setPorudzbine(porudzbine);
					top_10 = InstanceOPH.getInstance().sortByComparator(top_10, false);
					InstanceOPH.getInstance().saveToFile();
					ctx.setAttribute("top_10", top_10);
					ctx.setAttribute("stavke", null);
					ctx.setAttribute("porudzbine", null);
					ctx.setAttribute("sve_porudzbine", sve_porudzbine);
					response.sendRedirect("porudzbine.jsp");
			}
					
			
			if(otkazi_porudzbu != null)
			{	
				Integer komada = null;
				Porudzbina porudzba = new Porudzbina();
				for(Porudzbina p:korisnik.getPorudzbine())
				{
					if(p.getPorudzbina_datumivrijeme().equals(otkazi_porudzbu))
					{
						porudzba = p;
						break;
					}
				}
				Artikal pamti = new Artikal();
				for(Artikal artikal:artikli)
				{
					if(artikal.getNaziv_artikla().equals(porudzba.ispis_mape_STRING()))
					{
						pamti = artikal;
						artikal.setKolicina_artikla(porudzba.ispis_mape_vrijednost_int() + artikal.getKolicina_artikla());
						ctx.setAttribute("artikal", artikal);
						break;
					}
					
				}
				if(top_10 == null)
				{
					top_10 = new HashMap<Artikal, Integer>();
				} if(top_10.containsKey(pamti))
				{
					int i = top_10.get(pamti);
					if(i <= 1)
					{
						top_10.remove(pamti);
					} else
					{
						top_10.remove(pamti);
						top_10.put(pamti, i-1);
					}
				} 
				
				korisnik.getPorudzbine().remove(porudzba);
				porudzba.setPorudzbina_datumivrijeme(timeAndDate);
				porudzba.setPorudzbina_dostavljac(null);
				porudzba.setPorudzbina_kupac(null);
				porudzba.setPorudzbina_napomena("---");
				porudzba.setPorudzbina_status("Otkazano");
				korisnik.getPorudzbine().add(porudzba);
				top_10 = InstanceOPH.getInstance().sortByComparator(top_10, false);
				InstanceOPH.getInstance().saveToFile();
				ctx.setAttribute("top_10", top_10);
				response.sendRedirect("porudzbine.jsp");
			}
			
		}
		
	}

}
