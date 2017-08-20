package pl.coderslab.web.Cookies;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Servlet_05_1_Cookies")
public class Servlet_05_1_Cookies extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		Cookie newCookie = new Cookie("User", "NazwaUsera");
		newCookie.setMaxAge(60 * 60 * 24);
		response.addCookie(newCookie);
		response.getWriter().append("<a href='./Servlet_05_2_Cookies'> Servlet_05_2_Cookies </a>");
		
	}

}
