//$(document).ready(function() {
//    var columns = $('{{getCodeblockSixFirstEvents()}}');
//    $("#main_row").append(columns);
//});
//
//
//function showMoreEvents() {
//	var columns = $('{{getCodeblockNextThreeEvents()}}');
//	$("#main_row").append(columns);
//	columns.slideDown();
//}


$(document).ready(function() {
	
	$("#show_more_button").click(function(){
    	var nextPageId = $(this).attr("nextPage");
    	
    	$.ajax({
            url: '/eventList?pageId=' + nextPageId,
        }).done(function (items) {
//            var result = JSON.stringify(items);
//          console.log(items);
//          console.log(result);
            
            $("#main_row").append(items);
            $("#main_row").append(nextPageId);
            $("#show_more_button").attr("nextPage", Number(nextPageId) + 1);
        })
    	
    });
});