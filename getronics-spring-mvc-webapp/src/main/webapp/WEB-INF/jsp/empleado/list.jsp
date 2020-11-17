<%@ include file="../common/taglibs.jsp"%>

<h3 class="mt-5"><spring:message code="empleado.list.title"></spring:message> </h3>
<div class="table-responsive">
	<table class="table table-striped table-info">
		<thead class="thead-light">
			<th scope="col"><spring:message code="empleado.code"></spring:message> </th>
			<th scope="col"><spring:message code="empleado.nombre"></spring:message></th>
			<th scope="col"><spring:message code="empleado.apellido1"></spring:message></th>
			<th scope="col"><spring:message code="empleado.apellido2"></spring:message></th>
			<th scope="col"><spring:message code="empleado.departamento"></spring:message></th>
			<th scope="col"><spring:message code="empleado.fechaAlta"></spring:message></th>
			<th scope="col"><spring:message code="empleado.fechaModificacion"></spring:message></th>
			<th scope="col"><spring:message code="empleado.fechaBaja"></spring:message></th>
			<th scope="col"><spring:message code="empleado.activo"></spring:message></th>
			<th scope="col"><spring:message code="empleado.options"></spring:message></th>
		</thead>
		<tbody>

			<c:forEach items="${ empleados }" var="empleado">
				<tr>
					<td>${empleado.id}</td>
					<td>${empleado.nombre}</td>
					<td>${empleado.apellido1}</td>
					<td>${empleado.apellido2}</td>
					<td>${empleado.departamento}</td>
					<td><fmt:formatDate pattern="dd/MM/yyyy" value="${empleado.fechaAlta}" /></td>
					<td><fmt:formatDate pattern="dd/MM/yyyy" value="${empleado.fechaModificacion}" /></td>
					<td><fmt:formatDate pattern="dd/MM/yyyy" value="${empleado.fechaBaja}" /></td>
					<td>
					<c:if test="${empleado.activo}"><span class="material-icons text-success">check_circle_outline</span></c:if>
					<c:if test="${! empleado.activo}"><span class="material-icons text-danger">highlight_off</span></c:if>
					</td>
					<td>
						<a class="mr-2"
						href="<spring:url value="/empleado/delete/${ empleado.id }" ></spring:url>">
							<span class="material-icons">delete</span>
						</a>
						<a class="ml-2"
						href="<spring:url value="/empleado/update/${ empleado.id }" ></spring:url>">
							<span class="material-icons">edit</span>
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