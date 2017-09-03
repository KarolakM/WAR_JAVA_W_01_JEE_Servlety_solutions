package pl.coderslab.web.Homework_01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet_04_Homework_01")
public class Servlet_04_Homework_01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect("./index_Homework_01.html");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		double num1 = Double.parseDouble(request.getParameter("num1"));
		double num2 = Double.parseDouble(request.getParameter("num2"));
		double num3 = Double.parseDouble(request.getParameter("num3"));
		double num4 = Double.parseDouble(request.getParameter("num4"));
		
		double sum = num1+ num2+ num3+ num4;
		double ave = sum/4.0;
		double multi = num1*num2*num3*num4;
		
		

		response.getWriter().append("Liczby:" + 
				"<ul><li>"+num1+"</li>" + 
				"<li>"+num2+"</li>" + 
				"<li>"+num3+"</li>" + 
				"<li>"+num4+"</li></ul>" + 
				"Œrednia:" + 
				"<ul><li>"+ave+" </li></ul>" + 
				"Suma:" + 
				"<ul><li>"+sum+"  </li></ul>" + 
				"Iloczyn:" + 
				"<ul><li>"+multi+"</li></ul>");
	}

}

