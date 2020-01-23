package Controller;

import java.io.IOException;
import java.util.ArrayList;
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
import Model.Restoran;
import Model.Vozila;

/**
 * Servlet implementation class ServletStart
 */
public class ServletStart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletStart() {
        super();
        
        if(InstanceOPH.getInstance().getListaKorisnika().isEmpty())
        {
        	InstanceOPH.getInstance().setListaKorisnika(new ArrayList<Korisnik>());
        	
        	Korisnik k_new = new Korisnik("bane", "000", "Branislav", "Papulanovic", "kupac", "+387 66 917 222", "papulanovic@gmail.com", "19.6.2018", null, null,0);
        	Korisnik k_new2 = new Korisnik("gara", "001", "Branislav", "Garic", "kupac", "+387 66 004 639", "garic@gmail.com", "19.6.2018", null, null,0);
        	Korisnik k_new3 = new Korisnik("vex", "000", "Vedran", "Mimic", "kupac", "+387 65 342 342", "mimic@gmail.com", "19.6.2018", null, null,0);
        	
        	InstanceOPH.getInstance().addKorisnik(k_new);
        	InstanceOPH.getInstance().addKorisnik(k_new2);
        	InstanceOPH.getInstance().addKorisnik(k_new3);
        	
        	InstanceOPH.getInstance().saveToFile();
        	
        } 
        
        if(InstanceOPH.getInstance().getListaAdmina().isEmpty())
        {
        	InstanceOPH.getInstance().setListaAdmina(new ArrayList<Administrator>());
        	
        	Administrator admin = new Administrator();
        	//Dostavljac dostavljac = new Dostavljac("dostava","paps","Jovan","Ducic","dostavljac","+381 65 505 3856","dostava@gmail.com","21.6.2018");
        	admin.setName("Mladen");
        	admin.setLastname("Papulanovic");
        	admin.setEmail("admin_mp@paps.com");
        	admin.setRegistration_date("today");
        	admin.setUser_type("admin");
        	admin.setContact_phone("065/204-283");
        	admin.setUser_name("mladen");
        	admin.setUser_password("000");
        	InstanceOPH.getInstance().addAdmin(admin);
        	InstanceOPH.getInstance().saveToFile();
        }
        
