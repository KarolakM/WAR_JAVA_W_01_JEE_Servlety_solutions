package pl.coderslab.web.Get;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Servlet_01_get")
public class Servlet_01_get extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		try {
			int start = Integer.parseInt(request.getParameter("start"));
			int end = Integer.parseInt(request.getParameter("end"));
			for (int i = start; i < end; i++) {
				response.getWriter().append(i+"<br>");
			}
		} catch (NumberFormatException e) {
			response.getWriter().append("<h1> Brak przes³anych zmiennych</h1>");
		}
		
		
		
	}

}
