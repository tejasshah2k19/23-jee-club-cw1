package com.google.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.util.DbConnection;

@WebServlet("/EditPatientServlet")
public class EditPatientServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer patientId = Integer.parseInt(request.getParameter("patientId"));

		try {

			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from patient where patientId = ?");
			pstmt.setInt(1, patientId);

			ResultSet rs = pstmt.executeQuery();

			rs.next(); // goto first record

			String name = rs.getString("name");
			Integer age = rs.getInt("age");

			request.setAttribute("patientId", patientId);
			request.setAttribute("name", name);
			request.setAttribute("age", age);
			
			request.getRequestDispatcher("EditPatient.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
