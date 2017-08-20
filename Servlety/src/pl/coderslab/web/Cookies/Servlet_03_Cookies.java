package pl.coderslab.web.Cookies;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Servlet_03_Cookies")
public class Servlet_03_Cookies extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String myCookie= request.getParameter("key");
		String cookieValue= request.getParameter("value");
		int expiry = Integer.parseInt(request.getParameter("expiry"));

		Cookie newCookie = new Cookie(myCookie, cookieValue);
		newCookie.setMaxAge(expiry * 60* 60);
		response.addCookie(newCookie);
	}

}
