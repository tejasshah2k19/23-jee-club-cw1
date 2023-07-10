<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		ResultSet rs = (ResultSet) request.getAttribute("rs");
	%>

	<div class="container-fluid">

		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<table  class="table table-hover table-striped">       
					<thead>
						<tr>
							<td>UserId</td>
							<td>FirstName</td>
							<td>Email</td>
							<td>Password</td>
							<td>Gender</td>
						</tr>
					</thead>

					<tbody>
						<%
							while (rs.next()) {
						%>
						<tr>
							<td><%=rs.getInt("userId")%></td>
							<td><%=rs.getString("firstName")%></td>
							<td><%=rs.getString("email")%></td>
							<td><%=rs.getString("password")%></td>
							<td><%=rs.getString("gender")%></td>

						</tr>
						<%
							}
						%>   
					</tbody>
				</table>
			</div>
		</div>
	</div>

</body>
</html>