<!-- 
Author: Sumit Singh
Start Date: 19th March, 2014
Modify Date:
Modify By:
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html" charset=UTF-8>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page isThreadSafe="true" %>
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
<script type="text/javascript">
function showSubCategoryDetails() {
	var onum_category_slno = $("#onum_category_slno").val();
	if(onum_category_slno != "0") {
		var contextPath=$("#contextPath").val();	
		var url=contextPath+"/getExamSectionDetails";
	 	var datam={onum_category_slno : onum_category_slno, flag : "QUESTION_SUB_CATEGORY_DETAILS"};
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
	
function showSectionDetailsList() {
	var onum_sub_category_slno = $("#onum_sub_category_slno").val();
	if(onum_sub_category_slno != "0") {
		var contextPath=$("#contextPath").val();	
		var url=contextPath+"/getExamSectionDetails";
	 	var datam={onum_sub_category_slno : onum_sub_category_slno, flag : "SEARCH_SECTION_DETAILS"};
	  		$.ajax({
	   			type: "POST",
	   			url: url,
	   			data: datam,
	   
	   			success: function(response){
	   			 	 $("#section_details").html(response);
	   			}             
	  		});	
	}
}
	

function deleteQuestionDetails(id){
	var deleteQuestion = confirm("Are you sure you want to delete");
	
	if(deleteQuestion == true){
		var contextPath = $('#contextPath').val();
		contextPath = contextPath+"/deleteQuestionDetails?sl_no="+id;
		window.location.href = contextPath;
	}
}

function editQuestionDetails(id){
	
	var contextPath = $('#contextPath').val();
	contextPath = contextPath+"/editQuestionDetails?sl_no="+id;
	window.location.href = contextPath;
}

</script>
</head>
<body>
<s:form theme="simple" name="enquiryDetail" action="searchQuestionByCretaria" method="post" onsubmit="">
<s:hidden name="randomStingJsp" id="randomStingJsp"/>

<div class="grid_10">
	<div class="box round first grid">
	<h2>Search Question Details</h2>
	<div class="dms_display_message"><s:property value="info"/></div>

	<div align="center">
	<br/>
	<table width="80%" border="0" cellpadding="0" cellspacing="0">
	   <tr>    
	  	<td><label for="Unique ID"><b>Category Name</b></label>:</td>
	    <td>   
	    	<div class="styled-select2">
	    	<s:if test="categoryDetailsDtoList == null">
					<select id="onum_category_slno" name="questionDetailsDto.categoryDetailsDto.onum_slno" tabindex="1">
						<option value="0">Select</option>
					</select>
			</s:if>
			<s:else>
	    			<s:select theme="simple" list="categoryDetailsDtoList"
							id="onum_category_slno" listKey="onum_slno"
							listValue="ostr_category_name"
							name="questionDetailsDto.categoryDetailsDto.onum_slno"
							headerKey="0" headerValue="Select"
							onChange="showSubCategoryDetails();" tabindex="1"></s:select>
		 	</s:else> 
		 	</div>
	     </td>
	  	 <td><label for="Unique ID"><b>Sub Category Name</b></label>:</td>
	     <td>   
	    	<div id="sub_category_details">
		    	<div class="styled-select2">
		    	<s:if test="subcategoryDetailsDtoList == null">
						<select id="onum_sub_category_slno" name="questionDetailsDto.subCategoryDetailsDto.onum_slno" tabindex="1">
							<option value="0">Select</option>
						</select>
				</s:if>
				<s:else>
		    			<s:select theme="simple" list="subcategoryDetailsDtoList"
								id="onum_sub_category_slno" listKey="onum_slno"
								listValue="ostr_sub_category_name"
								name="questionDetailsDto.subCategoryDetailsDto.onum_slno"
								headerKey="0" headerValue="Select"
								onChange="showSectionDetailsList();" tabindex="2"></s:select>
			 	</s:else> 
			 	</div>
		 	</div>
	     </td>
	  </tr>
	  <tr>    
	  	<td><label for="Unique ID"><b>Section Name</b></label>:</td>
	    <td>   
	    <div id="section_details">
	    <div class="styled-select2">    
	    <s:if test="sectionDetailsDtoList == null">
					<select id="onum_slno" name="section_id" tabindex="1">
						<option value="0">Select</option>
					</select>
		</s:if>
		<s:else>
	    			<s:select theme="simple" list="sectionDetailsDtoList"
							id="onum_slno" listKey="onum_slno"
							listValue="ostr_section_name"
							name="section_id"
							headerKey="0" headerValue="Select"
							onChange="" tabindex="1"></s:select>
		 </s:else>
		 </div>
		 </div>
	     </td>
	    <td><label for="Unique ID"><b>Question</b></label>:</td>
	    <td>   
	    <s:textfield theme="simple" name="question" cssClass="text_field" id="question" tabindex="1"/>
	    </td>
	  </tr>
	</table>
	</div>
	<br/>
	<!--  Button Start  -->
	<table width="98%" border="0" cellspacing="0" cellpadding="0">
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
	<!--  Button End  -->
</div>
</div>

<div class="grid_10">
	<div class="box round first grid">
		 <div class="block">
		 <table class="data display datatable" id="example" border="1" bordercolor="#B3CBD6">		
			<thead>
			<tr>
				<th width="5%">Sl No.</th>
				<th width="10%">Category</th>
				<th width="10%">Sub Category</th>
				<th width="10%">Section Name</th>
				<th width="55%">Question</th>
				<th width="5%">Edit</th>
				<th width="5%">Delete</th>
			</tr>
		 </thead>
		 <tbody>
		
		 <s:if test="questionDetailsDtoList != null">
			<s:if test="%{questionDetailsDtoList.isEmpty()}">
				
			</s:if>
			<s:else>
			<%
				int i = 1;
			%>
			<s:iterator value="questionDetailsDtoList" id="requestList">
				<tr>
					<td><%=i%></td>
					<td><s:property value="categoryDetailsDto.ostr_category_name" /></td>
					<td><s:property value="subCategoryDetailsDto.ostr_sub_category_name" /></td>
					<td><s:property value="sectionDetailsDto.ostr_section_name" /></td>
					<td>${requestList.ostr_question}</td>
					<td width="5%"><center>
					<input type="button" value="Edit" onclick="editQuestionDetails('${requestList.onum_id}');" class="btn btn-small">
					</center></td>
					<td width="5%"><center>
					<input type="button" value="Delete" onclick="deleteQuestionDetails('${requestList.onum_id}');" class="btn btn-small">
					</center></td>
				</tr>
			<%
				i++;
			%>
			</s:iterator>
			</s:else>
		</s:if>
		<s:else>
				
		</s:else>
	</tbody>
	</table>
</div>
</div>
</div>

</s:form>
<input type="hidden" id="contextPath" value="<%=request.getContextPath() %>">
</body>
</html> 