        if(InstanceOPH.getInstance().getListaArtikala().isEmpty())
        {
        	InstanceOPH.getInstance().setListaArtikala(new ArrayList<Artikal>());
        	
        	Artikal a_new3 = new Artikal("Pivo Nektar", 3, "Banjaluèka.", 35, "pice", "500", null);
        	Artikal a_new4 = new Artikal("Prasetina", 25, "Vruæa s ražnja.", 44, "jelo", "300", null);
        	Artikal a_new1 = new Artikal("Pizza", 5.5, "Ljuta, porodièna.", 5, "jelo", "250", null);
        	Artikal a_new2 = new Artikal("Sarma", 10, "Smotana.", 150, "jelo", "100", null);
        	Artikal a_new5 = new Artikal("Rakija", 3, "Šljivovica iz Vlasenice.", 35, "pice", "100", null);
        	
        	Artikal a_new6 = new Artikal("Dzana", 25, "Rakija od džanarike.", 12, "pice", "50", null);
        	Artikal a_new7 = new Artikal("Teleci gulas", 10, "Fino ukuvan.", 37, "jelo", "390", null);
        	Artikal a_new8 = new Artikal("Krofne", 12, "Slatke.", 76, "jelo", "50", null);
        	Artikal a_new9 = new Artikal("Krompir przen", 10, "Domaæe jelo.", 150, "jelo", "120", null);
        	Artikal a_new10 = new Artikal("Macallan 18", 3, "Viski.", 35, "pice", "70", null);
        	
        	Artikal a_new11 = new Artikal("Voda", 0.30, "Izvorska, prirodna.", 900, "pice", "500", null);
        	Artikal a_new12 = new Artikal("Jagnjetina", 25.50, "Vruæa s ražnja.", 44, "jelo", "5000", null);
        	Artikal a_new13 = new Artikal("Paprikas", 15, "Ljuti.", 70, "jelo", "560", null);
        	Artikal a_new14 = new Artikal("Burek", 2.20, "Domaæa kuhinja.", 150, "jelo", "200", null);
        	Artikal a_new15 = new Artikal("Sok od narandze", 2, "Sa pulpom.", 35, "pice", "200", null);
        	
        	Artikal a_new16 = new Artikal("Vivia", 0.20, "Izvorska, nadprirodna.", 345, "pice", "600", null);
        	Artikal a_new17 = new Artikal("Peceni vo", 25, "Vruæ s ražnja.", 10, "jelo", "7000", null);
        	Artikal a_new18 = new Artikal("Supa", 10, "Masna.", 70, "jelo", "80", null);
        	Artikal a_new19 = new Artikal("Sataras", 24, "Domaca kuhinja.", 150, "jelo", "200", null);
        	Artikal a_new20 = new Artikal("Sok od jagode", 2, "Sa pulpom.", 405, "pice", "100", null);
        	
        	Artikal a_new21 = new Artikal("Papula", 2, "Specijalitet svih restorana.", 35, "jelo", "200", null);
        	Artikal a_new22 = new Artikal("Vodka", 5, "Ruska.", 23, "pice", "500", null);
        	Artikal a_new23 = new Artikal("Gorki list", 6, "Gorak.", 15, "pice", "100", null);
        	Artikal a_new24 = new Artikal("Pivo Jelen", 5, "Dobar, hladan.", 74, "pice", "500", null);
        	Artikal a_new25 = new Artikal("Vinjak", 9, "Rubin.", 86, "pice", "100", null);
        	
        	Artikal a_new26 = new Artikal("Konjak", 13, "Sa pulpom.", 32, "pice", "100", null);
        	Artikal a_new27 = new Artikal("Pivo Nektar sa limunom", 1, "Dobar za rashlaðivanje.", 51, "pice", "600", null);
        	Artikal a_new28 = new Artikal("Doncafe", 1, "Kafica.", 15, "pice", "100", null);
        	Artikal a_new29 = new Artikal("Kafa domaca", 0.5, "Domaæa.", 239, "pice", "100", null);
        	Artikal a_new30 = new Artikal("Pire krompir", 12, "Fin, nije loš.", 61, "jelo", "500", null);
        	
        	InstanceOPH.getInstance().addArtikal(a_new1);
        	InstanceOPH.getInstance().addArtikal(a_new2);
        	InstanceOPH.getInstance().addArtikal(a_new3);
        	InstanceOPH.getInstance().addArtikal(a_new4);
        	InstanceOPH.getInstance().addArtikal(a_new5);
        	
        	InstanceOPH.getInstance().addArtikal(a_new6);
        	InstanceOPH.getInstance().addArtikal(a_new7);
        	InstanceOPH.getInstance().addArtikal(a_new8);
        	InstanceOPH.getInstance().addArtikal(a_new9);
        	InstanceOPH.getInstance().addArtikal(a_new10);
        	
        	InstanceOPH.getInstance().addArtikal(a_new11);
        	InstanceOPH.getInstance().addArtikal(a_new12);
        	InstanceOPH.getInstance().addArtikal(a_new13);
        	InstanceOPH.getInstance().addArtikal(a_new14);
        	InstanceOPH.getInstance().addArtikal(a_new15);
        	
        	InstanceOPH.getInstance().addArtikal(a_new16);
        	InstanceOPH.getInstance().addArtikal(a_new17);
        	InstanceOPH.getInstance().addArtikal(a_new18);
        	InstanceOPH.getInstance().addArtikal(a_new19);
        	InstanceOPH.getInstance().addArtikal(a_new20);
        	
        	InstanceOPH.getInstance().addArtikal(a_new21);
        	InstanceOPH.getInstance().addArtikal(a_new22);
        	InstanceOPH.getInstance().addArtikal(a_new23);
        	InstanceOPH.getInstance().addArtikal(a_new24);
        	InstanceOPH.getInstance().addArtikal(a_new25);
        	
        	InstanceOPH.getInstance().addArtikal(a_new26);
        	InstanceOPH.getInstance().addArtikal(a_new27);
        	InstanceOPH.getInstance().addArtikal(a_new28);
        	InstanceOPH.getInstance().addArtikal(a_new29);
        	InstanceOPH.getInstance().addArtikal(a_new30);
        	
        	InstanceOPH.getInstance().saveToFile();
        }
        
