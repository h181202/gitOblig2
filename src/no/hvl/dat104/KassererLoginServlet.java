package no.hvl.dat104;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class KassererLoginServlet
 */
@WebServlet("/KassererLoginServlet")
public class KassererLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String passord;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		passord = getServletContext().getInitParameter("kassererpass");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String redirectErrorMessage = "";
		if(request.getParameter("feilPassord") != null)
		{
			redirectErrorMessage = "Passordet er ugyldig ";
		}
		request.setAttribute("redirectErrorMessage", redirectErrorMessage);
		
		request.getRequestDispatcher("WEB-INF/kassererlogin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String input = request.getParameter("password");
		if(!(passord.equals(input)))
		{
			response.sendRedirect("KassererLoginServlet?feilPassord");
		}
		else
		{
			HttpSession session = request.getSession(false);
			if (session != null) {
				session.invalidate();
			}
			session = request.getSession(true);
			response.sendRedirect("BetalingsoversiktServlet");
		}
		
	}

}