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
<style type="text/css">
	table {
		border: 2px solid;
		padding: 5px;
		border-collapse: collapse;
	}
	
	thead {
		background-color: #A1F3FB;
	}
	
	td {
		padding: 3px;
		border: 2px solid;
		text-align: center;
		background-color: #EDFDFF;
	}
	
	th{
		padding: 5px;
	}
	
	button {
		margin-top: 5px;
		padding: 5px 20px;
		width: 20%;
	}
	
	button:hover {
		margin-top: 5px;
		padding: 5px 20px;
		font-weight: bold;
		font-size: 12.5px;
		border: 3px solid;
		border-color: grey;
		border-radius: 5px;
	}
	
</style>
</head>
<body>
	<h1>LISTADO DEPARTAMENTOS</h1>
	<table>
		<thead>	
			<th>Id dept</th>
			<th>Nombre dept</th>
			<th>Fecha</th>
			<th>Opciones</th>
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
						<a href="departamento/visualizar/${ departamento.id }">ver</a>
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