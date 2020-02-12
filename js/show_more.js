// $(document).ready(function () {
//     $("#show_more").click(function () {
//         $(".original").append("<p>Test</p>");
//     });
// });

var new_item = $('<div class="row"><div class="col-sm-4"><a href="#"><img src="./assets/img/events/event.jpg" width="300"><h3 class="mt-2">Evento 7</h3></a><p>Texto de ejemplo del evento número 7</p></div><div class="col-sm-4"><a href="#"><img src="./assets/img/events/event.jpg" width="300"><h3 class="mt-2">Evento 8</h3></a><p>Texto de ejemplo del evento número 8</p></div></div>').hide();

function showMore() {
    $("#original").append(new_item);
    new_item.slideDown();
}

    
