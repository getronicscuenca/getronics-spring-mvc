<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<h1>${ departamento.nombre }</h1>

<p>fecha de creacion: ${ departamento.alta }</p><br>
<p>${ departamento.desc }</p>

<spring:url value="/departamento" var="url"></spring:url>
<a href="${ url }">Volver a departamentos</a>