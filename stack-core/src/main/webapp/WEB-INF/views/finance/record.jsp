<%@ include file="../include/head.jsp"%>
<h2>Finance Record</h2>
		<form:form  commandName="record" action="${contextpath}/finance/saveRecord" method="post">
			<form:hidden path="id"/>
			<label for="user">User</label>
			<div class="form-group">
				<form:input path="user" cssClass="form-control"/>
			</div>
			<label for="amount">Amount</label>
			<div class="form-group">
				<form:input path="amount" cssClass="form-control"/>
			</div>
			<label for="accountNumber">Account Number</label>
			<div class="form-group">
				<form:input path="accountNumber" cssClass="form-control"/>
			</div>
			<label for="bank">Bank</label>
			<div class="form-group">
				<form:select items="${banks}" path="bank" cssClass="form-control"/>
			</div>
			<p>
			<div class="btn-group">
				<input type="submit" value="Save" class="btn btn-primary">
				<a href="${contextpath}/finance/records" class="btn btn-default">Cancel</a>
			</div>
		</form:form>
<%@ include file="../include/tail.jsp"%>