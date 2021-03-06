package no.hvl.dat104;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PaamBekreftServlet
 */
@WebServlet("/PaamBekreftServlet")
public class PaamBekreftServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	   
		protected void doGet(HttpServletRequest request, HttpServletResponse response) 
						throws ServletException, IOException {
			
			HttpSession session = request.getSession(false);
				if(session == null) {
					response.sendRedirect("LoggInnServlet");
				} else {
					
				request.getAttribute("user");
				request.getRequestDispatcher("WEB-INF/paameldingsbekreftelse.jsp").forward(request, response);
		}
		}

}
