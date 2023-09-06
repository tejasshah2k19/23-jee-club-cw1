package com.google.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
@WebFilter("/LoginServlet") // when user ask for LoginServlet , before that servlet i {filter} will execute and 
			//	i will decide go ahead | go back 
public class LoginFilter implements Filter {

	public void init(FilterConfig arg0) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("DoFilter-->From-->LoginFilter");
		//goahead 
			//LoginServlet 
			chain.doFilter(request, response); // goahead 
		//goback 
			//Login.jsp 
			 //rd 
			//validation 
			
	
	}

	public void destroy() {

	}
}
