package pl.coderslab.web.c_Servlety_1;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Servlet_05")
public class Servlet_05 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enumeration<String> headerNames=request.getHeaderNames();
		response.setContentType("text/html");
		while(headerNames.hasMoreElements()){
			String headerName=  headerNames.nextElement();
			response.getWriter().append(""+headerName+": ")
			.append(request.getHeader(headerName))
			.append("<br>");
		}
		
		
	}

}
