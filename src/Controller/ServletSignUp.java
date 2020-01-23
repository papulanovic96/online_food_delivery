package Controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Model.Administrator;
import Model.Dostavljac;
import Model.InstanceOPH;
import Model.Korisnik;
import Model.Porudzbina;

/**
 * Servlet implementation class ServletSignUp
 */

public class ServletSignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		String username = request.getParameter("user_name");
		String password = request.getParameter("user_password");
		String ime = request.getParameter("ime_korisnika");
		String prezime = request.getParameter("prezime_korisnika");
		String uloga = request.getParameter("uloga_korisnika");
		String telefon = request.getParameter("telefon_korisnika");
		String email = request.getParameter("email_korisnika");
		String datum = request.getParameter("dat_reg_korisnika");
		boolean provjera = false;
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	    java.util.Date today = Calendar.getInstance().getTime();        
	    String timeAndDate = df.format(today);
		
		if(uloga.equals("kupac"))
		{
			Korisnik korisnik_novi = new Korisnik(username, password, ime, prezime, uloga, telefon, email, timeAndDate, null, null,0);

			for(Korisnik k:InstanceOPH.getInstance().getListaKorisnika())
			{
				if(k.getUser_name().equals(username))
				{
					System.out.println("Vec postoji ovaj korisnik!");
					provjera = true;
					break;
				}
			}
			if(provjera)
			{
				System.out.println("Pokusajte novi username!");
				response.sendRedirect("user_registration.jsp");
			} else
			{
				InstanceOPH.getInstance().addKorisnik(korisnik_novi);
				ServletContext ctx = getServletContext();
				ctx.removeAttribute("instance");
				ctx.setAttribute("instance", InstanceOPH.getInstance());
				System.out.println("Username: "+korisnik_novi.getUser_name()+"\nTip: "+korisnik_novi.getUser_type() +"\nPassword: " + korisnik_novi.getUser_password());
				InstanceOPH.getInstance().saveToFile();
				provjera = false;
				response.sendRedirect("user_login.jsp");
			}
		}
		
		
		if(uloga.equals("admin"))
		{
			Administrator korisnik_novi = new Administrator(username, password, ime, prezime, uloga, telefon, email, datum);
			korisnik_novi.setUser_name(username);
			for(Administrator k:InstanceOPH.getInstance().getListaAdmina())
			{
				if(k.getUser_name().equals(username))
				{
					System.out.println("Vec postoji ovaj korisnik!");
					provjera = true;
					break;
				}
			}
			if(provjera)
			{
				System.out.println("Pokusajte novi username!");
				response.sendRedirect("user_registration.jsp");
			} else
			{
				InstanceOPH.getInstance().addAdmin(korisnik_novi);
				ServletContext ctx = getServletContext();
				ctx.removeAttribute("instance");
				ctx.setAttribute("instance", InstanceOPH.getInstance());
				System.out.println("Username: "+korisnik_novi.getUser_name()+"\nTip: "+korisnik_novi.getUser_type() +"\nPassword: " + korisnik_novi.getUser_password());
				InstanceOPH.getInstance().saveToFile();
				provjera = false;
				response.sendRedirect("lista_admina.jsp");
			}
		}
		
		if(uloga.equals("dostavljac"))
		{
			Dostavljac korisnik_novi = new Dostavljac(username, password, ime, prezime, uloga, telefon, email, datum);

			for(Dostavljac k:InstanceOPH.getInstance().getListaDostavljaca())
			{
				if(k.getUser_name().equals(username))
				{
					System.out.println("Vec postoji ovaj korisnik!");
					provjera = true;
					break;
				}
			}
			if(provjera)
			{
				System.out.println("Pokusajte novi username!");
				response.sendRedirect("user_registration.jsp");
			} else
			{
				korisnik_novi.setDostavljac_porudzbine(new ArrayList<Porudzbina>());
				korisnik_novi.setDostavljac_vozilo(null);
				korisnik_novi.setUser_name(username);
				InstanceOPH.getInstance().addDostavljac(korisnik_novi);
				ServletContext ctx = getServletContext();
				ctx.removeAttribute("instance");
				ctx.setAttribute("instance", InstanceOPH.getInstance());
				System.out.println("Username: "+korisnik_novi.getUser_name()+"\nTip: "+korisnik_novi.getUser_type() +"\nPassword: " + korisnik_novi.getUser_password());
				InstanceOPH.getInstance().saveToFile();
				provjera = false;
				response.sendRedirect("dostavljaci_reg.jsp");
			}
		}
		
		
	}

}
