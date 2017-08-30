package pl.coderslab.web.Session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Servlet_08_Session")
public class Servlet_08_Session extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String[][] country = new String[][] { { "Niemcy", "Berlin" }, { "Czechy", "Praga" }, { "S³owacja", "Bratys³awa" },
			{ "Bia³oruœ", "Miñsk" }, { "Litwa", "Wilno" }, { "Ukraina", "Kijów" } };
		
		

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		response.setContentType("text/html;charset=UTF-8");
		
		if (sess.isNew()) {
			sess.setAttribute("pagesVisited", 1);
			sess.setAttribute("correct", 0);
			response.getWriter()
			.append("<form  method=\"POST\">\r\n" + "    <label>\r\n"
					+ country[(int) sess.getAttribute("pagesVisited")-1][0]
					+ "        <input type=\"text\" name=\"capital\">\r\n<br>" + "    </label>\r\n"
					+ "    <input type=\"submit\">\r\n" + "\r\n" + "</form>");

		} else if ((int) sess.getAttribute("pagesVisited") == country.length ) {
			response.getWriter().append("Poprawnych odpowiedzi: "+ sess.getAttribute("correct"));

		} else {
			int count = (int) sess.getAttribute("pagesVisited");
			count++;
			sess.setAttribute("pagesVisited", count);
			response.getWriter()
					.append("<form  method=\"POST\">\r\n" + "    <label>\r\n"
							+ country[(int) sess.getAttribute("pagesVisited")-1][0]
							+ "        <input type=\"text\" name=\"capital\">\r\n<br>" + "    </label>\r\n"
							+ "    <input type=\"submit\">\r\n" + "\r\n" + "</form>");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		String capital = request.getParameter("capital");
		int count = (int) sess.getAttribute("pagesVisited");
		int correct =  (int) sess.getAttribute("correct");
		
				if(capital.equals(country[count-1][1])) {
					correct++;
				}
				
		sess.setAttribute("correct", correct);
		doGet(request, response);
	}

}
