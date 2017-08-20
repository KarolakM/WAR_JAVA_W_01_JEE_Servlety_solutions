package pl.coderslab.web.Cookies;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Servlet_05_2_Cookies")
public class Servlet_05_2_Cookies extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		Cookie[] cookies = request.getCookies();
		boolean check=true;
		try {
			for (Cookie c : cookies) {
				if ("User".equals(c.getName())&& check) {
					check=false;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(check) {
			response.getWriter().append("Nie odwiedzi³eœ jeszcze tej strony")
			.append("<a href='./Servlet_05_1_Cookies'> Servlet_05_1_Cookies </a>");
		}else {
			response.getWriter().append("Witamy na stronie Servlet_05");
		}
	}

}
