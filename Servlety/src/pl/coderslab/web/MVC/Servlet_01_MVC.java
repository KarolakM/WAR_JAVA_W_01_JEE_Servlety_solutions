package pl.coderslab.web.MVC;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class Servlet_01_MVC extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		double exchangeRate = Double.parseDouble(getInitParameter("exchangeRate"));
		int zlotys = Integer.parseInt(request.getParameter("value"));
		request.setAttribute("euro", exchangeRate * zlotys);
		getServletContext().getRequestDispatcher("/WEB-INF/mvc/jsp1.jsp").forward(request, response);
	}

}
