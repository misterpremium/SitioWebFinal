<!DOCTYPE HTML>
<%@page language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
	
<html>
<head>
<title>index</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<form action="http://raspberrypidpm.ddns.net/SitioWebFinal/Table" method="post">
<p>Introducir nombre de DB</p>
<input type="text" name="DBname" list="DB">
<p>Introducir nombre de tabla</p>

<datalist id="DB" required="required" >
	<option value="employees"></option>
	<option value="Hotel"></option>
	<option value="hoteles"></option>
</datalist>
<input type="text" name="TableName" list="Tabla">
<p>Introducir nombre columna</p>
<datalist id="Tabla">
	<option value="employees"></option>
	<option value="salaries"></option>
	
</datalist>
<input type="text" name="nameColumn">
<input type="submit" value="Enviar">
</form>
<% String variable = request.getParameter("nameColumn"); %>
<% String variable2 = request.getParameter("TableName"); %>
<% String variable3 = request.getParameter("DBname"); %>





</body>
</html>