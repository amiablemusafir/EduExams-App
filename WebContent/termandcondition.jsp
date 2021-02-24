<%@page import="com.oes.action.Encryption"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.oes.dto.ContentDetailsDto"%>
<%@page import="java.util.List"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>XamDesk | Term & Condition</title>
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
													<h2>TERMS & CONDITIONS</h2>
													
													<div class="about-top">
														
														<h4 align="left">General Terms and Conditions:</h4>
														<p style="text-align: justify;">This page (together with the documents referred to on it) tells you("you" means the individual using the Website) the terms and conditions on which you may register yourself on website  www.xamdesk.com (website).  Please read these terms and conditions carefully and make sure that you understand them, before registering yourself on website. You should understand thant by registering yourself on website you agree to be bound by these terms and condiions . Please click on the button marke "I Accept" at the end of terms and conditions if you accept them. Please understand that if you refuse to accept these terms and conditions, you will not be able to register on website.</p>
														<p style="text-align: justify;">www.xamdesk.com is a site operated by XamDesk an online institute registered under the INDIAN REGISTRATION ACT,1908 with registeration no. 2122 .</p>
														
														<p style="text-align: justify;">
														1.	Governing Law:
														These terms and conditions shall be governed by and construed in accordance with the laws of REPUBLIC OF INDIA and you irrevocably submit to the exclusive jurisdiction of the courts of DELHI(INDIA).
														<br/><br/>
														2.	Access:
														You are provided with access to this website in accordance with these terms and conditions and any registrations or other general use of the website is strictly in accordance with these terms and conditions. Access to this website is permitted on a temporary basis or for a lmited time or for a fixed number of test taken by you, and we reserve the right to modify or withdraw, temporaritly or permanently , this wessiete (or any part thereof) with or without notice to your and you confirm that Xamdesk shall not be liable to you or any third party for any modification to or withdrawal of the website. Xamdesk will not be liable if for any reason the website is unavailable at any time or for any period.  Some parts of the website are restricted to use by registered members of Xamdesk only.
														<br/><br/>
														3.	Compensate against loss suffered:
														You agree fully to compesate for loss sustanined, defend an hold Xamdesk , harmless immedaitley on demand, from and agaisnt all claims, liability, damages, losses , costs and expenses, including reasonable legal fees,arising out of any breach of these terms and conditions by you or any other liabilities arising out of your use of this website, or the use by any other person accessing the website using your membership accountand /or your peronal information.
														<br/><br/>
														4.	Registration:
														You warrant that:
														<br/>
															a) You are at least 18 years old;
														<br/>
															b) You are legally capable of entering into binding contracts;
														<br/>
															c) The personal information which you are required to provide when you register as a member of Xamdesk is true, accurate, current and complete in all respect;
														<br/>    
														    d) You will notify us immediately fo any changes to the Personal Information by contacting by e-mail or SMS; 
														<br/>	
															e) You agree not to impersoante any other person or entity or to use a false name or a name that your are not authorised to use.
														<br/>	
															f) You will not share your user name and password with any other person or with multiple users on a network.
														<br/>
														5.	Our Rights:
														We have the right to revise and amend these terms and conditions from time to time to reflect chages in technology, chages in relevant laws and regulatory requirements and changes in Xamdesk system's capabilities. You will be sbujct to the polices and terms and conditons in force at the time when you register yourself, unless any change to those policies or these terms and conditions is reuired to be made by law or governmental authority . It is your responsibility to check regularly to determine whether these terms and conditions have been changed . We will not use this right to vary the terms of any term which may materially affect the contract. If you do not agree to any change to these terms and conditions then you must immediately stop using the website.
														<br/><br/>
														The content of this site and content of sites linked to and from this site are provided "asis" and "as available", without warranties of any kind. Xamdesk does not accept any liablity arising from any inaccuracy or omission in information or interruption in availability.Any error or omission in any information, or document issued by Xamdesk shall be subject to correction provided that the correction does not materially affect the contract.You are advised to verify the accuracy of any information before relying on it. Xamdesk does not warrant that the materials on website will be error free, nor free of viruses , defamatory offensive, or other harmful matter.  You assume the entire cost of any necessary service or correction that you may incur as a result of using this website.The information on this website does not necessarily reflect the views and opinions of Xamdesk. Materials and other things posted on the website are not intended to amount to advice on which reliance should be placed. Xamdesk therefore disclaim all liability and responsibility arising from any reliance placed on such materials by any visitor to the website, or by anyone who may be informed of any of its contens. Under no circumstances shall Xamdesk, its affiliates, or any other person associated with Xamdesk be liable for  any damages arising out of the use or inability to use the materials in this site or any linked site, evern if we are advised of the possiblity thereof, nor for any claim by a third pary . However, nothing isn these terms and conditions restrict or exclude any liability that Xamdesk has to any party which cannot be excluded by law. Yur agree to use this site for lawful purposes only and not in any way that might infringe third party rights or that might bring Xamdesk into disrepute. When using Xamdesk site, you must comply with the provisions of Xamdesk acceptance policy. You are responsible for making all arrangements necessary for you to have access to Xamdesk site. You are also responsible for ensuring that all persons who access Xamdesk site throgh your internet connection are aware of these terms and conditions and that they comply with them.
														
														<br/><br/>
														6.	Copyright 
														Xamdesk, Narayan online institute of competition and its site are all registereed property of Xamdesk .I am the owner or the licensee of all intellectual property rights in this website , and of the material published on it. Those works are protected by copyright laws in INDIA. All such rights are reserved.You may draw the attention of others within your organisation to material posted on the website. You must not modity the paper or digital copies of any materials you have printed off or downloaded in any way, and you must not use any illustarions,photographs,video or audio sequences or any graphics separately from any accompanying text.Xamdesk status (and that of any contributors) as the authors of material on the website must always be acknowledged. You must not use any part of the materials on Xamdesk website for commercial purposes without obtaining a licence to do so from NIOC or our licensors. If you print off, coy or download any part of the website in breach of these terms and conditions, your right to use the website will cease immediately and you must, at Xamdesk option, return or destroy any copies of the materials you have made.
														<br/><br/>
														7.	Viruses, hacking and other offences:
														You must not misuse the website by knowingly introducing viruses, trojans, worms, logic bombs or other material which is malicious or technologically harmful. You must not attempt to gain unauthorised access to the website , the server on which the website is stored or any server, computer or database connected to the website. You must not attack the website via a denial-of- service attack or a distributed denial- of-service attack. In the event of such breach, your right to use the website will cease immediately.We will not be liable for any loss or damage caused by a distributed denial-of-service attack , viruses or other technologically harmful material that may infect your computer equipment, computer programs, data or other proprietary material due to your use of the website or to your downloading of any material posted on it, or on any website linked to it.
														<br/><br/>
														8.	Linking to the website:
														Where the website contains links to other sites and resources provided by third parties, these links are provided for your information only. Xamdesk have no control over the contents of those sites or resources, and accept no responsibility for them or for any loss or damange that may arise from your use of them.
														<br/><br/>
														9.	Privacy Policy:
														Xamdesk process information about you in accordance with our privacy policy. By using the website , you consent to such porcessing and you warrant that all data provided by you is accurate.
														<br/><br/>
														10.	Data Protectin Notice:
														If you are registered with Xamdesk, Xamdesk will hold you contact details on Xamdesk database. Your data will never be sold or released to a third party to use for their own purposes. Xamdesk will retain your data and will use it only to communicate with you on Xamdesk related issues and to provide information that may be of use to you for the future. Xamdesk commits that its policy and security statement on Data Protection applies equally to members and non members . Xamdesk will not be liable for all type of losses that resullt form our failure to comply with these terms and conditions.
														<br/><br/>
														11.	Our Liability regarding your use of the website:
														Whilst every effort is taken to ensure the accuracy and integrity of all information displayed , the website is provided without any gurantees, conditions or warranties as to its accuracy. To the extent permitted by law, Xamdesk hereby expressly exclude: Any liability for any direct, indirect or consequential loss or damange incurred by any user in connection with the website or in connection with the use , inability to use, or results of the use of the website ,any website linked to it and any materials posted on it .
														<br/><br/>
														12.	Events outside Xamdesk control:
														Xamdesk will not be liable or responsible for any failure to perform, or delay in performance of , any of our obligations under  a contract that is caused by events outside Xamdesk reasonable control (“ Force Majeure Event”). 
														<br/><br/>
														13.	Waiver:
														If Xamdesk fail, at any time during the term of a contract, to insist upon strict performance of any of your obligations under the contract or any of these terms and conditions , or if Xamdesk fail to exercise any of the rights or remidies to which we are entitled under the contract, this will not constitute a waiver of such rights or remedies and will not relieve yhou from compliance with such obligations. A waiver by us of any default will not constitute a waiver of any subsequent deafault. No waiver by Xamdesk of any of these terms and conditions will be effective unless it is expressly stated to be a waiver and communicated to you in writing to our registered office.
														<br/><br/>
														14.	Severance :
														If any part of thse terms and conditions is found to be unenforceable as a matter of  law, the inforceability of any  other part of these terms and conditions will not be affected.
														
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