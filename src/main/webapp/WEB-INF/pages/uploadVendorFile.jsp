<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload Vendor File</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.js"></script> 
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="http://malsup.github.com/jquery.form.js"></script> 
<script src="resources/js/CircularLoader.js"></script>
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
   $( "#SubmitJquery" ).on( "click", function() {
	   var docIdId = $('#docIdId').val();
	   
	   if(docIdId == ''){
		   alert('Please enter documentId ');
		   return false;
	   }
	   $("#updateVendorFileUpload").ajaxForm({
		    success:function(msg) { 
		    	var data = JSON.parse(msg);
		    	data = JSON.parse(data);
		    	if(data.success == true){
		    		alert( "File upload and update successful");
					window.location = 'home.htm';
				}
				else{
					alert (data.errorMessage);
					window.location = 'home.htm';
				}
		    	
				
		     },
		     dataType:"text"
		   }).submit();
	 });
   $('#retLoadId').change(function(){
	   if($(this).is(':checked')){
		   $('#noTransNecId').hide();
		   $('#uploadedFile').hide();
	   }
	   else{
		   $('#noTransNecId').show();
		   $('#uploadedFile').show();
	   }
	});
   $('#noTransNecId').change(function(){
	   if($(this).is(':checked')){
		   $('#retLoadId').hide();
		   $('#uploadedFile').hide();
	   }
	   else{
		   $('#retLoadId').show();
		   $('#uploadedFile').show();
	   }
	});
});
function ajaxFileUpload(){
		   $("#divProgress").circularloader({
			   progressPercent: 5
			   });

		   $("#fileUpload").ajaxForm({
			    success:function(data) { 
			    	var path = JSON.parse(data)
			    	$("#filePathId").val(path);
			    	$("#divProgress").circularloader({
			 		   progressPercent: 100
			 		   });
					$('#retLoadId').hide();
					$('#noTransNecId').hide();
			     },
			     dataType:"text"
			   }).submit();
		   
		
}
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
				   			Upload Vendor File
				   		</div>
				    </div>
					<form method="POST" enctype="multipart/form-data" action="upload" id="fileUpload">
						<div class="row top-buffer">
							<div class="col-sm-6" style="text-align: right;">
								File to upload: 
							</div>
							<div class="col-sm-6" style="text-align: left;">
								<input type="file" name="file" onchange="return ajaxFileUpload();" id="uploadedFile"><br /> 
							</div>
						</div>
						<div class="row top-buffer">
							 <div class="col-sm-12" style="text-align: center;">
								<div id="divProgress"></div>
							</div>
						</div>
						
					</form>
					<form action="uploadVendorFile.htm" method="POST" id="updateVendorFileUpload">
						<input type="hidden" name="filePath" id="filePathId"/>
						<div class="row top-buffer">
							<div class="col-sm-6" style="text-align: right;">
								Document Id: 
							</div>
							<div class="col-sm-6" style="text-align: left;">
								<input type="text" name="docId" id="docIdId" placeholder="Enter DocId"/>
							</div>
						</div>
						<div class="row top-buffer">
							<div class="col-sm-6" style="text-align: right;">
								Retranslating without loading TMX
							</div>
							<div class="col-sm-6" style="text-align: left;">
								<input type="checkbox" name="retLoadTms" id="retLoadId"/>
							</div>
						</div>
						<div class="row top-buffer">
							<div class="col-sm-6" style="text-align: right;">
								No translation updates necessary
							</div>
							<div class="col-sm-6" style="text-align: left;">
								<input type="checkbox" name="noTransNec" id="noTransNecId"/>
							</div>
						</div>
					</form>
					<div class="row top-buffer">
						<div class="col-sm-12" style="text-align: center;">
							<input type="button" value="Submit" id="SubmitJquery">
						</div>
					</div>
					<div class="row top-buffer">
						<div class="col-sm-12" style="text-align: center;">
							<a href="logout.htm">LogOut</a>
						</div>
					</div>
					</div>
		</div>
	
</div>
</body>
</html>