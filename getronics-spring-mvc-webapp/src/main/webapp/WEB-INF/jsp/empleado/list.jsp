<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<table>
	<thead>
		<th>Id</th>
		<th><spring:message code="empleado.nombre"></spring:message></th>
		<th><spring:message code="empleado.apellido1"></spring:message></th>
		<th><spring:message code="empleado.apellido2"></spring:message></th>
		<th><spring:message code="empleado.options"></spring:message></th>
	</thead>
	<tbody>
		
			<c:forEach items="${ empleados }" var="alumno">
				<tr>
					<td>${alumno.id}</td>
					<td>${alumno.nombre}</td>
					<td>${alumno.apellido1}</td>
					<td>${alumno.apellido2}</td>
					<td>
						<a href="<spring:url value="/empleado/delete/${ alumno.id }" ></spring:url>">Eliminar</a>
						<a href="<spring:url value="/empleado/update/${ alumno.id }" ></spring:url>">Actualizar</a>
					</td>
				</tr>
			</c:forEach>
		
	</tbody>
	
	<spring:url value="/empleado" var="url"></spring:url>
	<form:form action="${ url }" >
		<button type="submit"><spring:message code="empleado.options.add"></spring:message></button>
	</form:form>
</table>