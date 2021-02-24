<!DOCTYPE HTML>
<%@page import="java.net.URLEncoder"%>
<%@page import="com.oes.dto.SpotLightDetailsDto"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.oes.dto.BlogDetailsDto"%>
<%@page import="com.oes.action.Encryption"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.oes.dto.ContentDetailsDto"%>
<%@page import="java.util.List"%>
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
		<link rel="canonical" href="https://www.xamdesk.com">
		
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assets/css/main.css" />
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
	</head>
	<%
	List<ContentDetailsDto> contentDetailsDtoList = new ArrayList<ContentDetailsDto>();
	contentDetailsDtoList = (ArrayList<ContentDetailsDto>)request.getSession().getAttribute("contentDetailsDtoList");
	
	SpotLightDetailsDto spotLightDetailsDto = new SpotLightDetailsDto();
	spotLightDetailsDto = (SpotLightDetailsDto) request.getSession().getAttribute("spotLightDetailsDto");
	%>
	<body class="right-sidebar">
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
													<a href="#" class="current_page_item">Tutorials</a>
														<ul>
														<%if(contentDetailsDtoList != null && contentDetailsDtoList.size()>0) {
															for(ContentDetailsDto dto : contentDetailsDtoList) {
																%><li><a href="showStudentMaterials?contenttype=<%=URLEncoder.encode(dto.getOnum_slno().toString(), "UTF-8")%>"><%=dto.getOstr_content_name()%></a></li><%
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
							<%
							BlogDetailsDto blogDetailsDto = new BlogDetailsDto();
							List<BlogDetailsDto> blogDetailsDtoList = new ArrayList<BlogDetailsDto>();
							blogDetailsDtoList = (ArrayList<BlogDetailsDto>)request.getSession().getAttribute("blogDetailsDtoList");
				
							if(blogDetailsDtoList != null && blogDetailsDtoList.size()>0) {
								blogDetailsDto = blogDetailsDtoList.get(0);				
								 %>
								<div id="banner" style="width: 95%">
									<br/>
									<b style="text-transform: uppercase; color: #fff; color: rgba(255, 255, 255, 0.75); font-size: 2.5em; font-weight: 700; line-height: 1.3em; letter-spacing: 0.04em;"><%=blogDetailsDto.getContentDetailsDto().getOstr_content_name()%></b>
									<br/>
									<b style="color: #fff; color: rgba(255, 255, 255, 0.75); font-size: 1.0em; font-weight: 700; line-height: 1.3em; letter-spacing: 0.04em;"><%=blogDetailsDto.getContentDetailsDto().getOstr_content_details()%></b>
								</div>
							<%
							}
							%>
							
							
						</div>
					</div>
					<!-- Main Wrapper -->
				
			
					<div id="main-wrapper">
					<div class="wrapper style3">
						<div class="inner">
							
							<div class="container">
								<div class="row">
									<div class="8u 12u(mobile)">

										<!-- Article list -->
											<section class="box article-list">
												<h2 class="icon fa-file-text-o">Recent Posts</h2>

												<%if(blogDetailsDtoList != null && blogDetailsDtoList.size()>0) {
													DateFormat fmt = new SimpleDateFormat("MMMM dd, yyyy", Locale.US);	
													for(BlogDetailsDto dto : blogDetailsDtoList) {
													%>
													<!-- Excerpt -->
													<article class="box excerpt">
														<a href="showStudentMaterialsDetails?contenttype=<%=URLEncoder.encode(dto.getOnum_id().toString(), "UTF-8")%>" class="image left"><img src="<%=dto.getOstr_image_url()%>" alt="<%=dto.getOstr_headline()%>" width="100%" height="100%"/></a>
														<div>
															<header>
																<span class="date"><%=fmt.format(dto.getOdt_entry_date())%></span>
																<h3><a href="showStudentMaterialsDetails?contenttype=<%=URLEncoder.encode(dto.getOnum_id().toString(), "UTF-8")%>"><%=dto.getOstr_headline()%></a></h3>
															</header>
															<p><%=dto.getOstr_short_description()%></p>
														</div>
													</article>
													<%}
												} %>												
											</section>
									</div>
									
									
									<%
									if(spotLightDetailsDto != null && spotLightDetailsDto.getOnum_id() != null) {
									%>
									<div class="4u 12u(mobile)">

										<!-- Spotlight -->
											<section class="box spotlight">
												<h2 class="icon fa-file-text-o">Spotlight</h2>
												<article>
													<a href="#" class="image featured"><img src="<%=spotLightDetailsDto.getOstr_image_url()%>" alt="<%=spotLightDetailsDto.getOstr_headline()%>"></a>
													<header>
														<h3><a href="#"><%=spotLightDetailsDto.getOstr_headline()%></a></h3>
														<p><%=spotLightDetailsDto.getOstr_sub_headline()%></p>
													</header>
													<p style="text-align: justify;"><%=spotLightDetailsDto.getOstr_short_description()%></p>
													<footer>
														<a href="showSpotLightDetailsPage?contenttype=<%=URLEncoder.encode(spotLightDetailsDto.getOnum_id().toString(), "UTF-8")%>" class="button alt icon fa-file-o">Continue Reading</a>
													</footer>
												</article>
											</section>

									</div>
									<%
									}
									%>
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