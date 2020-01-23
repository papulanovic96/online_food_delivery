package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Dostavljac;
import Model.InstanceOPH;
import Model.Korisnik;

/**
 * Servlet implementation class DostavaLogin
 */

public class DostavaLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DostavaLogin() {
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String logoff = request.getParameter("logoff");
		
		String uloga = "";
		
		Dostavljac dostavljac = (Dostavljac) session.getAttribute("dostavljac");
		
		if(dostavljac == null)
		{
			try
			{
				Dostavljac novi = InstanceOPH.getInstance().getDostava(username);
				uloga = novi.getUser_type();
			}catch (NullPointerException e) {
				response.getWriter().write("Dostavljac nije registrovan");
			}
				if(((dostavljac = InstanceOPH.getInstance().getDostava(username)) != null) && uloga.equals("dostavljac"))
				{
					if(dostavljac.getUser_password().equals(password))
					{
						session.setAttribute("dostavljac", dostavljac);
						response.sendRedirect("index_dostava.jsp");
					} else
						response.sendRedirect("dostava_login.jsp");
				} 
				return;
		} else
		{
			if(logoff.equals("OUT"))
			{
				session.removeAttribute("dostavljac");
				session.invalidate(); // brise sesiju iz registry i brise sve session atribute vezane za sesiju
				response.sendRedirect("index.jsp");
			} else
			{
				response.sendRedirect("dostava_login.jsp");
			}
		}

	}

}
