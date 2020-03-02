
$(document).ready(function(){
	
	$("#password-confirm").keyup(function(){
	    var pass = $("#register-password").val();
	    var passConf = $("#password-confirm").val();
	    console.log(pass != passConf);
	    console.log(pass == passConf);
	    if(pass != passConf){
	        $("#register-password").addClass("passwordError");
	        $("#password-confirm").addClass("passwordError");
	    }
	
	    if(pass == passConf){
	        $("#register-password").removeClass("passwordError");
	        $("#password-confirm").removeClass("passwordError");
	    }

	})
	
	
	$("#register-password").keyup(function(){
	    var pass = $("#register-password").val();
	    var passConf = $("#password-confirm").val();

	    if(pass != passConf){
	        $("#register-password").addClass("passwordError");
	        $("#password-confirm").addClass("passwordError");
	    }
	
	    if(pass == passConf){
	        $("#register-password").removeClass("passwordError");
	        $("#password-confirm").removeClass("passwordError");
	    }

	})
	
});

