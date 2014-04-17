<%@ include file="../include/head.jsp" %>
		<h2>Manage Users</h2>
		
		<div class="btn-group">
			<a href="${contextpath}/admin/newUser" class="btn btn-primary">New</a>
		</div>

		<%@ include file="modal/confirm-delete.jsp" %>
		
		<table class='table table-striped table-hover'>
			<tr>
				<th>Email</th>
				<th>Roles</th>
				<th></th> 
			</tr>
			<c:forEach items="${users}" var="user">
					<tr>
				<td><c:out value="${user.email}"/></td>
				<td><c:out value="${user.roles}"/></td>
				<td>
					<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav navbar-right" id="navigation">
							<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">Actions<b class="caret"></b></a>
								<ul class="dropdown-menu">
									<li><a href="${contextpath}/admin/user?id=${user.id}"> <span id="my-glyph1" class="glyphicon glyphicon-pencil"> </span> Edit</a></li>
									<li><a class="delete" data-toggle="modal" data-target="#myModal" data-id="${user.id}"><span id="my-glyph" class="glyphicon glyphicon-remove"></span> Delete</a></li>
								</ul>
        					</li>
						</ul>
					</div>
    			</td>
			</tr>
			</c:forEach>
		</table>

<%@include file="../include/tail.jsp"%>
