<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MostrarDepartamentos</title>
<style>
	table{
		background-color:lightblue;
	}
	th{
		background-color:lightgreen;
	}
</style>
</head>
<body>
	<h2>Mostrando Departamentos...</h2>
	<!--  ${mosList} -->
	
	<table border="1">
            <tr>
                <th style="width:  250px;">Nombre</th>
                <th style="width: 250px;">Descripcion</th>
                <th style="width:  250px;">Tecnologias</th>
                <th style="width: 250px;">Empleados</th>
                
            </tr>
            
            <c:forEach var="departamento" 
                       items="${departamentos}"
                       varStatus="status">
                <tr>
                    <td>${departamento.nombre}</td>
                    <td>${departamento.descripcion}</td>
                    <td>
						<c:forEach items="${ departamento.tecnologias }" var="tecnologia" varStatus="status" >
						${ tecnologia }<c:if test="${ not status.last }">, </c:if>
						</c:forEach>
					</td>
					<td>
						<c:forEach items="${ departamento.empleados }" var="empleado" varStatus="status" >
						${ empleado }<c:if test="${ not status.last }">, </c:if>
						</c:forEach>
					</td>
				</tr>
            </c:forEach>
        </table>
	
	<a href="/getronics-spring-mvc-webapp/departamento">Volver</a>
</body>
</html>