package pl.coderslab.web.d_Servlety_2;

import java.io.IOException;
import java.time.LocalTime;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Servlet_04d")
public class Servlet_04d extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String ip = request.getRemoteAddr();
		String browser =  request.getHeader("user-agent");;
		
		
		response.getWriter().append("Adres IP: " + ip+"<br>").append("Przegl¹darka: "+ browser +"<br>")
				.append("Aktualny czas: " + LocalTime.now().toString());
	}

}
