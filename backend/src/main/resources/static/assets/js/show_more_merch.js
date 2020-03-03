$(document).ready(function() {
	
	$("#show_more_button").click(function(){
    	var nextPageId = $(this).attr("nextPage");
    	
    	$.ajax({
            url: '/merchList?pageId=' + nextPageId,
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