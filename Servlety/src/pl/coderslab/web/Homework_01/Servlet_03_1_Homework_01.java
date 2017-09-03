package pl.coderslab.web.Homework_01;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Servlet_03_1_Homework_01")
public class Servlet_03_1_Homework_01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
		
		for (int i = 0; i < 8; i++) {
			
			String link = "<a href='./Servlet_03_2_Homework_01?id="+i+"'> Link do produktu "+i+" </a><br>";
			response.getWriter().append(link);
		}
	}

	

}
