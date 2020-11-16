<%@ include file="../common/taglibs.jsp"%>
<spring:url value="/departamento/alta/${ departamento.id }" var="url2"></spring:url>

<div class="row justify-content-center mt-4">
	<div class="col-md-6">
		<div class="card card-sm">
			<div class="text-center">
				<h1 class="mt-4 mb-5">${ departamento.nombre }</h1>
				<h4 class="mb-3 text-muted">${ departamento.desc }</h4>
				<br>
				<p class="text-muted">Fecha de creacion: ${ departamento.alta }
				</p>
				<br> <br>
				<div class="text-center">
					<h3 class="text-muted">
						<spring:message code="tecnologias.list.title.departamento"></spring:message>
					</h3>
					<br>
					<ul>
						<c:forEach items="${ tecnologias }" var="tecnologia">
						<spring:url value="/departamento/borrarTecnologia/${tecnologia.id }/${ departamento.id }" var="urlTecnologia"></spring:url>
							<form:form action="${ urlTecnologia }">
								<li type="disc">${tecnologia.nombre}

									<button type="submit" class="btn btn-sm">
										<svg width="1.5em" height="1.5em" viewBox="0 0 16 16"
											class="bi bi-trash" fill="currentColor"
											xmlns="http://www.w3.org/2000/svg">
							 	 <path
												d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z" />
							 	 <path fill-rule="evenodd"
												d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z" />
								</svg>
									</button>
								</li>
							</form:form>
						</c:forEach>
					</ul>
				</div>
				<div class="row justify-content-center clearfix ">
					<div class="float-left mr-5">
						<spring:url value="/departamento" var="url"></spring:url>
						<a href="${ url }"> <svg width="3em" height="3em"
								viewBox="0 0 16 16" class="bi bi-arrow-left-circle-fill"
								fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  									<path fill-rule="evenodd"
									d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-4.5.5a.5.5 0 0 0 0-1H5.707l2.147-2.146a.5.5 0 1 0-.708-.708l-3 3a.5.5 0 0 0 0 .708l3 3a.5.5 0 0 0 .708-.708L5.707 8.5H11.5z" />
								</svg>
						</a>
					</div>
					<div class="float-left">
						<form:form action="${ url2 }">
							<button type="submit" class="btn btn-primary btn-lg">
								<spring:message code="modificar.fecha"></spring:message>
							</button>
						</form:form>
					</div>

				</div>
			</div>
		</div>
	</div>
</div>