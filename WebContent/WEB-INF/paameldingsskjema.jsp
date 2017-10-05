<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglibprefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Påmelding</title>
</head>
<body>
<h2>Påmelding</h2>
<form action="PaameldingServlet" method="post">
  <fieldset>
    <legend>Personlige data</legend>
    <p>Fornavn: <input type="text" name="fornavn" value="${paameldinghjelp.fornavn}"/> 
    ${paameldinghjelp.fornavnFeil}</p>
    <p>Etternavn: <input type="text" name="etternavn"  value="${paameldinghjelp.etternavn}" />
	${paameldinghjelp.fornavnFeil}</p>
    <p>Mobil (8 siffer): <input type="text" name="mobil" value="${paameldinghjelp.mobil}" />
    ${paameldinghjelp.mobilFeil} </p>
    <p>Kjønn: <input type="radio" name="kjonn" value="mann" checked="checked" />mann
        <input type="radio" name="kjonn" value="kvinne" />kvinne</p>
    <p><input type="submit" value="Meld meg på" /></p>
  </fieldset>
</form>
</body>
</html>