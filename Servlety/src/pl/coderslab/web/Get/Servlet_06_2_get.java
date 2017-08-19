package pl.coderslab.web.Get;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Servlet_06_2_get")
public class Servlet_06_2_get extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int y =   Integer.parseInt(request.getParameter("year"));
		
		Random r = new Random();

		for (int i = 0; i < 5; i++) {
			int m = r.nextInt(21)-10;
			String link = "<a href='./Servlet_06_3_get?year="+y+"&mix="+m+"'> Rok "+y+", mix "+m+" </a><br>";
			response.getWriter().append(link);
		}
	}

}
