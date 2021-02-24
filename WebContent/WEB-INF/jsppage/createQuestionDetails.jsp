<!-- 
Author: Sumit Singh
Start Date: 19th March, 2014
Modify Date:
Modify By:
 -->
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
	
	function readQuestionURL(input) {
	
		if (input.files && input.files[0]) {
        	var reader = new FileReader();

        	reader.onload = function (e) {
            	$('#blah_question')
                	.attr('src', e.target.result)
                	.width(520)
                	.height(120);
            	};

        	reader.readAsDataURL(input.files[0]);
    	}
	}
	
	function readSolutionURL(input) {
		
		if (input.files && input.files[0]) {
        	var reader = new FileReader();

        	reader.onload = function (e) {
            	$('#blah_solution')
                	.attr('src', e.target.result)
                	.width(520)
                	.height(120);
            	};

        	reader.readAsDataURL(input.files[0]);
    	}
	}
	
	function readOption1URL(input) {
	
		if (input.files && input.files[0]) {
        	var reader = new FileReader();

        	reader.onload = function (e) {
            	$('#blah_option1')
                	.attr('src', e.target.result)
                	.width(200)
                	.height(120);
            	};

        	reader.readAsDataURL(input.files[0]);
    	}
	}
	function readOption2URL(input) {
	
		if (input.files && input.files[0]) {
        	var reader = new FileReader();

        	reader.onload = function (e) {
            	$('#blah_option2')
                	.attr('src', e.target.result)
                	.width(200)
                	.height(120);
            	};

        	reader.readAsDataURL(input.files[0]);
    	}
	}
	function readOption3URL(input) {
	
		if (input.files && input.files[0]) {
        	var reader = new FileReader();

        	reader.onload = function (e) {
            	$('#blah_option3')
                	.attr('src', e.target.result)
                	.width(200)
                	.height(120);
            	};

        	reader.readAsDataURL(input.files[0]);
    	}
	}
	function readOption4URL(input) {
	
		if (input.files && input.files[0]) {
        	var reader = new FileReader();

        	reader.onload = function (e) {
            	$('#blah_option4')
                	.attr('src', e.target.result)
                	.width(200)
                	.height(120);
            	};

        	reader.readAsDataURL(input.files[0]);
    	}
	}
	function readOption5URL(input) {
		
		if (input.files && input.files[0]) {
        	var reader = new FileReader();

        	reader.onload = function (e) {
            	$('#blah_option5')
                	.attr('src', e.target.result)
                	.width(200)
                	.height(120);
            	};

        	reader.readAsDataURL(input.files[0]);
    	}
	}
	
	function pageValidation() {
		
		$("#info").html("");
		$("#question_error").html("");
		$("#option1_error").html("");
		$("#option2_error").html("");
		$("#option3_error").html("");
		$("#option4_error").html("");
		$("#option5_error").html("");
		
		
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
		var ostr_question = $("#ostr_question").val();
		if(ostr_question == "") {
			
			var exiImg = document.getElementById('obl_question');
	 		var fup = document.getElementById('obl_question');
	  		var fileName = fup.value;
			var ext = fileName.substring(fileName.lastIndexOf('.') + 1);
			if(fileName != ''){
			
				if(!(ext == "gif" || ext == "GIF" || ext == "JPEG" || ext == "jpeg" || ext == "jpg" || ext == "JPG" || ext == "png" || ext == "PNG"))
				{
					$('#question_error').html('Upload Gif,Png or Jpg images only');
					fup.focus();
					return false;
				}
	 		} else {
	 			$('#question_error').html('Please Select Image or Enter Text as a Question');
				fup.focus();
				return false;
	 		}
		
			if(exiImg == null) {
				if(!(ext == "gif" || ext == "GIF" || ext == "JPEG" || ext == "jpeg" || ext == "jpg" || ext == "JPG" || ext == "png" || ext == "PNG"))
				{
					$('#question_error').html('Upload Gif,Png or Jpg images only');
					fup.focus();
					return false;
				}
			}
		
			//alert(fup.files[0].size);
			for(var i=0;i<fup.files.length;i++){
		 	   var fileSize = fup.files[i].size/1024/1024;
		 	   if(fileSize>1.5){
		 		  $('#question_error').html('Image size should be less then 1.5 MB');   
		 		  fup.focus();
		 		  return false;
		 	   }
		    }
		}
		
		
		
		
		var option1 = $("#ostr_option1").val();
		if(option1 == "") {
			var exiImg = document.getElementById('option1');
	 		var fup = document.getElementById('option1');
	  		var fileName = fup.value;
			var ext = fileName.substring(fileName.lastIndexOf('.') + 1);
			if(fileName != ''){
			
				if(!(ext == "gif" || ext == "GIF" || ext == "JPEG" || ext == "jpeg" || ext == "jpg" || ext == "JPG" || ext == "png" || ext == "PNG"))
				{
					$('#option1_error').html('Upload Gif,Png or Jpg images only');
					fup.focus();
					return false;
				}
	 		} else {
	 			$('#option1_error').html('Please Select Image or Enter Text as a Option');
				fup.focus();
				return false;
	 		}
		
			if(exiImg == null) {
				if(!(ext == "gif" || ext == "GIF" || ext == "JPEG" || ext == "jpeg" || ext == "jpg" || ext == "JPG" || ext == "png" || ext == "PNG"))
				{
					$('#option1_error').html('Upload Gif,Png or Jpg images only..');
					fup.focus();
					return false;
				}
			}
		
			//alert(fup.files[0].size);
			for(var i=0;i<fup.files.length;i++){
		 	   var fileSize = fup.files[i].size/1024/1024;
		 	   if(fileSize>1.5){
		 		  $('#option1_error').html('Image size should be less then 1.5 MB');   
		 		  fup.focus();
		 		  return false;
		 	   }
		    }
		}
		
		
		
		
		
		var option2 = $("#ostr_option2").val();
		if(option2 == "") {
			var exiImg = document.getElementById('option2');
	 		var fup = document.getElementById('option2');
	  		var fileName = fup.value;
			var ext = fileName.substring(fileName.lastIndexOf('.') + 1);
			if(fileName != ''){
			
				if(!(ext == "gif" || ext == "GIF" || ext == "JPEG" || ext == "jpeg" || ext == "jpg" || ext == "JPG" || ext == "png" || ext == "PNG"))
				{
					$('#option2_error').html('Upload Gif,Png or Jpg images only');
					fup.focus();
					return false;
				}
	 		} else {
	 			$('#option2_error').html('Please Select Image or Enter Text as a Option');
				fup.focus();
				return false;
	 		}
		
			if(exiImg == null) {
				if(!(ext == "gif" || ext == "GIF" || ext == "JPEG" || ext == "jpeg" || ext == "jpg" || ext == "JPG" || ext == "png" || ext == "PNG"))
				{
					$('#option2_error').html('Upload Gif,Png or Jpg images only..');
					fup.focus();
					return false;
				}
			}
		
			//alert(fup.files[0].size);
			for(var i=0;i<fup.files.length;i++){
		 	   var fileSize = fup.files[i].size/1024/1024;
		 	   if(fileSize>1.5){
		 		  $('#option2_error').html('Image size should be less then 1.5 MB');   
		 		  fup.focus();
		 		  return false;
		 	   }
		    }
		}
		
		
		
		
		var option3 = $("#ostr_option3").val();
		if(option3 == "") {
			var exiImg = document.getElementById('option3');
	 		var fup = document.getElementById('option3');
	  		var fileName = fup.value;
			var ext = fileName.substring(fileName.lastIndexOf('.') + 1);
			if(fileName != ''){
			
				if(!(ext == "gif" || ext == "GIF" || ext == "JPEG" || ext == "jpeg" || ext == "jpg" || ext == "JPG" || ext == "png" || ext == "PNG"))
				{
					$('#option3_error').html('Upload Gif,Png or Jpg images only');
					fup.focus();
					return false;
				}
	 		} else {
	 			$('#option3_error').html('Please Select Image or Enter Text as a Option');
				fup.focus();
				return false;
	 		}
		
			if(exiImg == null) {
				if(!(ext == "gif" || ext == "GIF" || ext == "JPEG" || ext == "jpeg" || ext == "jpg" || ext == "JPG" || ext == "png" || ext == "PNG"))
				{
					$('#option3_error').html('Upload Gif,Png or Jpg images only..');
					fup.focus();
					return false;
				}
			}
		
			//alert(fup.files[0].size);
			for(var i=0;i<fup.files.length;i++){
		 	   var fileSize = fup.files[i].size/1024/1024;
		 	   if(fileSize>1.5){
		 		  $('#option3_error').html('Image size should be less then 1.5 MB');   
		 		  fup.focus();
		 		  return false;
		 	   }
		    }
		}
		
		
		
		
		var option4 = $("#ostr_option4").val();
		if(option4 == "") {
			var exiImg = document.getElementById('option4');
	 		var fup = document.getElementById('option4');
	  		var fileName = fup.value;
			var ext = fileName.substring(fileName.lastIndexOf('.') + 1);
			if(fileName != ''){
			
				if(!(ext == "gif" || ext == "GIF" || ext == "JPEG" || ext == "jpeg" || ext == "jpg" || ext == "JPG" || ext == "png" || ext == "PNG"))
				{
					$('#option4_error').html('Upload Gif,Png or Jpg images only');
					fup.focus();
					return false;
				}
	 		} else {
	 			$('#option4_error').html('Please Select Image or Enter Text as a Option');
				fup.focus();
				return false;
	 		}
		
			if(exiImg == null) {
				if(!(ext == "gif" || ext == "GIF" || ext == "JPEG" || ext == "jpeg" || ext == "jpg" || ext == "JPG" || ext == "png" || ext == "PNG"))
				{
					$('#option4_error').html('Upload Gif,Png or Jpg images only..');
					fup.focus();
					return false;
				}
			}
		
			//alert(fup.files[0].size);
			for(var i=0;i<fup.files.length;i++){
		 	   var fileSize = fup.files[i].size/1024/1024;
		 	   if(fileSize>1.5){
		 		  $('#option4_error').html('Image size should be less then 1.5 MB');   
		 		  fup.focus();
		 		  return false;
		 	   }
		    }
		}
		
		var option5 = $("#ostr_option5").val();
		if(option5 == "") {
			var exiImg = document.getElementById('option5');
	 		var fup = document.getElementById('option5');
	  		var fileName = fup.value;
			var ext = fileName.substring(fileName.lastIndexOf('.') + 1);
			if(fileName != ''){
			
				if(!(ext == "gif" || ext == "GIF" || ext == "JPEG" || ext == "jpeg" || ext == "jpg" || ext == "JPG" || ext == "png" || ext == "PNG"))
				{
					$('#option5_error').html('Upload Gif,Png or Jpg images only');
					fup.focus();
					return false;
				}
				
				if(exiImg == null) {
					if(!(ext == "gif" || ext == "GIF" || ext == "JPEG" || ext == "jpeg" || ext == "jpg" || ext == "JPG" || ext == "png" || ext == "PNG"))
					{
						$('#option5_error').html('Upload Gif,Png or Jpg images only..');
						fup.focus();
						return false;
					}
				}
				
				//alert(fup.files[0].size);
				for(var i=0;i<fup.files.length;i++){
			 	   var fileSize = fup.files[i].size/1024/1024;
			 	   if(fileSize>1.5){
			 		  $('#option5_error').html('Image size should be less then 1.5 MB');   
			 		  fup.focus();
			 		  return false;
			 	   }
			    }
	 		}		
		}
			
		return true;
	}
	
	
	
	function resetForm() {
		
		$('#blah_question').attr('src', "").width(0).height(0);
		$('#blah_option1').attr('src', "").width(0).height(0);
		$('#blah_option2').attr('src', "").width(0).height(0);
		$('#blah_option3').attr('src', "").width(0).height(0);
		$('#blah_option4').attr('src', "").width(0).height(0);
		$('#blah_option5').attr('src', "").width(0).height(0);
		
		$("#info").html("");
		$("#question_error").html("");
		$("#option1_error").html("");
		$("#option2_error").html("");
		$("#option3_error").html("");
		$("#option4_error").html("");
		$("#option5_error").html("");
		
	}
	
	function showFifthOption() {
		$("#fifth_option").show();
		$("#correct_ans_fifth_option").show();
	}
	
	function removeFifthOption() {
		$("#fifth_option").hide();
		$("#correct_ans_fifth_option").hide();
		$('#blah_option5').attr('src', "").width(0).height(0);
		$("#option5_error").html("");
		$("#ostr_option5").val("");
		$("#correct_option1").prop('checked', 'checked');
	}
