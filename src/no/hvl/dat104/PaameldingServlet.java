package no.hvl.dat104;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PaameldingServlet
 */
@WebServlet("/PaameldingServlet")
public class PaameldingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	UserEOA eao; 
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/paameldingsskjema.jsp").forward(request, response);

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		PaameldingHjelp paamelding = new PaameldingHjelp(request);
		if(paamelding.alleGyldige()) {
			
			HttpSession session = request.getSession(true);
			
			User user = new User();
			user.setMobil(Integer.parseInt(paamelding.getMobilnr()));
			user.setEnavn(paamelding.getFornavn());
			user.setEnavn(paamelding.getEtternavn());
			
			String kjonn = request.getParameter("kjonn");
			if(kjonn.equals("mann")) {
				user.setSex(true);
			} else {
				user.setSex(false);
			}
			eao.leggTilUser(user);
			request.getSession().setAttribute("user", user);
			
			request.getSession().removeAttribute("paamelding");
			response.sendRedirect("PaamBekreftServlet");
		} else {
			paamelding.feilMelding();
			request.getSession().setAttribute("paamelding", paamelding);
			response.sendRedirect("PaameldingServlet");
		}
	}
}
