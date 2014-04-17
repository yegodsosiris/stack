<%@ include file="../include/head.jsp" %>

		<h2>Settings</h2>
		<div class="btn-group">
			<a href="${contextpath}/newSetting" class="btn btn-primary">New</a>
		</div>
		<%@ include file="modal/confirm-delete.jsp" %>
		<table class="table table-striped table-hover">
			<tr>
				<th width="1">Name</th>
				<th>Value</th>
				<th>Description</th>
				<th></th>
			</tr>
			<c:forEach items="${settings}" var="setting">
				<tr>
					<td><c:out value="${setting.name}"/></td>
					<td><c:out value="${setting.value}"/></td>
					<td><c:out value="${setting.description}"/></td>
					<td>
						<div class="btn-group">
							<a class="btn btn-default" href="${contextpath}/admin/editSetting?id=${setting.id}">Edit</a>
							<a class="btn btn-default delete" data-toggle="modal" data-target="#deleteConfigModal" data-id="${setting.id}">Delete</a>
						</div>
					</td>
				</tr>
			</c:forEach>
		
		</table>
		
<%@ include file="../include/tail.jsp" %>
