<%@page import="com.oes.action.Encryption"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.oes.dto.ContentDetailsDto"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML>
<html>
	<head>
		<title>XamDesk | Registration</title>
		<link rel='shortcut icon' type='image/x-icon' href='image/favicon.ico'/>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		
		<link href="css/sunny/jquery-ui-1.10.4.custom.css" rel="stylesheet">
		<script src="js_sunny/jquery-1.10.2.js"></script>
		<script src="js_sunny/jquery-ui-1.10.4.custom.js"></script>
		
		
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assets/css/main.css" />
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
		<script language="javascript" type="text/javascript" src="js/md5hash.js"></script>
		<script type="text/javascript">
		$(function() {
			  $( "#istr_date_of_birth" ).datepicker({
				dateFormat: 'dd-MM-yy',
		 		changeMonth: true,
		 		changeYear: true,
		 		yearRange: '1960:'+(new Date).getFullYear()  
			  });
		});
		
	 function StudentValidation() {
	 	 
		 $('#first_name').html('');
		 $('#last_name').html('');
		 $('#date_of_birth').html('');
		 $('#mobile_number').html('');
		 $('#email_id').html('');
		 $('#info').html('');
		 $('#captcha_details').html('');
		 
		 var result = '';
		 var pattern = new RegExp(/^[0-9]{1,10}$/);
			 
		 
		 var first_name = document.getElementById('istr_first_name').value;
		 if (first_name == '') {
			$('#first_name').html('Enter First Name');
			document.getElementById('istr_first_name').focus();

			return false;
		 }
			
		 var email_id = document.getElementById('istr_email').value;
		 if (email_id == '') {
			$('#email_id').html('Enter Email Id');
			document.getElementById('istr_email').focus();

			return false;
		 }
		 
		 if (!checkEmail(email_id)) {
			$('#email_id').html('Enter the valid Email Id');
			document.getElementById('istr_email').focus();

			return false;
		 }
		 
		 var date_of_birth = document.getElementById('istr_date_of_birth').value;
		 if (date_of_birth == '') {
			$('#date_of_birth').html('Select Date of Birth');
			document.getElementById('istr_date_of_birth').focus();

			return false;
		 }
		
		 var mobile_number = document.getElementById('inum_mobile_number').value;
		 if (mobile_number == '') {
			$('#mobile_number').html('Enter Mobile Number');
			document.getElementById('inum_mobile_number').focus();

			return false;
		 }
		
		 if (!isInteger(mobile_number)) {
			$('#mobile_number').html('Enter valid Mobile Number');
			document.getElementById('inum_mobile_number').focus();
			return false;
		 }
		 if(mobile_number.length != 10) {
			$('#mobile_number').html('Mobile Number should 10 digits');
			document.getElementById('inum_mobile_number').focus();
			return false;
		 }		
		
		if((!$("#term_and_conditions").is(':checked'))) {
			$('#info').html('You must agree with the terms and conditions of www.xamdesk.com to register.');
			return false;
		}		
		return true;	 	 
	 }


	 function checkEmail(inputvalue) 
	 {
	 	var pattern = /^[_\.\!\#\$\%\&\'\*\+\-\/\=\?\^\`\{\|\}\~A-Za-z0-9](([_\.\!\#\$\%\&\'\*\+\-\/\=\?\^\`\{\|\}\~]?[a-zA-Z0-9_\.\!\#\$\%\&\'\*\+\-\/\=\?\^\`\{\|\}\~]+)*)@([a-zA-Z0-9-\s].+\.[a-zA-Z]{2,5})$/;
	 	if (pattern.test(inputvalue)) {
	 		return true;
	 	} else {
	 		return false;
	 	}
	 }
	 function isInteger(s) {
		var i;
		for (i = 0; i < s.length; i++) {
		var c = s.charAt(i);
		if (((c < "0") || (c > "9")))
			return false;
		}
		return true;
	}

	function isValidPersantage(num) {
		
		var num2 = parseInt(num);
		if (((num2>=0) && (num2<=100))) {
			return true;
		}	
		return false;
	}
</script>
<style type="text/css">

/* ---------- LOGIN ---------- */
#login {

}

#space {
  padding: 1em 0em 0em 3em;
}
.wrapper { 
  overflow:hidden;
}

