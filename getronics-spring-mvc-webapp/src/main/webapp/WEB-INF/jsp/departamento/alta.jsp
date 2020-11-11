<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<spring:url value="/departamento/chAlta/${departamento.id}" var="url"></spring:url>

<form:errors path="*"/>
<div class="row justify-content-center">
	<div class="col-6">
		<form:form action="${ url }" modelAttribute="departamento">
			<div class="form-group">
				<h2>editar fecha de alta de: ${departamento.nombre}</h2>
				<input class="form-control" type="date" id="date" name="date">
				<form:button class="btn btn-primary form-control" value="submit">Guardar</form:button>
			</div>
		</form:form>
	</div>
</div>

<script type="text/javascript">
	var dateControl = document.querySelector('input[type="date"]');
	var d= new Date();
	var m=d.getMonth()+1;
	dateControl.value=d.getFullYear()+"-"+m+"-"+d.getDate();
	
	
</script>