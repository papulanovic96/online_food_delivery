package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Administrator;
import Model.InstanceOPH;
import Model.Korisnik;

/**
 * Servlet implementation class AdminLogin
 */

public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
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
		
		String uloga_admina = "";
		
		Administrator admin = (Administrator) session.getAttribute("admin");
		
		if(admin == null)
		{
			try
			{
				Administrator novi = InstanceOPH.getInstance().getAdmin(username);
				uloga_admina = novi.getUser_type();
				System.out.println(novi.getUser_name() + novi.getUser_password());
			}catch (NullPointerException e) {
				response.getWriter().write("Ne postoji admin");
				return;
			}
				if(((admin = InstanceOPH.getInstance().getAdmin(username)) != null) && uloga_admina.equals("admin"))
				{
					if(admin.getUser_password().equals(password))
					{
						session.setAttribute("admin", admin);
						response.sendRedirect("index_admin.jsp");
					} else
						response.sendRedirect("admin_login.jsp");
				} 
				return;
		} else
		{
			if(logoff.equals("OUT"))
			{
				session.removeAttribute("admin");
				session.invalidate(); // brise sesiju iz registry i brise sve session atribute vezane za sesiju
				
				response.sendRedirect("index.jsp");
			} else
			{
				response.sendRedirect("admin_login.jsp");
			}
		}

		

	}

}
