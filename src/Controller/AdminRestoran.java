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

/**
 * Servlet implementation class AdminRestoran
 */

public class AdminRestoran extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminRestoran() {
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
		System.out.println("Usao u servlet AdminRestoran.");
		String artikal_pice = request.getParameter("artikal_pice");
		//restorani
		
		String naziv = request.getParameter("naziv_restorana");
		String adresa = request.getParameter("adresa_restorana");
		String kategorija = request.getParameter("kategorija_restorana");
		
		List<Artikal> lista_jela = new ArrayList<Artikal>();
		List<Artikal> lista_pica = new ArrayList<Artikal>();
		Artikal novi = new Artikal();

		
		if(admin != null)
		{
			boolean provjera = false;
				if(artikal_pice != null)
				{
					
					for(Artikal art:InstanceOPH.getInstance().getListaArtikala())
					{
						if(art.getNaziv_artikla().equals(artikal_pice))
						{
							novi = InstanceOPH.getInstance().getArtikal(art.getNaziv_artikla());
							if(novi.getArtikal_tip().equals("pice"))
							{
								lista_pica = (List<Artikal>) ctx.getAttribute("lista_pica");
								if(lista_pica == null)
								{
									lista_pica = new ArrayList<Artikal>();
									lista_pica.add(novi);
									ctx.setAttribute("lista_pica", lista_pica);
								} else
								{
									for(Artikal oo:new ArrayList<>(lista_pica))
									{
										if(oo.getNaziv_artikla().equals(novi.getNaziv_artikla()))
										{
											System.out.println("Isto ime pica...");
										} else
										{
											lista_pica.add(novi);
											ctx.setAttribute("lista_pica", lista_pica);
											break;
										}
									}
								}
								
								response.sendRedirect("dodavanje.jsp");
								break;
							} else if(novi.getArtikal_tip().equals("jelo"))
							{
								lista_jela = (List<Artikal>) ctx.getAttribute("lista_jela");
								if(lista_jela == null)
								{
									lista_jela = new ArrayList<Artikal>();
									lista_jela.add(novi);
									ctx.setAttribute("lista_jela", lista_jela);
								} else
								{
									for(Artikal oo:new ArrayList<>(lista_jela))
									{
										if(oo.getNaziv_artikla().equals(novi.getNaziv_artikla()))
										{
											System.out.println("Isto ime jelo...");
										} else
										{
											lista_jela.add(novi);
											ctx.setAttribute("lista_jela", lista_jela);
											break;
										}
									}
								}
								response.sendRedirect("dodavanje.jsp");
								break;
							}
						}
					}
				}else if (artikal_pice == null)
				{
					Restoran restoran = new Restoran();
					restoran.setRestoran_naziv(naziv);
					restoran.setRestoran_adresa(adresa);
					restoran.setRestoran_kategorija(kategorija);
					lista_jela = (List<Artikal>) ctx.getAttribute("lista_jela");
					lista_pica = (List<Artikal>) ctx.getAttribute("lista_pica");
					restoran.setLista_pica(lista_pica);
					restoran.setLista_jela(lista_jela);
					
					for(Restoran r: InstanceOPH.getInstance().getListaRestorana())
					{
						if(r.getRestoran_naziv().equals(naziv))
						{
							System.out.println("postoji restoran " + r.getRestoran_naziv() );
							provjera = true;
							break;
						}
					}
					if(provjera)
					{
						System.out.println("Pokusaj opet!");
						response.sendRedirect("dodavanje.jsp");
					}else
					{
						InstanceOPH.getInstance().addRestoran(restoran);
						ctx.setAttribute("restoran", restoran);
						System.out.println("restoran: "+ restoran.getRestoran_naziv());
						InstanceOPH.getInstance().saveToFile();
						ctx.setAttribute("lista_pica", null);
						ctx.setAttribute("lista_jela", null);
						provjera = false;
						response.sendRedirect("restorani.jsp");
					}
				} 
	}
	}
}
