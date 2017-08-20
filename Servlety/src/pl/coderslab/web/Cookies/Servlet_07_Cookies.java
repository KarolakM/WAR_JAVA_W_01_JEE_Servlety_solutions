package pl.coderslab.web.Cookies;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/rememberMe")
public class Servlet_07_Cookies extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String cookieValue = null;
		Boolean continu= true;
		Cookie[] cookies = request.getCookies();
		if (cookies != null){
			for (Cookie c : cookies) {
					if ("NazwaUsera".equals(c.getName())) {
						cookieValue = c.getValue();
						continu = false;
						response.getWriter().append("Czeœæ ").append(cookieValue)
								.append("Twoje dane zosta³y wczytane z ciasteczka");
					}
			} 
		}
		if(continu) {
			response.sendRedirect(request.getContextPath() + "/index_Cookie.html");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String name = request.getParameter("name");
		String check = request.getParameter("rememberMe");
		response.getWriter().append("Czeœæ ").append(name);
		if(check!= null ){
			Cookie newCookie = new Cookie(name, "NazwaUsera");
			response.addCookie(newCookie);
		}
		
		
		
		
	}

}
