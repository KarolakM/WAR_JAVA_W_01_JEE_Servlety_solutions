package pl.coderslab.web.Session;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Servlet_04_Session")
public class Servlet_04_Session extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		showCart(request, response);
                             
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sess = request.getSession(true);

		String productName= request.getParameter("name");
		int productQty=  Integer.parseInt(request.getParameter("qty"));
		double productPrice =  Double.parseDouble(request.getParameter("price"));
		double[] currentProductCart = (double[]) sess.getAttribute(productName);

		if (sess.getAttribute(productName) == null) {
			sess.setAttribute(productName, new double[] { productQty, productPrice });
		} else {

			double qty = currentProductCart[0];
			qty = qty + productQty;
			sess.setAttribute(productName, new double[] { qty, productPrice });

		}
		showCart(request, response);

	}
	
	public  void showCart(HttpServletRequest request2, HttpServletResponse response2)
			throws ServletException, IOException {
		response2.setContentType("text/html;charset=UTF-8");
		HttpSession sess2 = request2.getSession();
		Enumeration <String>  attributeNames = sess2.getAttributeNames();  
		double sum = 0.0;
		response2.getWriter().append("<table>");

        while(attributeNames.hasMoreElements()) {
        	String name=  attributeNames.nextElement();
        	double []productCart= (double[]) sess2.getAttribute(name);   
        	double sumProduct = productCart[0]*productCart[1];
        	sum+=sumProduct;
        
        	response2.getWriter().append("<tr><td>"+name+" - </td><td align=right> ")
        	.append(+ (int)productCart[0]+ "</td><td align=right> x "+ productCart[1]+"z³ </td><td align=right>= "+ sumProduct+"z³ </td></tr>");
                      
        } response2.getWriter().append("<tr><td colspan=3 align=right>SUMA: </td><td align=right>"+sum+"z³</td></tr></table>");     

	}

}
