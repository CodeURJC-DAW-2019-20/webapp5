$(document).ready(function() {
    var columns = $({{getCodeblockSixFirstEvents()}});
    $(".main_row").append(columns);
});

function showMoreEvents() {
	var columns = $({{getCodeblockNextThreeEvents()}});
	$(".main_row").append(columns);
	columns.slideDown();
}