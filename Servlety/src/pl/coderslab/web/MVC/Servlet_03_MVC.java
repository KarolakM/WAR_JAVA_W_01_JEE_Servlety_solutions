package pl.coderslab.web.MVC;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.web.MVCjdbc.Book;

@WebServlet("/Servlet_03_MVC")
public class Servlet_03_MVC extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		getServletContext().getRequestDispatcher("/WEB-INF/mvc/jsp3.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		Book Book = new Book(request.getParameter("title"), request.getParameter("author"), request.getParameter("isbn"));
		request.setAttribute("book", Book);
		getServletContext().getRequestDispatcher("/WEB-INF/mvc/result.jsp").forward(request, response);
	
	}

}
