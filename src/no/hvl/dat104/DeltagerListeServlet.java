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
 * @author David Korsrud Bråten
 *
 */

@WebServlet("/DeltagerListeServlet")
public class DeltagerListeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	UserEOA ueoa;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
			if(session == null) {
				request.setAttribute("items", ueoa.finnAlleUser());				
				request.getRequestDispatcher("WEB-INF/deltagerliste.jsp").forward(request, response);
			} else {
				response.sendRedirect("FerdigServlet");
		}
	}

}
