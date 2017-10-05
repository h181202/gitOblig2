package no.hvl.dat104;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BetalingsoversiktServlet
 */
@WebServlet("/BetalingsoversiktServlet")
public class BetalingsoversiktServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private UserEOA userEAO;
	
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("kasserer") == null) {
			response.sendRedirect("KassererLoginServlet");
		} else {
			
			List<User> listen = userEAO.finnAlleUser();
		
			request.setAttribute("listen", listen);
		
			request.getRequestDispatcher("WEB-INF/betalingsoversikt.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String input = request.getParameter("mobil");
		if(input != null)
		{
			Integer nr = Integer.parseInt(input);
			userEAO.betaling(userEAO.finnUser(nr));
		}
		
		response.sendRedirect("BetalingsoversiktServlet");
		//lala
	}

}

