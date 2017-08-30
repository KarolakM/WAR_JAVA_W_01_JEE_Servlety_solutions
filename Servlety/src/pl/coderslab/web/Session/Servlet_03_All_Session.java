package pl.coderslab.web.Session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/showAllSession")
public class Servlet_03_All_Session extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter responseWriter = response.getWriter();
		 
        responseWriter.write("<html><body>");
 
        HttpSession session = request.getSession();
        Enumeration<String> attributeNames = session.getAttributeNames();
        responseWriter.write("<table border=\"1\">");
        while (attributeNames.hasMoreElements()) {
            String attributeName = attributeNames.nextElement();
            responseWriter.write("<tr><td>" + attributeName + "</td><td> " + session.getAttribute(attributeName) + "</td></tr> ");
        }
        responseWriter.write("</table></body></html>");
      
		
	}

	

}