.wrapper div {
   padding: 1px;
}
.asideone {
  float:left;
  width: 50%;
}
.asidetwo { 
  overflow:hidden;
}
.td-one {
  float:left;
  width: 30%;
}
.td-two { 
  overflow:hidden;
}
#istr_first_name {width : 200px;}
#istr_last_name {width : 200px;}
#istr_date_of_birth {width : 200px;}
#istr_email {width : 200px;}
#inum_mobile_number {width : 200px;}
#istr_street_address {width : 200px;}
#istr_pin_code {width : 200px;}
#istr_state_name {width : 200px;}

.bigbox {
width: 80%; 
-webkit-border-radius: 20px 20px 0px 0px;
-moz-border-radius: 20px 20px 0px 0px;
border-radius: 20px 20px 0px 0px;
border:2px solid #FFFFFF;
background:rgba(201,198,193,0.9);
-webkit-box-shadow: rgba(0, 116, 199, 0.74) 22px 22px 22px;
-moz-box-shadow: rgba(0, 116, 199, 0.74) 22px 22px 22px;
box-shadow: rgba(0, 116, 199, 0.74) 22px 22px 22px;
}



/* For mobile phones: */
@media screen and (max-width: 400px) {
	[class*="col-"] {width: 100%;}
    .asideone {width: 100%;}
	.asidetwo {width: 100%;}
	.bigbox {width: auto;}
	#space {padding: 1em 0em 0em 3em;}
	.td-one {float:left; width: 100%;}
    .td-two {overflow:hidden;  width: 100%;}
    #istr_first_name {width : 90%; height : 30px;}
	#istr_last_name {width : 90%; height : 30px;}
	#istr_date_of_birth {width : 90%; height : 30px;}
	#istr_email {width : 90%; height : 30px;}
	#inum_mobile_number {width : 90%; height : 30px;}
	#istr_street_address {width : 90%; height : 30px;}
	#istr_pin_code {width : 90%; height : 30px;}
	#istr_state_name {width : 90%; height : 30px;}

@media only screen and (min-width: 600px) {
     /* For tablets: */
     .col-m-1 {width: 50%;}
     .col-m-12 {width: 100%;}
    .asideone {width: 100%;}
	.asidetwo {width: 100%;}
	 .bigbox {width: auto;}
	 #space {padding: 1em 0em 0em 3em;}
	 .td-one {float:left; width: 100%;}
     .td-two {overflow:hidden;  width: 100%;}
      #istr_first_name {width : 90%; height : 30px;}
	  #istr_last_name {width : 90%; height : 30px;}
	  #istr_date_of_birth {width : 90%; height : 30px;}
	  #istr_email {width : 90%; height : 30px;}
	  #inum_mobile_number {width : 90%; height : 30px;}
	  #istr_street_address {width : 90%; height : 30px;}
	  #istr_pin_code {width : 90%; height : 30px;}
	  #istr_state_name {width : 90%; height : 30px;}
    
}
@media only screen and (min-width: 768px) {
    /* For desktop: */
    .col-1 {width: 50%;}
    .col-12 {width: 100%; }
    .asideone {width: 100%;}
	.asidetwo {width: 100%;}
	.bigbox {width: auto;}
	 #space {padding: 1em 0em 0em 3em;}
	.td-one {float:left; width: 100%;}
    .td-two {overflow:hidden;  width: 100%;}
    
  }
}

