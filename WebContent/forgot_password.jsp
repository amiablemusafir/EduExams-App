<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML>
<html>
	<head>
	<title>XamDesk | Forgot Password</title>
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
	function passwordValidation() {

		var login_id = document.getElementById('istr_login_id').value;
				
		var email_id = document.getElementById('istr_email_id').value;
		
		var status = 0;
		if (login_id != '') {
			status = 1;	
			$("#istr_email_id").val("");
			$("#status").val("1");
		}
		
		if (email_id != '') {
			status = 2;	
			$("#istr_login_id").val("");
			$("#status").val("2");
		}
		
		if(status == 0) {
			$("#messages").html("Please Enter Username Or Email Id");
			return false;
		} 		
		return true;
	}
</script>


<style type="text/css">

/* ---------- LOGIN ---------- */
#login {margin: 50px auto; width: 550px;}
#istr_login_id {width: 300px; }
#date_of_birth1 {width: 300px; }
#date_of_birth2 {width: 300px; }
#istr_email_id {width: 300px; }
.bot1 {width: 50%; margin-top : 60px; float: left;}
.bot2 {width: 50%; margin-top : 80px; float: right;}

#login_button {width: 300px; }

.space {padding: 0em 0em 0em 3em;}
#textfield_box {width : 300px;}
.bigbox {
	 width: 550px; 
	-webkit-border-radius: 20px 20px 0px 0px;
	-moz-border-radius: 20px 20px 0px 0px;
	 border-radius: 20px 20px 0px 0px;
	 border:2px solid #FFFFFF;
	 background:rgb(253, 253, 252);
	 -webkit-box-shadow: rgba(0, 116, 199, 0.74) 22px 22px 22px;
	 -moz-box-shadow: rgba(0, 116, 199, 0.74) 22px 22px 22px;
	 box-shadow: rgba(0, 116, 199, 0.74) 22px 22px 22px;
}

.messagebox {
	width: 400px; 
	-webkit-border-radius: 20px 20px 20px 20px;
	-moz-border-radius: 20px 20px 20px 20px;
	border-radius: 20px 20px 20px 20px;
	border:2px solid #FFFFFF;
	background:rgba(201,198,193,0.9);
	-webkit-box-shadow: #B3B3B3 22px 22px 22px;
	-moz-box-shadow: #B3B3B3 22px 22px 22px; 
	box-shadow: #B3B3B3 22px 22px 22px;
}

/* For mobile phones: */
@media screen and (max-width: 400px) {
	.messagebox {width: 98%;}
	.bigbox {width: 98%;}
	#login {margin: 10px 10px; width: auto;}
	.space {padding: 1em 0em 0em 1.5em;}
	#istr_login_id {width: 90%; height: 30px;}
	#date_of_birth1 {width: 90%; height: 30px;}
	#date_of_birth2 {width: 90%; height: 30px;}
	#istr_email_id {width: 90%; height: 30px;}
	#login_button {width: 90%;}
	.bot1 {width: 90%; margin-top : 0px; float: left;}
	.bot2 {width: 90%; margin-top : 0px; float: left;}
	
	
@media only screen and (min-width: 600px) {
     /* For tablets: */
    .messagebox {width: auto;}
	.bigbox {width: auto;}
    #login {margin: 0px auto; width: auto;}
    .space {padding: 1em 0em 0em 1.5em;}
}
@media only screen and (min-width: 768px) {
    /* For desktop: */
    .messagebox {width: 500px;}
	.bigbox {width: 500px;}
	
  }
}

#message {
	margin: 20px auto;
	width: 500px;
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
	width: 300px;
	-webkit-appearance:none;
	-webkit-box-shadow: rgba(0, 116, 199, 0.74) 2px 2px 2px;
	-moz-box-shadow: rgba(0, 116, 199, 0.74) 2px 2px 2px;
	box-shadow: rgba(0, 116, 199, 0.74) 2px 2px 2px;
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
	<body class="no-sidebar">
		<div id="page-wrapper">

		

				<!-- Main Wrapper -->
				<div id="main-wrapper" style="background: #5174a4;">
					<div class="wrapper style2" style="padding: 1em 0 4em 0;">
						<div class="inner">
								
							<div class="container">
								<div id="content">

									<div id="login">
									<div class="bigbox">
									
									<div align="center">
									<img src="image/forgot_password.png" width="20%" height="20%">
									<h1>Lost your password ?</h1>
									
									<font color="#000000">Enter your email or username to receive an email <br/>with a reset password request.</font>
									<br/>
									<br/>
									<font color="#D22117"><div id="messages"><s:property value="messages"/></div></font>
									
									
									<div align="center">									
									<form id="adminDetailDto" name="formLogin" action="forgotPasswordAuthentication" method="post" onsubmit="return(passwordValidation());">
									<fieldset>	
									
									<input name="istr_login_id" placeholder="Enter Your Username"  id="istr_login_id" type="text">
									
									<p style="padding-top: 15px;"><span class="btn-round">or</span></p>
									
									<input placeholder="Enter Your Email Id" name="istr_email_id" id="istr_email_id" type="text">
									<br/>
									<p><input type="submit" value="Submit" id="login_button"></p>
									<input type="hidden" name="status" id="status">
									<input type="hidden" name="contextPath" id="contextPath" value="<%=request.getContextPath()%>"/>
									<font color="#000000" style="font-size: 14px;">Still need help?&nbsp;&nbsp;&nbsp;&nbsp;<a href="ContactUs" style="text-decoration: none; font-size: 14px; font-weight: bold; color: #40a0e9;">Contact Us </a>  &nbsp;&nbsp;|&nbsp;&nbsp; <a href="accountLogin" style="text-decoration: none; font-size: 14px; font-weight: bold; color: #40a0e9;">Click for Login </a></font>
									
									</fieldset>
									</form>										
									</div>
									</div>
									</div>
									
									<div class="bot1">
									<table>
									<tr>
									<td align="left"><a href="xamdeskhome"><img src="image/logo_temp.png" style="width: auto; height: auto;"/></a></td>
									</tr>
									</table>
									</div>
									<div class="bot2">
									<table>
									<tr>
									<td align="right" style="color: #ffffff; font-size: 14px; font-weight: bold; text-decoration: none;"><a href="xamdeskhome"  style="text-decoration: none;">Home</a>&nbsp;&nbsp;&nbsp;  |  &nbsp;&nbsp;&nbsp;<a href="accountLogin"  style="text-decoration: none;">Login</a>&nbsp;&nbsp;&nbsp;  | &nbsp;&nbsp;&nbsp;<a href="ContactUs"  style="text-decoration: none;">Contact</a></td>
									</tr>
									</table>
									</div>
									
									<br/>
									<br/>
									</div> <!-- end login -->
								</div>
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

		<script src="assets/js/skel.min.js"></script>
		<script src="assets/js/skel-viewport.min.js"></script>
		<script src="assets/js/util.js"></script>
		<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
		<script src="assets/js/main.js"></script>

	</body>
</html>