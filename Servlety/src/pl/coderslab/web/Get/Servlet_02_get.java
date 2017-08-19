package pl.coderslab.web.Get;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Servlet_02_get")
public class Servlet_02_get extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String, String[]> allMap= request.getParameterMap();
		for (String  key : allMap.keySet()) {
			String[] str=allMap.get(key);
			for (String val : str) {
				response.getWriter().append("key ="+key+"; val= "+val);
			}
		}
		
		
		
	}

}
