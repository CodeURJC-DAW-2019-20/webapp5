$(function () {
	//Life cycle functions
	feather.replace()
	
	eventsChart();
	merchChart();
	
	
	$( ".role_select" ).each(function() {
		$(this).val($(this).attr("value"));
	});
	
	//Handler behaviors
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
	$( ".delete_button" ).click(function() {
		var user_id = $(this).attr("user_id")
		$(".user_table tr[user_id='"+ user_id +"']").remove();
	});
	
});

