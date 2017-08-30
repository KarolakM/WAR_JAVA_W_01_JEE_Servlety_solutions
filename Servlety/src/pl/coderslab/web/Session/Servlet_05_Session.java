package pl.coderslab.web.Session;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Servlet_05_Session")
public class Servlet_05_Session extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		Random r = new Random();
		int number1=r.nextInt(101);
		int number2 = r.nextInt(101);
		int sum = number1+number2;
		
		HttpSession sess = request.getSession(true);
		sess.setAttribute("captha", sum);
		

		response.getWriter().append("<form  method=\"POST\">\r\n" + 
				"    <label>\r\n" + 
				"        Imiê:\r\n<br>" + 
				"        <input type=\"text\" name=\"firstName\">\r\n<br>" + 
				"    </label>\r\n" + 
				"    <label>\r\n" + 
				"        Nazwisko:\r\n<br>" + 
				"        <input type=\"text\" name=\"lastName\">\r\n<br>" + 
				"    </label>\r\n" + 
				"    <label>\r\n" + 
				"        mail:\r\n<br>" + 
				"        <input type=\"text\" name=\"mail\">\r\n<br>" + 
				"    </label>\r\n" + 
				"    <label>\r\n" + 
				"        Wpisz poni¿ej sumê "+number1+" + " +number2 +":\r\n<br>" + 
				"        <input type=\"number\" name=\"captcha\">\r\n" + 
				"    </label>\r\n" + 
				"    <input type=\"submit\">\r\n" + 
				"\r\n" + 
				"</form>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		if((int)sess.getAttribute("captha")==Integer.parseInt(request.getParameter("captcha"))) {
			response.getWriter().append("Witaj "+ request.getParameter("firstName"));
		}else {
			response.getWriter().append("Zly captha, sprobuj jeszcze raz");
			
		}
		
	}

}
