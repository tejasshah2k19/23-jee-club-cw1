package com.google.stag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SqrTag extends SimpleTagSupport{

	//attribute 
	
	int value; //this is the name of attribute that we will use in tag 
	
	//also create getters setters 
	public int getValue() {
		return value;
	}
	//setter will call by server  when we call tag in jsp 
	public void setValue(int value) {
		this.value = value;
	}

	
	
	public void doTag() throws JspException, IOException {

		JspWriter out = getJspContext().getOut(); 
		out.print(value*value);
	}

}
