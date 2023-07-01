package com.google.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SaveUserServlet")
public class SaveUserServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("SaveUserSerlvet Called...");

		// read form data
		String firstName = request.getParameter("firstName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		boolean isError = false;
		String error = "";
		if (firstName == null || firstName.trim().length() == 0) {
			isError = true;
			error += "Please Enter FirstName<br>";
		}

		if (email == null || email.trim().length() == 0) {
			isError = true;
			error += "Please Enter Email<br>";
		}

		if (password == null || password.trim().length() == 0) {
			isError = true;
			error += "Please Enter Password<br>";
		}

		System.out.println(firstName);
		System.out.println(email);
		System.out.println(password);

		// response print -> old approach => servlet -> generate html

		response.setContentType("text/html"); // MIME

		PrintWriter out = response.getWriter(); // server --> client

		out.print("<html><body>");

		if (isError == true) {
			out.print(error);
		} else {
			out.print("<br>FirstName => " + firstName);
			out.print("<BR>Email => " + email);
			out.print("<br>Password =>" + password);
		}
		out.print("</body></html>");
	}
}
