<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<h1>${ departamento.nombre }</h1>

<spring:url value="/departamento/alta/${ departamento.id }" var="url2"></spring:url>
<p>fecha de creacion: ${ departamento.alta }
	<form:form action="${ url2 }" >
		<button type="submit">editar fecha</button>
	</form:form>
</p>
<table>
	<thead>
		<th>empleados:</th>
	</thead>	

<tbody>
	<c:forEach items="${ departamento.empleados }" var="emple">
		<tr>
			<td>${ emple.nombre }</td>
					
		</tr>
	</c:forEach>

</tbody>
</table>



<p>${ departamento.desc }</p>

<spring:url value="/departamento" var="url"></spring:url>
<a href="${ url }">Volver a departamentos</a>