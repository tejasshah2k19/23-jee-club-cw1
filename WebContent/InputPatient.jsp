<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Input Patient</title>
</head>
<body>

<% String nameError = (String) request.getAttribute("nameError"); %>
	<form action="ProcessPatientServlet" method="post">
	
	
		Name : <input type="text" name="patientName"/>
		<%=nameError==null?"":nameError %>
		<br><br>
		
		Gender :  Male <input type="radio" name="gender"  value="male" />
				FeMale <input type="radio" name="gender"  value="female" />
		${genderError }
		<br><Br>
		Age : <input type="text" name="age"/>
		${ageError }
		<br><br>
		
		Smoke?: <input type="checkbox" name="smoke" value="smoke" /> 
		<br><br>
		
		Existing Problem: 
		Diabetic?: <input type="checkbox" name="existingProblem" value="db" />
		BloodPressure?: <input type="checkbox" name="existingProblem" value="bp" />
		 <Br><Br>
		<input type="submit" value="Process"/>  
		
		
		
		
	</form>
</body>
</html>