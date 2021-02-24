<!-- 
Author: Sumit Singh
Start Date: 27th March, 2014
Modify Date:
Modify By:
Motive: Admission Details
 -->
<%@page import="com.thoughtworks.xstream.core.util.Base64Encoder" %>
<%@page isThreadSafe="true"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	response.setHeader("pragma", "no-cache");//HTTP 1.1 
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Cache-Control", "must-revalidate");
	response.addDateHeader("Expires", -1);
	response.setDateHeader("max-age", 0);
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="/tags/custom-tag"%>
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript">
function deleteCategory(categoryId){
	
	var showBill=confirm("Are you sure you want to delete");
	
	if(showBill == true){
			
		 var contextPath = $('#contextPath').val();
			
		 contextPath = contextPath + "/deleteInstituteDetail?slno="+categoryId;
	
		 window.location.href = contextPath;
	}
	
}


		function newUserRegistrationValidation() {
		
		var institute_name = document.getElementById('ostr_institute_name').value;
		if (institute_name == '') {
			alert('Please Enter Institute Name');
			document.getElementById('ostr_institute_name').focus();

			return false;
		}
				
		return true;

	}
</script>
</head>
<body>
	
<div class="grid_10">
	<div class="box round first grid">

    <h2>Institute Master</h2>
	<div align="center">
	<s:form autocomplete="off" action="saveInstituteDetailsDto" name="instituteMasterDto" method="post" onsubmit="return(newUserRegistrationValidation())">
	<s:hidden name="randomStingJsp" id="randomStingJsp"/>
	<br/>
	<div class="message1" id="info"><s:property value="info"/></div>


<table width="40%">

 <tr>
    <td width="48%" class="sms_admin_align" >
    <s:hidden name="instituteDetailsDto.onum_slno" />
    <s:hidden name="instituteDetailsDto.onum_is_active" />
    <s:hidden name="instituteDetailsDto.odt_entry_date" />    
    
    <label for="Source Name"><b>Institute Name</b></label>:</td>
    <td width="48%" >
    	<s:textfield theme="simple" cssClass="text_field" name="instituteDetailsDto.ostr_institute_name" id="ostr_institute_name" tabindex="2" />
    </td>
 	</tr>
	<tr>	
		<td></td>
		<td><div class="message1"><s:property value="institute_name"/></div></td>
 	</tr>
 	<tr>
 		<td><label for="Source Name"><b>Institute Logo</b></label>:</td>
    	<td width="48%" >
    		<s:textfield theme="simple" cssClass="text_field" name="instituteDetailsDto.ostr_institute_logo" id="ostr_institute_logo" tabindex="2" />
    	</td>
	</tr>
	<tr>
 		<td><label for="Source Name"><b>Address1</b></label>:</td>
    	<td width="48%" >
    		<s:textfield theme="simple" cssClass="text_field" name="instituteDetailsDto.ostr_address1" id="ostr_address1" tabindex="2" />
    	</td>
	</tr>
	<tr>
 		<td><label for="Source Name"><b>Address2</b></label>:</td>
    	<td width="48%" >
    		<s:textfield theme="simple" cssClass="text_field" name="instituteDetailsDto.ostr_address2" id="ostr_address2" tabindex="2" />
    	</td>
	</tr>
	<tr>
 		<td><label for="Source Name"><b>URL-Website</b></label>:</td>
    	<td width="48%" >
    		<s:textfield theme="simple" cssClass="text_field" name="instituteDetailsDto.ostr_website_url" id="ostr_website_url" tabindex="2" />
    	</td>
	</tr>
	<tr>
 		<td><label for="Source Name"><b>Phone No</b></label>:</td>
    	<td width="48%" >
    		<s:textfield theme="simple" cssClass="text_field" name="instituteDetailsDto.ostr_phone_no" id="ostr_phone_no" tabindex="2" />
    	</td>
	</tr>

</table>

<!--  Button Start  -->
<table width="98%" border="0" cellspacing="0" cellpadding="0">
  <tr>    
    <td width="100%">
    <div align="center">   
	    <input type="submit" value="Submit" name="submit" tabindex="8" style="width:120px;" class="btn">
	    &nbsp;&nbsp;
	    <input type="reset" name="reset" value="Reset" tabindex="9" style="width:120px;" class="btn">
    </div> 
    </td>
  </tr>
</table>
<!--  Button End  -->

</s:form>
</div>
</div>
</div>


<div class="grid_10">
	<div class="box round first grid">
		 <div class="block">
			<table class="data display datatable" id="example" border="1" bordercolor="#B3CBD6">
			<thead>
			<tr>
				<th width="5%">Sl No.</th>
				<th>Institute Name</th>
				<th>Phone No</th>
				<th>Website URL</th>
				<th width="10%">Edit</th>
				<th width="10%">Delete</th>
			</tr>
		</thead>
		<tbody>
		
		<s:if test="instituteDetailsDtoList != null">

			<s:if test="%{instituteDetailsDtoList.isEmpty()}">

			</s:if>
			<s:else>
			<%
				int i = 1;
			%>
			<s:iterator value="instituteDetailsDtoList" id="requestList">
				<tr class="odd">
					<td width="10%"><%=i%></td>
					
					<td ><s:property value="ostr_institute_name" /></td>

					<td ><s:property value="ostr_phone_no" /></td>
					
					<td ><a href="${requestList.ostr_website_url}" target="_blank"><s:property value="ostr_website_url"/></a></td>

					<td width="10%"><a href="editInstituteDetail?slno=${requestList.onum_slno}"><img src='image/Edit-Male-User-icon.png'></a></td>

					<td width="10%"><a href="#" onclick="deleteCategory('${requestList.onum_slno}');"><img src='image/user_remove.png'></a></td>
				</tr>
			<%
				i++;
			%>
			</s:iterator>
			</s:else>
		</s:if>
	</tbody>
	</table>

</div>
</div>
</div>

<input type="hidden" id="contextPath" value="<%=request.getContextPath() %>" >
</body>
</html>   
