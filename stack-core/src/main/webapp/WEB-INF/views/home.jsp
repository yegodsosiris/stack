<%@ include file="include/head.jsp" %>
	<style>
		#homelogo {
		  width: 1049px;
		  height: 819px;
		  display: block;
		  position: relative;
		  margin-left: auto;
		  margin-right: auto;
		}
		#homelogo::after {
		  content: "";
		  background: url(${contextpath}/resources/img/RDF.png);
		  opacity: 0.2;
		  top: 0;
		  left: 0;
		  bottom: 0;
		  right: 0;
		  position: absolute;
		  z-index: -1;   
		}
	
	</style>
	<div id="homelogo"></div>

<%@ include file="include/tail.jsp" %>