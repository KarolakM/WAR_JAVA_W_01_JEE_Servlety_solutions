package pl.coderslab.web.MVCjdbc;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/search-book")
public class Servlet_04_MVCjdbc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDao bookDao= new BookDao();
		List<Book> books = bookDao.findAll();
		
		request.setAttribute("books", books);
		getServletContext().getRequestDispatcher("/WEB-INF/jsp3_MVCjdbc.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search = request.getParameter("find");
		BookDao bookDao2= new BookDao();
		List<Book> books2 = bookDao2.findBook(search);
		
		request.setAttribute("books", books2);
		getServletContext().getRequestDispatcher("/WEB-INF/jsp3_MVCjdbc.jsp").forward(request, response);
	}

}
