package pl.coderslab.web.Get;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Servlet_06_3_get")
public class Servlet_06_3_get extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int m = Integer.parseInt(request.getParameter("mix"));
		int y = Integer.parseInt(request.getParameter("year"));
		int newY = y + m;

		response.getWriter().append("Rok to: " + newY);

	}

}
