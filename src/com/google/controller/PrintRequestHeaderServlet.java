package com.google.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrintRequestHeaderServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Enumeration<String> data = request.getHeaderNames();

		PrintWriter out = response.getWriter();

		response.setContentType("text/html");

		out.print("<html>");
		out.print("<body>");
		while (data.hasMoreElements()) {
			String x = data.nextElement(); // record
			out.print(x+" => "+ request.getHeader(x)+ "<Br>");
		}
		out.print("</body>");
		out.print("</html>");

	}

}
