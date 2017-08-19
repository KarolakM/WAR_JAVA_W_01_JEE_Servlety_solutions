package pl.coderslab.web.Get;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Servlet_05_get")
public class Servlet_05_get extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String company =  request.getParameter("company");
		String[] learn = request.getParameterValues("learn");
		
		response.getWriter().append("company: <br>").append("	- "+company+"<br>").append("learn: <br>");
		
		for (int i = 0; i < learn.length; i++) {
			response.getWriter().append("	- "+learn[i]+"<br>");
		}
	}

}
