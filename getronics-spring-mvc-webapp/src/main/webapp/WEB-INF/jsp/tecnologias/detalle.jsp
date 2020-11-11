<%@ include file="../common/taglibs.jsp"%>
<div class="row justify-content-center mt-4">
	<div class="col-md-6">
		<div class="card card-sm">
			<div class="text-center">
				<h1 class="mt-4 mb-5">${ tecnologia.nombre }</h1>
				<h4 class="mb-3 text-muted">${ tecnologia.descripcion }</h4> 
				
				<div class="row justify-content-center clearfix ">
						<spring:url value="/tecnologias" var="url"></spring:url>
						<a href="${ url }"> <svg width="3em" height="3em"
								viewBox="0 0 16 16" class="bi bi-arrow-left-circle-fill"
								fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  									<path fill-rule="evenodd"
									d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-4.5.5a.5.5 0 0 0 0-1H5.707l2.147-2.146a.5.5 0 1 0-.708-.708l-3 3a.5.5 0 0 0 0 .708l3 3a.5.5 0 0 0 .708-.708L5.707 8.5H11.5z" />
								</svg>
						</a>
				</div>
			</div>
		</div>
	</div>
</div>