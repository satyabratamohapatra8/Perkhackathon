<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.js"></script> 
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="http://malsup.github.com/jquery.form.js"></script> 
<style type="text/css">
.span12{
    -moz-box-shadow: 0 0 2px black;
    -webkit-box-shadow: 0 0 2px black;
    box-shadow: 0 0 2px black;
}
.top-buffer { margin-top:10px; }
</style>
<script type="text/javascript">
$( document ).ready(function() {
	$( "#submitLogin" ).on( "click", function() {
		var userName = $("#userName").val();
		var password = $("#password").val();
		if(userName == ''){
			alert("please enter username");
			return false;
		}
		if(password == ''){
			alert("please enter password");
			return false;
		}
		$.ajax({
			  url: "authenticate.htm",
			  data: { userName: userName, password: password }
			})
			  .done(function( msg ) {
					var data = JSON.parse(msg);
					if(data.success == true){
						window.location = 'home.htm';
					}
					else{
						alert ("Authentication failed")
					}
			  });
	});
});
</script>
</head>
<body>
	<div class="container">
	
		<div class="row">
			<div class="col-sm-8">
				<img alt="" src="resources/image/banner_paws_jp.gif">
			</div>
			<div class="col-sm-4">
				<img alt="" src="resources/image/cisco_logo.gif">
			</div>
		</div>
		<div class="row" >
			&nbsp;
		</div>
		<div class="row" >
			    <div class="span12">
				    <div class="row" style="margin-left:3px;margin-right:3px;">
				   		<div class="col-sm-12" style="background-color: #F7F7F7;;text-align: center;">
				   			IPS-Signature Log In
				   		</div>
				    </div>
			        <div class="row top-buffer">
			        	<div class="col-sm-6" style="text-align: right;">
			        		User Name  :  
			        	</div>
			        	<div class="col-sm-6" style="text-align: left;">
			        		<input type="text" id="userName"/>
			        	</div>
			            
			        </div>
			        
			        <div class="row top-buffer">
				        <div class="col-sm-6" style="text-align: right;">
				        		Password  :  
				        </div>
				        <div class="col-sm-6" style="text-align: left;">
				        	<input type="password" id="password"/>
				        </div>
			        </div>
			        
			        <div class="row top-buffer">
			        	<div class="col-sm-12" style="text-align: center;">
			        		<input type="button" value="Log In" id = "submitLogin"/>
			        	</div>
			        </div>
			        <div class="row top-buffer">
			        </div>
    			</div>
		</div>
	</div>
</body>
</html>