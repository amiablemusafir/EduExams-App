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
 
<script type="text/javascript">
function deleteCategory(categoryId){
	
	var showBill=confirm("Are you sure you want to delete");
	
	if(showBill == true){
			
		 var contextPath = $('#contextPath').val();
			
		 contextPath = contextPath+"/deleteemployeeDetail?emp_id="+categoryId;
	
		 window.location.href = contextPath;
	}
	
}

var radioArray = new Array();
$(document).ready(function(){
	
	$( "#idt_dob" ).datepicker({
	changeMonth: true,
	changeYear: true,
	dateFormat: 'dd-MM-yy'
	});
	
});

function clickOnRadioButton(studentId){
	
	//alert("Student ID : "+studentId);
    radioArray = new Array();	
	radioArray.push(studentId);
		
}

function showUserDetails(){
	
	if (radioArray == '') {
			$('#message').html('Please enter the valid credential');
		return false;
	}
	
	 document.forms[0].action = "showEmployeeDetailByCriteria?iteratorId="+radioArray;
	 document.forms[0].submit();	
}
</script>
</head>
<body>
<%
   String pageRequest =  (String)request.getSession().getAttribute("pageRequest");
   System.out.println("Page Request::::::::::"+pageRequest);
%>
<s:form theme="simple" name="employeeDetail" action="searchEmployeeDetailsByCretaria" method="post" onsubmit="">
<s:hidden name="randomStingJsp" id="randomStingJsp"/>

<div class="grid_10">
<div class="box round first grid">

<h2>Search Employee Details</h2>

<div class="dms_display_message"><s:property value="info"/></div>

<div align="center">
<table width="80%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><label for="Unique ID">Unique ID</label>:</td>
    <td>   
    <s:textfield theme="simple" name="unique_id" cssClass="text_field" id="uniqueId" tabindex="1"/>
    </td>
    <td>
    	<label for="gender">Gender</label>:</td>
    <td>   
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
    <td><label for="firstname">First Name</label>:</td>
    <td>
      <s:textfield theme="simple" name="first_name" cssClass="text_field" id="firstNameId" tabindex="2"/>
    </td>
       <td><label for="Email">Email </label>:</td>
    <td>
   
    <s:textfield theme="simple" name="email_id" cssClass="text_field" id="istr_email_id" tabindex="6"/>
   
    </td>
  </tr>
  <tr>
    <td><label for="lastname">Last Name</label>:</td>
    <td>
      <s:textfield theme="simple" name="last_name" cssClass="text_field" id="lastNameId" tabindex="3"/>
    </td>
    <td><label for="Pincode">Pin code</label>:</td>
    <td>
    <s:textfield theme="simple" name="istr_pin_code" cssClass="text_field" id="istr_pin_code" tabindex="16"/>
    </td>
  </tr>
  <tr>
   <td><label for="DateofBirth">Date of Birth</label>:</td>
    <td>
    <s:textfield theme="simple" name="dob" cssClass="text_field" id="idt_dob" tabindex="4"/> 
    </td>
    <td></td>
    <td></td>
  </tr>
 </table>
 </div>
 
<!--  Button Start  -->
<div class="dms_request_button"><table width="98%" border="0" cellspacing="0" cellpadding="0">
  <tr>    
    <td width="100%">
    <div align="center">   
	    <input type="submit" value="Search" name="submit" tabindex="8" style="width:120px;" class="btn">
	    &nbsp;&nbsp;
	    <input type="reset" name="reset" value="Reset" tabindex="9" style="width:120px;" class="btn">
    </div> 
    </td>
  </tr>
</table>
</div>
<!--  Button End  -->

</div>
</div>


<div class="grid_10">
<div class="box round first grid">
		 <div class="block">
		 <table class="data display datatable" id="example" border="1" bordercolor="#B3CBD6">
		 <thead>
			<tr>
				<th class="coll_align">Sl No.</th>
				<th class="coll_align">Employee Id</th>
				<th class="coll_align">Employee Name</th>
				<th class="coll_align">DOB</th>
				<th class="coll_align">Gender</th>
				<th class="coll_align">Phone No</th>
				<th class="coll_align">Email Id</th>
				<th class="coll_align">Edit</th>
				<th class="coll_align">Delete</th>
			</tr>
		</thead>
		<tbody>
		
		<s:if test="employeeDetailsDtoList != null">
			<s:if test="%{employeeDetailsDtoList.isEmpty()}">
			</s:if>
			<s:else>
			<%
				int i = 1;
			%>
			<s:iterator value="employeeDetailsDtoList" id="requestList">
				<tr class="odd">
					<td class="itemcenter5" width="5%"><%=i%></td>
					<td class="itemcenter5"><s:property value="istr_unique_id" /></td>
					<td class="itemcenter5"><s:property value="istr_first_name" /></td>
					<td class="itemcenter5"><s:property value="istr_date_of_birth" /></td>
					
					<td class="itemcenter5"><s:property value="istr_gender" /></td>
					<td class="itemcenter5"><s:property value="inum_mobile_number" /></td>
					<td class="itemcenter5"><s:property value="istr_email" /></td>
					
					<td class="itemcenter5" width="5%"><a href="editemployeeDetail?emp_id=${requestList.inum_employee_id}"><img src='image/Edit-Male-User-icon.png'></a></td>
					<td class="itemcenter5" width="5%"><a href="#" onclick="deleteCategory('${requestList.inum_employee_id}');"><img src='image/user_remove.png'></a></td>
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

</s:form>
</body>

<input type="hidden" id="contextPath" value="<%=request.getContextPath() %>" >
</html> 