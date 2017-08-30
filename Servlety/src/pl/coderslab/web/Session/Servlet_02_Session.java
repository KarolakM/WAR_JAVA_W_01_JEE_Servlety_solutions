package pl.coderslab.web.Session;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Servlet_02_Session")
public class Servlet_02_Session extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public String form = "<form action='' method='POST'><label>Ocena: <input type='text' name='grade'></label> <input type='submit'></form>";

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().append(form);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sess = request.getSession();
		int grade = Integer.parseInt(request.getParameter("grade"));
		int[] grades = (int[]) sess.getAttribute("grades");
		if (grade > 0 && grade < 7) {
			if (sess.getAttribute("grades") == null) {
				sess.setAttribute("grades", new int[] { grade });
			} else {
				sess.setAttribute("grades", addToGrades(grades, grade));
			}
		}
		grades = (int[]) sess.getAttribute("grades");
		response.getWriter().append(form);
		response.getWriter().append("Oceny: "+Arrays.toString(grades)+"<br>");
		response.getWriter().append("Avg = " + countAvg(grades));

	}

	private double countAvg(int[] grades) {
		if(grades.length >0) {
		double sum = Arrays.stream(grades).sum();
		return sum / grades.length;
		}
		return 0;
	}

	public int[] addToGrades(int[] grades, int grade) {
		int[] tmpGrades = Arrays.copyOf(grades, grades.length + 1);
		tmpGrades[grades.length] = grade;
		return tmpGrades;
	}


}
