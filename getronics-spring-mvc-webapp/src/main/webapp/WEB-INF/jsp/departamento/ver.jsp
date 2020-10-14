<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table>
	<thead>
		<th>Id</th>
		<th><spring:message code="departamento.nombre"></spring:message></th>
		<th><spring:message code="departamento.descripcion"></spring:message></th>
		<th><spring:message code="departamento.fecha"></spring:message></th>

	</thead>
	<tbody>

		<c:forEach items="${ departamentos }" var="dep">
			<tr>
				<td>${dep.id}</td>
				<td>${dep.nombre}</td>
				<td>${dep.descripcion}</td>
				<td>${dep.fecha}</td>

				<td><a href="<spring:url value="/departamento/" ></spring:url>">volver</a>

				</td>
			</tr>
		</c:forEach>

	</tbody>

	<spring:url value="/departamento" var="url"></spring:url>
	<form:form action="${ url }">
		<button type="submit">
			<spring:message code="departamento.options.add"></spring:message>
		</button>
	</form:form>
</table>