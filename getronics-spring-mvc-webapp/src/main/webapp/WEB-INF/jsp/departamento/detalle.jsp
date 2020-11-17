<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<div class="row justify-content-center mt-3 mb-5">
	<div class="col-11">
		<h1 class="text-center">Departamento ${ departamento.nombre }</h1>

		<spring:url value="/departamento/alta/${ departamento.id }" var="url2"></spring:url>
		<p>
			fecha de creacion: ${ departamento.alta }
			<form:form action="${ url2 }">
				<button class="btn btn-primary" type="submit">editar fecha</button>
			</form:form>
		</p>
		

		<h4>Nombre del departamento</h4>
		<p>${ departamento.desc }</p>
		
		<h4>tecnologias</h4>
		<ul class="list-group">
			<c:forEach items="${tecnologias }" var="tecnologia">
				<li class="list-group-item">${tecnologia.nombre }<a class="btn btn-danger float-right" href="./eliminar/tecnologia/${departamento.id}/${tecnologia.id }">Borrar</a></li>
			</c:forEach>
		</ul>
		<a href="/getronics-spring-mvc-webapp/departamento" class="btn btn-primary mt-2">Volver a departamentos</a>
	</div>
</div>
