package pl.coderslab.web.Cookies;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/addToCookie")
public class Servlet_02_Cookies extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().append("<form action=\"\" method=\"POST\">").append("<label> Klucz:<input type='text' name='key'> </label>")
		.append("<label> Wartoœæ: <input type=\"text\" name=\"value\"> </label>").append("<input type=\"submit\"> </form>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String myCookie= request.getParameter("key");
		String cookieValue= request.getParameter("value");

		Cookie newCookie = new Cookie(myCookie, cookieValue);
		response.addCookie(newCookie);

		
	}

}
