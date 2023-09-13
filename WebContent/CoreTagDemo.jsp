<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	int a=10; 
%>
<%=a  %>
<%if(a%2 == 0){ %>
	EVEN
<%} %>

<%for(int x=1;x<=5;x++){ %>
	<%=x %><br>
<%} %>


<%String str = "jan,feb,march" ;%>
<% String strA[] = str.split(","); %>
<%for(String s:strA) {%>
	<%=s %><br>
<%} %>

<hr>


<c:set var="a" value="10"></c:set>
<c:out value="${a}"></c:out>

<c:if test="${a%2 == 0}">
	EVEN 
</c:if>


<c:forEach var="x" begin="1" end="5" step="1">
	${x }<br>
</c:forEach>

<c:set var="strA" value="jan,feb,march"></c:set>
<c:forTokens items="${strA}" delims=","  var="x">
	${x }<br>
</c:forTokens>


</body>
</html>