</script>

</head>
<body>
<%
   String pageRequest =  (String)request.getSession().getAttribute("pageRequest");
   System.out.println("Page Request::::::::::"+pageRequest);
%>
<s:form theme="simple" name="enquiryDetail" action="saveQuestionDetailsDto" method="post" onsubmit="return pageValidation();" enctype="multipart/form-data">
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
    <td></td>
    <td></td>
  </tr>
  
 </table>
 </div>
 
<div class="clear"></div>
<hr style="width:95%; border-bottom:1px dotted  #CCCCCC;" />		 
</div>


<div class="clear"></div>
     	

<table width="90%" border="0" cellpadding="0" cellspacing="0">
  <tr>
  	<td width="28px;"></td>
    <td width="14%"><label for="lastname"><b>Question</b></label> :</td>
    <td>
      <s:textarea theme="simple" cols="78" rows="4" name="questionDetailsDto.ostr_question" id="ostr_question" tabindex="6" cssStyle="width :60%px;"/><br/>
      <s:file name="obl_question" id="obl_question" onchange="readQuestionURL(this);" />
    </td>
  </tr>
  <tr>
  	<td width="28px;"></td>
    <td width="14%"></td>
    <td><img id="blah_question"/></td>
  </tr>
  <tr>
  	<td width="28px;"></td>
    <td width="14%"></td>
    <td><div id="question_error" class="message1"></div></td>
  </tr>
 
  <tr>
  	<td height="20px;">&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  
  
  <tr>
  	<td width="28px;"></td>
    <td width="14%"><label for="lastname"><b>Option 1</b></label>:</td>
    <td>
      <s:textfield theme="simple" name="questionDetailsDto.ostr_option1" id="ostr_option1" tabindex="7"  size="30"/>&nbsp;&nbsp;
      <s:file name="option1" id="option1" onchange="readOption1URL(this);" />
    </td>
  </tr>
  <tr>
  	<td width="28px;"></td>
    <td width="14%"></td>
    <td><img id="blah_option1"/></td>
  </tr>
  <tr>
  	<td width="28px;"></td>
    <td width="14%"></td>
    <td><div id="option1_error" class="message1"></div></td>
  </tr>
  <tr>
  	<td width="28px;"></td>
    <td width="14%"><label for="lastname"><b>Option 2</b></label>:</td>
    <td>
      <s:textfield theme="simple" name="questionDetailsDto.ostr_option2" id="ostr_option2"  tabindex="8" size="30"/>&nbsp;&nbsp;
      <s:file name="option2" id="option2" onchange="readOption2URL(this);"/>
    </td>
  </tr>
  <tr>
  	<td width="28px;"></td>
    <td width="14%"></td>
    <td><img id="blah_option2"/></td>
  </tr>
  <tr>
  	<td width="28px;"></td>
    <td width="14%"></td>
    <td><div id="option2_error" class="message1"></div></td>
  </tr>
  <tr>
  	<td width="28px;"></td>
    <td width="14%"><label for="lastname"><b>Option 3</b></label>:</td>
    <td>
      <s:textfield theme="simple" name="questionDetailsDto.ostr_option3" id="ostr_option3"  tabindex="9" size="30"/>&nbsp;&nbsp;
      <s:file name="option3" id="option3" onchange="readOption3URL(this);"/>
    </td>
  </tr>
  <tr>
  	<td width="28px;"></td>
    <td width="14%"></td>
    <td><img id="blah_option3"/></td>
  </tr>
  <tr>
  	<td width="28px;"></td>
    <td width="14%"></td>
    <td><div id="option3_error" class="message1"></div></td>
  </tr>
  <tr>
  	<td width="28px;"></td>
    <td width="14%"><label for="lastname"><b>Option 4</b></label>:</td>
    <td>
      <s:textfield theme="simple" name="questionDetailsDto.ostr_option4" id="ostr_option4"  tabindex="10" size="30"/>&nbsp;&nbsp;
      <s:file name="option4" id="option4" onchange="readOption4URL(this);"/>
    </td>
  </tr>
  <tr>
  	<td width="28px;"></td>
    <td width="14%"></td>
    <td><img id="blah_option4"/></td>
  </tr>
  <tr>
  	<td width="28px;"></td>
    <td width="14%"></td>
    <td><div id="option4_error" class="message1"></div></td>
  </tr>  
  <tr>
  	<td width="28px;"></td>
    <td width="14%"></td>
    <td><a style="cursor: pointer;" onclick="showFifthOption();">Add Fifth Option</a> | <a style="cursor: pointer;" onclick="removeFifthOption();">Remove Fifth Option</a></td>
  </tr>
  </table>
  <div id="fifth_option" style="display: none;">
  <table width="90%" border="0" cellpadding="0" cellspacing="0">
  
  <tr>
  	<td width="28px;"></td>
    <td width="14%"><label for="lastname"><b>Option 5</b></label>:</td>
    <td>
      <s:textfield theme="simple" name="questionDetailsDto.ostr_option5" id="ostr_option5"  tabindex="10" size="30"/>&nbsp;&nbsp;
      <s:file name="option5" id="option5" onchange="readOption5URL(this);"/>
    </td>
  </tr>
  <tr>
  	<td width="28px;"></td>
    <td width="14%"></td>
    <td><img id="blah_option5"/></td>
  </tr>
  <tr>
  	<td width="28px;"></td>
    <td width="14%"></td>
    <td><div id="option5_error" class="message1"></div></td>
  </tr>
  </table>
  </div>


