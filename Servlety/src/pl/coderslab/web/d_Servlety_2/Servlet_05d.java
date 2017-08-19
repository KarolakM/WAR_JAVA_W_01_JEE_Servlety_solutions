package pl.coderslab.web.d_Servlety_2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Servlet_05d")
public class Servlet_05d extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		
		String browser =  request.getHeader("user-agent");
		
		
		if (browser.contains("Google Chrome")) {
			response.getWriter().append("U퓓tkownik u퓓wa przegl퉐arki:  Chrome");
		} else if (browser.contains("Mozilla") || browser.contains("Firefox")) {
			response.getWriter().append("U퓓tkownik u퓓wa przegl퉐arki:  Firefox");
		} else if(browser.contains("Opera")) {
			response.getWriter().append("U퓓tkownik u퓓wa przegl퉐arki:  Opera");
		} else if(browser.contains("Safari")) {
			response.getWriter().append("U퓓tkownik u퓓wa przegl퉐arki:  Safari");
		}else{
			response.getWriter().append("Inna przeladarka");
		}
		
	}

}
