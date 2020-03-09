$(document).ready(function() {
	
	$("#show_more_button").click(function(){
    	var nextPageId = $(this).attr("nextPage");
    	var game = getUrlVars()["game"];
    	
    	if(typeof(game) == "undefined"){
    		game = "null";
    	}
    	$.ajax({
            url: '/eventList?pageId=' + nextPageId + '&game=' + game,
        }).done(function (items) {
        	if(items != "nomore"){
        		$("#main_row").append(items);
                $("#show_more_button").attr("nextPage", Number(nextPageId) + 1);
        	} else {
        		$('#show_more_button').prop('disabled', true);
        		$('#show_more_button').text("No more results");
        		
        	}
        	
        })
    	
    });
	
	$("#show_more_button").click();
	
});


function getUrlVars() {
    var vars = {};
    var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(m,key,value) {
        vars[key] = value;
    });
    return vars;
}