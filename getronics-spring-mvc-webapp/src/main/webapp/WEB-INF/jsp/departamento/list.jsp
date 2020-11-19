<%@ include file="../common/taglibs.jsp"%>


<h3 class="mt-5"><spring:message code="departamento.list.title"></spring:message> </h3>
<div class="table-responsive">
<table class="table table-striped table-info">
	<thead class="thead-light">
		<th scope="col"><spring:message code="departamento.code"></spring:message></th>
		<th scope="col"><spring:message code="departamento.nombre"></spring:message></th>
		<th scope="col"><spring:message code="departamento.tecnologia"></spring:message></th>
		<th scope="col"><spring:message code="departamento.empleados"></spring:message></th>
		<th scope="col"><spring:message code="departamento.options"></spring:message></th>
	</thead>
	<tbody>
		<c:forEach items="${ departamentos }" var="departamento">
			<tr>
				<td>${ departamento.id }</td>
				<td>${ departamento.nombre }</td>
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
				<td><a
					href="<spring:url value="/departamento/delete/${ departamento.id }"></spring:url>"><span class="material-icons">delete</span></a>
					<a
					href="<spring:url value="/departamento/update/${ departamento.id }"></spring:url>"><span class="material-icons">edit</span></a>
					<a
					href="<spring:url value="/departamento/ver/${ departamento.id }"></spring:url>"><span class="material-icons">zoom_out_map</span></a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
	<form:errors path="nombre" />
	<form:errors path="descripcion" />
	

	</table>
</div>
<spring:url value="/departamento" var="url"></spring:url>
	<form:form action="${ url }" cssClass="row justify-content-end mr-5">
		<button type="submit" class="btn btn-info">
			<spring:message code="departamento.options.add"></spring:message>
		</button>
		&nbsp;
		<a href="<spring:url value="/index.jsp"></spring:url>" class="btn btn-info">volver</a>
	</form:form>
	