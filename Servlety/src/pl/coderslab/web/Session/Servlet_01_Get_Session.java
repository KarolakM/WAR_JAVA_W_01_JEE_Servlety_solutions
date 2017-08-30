package pl.coderslab.web.Session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Servlet_01_Get_Session")
public class Servlet_01_Get_Session extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sess = request.getSession();

		if (sess.getAttribute("counter") == null) {
			response.getWriter().append("Brak atrybutu");
		} else {
			int counter = (int) sess.getAttribute("counter");

			sess.setAttribute("counter", 1 + counter);
			response.getWriter().append(counter + "");
		}
	}

}
