<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglibprefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logg inn</title>
</head>
<body>
<h2>Logg inn</h2>
<p>Det er kun registrerte deltagere som får se deltagerlisten.
Logg inn ved å gi mobilnummeret ditt.</p>
<form action="LogginnServlet" method = "post">
  <fieldset>
    <legend>Logg inn</legend>
    <p>Mobil: <input type="password" name="mobil"/>
    ${logginnservlet.feilmelding}</p>
    <p><input type="submit" value="Logg inn" /></p>
  </fieldset>
</form>
</body>
</html>