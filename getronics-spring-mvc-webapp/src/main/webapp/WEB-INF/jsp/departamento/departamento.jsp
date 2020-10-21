<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado de departamentos</title>
<style>
	.error {
		color: red;
	}
</style>
</head>
<body>
	<spring:url value="/departamento/new" var="url"></spring:url>
	<spring:message code="departamento.new.title" var="insertTitle"/>
	<spring:message code="departamento.update.title" var="updateTitle"/>
	<c:choose>
		<c:when test="${ departamento.id == null}">
			<c:set value="${ insertTitle }" var="title" />
		</c:when>
		<c:otherwise>
			<c:set value="${ updateTitle }" var="title" />
		</c:otherwise>
	</c:choose> 
	<h1>${ title }</h1>
	<form:form modelAttribute="departamento" action="${ url }">
		<form:hidden path="id"/>
		Nombre: <form:input path="nombre"/><form:errors path="nombre" cssClass="error" />
		</br>
		Descripción: <form:input path="descripcion" /><form:errors path="descripcion" cssClass="error" /></br>
		Fecha: 	<input type="date" path="fecha" id="fecha" name="fecha"/></br>
		<form:button value="submit">Enviar</form:button>
	</form:form>
</body>
</html>