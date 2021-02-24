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
			
		 contextPath = contextPath + "/deleteCourseDetail?slno="+categoryId;
	
		 window.location.href = contextPath;
	}
	
}


		function newUserRegistrationValidation() {
		
		var course_name = document.getElementById('ostr_course_name').value;
		if (course_name == '') {
			alert('Please Enter Course Name');
			document.getElementById('ostr_course_name').focus();

			return false;
		}
				
		return true;

	}
</script>
</head>
<body>
	
<div class="grid_10">
	<div class="box round first grid">

    <h2>Course Master</h2>
	<div align="center">
	<s:form autocomplete="off" action="saveCourseDetailsDto" name="courseMasterDto" method="post" onsubmit="return(newUserRegistrationValidation())">
	<s:hidden name="randomStingJsp" id="randomStingJsp"/>
	<br/>
	<div class="message1" id="info"><s:property value="info"/></div>


<table width="40%">

 <tr>
    <td width="48%" class="sms_admin_align" >
    <s:hidden name="courseDetailsDto.onum_slno" />
    <s:hidden name="courseDetailsDto.onum_is_active" />
    <s:hidden name="courseDetailsDto.odt_entry_date" />    
    
    <label for="Source Name"><b>Course Name</b></label>:</td>
    <td width="48%" >
    	<s:textfield theme="simple" cssClass="text_field" name="courseDetailsDto.ostr_course_name" id="ostr_course_name" tabindex="2" />
    </td>
 	</tr>
	<tr>	
		<td></td>
		<td><div class="message1"><s:property value="course_name"/></div></td>
 	</tr>
 	<tr>
 		<td><label for="Source Name"><b>Course Description</b></label>:</td>
    	<td width="48%" >
    		<s:textfield theme="simple" cssClass="text_field" name="courseDetailsDto.ostr_course_details" id="ostr_course_details" tabindex="2" />
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
				<th width="10%">Sl No.</th>
				<th width="70%">Course Name</th>
				<th width="70%">Course Description</th>
				<th width="10%">Edit</th>
				<th width="10%">Delete</th>
			</tr>
		</thead>
		<tbody>
		
		<s:if test="courseDetailsDtoList != null">

			<s:if test="%{courseDetailsDtoList.isEmpty()}">

			</s:if>
			<s:else>
			<%
				int i = 1;
			%>
			<s:iterator value="courseDetailsDtoList" id="requestList">
				<tr class="odd">
					<td width="10%"><%=i%></td>
					
					<td ><s:property value="ostr_course_name" /></td>

					<td ><s:property value="ostr_course_details" /></td>

					<td width="10%"><a href="editCourseDetail?slno=${requestList.onum_slno}"><img src='image/Edit-Male-User-icon.png'></a></td>

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
