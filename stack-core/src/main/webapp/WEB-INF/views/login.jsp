<%@ include file="include/head-min.jsp"%>
	<div>
		<form name="f" action="${contextpath}/j_spring_security_check" method="POST">
			<div class="form-group">
				<label for="email">Email
					<input  class="form-control" id="email" type="text" name="j_username" placeholder="Email">
				</label> 
			</div>
			<div class="form-group">
				<label for="password">Password
					<input class="form-control" id="password" type="password" name="j_password" placeholder="Password">
				</label>
			</div>
			<input id="login"class="btn btn-primary" name="submit" type="submit" value="Login">
		</form>
	</div>
<%@ include file="include/tail.jsp"%>