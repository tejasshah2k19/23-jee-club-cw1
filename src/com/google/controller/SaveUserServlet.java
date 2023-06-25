package com.google.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SaveUserServlet")
public class SaveUserServlet extends HttpServlet{

	public void service(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("SaveUserSerlvet Called...");
	}
}


