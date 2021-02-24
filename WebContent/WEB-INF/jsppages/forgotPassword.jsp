<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.8.2.js"></script>

<script type="text/javascript" src="js/jquery.fancybox-1.3.4.js"></script>
<script type="text/javascript" src="js/jquery.fancybox-1.3.4.pack.js"></script>
<script type="text/javascript" src="js/userRegistration.js"></script>
<script language="javascript" type="text/javascript" src="js/md5hash.js"></script>


<script type="text/javascript">
$(document).ready(function(){

	$("#password_div").hide();
	
	$("#istr_secrete_qus").click(function(){
		$("#info").html("");
		$("#info").hide();  
	});
	
	
});


</script>

</head>
<body>
<div align="center"><font size="5px" color="204f6d" style="font-style: normal;"> Forget Password </font></div>
 <font color="red"> <s:property value="messages"/></font>
 <div id="info" style="font-size: 15px; color: red "></div>

  <div id="login_detail_div">
	<table class="filterTable" style="padding-top:20px" align="center">
		<tr>
			<td>Username:
			</td>
			<td>
			<s:textfield theme="simple" name="istr_login_id" id="istr_login_id" tabindex="1"/>
			&nbsp;
 	        <input type="button" value="Check Existence" name="check_existence" id="existence_button" tabindex="2">
			</td>
		</tr>
		<tr>
			<td>Secret Question:</td>
			<td>
				<s:select theme="simple" list="#{'0':'Select Question','What town were you born in?':'What town were you born in?',
	'What is your nick name?':'What is your nick name?','What is the name of your primary school?':'What is the name of your primary school?',
	'What is the name of your best childhood friend?':'What is the name of your best childhood friend?'}" 
	name="istr_secrete_question" id="istr_secrete_qus" tabindex="3"></s:select>
	
			</td>
		</tr>
		<tr>
			<td>Secret Answer:
			</td>
			<td>
			
			<s:textfield theme="simple" name="adminDetailDto.istr_answer" id="istr_answer" tabindex="4"/>
			
			</td>
	</tr>
	 <tr>
	    <td></td>
		<td><input type="submit" name="frgtPass" value="validate" onclick="confirmforgetPasswordDetails();">
		<span><input type="button" value="Close" onclick="closeFancyBox();"></span>
		</td>
	</tr>
	
</table>
</div>

<div id="password_div">

<table class="filterTable" style="padding-top:20px" align="center">
		<tr>
			<td>New Password:
			</td>
			<td>
			<s:password theme="simple" name="new_password" id="new_password" tabindex="7"></s:password>	
			</td>
		</tr>
		
		<tr>
			<td>Re-enter Password:
			</td>
			<td>
			<s:password theme="simple" name="re_password" id="re_password" tabindex="8"></s:password>	
			</td>
		</tr>
		
		<tr>
	    <td><input type="button" name="backbutton" value="Back" onclick="showBackPage();"></td>
		<td><input type="submit" name="submitbutton" value="Submit" onclick="changeAndValidatePassword();">
		<span><input type="button" value="Close" onclick="closeFancyBox();"></span>
		</td>
	</tr>
               		
</table>        
</div>
	
<input type="hidden" name="contextPath" id="contextPath" value="<%=request.getContextPath()%>"/>
		
</body>
</html>