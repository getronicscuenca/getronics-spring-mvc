<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isErrorPage = "true" %>

<spring:url value="/departamento/chAlta/${departamento.id}" var="url"></spring:url>

<form:errors path="*"/>

<form:form action="${ url }" modelAttribute="departamento">

	<h1>editar fecha de alta de: ${departamento.nombre}</h1>

	<input type="date" id="date" name="date">
	
	<form:button value="submit">Guardar</form:button><br>
	<c:if test="${errores != null}">
		<p>${errores}<p>
	</c:if>
	
</form:form>
<script type="text/javascript">
	var dateControl = document.querySelector('input[type="date"]');
	var d= new Date();
	var m=d.getMonth()+1;
	dateControl.value=d.getFullYear()+"-"+m+"-"+d.getDate();
	
	
</script>