package Controller;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.InstanceOPH;
import Model.Korisnik;


/**
 * Servlet implementation class ServletLogin
 */

public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String logoff = request.getParameter("logoff");
		
		String uloga_korisnika = "";
		
		Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");
		
		if(korisnik == null)
		{
			try
			{
				Korisnik novi = InstanceOPH.getInstance().getKorisnik(username);
				uloga_korisnika = novi.getUser_type();
			}catch (NullPointerException e) {
				response.getWriter().write("Korisnik nije registrovan");
			}
				if(((korisnik = InstanceOPH.getInstance().getKorisnik(username)) != null) && uloga_korisnika.equals("kupac"))
				{
					if(korisnik.getUser_password().equals(password))
					{
						session.setAttribute("korisnik", korisnik);
						response.sendRedirect("index.jsp");
						ctx.setAttribute("svi_omiljeni", new ArrayList());
					} else
						response.sendRedirect("user_login.jsp");
				} 
				return;
		} else
		{
			if(logoff.equals("OUT"))
			{
				session.removeAttribute("korisnik");
				session.invalidate(); // brise sesiju iz registry i brise sve session atribute vezane za sesiju
				response.sendRedirect("index.jsp");
			} else
			{
				response.sendRedirect("user_login.jsp");
			}
		}

		}//IF sav

	}

