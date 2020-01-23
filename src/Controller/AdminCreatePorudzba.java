package Controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
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
import Model.Dostavljac;
import Model.InstanceOPH;
import Model.Korisnik;
import Model.Porudzbina;

/**
 * Servlet implementation class AdminCreatePorudzba
 */

public class AdminCreatePorudzba extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCreatePorudzba() {
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
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		ServletContext ctx = getServletContext();
		
		Administrator admin = (Administrator) session.getAttribute("admin");
		
		String korisnik = request.getParameter("korisnici_tabela");
		String dostavljac = request.getParameter("dostavljaci_tabela");
		String poruci = request.getParameter("poruci");
		String kolicina = request.getParameter("kolicina");
		String otkazi_porudzbu = request.getParameter("otkazi_porudzbinu");
		String izmjeni = request.getParameter("izmjeni");
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	    java.util.Date today = Calendar.getInstance().getTime();        
	    String timeAndDate = df.format(today);
		
	    HashMap<Artikal, Integer> stavke = new HashMap<Artikal, Integer>();
	    
	    HashMap<Artikal, Integer> top_10 = InstanceOPH.getInstance().getListaTop10();
	    ctx.setAttribute("top_10", top_10);
	    top_10 = (HashMap<Artikal, Integer>) ctx.getAttribute("top_10");
	    
	    Integer kolicinaInteger = null;
	    
	    List<Korisnik> korisnici = InstanceOPH.getInstance().getListaKorisnika();
		ctx.setAttribute("korisnici", korisnici);
		korisnici = (List<Korisnik>) ctx.getAttribute("korisnici");
		
		List<Dostavljac> dostavljaci = InstanceOPH.getInstance().getListaDostavljaca();
		ctx.setAttribute("dostavljaci", dostavljaci);
		dostavljaci = (List<Dostavljac>) ctx.getAttribute("dostavljaci");
	    
		List<Porudzbina> porudzbine = new ArrayList<Porudzbina>();
		if(korisnik != null)
		{
			porudzbine = InstanceOPH.getInstance().getKorisnik(korisnik).getPorudzbine();
			ctx.setAttribute("porudzbine", porudzbine);
			porudzbine = (List<Porudzbina>) ctx.getAttribute("porudzbine");
		}
		if(porudzbine == null)
		{
			porudzbine = new ArrayList<Porudzbina>();
		}
		
		List<Artikal> artikli = InstanceOPH.getInstance().getListaArtikala();
		ctx.setAttribute("artikli", artikli);
		artikli = (List<Artikal>) ctx.getAttribute("artikli");
		
		List<Porudzbina> sve_porudzbine = InstanceOPH.getInstance().getListaPorudzbina();
		ctx.setAttribute("sve_porudzbine", sve_porudzbine);
		sve_porudzbine = (List<Porudzbina>) ctx.getAttribute("sve_porudzbine");
		
		List<Porudzbina> lista_dostava = new ArrayList<Porudzbina>();
	    if(dostavljac != null )
	    {
	    	if(dostavljac != "")
	    	{
	    		lista_dostava = InstanceOPH.getInstance().getDostava(dostavljac).getDostavljac_porudzbine();
				ctx.setAttribute("lista_dostava", lista_dostava);
				lista_dostava = (List<Porudzbina>) ctx.getAttribute("lista_dostava");
	    	}
	    	
	    }
		if(lista_dostava == null)
		{
			lista_dostava = new ArrayList<Porudzbina>();
		}
		Artikal temp = new Artikal();
		
