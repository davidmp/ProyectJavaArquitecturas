<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form class="form-signin" action="javascript:validaxion()" method="post">
        <h2 class="form-signin-heading">Ingreso SysVentas</h2>
        <label for="username" class="sr-only">Email address</label>
        <input type="text" id="username" class="form-control" placeholder="Username"  autofocus>
        <label for="password" class="sr-only">Password</label>
        <input type="password" id="password" class="form-control" placeholder="Password" >
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        <div class="myerror" align="center">
            <a id="login_error"></a>
        </div>        
</form>
<script type="text/javascript">
function validaxion(){
     var error = "";
     $('#llave').val("");
	if (!$("#username").val()){
		error += "Introduce el usuario<br>";
		$('#username').focus();
	}
	if (!$("#password").val()){
		error += "Introduce la contraseña";
		if ($("#username").val())
		 $('#password').focus();
	}      
    if(error.length > 0){
	   $("#login_error").html('');
	   $("#login_error").append(error);
	   $("#login_error").slideDown();           
	}else{
	$('#login_error').css('display','none');	
        var objParameter = "";

        $.ajax({
                type: 'POST',
		url: '${pageContext.request.contextPath}/validate',		
		data: 'username=' + encodeURIComponent($('#username').val()) + '&password=' + encodeURIComponent($('#password').val()) + '&web=validaxion',
		success: function(data){ 
                    //alert(data);
                   objParameter=$.trim(data).split("|");   

                    if($.trim(objParameter[1])=="5"){
                                if($.trim(objParameter[2])=='Exito'){
                                    
                                     window.location='${pageContext.request.contextPath}/'+$.trim(objParameter[3]);
                                }
                                else {
				$('#login_error').html("Acceso no Autorizado");
				$('#login_error').css('display','block');                                
                                }                         
                         }else{
				$('#login_error').html($.trim(objParameter[2]));
				$('#login_error').css('display','block');
				$('#username').focus();                                
                         } 
            }
         })        
	}
}
</script>        