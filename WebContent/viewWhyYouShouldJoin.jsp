<%@page import="com.oes.action.Encryption"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.oes.dto.ContentDetailsDto"%>
<%@page import="java.util.List"%><!DOCTYPE HTML>
<html>
	<head>
		<title>XamDesk | Why you should join</title>
		<link rel='shortcut icon' type='image/x-icon' href='image/favicon.ico'/>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assets/css/main.css" />
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
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
												<li class="current_page_item"><a href="AboutUs">About Us</a></li>
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
												<li><a href="ContactUs">Contact Us</a></li>
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

							<!-- Feature 1 -->
								<section class="container box feature1"style="width: 80%;">
									<div class="row">
										<div class="12u">
													<h2>Why you should join ??</h2>
													
													<div class="about-top">
														
														<h4 align="left">Benefits:&nbsp;&nbsp;One India One Test (Test your competitiveness)
														It is a chance for you to compete with many more aspirants than your classroom or coaching institute or even city.
														</h4>
															
														<h4 align="left">>> Rewards & Recognition</h4>
														<img alt="Advertisement" src="images/OIOT1.jpg" width="100%" height="100%"/>
													
																												
														<h4 align="left">>> Performance Excellency</h4>
														<p style="text-align: justify;">
														Most exams are being conducted online these days. Our <b>One India One Test</b> simulates the exact experience of an online exam and would help you get a real time scenario what an Online exam is all about before you sit for the real test.
														</p>
														
														<h4 align="left">>> Get your All India rank</h4>
														<p style="text-align: justify;">
														The All India Rank you secure after attempting our One India One Test will be a better evaluation of your exam preparation because you'd see yourself competing against millions of other candidates from all over India. 
														</p>
														
														<h4 align="left">>> Real simulation of exam</h4>
														<p style="text-align: justify;">
														By attempting an One India One Test before your actual examination, you'd cut down on the mistakes, errors you may commit in the real exam.  
														</p>
														
													</div>
													
													<br/>
													
													<div class="row">
														<div class="4u 12u(mobile)">
															<section>
																<a href="#" class="image featured"><img src="images/pic02.png" alt="" /></a>
															</section>
														</div>
														<div class="4u 12u(mobile)">
															<section>
																<a href="#" class="image featured"><img src="images/pic03.png" alt="" /></a>
															</section>
														</div>
														<div class="4u 12u(mobile)">
															<section>
																<a href="#" class="image featured"><img src="images/pic01.png" alt="" /></a>
															</section>
														</div>
													</div>													
													
													</div>
											</div>
										</section>
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
								<li>&copy; XamDesk. All rights reserved</li><li>Developed By: <a href="http://squareinterface.com">Square Interface Solutions Pvt Ltd.</a></li>
							</ul>
						</div>							
		</footer>
			
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.dropotron.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/skel-viewport.min.js"></script>
			<script src="assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="assets/js/main.js"></script>

	</body>
</html>