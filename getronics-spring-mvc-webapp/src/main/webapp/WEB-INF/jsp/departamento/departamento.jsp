<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado de departamentos</title>
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
		Nombre: <form:input path="nombre"/></br>
		Fecha: <!--<form:input path="fecha" disabled="true"/></br>-->
		<input type="date" path="fecha">
		<form:button value="submit">Enviar</form:button>
	</form:form>
</body>
</html>