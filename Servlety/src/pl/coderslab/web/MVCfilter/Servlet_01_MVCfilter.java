package pl.coderslab.web.MVCfilter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class Servlet_01_MVCfilter
 */
@WebFilter("/Servlet_01_MVCfilter")
public class Servlet_01_MVCfilter implements Filter {

	public void destroy() {
	
	}

	private String encoding = "utf-8";
	private String charset = "text/html";

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		request.setCharacterEncoding(encoding);
		response.setContentType(charset);
		response.setCharacterEncoding(encoding);
		filterChain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}