<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<spring:url value="/departamento" var="url"></spring:url>
<spring:url value="/departamento/alta/${ departamento.id }" var="url2"></spring:url>
<style>
	.row > div{
		background: #f2f2f2;
		margin: 10p 0;
	}
</style>


<div class="container">
	<div class="row">
		<div class="col">
			<h1>${ departamento.nombre }</h1>
		</div>
	</div>
	<div class="row">
	
		<div class="col">
			<p>
			fecha de creacion: ${ departamento.alta }
				<form:form action="${ url2 }" method="GET">
					<button type="submit">editar fecha</button>
				</form:form>
			</p>
		</div>
		
		<div class="col">
			<p>Jefe: ${ departamento.jefe.getNombre()}</p>
		</div>
		
		<div class="col">
			<table>
			<thead>
				<th>empleados:</th>
			</thead>
		
			<tbody>
				<c:forEach items="${ departamento.empleados }" var="emple">
					<tr>
						<td>${ emple.nombre }</td>
						<td><a
							href="/getronics-spring-mvc-webapp/departamento/ascenso/${ departamento.id }/${ emple.id }">ascender</a></td>
		
					</tr>
				</c:forEach>
		
			</tbody>
			</table>
		</div><!-- col  -->
		
		<div class="col">
			<table>
			<thead>
				<th>Tecnologias:</th>
			</thead>
			<tbody>
				<c:forEach items="${ departamento.tecnologias }" var="tecnologia">
					<tr>
						<td>${ tecnologia.getNombre() }</td>
					</tr>
				</c:forEach>
			</tbody>
			</table>
		</div>
		
		<div class="col-12">
			<p>descripcion: <br>${ departamento.desc }</p>
			
		</div>	
	</div>
		
</div>
	
	
	
	
	
	
	
	
	
</div>



