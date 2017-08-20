package pl.coderslab.web.Cookies;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Servlet_04_Show_Cookies")
public class Servlet_04_Show_Cookies extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
		 for (Cookie cookie : cookies) {
			 String link = "<a href='./Servlet_04_Del_Cookies?cookie="+cookie.getName()+"'> Skasuj ciasteczko </a><br>";
			   response.getWriter().append("Cookie name: "+cookie.getName()).append(" Cookie value: "+cookie.getValue()).append(link);	
		  }
		}
	}


}
