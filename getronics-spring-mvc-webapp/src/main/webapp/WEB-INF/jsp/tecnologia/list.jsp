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
							<span class="material-icons">delete</span>
						</a>
						<a class="ml-2"
						href="<spring:url value="/tecnologia/update/${ tecnologia.id }" ></spring:url>">
							<span class="material-icons">edit</span>
						</a>
					</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
</div>

<spring:url value="/tecnologia" var="url"></spring:url>
<form:form action="${ url }" cssClass="row justify-content-end mr-5">
	<button type="submit" class="btn btn-info">
	
		<spring:message code="empleado.options.add"></spring:message>
	</button>
</form:form>