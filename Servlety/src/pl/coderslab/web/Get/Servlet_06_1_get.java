package pl.coderslab.web.Get;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Servlet_06_1_get")
public class Servlet_06_1_get extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Random r = new Random();
		
		for (int i = 0; i < 5; i++) {
			int y = 1980 +r.nextInt(31);
			String link = "<a href='./Servlet_06_2_get?year="+y+"'> Link do roku "+y+" </a><br>";
			response.getWriter().append(link);
		}
		
		
		
	}

}
