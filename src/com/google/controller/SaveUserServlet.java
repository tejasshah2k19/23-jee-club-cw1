package com.google.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.util.Validator;

@WebServlet("/SaveUserServlet")
public class SaveUserServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("SaveUserSerlvet Called...");

		// read form data
		String firstName = request.getParameter("firstName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String country = request.getParameter("country");
		String hobby[] = request.getParameterValues("hobby");

		boolean isError = false;
		String error = "";
		if (Validator.isBlank(firstName)) {
			isError = true;
			error += "Please Enter FirstName<br>";
			request.setAttribute("firstNameError", "Please Enter FirstName");

		} else if (Validator.isAlpha(firstName) == false) {
			isError = true;
			error += "Please Enter Valid FirstName<br>";
			request.setAttribute("firstNameError", "Please Enter Valid FirstName");

		} else if (Validator.isValidLength(firstName, 2) == false) {
			isError = true;
			error += "Please Enter Valid FirstName (min Length 2 char)<br>";
			request.setAttribute("firstNameError", "Please Enter Valid FirstName (min Length 2 Char) ");

		}

		if (Validator.isBlank(email)) {
			isError = true;
			error += "Please Enter Email<br>";
			request.setAttribute("emailError", "Please Enter Email");
		}

		if (Validator.isBlank(password)) {
			isError = true;
			error += "Please Enter Password<br>";
		} else if (Validator.isValidLength(password, 5)) {
			isError = true;
			error += "Please Enter Strong Password (atleast 5 in length ) <br>";
		}

		if (country == null || country.equals("-1")) {
			isError = true;
			error += "Please Select Country<br>";
		}
		if (gender == null) {
			isError = true;
			error += "Please Select Gender<br>";
		}

		if (hobby == null || hobby.length < 2) {
			isError = true;
			error += "Please Select atelast 2 hobby<br>";
		}
		System.out.println(firstName);
		System.out.println(email);
		System.out.println(password);

		// response print -> old approach => servlet -> generate html

		response.setContentType("text/html"); // MIME

		PrintWriter out = response.getWriter(); // server --> client

		out.print("<html><body>");

		if (isError == true) {
//			out.print(error);
			// goback ->
			
			request.setAttribute("error", error) ; //current request->error set 
			
			RequestDispatcher rd = request.getRequestDispatcher("Signup.jsp");
			rd.forward(request, response);

		} else {
			out.print("<br>FirstName => " + firstName);
			out.print("<BR>Email => " + email);
			out.print("<br>Password =>" + password);
		}
		out.print("</body></html>");
	}
}
