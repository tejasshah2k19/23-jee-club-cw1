package com.google.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.spec.PSSParameterSpec;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.util.DbConnection;

@WebServlet("/ListPatientServlet")
public class ListPatientServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// open db connection
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from patient");
			ResultSet rs = pstmt.executeQuery(); // return all the rows -> rs

			PrintWriter out = response.getWriter(); // out -> response
			response.setContentType("text/html");

			out.print("<html><body>");
		
			out.print("<br><a href='GeneratePatientPDFServlet'>Export PDF</a><br>");
			
			out.print("<table border='1'>");
			out.print("<tr><th>PatientId</th><th>Name</th><tH>Gender</th><th>Age</th>"
					+ "<th>Action</th>"
					+ "</tr>");

			while (rs.next()) { // 1st row , true -- false
				int patientId = rs.getInt("patientId");
				String name = rs.getString("name"); // getString("dbColumnName");
				String gender = rs.getString("gender");
				int age = rs.getInt("age");

				out.print("<tr>");
				out.print("<td>" + patientId + "</td>");
				out.print("<td>" + name + "</td>");
				out.print("<td>" + gender + "</td>");
				out.print("<td>" + age + "</td>");
				out.print("<td><a href='DeletePatientServlet?patientId="+patientId+"'>Delete</a></td>");	
				out.print("</tr>");
			}

			out.print("</table>");

			out.print("</body></html>");

		} catch (Exception e) {
			System.out.println("ListPatientServlet");
			e.printStackTrace();
		}

		// execute select query -> db -> servlet -> browser

	}
}
