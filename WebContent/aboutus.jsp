<%@page import="com.oes.action.Encryption"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.oes.dto.ContentDetailsDto"%>
<%@page import="java.util.List"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>XamDesk | About Us</title>
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
													<h2>About Us</h2>
													<img src="image/about_banner.jpg" style="width: 100%;">
										
													<div class="about-top">
														
														<div class="col-md-8 book">
															<p style=" text-align: justify;">The website provide a  Test Series  which consists of randomly selected questions  from a vast question bank. The question bank containing thousands of question & has been prepared keeping in view of the revised pattern and syllabus( All the four papers)  for all Competitive Examination of Posts as applicable from the previous years. Questions from the previous years Examination also have been included in the Question Bank and Test Series.
															<br/><br/>
															Members may take the online test as per their convenience. There is a fixed Time Limit for each test  keeping in view the the time available in the present  pattern of examination which allows ,on an average , a time period of 2 minutes for each question. While preparing for the examination,a candidate should time his responses to a period that is lesser than the allotted average .
															<br/><br/>
															This time bound Test Series will not only enhance the ability of the candidate to reduce the response-time in answering a   question but  also help the candidate to check his  response-time and consolidating his knowledge on subjects by taking  Tests again and again.The result  and all over India ranking of the test taken by the candidate will be declared within a few hours so that the candidate may able to review his performance and improve it in the forthcoming tests.
															</p>						
														</div>
													</div>
													
													<p style="font-size: 15px; text-align: justify;">This website will also make an endeavour to assist the member and viewer to get up-to-date information, news and reports as well as the latest developments concerning in  the Department of Posts.
													In additionthe website also aims to provide its visitor with various useful links viz., Departments under the Government of India and various State Governments Websites, etc.
													The adminstrative /departmental rules and regulations, the laws and other relevant data have been based on authorised texts. Due care has been taken to check the accuracy and updation of data. The members and viewers are also advised to read the relevant authorised texts of prescribed laws, rules, regulations, manuals, handbooks and guide before  attempting the questions accessible through the website so they may get benefitted most.
													</p>
													<p style="font-size: 15px; text-align: justify;">I would like to welcome you once again to the <b>XAMDESK</b> which I hope you will find it interesting as well as beneficial. Your valuable suggestions and feedback is solicited .</p>
													
													<p style="font-size: 14px; text-align: justify;"><b>Disclaimer: </b>The Director & Developer shall not be liable or severally, for the updation, accuracy and correctness of the statutory, judicial, administrative, regulatory or departmental provisions discussed in the tests & text available on the website and also dont take any resposibility for the the absolute accuracy of any information made available on the website and the damages or loss suffered. thereupon. Only the courts at Delhi shall have the jurisdiction for any legal dispute.</p>
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