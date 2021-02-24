<!-- 
Author: Sumit Singh
Start Date: 19th March, 2014
Modify Date:
Modify By:
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
<link rel="stylesheet" type="text/css" media="all" href="style/displayTag.css" /> 
<script type="text/javascript" src="js2/jquery.paginate.js"></script>
<link rel="stylesheet" type="text/css" href="style/pagination.css" />

<script type="text/javascript">
		$(document).ready(function() {

			// Paginate table rows
			$('table tbody').paginate({
				status: $('#status'),
				controls: $('#paginate'),
				itemsPerPage: 5
			});
		});
</script>
</head>
<body>
<%
   String pageRequest =  (String)request.getSession().getAttribute("pageRequest");
   System.out.println("Page Request::::::::::"+pageRequest);
%>
<s:form theme="simple" name="enquiryDetail" action="searchStudentsDetailsByCretariaOfflineDetails" method="post" onsubmit="">
<div class="dms_admin_cover">
<div class="dms_bar">Search Student Details</div>
<div class="dms_display_message"><s:property value="info"/></div>
<div class="dms_admin_unique_detail">
<table width="80%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><label for="Unique ID">Unique ID</label>:</td>
    <td>   
    <s:textfield theme="simple" name="istr_unique_id" cssClass="text_field" id="istr_unique_id" tabindex="1"/>
    </td>
  </tr>
  <tr>
    <td><label for="firstname">Class</label>:</td>
    <td>
      <s:textfield theme="simple" name="istr_classs" cssClass="text_field" id="istr_classs" tabindex="2"/>
    </td>
  </tr>
  <tr>
    <td><label for="lastname">First Name</label>:</td>
    <td>
      <s:textfield theme="simple" name="istr_first_name" cssClass="text_field" id="istr_first_name" tabindex="3"/>
    </td>
  </tr>
  <tr>
   <td><label for="DateofBirth">Last Name</label>:</td>
    <td>
    <s:textfield theme="simple" name="istr_last_name" cssClass="text_field" id="istr_last_name" tabindex="4"/> 
    </td>
  </tr>
 </table>
 
</div>

<div class="dms_admin_course">
<table width="94%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="25%" valign="middle">
    <label for="gender">Gender</label>:</td>
    <td width="70%">   
    <div class="styled-select2">
    <select name="istr_gender" id="istr_gender">
	<option value="0">Select</option>
	<option value="Male">Male</option>
	<option value="Female">Female</option>
	</select>    
    </div>
    </td>
    </tr>
  
    <tr>
    <td><label for="Email">Email </label>:</td>
    <td>
   
    <s:textfield theme="simple" name="istr_email_id" cssClass="text_field" id="istr_email_id" tabindex="6"/>
   
    </td>
    </tr>
  
  
    <tr>
    <td><label for="Pincode">Father Name</label>:</td>
    <td>
    <s:textfield theme="simple" name="istr_father_name" cssClass="text_field" id="istr_father_name" tabindex="16"/>
    </td>
</tr>
</table>
</div>

<!--  Button Start  -->
<div class="dms_request_button"><table width="98%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    
    <td width="70%"></td><td width="30%" align="right">
    
    <input type="submit" value="Search" name="submit" tabindex="8">
    
    <input type="reset" name="reset" value="Reset" tabindex="9">
    
    </td>
  </tr>
</table>
</div>
<!--  Button End  -->

</div>


<div class="clear"></div>


<div>
	<table width="95%" border="1" bordercolor="#FFFFFF" cellspacing="0" cellpadding="0" id="requestList" class="Table">
		<thead>
			<tr>
				<th class="coll_align">Sl No.</th>
				<th class="coll_align">Unique Id</th>
				<th class="coll_align">Student Name</th>
				<th class="coll_align">Class</th>
				<th class="coll_align">DOB</th>
				<th class="coll_align">Gender</th>
				<th class="coll_align">Phone No</th>
				<th class="coll_align">Email Id</th>
				<th class="coll_align">Select</th>
			</tr>
		</thead>
		<tbody>
		
		<s:if test="studentDetailsDtoList != null">
			<s:if test="%{studentDetailsDtoList.isEmpty()}">
			</s:if>
			<s:else>
			<%
				int i = 1;
			%>
			<s:iterator value="studentDetailsDtoList" id="requestList">
				<tr class="odd">
					<td class="itemcenter5" width="5%"><%=i%></td>
					<td class="itemcenter5"><s:property value="istr_unique_id" /></td>
					<td class="itemcenter5"><s:property value="istr_first_name" /></td>
					<td class="itemcenter5"><s:property value="istr_class" /></td>
					<td class="itemcenter5"><s:property value="istr_date_of_birth" /></td>
					
					<td class="itemcenter5"><s:property value="istr_gender" /></td>
					<td class="itemcenter5"><s:property value="inum_mobile_number" /></td>
					<td class="itemcenter5"><s:property value="istr_email" /></td>
					
					<td class="itemcenter5" width="5%"><a href="showStudentDetailsInformationDetail?sl_no=${requestList.inum_student_id}"><input type="button" value="Select" tabindex="9"></a></td>
				</tr>
			<%
				i++;
			%>
			</s:iterator>
			</s:else>
		</s:if>
	</tbody>
	</table>

	<div id="status"></div>
	<div id="paginate"></div>

</div>
</s:form>
<input type="hidden" id="contextPath" value="<%=request.getContextPath() %>">
</body>
</html> 