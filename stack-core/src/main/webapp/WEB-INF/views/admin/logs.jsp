<%@ include file="../include/head.jsp" %>

		<h2>Logs</h2>
		<a href="${contextpath}/admin/clearLogs" class="btn btn-primary">Clear</a>
		<table id="loglist" class="table table-striped table-hover">
			<c:forEach var="log" items="${logs}">
				<tr class="${log.level}"><td>${log.date}</td><td>${log.userName}</td><td>${log.level}</td><td>${log.message}</td></tr>
			</c:forEach>
		</table>

	<script src="${contextpath}/resources/js/admin.js"></script>
	
<%@ include file="../include/tail.jsp" %>
