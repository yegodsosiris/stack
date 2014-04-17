var deleteId;
$(function() {

		$('.delete').click(function() {
			deleteId = $(this).data("id");
		});
		
		$('#confirmDeleteRecord').live('click', function(response, status, xhr) {
			location.href=contextpath+"/finance/deleteRecord?id="+deleteId;
			if (status == "error") 
			{
				var msg = "Sorry but there was an error: ";
				$("#error").html(msg + xhr.status + " " + xhr.statusText+". Contact your administrator.");
				$('#error').slideDown();
			}
		});
		

});