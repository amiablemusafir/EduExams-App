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
			
		 contextPath = contextPath + "/deleteSectionDetail?slno="+categoryId;
	
		 window.location.href = contextPath;
	}
	
}

function showSubCategoryDetails() {
	var onum_category_slno = $("#onum_category_slno").val();
	if(onum_category_slno != "0") {
		var contextPath=$("#contextPath").val();	
		var url=contextPath+"/getExamSectionDetails";
	 	var datam={onum_category_slno : onum_category_slno, flag : "SUB_CATEGORY_DETAILS_BY_CATEGORY"};
	  		$.ajax({
	   			type: "POST",
	   			url: url,
	   			data: datam,
	   
	   			success: function(response){
	   			 	 $("#sub_category_details").html(response);
	   			}             
	  		});	
	}
}

function getParagraphDetails() {
	
	var data = $("#inum_is_paragraph").val();
	if(data == '1') {
	
		var contextPath=$("#contextPath").val();	
		var url=contextPath+"/getParagraphDetailsList";
	 	var datam={is_paragraph : data, flag : "GET_PARAGRAPH_DETAILS"};
	  		$.ajax({
	   			type: "POST",
	   			url: url,
	   			data: datam,
	   
	   			success: function(response){
	   			 	 $("#paragraph_id").html(response);
	   			}             
	  	});			
	} else {
		$("#paragraph_id").html("");
	}
}


function newUserRegistrationValidation() {
		
	var onum_category_slno = document.getElementById('onum_category_slno').value;
	if (onum_category_slno == '0') {
		alert('Please Select Category');
		document.getElementById('onum_category_slno').focus();
		return false;
	}
	
	var onum_sub_category_slno = document.getElementById('onum_sub_category_slno').value;
	if (onum_sub_category_slno == '0') {
		alert('Please Select Sub Category');
		document.getElementById('onum_sub_category_slno').focus();
		return false;
	}
	
	var section_name = document.getElementById('ostr_section_name').value;
	if (section_name == '') {
		alert('Please Enter Section Name');
		document.getElementById('ostr_section_name').focus();

		return false;
	}
	
	var onum_total_question = document.getElementById('onum_total_question').value;
	if (onum_total_question == '') {
		alert('Please Enter Total Question');
		document.getElementById('onum_total_question').focus();
		return false;
	}
	
	if (!isInteger(onum_total_question)) {
		alert('Please Enter Valid Total Question');
		document.getElementById('onum_total_question').focus();
		return false;
	}
	
	var inum_is_paragraph = document.getElementById('inum_is_paragraph').value;
	if (inum_is_paragraph == '1') {
		
		var onum_paragraph_id = document.getElementById('onum_paragraph_id').value;
		if (onum_paragraph_id == '0') {
			alert('Please Select Paragraph');
			document.getElementById('onum_paragraph_id').focus();
			return false;
		}
	}
			
	return true;
}

function isInteger(s) {
	var i;
	for (i = 0; i < s.length; i++) {
	var c = s.charAt(i);
	if (((c < "0") || (c > "9")))
		return false;
	}
	return true;
}
</script>
</head>
<body>

