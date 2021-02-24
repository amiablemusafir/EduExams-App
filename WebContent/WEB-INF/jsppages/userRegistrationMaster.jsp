<%@page isThreadSafe="true" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
<html>
<head>
<title></title>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<link rel="stylesheet" type="text/css" media="all" href="css/displayTag.css" /> 
<%-- <script type="text/javascript" src="js/jquery-1.8.2.js"></script> --%>
<script type="text/javascript" src="js/md5hash.js"></script>
<script type="text/javascript" src="js/userRegistration.js"></script>


<script type="text/javascript">

function encryptPassword()
{
	var password = document.getElementById('istr_password').value;
	var security_pass = document.getElementById('istr_secrete_qus').value;
	var pstr_answer = document.getElementById('istr_answer').value;
	
	if(password =="" || security_pass == "" || pstr_answer==""){
		
		return false;
	}
	else{
	
		 var hashPass = calcMD5(password);
		  var hashQuestion = calcMD5(security_pass); 
		  var hashAnswer = calcMD5(pstr_answer);
		  	  
		  document.getElementById("istr_password").value = hashPass;
		  document.getElementById("secrete_question").value = hashQuestion; 
		  document.getElementById("istr_answer").value = hashAnswer;
		
	}
	 
 }

</script>
</head>

<body>
<div class="dms_admin_cover">
<div class="dms_bar">User Registration</div>
<div class="dms_admin_grid">

<s:form autocomplete="off" action="saveUserRegistration" name="adminDetailDto" method="post" onsubmit="encryptPassword();">
<div class="dms_display_message"><s:property value="messages"/></div>
<div class="dms_display_message" id="info"></div>

<table width="96%">

 <tr>
    <td width="48%" class="dms_admin_align" >User Type :
    <s:hidden name="adminDetailDto.inum_user_id" /></td>
	<td width="48%">
    <div class="styled-select2">
    <s:if test="roleMasterList == null">
						<select id="istr_role_name" name="adminDetailDto.inum_role_id" tabindex="1">
						<option value="0">Select</option>
						</select>
						</s:if>
						<s:else>
	<s:select theme="simple" cssClass="select" list="roleMasterList"
						id="istr_role_name" listKey="inum_role_id"
						listValue="istr_role_name"
						name="adminDetailDto.inum_role_id"
						headerKey="0" headerValue="Select Role"
						onChange="" tabindex="1"></s:select></s:else></div>
	
	</td>
</tr>

<tr>
    <td width="48%" class="dms_admin_align" >Department :</td>
	<td>
	<div class="styled-select2">       
						<s:if test="departmentMasterDtoList == null">
						<select id="istr_department" name="adminDetailDto.istr_department" tabindex="1">
						<option value="0">Select</option>
						</select>
						</s:if>
						<s:else>
						<s:select theme="simple" cssClass="select" list="departmentMasterDtoList"
								id="istr_department" listKey="istr_department_name"
								listValue="istr_department_name"
								name="adminDetailDto.istr_department"
								headerKey="0" headerValue="Select"
								onChange="" tabindex="1"></s:select>
	</s:else></div>
	<%-- <s:textfield theme="simple" name="adminDetailDto.istr_department" id="istr_department" tabindex="2"/> --%>
	
	<!-- <button type="button" name="check_existence" id="existence_button" tabindex="3">Available</button> -->
	</td>
</tr>

<tr>
    <td width="48%" class="dms_admin_align" >Login ID :</td>
	<td>
	<s:textfield theme="simple" name="adminDetailDto.istr_login_id" id="istr_login_id" tabindex="2"/>
	
	<!-- <button type="button" name="check_existence" id="existence_button" tabindex="3">Available</button> -->
	</td>
</tr>

<tr>
    <td width="48%" class="dms_admin_align" >Login Password :</td>
	<td>
	<s:password theme="simple" name="adminDetailDto.istr_password" id="istr_password" tabindex="4"></s:password>
	</td>
</tr>


<tr>
    <td width="48%" class="dms_admin_align" >Re-Enter Password :</td>
	<td>
	<s:password theme="simple" name="istr_repassword" id="istr_repassword" tabindex="5"></s:password>
	</td>
</tr>

<tr>
    <td width="48%" class="dms_admin_align" >Secret Question :</td>
	<td width="48%">
     <div class="styled-select2">
	<s:select theme="simple" list="#{'0':'Select Question','What town were you born in?':'What town were you born in?',
	'What is your nick name?':'What is your nick name?','What is the name of your primary school?':'What is the name of your primary school?',
	'What is the name of your best childhood friend?':'What is the name of your best childhood friend?'}" 
	name="istr_secrete_question" id="istr_secrete_qus" tabindex="6"></s:select>
	
	<input type="hidden" name="adminDetailDto.istr_secrete_question" id="secrete_question"></div>
	</td>
</tr>

<tr>
    <td width="48%" class="dms_admin_align" >Answer :</td>
	<td>
	<s:textfield theme="simple" name="adminDetailDto.istr_answer" id="istr_answer" tabindex="7"/>
	</td>
</tr>

<tr>
    <td width="48%" class="dms_admin_align" >Name :</td>
	<td>
	<s:textfield theme="simple" name="adminDetailDto.istr_user_name" id="istr_user_name" tabindex="8"/>
	</td>
</tr>

<tr>
    <td width="48%" class="dms_admin_align" >Email :</td>
	<td>
	<s:textfield theme="simple" name="adminDetailDto.istr_email" id="istr_email" tabindex="9"/>
	</td>
</tr>

<tr>
    <td width="48%" class="dms_admin_align" >Designation :</td>
	<td>
	<s:textfield theme="simple" name="adminDetailDto.istr_designation" id="istr_designation" tabindex="10"/>
	</td>
</tr>

<tr>
    <td width="48%" class="dms_admin_align" >Address :</td>
	<td>
	<s:textfield theme="simple" name="adminDetailDto.istr_address" id="istr_address" tabindex="11"/>
	</td>
</tr>

<tr>
    <td width="48%" class="dms_admin_align" >Mobile :</td>
	<td>
	<s:textfield theme="simple" name="adminDetailDto.istr_mobile_no" id="istr_mobile_no" tabindex="12"/>
	</td>
</tr>

<tr>
	<td colspan="2"><p>&nbsp;</p></td>
</tr>
<tr>
	<td colspan="2"><div align="center"><input class="p_button p_button-submit" type="submit" id="submit_button_id" value="Submit" tabindex="13"/>

	<input class="p_button p_button-submit" type="reset" value="Reset" tabindex="14"/></div>
	
	<input type="hidden" name="contextPath" id="contextPath" value="<%=request.getContextPath()%>"/>
	
	</td>
    

</tr>
</table>




</s:form>
 </div>
 </div>
 

</body>
</html> 