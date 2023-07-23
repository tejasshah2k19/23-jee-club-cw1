package com.google.controller;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/ProcessPatientServlet")
public class ProcessPatientServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// read all jsp data

		String name = request.getParameter("patientName");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age"); // later we convert into int
		String smoke = request.getParameter("smoke");
		String existingProblem[] = request.getParameterValues("existingProblem");
		int ageInt = 0;

		// validation
		boolean isError = false;
		boolean isSmoke = false;
		boolean isDibetic = false;
		boolean isBP = false;
		if (Validator.isBlank(name)) {
			isError = true;
			request.setAttribute("nameError", "Please Enter Patient Name");
		}

		if (Validator.isBlank(gender)) {
			isError = true;
			request.setAttribute("genderError", "Please Select Gender");
		}

		if (Validator.isBlank(age)) {
			isError = true;
			request.setAttribute("ageError", "Please Enter Age");
		} else {
			ageInt = Integer.parseInt(age);
		}

		if (smoke != null) {
			isSmoke = true;
		}

		if (existingProblem != null) {
			for (int i = 0; i < existingProblem.length; i++) {
				if (existingProblem[i].equals("db")) {
					isDibetic = true;
				}
				if (existingProblem[i].equals("bp")) {
					isBP = true;
				}
			}
		}

		if (isError == false) {

			// db save -> success -> result

			// Java -> DbConnection ->
			// driver -> mysql -> connection OK
			// insert into table -->

			try {
				Connection con = DbConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"insert into patient (name,gender,age,smoke,diabetic,bp) values (?,?,?,?,?,?)");
				pstmt.setString(1, name);
				pstmt.setString(2, gender);
				pstmt.setInt(3, ageInt);
				pstmt.setBoolean(4, isSmoke);
				pstmt.setBoolean(5, isDibetic);
				pstmt.setBoolean(6, isBP);
				
				
				pstmt.executeUpdate() ;// execute the query -- return the count 
				//insert update delete 
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Patient insertion failed --> ");
				e.printStackTrace();
			}

			PrintWriter out = response.getWriter(); // out -> response
			response.setContentType("text/html");

			out.print("<html><body>");
			out.print("<br>Patient Name : " + name);
			out.print("<br>Gender : " + gender);
			out.print("<br>Age : " + ageInt);
			out.print("<br>isSMoke : " + isSmoke);
			out.print("<br>isDibetic : " + isDibetic);
			out.print("<br>isBP : " + isBP);
			out.print("<br><h3> Heart Dis. chance " + 50 + "%</h3>");
		
			out.print("<a href='InputPatient.jsp'>Add More Patient</a>");
			out.print("<a href='ListPatientServlet'>List Patient</a>");
			
			
			out.print("</body></html>");
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("InputPatient.jsp");
			rd.forward(request, response);
		}
	}
}
