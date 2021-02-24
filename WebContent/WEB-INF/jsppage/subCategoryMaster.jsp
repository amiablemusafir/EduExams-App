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
			
		 contextPath = contextPath + "/deleteSubCategoryDetail?slno="+categoryId;
	
		 window.location.href = contextPath;
	}
	
}


function newUserRegistrationValidation() {
		
		var onum_slno = $("#onum_slno").val();
		if(onum_slno == "0") {
			alert('Please Select Category Name');
			document.getElementById('onum_slno').focus();

			return false;
		}
		
		var category_name = document.getElementById('ostr_sub_category_name').value;
		if (category_name == '') {
			alert('Please Enter Sub Category Name');
			document.getElementById('ostr_sub_category_name').focus();

			return false;
		}
				
		return true;

}
</script>
</head>
<body>

<div class="grid_10">
	<div class="box round first grid">

    <h2>Sub Category Master</h2>
	
	<div align="center">
	<s:form autocomplete="off" action="saveSubCategoryDetailsDto" name="subCategoryMasterDto" method="post" onsubmit="return(newUserRegistrationValidation())">
	<s:hidden name="randomStingJsp" id="randomStingJsp"/>
	
	<div class="message1" id="info"><s:property value="info"/></div>
	<table width="50%">
	<tr>
  		<td><label for="Unique ID"><b>Category Name</b></label>:</td>
    	<td>   
    	<div class="styled-select2">
    	<s:if test="categoryDetailsDtoList == null">
				<select id="onum_slno" name="subCategoryDetailsDto.categoryDetailsDto.onum_slno" tabindex="1">
					<option value="0">Select</option>
				</select>
		</s:if>
		<s:else>
    			<s:select theme="simple" list="categoryDetailsDtoList"
						id="onum_slno" listKey="onum_slno"
						listValue="ostr_category_name"
						name="subCategoryDetailsDto.categoryDetailsDto.onum_slno"
						headerKey="0" headerValue="Select"
						onChange="" tabindex="1"></s:select>
	 	</s:else> 
	 	</div>
     	</td>
  	</tr>
  	<tr>	
		<td></td>
		<td><div class="message1" id="category_error"><s:property value="category_error"/></div></td>
 	</tr>

 	<tr>
    <td width="48%" class="sms_admin_align" >
    <s:hidden name="subCategoryDetailsDto.onum_slno" />
    <s:hidden name="subCategoryDetailsDto.onum_is_active" />
    <s:hidden name="subCategoryDetailsDto.odt_entry_date" />    
    
    <label for="Source Name"><b>Sub Category Name</b></label>:</td>
    <td width="48%" >
    	<s:textfield theme="simple" cssClass="text_field" name="subCategoryDetailsDto.ostr_sub_category_name" id="ostr_sub_category_name" tabindex="2" />
    </td>
 	</tr>
	<tr>	
		<td></td>
		<td><div class="message1"><s:property value="sub_category_name"/></div></td>
 	</tr>
  	<tr>
 		<td><label for="Source Name"><b>Sub Category Description</b></label>:</td>
    	<td width="48%" >
    		<s:textfield theme="simple" cssClass="text_field" name="subCategoryDetailsDto.ostr_sub_category_details" id="ostr_sub_category_details" tabindex="2" />
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
				<th>Category Name</th>
				<th>Sub Category Name</th>
				<th>Category Description</th>
				<th width="10%">Edit</th>
				<th width="10%">Delete</th>
			</tr>
		</thead>
		<tbody>
		
		<s:if test="subCategoryDetailsDtoList != null">

			<s:if test="%{subCategoryDetailsDtoList.isEmpty()}">

			</s:if>
			<s:else>
			<%
				int i = 1;
			%>
			<s:iterator value="subCategoryDetailsDtoList" id="requestList">
				<tr class="odd">
					<td width="10%"><%=i%></td>
					
					<td><s:property value="categoryDetailsDto.ostr_category_name" /></td>
					
					<td><s:property value="ostr_sub_category_name" /></td>
					
					<td><s:property value="ostr_sub_category_details" /></td>

					<td width="10%"><a href="editSubCategoryDetail?slno=${requestList.onum_slno}"><img src='image/Edit-Male-User-icon.png'></a></td>

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
