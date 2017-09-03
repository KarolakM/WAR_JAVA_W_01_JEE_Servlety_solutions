package pl.coderslab.web.Homework_01;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Servlet_05_Homework_01")
public class Servlet_05_Homework_01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Random r = new Random();
		int[] numbers = new int[10];

		for (int i = 0; i < 10; i++) {
			numbers[i]=r.nextInt(101);
		}

		response.getWriter().append(Arrays.toString(numbers)+"<br>");
		Arrays.sort(numbers);
		response.getWriter().append(Arrays.toString(numbers));
	}


}
