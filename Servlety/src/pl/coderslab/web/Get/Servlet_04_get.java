package pl.coderslab.web.Get;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Servlet_04_get")
public class Servlet_04_get extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		int number =   Integer.parseInt(request.getParameter("page"));
		
		ArrayList <Integer> result = new ArrayList<>();
		
		for (int i = 1; i <= number; i++) {
			if(number%i==0){
				result.add(i);
			}
			
		}
		
		response.getWriter().append("Wiadomosc wyslana. ").append("Dzielniki ca³kowite  liczby: "+ number+ " to: "+ Arrays.toString(result.toArray()));
	}

	

}
