<!-- 
Author: Sumit Singh
Start Date: 18th Mar, 2014
Modify Date:
Modify By:
Motive: To change user password
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isThreadSafe="true" %>
<%@page import="com.sms.admin.dto.AdminDetailDto" %>
<% 
	response.setHeader("pragma","no-cache");//HTTP 1.1 
	response.setHeader("Cache-Control","no-cache"); 
	response.setHeader("Cache-Control","no-store"); 
	response.setHeader("Cache-Control","must-revalidate");
	response.addDateHeader("Expires", -1); 
	response.setDateHeader("max-age", 0); 
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="/tags/custom-tag"%>
   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ChangePasswordOrsecretQuestion</title>
 <%-- <script type="text/javascript" src="js/jquery-1.8.2.js"></script> --%>
 
<script type="text/javascript" src="js/md5hash.js"></script>
 
  
<script type="text/javascript">
       function LoginValidation() {

  		$('#old_password_js').html('');
  		$('#new_password_js').html('');
  		$('#confirm_password_js').html('');
  		var old_password = document.getElementById('old_password').value;
  		var new_password = document.getElementById('new_password').value;
  		var confirm_password = document.getElementById('confirm_password').value;
  		
  		var newPasswordLength = new_password.length;
  		
  		/* var pattern = new RegExp(/(?=^.{6,8}$)(?=(?:.*?\d){1})(?=.*[a-z])(?=(?:.*?[!@#$%*()_+^&}{:;?.]){1})(?!.*\s)[0-9a-zA-Z!@#$%*()_+^&]*$/);
  		var result = pattern.test(new_password);  */
  		
  		if (old_password == '') {
  			$('#old_password_js').html('Please enter the valid credential');
  			document.getElementById('old_password').focus();
  			return false;
  		}
  		if (new_password == '') {
  			$('#new_password_js').html('Please enter the valid credential');
  			document.getElementById('new_password').focus();
  			return false;
  		} 
  		if (confirm_password == '') {
  			$('#confirm_password_js').html('Please enter the valid credential');
  			document.getElementById('confirm_password').focus();
  			return false;
  		}
  		if (new_password != confirm_password) {
  			$('#confirm_password_js').html('New Password and confirm password not matched');
  			document.getElementById('new_password').focus();
  			return false;
  			
  		} 
  		if (newPasswordLength > 20) {
  			$('#new_password_js').html('Password cannot be more than 20 characters');
  			document.getElementById('new_password').focus();
  			return false;
  			
  		}
  		if (newPasswordLength < 4) {
  			$('#new_password_js').html('Password must be at least 4 characters');
  			document.getElementById('new_password').focus();
  			return false;
  			
  		}
  		/* if (result == false) {
  			$('#new_password_js').html('Password should be combination of Letter, Number and a Special Character');
  			document.getElementById('new_password').focus();
  			return false;
  			
  		} */
  		else {
  			
  			var finalOldPassword = calcMD5(old_password);
  			var finalNewPassword = calcMD5(new_password);
  			var finalConfirmPassword = calcMD5(confirm_password);
  			
  			document.getElementById('old_password').value = finalOldPassword;
  			document.getElementById('new_password').value = finalNewPassword;
  			document.getElementById('confirm_password').value = finalConfirmPassword;
  		}

  		return true;

  	}
      
      </script>  

</head>
<body>

<%

     AdminDetailDto adminDetailDto = (AdminDetailDto)request.getSession().getAttribute("adminDetailDto");


%>
<div class="grid_10">
	<div class="box round first grid">

    <h2>Change Password</h2>
	<div class="dms_display_message">${info}</div>

	<s:form theme="simple" autocomplete="off" action="saveOrUpdateStudentChangePasswordDtl" name="" method="post"  onsubmit="return(LoginValidation());" class="form">


<table width="96%">
	<tr>
	<td width="50%" align="right"><label for="User Name"><b>User Name :&nbsp;&nbsp;&nbsp;</b></label></td>
	<td width="50%" >
	<input type="text" name="user_id" class="text_field" value="<%= adminDetailDto.getIstr_login_id() %>" id="user_id" readonly="readonly">
	</td>
</tr>
<tr>	
	<td></td>
	<td></td>
	
</tr>
<tr>	
	<td width="50%"  align="right"><label for="Old Password"><b>Old Password :&nbsp;&nbsp;&nbsp;</b></label>
	</td>
	<td width="50%" >
	<s:password theme="simple" cssClass="text_field" name="old_password" id="old_password"/>
	</td>
</tr>
<tr>	
	<td></td>
	<td><div class="message1" id="old_password_js"><s:property value="o_password"/></div></td>
</tr>
<tr>	
	<td width="50%"  align="right"><label for="new password"><b>New Password :&nbsp;&nbsp;&nbsp;</b></label>
	</td>
	<td width="50%" >
	<s:password theme="simple" cssClass="text_field" name="new_password" id="new_password" />
	</td>
</tr>
<tr>	
	<td></td>
	<td><div class="message1" id="new_password_js"><s:property value="n_password"/></div></td>
</tr>
<tr>	
	<td width="50%" align="right"><label for="Confirm Password"><b>Confirm Password :&nbsp;&nbsp;&nbsp;</b></label>
	</td>
	<td width="50%" >
	<s:password theme="simple"  cssClass="text_field" name="confirm_password" id="confirm_password" />
	</td>
</tr>
<tr>	
	<td></td>
	<td><div class="message1" id="confirm_password_js"></div><s:property value="c_password"/></div></td>
</tr>
<tr>
	<td colspan="2"><p>&nbsp;</p></td>
</tr>
</table>

<div class="clear"></div>
<table width="100%">
<tr>
	<td>
	<center>
		<input type="submit" value="Submit" style="width: 100px; height: 30px;" class="btn"/>&nbsp;&nbsp;&nbsp;
		<input type="reset" value="Reset" style="width: 100px; height: 30px;" class="btn"/>
	</center>
	</td>
</tr>
</table>
<div class="clear"></div>
</s:form>
</div>
</div>

</body>
</html>