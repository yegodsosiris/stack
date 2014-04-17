<%@ include file="../include/head.jsp" %>

		<h2>${setting.name}</h2>

		<form:form  commandName="setting" action="${contextpath}/admin/saveSetting" method="post">
			<form:hidden path="id"/>
			<label for="name">Name</label>
			<div class="form-group">
				<form:input path="name" size="75" cssClass="form-control"/>
			</div>
			<label for="value">Value</label>
			<div class="form-group">
				<form:input path="value" size="75" cssClass="form-control"/>
			</div>
			<label for="description">Description</label>
			<div class="form-group">
				<form:input path="description" size="75" cssClass="form-control"/>
			</div>
			
			<p>
			<div class="btn-group">
				<input type="submit" value="Save" class="btn btn-primary">
				<a href="${contextpath}/admin/settings" class="btn btn-default">Cancel</a>
			</div>
		</form:form>
		
<%@ include file="../include/tail.jsp" %>
