package pl.coderslab.web.Session;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Servlet_07_Session")
public class Servlet_07_Session extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		response.setContentType("text/html;charset=UTF-8");
		Random r = new Random();
		int [] number = new int []{ r.nextInt(1021)-20, r.nextInt(1021)-20};
		
		sess.setAttribute("numbers", number);
		
		response.getWriter().append("<form  method=\"POST\">\r\n" + 
				"    <label>\r\n" + 
				number[0]+ " + "+ number[1]+ "= " +
				"        <input type=\"number\" name=\"sum\">\r\n<br>" + 
				"    </label>\r\n" + 
				"    <label>\r\n" + 
				number[0]+ " - "+  number[1]+ "= " +
				"        <input type=\"number\" name=\"subtraction\">\r\n<br>" + 
				"    </label>\r\n" + 
				"    <label>\r\n" + 
				number[0]+ " * "+ number[1]+ "= " +
				"        <input type=\"number\" name=\"multiply\">\r\n<br>" + 
				"    </label>\r\n" +  
				"    <input type=\"submit\">\r\n" + 
				"\r\n" + 
				"</form>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		int sum = Integer.parseInt(request.getParameter("sum"));
		int subtraction = Integer.parseInt(request.getParameter("subtraction"));
		int multiply = Integer.parseInt(request.getParameter("multiply"));
		String sum_result,  subtraction_result, multiply_result;
		
		
		int[] numbers = (int[]) sess.getAttribute("numbers");
		
		if ((numbers[0] + numbers[1]) == sum) {
			sum_result = "CORRECT";
		} else {
			 sum_result = "Wrong";
		}
		
		if ((numbers[0] - numbers[1]) == subtraction) {
			 subtraction_result = "CORRECT";
		} else {
			 subtraction_result = "Wrong";
		}
		
		if ((numbers[0] * numbers[1]) == multiply) {
			 multiply_result = "CORRECT";
		} else {
			 multiply_result = "Wrong";
		}
	
		response.getWriter().append("<table><tr><td>"+numbers[0]+"</td><td> + </td><td>"+ numbers[1]+"</td><td> = </td><td>"+ sum+ "</td><td>"+sum_result+" </td></tr>")
		.append("<tr><td>"+numbers[0]+"</td><td> - </td><td>"+ numbers[1]+"</td><td> = </td><td>"+ subtraction+ "</td><td>"+subtraction_result+" </td></tr>")
		.append("<tr><td>"+numbers[0]+"</td><td> * </td><td>"+ numbers[1]+"</td><td> = </td><td>"+ multiply+ "</td><td>"+multiply_result+" </td></tr></table>");
		
	
	}

}
