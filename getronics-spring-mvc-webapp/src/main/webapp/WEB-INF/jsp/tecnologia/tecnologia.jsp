<%@ include file="../common/taglibs.jsp"%>

<spring:url value="/tecnologia/new" var="url"></spring:url>
<spring:message code="tecnologia.new.title" var="insertTitle" />
<spring:message code="tecnologia.update.title" var="updateTitle" />


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
	<c:when test="${ tecnologia.id == null}">
		<c:set value="${ insertTitle }" var="title" />
	</c:when>
	<c:otherwise>
		<c:set value="${ updateTitle }" var="title" />
	</c:otherwise>
</c:choose>

<div class="row justify-content-center mt-5">
	<div class="col-md-8">
		<div class="card card-sm">
			
			<form:form modelAttribute="tecnologia" action="${ url }"
				cssClass="form-horizontal">
				<fieldset>
					<legend class="text-center header">${ title }</legend>
					<form:hidden path="id" />
					<div class="row justify-content-center">
						
						<form:errors path="*" cssClass="errorblock" element="div" />
						
						<div class="form-group col-md-11">
							<label for="nombre"><spring:message
									code="tecnologia.nombre"></spring:message></label>
							<form:input path="nombre" cssClass="form-control" required="required" minlength="3" />
						</div>
						<div class="form-group col-md-11">
							<label for="descripcion"><spring:message
									code="tecnologia.descripcion"></spring:message></label>
							<form:input path="descripcion" cssClass="form-control" required="required" minlength="3" />
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

