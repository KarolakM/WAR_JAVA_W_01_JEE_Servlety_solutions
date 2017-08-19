package pl.coderslab.web.Post;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;


@WebServlet("/Servlet_02_Post")
public class Servlet_02_Post extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List <String> list = Arrays.asList(new String[] {"dupa", "cholera"});
		String message = request.getParameter("message");
		String confirm = request.getParameter("tick");
		
		if(confirm==null){
			String censored = "";
			String[] words = message.split(" ");
			for (String string : words) {
				if(list.contains(string)){
					censored += StringUtils.repeat("*", string.length())+" ";
				}else{
					censored +=string+" ";
				}
			}
			response.getWriter().append(censored);
		}else{
			response.getWriter().append(message);
		}
		

	}

}
