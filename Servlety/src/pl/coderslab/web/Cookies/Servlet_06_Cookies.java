package pl.coderslab.web.Cookies;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Servlet_06_Cookies")
public class Servlet_06_Cookies extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String cookieValueBackground= null;
		String cookieValueFont =null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if ("background".equals(c.getName())) {
					cookieValueBackground = c.getValue();
				}else if("font".equals(c.getName())) {
					cookieValueFont = c.getValue();
				}
			}
		}
		
		if(cookieValueBackground != null &&cookieValueFont != null ) {
			response.getWriter().append("<body style='background-color:"+cookieValueBackground+"; color:"+cookieValueFont+"'>").
			append("Zapamiêtany w ciasteczku kolor tekstu to: ").append(cookieValueFont).append(", oraz t³a jako: ")
					.append(cookieValueBackground);
		}else {
			response.sendRedirect(request.getContextPath() + "/index_Cookie.html");
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String background= request.getParameter("background");
		String font= request.getParameter("font");
		
		Cookie backgroundCookie = new Cookie("background", background);
		Cookie fontCookie = new Cookie("font", font);
		response.addCookie(backgroundCookie);
		response.addCookie(fontCookie);
		
		response.getWriter().append("<body style='background-color:"+background+"; color:"+font+"'>").
		append("Wybra³eœ kolor tekstu jako: ").append(font).append(", oraz t³a jako: ")
				.append(background).append(". Twój wybór zosta³ zapisane w ciasteczku.");
		
	}

}