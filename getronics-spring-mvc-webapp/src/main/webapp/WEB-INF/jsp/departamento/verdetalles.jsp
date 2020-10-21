<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalles del departamento</title>
</head>
<body>

	<h4>Nombre departamento</h4>
	<p>${ departamento.nombre } - fecha: ${ departamento.fecha }</p>
	<hr>
	<h4>Detalles del departamento</h4>
	<p>${ departamento.descripcion }</p>
</body>
</html>