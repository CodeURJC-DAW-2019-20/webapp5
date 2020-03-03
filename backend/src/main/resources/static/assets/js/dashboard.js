$(function () {
	//Life cycle functions
	feather.replace()
	
	eventsChart();
	merchChart();
	
	
	$( ".role_select" ).each(function() {
		$(this).val($(this).attr("value"));
	});
	
	//Handler behaviors
	var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    $(document).ajaxSend(function (e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });
	$( "#dash_events" ).click(function() {
		$(".dash_page").attr("hidden",true);
		$("#events_page").attr("hidden",false);
		
		$( ".dash_menu a" ).removeClass("active");
		$( "#dash_events" ).addClass("active");
	});
	$( "#dash_merch" ).click(function() {
		$(".dash_page").attr("hidden",true);
		$("#merch_page").attr("hidden",false);
		
		$( ".dash_menu a" ).removeClass("active");
		$( "#dash_merch" ).addClass("active");
	});
	$( "#dash_admin" ).click(function() {
		$(".dash_page").attr("hidden",true);
		$("#admin_page").attr("hidden",false);
		
		$( ".dash_menu a" ).removeClass("active");
		$( "#dash_admin" ).addClass("active");
	});
	
	//Admin user handling
	$( ".save_button" ).click(function() {
		var user_id = $(this).attr("user_id")
		var newRoleId = $(".user_table tr[user_id='"+ user_id +"'] select").val();
		
		$.ajax({
			type:'POST',
			url: '/users/role/' + user_id,
			data: JSON.stringify(newRoleId),
			processData: false,
	        headers: {
	            "Content-Type": "application/json"
	        }
		}).done(function (item){
			alert("Success")
		})
	});
	
	$( ".delete_button" ).click(function() {
		var user_id = $(this).attr("user_id")
		
		$.ajax({
			type:'DELETE',
			url: '/users/' + user_id
		}).done(function (item){
			$(".user_table tr[user_id='"+ user_id +"']").remove();
		})
		
	});
	
});

