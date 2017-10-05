<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Deltagerliste</title>
</head>
<body>
<h2>Deltagerliste</h2>
<table border="1">
<tr bgcolor="#cccccc"><th>Kjønn</th><th align="left">Navn</th></tr>
<c:forEach var="user" items="${requestScope.items}">
<tr 
	<c:if test="${user} eq ${sessionScope.user} && ${user.betalt} == true">
		bgcolor="#aaffaa"
	</c:if>
	<c:if test="${user} eq ${sessionScope.user} && ${user.betalt} == false">
		bgcolor="#ffaaaa"
	</c:if>
><td align="center">
	<c:if test="${user.sex} == true">
		&#9794;
	</c:if>
	<c:if test="${user.sex} == false">
		&#9792;
	</c:if>
	</td><td>
		<c:out value="${user.fnavn} ${user.enavn}"></c:out>
	</td></tr>
</c:forEach>
</table>
<p><a href="FerdigServlet">Ferdig</a></p>
</body>
</html>