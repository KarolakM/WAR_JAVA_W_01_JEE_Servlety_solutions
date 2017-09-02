package pl.coderslab.web.MVCfilter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/Servlet_02_MVCfilter")
public class Servlet_02_MVCfilter implements Filter {

	public void destroy() {
		
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		long startTime = System.currentTimeMillis();
		filterChain.doFilter(request, response);
		long stopTime = System.currentTimeMillis();
		System.out.println(stopTime - startTime);
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String browserName = httpRequest.getHeader("User-Agent");
		System.out.println(browserName);
	}


	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
