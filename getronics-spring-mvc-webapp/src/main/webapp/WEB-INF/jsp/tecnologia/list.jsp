<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table>
	</thead>
	<th>ID</th>
	<th>NOMBRE</th>
	<thead>
	<tbody>
		<c:forEach items="${ tecnologias  }" var="tecnologia">
			<tr>
				<td>${ tecnologia.id }</td>
				<td>${ tecnologia.nombre }</td>
				<td>
					<a href="<spring:url value="/tecnologia/delete/${ tecnologia.id }" ></spring:url>">Eliminar</a>
					<a href="<spring:url value="/tecnologia/update/${ tecnologia.id }" ></spring:url>">Actualizar</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
	<spring:url value="/tecnologia" var="url"></spring:url>
	<form:form action="${ url }" >
		<button type="submit">Nueva Tecnologia</button>
	</form:form>
</table>