<div class="grid_10">
	<div class="box round first grid">

    <h2>Section Master</h2>
	
	<div align="center">
	<s:form autocomplete="off" action="saveSectionDetailsDto" name="sectionMasterDto" method="post" onsubmit="return(newUserRegistrationValidation())">
	<s:hidden name="randomStingJsp" id="randomStingJsp"/>
	
	<div class="message1" id="info"><s:property value="info"/></div>
	<table width="50%">
	<tr>
  		<td><label for="Unique ID"><b>Category Name</b></label>:</td>
    	<td>   
    	<div class="styled-select2">
    	<s:if test="categoryDetailsDtoList == null">
				<select id="onum_category_slno" name="sectionDetailsDto.categoryDetailsDto.onum_slno" tabindex="1">
					<option value="0">Select</option>
				</select>
		</s:if>
		<s:else>
    			<s:select theme="simple" list="categoryDetailsDtoList"
						id="onum_category_slno" listKey="onum_slno"
						listValue="ostr_category_name"
						name="sectionDetailsDto.categoryDetailsDto.onum_slno"
						headerKey="0" headerValue="Select"
						onChange="showSubCategoryDetails();" tabindex="1"></s:select>
	 	</s:else> 
	 	</div>
     	</td>
  	</tr>
  	<tr>
  		<td><label for="Unique ID"><b>Sub Category Name</b></label>:</td>
    	<td>   
    	<div id="sub_category_details">
	    	<div class="styled-select2">
	    	<s:if test="subcategoryDetailsDtoList == null">
					<select id="onum_sub_category_slno" name="sectionDetailsDto.subCategoryDetailsDto.onum_slno" tabindex="1">
						<option value="0">Select</option>
					</select>
			</s:if>
			<s:else>
	    			<s:select theme="simple" list="subcategoryDetailsDtoList"
							id="onum_sub_category_slno" listKey="onum_slno"
							listValue="ostr_sub_category_name"
							name="sectionDetailsDto.subCategoryDetailsDto.onum_slno"
							headerKey="0" headerValue="Select"
							onChange="" tabindex="2"></s:select>
		 	</s:else> 
		 	</div>
	 	</div>
     	</td>
  	</tr>

 	<tr>
    <td width="48%" class="sms_admin_align" >
    <s:hidden name="sectionDetailsDto.onum_slno" />
    <s:hidden name="sectionDetailsDto.onum_is_active" />
       <s:hidden name="sectionDetailsDto.onum_remaining_question" />
    <s:hidden name="sectionDetailsDto.odt_entry_date" />    
    
    <label for="Source Name"><b>Section Name</b></label>:</td>
    <td width="48%" >
    	<s:textfield theme="simple" cssClass="text_field" name="sectionDetailsDto.ostr_section_name" id="ostr_section_name" tabindex="3" />
    </td>
 	</tr>
	<tr>	
		<td></td>
		<td><div class="message1"><s:property value="section_name"/></div></td>
 	</tr>
 	<tr>
 	<td><label for="Source Name"><b>Total Question</b></label>:</td>
    <td width="48%" >
    	<s:textfield theme="simple" cssClass="text_field" name="sectionDetailsDto.onum_total_question" id="onum_total_question" tabindex="4" />
    </td>
 	</tr>
	<tr>	
		<td></td>
		<td><div class="message1"><s:property value="section_name"/></div></td>
 	</tr>
 	<tr>
 		<td><label for="Source Name"><b>Section Description</b></label>:</td>
    	<td width="48%" >
    		<s:textfield theme="simple" cssClass="text_field" name="sectionDetailsDto.ostr_section_details" id="ostr_section_details" tabindex="5" />
    	</td>
	</tr>
	 <tr>
     	<td width="48%"><b><label for="Role Name">Is Paragraph</label>:</b></td>
    	<td width="48%"><div class="styled-select2"><s:select theme="simple" list="#{'0':'Select','0':'No','1':'Yes'}" name="sectionDetailsDto.inum_is_paragraph" id="inum_is_paragraph" 
		 cssClass="parent_class" onchange="getParagraphDetails();"></s:select></div></td>
  </tr>

  <tr id="paragraph_id">
  		<s:if test="sectionDetailsDto.inum_is_paragraph == 1">
			<td>
		   		<b><label for="gender">Paragraph</label>:</b></td>
		    <td>   
		    <div class="styled-select2">
		   		 <s:select theme="simple" list="paragraphDetailsDtoList"
				  id="onum_paragraph_id" listKey="onum_slno"
				  listValue="ostr_paragraph_name"
				  name="sectionDetailsDto.paragraphDetailsDto.onum_slno"
				  headerKey="0" headerValue="Select"
				  onChange="" tabindex="1"></s:select> </div>
		    </td>

		</s:if>
		<s:else>
			<td colspan="2"><s:hidden name='sectionDetailsDto.paragraphDetailsDto.onum_slno' id='inum_paragraph_id'/></td>
		</s:else>
  </tr>

  <tr>
	<td colspan="2"><p>&nbsp;</p></td>
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
				<th>Category Name</th>
				<th>Sub Category Name</th>
				<th>Section Name</th>
				<th>Total Question</th>
				<th>Section Description</th>
				<th width="5%">Edit</th>
				<th width="5%">Delete</th>
			</tr>
		</thead>
		<tbody>
		
		<s:if test="sectionDetailsDtoList != null">

			<s:if test="%{sectionDetailsDtoList.isEmpty()}">

			</s:if>
			<s:else>
			<%
				int i = 1;
			%>
			<s:iterator value="sectionDetailsDtoList" id="requestList">
				<tr class="odd">
					<td width="5%"><%=i%></td>
					
					<td><s:property value="categoryDetailsDto.ostr_category_name" /></td>
					<td><s:property value="subCategoryDetailsDto.ostr_sub_category_name" /></td>
					
					<td><s:property value="ostr_section_name" /></td>
					
					<td><s:property value="onum_total_question" /></td>

					<td><s:property value="ostr_section_details" /></td>

					<td width="5%"><a href="editSectionDetail?slno=${requestList.onum_slno}"><img src='image/Edit-Male-User-icon.png'></a></td>

					<td width="5%"><a href="#" onclick="deleteCategory('${requestList.onum_slno}');"><img src='image/user_remove.png'></a></td>
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
