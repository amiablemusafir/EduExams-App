<%@page import="com.oes.action.Encryption"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.oes.dto.ContentDetailsDto"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>XamDesk | Contact</title>
		<link rel='shortcut icon' type='image/x-icon' href='image/favicon.ico'/>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assets/css/main.css" />
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
		
		<link href="css_design/bootstrap_contact.css" rel="stylesheet" type="text/css" media="all" />
		<script src="js_design/jquery.min.js"></script>
		<link href="css_design/style_contact.css" rel="stylesheet" type="text/css" media="all" />	
		<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
		
		
		<script type="text/javascript">
		function StudentValidation() {
				 
				 $('#info').html('');
				 
				 var result = '';
				 var pattern = new RegExp(/^[0-9]{1,10}$/);
					 
				 
				 var name = document.getElementById('your_name').value;
				 if (name == '') {
					$('#info').html('Please Enter Your Name');
					document.getElementById('your_name').focus();

					return false;
				 }
					
				 var phone_no = document.getElementById('phone_no').value;
				 if (phone_no == '') {
					$('#info').html('Please Enter Phone Number');
					document.getElementById('phone_no').focus();

					return false;
				}
				
				if (!isInteger(phone_no)) {
					$('#info').html('Enter valid Phone Number');
					document.getElementById('phone_no').focus();
					return false;
				}
				if(phone_no.length != 10) {
					$('#info').html('Phone Number should 10 digits');
					document.getElementById('phone_no').focus();
					return false;
				}		
				var message = document.getElementById('message').value;
				if (message == '') {
					$('#info').html('Please Enter Message');
					document.getElementById('message').focus();

					return false;
				}
				
				var captchatext = document.getElementById('captchatext').value;
				if (captchatext == '') {
					$('#info').html('Please Enter Valid Details');
					document.getElementById('captchatext').focus();

					return false;
				}
				
				return true;	 	 
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
		</script>
	</head>
	<%
	List<ContentDetailsDto> contentDetailsDtoList = new ArrayList<ContentDetailsDto>();
	contentDetailsDtoList = (ArrayList<ContentDetailsDto>)request.getSession().getAttribute("contentDetailsDtoList");
	
	%>
	<body class="homepage">
		<div id="page-wrapper">

			<!-- Header -->
				<div id="header-wrapper">
					<div class="container">

						<!-- Header -->
							<header id="header">
								<div class="inner">

									<!-- Logo -->
										<h1><a href="index.html" id="logo"><img src="images/logo.png" style="width : 33%; margin-top: -0.8em;"></a></h1>

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
												<li><a href="RegistrationPage">Registration</a></li>
												<li class="current_page_item"><a href="ContactUs">Contact Us</a></li>
											</ul>
										</nav>

								</div>
							</header>
					</div>
				</div>

			<!-- Main Wrapper -->
				<div id="main-wrapper">
					<div class="wrapper style1">
						<div class="inner">

						<div align="center" style="color: #BF0C1B; font-size: 18px; font-weight: bold; margin-top: 20px;" id="info"><s:property value="info"/></div>
						<div class="contact">
							
						<div class="container" style="width: 1024px;"> 
							<div class="contact-form" style="width: 100%;">
								<table width="100%">
								<tr>
								<td width="45%">
								<div class="col-md-6 contact-grid">
									<h3>Contact form</h3>
									<form action="SaveContactUsDetails" method="post" onsubmit="return(StudentValidation());">
										Your Name
										<input type="text" name="your_name" id="your_name" style="background: #A7A5A5;">
										Your Phone number
										<input type="text" name="phone_no" id="phone_no" style="background: #A7A5A5;">
										Your Message
										<textarea cols="77" rows="6" name="message" id="message" style="background: #A7A5A5;"></textarea>
										<div style="float: left;">
										Enter text as shown below<br/>
										<img src="<%=request.getContextPath()%>/showCaptcha" style="box-shadow: 0 1px 3px rgba(0,0,0,0.12), 0 1px 2px rgba(0,0,0,0.24); -webkit-border-radius: 10px 10px 10px 10px; -moz-border-radius: 10px 10px 10px 10px; border-radius: 10px 10px 10px 10px; background-color: rgb(239, 192, 119); -webkit-box-shadow: #B3B3B3 15px 15px 15px;"> 
										</div>
										<div style="float: left;">
										&nbsp;<br/>
										<input type="text" name="captchatext" id="captchatext" style="background: #A7A5A5; width: 150px;">
										</div>
										<div class="send" style="float: right; width: 100%" align="center">
											<br/><input type="submit" value="Send" >
										</div>
									</form>
								</div>
								</td>
								<td width="10%"></td>
								<td width="45%">
								<div class="col-md-6 contact-in">
									<h3>Contact information</h3>
									<br/>
									
									<p class="sed-para"> Thank you for your interest in XamDesk. Please enter the following information: Name, Mobile no. and message/query.</p>
									<br/>
									<p class="sit-in" style="text-align: justify;">Feel free to contact XamDesk for any Feedback. We value your feedback and product suggestions. If you need a call back from us, Fill the ENQUIRY FORM, you will get the call back from us within 24-48 hours. If you need to complain against someone in XamDesk, Write a mail to <b><a href="mailto:info@xamdesk.com">info@xamdesk.com</a></b>. Your feedback will be forwarded to the management for appropriate corrective measures and we will try to solve your problem as soon as possible.</p>
									
									<br/>
									<div class="sed-para">
									
										<p class="sed-para">
										<b>Tel: &nbsp;&nbsp;(+91) 9958903074, 9090459655</b><br/>
										<b>Email: &nbsp;&nbsp;<a href="mailto:info@xamdesk.com">info@xamdesk.com</a></b></p>
									</div>
									<div class="clearfix"> </div>
								</div></td>
								</tr>
								</table>
								
								
								<div class="clearfix"> </div>
							</div>
						

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
		<!-- Scripts -->

			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.dropotron.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/skel-viewport.min.js"></script>
			<script src="assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="assets/js/main.js"></script>

	</body>
</html>