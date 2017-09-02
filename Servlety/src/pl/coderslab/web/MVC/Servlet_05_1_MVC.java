package pl.coderslab.web.MVC;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pl.coderslab.web.MVCjdbc.Book;

@WebServlet("/Servlet_05_1_MVC")
public class Servlet_05_1_MVC extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/mvc/form5_1.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sess = request.getSession();
		
		Book Book = new Book(request.getParameter("title1"), request.getParameter("author1"),
				request.getParameter("isbn1"));

		Book[] booksTemp = (Book[]) sess.getAttribute("books");
		
		response.getWriter().append("Books"+ Arrays.toString(booksTemp));

		if (booksTemp != null) {
			Book[] books = Arrays.copyOf(booksTemp, booksTemp.length + 1);
			books[booksTemp.length] = Book;

			sess.setAttribute("books", books);
		} else {
			Book[] books = new Book[] { Book };
			sess.setAttribute("books", books);
		}

		getServletContext().getRequestDispatcher("/WEB-INF/mvc/result_2.jsp").forward(request, response);

	}
}
