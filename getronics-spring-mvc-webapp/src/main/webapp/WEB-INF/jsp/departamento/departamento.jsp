<%@ include file="../common/taglibs.jsp"%>

<spring:url value="/departamento/new" var="url"></spring:url>
<spring:message code="departamento.new.title" var="insertTitle"/>
<spring:message code="departamento.update.title" var="updateTitle"/> 


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
		<c:set value="${ insertTitle }" var="title"/>
	</c:when>
	<c:otherwise>
		<c:set value="${ updateTitle }" var="title"/>
	</c:otherwise>
</c:choose>
   

<div class="row justify-content-center mt-5">
	<div class="col-md-8">
		<div class="card card-sm">
			<form:errors path="*" cssClass="errorblock" element="div" />
	
				<form:form modelAttribute="departamento" action="${ url }" cssclass="form-horizontal">
					
					<fieldset>
						<legend class="text-center header">${ title }</legend>
						<form:hidden path="id"/>
						<div class="row justify-content-center">
							<div class="form-group col-md-11">
								<label for="nombre"><spring:message code="departamento.nombre"></spring:message></label>
								<form:errors path="nombre" cssClass="error" />
								<form:input path="nombre" cssClass="form-control"/>
							</div>
						
						
							<div class="form-group col-md-11">
								<label for="descripcion"><spring:message code="departamento.desc"></spring:message></label>
								<form:errors path="desc" cssClass="error" />
								<form:input path="desc" cssClass="form-control"/>
							</div>
						
							<div class="form-group col-md-11">
								<label><spring:message code="departamento.tecnologia"></spring:message></label>
								<div class="custom-control custom-radio">
									<form:checkboxes path="tecnologias" items="${tecnologias}" itemLabel="nombre" itemValue="id" />
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







