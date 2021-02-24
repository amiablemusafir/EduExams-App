<%@page import="com.oes.action.GoogleConnection"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@page import="com.oes.action.FBConnection"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>XamDesk | Login</title>
		<link rel='shortcut icon' type='image/x-icon' href='image/favicon.ico'/>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assets/css/main.css" />
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
		<script language="javascript" type="text/javascript" src="js/md5hash.js"></script>
		<%
			FBConnection fbConnection = new FBConnection();
			GoogleConnection googleConnection = new GoogleConnection();
		%>
			<script type="text/javascript">
			/* $(function() {
				$('html, body').animate({
				      scrollTop: $("#istr_login_id").offset().top
				}, 400);
			}); */
		
			function LoginValidation() {
		
				var username = document.getElementById('istr_login_id').value;
				var password = document.getElementById('istr_password').value;
				
				username = username.trim();
				password = password.trim();
				
				var randomString = document.getElementById('randomstr').value;
				
				if (username == '') {
					alert('Please enter Username');
					return false;
				}
				if (password == '') {
					alert('Please enter Password');
					return false;
				} else {
				
					var hashPass = calcMD5(password);
				
					var concateString = hashPass + randomString;
					
					var finalPassword = calcMD5(concateString);
						
					document.getElementById('istr_password').value = finalPassword;
		
		
				}
		
				return true;
		
			}
	
</script>
<style type="text/css">

/* ---------- LOGIN ---------- */
#login {margin: 50px auto; width: 550px;}
#istr_login_id {width: 300px; }
#istr_password {width: 300px; }
#login_button {width: 300px; }
.bot1 {width: 50%; margin-top : 60px; float: left;}
.bot2 {width: 50%; margin-top : 80px; float: right;}

.space {padding: 1em 0em 0em 0em;}
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
	-webkit-border-radius: 20px 20px 0px 0px;
	-moz-border-radius: 20px 20px 0px 0px;
	 border-radius: 20px 20px 0px 0px;
	 border:2px solid #FFFFFF;
	 background:rgb(253, 253, 252);
	 -webkit-box-shadow: rgba(0, 116, 199, 0.74) 22px 22px 22px;
	 -moz-box-shadow: rgba(0, 116, 199, 0.74) 22px 22px 22px;
	 box-shadow: rgba(0, 116, 199, 0.74) 22px 22px 22px;
}

/* For mobile phones: */
@media screen and (max-width: 400px) {
	.messagebox {width: 98%;}
	.bigbox {width: 98%;}
	#login {margin: 10px 10px; width: auto;}
	.space {padding: 1em 0em 0em 0em;}
	#istr_login_id {width: 90%; height: 30px;}
	#istr_password {width: 90%; height: 30px;}
	#login_button {width: 90%;}
	.bot1 {width: 90%; margin-top : 0px; float: left;}
	.bot2 {width: 90%; margin-top : 0px; float: left;}
	
	
@media only screen and (min-width: 600px) {
     /* For tablets: */
    .messagebox {width: auto;}
	.bigbox {width: auto;}
    #login {margin: 0px auto; width: auto;}
    .space {padding: 1em 0em 0em 0em;}
}
@media only screen and (min-width: 768px) {
    /* For desktop: */
    .messagebox {width: 400px;}
	.bigbox {width: 400px;}
	
  }
}

#message {
	margin: 20px auto;
	width: 400px;
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
.facebook-before {
	background-color: #0064ab;
	border-radius: 3px 0px 0px 3px;
	-moz-border-radius: 3px 0px 0px 3px;
	-webkit-border-radius: 3px 0px 0px 3px;
	color: #f4f4f4;
	display: block;
	float: left;
	height: 50px;
	line-height: 50px;
	text-align: center;
	width: 50px;
}
.facebook {
	background-color: #0079ce;
	border: none;
	border-radius: 0px 3px 3px 0px;
	-moz-border-radius: 0px 3px 3px 0px;
	-webkit-border-radius: 0px 3px 3px 0px;
	color: #f4f4f4;
	cursor: pointer;
	height: 50px;
	text-transform: uppercase;
	width: 250px;
}
.twitter-before {
	background-color: #189bcb;
	border-radius: 3px 0px 0px 3px;
	-moz-border-radius: 3px 0px 0px 3px;
	-webkit-border-radius: 3px 0px 0px 3px;
	color: #f4f4f4;
	display: block;
	float: left;
	height: 50px;
	line-height: 50px;
	text-align: center;
	width: 50px;
}
.twitter {
background-color: #1bb2e9;
border: none;
border-radius: 0px 3px 3px 0px;
-moz-border-radius: 0px 3px 3px 0px;
-webkit-border-radius: 0px 3px 3px 0px;
color: #f4f4f4;
cursor: pointer;
height: 50px;
text-transform: uppercase;
width: 250px;
}

