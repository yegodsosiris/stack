	
    <script src="${contextpath}/resources/js/jquery/jquery-1.8.2.min.js"></script>
    <script src="${contextpath}/resources/js/jquery/jquery-ui-1.9.1.custom.min.js"></script>
    
	
  	<script src="${contextpath}/resources/js/bootstrap.min.js"></script>
  	<script src="${contextpath}/resources/js/dateutil/date.js"></script>
    <script src="${contextpath}/resources/js/tinymce/tinymce.min.js"></script>
    
    
    <sec:authorize access="hasRole('ROLE_Admin')">
    	<script src="${contextpath}/resources/js/admin.js"></script>
    </sec:authorize>
    
    <sec:authorize access="hasRole('ROLE_Finance')">
    	<script src="${contextpath}/resources/js/finance.js"></script>
    </sec:authorize>
    
    <script type="text/javascript">
		tinymce.init({
		    selector: "textarea",
		    browser_spellcheck : true,
		    plugins: [
		       "table code"
             // "advlist autolink lists link image charmap print preview anchor",
             // "searchreplace visualblocks code fullscreen",
             // "insertdatetime media table contextmenu paste"
            ],
            toolbar: "undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image"
		 });
	</script>