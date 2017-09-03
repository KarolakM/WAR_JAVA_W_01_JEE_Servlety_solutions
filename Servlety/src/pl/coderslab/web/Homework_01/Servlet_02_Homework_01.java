package pl.coderslab.web.Homework_01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Servlet_02_Homework_01")
public class Servlet_02_Homework_01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		if(gender.equals("m")) {
			response.getWriter().append("Coders Lab wita Pana "+name);
		}else {
			response.getWriter().append("Coders Lab wita Pani¹ "+name);
		}
	}

}
