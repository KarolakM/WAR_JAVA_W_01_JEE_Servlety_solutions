package pl.coderslab.web.MVC;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Servlet_02_MVC")
public class Servlet_02_MVC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int start = Integer.parseInt(request.getParameter("start")) + 10;
		int end = Integer.parseInt(request.getParameter("end")) + 10;
		request.setAttribute("start", start);
		request.setAttribute("end", end);
		getServletContext().getRequestDispatcher("/WEB-INF/mvc/jsp2.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