		if(admin != null)
		{
			if(korisnik != null && dostavljac != null && poruci != null && kolicina != null)
			{
				System.out.println("Usao u if petlju sa puno jada");
				for(Artikal artikal:artikli)
				{
					if(artikal.getNaziv_artikla().equals(poruci))
					{
						temp = artikal;
						ctx.setAttribute("artikal", temp);
						break;
					}
				}
				kolicinaInteger = Integer.parseInt(kolicina);
				stavke.put(temp, kolicinaInteger);
				Integer nova_kolicina = temp.getKolicina_artikla() - kolicinaInteger;
				if(nova_kolicina < 0)
				{
					System.out.println("Nema ga na stanju!");
				} else
				{
					Korisnik kori = new Korisnik();
					for(Korisnik k:korisnici)
					{
						if(k.getUser_name().equals(korisnik))
						{
							kori = k;
							break;
						}
					}
					Dostavljac dori = new Dostavljac();
					for(Dostavljac d:dostavljaci)
					{
						if(d.getUser_name().equals(dostavljac))
						{
							dori = d;
							break;
						}
					}
					temp.setKolicina_artikla(nova_kolicina);
					Porudzbina nova_porudzbina = new Porudzbina();
					nova_porudzbina.setLista_stavki(stavke);
					nova_porudzbina.setPorudzbina_datumivrijeme(timeAndDate);
					nova_porudzbina.setPorudzbina_kupac(kori);
					boolean ima = false;
					if(dori.getDostavljac_porudzbine().isEmpty())
					{
						ima = true;
						nova_porudzbina.setPorudzbina_dostavljac(dori);
					} else
					{
						System.out.println("dostavljac ima porudzbu!");
					}
					
					if(!ima)
					{
						nova_porudzbina.setPorudzbina_status("Poruèeno");
					} else
					{
						nova_porudzbina.setPorudzbina_status("Dostava u toku");
					}
					nova_porudzbina.setPorudzbina_napomena("---");
					

					porudzbine.add(nova_porudzbina);
					lista_dostava.add(nova_porudzbina);
					InstanceOPH.getInstance().addPorudzbina(nova_porudzbina);
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
					kori.setPorudzbine(porudzbine);
					dori.setDostavljac_porudzbine(lista_dostava);
					top_10 = InstanceOPH.getInstance().sortByComparator(top_10, false);
					InstanceOPH.getInstance().saveToFile();
					ctx.setAttribute("top_10", top_10);
					ctx.setAttribute("porudzbine", null);
					ctx.setAttribute("sve_porudzbine", sve_porudzbine);
				}
				response.sendRedirect("admin_porudzbe.jsp");
			}
			if(otkazi_porudzbu != null)
			{	
				Porudzbina porudzbaSve = new Porudzbina();
				for(Porudzbina p:sve_porudzbine)
				{
					if(p.getPorudzbina_datumivrijeme().equals(otkazi_porudzbu))
					{
						porudzbaSve = p;
						break;
					}
				}
				
				Korisnik kori = porudzbaSve.getPorudzbina_kupac();
				Dostavljac dori = porudzbaSve.getPorudzbina_dostavljac();
				Artikal pamti = new Artikal();
				for(Artikal artikal:artikli)
				{
					if(artikal.getNaziv_artikla().equals(porudzbaSve.ispis_mape_STRING()))
					{
						pamti = artikal;
						artikal.setKolicina_artikla(porudzbaSve.ispis_mape_vrijednost_int() + artikal.getKolicina_artikla());
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
				HashMap<Artikal, Integer> porud = porudzbaSve.getLista_stavki();
				dori.getDostavljac_porudzbine().remove(porudzbaSve);
				kori.getPorudzbine().remove(porudzbaSve);
				InstanceOPH.getInstance().deletePorudzbina(porudzbaSve);
				porudzbaSve.setLista_stavki(porud);
				porudzbaSve.setPorudzbina_datumivrijeme(timeAndDate);
				porudzbaSve.setPorudzbina_dostavljac(null);
				porudzbaSve.setPorudzbina_kupac(null);
				porudzbaSve.setPorudzbina_napomena("---");
				porudzbaSve.setPorudzbina_status("Otkazano");
				dori.getDostavljac_porudzbine().add(porudzbaSve);
				kori.getPorudzbine().add(porudzbaSve);
				InstanceOPH.getInstance().addPorudzbina(porudzbaSve);
				top_10 = InstanceOPH.getInstance().sortByComparator(top_10, false);
				InstanceOPH.getInstance().saveToFile();
				ctx.setAttribute("top_10", top_10);
				response.sendRedirect("admin_porudzbe.jsp");
				
			}
			
			if(izmjeni != null)
			{
				Porudzbina after_change = new Porudzbina();
				boolean obrisana = false;
				for(Porudzbina p:sve_porudzbine)
				{
					if(izmjeni.equals(p.getPorudzbina_datumivrijeme()))
					{
						if(!p.getPorudzbina_status().equals("Otkazano"))
						{
							after_change = p;
							sve_porudzbine.remove(p);
							break;
						} else
						{
							obrisana = true;
							break;
						}
						
					}
				}
				if(!obrisana)
				{
					ctx.setAttribute("sve_porudzbine", sve_porudzbine);
					
					String change_user = after_change.getPorudzbina_kupac().getUser_name();
					String chgange_delivery = after_change.getPorudzbina_dostavljac().getUser_name();
					String change_date = after_change.getPorudzbina_datumivrijeme();
					String change_status = after_change.getPorudzbina_status();
					String change_note = after_change.getPorudzbina_napomena();
					Integer change_value = after_change.ispis_mape_vrijednost_int();
					
					request.setAttribute("kori", change_user);
					request.setAttribute("dori", chgange_delivery);
					request.setAttribute("status", change_status);
					request.setAttribute("napomena", change_note);
					request.setAttribute("kolicina", change_value);
					
					RequestDispatcher disp = request.getRequestDispatcher("admin_narudzba_izmjena.jsp");
					disp.forward(request, response);
				} else
				{
					System.out.println("Obrisanu porudzbu ne mozete mjenjati!");
					RequestDispatcher disp = request.getRequestDispatcher("admin_porudzbe.jsp");
					disp.forward(request, response);
				}
				 
			}
		}
		
		
		
		
		
	}

}
