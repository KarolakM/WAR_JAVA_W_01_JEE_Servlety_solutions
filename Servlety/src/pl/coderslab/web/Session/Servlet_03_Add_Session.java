package pl.coderslab.web.Session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/addToSession")
public class Servlet_03_Add_Session extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		HttpSession sess = request.getSession(true);

		String sessionKey= request.getParameter("key");
		String sessionValue= request.getParameter("value");
		

		
		sess.setAttribute(sessionKey, sessionValue);
		 
		
	}

}