        if(InstanceOPH.getInstance().getListaVozila().isEmpty())
        {
        	InstanceOPH.getInstance().setListaVozila(new ArrayList<Vozila>());
        	
        	Vozila vozilo1 = new Vozila("Opel", "Zafira", "Minivan", "08.07.2016", 2004, "Slobodno", "nothing");
        	Vozila vozilo2 = new Vozila("Volkswagen", "Golf", "Limuzina", "02.02.1990", 1989, "Slobodno", "nothing");
        	Vozila vozilo3 = new Vozila("Nissan", "X-trail", "Jeep", "19.06.2018", 2018, "Slobodno", "nothing");
        	
        	InstanceOPH.getInstance().addVozilo(vozilo1);
        	InstanceOPH.getInstance().addVozilo(vozilo2);
        	InstanceOPH.getInstance().addVozilo(vozilo3);
        	InstanceOPH.getInstance().saveToFile();
        }
        if(InstanceOPH.getInstance().getListaDostavljaca().isEmpty())
        {
        	InstanceOPH.getInstance().setListaDostavljaca(new ArrayList<Dostavljac>());
        	
        	Vozila ss = InstanceOPH.getInstance().getVozilo("Zafira");
        	
        	Dostavljac dostava1 = new Dostavljac();
        	dostava1.setName("Rajko");
        	dostava1.setLastname("Èonjiæ");
        	dostava1.setEmail("r.conjic@paps.com");
        	dostava1.setContact_phone("065 887 889");
        	dostava1.setRegistration_date("29.6.2018");
        	dostava1.setUser_name("raso");
        	dostava1.setUser_password("002");
        	dostava1.setUser_type("dostavljac");
        	dostava1.setDostavljac_vozilo(ss);
        	
        	Dostavljac dostava2 = new Dostavljac();
        	dostava2.setName("Dejan");
        	dostava2.setLastname("Èonjiæ");
        	dostava2.setEmail("d.conjic@paps.com");
        	dostava2.setContact_phone("065 888 889");
        	dostava2.setRegistration_date("29.6.2018");
        	dostava2.setUser_name("dejo");
        	dostava2.setUser_password("003");
        	dostava2.setUser_type("dostavljac");
        	
        	InstanceOPH.getInstance().addDostavljac(dostava1);
        	InstanceOPH.getInstance().addDostavljac(dostava2);
        	InstanceOPH.getInstance().saveToFile();
        }
        if(InstanceOPH.getInstance().getListaRestorana().isEmpty())
        {
        	InstanceOPH.getInstance().setListaRestorana(new ArrayList<Restoran>());
        	
        	ArrayList<Artikal> lista = (ArrayList<Artikal>) InstanceOPH.getInstance().getListaArtikala();
        	ArrayList<Artikal> pica = new ArrayList<Artikal>();
        	ArrayList<Artikal> jela = new ArrayList<Artikal>();
        	for(Artikal a:lista)
        	{
        		if(a.getArtikal_tip().equals("jelo"))
        		{
        			jela.add(a);
        		} else if(a.getArtikal_tip().equals("pice"))
        		{
        			pica.add(a);
        		}
        	}

        	Restoran restoran1 = new Restoran("Jugoslavija", "Svetosavska 11", "Rostilj", null, null);
        	Restoran restoran2 = new Restoran("Volan", "Ilije Bircanina bb", "Indijski restoran", null, null);
        	Restoran restoran3 = new Restoran("Panorama", "Milosa Obilica 32", "Domaca kuhinja", null, null);
        	Restoran restoran4 = new Restoran("Chin chin", "Vuka Karadzica 54", "Kineski restoran", null, null);
        	Restoran restoran5 = new Restoran("Autobuska", "Ilije Bircanina 21", "Picerija", null, null);
        	Restoran restoran6 = new Restoran("Orion", "Carice Milice bb", "Poslasticarnica", null, null);
        	Restoran restoran7 = new Restoran("Zvijezda", "Stepe Stepanovica bb", "Poslasticarnica", null, null);
        	
        	InstanceOPH.getInstance().addRestoran(restoran1);
        	InstanceOPH.getInstance().addRestoran(restoran2);
        	InstanceOPH.getInstance().addRestoran(restoran3);
        	InstanceOPH.getInstance().addRestoran(restoran4);
        	InstanceOPH.getInstance().addRestoran(restoran5);
        	InstanceOPH.getInstance().addRestoran(restoran6);
        	InstanceOPH.getInstance().addRestoran(restoran7);
        	InstanceOPH.getInstance().saveToFile();
        }
        if(InstanceOPH.getInstance().getListaPorudzbina() == null)
        {
        	InstanceOPH.getInstance().setListaPorudzbina(new ArrayList<Porudzbina>());
        }
        if(InstanceOPH.getInstance().getListaOmiljenihRestorana() == null)
        {
        	InstanceOPH.getInstance().setListaOmiljenihRestorana(new ArrayList<Restoran>());
        }
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
			List<Artikal> artikli = InstanceOPH.getInstance().getListaArtikala();
			List<Korisnik> korisnici = InstanceOPH.getInstance().getListaKorisnika();
			List<Administrator> admini = InstanceOPH.getInstance().getListaAdmina();
			List<Dostavljac> dostavljaci = InstanceOPH.getInstance().getListaDostavljaca();
			List<Vozila> vozila = InstanceOPH.getInstance().getListaVozila();
			List<Restoran> restorani = InstanceOPH.getInstance().getListaRestorana();
			List<Porudzbina> sve_porudzbine = InstanceOPH.getInstance().getListaPorudzbina();
			HashMap<Artikal, Integer> top_10 = InstanceOPH.getInstance().getListaTop10();
			List<Porudzbina> dostavljene =  (List<Porudzbina>) ctx.getAttribute("dostavljene");
			List<Restoran> svi_omiljeni = InstanceOPH.getInstance().getListaOmiljenihRestorana();
		
