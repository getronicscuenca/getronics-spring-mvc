<%@ include file="../common/taglibs.jsp"%>

<h3 class="mt-5">
	<spring:message code="departamento.list.title"></spring:message>
</h3>
<div class="table-responsive">
	<table class="table table-striped table-info">
		<thead class="thead-light">
			<th scope="col"><spring:message code="departamento.code"></spring:message></th>
			<th scope="col"><spring:message code="departamento.nombre"></spring:message></th>
			<th scope="col"><spring:message code="departamento.empleado"></spring:message></th>
			<th scope="col"><spring:message code="departamento.options"></spring:message></th>
		</thead>
		<tbody>
			<c:forEach items="${ departamentos }" var="departamento">
				<tr>
					<td>${ departamento.id }</td>
					<td>${ departamento.nombre }</td>
					<td>${departamento.nombreEmpleado }</td>
					<td><a class="mr-2"
						href="<spring:url value="/departamento/delete/${ departamento.id }" ></spring:url>">
							<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-trash" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
							  <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
							  <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
							</svg>
							</a>
						<a class="ml-2"
						href="<spring:url value="/departamento/update/${ departamento.id }" ></spring:url>">
							<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-pencil-square" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
							  <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456l-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
							  <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/>
							</svg>
						</a>
						<a class="ml-2"
						href="<spring:url value="/departamento/ver/${ departamento.id }"></spring:url>">
						<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-info-circle-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  						<path fill-rule="evenodd" d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm.93-9.412l-2.29.287-.082.38.45.083c.294.07.352.176.288.469l-.738 3.468c-.194.897.105 1.319.808 1.319.545 0 1.178-.252 1.465-.598l.088-.416c-.2.176-.492.246-.686.246-.275 0-.375-.193-.304-.533L8.93 6.588zM8 5.5a1 1 0 1 0 0-2 1 1 0 0 0 0 2z"/>
						</svg>
						</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
		<spring:url value="/departamento" var="url"></spring:url>
		<form:form action="${ url }" cssClass="row justify-content-center">
			<button type="submit" class="btn btn-info" cssClass="">
				<spring:message code="departamento.options.add"></spring:message>
			</button>
		</form:form>