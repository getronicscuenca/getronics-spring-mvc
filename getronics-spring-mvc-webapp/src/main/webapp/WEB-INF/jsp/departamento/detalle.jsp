<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1>${ departamento.nombre }</h1>

<spring:url value="/departamento/alta/${ departamento.id }" var="url2"></spring:url>
<p>fecha de creacion: ${ departamento.alta }
	<form:form action="${ url2 }" >
		<button type="submit">editar fecha</button>
	</form:form>
</p>



<p>${ departamento.desc }</p>

<spring:url value="/departamento" var="url"></spring:url>
<a href="${ url }">Volver a departamentos</a>