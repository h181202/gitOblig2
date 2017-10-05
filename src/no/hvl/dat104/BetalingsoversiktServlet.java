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
		
		//List<User> listen = userEAO.finnAlleUser();
		User u = userEAO.finnUser(81549300);
		//request.setAttribute("listen", listen);
		System.out.println(u.getEnavn());
		request.getRequestDispatcher("BetalingsoversiktServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer mobilnr = null;
		if((request.getParameter("mobil") != null))
		{
			mobilnr = Integer.parseInt(request.getParameter("mobil"));
			userEAO.finnUser(mobilnr).setBetalt(true);
		}
		
		
		//doGet(request, response);
	}

}
