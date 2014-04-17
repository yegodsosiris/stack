		$(function() {

			$('#confirmDeleteUser').live('click', function() {
				location.href=contextpath+"/admin/deleteUser?id="+deleteId;
			});
			$('#confirmDeleteConfig').live('click', function() {
				location.href=contextpath+"/admin/deleteSetting?id="+deleteId;
			});
			$('.delete').click(function() {
				deleteId = $(this).data("id");
			});
			$('#password').focus(function() {
				$('#nopassword').slideUp();
			});
			$('#saveAuthcode').live('click', function() {
				if($('#authresult').val()=='') {
					$('#noauthresult').slideDown();
					return false;
				}
				$.ajax({
					url:contextpath+'/admin/saveAuth',
					data:$('#authresult').val(),
					type: 'post'
					
				}).success(function() {
					showMessage("Successfully updated");
				}).error(function() {
					showMessage("There was an error");
				});
			});
			$('#synchOauth').live('click', function() {
				if($('#authresult').val()=='') {
					$('#noauthresult').slideDown();
					return false;
				}
				$.ajax({
					url:contextpath+'/admin/synchOauth',
					data:$('#authresult').val(),
					type: 'get'
					
				}).success(function() {
					showMessage("Successfully updated");
				}).error(function() {
					showMessage("There was an error");
				});
			});
			$('#confirmReset').live('click', function() {
				$.ajax({
					url:contextpath+'/admin/resetAuthData',
					type: 'post'
					
				}).success(function() {
					showMessage("New Auth Code was called successfully and reset");
				}).error(function() {
					showMessage("There was an error");
				});
			});
			$('#authresult').focus(function() {
				$('#noauthresult').slideUp();
			});
		});