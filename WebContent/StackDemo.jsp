<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Stack</title>
</head>
<body>

<form action="StackServlet">
	Data : <input type="text" placeholder="Enter Number" name="data"/><BR><br>
	<input type="submit" value="CreateStack"/>

</form>
<br>
${error}
</body>
</html>