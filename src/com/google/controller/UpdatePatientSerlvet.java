package com.google.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.util.DbConnection;

@WebServlet("/UpdatePatientSerlvet")
public class UpdatePatientSerlvet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer patientId = Integer.parseInt(request.getParameter("patientId"));
		Integer age = Integer.parseInt(request.getParameter("age"));
		String name = request.getParameter("patientName");

		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstm = con.prepareStatement("update patient set age = ? , name =  ? where patientId = ?");
			pstm.setInt(1, age);
			pstm.setString(2, name);
			pstm.setInt(3, patientId);

			pstm.executeUpdate();
			
			response.sendRedirect("ListPatientServlet");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
