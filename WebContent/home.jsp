<!DOCTYPE HTML>
<%@page import="com.oes.action.GoogleConnection"%>
<%@page import="com.oes.action.FBConnection"%>
<%@page import="com.oes.action.Encryption"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.oes.dto.ContentDetailsDto"%>
<%@page import="java.util.List"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>XamDesk | Home</title>
		<link rel='shortcut icon' type='image/x-icon' href='image/favicon.ico'/>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		
		<meta name="description" content="Xamdesk.com help you to prepare for all examination like Govt & Private both SSC, IAS, BANK, RAILWAY, JAVA, .NET, LIC, BPSC etc. We keep
		 students update with latest study materials and news updates. We also providing study materials (Online Test, eBooks, Books, e-Practice Set PDF) we provides test series for students preparing 
		 for competitives examination" />	
		<meta name="keywords" content="online exam, exam preparation, online practice page, free mock test, online practice set, free online test, bank exam, po exam, ibps, sbi, bpsc, bpsc online test,
		 bpsc online, bank exam, bpsc exam, po exam, mock test, jee, ojee"/>		
		<link rel="canonical" href="https://www.xamdesk.com"/>
		<script language="javascript" type="text/javascript" src="js/md5hash.js"></script>
		<script language="javascript" type="text/javascript" src="js/homepage.js"></script>
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assets/css/main.css" />
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
		<link rel="stylesheet" href="style/home_style.css" />
		<%
			FBConnection fbConnection = new FBConnection();
			GoogleConnection googleConnection = new GoogleConnection();
		%>		
	</head>
	<%
	List<ContentDetailsDto> contentDetailsDtoList = new ArrayList<ContentDetailsDto>();
	contentDetailsDtoList = (ArrayList<ContentDetailsDto>)request.getSession().getAttribute("contentDetailsDtoList");
	
	%>
	<body class="homepage" onload="document.getElementById('id02').style.display='block'">
		<div id="page-wrapper">
				<!-- Header -->
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
												<li class="current_page_item"><a href="xamdeskhome">Home</a></li>
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
												<li><a href="#" onclick="document.getElementById('id01').style.display='block'">Login</a></li>												
												<li><a href="RegistrationPage">Registration</a></li>
												<li><a href="ContactUs">Contact Us</a></li>
											</ul>
										</nav>

								</div>
							</header>

						<!-- Banner -->
							<div id="banner">
								<h2><img src="images/banner_home_page.png" style="width : 90%;"></h2>
								<p>Interested?? Want to register with XamDesk?? Click the big button.</p>
								<a href="RegistrationPage" class="button big icon fa-check-circle">REGISTER</a>
							</div>
					</div>
				</div>

			<!-- Main Wrapper -->
				<div id="main-wrapper">
					<div class="wrapper style1">
						<div class="inner">

							<!-- Feature 1 -->
								<section class="container box feature1">
									<div class="row">
										<div class="12u">
											<header class="first major">
												<h2>WELCOME  TO XAMDESK,</h2>
												<p>It gives us great pleasure in welcoming you to the website of <strong>XAMDESK</strong> devised by the <strong>SIS Group</strong>. <br/>A platform for the government job aspirants that will provide them most accurate and reliable myriad test series and study materials.</p>
											</header>
										</div>
									</div>
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
									<div class="row">
								
										<div class="12u">
											
											<p style="text-align: justify;">This website is designed to facilitate the search of government job aspirants regarding study materials, mock test and to serve their entire preparation query.The website provide a Test Series which consists of randomly selected questions from a vast question bank. The question bank containing thousands of question & has been prepared keeping in view of the revised pattern and syllabus( All the four papers) for Limited Departmental Competitive Examination for the post of Inspector of Posts as applicable from the year 2011. Questions from the previous years Examination also have been included in the Question Bank and Test Series.<br/><br/>
											‘Melange’ section contains practice book which will provide them with a series of online test for different government examinations mainly IBPS PO/CLERK, SBI PO/ CLERK, SSC CGL, SSC CHSL, RBI Assistants etc., GK updates on daily and weekly basis and gist of current affairs month wise, E- books and topic and subject-wise notes for examination preparation.Members may take the online test as per their convenience. There is a fixed Time Limit for each test keeping in view the the time available in the present pattern of examination which allows ,on an average , a time period of 2 minutes for each question. While preparing for the examination,a candidate should time his responses to a period that is lesser than the allotted average .
											<br/><br/>
											Members need to login with us in order to gain from our myriad offerings starting from test series to e-books. They can also review their performance and thus resulting into overall development.
											<br/><br/>
											Not to mention, we are bound to serve you better, give you the best and let the best come out of you.This time bound Test Series will not only enhance the ability of the candidate to reduce the response-time in answering a question but also help the candidate to check his response-time and consolidating his knowledge on subjects by taking Tests again and again.The result and all over India ranking of the test taken by the candidate will be declared within a few hours so that the candidate may able to review his performance and improve it in the forthcoming tests.
											</p>
										
											<p style="text-align: justify;"><b>So, be a part of us and end your monotonous and traditional ways of examination preparation.</b></p>
										
										</div>
									</div>
								</section>

						</div>
					</div>
					<div class="wrapper style2">
						<div class="inner">

							<!-- Feature 2 -->
								<section class="container box feature2">
									<div class="row">
										<div class="6u 12u(mobile)">
											<section>
												<header class="major">
													<h2>Already have account ? </h2>
													<p>Best of luck for your upcoming session.</p>
												</header>
												<p>Just put your time, zeal, commitment & efforts, and leave the rest<br/>
												<b>XAMDESK</b> promise your investment will yield you Success and Knowledge <br/> 
												with the upcoming test. Wishing you a successful endeavour<br/>
																								 
												</p>
												<footer>
													<a href="accountLogin" class="button medium icon fa-arrow-circle-right">Signin</a>
												</footer>
											</section>
										</div>
										<div class="6u 12u(mobile)">
											<section>
												<header class="major">
													<h2>New to Xamdesk ?</h2>
													<p>A must have runway to excel your career.</p>
												</header>
												<p>You must be well prepared and for you exams will be a piece of cake<br/>
												But to judge trajectory of your flight among the fleets you need to check<br/>
												And for that <b>XAMDESK</b> will provide you the runway you must take</p>
												<footer>
													<a href="RegistrationPage" class="button medium alt icon fa-info-circle">signup</a>
												</footer>
											</section>
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
		
		<div id="id01" class="modal">  
		  <div class="modal-content animate"> 
		  	  <div class="imgcontainer">
				      <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
				      <div class="register-head">
				      <img src="image/rect.png" class="rect-img">
				      <span id="login_header">&nbsp;&nbsp;Login Into Your Acount</span>
				      <span id="registration_header" style="display: none;">&nbsp;&nbsp;Don't have an account? Registration</span>
				      </div>
			  </div>
			  <div align="center" style="color: #D22117; font-size: 14px; font-weight: bold;" id="messages"><s:property value="messages"/></div>
			  <div id="login_form">
			  <div style="margin-top: 25px;">
			  	  <hr style="border-top: dotted 1px;"/>
			  </div>
			  <div id="login_form_page_left">
				  <form id="adminDetailDto" name="formLogin" action="authentication" method="post" onsubmit="return(LoginValidation());">					
			  	     
				      <div class="container_login">
				     <label style="margin-top: 15px;"><b>Username / Email Id</b></label>
				      <input type="text" placeholder="Enter Username" name="loginId" id="istr_login_id" style="background: rgba(224, 223, 223, 0.55);">
					  <div align="left" style="color: #D22117; font-size: 14px;" id="username"></div>
					  
					  <label style="margin-top: 15px;"><b>Password</b></label>
				      <input type="password" placeholder="Enter Password" name="password" id="istr_password" style="background: rgba(224, 223, 223, 0.55);">
				      <div align="left" style="color: #D22117; font-size: 14px;" id="password"></div>  
				        
				      <br/>
				      <button type="submit" id="login_button">LOGIN NOW</button>
				      <span class="psw"><a href="forgotPassword" style="text-decoration: none; font-weight: bold;">Forgot password?</a></span>
				      </div>			        
				  </form>			  		  
			  </div>
			  <div id="login_form_page_right">
				<br/>
				&nbsp;&nbsp;&nbsp;&nbsp;<button class="loginBtn loginBtn--facebook"><a href="<%=fbConnection.getFBAuthUrl()%>">
				  	Login with Facebook
				</a></button>
				<br/>
				<br/>
				&nbsp;&nbsp;&nbsp;&nbsp;<button class="loginBtn loginBtn--google"><a href="<%=googleConnection.getGBAuthUrl()%>">
				  	Login with Google
				</a></button>	
			  </div>	
			  <div class="container_login" style="background-color:#f56417; width: 100%;">
			  	   &nbsp;&nbsp;	
				   <br/><b style="color: #ffffff;">New to XamDesk? <a href="#" onclick="showRegistrationForm();">Register</a></b>		      
			  </div> 
			  </div>
			  
			  
			  <div id="registration_form" style="display: none;">
			  <div style="margin-top: 25px;">
		     	  <hr style="border-top: dotted 1px;"/>
		      </div>
			  <div id="login_form_page_left">						
		  	  <s:form theme="simple" autocomplete="off" id="saveUserDetails" action="saveUserDetails.action" name="studentDetailsDto"  method="post" onsubmit="return(StudentValidation());">
				  
			 
			      <div class="container_login">
			      <table width="100%">
			      <tr>
			      <td><label style="margin-top: 15px;"><b>Name</b></label></td>
			      <td><s:textfield theme="simple" name="studentDetailsDto.istr_first_name" id="istr_first_name" tabindex="1" placeholder="Enter Full Name" style="background: rgba(224, 223, 223, 0.55);"/></td>
				  </tr>
				  
				  <tr>
			      <td></td>
			      <td> <div align="left" style="color: #D22117; font-size: 14px;" id="reg_username"></div></td>
				  </tr>
				  
			      <tr>
			      <td><label style="margin-top: 15px;"><b>Emai Id</b></label></td>
			      <td><s:textfield theme="simple" name="studentDetailsDto.istr_email" id="istr_email" tabindex="2" placeholder="Enter Email Id" style="background: rgba(224, 223, 223, 0.55);"/></td>
			      </tr>
			      
			      <tr>
			      <td></td>
			      <td> <div align="left" style="color: #D22117; font-size: 14px;" id="reg_emailid"></div></td>
				  </tr>
				  
			      <tr>
			      <td><label style="margin-top: 15px;"><b>Mobile</b></label></td>
			      <td><s:textfield theme="simple" name="studentDetailsDto.inum_mobile_number" id="inum_mobile_number" tabindex="3" placeholder="Enter Mobile No" style="background: rgba(224, 223, 223, 0.55);"/></td>
			      </tr>
			      
			      <tr>
			      <td></td>
			      <td><div align="left" style="color: #D22117; font-size: 14px;" id="reg_phoneno"></div></td>
				  </tr>
				  
			      
			      </table>
			      <p style="font-size: 10px; margin-top: 15px;">By proceeding further you agree to XamDesk's <a  href="termAndCondition.action" target="_blank" style="cursor: pointer;"><b>Terms & Conditions</b></a></p>
			      <button type="submit" id="login_button" style="margin-top: -50px;">REGISTER</button>
			      </div>
			
			         
			  </s:form>
			  </div>
			  <div id="login_form_page_right">
				<br/>
				&nbsp;&nbsp;&nbsp;&nbsp;<button class="loginBtn loginBtn--facebook"><a href="<%=fbConnection.getFBAuthUrl()%>">
				  	Continue with Facebook
				</a></button>
				<br/>
				<br/>
				&nbsp;&nbsp;&nbsp;&nbsp;<button class="loginBtn loginBtn--google"><a href="<%=googleConnection.getGBAuthUrl()%>">
				  	Continue with Google
				</a></button>	
			  </div>			  
			  <div class="container_login" style="background-color:#f56417;">
			       &nbsp;&nbsp;	
				   <br/><b style="color: #ffffff;">Already have an account? <a href="#" onclick="showLoginForm();">Login</a></b>
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
				
		<%-- 
		<div id="id02" class="modal2">  
		  <div class="modal-content2 animate"> 
		  	<div class="imgcontainer" style="background-color:  #2e3378;">
				 <span onclick="document.getElementById('id02').style.display='none'" class="close2" title="Close Modal">&times;</span>				      
			</div>
			<img alt="Advertisement" src="images/OIOT1.jpg" width="100%" height="100%"/>
			<div style="color: #f78478; font-size: 18px; font-style: italic;" align="center"><a href="RegistrationPage" target="_blank">Click here for Registration</a></div> 
		  </div>
		</div> 
		--%>
		
		<input type="hidden" name="contextPath" id="contextPath" value="<%=request.getContextPath()%>"/>
		<input type="hidden" name="randomstr" id="randomstr" value="<s:property value='randomString'/>"/>
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