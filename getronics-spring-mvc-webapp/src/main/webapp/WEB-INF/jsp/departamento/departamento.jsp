<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<spring:url value="/departamento/new" var="url"></spring:url>
<spring:message code="departamento.new.title" var="insertTitle" />
<spring:message code="departamento.update.title" var="updateTitle" />

<c:choose>
	<c:when test="${ dep.id == null}">
		<c:set value="${ insertTitle }" var="title" />
	</c:when>
	
	<c:when test="${ dep.id == null}">
		<c:set value="${ updateTitle }" var="title" />
	</c:when>
	
</c:choose>

<form:form modelAttribute="departamento" action="${ url }">

	<h1>${ title }</h1>
	<form:hidden path="id" />
	<spring:message code="departamento.nombre"></spring:message>: <form:input path="nombre" />
	<br />

	<form:button value="submit">Enviar</form:button>
</form:form>