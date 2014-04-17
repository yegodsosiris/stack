<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"  %>
<%@ taglib prefix="form" uri="/WEB-INF/tld/spring-form.tld" %>
<%@ taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld" %>
<!DOCTYPE html>
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="shortcut icon" href="${contextpath}/resources/img/stack.jpg">

	<title>Stack</title>
	
	<script>
		var contextpath='${contextpath}';
	</script>

	<!-- Bootstrap core CSS -->
	<link href="${contextpath}/resources/css/start/jquery-ui-1.9.1.custom.css" rel="stylesheet">
	<link href="${contextpath}/resources/css/main.css" rel="stylesheet" media="screen">
	<link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">
	
	
	<!--[if lt IE 9]><script src="../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
	
	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
	  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	  <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
	<![endif]-->


  <body>
	<%@ include file="navbar.jsp" %>
   


    <!-- Page content of course! -->
    <main class="bs-docs-masthead" id="content" role="main">