<div class="clear"></div>
<div class="dms_admin_cover" align="left">
<table width="50%" border="0" cellpadding="0" cellspacing="0" style="margin-left: 30px; margin-top: 40px;">
  <tr>
  	
    <td width="14%" colspan="5"><label for="lastname"><b>Correct Answer </b></label>:</td>
  </tr>
  <tr>
  	
    <td>&nbsp;</td>
  </tr>
  <tr>
   
    <td width="5%"><b>Option 1</b><input type="radio" name="questionDetailsDto.ostr_correct_option" value="1" checked="checked" id="correct_option1"/></td>
    <td width="5%">&nbsp;&nbsp;<b>Option 2 </b><input type="radio" name="questionDetailsDto.ostr_correct_option" value="2"/></td>
    <td width="5%">&nbsp;&nbsp;<b>Option 3 </b><input type="radio" name="questionDetailsDto.ostr_correct_option" value="3"/></td>
    <td width="5%">&nbsp;&nbsp;<b>Option 4 </b><input type="radio" name="questionDetailsDto.ostr_correct_option" value="4"/></td>
    <td width="5%">
    <div id="correct_ans_fifth_option" style="display: none;">
    &nbsp;&nbsp;<b>Option 5 </b><input type="radio" name="questionDetailsDto.ostr_correct_option" value="5" id="correct_option5"/>
    </div>
    </td>
  </tr>
  <tr>
  	<td colspan="5"><div id="option1_error" class="message1"></div></td>
  </tr>
</table>
<table width="90%" border="0" cellpadding="0" cellspacing="0">
	<tr>
	 	<td width="28px;"></td>
	    <td width="14%"><label for="lastname"><b>Solution</b></label> :</td>
	    <td>
	      <s:textarea theme="simple" cols="78" rows="4" name="questionDetailsDto.ostr_solution" id="ostr_solution" tabindex="6" cssStyle="width :60%px;"/><br/>
	      <s:file name="obl_solution" id="obl_solution" onchange="readSolutionURL(this);" />
	    </td>
	  </tr>
	  <tr>
	  	<td width="28px;"></td>
	    <td width="14%"></td>
	    <td><img id="blah_solution"/></td>
	  </tr>
	  <tr>
	  	<td width="28px;"></td>
	    <td width="14%"></td>
	    <td><div id="solution_error" class="message1"></div></td>
	  </tr>
	 
	  <tr>
	  	<td height="20px;">&nbsp;</td>
	    <td>&nbsp;</td>
	    <td>&nbsp;</td>
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
<div class="clear"></div>
<br/>
<br/>
<div class="clear"></div>
</div>
</div>
<input type="hidden" name="contextPath" id="contextPath" value="<%=request.getContextPath()%>">

</s:form>
</body>
</html> 