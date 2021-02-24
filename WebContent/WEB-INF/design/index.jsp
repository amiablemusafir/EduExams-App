<%@page import="com.oes.dto.NewsAndEventsDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.apache.struts2.interceptor.RequestAware"%>
<%@page import="java.util.List" %>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>OES</title>
<link href="style/dms_home.css" rel="stylesheet">
<link href="style/dms_form.css" rel="stylesheet">
<link rel="stylesheet" href="style/style.css" media="all">
<script language="javascript" type="text/javascript" src="js/md5hash.js"></script>
<script type="text/javascript">
	/* $(function() {
		$('html, body').animate({
		      scrollTop: $("#istr_login_id").offset().top
		}, 400);
	}); */

	function LoginValidation() {

		var username = document.getElementById('istr_login_id').value;
		var password = document.getElementById('istr_password').value;
		
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

<link rel="stylesheet" href="style/jquery-ui.css">
<script src="js/jquery-1-10-2.js"></script>
<script src="js/jquery-ui.js"></script>
</head>
<body>


<div id="templatemo_content_wrapper">
<div class="cleaner"></div> 
<div class="dms_home_left">
<div class="dms_aboutus">
<div class="dms_news"><img src="image/newsicon.png">&nbsp;&nbsp;News Updates</div>
<div class="dms_about_content">
<marquee direction="up" height="130" width="600" scrollamount="2" onmouseover="this.stop();" onmouseout="this.start();">
	
	<% 
	   try{	
		   if(request.getSession().getAttribute("newsAndEventsDtoList") != null) {
				List newsAndEventsDtoList = (List) request.getSession().getAttribute("newsAndEventsDtoList"); 
	  		 	for(int i = 0; i<newsAndEventsDtoList.size() ; i++){
		 			NewsAndEventsDto newsAndEventsDto = (NewsAndEventsDto) newsAndEventsDtoList.get(i);
	   
	%>
			<p style="font-size: 13px; color: #035a83; margin-left: 5px; font-weight: bold;"><%=newsAndEventsDto.getGdt_entry_date()+" "+newsAndEventsDto.getGstr_headline()%></p>
			<a href="" onclick="window.open('newsdetailsaction?slno=<%=newsAndEventsDto.getGnum_slno()%>','_blank','toolbar=yes,location=yes,directories=no,status=no,menubar=yes,scrollbars=yes,resizable=yes,copyhistory=yes, width=800,height=400')" style="text-decoration: none;"><b style="font-size: 12px; color: maroon; margin-left: 5px; font-weight: bold; margin-top: -10px;">Read more</b></a>
			<br/>
			<br/>
	<%}}
	  } catch(Exception e){
			out.print("Due to Some technical problem we are unable to show news & Events");	  	  
	  }%>
	</marquee>
</div>
</div>
</div>


<div class="dms_home_right">
<form id="adminDetailDto" name="formLogin" action="authentication" method="post" onsubmit="return(LoginValidation());">
<div class="dms_login"><font color="red"><s:property value="messages"/></font>
<div class="login_icon"><img src="image/lock.png">Login</div>
<div class="login_user">Username: </div>
<div class="login_user_field">
<input required name="loginId" id="istr_login_id" maxlength="20" type="text" class="login_text"></div>
<div class="login_user">Password: </div>
<div class="login_user_field">
<input required name="password" id="istr_password" type="password" size="35" class="login_text">
</div>
<div class="login_button"> 
<button type="submit" class="buttonall2" >Login</button></div>
<div class="login_forget"></div>
<div class="register_email_id"></div>

<div class="login_forget"><a href="#">Forgot&nbsp;Password?</a></div>
</div>
<input type="hidden" name="contextPath" id="contextPath" value="<%=request.getContextPath()%>"/>
	
	<input type="hidden" name="randomstr" id="randomstr" value="<s:property value='randomString'/>"/>
</form>

</div>
<div class="cleaner"></div> 
</div>
</body>
</html>