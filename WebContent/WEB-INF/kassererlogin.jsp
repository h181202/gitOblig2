<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Kasserer login</title>
</head>
<body>
<h2>Kasserer login</h2>
<form action="KassererLoginServlet" method="post">
  <fieldset>
    <legend>Kasserer login</legend>
    <p>Passord: <input type="password" name="password" value="allstars" /></p>
    <p><input type="submit" value="Login" /></p>
    <p><c:out value="${requestScope.redirectErrorMessage}"></c:out>
  </fieldset>
</form>
</body>
</html>