p.your-para {
    color: rgb(91, 81, 99);
	text-transform: uppercase;
}
form fieldset input {
	background-color: #e5e5e5;
	border: none;
	border-radius: 3px;
	-moz-border-radius: 3px;
	-webkit-border-radius: 3px;
	color: #5a5656;
	font-family: 'Open Sans', Arial, Helvetica, sans-serif;
	font-size: 14px;
	height: 50px;
	outline: none;
	padding: 0px 10px;
	width: 300px;
	-webkit-appearance:none;
}
form fieldset input[type="submit"] {
	background-color: #008dde;
	border: none;
	border-radius: 3px;
	-moz-border-radius: 3px;
	-webkit-border-radius: 3px;
	color: #f4f4f4;
	cursor: pointer;
	font-family: 'Open Sans', Arial, Helvetica, sans-serif;
	height: 50px;
	text-transform: uppercase;
	width: 200px;
	-webkit-appearance:none;
}
form fieldset a {
	color: #5a5656;
	font-size: 10px;
}
form fieldset a:hover { text-decoration: underline; }
.btn-round {
	background-color: #5a5656;
	border-radius: 50%;
	-moz-border-radius: 50%;
	-webkit-border-radius: 50%;
	color: #f4f4f4;
	display: block;
	font-size: 12px;
	height: 50px;
	line-height: 50px;
	margin: 0px 125px;
	text-align: center;
	text-transform: uppercase;
	width: 50px;
}
</style>
	</head>
	<%
	List<ContentDetailsDto> contentDetailsDtoList = new ArrayList<ContentDetailsDto>();
	contentDetailsDtoList = (ArrayList<ContentDetailsDto>)request.getSession().getAttribute("contentDetailsDtoList");
	
	%>
	<body class="no-sidebar">
		<div id="page-wrapper">

			<!-- Header Wrapper -->
				<div id="header-wrapper">
					<div class="container">

						<!-- Header -->
							<header id="header">
								<div class="inner">

									<!-- Logo -->
										<h1><a href="xamdeskhome" id="logo"><img src="images/logo.png" style="width : 33%; margin-top: -0.8em;"></a></h1>

									<!-- Nav -->
										<nav id="nav">
											<ul>
												<li><a href="xamdeskhome">Home</a></li>
												<li><a href="AboutUs">About Us</a></li>
												<li>
													<a href="#">Tutorials</a>
														<ul>
														<%if(contentDetailsDtoList != null && contentDetailsDtoList.size()>0) {
															for(ContentDetailsDto dto : contentDetailsDtoList) {
																%><li><a href="showStudentMaterials?contenttype=<%=Encryption.encryptText(dto.getOnum_slno().toString())%>"><%=dto.getOstr_content_name()%></a></li><%
															}
														 } %>
													</ul>
												</li>
												<li><a href="accountLogin">Login</a></li>
												<li class="current_page_item"><a href="#">Registration</a></li>
												<li><a href="ContactUs">Contact Us</a></li>
											</ul>
										</nav>

								</div>
							</header>

					</div>				
				</div>

				<!-- Main Wrapper -->
				<div id="main-wrapper" style="background: #5174a4;">
					<div class="wrapper style2" style="padding: 1em 0 4em 0;">
						<div class="inner">
								
							<div class="container">
								<div id="content">

									<!-- Content -->
									<div id="login" align="center" style="margin-top: 2em;">
									<div class="bigbox">
									<div id="space">
										<h3 align="left">NEW TO XAMDESK ? Register for a runway to excel your career.</h3>
										<h6 align="left">You must be well prepared and for you exams will be a piece of cake
										But to judge<br/> trajectory of your flight among the fleets you need to check
										And for that XAMDESK<br/> will provide you the runway you must take.
										</h6>
										<div align="center" style="color: #D22117; font-size: 18px; font-weight: bold; margin-top: 20px;" id="info"><s:property value="info"/></div>
										<br/>
										<s:form theme="simple" autocomplete="off" id="studentDetailsDto" action="saveUserDetails.action" name="studentDetailsDto"  method="post" onsubmit="return(StudentValidation());">
										
										<div class="wrapper">
										    <div class="asideone">
										    <div class="td-one" align="left"><div style="font-weight: bold; font-size: 14px; color: rgb(91, 81, 99);">Name<b style="color: red;">&nbsp;*</b></div></div>										    
										    <div class="td-two" align="left"><s:textfield theme="simple" name="studentDetailsDto.istr_first_name" id="istr_first_name" tabindex="1"/></div>										    
										    <div class="td-one" align="left"></div><div class="td-two" align="left"><div id="first_name" style="color: #D22117; font-size: 15px; font-weight: bold;"></div></div>										    
										    
										    <div class="td-one" align="left"><div style="font-weight: bold; font-size: 14px; color: rgb(91, 81, 99);">Date of Birth<b style="color: red;">&nbsp;*</b></div></div>										    
										    <div class="td-two" align="left"><s:textfield theme="simple" name="studentDetailsDto.istr_date_of_birth" id="istr_date_of_birth" tabindex="3" readonly="true"/></div>
										    <div class="td-one" align="left"></div><div class="td-two" align="left"><div id="date_of_birth" style="color: #D22117; font-size: 15px; font-weight: bold;"></div></div>
										    
										    <div class="td-one" align="left"><div style="font-weight: bold; font-size: 14px; color: rgb(91, 81, 99);">Address</div></div>										    
										    <div class="td-two" align="left"><s:textfield theme="simple" name="studentDetailsDto.istr_street_address" id="istr_street_address" tabindex="6"/></div>
										    <div class="td-one" align="left"></div><div class="td-two" align="left"><div id="address_error" style="color: #D22117; font-size: 15px; font-weight: bold;"></div></div>
										    
										    <div class="td-one" align="left"><div style="font-weight: bold; font-size: 14px; color: rgb(91, 81, 99);">State</div></div>										    
										    <div class="td-two" align="left"><s:textfield theme="simple" name="studentDetailsDto.istr_state_name" id="istr_state_name" tabindex="7"/></div>										    
										    <div class="td-one" align="left"></div><div class="td-two" align="left"><div id="state_error" style="color: #D22117; font-size: 15px; font-weight: bold;"></div></div>
										    </div>
										    
										    <div class="asidetwo">
										    <div class="td-one" align="left"><div style="font-weight: bold; font-size: 14px; color: rgb(91, 81, 99);">Email Id<b style="color: red;">&nbsp;*</b></div></div>										    
										    <div class="td-two" align="left"><s:textfield theme="simple" name="studentDetailsDto.istr_email" id="istr_email" tabindex="4"/></div>
										    <div class="td-one" align="left"></div><div class="td-two" align="left"><div id="email_id" style="color: #D22117; font-size: 15px; font-weight: bold;"></div></div>
										    
										    <div class="td-one" align="left"><div style="font-weight: bold; font-size: 14px; color: rgb(91, 81, 99);">Phone No<b style="color: red;">&nbsp;*</b></div></div>										    
										    <div class="td-two" align="left"><s:textfield theme="simple" name="studentDetailsDto.inum_mobile_number" id="inum_mobile_number" tabindex="5"/></div>
										    <div class="td-one" align="left"></div><div class="td-two" align="left"><div id="mobile_number" style="color: #D22117; font-size: 15px; font-weight: bold;"></div></div>
																		 		
										    <div class="td-one" align="left"><div style="font-weight: bold; font-size: 14px; color: rgb(91, 81, 99);">Pincode</div></div>										    
										    <div class="td-two" align="left"><s:textfield theme="simple" name="studentDetailsDto.istr_pin_code" id="istr_pin_code" tabindex="8"/></div>
										    <div class="td-one" align="left"></div><div class="td-two" align="left"><div id="pincode_error" style="color: #D22117; font-size: 15px; font-weight: bold;"></div></div>
										    </div>
										</div>
										
									
										<table>
										<tr>
										<td colspan="4" align="right">&nbsp;</td>
										</tr>
										<tr>
										<td align="right"><input type="checkbox" name="term_and_conditions" id="term_and_conditions" style="width: 20px; height: 20px;"></td>
			    						<td colspan="4" align="left" style="vertical-align: middle;"><label style="font-weight: bold; font-size: 14px; color: rgb(91, 81, 99);">&nbsp;&nbsp;I have read and agree to the <a href="termAndCondition.action" target="_blank" style="cursor: pointer;"><u>Terms&nbsp;&amp;&nbsp;Conditions</u></a>.</label></td>
										</tr>
										</table>
										
										<%-- <table style="width: AUTO; box-shadow: 0 1px 3px rgba(0,0,0,0.12), 0 1px 2px rgba(0,0,0,0.24); -webkit-border-radius: 10px 10px 10px 10px; -moz-border-radius: 10px 10px 10px 10px; border-radius: 10px 10px 10px 10px; background-color: rgba(255, 255, 255, 0.2); -webkit-box-shadow: #B3B3B3 15px 15px 15px;">
										<tr>
										<td width="10%">&nbsp;</td>
										<td align="center">										
											<div style="font-weight: bold; font-size: 14px; color: rgb(91, 81, 99);">Enter text as shown below</div>
										</td>
										<td width="10%">&nbsp;</td>
										</tr>
										<tr>
										<td width="10%">&nbsp;</td>
										<td>										
											<div style="float: left;"><img src="<%=request.getContextPath()%>/showCaptcha" style="box-shadow: 0 1px 3px rgba(0,0,0,0.12), 0 1px 2px rgba(0,0,0,0.24); -webkit-border-radius: 10px 10px 10px 10px; -moz-border-radius: 10px 10px 10px 10px; border-radius: 10px 10px 10px 10px; background-color: rgb(239, 192, 119); -webkit-box-shadow: #B3B3B3 15px 15px 15px;"></div> 
											<div style="float: left;"><input type="text" name="captchatext" id="captchatext" style="background: #ffffff; width: 150px;"></div>
										</td>
										<td width="10%">&nbsp;</td>
										</tr>
										<tr>
										<td>&nbsp;</td>
										</tr>
										<tr>
										<td colspan="3" align="center"><div id="captcha_details" style="color: #D22117; font-size: 15px; font-weight: bold;"></div></td>
										</tr>
										</table> --%>
										
										<fieldset>
											<p><input type="submit" value="Register"></p>
										</fieldset>
										
										<input type="hidden" name="contextPath" id="contextPath" value="<%=request.getContextPath()%>"/>
										<input type="hidden" name="randomstr" id="randomstr" value="<s:property value='randomString'/>"/>
										</s:form>
										
										<!--
										<p><span class="btn-round">or</span></p>
										<p>
											<a class="facebook-before"></a>
											<button class="facebook">Login Using Facbook</button>
										</p>
										<p>
											<a class="twitter-before"></a>
											<button class="twitter">Login Using Twitter</button>
										</p>
										-->
									</div>
									</div>
									</div> <!-- end login -->
								</div>
							</div>				
						</div>
					</div>					
				</div>



									<!-- Footer Wrapper -->
			<footer id="footer" class="container">
				<div class="row">
				<div class="3u 12u(mobile)">

					<!-- Links -->
					<section>
						<h2>XamDesk</h2>
							<ul class="divided">
								<li><a href="RegistrationPage">Registration</a> | <a href="accountLogin">Login</a></li>
								<li><a href="AboutUs">About Us</a> | <a href="ContactUs">Contact Us</a></li>
								<li><a href="#">For Coaching Centres</a></li>
								<li><a href="termAndCondition.action">Terms & Conditions</a> | <a href="#">FAQs</a></li>
						
							</ul>
						</section>
						

					</div>
						<div class="3u 12u(mobile)">

						<!-- Links -->
							<section>
								<h2>RESOURCES</h2>
								<ul class="divided">
									<li><a href="#">Govterment Jobs</a></li>
									<li><a href="#">Examination Alert</a></li>
									<li><a href="#">Group Discussions</a></li>
									<li><a href="#">Current Affairs</a></li>
								</ul>
							</section>


							</div>
							<div class="6u 12u(mobile)">

								<!-- About -->
									<section>
										<h2><strong>Welcome to</strong> XamDesk</h2>
										<p>It gives us great pleasure in welcoming you to the website of <strong>XAMDESK</strong> devised by the <strong>SIS Group</strong>. A platform for the government job aspirants that will provide them most accurate and reliable myriad test series and study materials.</p>
										<a href="AboutUs" class="button alt icon fa-arrow-circle-right">Learn More</a>
									</section>
							</div>

						</div>	
						<br/>
						<div align="center">
							<a href="https://www.facebook.com/xamdesk/" target="_blank" class="fa fa-facebook" style="color: #FFFFFF;"></a>&nbsp;&nbsp;
							<a href="https://twitter.com/DeskXam" target="_blank" class="fa fa-twitter" style="color: #FFFFFF;"></a>&nbsp;&nbsp;
							<a href="https://plus.google.com/109400441840990260648" target="_blank" class="fa fa-google" style="color: #FFFFFF;"></a>&nbsp;&nbsp;
							<a href="#" class="fa fa-linkedin" style="color: #FFFFFF;"></a>&nbsp;&nbsp;
							<a href="https://www.youtube.com/channel/UCQQad4OagMGoompxWNAXWAQ/" target="_blank" class="fa fa-youtube" style="color: #FFFFFF;"></a> 
						</div>
						<div id="copyright">
							<ul class="menu">
								<li>&copy; XamDesk. All rights reserved</li><li>Developed By: <a href="#">Swans Digital Solutions Pvt Ltd.</a></li>
							</ul>
						</div>							
		</footer>

		</div>
		
			<script src="assets/js/jquery.dropotron.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/skel-viewport.min.js"></script>
			<script src="assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="assets/js/main.js"></script>
	</body>
</html>