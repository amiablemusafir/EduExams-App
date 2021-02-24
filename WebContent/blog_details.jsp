<!DOCTYPE HTML>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.oes.dto.BlogDetailsDto"%>
<%@page import="com.oes.action.Encryption"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.oes.dto.ContentDetailsDto"%>
<%@page import="java.util.List"%>

<%
BlogDetailsDto blogDetailsDto = new BlogDetailsDto();
blogDetailsDto = (BlogDetailsDto) request.getSession().getAttribute("blogDetailsDto");			
%>
<html>
	<head>
		<title>XamDesk | <%=blogDetailsDto.getOstr_headline()%></title>
		<link rel='shortcut icon' type='image/x-icon' href='image/favicon.ico'/>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		
		<meta name="url" content="https://www.xamdesk.com/showStudentMaterialsDetails?contenttype=<%=URLEncoder.encode(blogDetailsDto.getOnum_id().toString(), "UTF-8")%>"/>
		<meta name="title" content="<%=blogDetailsDto.getOstr_headline()%>"/>
		<meta name="description" content="<%=blogDetailsDto.getOstr_short_description()%>"/>
		<meta name="image" content="https://www.xamdesk.com/<%=blogDetailsDto.getOstr_image_url()%>"/>

		<meta property="og:site_name" content="Xamdesk"/>
		<meta property="og:type" content="article"/>
		<meta property="og:url" content="https://www.xamdesk.com/showStudentMaterialsDetails?contenttype=<%=URLEncoder.encode(blogDetailsDto.getOnum_id().toString(), "UTF-8")%>" />
		<meta property="og:type" content="article" />
		<meta property="og:title" content="<%=blogDetailsDto.getOstr_headline()%>" />
		<meta property="og:description" content="<%=blogDetailsDto.getOstr_short_description()%>" />
		<meta property="og:image" content="https://www.xamdesk.com/<%=blogDetailsDto.getOstr_image_url()%>" />
		<meta property="og:image:type" content="image/jpeg" />
		<meta property="og:image:width" content="1200" />
		<meta property="og:image:height" content="630" />
		
