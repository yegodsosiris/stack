<%@ include file="../include/head.jsp"%>

<h2>Edit User</h2>

<form:form commandName="user" action="${contextpath}/admin/saveUser"
	method="post" cssClass="form-horizontal">
	<form:hidden path="id" />
	<div class="form-group">
		<label for="email" class="col-md-2 control-label">Email
			address</label>
		<div class="col-md-6">
			<form:input cssClass="form-control" path="email" />
		</div>
	</div>
	<div class="form-group">
		<label for="password" class="col-md-2 control-label">Password</label>
		<div class="col-md-6">
			<form:input cssClass="form-control" path="password" />
			* Leave blank if not changing.
		</div>
	</div>
	<div id="nopassword" style="display: none" class="alert alert-danger">You
		must enter a password</div>

	<div id="rolesContainer" class="form-group">
		<label class="col-md-2 control-label" for="roles">Roles</label>
		<div class="col-md-6">
			<form:checkboxes element="span class='checkbox'" items="${roles}"
				path="roles" />
		</div>
	</div>
	<p>
	<div class="btn-group">
		<input id="saveUser" type="submit" value="Save"
			class="btn btn-primary"> <a href="${contextpath}/admin/users"
			class="btn btn-default">Cancel</a>
	</div>
</form:form>


<%@ include file="../include/tail.jsp"%>
