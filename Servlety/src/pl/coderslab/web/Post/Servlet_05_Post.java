package pl.coderslab.web.Post;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Servlet_05_Post")
public class Servlet_05_Post extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String message;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		double a =  Double.parseDouble(request.getParameter("degrees"));
		String type = request.getParameter("convertionType");
		
		if(type.equals("celcToFahr")) {
			double b =  (a*(9/5))+32;
			message = a+ "  °C to "+ b + "  °F.";			
		}else if(type.equals("FahrToCelc")) {
			double b = (a-32)*(5/9);
			message = a+ "  °F to "+ b + "  °C.";
		}else {
			message="Wybierz sposob przeliczania";
		}
		response.getWriter().append(message);
	}

}
