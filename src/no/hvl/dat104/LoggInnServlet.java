package no.hvl.dat104;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import david.copy.UserEOA;

/**
 * Servlet implementation class LoggInnServlet
 */
@WebServlet("/LoggInnServlet")
public class LoggInnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	UserEOA eao;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		String redirectErrorMessage = "";
		if(request.getParameter("feilPassord") != null)
		{
			redirectErrorMessage ="Feil passord";
		}
		request.setAttribute("redirectErrorMessage", redirectErrorMessage);
		
		request.getRequestDispatcher("WEB-INF/mobillogin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		
			int nummer = Integer.parseInt(request.getParameter("mobil"));
			String nr = request.getParameter("mobil");
			
			if((eao.finnUser(nummer) == null ) || (nr == null)) {

				response.sendRedirect("LoggInnServlet?feilPassord");
			} else {
				HttpSession session = request.getSession(false);
				if (session != null) {
					session.invalidate();
				}
				session = request.getSession(true);
				request.getSession().setAttribute("user", eao.finnUser(nummer));
				response.sendRedirect("DeltagerListeServlet");
				
			}
	}

	}

