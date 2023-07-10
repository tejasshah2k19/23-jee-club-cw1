package com.google.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import com.google.util.DbConnection;

@WebServlet("/ListUsersServlet")
public class ListUsersServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			// db connection open
			Connection con = DbConnection.getConnection();
			// select * from users
			PreparedStatement pstmt = con.prepareStatement("select * from users");
			ResultSet rs = pstmt.executeQuery();//

			// print data on browser
//			response.setContentType("text/html");
//			PrintWriter out = response.getWriter();
// 
//			while (rs.next()) { // rs -> cursor set to 1st row
//				int userId = rs.getInt("userId");
//				String firstName = rs.getString("firstName");
//				String email = rs.getString("email");
//				String password = rs.getString("password");
//				String gender = rs.getString("gender");
//
//				out.print("<br>"+userId + "  " + firstName + "  " + email + "  " + password + "  " + gender);
//			}

			request.setAttribute("rs", rs);
			RequestDispatcher rd = request.getRequestDispatcher("ListUser.jsp");
			rd.forward(request, response);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
