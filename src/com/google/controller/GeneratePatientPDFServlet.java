package com.google.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.collection.PdfTargetDictionary; 

@WebServlet("/GeneratePatientPDFServlet")
public class GeneratePatientPDFServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/pdf");
	
		response.setHeader("Content-disposition", "outline;filename=patientlist.pdf");
		
		try {
			Document document = new Document();
	
			PdfWriter.getInstance(document, response.getOutputStream());
			
			
			document.open();
			document.add(new Paragraph("Patient List"));
 
			
		      
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
