<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<spring:url value="/departamento" var="url"></spring:url>
<spring:url value="/departamento/alta/${ departamento.id }" var="url2"></spring:url>
<style>
	.prueba{
		background: #f2f2f2;
		
	}

</style>


<div class="container">
	<div class="row text-center">
		<div class="col">
			<h1>${ departamento.nombre }</h1>
		</div>
	</div>
	<div class="row">
	
		<div class="col prueba mr-1">
			<p>
			fecha de creacion: ${ departamento.alta }
				<form:form action="${ url2 }" method="GET">
					<button type="submit">editar fecha</button>
				</form:form>
			</p>
		</div>
		
		<div class="col prueba mr-1">
			<p>Jefe: ${ departamento.jefe.getNombre()}</p>
		</div>
		
		<div class="col prueba mr-1">
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
		
		<div class="col prueba">
			<table>
			<thead>
				<th>Tecnologias:</th>
			</thead>
			<tbody>
				<c:forEach items="${ departamento.tecnologias }" var="tecnologia">
					<tr>
						<td>${ tecnologia.getNombre() }</td>
						<td>
							<a class="mr-1" href="<spring:url value="/departamento/deleteTecnologia/${ tecnologia.getId() }/${ departamento.id }"></spring:url>"><svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-trash" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
								  <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
								  <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
								</svg>
						</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
			</table>
		</div>
		
		<div class="col-12 text-center">
			<p>descripcion: <br>${ departamento.desc }</p>
			
		</div>	
	</div>
		
</div>
	
	
	
	
	
	
	
	
	
</div>



