<%@ include file="../common/taglibs.jsp"%>

<spring:url value="/departamento/new" var="url"></spring:url>
<spring:message code="departamento.new.title" var="insertTitle" />
<spring:message code="departamento.update.title" var="updateTitle" />


<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
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

<form:errors path="*" cssClass="errorblock" element="div" />

<div class="row justify-content-center mt-5">
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
							<form:input path="nombre" cssClass="form-control" required="required" minlength="3" maxlength="20" pattern="[A-Z][A-z]{2,20}" title="3 a 20 letras, sin números, empieza por mayúscula" />
						</div>
						<div class="form-group col-md-11">
							<label for="desc"><spring:message
									code="departamento.desc"></spring:message></label>
							<form:input path="desc" cssClass="form-control" required="required" minlength="3" maxlength="25" pattern="[A-z]{3,25}" title="3 a 25 letras, sin números"/>
						</div>
						
						<div class="form-group col-md-11">
							<label><spring:message code="departamento.jefe"></spring:message></label>
							<div class="custom-control custom-radio">
								<form:radiobuttons path="id"
									items="${jefe}" itemLabel="nombre" itemValue="id" required="required" />
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
