package com.google.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;



//@WebFilter(filterName="f2" ,urlPatterns="/StackServlet")
public class StackFormatValidationFilter implements Filter {
	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("StackFormatValidationFilter -> doFilter");

		String data = request.getParameter("data");

		String numberRegEx = "[0-9]+";
		if (data.matches(numberRegEx) == false) {
			request.setAttribute("error", "Please Enter Valid Data");
			request.getRequestDispatcher("StackDemo.jsp").forward(request, response);
		} else {
			// go ahead
			chain.doFilter(request, response);// next filteR ? next servlet?
		}

	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
