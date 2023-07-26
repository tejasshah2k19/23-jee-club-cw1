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

@WebServlet("/DeletePatientServlet")
public class DeletePatientServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		int patientId = Integer.parseInt(request.getParameter("patientId")); 
		
		
		try {
				Connection con = DbConnection.getConnection(); //open 
				PreparedStatement pstmt = con.prepareStatement("delete from patient where patientId = ?");
				pstmt.setInt(1, patientId);
				pstmt.executeUpdate();  //insert update delete 
				
				//next -> ListPatientServlet
				response.sendRedirect("ListPatientServlet");
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}

}
