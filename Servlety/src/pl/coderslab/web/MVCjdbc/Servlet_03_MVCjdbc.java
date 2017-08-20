package pl.coderslab.web.MVCjdbc;
import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/all-books")
public class Servlet_03_MVCjdbc extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDao bookDao= new BookDao();
		List<Book> books = bookDao.findAll();
		
		request.setAttribute("books", books);
		getServletContext().getRequestDispatcher("/WEB-INF/jsp3_MVCjdbc.jsp").forward(request, response);
		


	}
	

}