.loginBtn {
  box-sizing: border-box;
  position: relative;
  width: 300px;
  height: 4em;
  margin: 0.2em;
  padding: 0 15px 0 46px;
  border: none;
  text-align: left;
  line-height: 34px;
  white-space: nowrap;
  border-radius: 0.2em;
  font-size: 12px;
  color: #FFF;
}
.loginBtn:before {
  content: "";
  box-sizing: border-box;
  position: absolute;
  top: 0;
  left: 0;
  width: 40x;
  height: 100%;
}
.loginBtn:focus {
  outline: none;
}
.loginBtn:active {
  box-shadow: inset 0 0 0 32px rgba(0,0,0,0.1);
}


/* Facebook */
.loginBtn--facebook {
  background-color: #4C69BA;
  background-image: linear-gradient(#4C69BA, #3B55A0);
  /*font-family: "Helvetica neue", Helvetica Neue, Helvetica, Arial, sans-serif;*/
  text-shadow: 0 -1px 0 #354C8C;
}
.loginBtn--facebook:before {
  border-right: #364e92 1px solid;
  width: 3.5em;
  background: url('images/facebook.png') 6px 6px no-repeat;
}
.loginBtn--facebook:hover,
.loginBtn--facebook:focus {
  background-color: #5B7BD5;
  background-image: linear-gradient(#5B7BD5, #4864B1);
}


/* Google */
.loginBtn--google {
  /*font-family: "Roboto", Roboto, arial, sans-serif;*/
  background: #DD4B39;
}
.loginBtn--google:before {
  border-right: #BB3F30 1px solid;
  width: 3.5em;
  background: url('images/gplus.png') 6px 6px no-repeat;
}
.loginBtn--google:hover,
.loginBtn--google:focus {
  background: #E74B37;
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

									<div align="center">
									<div id="login">
									<div class="bigbox">
									<div class="space">
										<img src="image/login.png">
										<h1>XamDesk Account</h1>
										<font color="#000000">Please enter Username and Password</font>
										<br/>
										<div align="center" style="color: #D22117; font-size: 14px; font-weight: bold;" id="messages"><s:property value="messages"/></div>
										<form id="adminDetailDto" name="formLogin" action="authentication" method="post" onsubmit="return(LoginValidation());">
										<fieldset>
											<p><input type="text" placeholder="Enter Username or Email Id" required name="loginId" id="istr_login_id"></p>
											<p><input type="password"  required name="password" placeholder="Enter Password" id="istr_password" type="password"></p>
											<h6><a href="forgotPassword">Forgot Password?</a></h6>
											<p><input type="submit" value="Login" id="login_button"></p>
										</fieldset>
								
										<input type="hidden" name="contextPath" id="contextPath" value="<%=request.getContextPath()%>"/>
										<input type="hidden" name="randomstr" id="randomstr" value="<s:property value='randomString'/>"/>
										</form>
										
										<p><span class="btn-round">or</span></p>
										
										<button class="loginBtn loginBtn--facebook"><a href="<%=fbConnection.getFBAuthUrl()%>">
										  	Login with Facebook
										</a></button>
										<br/>
										<br/>
										<button class="loginBtn loginBtn--google"><a href="<%=googleConnection.getGBAuthUrl()%>">
										  	Login with Google
										</a></button>	
										<br/>
										<br/>
									</div>
									</div>
									<div class="bot1">
									<table>
									<tr>
									<td align="left"><a href="xamdeskhome"><img src="image/logo_temp.png"/></a></td>
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
		<s:form theme="simple" autocomplete="off" id="socialUserDetails" action="socialUserDetails.action" name="socialUserDetails"  method="post">
			<s:hidden name="fb_email" id="fb_email"/>
			<s:hidden name="fb_fname" id="fb_fname"/>
			<s:hidden name="fb_lname" id="fb_lname"/>
			<s:hidden name="fb_verified" id="fb_verified"/>
			<s:hidden name="fb_birthday" id="fb_birthday"/>
			<s:hidden name="fb_token" id="fb_token"/>
		</s:form>	
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

		<!-- Scripts -->

			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/skel-viewport.min.js"></script>
			<script src="assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="assets/js/main.js"></script>

	</body>
</html>