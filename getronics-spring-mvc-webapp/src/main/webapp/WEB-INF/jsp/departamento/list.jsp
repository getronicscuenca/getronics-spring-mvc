<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>	
			<th>Id dept</th>
			<th>Nombre dept</th>
		</thead>
		<tbody>
			<c:forEach items="${ departamentos }" var="departamento">
				<tr>
					<td>${ departamento.id }</td>
					<td>${ departamento.nombre }</td>
					<td>${ departamento.fecha }</td>
					<td>
						<a href="departamento/delete/${ departamento.id }">Eliminar</a>
						<a href="departamento/update/${ departamento.id }">Actualizar</a>
					</td>
				</tr>
			</c:forEach>
			
		</tbody>
	</table>
	
	<form:form action="departamento" method="post">
		<button type="submit">Añadir departamento</button>
	</form:form>
</body>
</html>