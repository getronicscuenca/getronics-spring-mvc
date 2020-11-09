<%@ include file="../common/taglibs.jsp"%>

<spring:url value="/empleado/new" var="url"></spring:url>
<spring:message code="empleado.new.title" var="insertTitle" />
<spring:message code="empleado.update.title" var="updateTitle" />
<c:choose>
	<c:when test="${ alumno.id == null}">
		<c:set value="${ insertTitle }" var="title" />
	</c:when>
	<c:otherwise>
		<c:set value="${ updateTitle }" var="title" />
	</c:otherwise>
</c:choose>

<div class="row justify-content-center mt-5">
	<div class="col-md-8">
		<div class="card card-sm">
			<form:form modelAttribute="empleado" action="${ url }"
				cssClass="form-horizontal">

				<fieldset>
					<legend class="text-center header">${ title }</legend>
					<form:hidden path="id" />
					<div class="row justify-content-center">
						<div class="form-group col-md-11">
							<label for="nombre"><spring:message
									code="empleado.nombre"></spring:message></label>
							<form:input path="nombre" cssClass="form-control" required="required" minlength="3" maxlength="15" pattern="[A-Z][a-z]{2,15}" title="3 a 15 letras, sin números, empieza por mayúscula" />
						</div>
						<div class="form-group col-md-11">
							<label for="nombre"><spring:message
									code="empleado.apellido1"></spring:message></label>
							<form:input path="apellido1" cssClass="form-control" required="required" minlength="3" maxlength="15" pattern="[A-Z][a-z]{2,15}" title="3 a 15 letras, sin números, empieza por mayúscula"/>
						</div>
						<div class="form-group col-md-11">
							<label for="nombre"><spring:message
									code="empleado.apellido2"></spring:message></label>
							<form:input path="apellido2" cssClass="form-control" required="required" minlength="3" maxlength="15" pattern="[A-Z][a-z]{2,15}" title="3 a 15 letras, sin números, empieza por mayúscula"/>
						</div>
						<div class="form-group col-md-11">
							<label><spring:message code="empleado.departamento"></spring:message></label>
							<div class="custom-control custom-radio">
								<form:radiobuttons path="idDepartamento"
									items="${departamentos}" itemLabel="nombre" itemValue="id" required="required" />
							</div>
						</div>
						<div class="form-group col-md-11">
							<form:button value="submit" class="btn btn-info"><spring:message code="common.button.send"></spring:message></form:button>
						</div>

					</div>
				</fieldset>
			</form:form>
		</div>
	</div>
</div>

