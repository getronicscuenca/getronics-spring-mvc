<%@ include file="../common/taglibs.jsp"%>

<h3 class="mt-5"><spring:message code="departamento.list.title"></spring:message> </h3>
<table>
	<thead>
		<th>Id</th>
		<th> <spring:message code="departamento.nombre"></spring:message></th>
		<th> <spring:message code="departamento.empleado"></spring:message></th>
		<th> <spring:message code="departamento.options"></spring:message></th>
	</thead>
	<tbody>
		<c:forEach items="${ departamentos }" var="departamento">
			<tr>
				<td>${ departamento.id }</td>
				<td>${ departamento.nombre }</td>
				 <td>${departamento.nombreEmpleado }</td> 
				<td>
					<a href="<spring:url value="/departamento/delete/${ departamento.id }"></spring:url>">eliminar</a>
					<a href="<spring:url value="/departamento/update/${ departamento.id }"></spring:url>">actualizar</a>
					<a href="<spring:url value="/departamento/ver/${ departamento.id }"></spring:url>">ver</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
	<form:errors path="nombre"/>
	<form:errors path="desc"/>
	<spring:url value="/departamento" var="url"></spring:url>
	<form:form action="${ url }" >
		<button type="submit"><spring:message code="departamento.options.add"></spring:message></button>
	</form:form>
</table>