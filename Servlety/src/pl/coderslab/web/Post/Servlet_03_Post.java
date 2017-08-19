package pl.coderslab.web.Post;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Servlet_03_Post")
public class Servlet_03_Post extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int a =  Integer.parseInt(request.getParameter("a"));
		int b =  Integer.parseInt(request.getParameter("b"));
		int c =  Integer.parseInt(request.getParameter("c"));
		
		
		
		double delta = Math.pow(b, 2) - (4 * a * c);

		if (delta == 0) {
			double x = -b / (2 * a);
			response.getWriter().append("Jest jeden podwójny pierwiastek: " + x);
		} else if (delta > 0) {
			double x1 = (-b - Math.sqrt(delta)) / (2 * a);
			double x2 = (-b + Math.sqrt(delta)) / (2 * a);

			response.getWriter().append("Dwa pierwiastki: " + x1 + ", " + x2);
		} else {
			response.getWriter().append("brak pierwiastkow");
		}

	}

}
