package pl.coderslab.web.Get;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Servlet_03_get")
public class Servlet_03_get extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html;charset=UTF-8");
		
		try {
			int width= 5;
			int height= 10;
			
			if (request.getParameterMap().containsKey("width")) {
				 width = Integer.parseInt(request.getParameter("width"));
	        }
			
			if (request.getParameterMap().containsKey("height")) {
				 height = Integer.parseInt(request.getParameter("height"));
	        }
			
			int[][] multi= new int[width][height];
			
			for (int i = 0; i <multi.length; i++) {
				for (int j = 0; j < multi[i].length; j++) {
					multi[i][j]=(i+1)*(j+1);
				}
				response.getWriter().append(Arrays.toString(multi[i])+"<br>");
				
			}
				
		} catch (NumberFormatException e) {
			response.getWriter().append("<h1>  Brak przes³anych zmiennych</h1>");
			
		}
		
		
	}

}