			ctx.setAttribute("artikli", artikli);
			ctx.setAttribute("korisnici", korisnici);
			ctx.setAttribute("vozila", vozila);
			ctx.setAttribute("dostavljaci", dostavljaci);
			ctx.setAttribute("admini", admini);
			ctx.setAttribute("restorani", restorani);
			ctx.setAttribute("sve_porudzbine", sve_porudzbine);
			ctx.setAttribute("top_10", top_10);
			ctx.setAttribute("svi_omiljeni", svi_omiljeni);
			
			artikli = (List<Artikal>) ctx.getAttribute("artikli");
			korisnici = (List<Korisnik>) ctx.getAttribute("korisnici");
			vozila = (List<Vozila>) ctx.getAttribute("vozila");
			admini = (List<Administrator>) ctx.getAttribute("admini");
			dostavljaci = (List<Dostavljac>) ctx.getAttribute("dostavljaci");
			restorani = (List<Restoran>) ctx.getAttribute("restorani");
			sve_porudzbine = (List<Porudzbina>) ctx.getAttribute("sve_porudzbine");
			top_10 = (HashMap<Artikal, Integer>) ctx.getAttribute("top_10");
			svi_omiljeni = (List<Restoran>) ctx.getAttribute("svi_omiljeni");	
			
			if(artikli == null)
			{
				artikli = new ArrayList<Artikal>();
			}
			if(korisnici == null)
			{
				korisnici = new ArrayList<Korisnik>();
			}
			if(vozila == null)
			{
				vozila = new ArrayList<Vozila>();
			}
			if(admini == null)
			{
				admini = new ArrayList<Administrator>();
			}
			if(dostavljaci == null)
			{
				dostavljaci = new ArrayList<Dostavljac>();
			}
			if(restorani == null)
			{
				restorani = new ArrayList<Restoran>();
			}
			if(sve_porudzbine == null)
			{
				sve_porudzbine = new ArrayList<Porudzbina>();
			}
			if(top_10 == null)
			{
				top_10 = new HashMap<Artikal, Integer>();
			}
			if(dostavljene == null)
			{
				dostavljene = new ArrayList<Porudzbina>();
			}
			if(svi_omiljeni == null)
			{
				svi_omiljeni = new ArrayList<Restoran>();
			}
			
			top_10 = InstanceOPH.getInstance().sortByComparator(top_10, true);
			ctx.setAttribute("top_10", top_10);
			
			List<Korisnik> listurinaK = InstanceOPH.getInstance().getListaKorisnika();
			List<Restoran> omiljeni_restorani = new ArrayList<Restoran>();
			
			for(Korisnik k:listurinaK)
			{
				omiljeni_restorani = InstanceOPH.getInstance().getKorisnik(k.getUser_name()).getOmiljeni_restorani();
				if(omiljeni_restorani != null)
				{
					k.setOmiljeni_restorani(omiljeni_restorani);
					ctx.setAttribute("omiljeni_restorani", omiljeni_restorani);
					break;
				} else
				{
					omiljeni_restorani = new ArrayList<Restoran>();
				}
			}
			ctx.setAttribute("omiljeni_restorani", omiljeni_restorani);
			
			List<Dostavljac> listaD = InstanceOPH.getInstance().getListaDostavljaca();
        	List<Porudzbina> neka = new ArrayList<Porudzbina>();
        	for(Dostavljac d:listaD)
        	{
        		neka = InstanceOPH.getInstance().getDostava(d.getUser_name()).getDostavljac_porudzbine();
        		if(neka != null)
            	{
            		d.setDostavljac_porudzbine(neka);
            		ctx.setAttribute("lista_dostava", neka);
            	} else
            	{
            		neka = new ArrayList<Porudzbina>();
            	}
        	}
        	ctx.setAttribute("lista_dostava", null);
        	
			List<Korisnik> listaK = InstanceOPH.getInstance().getListaKorisnika();
        	List<Porudzbina> pp = new ArrayList<Porudzbina>();
        	for(Korisnik k:listaK)
        	{
        		pp = InstanceOPH.getInstance().getKorisnik(k.getUser_name()).getPorudzbine();
        		if(pp != null)
            	{
            		k.setPorudzbine(pp);
            		ctx.setAttribute("porudzbine", pp);
            	} else
            	{
            		pp = new ArrayList<Porudzbina>();
            	}
        	}
        	ctx.setAttribute("porudzbine", null);
		response.sendRedirect("index.jsp");
	}

}
