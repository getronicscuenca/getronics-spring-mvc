<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<spring:url value="/departamento/new" var="url"></spring:url>
<spring:message code="departamento.new.title" var="insertTitle" />
<spring:message code="departamento.update.title" var="updateTitle" />


<style>
.error {
	color: #ff0000;
}
</style>

<c:choose>
	<c:when test="${departamento.id == null}">
		<c:set value="${ insertTitle }" var="title" />
	</c:when>
	<c:otherwise>
		<c:set value="${ updateTitle }" var="title" />
	</c:otherwise>
</c:choose>

<div class="row justify-content-center mt-4">
	<div class="col-md-8">
		<div class="card card-sm">
			<form:form modelAttribute="departamento" action="${ url }"
				cssClass="form-horizontal">
				<fieldset>
					<legend class="text-center header">${ title }</legend>
					<form:hidden path="id" />
					<div class="row justify-content-center">
						<div class="form-group col-md-11">
							<label for="nombre"><spring:message
									code="departamento.nombre"></spring:message></label>

							<form:input path="nombre" cssClass="form-control" />
							<form:errors path="nombre" cssClass="error" />
						</div>

						<br>
						<div class="form-group col-md-11">
							<label for="desc"><spring:message
									code="departamento.desc"></spring:message></label>
							<form:input path="desc" cssClass="form-control" />
							<form:errors path="desc" cssClass="error " />
						</div>
						<br>
						<br>

						<div class="form-group col-md-11 mt-3">
							<label><spring:message code="departamento.empleado"></spring:message></label>
							<form:select path="idEmpleado" cssClass="form-group">
								<form:options items="${empleados}" itemLabel="nombre"
									itemValue="id" />
							</form:select>
							<form:errors path="idEmpleado" cssClass="error" />
						</div>
						<div class="form-group col-md-11 text-center">
							<form:button value="submit" class="btn btn-info"><spring:message code="common.button.send"></spring:message></form:button>
						</div>
					</div>
				</fieldset>
			</form:form>
		</div>
	</div>
</div>