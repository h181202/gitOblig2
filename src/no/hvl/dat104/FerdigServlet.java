package no.hvl.dat104;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FerdigServlet
 */
@WebServlet("/FerdigServlet")
public class FerdigServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesjon = request.getSession(false);
		if(sesjon != null) {
			sesjon.invalidate();
		}
		request.getRequestDispatcher("WEB-INF/ferdig.jsp").forward(request, response);
	}

}
