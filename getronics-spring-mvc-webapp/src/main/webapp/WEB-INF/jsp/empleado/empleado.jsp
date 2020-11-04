<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<spring:url value="/empleado/new" var="url"></spring:url>
<spring:message code="empleado.new.title" var="insertTitle" />
<spring:message code="empleado.update.title" var="updateTitle" />
<c:choose>
	<c:when test="${ alumno.id == null}">
		<c:set value="${ insertTitle }" var="title" />
	</c:when>
	<c:otherwise>
		<c:set value="${ updateTitle }" var="title" />
	</c:otherwise>
</c:choose>

<form:form modelAttribute="empleado" action="${ url }">

	<h1>${ title }</h1>
	<form:hidden path="id" />
	<spring:message code="empleado.nombre"></spring:message>: <form:input
		path="nombre" />
	<br />
	<spring:message code="empleado.apellido1"></spring:message>
	<form:input path="apellido1" />
	<br />
	<spring:message code="empleado.apellido2"></spring:message>
	<form:input path="apellido2" />
	<br />
	<spring:message code="empleado.departamento"></spring:message>
	<form:radiobuttons path="idDepartamento" items="${departamentos}"
		itemLabel="nombre" itemValue="id" />
	<br />
	<a href="<spring:url value="/empleado"></spring:url>">volver</a>

	<form:button value="submit">Enviar</form:button>
</form:form>