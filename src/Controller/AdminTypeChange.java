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
import Model.Dostavljac;
import Model.InstanceOPH;
import Model.Korisnik;
import Model.Restoran;

/**
 * Servlet implementation class AdminTypeChange
 */

public class AdminTypeChange extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminTypeChange() {
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
		String izmjeni = request.getParameter("izmjeni_tip");
		String izmjeni_tip_dostave = request.getParameter("izmjeni_tip_dostave");
		String izmjeni_tip_admin = request.getParameter("izmjeni_tip_admin");
		
		if(izmjeni != null)
		{
			if(admin != null)
			{
				List<Korisnik> korisnici = InstanceOPH.getInstance().getListaKorisnika();
				ctx.setAttribute("korisnici", korisnici);
				korisnici = (List<Korisnik>) ctx.getAttribute("korisnici");
				
				Korisnik korisnik = new Korisnik();
				
				for(Korisnik k:korisnici)
				{
					if(k.getUser_name().equals(izmjeni))
					{
						korisnik = InstanceOPH.getInstance().getKorisnik(k.getUser_name());
						korisnici.remove(k);
						InstanceOPH.getInstance().deleteKorisnik(k);
						InstanceOPH.getInstance().saveToFile();
						break;
					}
				}
				
				ctx.setAttribute("korisnici", korisnici);
				
				String tipic = korisnik.getUser_type();
				String ime = korisnik.getName();
				String pre = korisnik.getLastname();
				String kim = korisnik.getUser_name();
				String pas = korisnik.getUser_password();
				String tel = korisnik.getContact_phone();
				String ema = korisnik.getEmail();
				String dat = korisnik.getRegistration_date();
				
				if(tipic != null)
				{	
					request.setAttribute("tipic", tipic);
					request.setAttribute("ime", ime);
					request.setAttribute("pre", pre);
					request.setAttribute("kim", kim);
					request.setAttribute("pas", pas);
					request.setAttribute("tel", tel);
					request.setAttribute("ema", ema);
					request.setAttribute("dat", dat);
					
					RequestDispatcher disp = request.getRequestDispatcher("type_change.jsp");
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
		
		
		if(izmjeni_tip_dostave != null)
		{
			if(admin != null)
			{
				List<Dostavljac> dostavljaci = InstanceOPH.getInstance().getListaDostavljaca();
				ctx.setAttribute("dostavljaci", dostavljaci);
				dostavljaci = (List<Dostavljac>) ctx.getAttribute("dostavljaci");
				
				Dostavljac dostavljac = new Dostavljac();
				
				for(Dostavljac d:dostavljaci)
				{
					if(d.getUser_name().equals(izmjeni_tip_dostave))
					{
						dostavljac = InstanceOPH.getInstance().getDostava(d.getUser_name());
						dostavljaci.remove(d);
						InstanceOPH.getInstance().deleteDostavljac(d);
						InstanceOPH.getInstance().saveToFile();
						break;
					}
				}
				
				ctx.setAttribute("dostavljaci", dostavljaci);
				String tipic = dostavljac.getUser_type();
				String ime = dostavljac.getName();
				String pre = dostavljac.getLastname();
				String kim = dostavljac.getUser_name();
				String pas = dostavljac.getUser_password();
				String tel = dostavljac.getContact_phone();
				String ema = dostavljac.getEmail();
				String dat = dostavljac.getRegistration_date();
				
				if(tipic != null)
				{	
					request.setAttribute("tipic", tipic);
					request.setAttribute("ime", ime);
					request.setAttribute("pre", pre);
					request.setAttribute("kim", kim);
					request.setAttribute("pas", pas);
					request.setAttribute("tel", tel);
					request.setAttribute("ema", ema);
					request.setAttribute("dat", dat);
					
					RequestDispatcher disp = request.getRequestDispatcher("type_change.jsp");
					disp.forward(request, response);
				}
				
				
				
			} else
			{
				response.sendRedirect("index_admin.jsp");
			}
		} else
		{

			System.out.println("Nema izmjene dostave!");
			
		}
		
		
		if(izmjeni_tip_admin != null)
		{
			if(admin != null)
			{
				List<Administrator> admini = InstanceOPH.getInstance().getListaAdmina();
				ctx.setAttribute("admini", admini);
				admini = (List<Administrator>) ctx.getAttribute("admini");
				
				Administrator adminX = new Administrator();
				
				for(Administrator a:admini)
				{
					if(a.getUser_name().equals(izmjeni_tip_admin))
					{
						adminX = InstanceOPH.getInstance().getAdmin(a.getUser_name());
						admini.remove(a);
						InstanceOPH.getInstance().deleteAdmin(a);
						InstanceOPH.getInstance().saveToFile();
						break;
					}
				}
				
				ctx.setAttribute("admini", admini);
				String tipic = adminX.getUser_type();
				String ime = adminX.getName();
				String pre = adminX.getLastname();
				String kim = adminX.getUser_name();
				String pas = adminX.getUser_password();
				String tel = adminX.getContact_phone();
				String ema = adminX.getEmail();
				String dat = adminX.getRegistration_date();
				
				if(tipic != null)
				{	
					request.setAttribute("tipic", tipic);
					request.setAttribute("ime", ime);
					request.setAttribute("pre", pre);
					request.setAttribute("kim", kim);
					request.setAttribute("pas", pas);
					request.setAttribute("tel", tel);
					request.setAttribute("ema", ema);
					request.setAttribute("dat", dat);
					
					RequestDispatcher disp = request.getRequestDispatcher("type_change.jsp");
					disp.forward(request, response);
				}
			} else
			{
				response.sendRedirect("index_admin.jsp");
			}
		} else
		{

			System.out.println("Nema izmjene dostave!");
			
		}
	}

}
