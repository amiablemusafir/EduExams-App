<!-- 
Author: Himanshu Bharti
Start Date: 26h Sep, 2013
Modify Date:
Modify By:
Motive: To update user profile
 -->
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



</head>

<body>


<div class="dms_admin_cover">

<div class="dms_bar">Personal Profile Update</div>

<div class="dms_admin_grid">
<s:form autocomplete="off" action="updateUserDetails" name="adminDetailDto" method="post">

<div class="message"><s:property value="messages"/></div>
<div class="message"></div>

<table width="96%">

 <tr>
    <td width="48%" class="dms_admin_align">
    <s:hidden theme="simple" name="adminDetailDto.inum_user_id"></s:hidden>
    
    <label for="Role Name">Login ID</label>:</td>
    <td width="48%">
    
 <%--    <s:textfield theme="simple" cssClass="text_field" name="roleMasterDto.istr_role_name" id="istr_role_name" />
 --%>    
    <s:textfield theme="simple" cssClass="text_field" name="adminDetailDto.istr_login_id" id="istr_login_id" tabindex="1" readonly="true"/>
    
    </td>
 </tr>

 <tr>
    <td width="48%"  class="dms_admin_align">
    
    <label for="Role Name">Name</label>:</td>
    <td width="48%">
    
    <s:textfield theme="simple" cssClass="text_field" name="adminDetailDto.istr_user_name" id="istr_user_name" tabindex="2"/>
    
    </td>
  </tr>
  
  <tr>
    <td width="48%"  class="dms_admin_align">
    
    <label for="Role Name">Email</label>:</td>
    <td width="48%">
    
    <s:textfield theme="simple" cssClass="text_field" name="adminDetailDto.istr_email" id="istr_email" tabindex="3"/>
    
    </td>
  </tr>
  
  <tr>
    <td width="48%"  class="dms_admin_align">
    
    <label for="Role Name">Designation</label>:</td>
    <td width="48%">
    
    <s:textfield theme="simple" cssClass="text_field" name="adminDetailDto.istr_designation" id="istr_designation" tabindex="4"/>
    
    </td>
  </tr>

<tr>
    <td width="48%"  class="dms_admin_align">
    
    <label for="Role Name">Mobile</label>:</td>
    <td width="48%">
    
    <s:textfield theme="simple" cssClass="text_field" name="adminDetailDto.istr_mobile_no" id="istr_mobile_no" tabindex="5"/>
    
    </td>
  </tr>
  
  <tr>
    <td width="48%"  class="dms_admin_align">
    
    <label for="Role Name">Address</label>:</td>
    <td width="48%">
    
    <s:textfield theme="simple" cssClass="text_field" name="adminDetailDto.istr_address" id="istr_address" tabindex="6"/>
    
    </td>
  </tr>


 <tr>
	<td colspan="2"><p>&nbsp;</p></td>
</tr>

<tr>
	<td colspan="2"><div align="center"><input class="p_button p_button-submit" type="submit" value="Submit"/>
	<input class="p_button p_button-submit" type="reset" value="Reset"/>
	
	<input type="hidden" name="contextPath" id="contextPath" value="<%=request.getContextPath()%>"/>
	</div></td>
</tr>
</table>


<s:hidden theme="simple" name="adminDetailDto.istr_password"></s:hidden>
<s:hidden theme="simple" name="adminDetailDto.istr_secrete_question"></s:hidden>
<s:hidden theme="simple" name="adminDetailDto.istr_answer"></s:hidden>
<s:hidden theme="simple" name="adminDetailDto.inum_role_id"></s:hidden>
<s:hidden theme="simple" name="adminDetailDto.inum_is_active"></s:hidden>
<s:hidden theme="simple" name="adminDetailDto.idt_entry_date"></s:hidden>
<s:hidden theme="simple" name="adminDetailDto.inum_account_status"></s:hidden>
<s:hidden theme="simple" name="adminDetailDto.istr_user_type"></s:hidden>
<s:hidden theme="simple" name="adminDetailDto.administrationUserDetailsDto.inum_student_id"></s:hidden>
<s:hidden theme="simple" name="adminDetailDto.inum_is_rejected"></s:hidden>
<s:hidden theme="simple" name="adminDetailDto.inum_is_verified"></s:hidden>

</s:form>
</div>
</div> 

</body>
</html> 