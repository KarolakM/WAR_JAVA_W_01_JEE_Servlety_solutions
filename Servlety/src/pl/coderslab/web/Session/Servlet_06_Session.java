package pl.coderslab.web.Session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/favImages")
public class Servlet_06_Session extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sess = request.getSession();
		response.setContentType("text/html;charset=UTF-8");

		if (sess.isNew()) {
			sess.setAttribute("pagesVisited", 1);
			response.sendRedirect("wybor_1_Session.html");
		} else if ((int) sess.getAttribute("pagesVisited") == 4) {
			response.getWriter().append("Te obrazy Ci siê podoba³y: <br>");
			for (int i = 1; i < 5; i++) {
				if (sess.getAttribute("choice_" + i).equals("TAK")) {
					response.getWriter().append("Strona " + i+"<br>");
				}
			}

		} else {
			int count = (int) sess.getAttribute("pagesVisited");
			count++;
			sess.setAttribute("pagesVisited", count);
			response.sendRedirect("wybor_" + sess.getAttribute("pagesVisited") + "_Session.html");
		}
	}
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		String like = request.getParameter("like");
		String attribute = "choice_"+sess.getAttribute("pagesVisited");
		sess.setAttribute(attribute, like);
		doGet(request, response);
	}

}
