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

<div class="row justify-content-center mt-5">
	<div class="col-md-8">
		<div class="card card-sm">

			<form:form modelAttribute="departamento" action="${ url }"
				cssClass="form-horizontal">
				<fieldset>
					<legend class="text-center header">${ title }</legend>
					<form:hidden path="id" />
					<div class="row justify-content-center">

						<form:errors path="*" cssClass="errorblock" element="div" />
						
						<div class="form-group col-md-11">
							
							<spring:message code="departamento.nombre"></spring:message>
							<form:errors path="nombre" cssClass="error"  />
							<br>
							<form:input path="nombre" cssClass="form-control" required="required" minlength="3" />
						</div>
						<div class="form-group col-md-11">
							<spring:message code="departamento.descripcion"></spring:message>
							<form:errors path="descripcion" cssClass="error" />
							<br>
							<form:input path="descripcion" cssClass="form-control" required="required" minlength="3" />
						</div>
						
						
						<div class="input-group mb-3 col-md-11">
						  <label for="selectedTecnologias"><spring:message
									code="departamento.tecnologia"></spring:message></label>
						  <div class="w-100"></div>
						  <div class="input-group-prepend">
						    	<form:checkboxes items="${ tecnologias }" path="selectedTecnologias" itemLabel="value" itemValue="key" element="div class=\"input-group-text\"" cssClass="mr-2" required="required"/>
						  </div>
						</div>
						
						<div class="form-group col-md-11">
							<form:button value="submit" class="btn btn-info">
								<spring:message code="common.button.send"></spring:message>
							</form:button>
						</div>
					</div>
				</fieldset>
			</form:form>
		</div>
	</div>
</div>