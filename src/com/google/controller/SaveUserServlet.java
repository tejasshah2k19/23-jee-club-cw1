package com.google.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.util.DbConnection;
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
			request.setAttribute("passwordError", "Please Enter Password");
		} else if (Validator.isValidLength(password, 5) == false) {
			isError = true;
			error += "Please Enter Strong Password (atleast 5 in length ) <br>";
			request.setAttribute("passwordError", "Please Enter Strong Password (atleast 5 in length )");
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

		if (isError == true) {
//			out.print(error);
			// goback ->
			System.out.println(error);
			request.setAttribute("error", error); // current request->error set

			RequestDispatcher rd = request.getRequestDispatcher("Signup.jsp");
			rd.forward(request, response);

		} else {

			// db connection
			Connection con = DbConnection.getConnection();

			// execute query
			try {
				PreparedStatement pstmt = con
						.prepareStatement("insert into users (firstName,email,password,gender) values (?,?,?,?)");

				pstmt.setString(1, firstName);
				pstmt.setString(2, email);
				pstmt.setString(3, password);
				pstmt.setString(4, gender);

				pstmt.executeUpdate(); // 
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);

		}
	}
}
