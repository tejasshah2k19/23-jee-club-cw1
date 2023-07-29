<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Input Patient</title>
</head>
<body>
 
	<form action="UpdatePatientSerlvet" method="post">

		<input type="hidden" name="patientId" value="${patientId}"/>

		Name : <input type="text" name="patientName" value="${name}" />
 		<br>
		<br> Age : <input type="text" name="age" value="${age}" />
	 <br>
		<br> <input type="submit" value="Update" />




	</form>
</body>
</html>