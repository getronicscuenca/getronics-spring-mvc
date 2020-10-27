<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<spring:url value="/tecnologia/new" var="url"></spring:url>

<c:choose >
	<c:when test="${ tecnologia.id == null}">
		<c:set value="Insertar nueva tecnologia" var="title" />
	</c:when>
	<c:otherwise>
		<c:set  value="Actualizar tecnologia existente" var="title" />
	</c:otherwise>
</c:choose>
<form:form modelAttribute="tecnologia" action="${ url }"
<h1>${ title }</h1>
	<form:hidden path="id"/>
	Nombre: <form:input path="nombre" /><br/>
	Descripcion:<form:input path="descripcion"/><br/>
	
	
	<form:button value="submit">Enviar</form:button>
</form:form>