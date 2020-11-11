<%@ include file="../common/taglibs.jsp"%>


<spring:url value="/departamento/chAlta/${departamento.id}" var="url"></spring:url>

<div class="row justify-content-center mt-5">

	<form:errors path="*" />
	<div class="text-center">
		<form:form action="${ url }" modelAttribute="departamento">
			<div class="mb-5">
			<h2>Departamento: ${departamento.nombre}</h2>
				<h3 class="text-muted"><spring:message code="modificar.fecha"></spring:message></h3>
				
			</div>
			<input type="date" id="date" name="date" class="mb-2"><br>
			<form:button type="submit" class="btn btn-outline-success btn-md"><spring:message code="modificar.alta"></spring:message></form:button>
		</form:form>
	</div>
</div>
<script type="text/javascript">
	var dateControl = document.querySelector('input[type="date"]');
	var d = new Date();
	var m = d.getMonth() + 1;
	dateControl.value = d.getFullYear() + "-" + m + "-" + d.getDate();
</script>