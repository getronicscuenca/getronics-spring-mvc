<%@ include file="../common/taglibs.jsp"%>

<spring:url value="/departamento" var="url"></spring:url>

<spring:message code="departamento.detail.title" var="detailTitle" />


<div class="row justify-content-center mt-5">
	<div class="col-md-8">
		<div class="card card-sm">

			<form:errors path="*" cssClass="errorblock" element="div" />


			<form:form modelAttribute="departamento" action="${ url }"
				cssClass="form-horizontal">
				<fieldset>
					<legend class="text-center header">${ detailTitle }</legend>

					<div class="row justify-content-center">

						<form:errors path="*" cssClass="errorblock" element="div" />
						<div class="form-group col-md-11">
							<form:hidden path="id" />
							<spring:message code="departamento.nombre"></spring:message>
							<form:errors path="nombre" cssClass="error" />
							<br>
							<form:input path="nombre" cssClass="form-control" disabled="true"/>
						</div>
						<div class="form-group col-md-11">
							<spring:message code="departamento.descripcion"></spring:message>
							<form:errors path="descripcion" cssClass="error" />
							<br>
							<form:input path="descripcion" cssClass="form-control" disabled="true"/>
						</div>
						
						
						<div class="input-group mb-3 col-md-11">
						  <label for="selectedTecnologias"><spring:message
									code="departamento.tecnologia"></spring:message></label>
						  <div class="w-100"></div>
						  <ul class="">
						  		<c:forEach items="${ departamento.tecnologias }" var="tecnologia">
						  			<li>${ tecnologia }</li>
						  		</c:forEach>
						  </ul>
						</div>
						
						<div class="form-group col-md-11">
							<a href="${ url }" class="btn btn-info">Volver a departamentos</a>
						</div>
					</div>
				</fieldset>
			</form:form>
			
		</div>
	</div>
</div>

