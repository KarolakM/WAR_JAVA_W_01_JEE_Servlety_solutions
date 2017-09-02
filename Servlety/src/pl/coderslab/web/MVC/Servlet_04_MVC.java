package pl.coderslab.web.MVC;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.web.MVCjdbc.Book;


@WebServlet("/Servlet_04_MVC")
public class Servlet_04_MVC extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/mvc/form.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Book Book1 = new Book(request.getParameter("title1"), request.getParameter("author1"), request.getParameter("isbn1"));
		Book Book2 = new Book(request.getParameter("title2"), request.getParameter("author2"), request.getParameter("isbn2"));
		Book Book3 = new Book(request.getParameter("title3"), request.getParameter("author3"), request.getParameter("isbn3"));
		Book Book4 = new Book(request.getParameter("title4"), request.getParameter("author4"), request.getParameter("isbn4"));
		Book Book5 = new Book(request.getParameter("title5"), request.getParameter("author5"), request.getParameter("isbn5"));
		Book [] books =  new Book[] {Book1, Book2, Book3, Book4, Book5};
		request.setAttribute("books", books);
		getServletContext().getRequestDispatcher("/WEB-INF/mvc/result_2.jsp").forward(request, response);
		
	}

}
