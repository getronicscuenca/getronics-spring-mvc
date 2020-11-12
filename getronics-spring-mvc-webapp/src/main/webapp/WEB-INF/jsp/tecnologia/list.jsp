<%@ include file="../common/taglibs.jsp"%>

<h3 class="mt-5"><spring:message code="tecnologia.list.title"></spring:message> </h3>
<div class="table-responsive">
	<table class="table table-striped table-info">
		<thead class="thead-light">
			<th scope="col"><spring:message code="tecnologia.code"></spring:message> </th>
			<th scope="col"><spring:message code="tecnologia.nombre"></spring:message></th>
			<th scope="col"><spring:message code="tecnologia.descripcion"></spring:message></th>
			<th scope="col"><spring:message code="tecnologia.options"></spring:message></th>
		</thead>
		<tbody>

			<c:forEach items="${ tecnologias }" var="tecnologia">
				<tr>
					<td>${tecnologia.id}</td>
					<td>${tecnologia.nombre}</td>
					<td>${tecnologia.descripcion}</td>
					<td>
						<a class="mr-2"
						href="<spring:url value="/tecnologia/delete/${ tecnologia.id }" ></spring:url>">
							<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-trash" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
							  <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
							  <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
							</svg>
						</a>
						<a class="ml-2"
						href="<spring:url value="/tecnologia/update/${ tecnologia.id }" ></spring:url>">
							<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-pencil-square" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
							  <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456l-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
							  <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/>
							</svg>
						</a>
					</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
</div>

<spring:url value="/empleado" var="url"></spring:url>
<form:form action="${ url }" cssClass="row justify-content-end mr-5">
	<button type="submit" class="btn btn-info">
	
		<spring:message code="empleado.options.add"></spring:message>
	</button>
</form:form>