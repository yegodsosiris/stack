<%@ include file="include/head.jsp" %>

		<h2>Apologies</h2>
		<b>an error has occurred with ${name}.</b>
		<div class="error">
			${message}
		</div>
		 <sec:authorize access="hasRole('ROLE_Admin')">
			<div class="error">
				<code>
				<c:forEach items="${stack}" var ="s">
					${s}<br>
				</c:forEach> 
				</code>
			</div>
		</sec:authorize>
		
<%@ include file="include/tail.jsp" %>