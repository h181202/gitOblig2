<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglibprefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Påmeldingsbekreftelse</title>
</head>
<body>
<h2>Påmeldingsbekreftelse</h2>
<p>Påmeldingen er mottatt for</p>
<p> ${user.fornavn}<br/>
	${user.etternavn}<br/>
	${user.mobil}<br/>
	${user.kjonn}</p>
<p><b>NB! Husk å betale til kassereren før festen!</b></p>
<a href="deltagerliste.html">Gå til deltagerlisten</a>
</body>
</html>