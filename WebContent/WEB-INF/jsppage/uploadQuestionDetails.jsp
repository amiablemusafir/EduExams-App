<!-- 
Author: Sumit Singh
Start Date: 19th March, 2014
Modify Date:
Modify By:
 -->
<%@page import="java.util.ArrayList"%>
<%@page import="com.oes.dto.ErrorDetailsDto"%>
<%@page import="java.util.List"%>
<%@page import="com.oes.dto.QuestionDetailsDto"%>
<%@page import="com.itextpdf.text.log.SysoLogger"%>
<%@page isThreadSafe="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		 	var datam={onum_sub_category_slno : onum_sub_category_slno, flag : "QUESTION_SECTION_DETAILS"};
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
 	
	function showSectionDetails(){
		var examSection_id = $("#onum_slno").val();
		if(examSection_id != "0") {
			
			var contextPath=$("#contextPath").val();			   
		 	var url=contextPath+"/getExamSectionDetails";
		 	var datam={examSection_id : examSection_id, flag : "EXAM_SECTION_DETAILS"};
		  		$.ajax({
		   			type: "POST",
		   			url: url,
		   			data: datam,
		   
		   			success: function(response){
					    var arr = response.split("@@@");
					   	$("#total_question").val(arr[0]);
					    $("#question_left").val(arr[1]);
		   			}             
		  		});	
		} else {
			$("#total_question").val("");
			$("#question_left").val("");
		}
		
	}
	
	function pageValidation() {
		
		$("#info").html("");
			
		var onum_category_slno = $("#onum_category_slno").val();
		if(onum_category_slno == "0") {
			$("#info").html("Please Select Category");
			return false;
		}
		
		var onum_sub_category_slno = $("#onum_sub_category_slno").val();
		if(onum_sub_category_slno == "0") {
			$("#info").html("Please Select Sub Category");
			return false;
		}		
		
		var onum_slno = $("#onum_slno").val();
		if(onum_slno == "0") {
			$("#info").html("Please Select Section");
			return false;
		}
		
		var exiImg = document.getElementById('uploaded_excel');
	 	var fup = document.getElementById('uploaded_excel');
	  	var fileName = fup.value;
		var ext = fileName.substring(fileName.lastIndexOf('.') + 1);
		
		if(fileName != ''){
			
			if(!(ext == "xls"))
			{
				$('#upload_excel').html('Please upload valid excel file');
				fup.focus();
				return false;
			}
	 	} else {
	 		$('#upload_excel').html('Please upload excel file');
			fup.focus();
			return false;
	 	}
		
		if(exiImg == null) {
			if(!(ext == "xls"))
			{
				$('#upload_excel').html('Upload valid excel file');
				fup.focus();
				return false;
			}
		}
		
		//alert(fup.files[0].size);
		for(var i=0;i<fup.files.length;i++){
		   var fileSize = fup.files[i].size/2024/2024;
		   if(fileSize>1.5){
			  $('#question_error').html('File size should be less then 2.5 MB');   
			  fup.focus();
		 	  return false;
		   }
	    }
		
		
		return true;
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
	
	
	function resetForm() {		
		$("#info").html("");		
	}
</script>

</head>
<body>
<%
   String pageRequest =  (String)request.getSession().getAttribute("pageRequest");
   System.out.println("Page Request::::::::::"+pageRequest);
   
   List<ErrorDetailsDto> errorDetailsDtoList = new ArrayList<ErrorDetailsDto>();
   errorDetailsDtoList = (ArrayList<ErrorDetailsDto>)request.getSession().getAttribute("errorDetailsDtoList");   
   
%>
<s:form theme="simple" name="enquiryDetail" action="saveUploadQuestionDetailsDto" method="post" onsubmit="return pageValidation();" enctype="multipart/form-data">
<s:hidden name="randomStingJsp" id="randomStingJsp"/>

<div class="grid_10">
	<div class="box round first grid">

    <h2>Create Question Master</h2>
	<br/>
	<div class="dms_display_message" id="info"><s:property value="info"/></div>
	
	<div class="dms_admin_unique_detail">
	
<div align="center">

<table width="70%" border="0" cellpadding="0" cellspacing="0">
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
				<select id="onum_slno" name="questionDetailsDto.sectionDetailsDto.onum_slno" tabindex="1">
					<option value="0">Select</option>
				</select>
	</s:if>
	<s:else>
    			<s:select theme="simple" list="sectionDetailsDtoList"
						id="onum_slno" listKey="onum_slno"
						listValue="ostr_section_name"
						name="questionDetailsDto.sectionDetailsDto.onum_slno"
						headerKey="0" headerValue="Select"
						onChange="showSectionDetails();" tabindex="1"></s:select>
	 </s:else> 
	 </div>
	 </div>
     </td>
  	 <td><label for="firstname"><b>Total Active Question</b></label>:</td>
     <td>
      <s:textfield theme="simple"  name="total_question" id="total_question" cssClass="text_field" tabindex="2" readonly="true" cssStyle="text-align:right;"/>
     </td>
  </tr>
  <tr>
  	<td><label for="firstname"><b>Created Question</b></label>:</td>
    <td>
      <s:textfield theme="simple"  name="question_left" id="question_left" cssClass="text_field" tabindex="2" readonly="true" cssStyle="text-align:right;"/>
    </td>
    <td colspan="2" align="center">
    <a href="data/sample_excel.xls"><input type="button" value="Download Sample Excel File" name="Download Sample Excel File" style="width:200px;" class="btn"></a>
    </td>
  </tr>  
 </table>
<div class="clear"></div>
<hr style="width:95%; border-bottom:1px dotted  #CCCCCC;" />		 
</div>


<div class="clear"></div>
     	

<table width="90%" border="0" cellpadding="0" cellspacing="0">
  <tr>
  	<td width="50%" align="right"><label for="lastname"><b>Upload Excel</b></label> :&nbsp;&nbsp;&nbsp;</td>
    <td width="50%" align="left">
       <s:file name="uploaded_excel" id="uploaded_excel" />
    </td>
  </tr>
  <tr>
  	<td width="50%"></td>
    <td align="left"><div class="message1" id="upload_excel"><s:property value="upload_excel"/></div></td>
  </tr>
  </table>
</div>

<div class="clear"></div>
<hr style="width:95%; border-bottom:1px dotted  #CCCCCC;" />


<!--  Button Start  -->
<table width="98%" border="0" cellspacing="0" cellpadding="0">
  <tr>    
    <td width="100%">
    <div align="center">   
	    <input type="submit" value="Submit" name="submit" tabindex="8" style="width:80px;" class="btn">
	    &nbsp;&nbsp;
	    <input type="reset" name="reset" value="Reset" tabindex="9" style="width:80px;" class="btn">
	     &nbsp;&nbsp;
	    <input type="button" value="Cancel" name="Cancel" style="width:80px;" class="btn">
	    
	  
    </div> 
    </td>
  </tr>
</table>
<!--  Button End  -->
</div>
</div>

<s:if test="questionDetailsDtoList != null">
<div class="grid_10">
	<div class="box round first grid">
	<div class="message1">
	<% 
	if(errorDetailsDtoList != null && errorDetailsDtoList.size()>0) {
		for(ErrorDetailsDto dto : errorDetailsDtoList) {
			out.print("Sl No : "+dto.getSlno()+" = "+dto.getError_message()+"<br/>");		
		}
	}
	%>
	</div>
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

	</tbody>
	</table>
</div>
</div>
</div>
</s:if>
<s:else>
				
</s:else>
<div class="clear"></div>

<input type="hidden" name="contextPath" id="contextPath" value="<%=request.getContextPath()%>">
</s:form>
</body>
</html> 