<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Betalingsoversikt</title>
</head>
<body>
<h2>Betalingsoversikt</h2>
<form>
<table border="1">
<tr bgcolor="#cccccc"><th align="left">Navn</th><th>Mobil</th><th>Betalingsstatus</th></tr>

<c:forEach var="user" items="${requestScope.listen}">

<c:if test="${user.betalt}">
<tr><td><c:out value="${user.fnavn} ${user.enavn}"></c:out></td><td><c:out value="${user.mobil}"></c:out></td><td align="center">Betaling mottatt</td></tr>
</c:if>

<c:if test="${!user.betalt}">
<form action="BetalingsoversiktServlet" method="post">
<tr><td><c:out value="${user.fnavn} ${user.enavn}"></c:out></td><td><c:out value="${user.mobil}"></c:out></td>
<td><input type="submit" name="registrer" value="Registrer betaling"/></td></tr>
<input type="hidden" name="mobil" value='<c:out value="${user.mobil}"></c:out>'/>
</form>
</c:if>

</c:forEach>
<tr><td>Arne And</td><td>123 45 678</td><td align="center">Betaling mottatt</td></tr>
<tr><td>Arne Arnesen</td><td>901 23 456</td><td><input type="submit" name="90123456" value="Registrer betaling" /></td></tr>
<tr><td>Berit Beritsen</td><td>876 54 321</td><td><input type="submit" name="87654321" value="Registrer betaling" /></td></tr>
</table>
</form>
<p><a href="kassererlogin.html">Ferdig</a></p>
</body>
</html>