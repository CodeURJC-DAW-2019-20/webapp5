
$(function(){
	$('.check-mostrar').change(function(){
  	if(!$(this).prop('checked')){
    	$('#div-mostrar').hide();
    }else{
    	$('#div-mostrar').show();
    }
  
  })

})