<%-- 		
   <!-- <meta property="og:locale" content="hi_IN"/> -->
		<meta property="og:type" content="article"/>
		<meta property="og:site_name" content="XamDesk"/>
		<meta property="og:url" content="https://www.xamdesk.com/showStudentMaterialsDetails?contenttype=<%=Encryption.encryptText(blogDetailsDto.getOnum_id().toString())%>"/>
		<meta property="og:title" content="<%=blogDetailsDto.getOstr_headline()%>"/>
		<meta property="og:description" content="<%=blogDetailsDto.getOstr_short_description()%>"/>
		<meta property="og:updated_time" content="<%=blogDetailsDto.getOdt_entry_date()%>"/>
		<meta property="og:image" content="https://www.xamdesk.com/<%=blogDetailsDto.getOstr_image_url()%>"/>
		<meta property="og:image:type" content="image/jpeg"/>
		<meta property="og:image:width" content="850"/>
		<meta property="og:image:height" content="550"/> --%>
		
		
		<meta name="twitter:card" content="summary_large_image">
    	<meta name="twitter:site" content="@xamdesk">
    	<meta name="twitter:title" content="<%=blogDetailsDto.getOstr_headline()%>">
    	<meta name="twitter:description" content="<%=blogDetailsDto.getOstr_short_description()%>">
    	<meta name="twitter:creator" content="@xamdesk">
    	<meta name="twitter:image:src" content="https://www.xamdesk.com/<%=blogDetailsDto.getOstr_image_url()%>">
    	<meta name="twitter:image:alt" content="<%=blogDetailsDto.getOstr_headline()%>" />
    	<meta name="twitter:domain" content="https://www.xamdesk.com/">
    	<meta name="twitter:image:width" content="850"/>
		<meta name="twitter:image:height" content="550"/>
		
		<link rel="canonical" href="https://www.xamdesk.com/showStudentMaterialsDetails?contenttype=<%=URLEncoder.encode(blogDetailsDto.getOnum_id().toString(), "UTF-8")%>"/>
		
		<!-- Place this tag in your head or just before your close body tag. -->
		<script src="https://apis.google.com/js/platform.js" async defer></script>		
		<script async src="//platform.twitter.com/widgets.js" charset="utf-8"></script>
			
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assets/css/main.css" />
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
	
	</head>
	<%
	List<ContentDetailsDto> contentDetailsDtoList = new ArrayList<ContentDetailsDto>();
	contentDetailsDtoList = (ArrayList<ContentDetailsDto>)request.getSession().getAttribute("contentDetailsDtoList");
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
						</div>
				</div>
				<!-- Main Wrapper -->
				<%
				DateFormat fmt = new SimpleDateFormat("MMMM dd, yyyy", Locale.US);	
				
				List<BlogDetailsDto> blogDetailsDtoList = new ArrayList<BlogDetailsDto>();
				blogDetailsDtoList = (ArrayList<BlogDetailsDto>)request.getSession().getAttribute("blogDetailsDtoList");
				%>

				<!-- Main Wrapper -->
				<div id="main-wrapper">
					<div class="wrapper style2">
						<div class="inner">

							<!-- Feature 1 -->
								<section class="container box feature1"style="width: 80%;">
											<div style="width: 50%; float: left;" align="left">	
											<div class="fb-like" data-href="https://www.xamdesk.com/showStudentMaterialsDetails?contenttype=<%=URLEncoder.encode(blogDetailsDto.getOnum_id().toString(), "UTF-8")%>" data-layout="button_count" data-action="like" data-size="small" data-show-faces="true" data-share="true"></div>										
											<div class="fb-follow" data-href="https://www.facebook.com/xamdesk/" data-layout="button" data-size="small" data-show-faces="true"></div>
											<div class="fb-save" data-uri="https://www.xamdesk.com/showStudentMaterialsDetails?contenttype=<%=URLEncoder.encode(blogDetailsDto.getOnum_id().toString(), "UTF-8")%>" data-size="small"></div>
											</div>
											
											<div style="width: 50%; float: right;" align="right">	
											<!-- Place this tag where you want the share button to render. -->
											<div class="g-plus" data-action="share" data-annotation="none"></div>
											<a href="https://twitter.com/share" class="twitter-share-button" data-size="small" data-url="https://www.xamdesk.com" data-show-count="false">Tweet</a><script async src="//platform.twitter.com/widgets.js" charset="utf-8"></script>
											</div>
									<div class="row">
										<div class="12u">
											<span class="date" align="left"><%=fmt.format(blogDetailsDto.getOdt_entry_date())%></span>
											<h2 align="left"><%=blogDetailsDto.getOstr_headline()%></h2>
											<div style="color: #000000;"><%=blogDetailsDto.getOstr_message()%></div>						
											
											
											<div style="width: 50%; float: left;" align="left">	
											<div class="fb-like" data-href="https://www.xamdesk.com/showStudentMaterialsDetails?contenttype=<%=Encryption.encryptText(blogDetailsDto.getOnum_id().toString())%>" data-layout="button_count" data-action="like" data-size="large" data-show-faces="true" data-share="true"></div>										
											<div class="fb-follow" data-href="https://www.facebook.com/xamdesk/" data-layout="button" data-size="large" data-show-faces="true"></div>
											<div class="fb-save" data-uri="https://www.xamdesk.com/showStudentMaterialsDetails?contenttype=<%=Encryption.encryptText(blogDetailsDto.getOnum_id().toString())%>" data-size="large"></div>
											</div>
											
											<div style="width: 40%; float: left;" align="right">	
											<!-- Place this tag where you want the share button to render. -->
											<div class="g-plus" data-action="share" data-annotation="none" data-height="36"></div>
											&nbsp;&nbsp;
											</div>
											<div style="width: 10%; float: right;" align="left">	
											<a href="https://twitter.com/share" class="twitter-share-button" data-size="large" data-url="https://www.xamdesk.com/contenttype=<%=Encryption.encryptText(blogDetailsDto.getOnum_id().toString())%>" data-show-count="false">Tweet</a>
											</div>
										</div>
									</div>
								</section>
							</div>										
						</div>
					</div>
								
				<div id="main-wrapper">
					<div class="wrapper style3">
						<div class="inner">
							<div class="container">
							
								<div class="row">
								
								<%if(blogDetailsDtoList != null && blogDetailsDtoList.size()>0) {
									for(BlogDetailsDto dto : blogDetailsDtoList) {
									%>
									<div class="4u 12u(mobile)">
									<!-- Excerpt -->
									<article class="box excerpt">
									<header>
										<span class="date"><%=fmt.format(dto.getOdt_entry_date())%></span>
										<h3><a href="showStudentMaterialsDetails?contenttype=<%=URLEncoder.encode(dto.getOnum_id().toString(), "UTF-8")%>"><%=dto.getOstr_headline()%></a></h3>
									</header>
					
									<div>
										<a href="showStudentMaterialsDetails?contenttype=<%=URLEncoder.encode(dto.getOnum_id().toString(), "UTF-8")%>" class="image left"><img src="<%=dto.getOstr_image_url()%>" alt="<%=dto.getOstr_headline()%>" width="100%" height="100%"/></a>
										<p align="justify"><%=dto.getOstr_short_description()%></p>
									</div>
									</article>
								</div>
								<%}
							} %>	
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

			<div id="fb-root"></div>
			<script>
			  (function(d, s, id) {
			  var js, fjs = d.getElementsByTagName(s)[0];
			  if (d.getElementById(id)) return;
			  js = d.createElement(s); js.id = id;
			  js.src = "//connect.facebook.net/en_GB/sdk.js#xfbml=1&version=v2.8";
			  fjs.parentNode.insertBefore(js, fjs);
			  }(document, 'script', 'facebook-jssdk'));
			</script>												
	</body>
</html>