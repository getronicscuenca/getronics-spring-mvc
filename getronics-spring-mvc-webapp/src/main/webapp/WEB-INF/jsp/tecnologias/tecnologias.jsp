<%@ include file="../common/taglibs.jsp"%>

<spring:url value="/tecnologias/new" var="url"></spring:url>
<spring:message code="tecnologias.new.title" var="insertTitle" />
<spring:message code="tecnologias.update.title" var="updateTitle" />

<c:choose>
	<c:when test="${tecnologias.id == null}">
		<c:set value="${ insertTitle }" var="title" />
	</c:when>
	<c:otherwise>
		<c:set value="${ updateTitle }" var="title" />
	</c:otherwise>
</c:choose>
<div class="row justify-content-center mt-4">
	<div class="col-md-8">
		<div class="card card-sm">
			<form:form modelAttribute="tecnologias" action="${ url }"
				cssClass="form-horizontal">
				<fieldset>
					<legend class="text-center header">${ title }</legend>
					<form:hidden path="id" />
					<div class="row justify-content-center">
						<div class="form-group col-md-11">
							<label for="nombre"><spring:message code="tecnologias.nombre"></spring:message></label>

							<form:input path="nombre" cssClass="form-control" />
							<form:errors path="nombre" cssClass="text-danger" />
						</div>
						<br>
						<div class="form-group col-md-11">
							<label for="descripcion"><spring:message
									code="tecnologias.descripcion"></spring:message></label>
							<form:input path="descripcion" cssClass="form-control" />
							<form:errors path="descripcion" cssClass="text-danger " />
						</div>
						<br>
						<br>
						<div class="form-group col-md-11 text-center">
							<form:button value="submit" class="btn btn-outline-success"><spring:message code="common.button.send"></spring:message></form:button>
						</div>
					</div>
				</fieldset>
			</form:form>
		</div>
	</div>
</div>