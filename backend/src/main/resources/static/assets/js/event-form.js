
$(document).ready(function(){
        $(".check-mostrar").click(function(evento){
          
            var valor = $(this).val();
          
            if(valor == 'true'){
                $("#div-mostrar").css("display", "block");
           
            }else{
                $("#div-mostrar").css("display", "none");
                
            }
    });
});

