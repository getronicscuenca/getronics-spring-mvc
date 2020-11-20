<%@ include file="../common/taglibs.jsp"%>

<spring:url value="/j_spring_security_check" var="url"></spring:url>

<div class="row justify-content-center mt-5">
	<div class="col-md-8">
		<div class="card card-sm">
			<form name="login" action="${ url }" method="post"
				class="form-horizontal">
				<fieldset>
					<legend class="text-center header">
						<spring:message code="login.title"></spring:message>
					</legend>
					<div class="row justify-content-center">

						<div class="form-group col-md-11">
							<label for="j_username"><spring:message
									code="login.username"></spring:message></label> 
							<input type="text" class="form-control"
								id="j_username" name="j_username" />
						</div>
						<div class="form-group col-md-11">
							<label for="j_password"><spring:message
									code="login.password"></spring:message></label> 
							<input type="password" class="form-control"
								id="j_password" name="j_password" />
						</div>

						<div class="form-group col-md-11">
							<button type="submit" class="btn btn-info">
								<spring:message code="login.button.send"></spring:message>
							</button>
						</div>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
</div>
