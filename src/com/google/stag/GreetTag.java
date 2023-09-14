package com.google.stag;

import java.io.IOException;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
//jsp-api.jar ->tomcat/lib 
public class GreetTag extends SimpleTagSupport{

	public void doTag() throws JspException, IOException {

		//we want to write data on jsp 
		JspWriter out = getJspContext().getOut();
		Date d = new Date(); 
		
		int h = d.getHours(); //18 
		
		if( h >= 0 && h <= 11) {
			out.print("Good Morning");
		}else if(h >= 12 && h<=17) {
			out.print("Good AfterNoon");
		}else {
			out.print("Good Evening");
		}
	}
	
	
}
