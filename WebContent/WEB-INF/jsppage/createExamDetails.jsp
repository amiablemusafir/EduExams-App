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

<link href="css/themes/base/jquery.ui.all.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-ui/jquery.ui.widget.min.js" type="text/javascript"></script>
<script src="js/jquery-ui/jquery.ui.datepicker.min.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery-ui/jquery.ui.core.min.js"></script>


<script src="js/timepicker.js"></script>
<link rel="stylesheet" type="text/css" media="all" href="style/timepicker.css" />
<script type="text/javascript">
$(document).ready(function(){
	
	$( "#odt_exam_date" ).datepicker({
	changeMonth: true,
	changeYear: true,
	dateFormat: 'dd-mm-yy'
	});
	$('#odt_exam_time').timepicker({
		hourMin: 0,
		hourMax: 23
    });
	
});
</script>
<script type="text/javascript">
function showSubCategoryDetails(id) {
	var onum_category_slno = $("#onum_category_slno"+id).val();
	if(onum_category_slno != "0") {
		var contextPath=$("#contextPath").val();	
		var url=contextPath+"/getExamSectionDetails";
	 	var datam={onum_category_slno : onum_category_slno,id : id , flag : "CREATE_EXAM_SUB_CATEGORY_DETAILS"};
	  		$.ajax({
	   			type: "POST",
	   			url: url,
	   			data: datam,
	   
	   			success: function(response){
	   			 	 $("#sub_category_details"+id).html(response);
	   			}             
	  		});	
	}
}
	
function showSectionDetailsList(id) {
	var onum_sub_category_slno = $("#onum_sub_category_slno"+id).val();
	if(onum_sub_category_slno != "0") {
		var contextPath=$("#contextPath").val();	
		var url=contextPath+"/getExamSectionDetails";
	 	var datam={onum_sub_category_slno : onum_sub_category_slno, id : id, flag : "CREATE_EXAM_QUESTION_SECTION_DETAILS"};
	  		$.ajax({
	   			type: "POST",
	   			url: url,
	   			data: datam,
	   
	   			success: function(response){
	   			 	 $("#section_details"+id).html(response);
	   			}             
	  		});	
	}
}

function showSectionDetails(id){
	
	var examSection_id = $("#section"+id).val();
	var contextPath=$("#contextPath").val();			   
	var url=contextPath+"/getExamSectionDetails";
	var datam={examSection_id : examSection_id, flag : "EXAM_SECTION_DETAILS_BY_ID"};
	$.ajax({
		type: "POST",
		url: url,
		data: datam,
	   
		success: function(response){
				$("#total_active_question"+id).val(response);
		}             
	});		
}


function addNewRow1() {  
		
		var table_loop_size = $("#table_loop_size").val();
		table_loop_size = parseInt(table_loop_size) + 1;
		
		var divHtml = "";
		divHtml = divHtml+'<tr id="itemrow'+table_loop_size+'">';
		divHtml = divHtml+'<td class="itemcenter5">&nbsp;&nbsp;&nbsp;'+table_loop_size+'</td>';
		
		divHtml = divHtml+'<td class="itemcenter5"><div class="styled-select2">';
	  	divHtml = divHtml+'<select name="category" id="onum_category_slno'+table_loop_size+'" onChange="showSubCategoryDetails('+table_loop_size+')">';
	  	divHtml = divHtml+'<option value="0">Select</option>';
	    divHtml = divHtml+'<s:iterator value="categoryDetailsDtoList" var="catecoryList">';
	  	divHtml = divHtml+'<option value="${catecoryList.onum_slno}">${catecoryList.ostr_category_name}</option></s:iterator></select></div></td>';
	  	
	  	
	  	divHtml = divHtml+'<td class="itemcenter5"><div id="sub_category_details'+table_loop_size+'"><div class="styled-select2">';
	  	divHtml = divHtml+'<select name="sub_category" id="onum_sub_category_slno'+table_loop_size+'" onChange="showSectionDetailsList('+table_loop_size+')">';
	  	divHtml = divHtml+'<option value="0">Select</option>';
	    divHtml = divHtml+'<s:iterator value="subCategoryDetailsDtoList" var="subCategoryList">';
	  	divHtml = divHtml+'<option value="${subCategoryList.onum_slno}">${subCategoryList.ostr_section_name}</option></s:iterator></select></div></div></td>';
	  	
		
		divHtml = divHtml+'<td class="itemcenter5"><div id="section_details'+table_loop_size+'"><div class="styled-select2">';
	  	divHtml = divHtml+'<select name="section" id="section'+table_loop_size+'" onChange="showSectionDetails('+table_loop_size+')">';
	  	divHtml = divHtml+'<option value="0">Select</option>';
	    divHtml = divHtml+'<s:iterator value="sectionDetailsDtoList" var="sectionList">';
	  	divHtml = divHtml+'<option value="${sectionList.onum_slno}">${sectionList.ostr_section_name}</option></s:iterator></select></div></div></td>';
	  	
	  	divHtml = divHtml+'<td align="right"><input type="text" name="total_active_question" id="total_active_question'+table_loop_size+'" value="0" class="text_field2" style="text-align: right;" readonly="readonly"></td>';        
		divHtml = divHtml+'<td align="right"><input type="text" name="question" id="question'+table_loop_size+'" value="0" class="text_field2" onblur="calulateQuestion();" style="text-align: right;"></td>';
		divHtml = divHtml+'<td align="right"><input type="text" name="mark" id="mark'+table_loop_size+'"  value="0" class="text_field2" onblur="calulateQuestion();" style="text-align: right;"></td>';
		divHtml = divHtml+'</tr>';
		
		$("#requestList").append(divHtml);	
		$("#table_loop_size").val(table_loop_size);
		this.calulateQuestion();
	}
	
	function removeRow1() {
		var id = $("#table_loop_size").val();
		if(id != '1') {
			$("#itemrow"+id).remove();
			id = parseInt(id)-1;
			$("#table_loop_size").val(id);
		}
		this.calulateQuestion();
	}
	
	function calulateQuestion() {
		
		var id = $("#table_loop_size").val();
		var totalQuestion = '0';
		var totalMark = '0';
		for(var i = 1; i<=id; i++) {
			
			var question = $("#question"+i).val();
			if (!isInteger(question)) {
				$('#info').html("<div class='message success'><h5>Success!</h5><p>Please enter valid Question</p></div>");
				question = "0";
			}
			question = parseInt(question);
			$("#question"+i).val(question);
			
			if(question != '') {
				totalQuestion = parseInt(totalQuestion)+parseInt(question);
			}
			var mark = $("#mark"+i).val();
			if (!isInteger(mark)) {
				$('#info').html('Please enter valid Mark');
				mark = "0";
			}
			mark = parseInt(mark);
			$("#mark"+i).val(mark);
			if(mark != '') {
				totalMark = parseInt(totalMark)+parseInt(mark);
			}
		}	
		$("#total_question").html(totalQuestion);
		$("#total_mark").html(totalMark);
	}
	
	function submitData()
	{
		
		$("#info").html("");
		$("#info2").html("");
		var ostr_exam_name=$("#ostr_exam_name").val();
		//alert("inside");
		if(ostr_exam_name=="")
		{
			$('#info').html("Please enter Exam Name</div>");
			$("#ostr_exam_name").focus();
			return false;
		}
		
		var onum_course_id=$("#onum_course_id").val();
		//alert("inside");
		if(onum_course_id=='0')
		{
			$('#info').html("Please select Course Name</div>");
			$("#onum_course_id").focus();
			return false;
		}
		
		var odt_exam_date=$('#odt_exam_date').val();
		if(odt_exam_date=="")
		{
			$('#info').html("Please Select Exam Date");
			$("#odt_exam_date").focus();
			return false;
		}
		
		var odt_exam_time=$('#odt_exam_time').val();
		if(odt_exam_time=="")
		{
			$('#info').html("Please Select Exam time");
			$("#odt_exam_time").focus();
			return false;
		}
		
		var obl_exam_pic=$("#obl_exam_pic").val();
		//alert("inside");
		if(obl_exam_pic == '0')
		{
			$('#info').html("Please select Exam Pic");
			$("#obl_exam_pic").focus();
			return false;
		}
		
		var ostr_exam_pattern = $("#ostr_exam_pattern").val();
		if(ostr_exam_pattern == '0')
		{
			$('#info').html("Please select Exam Pattern");
			$("#obl_exam_pic").focus();
			return false;
		}
				
		var ostr_exam_description=$('#ostr_exam_description').val();
		if(ostr_exam_description=="")
		{
			$('#info').html("Please enter some Description");
			$("#ostr_exam_description").focus();
			return false;
		}
		
		var ostr_price=$('#ostr_price').val();
		if(ostr_price == "")
		{
			$('#info').html("Please enter price for examination");
			$("#ostr_price").focus();
			return false;
		}
		if (!isInteger(ostr_price)) {
			$('#info').html('Please enter valid price for examination');
			$("#ostr_price").focus();
			return false;
		}	
		
		var ostr_negative_mark = $('#ostr_negative_mark').val();
		if(ostr_negative_mark == "")
		{
			$('#info').html("Please enter negative mark");
			$("#ostr_negative_mark").focus();
			return false;
		}
		if(!isValidPersantage(ostr_negative_mark))
		{
			$('#info').html("Please enter valid negative mark e.g: 0.25, 0.50");
			$("#ostr_negative_mark").focus();
			return false;
		}
		
		var sectionDetailsArr = new Array();
		var table_loop_size = $("#table_loop_size").val();
		
		for(var i = 1; i<=table_loop_size; i++) {
			
			var section = $('#section'+i).val();
			if(section == "0")
			{
				
				$('#info2').html("Please Select section");
				$("#section"+i).focus();
				return false;
			}
			sectionDetailsArr.push(section);
						
			var question = $('#question'+i).val();
			if(question == "")
			{
				$('#info2').html("Please enter question");
				$("#question"+i).focus();
				return false;
			}
			if(question == "0")
			{
				$('#info2').html("Please enter question");
				$("#question"+i).focus();
				return false;
			}
			
			var total_active_question = $("#total_active_question"+i).val();
			
			question = parseInt(question);
			total_active_question = parseInt(total_active_question);
			
			if(question>total_active_question) {
				
				$('#info2').html("Question should not be grether than active question");
				$("#question"+i).focus();
				return false;
			}
			
			var mark = $('#mark'+i).val();
			if(mark == "")
			{
				$('#info2').html("Please enter mark");
				$("#mark"+i).focus();
				return false;
			}
			if(mark == "0")
			{
				$('#info2').html("Please enter mark");
				$("#mark"+i).focus();
				return false;
			}
			
		}
		if(has_duplicates(sectionDetailsArr)==true) {			
			$('#info2').html("You can't select same Section multiple times.");
			return false;
		}
		
		if(ostr_price != '0') {
			var price = $("#ostr_price").val();
			price = price+".00";
			$("#ostr_price").val(price);
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
	
	function has_duplicates(arr) {

	    var x = {}, len = arr.length;
	    for (var i = 0; i < len; i++) {
	        if (x[arr[i]]) {
	             return true;
	        }
	        x[arr[i]] = true;
	    }
	    return false;
	}
	function isValidPersantage(num) {
		
		var num2 = parseInt(num);
		if (((num2>=0) && (num2<=100))) {
			return true;
		}	
		return false;
	}
</script>
</head>
<body>
<%
   String pageRequest =  (String)request.getSession().getAttribute("pageRequest");
   System.out.println("Page Request::::::::::"+pageRequest);
%>
<s:form theme="simple" name="saveExamSectionDetail" action="saveExamSectionDetail" method="post" onsubmit="return submitData()"  enctype="multipart/form-data">

<s:hidden name="randomStingJsp" id="randomStingJsp"/>

<div class="grid_10">
	<div class="box round first grid">

    <h2>Create Exam Master</h2>
	<br/>
	<div class="dms_display_message" id="info"><s:property value="info"/></div>


<div align="center">
<table width="80%" border="0" cellpadding="0" cellspacing="0">
  <tr>
  	
    <td><label for="Unique ID"><b>Exam Name</b></label>:</td>
    <td>   
    <s:textfield theme="simple" name="examDetailsDto.ostr_exam_name" cssClass="text_field" id="ostr_exam_name" tabindex="1"/>
    </td>
    
    <td width="10%"></td>
    
    <td><label for="gender"><b>Course</b></label>:</td>
    <td>   
    <div class="styled-select2">
   
    <s:select theme="simple" list="courseDetailsDtoList"
						id="onum_course_id" listKey="onum_slno"
						listValue="ostr_course_name"
						name="examDetailsDto.courseDetailsDto.onum_slno"
						headerKey="0" headerValue="Select"
						onChange="" tabindex="1"></s:select> </div>
    </td>
  </tr>
  
  
  <tr>
    <td><label for="firstname"><b>Date</b></label>:</td>
    <td>
       <s:textfield theme="simple" name="examDetailsDto.odt_exam_date" cssClass="text_field" id="odt_exam_date" tabindex="2" readonly="true"/>
    </td>
        
    <td width="10%"></td>
    
    <td><label for="Email"><b>Time </b></label>:</td>
    <td>   
    <s:textfield theme="simple" name="examDetailsDto.odt_exam_time" cssClass="text_field" id="odt_exam_time" tabindex="6" readonly="true"/>
    </td>
  </tr>
  
  <tr>
    <td><label for="firstname"><b>Exam Image</b></label>:</td>
    <td>
        <div class="styled-select2">   
    	<s:select theme="simple" list="examImageMasterDtoList"
						id="obl_exam_pic" listKey="ostr_image_url"
						listValue="ostr_exam_name"
						name="examDetailsDto.obl_exam_pic"
						headerKey="0" headerValue="Select"
						onChange="" tabindex="1"></s:select> 
		</div>
    </td>
        
    <td width="10%"></td>
    <td><label for="firstname"><b>Exam Pattern</b></label>:</td>
    <td>
        <div class="styled-select2">   
    	<select name="examDetailsDto.ostr_exam_pattern" id="ostr_exam_pattern">
    		<option value="0">select</option>
    		<option value="1">Banking</option>
    		<option value="2">Default</option>
    	</select>
		</div>
    </td>
    
  </tr>
  
  <tr>
	  <td><label for="firstname"><b>Description</b></label>:</td>
	  <td colspan="4">
	      <s:textarea theme="simple" cols="78" rows="4" cssStyle="width: 85%; height: 70px;" name="examDetailsDto.ostr_exam_description" id="ostr_exam_description" tabindex="3"/>
	  </td>
  </tr>
  <tr>
    <td><label for="Email"><b>Negative Mark</b></label>:</td>
    <td>   
    <s:textfield theme="simple" name="examDetailsDto.ostr_negative_mark" cssClass="text_field4" id="ostr_negative_mark" tabindex="8" maxlength="6" value="0"/><b style="font-size: 16px;">%</b>
    </td>
        
    <td width="10%"></td>
   
    <td><label for="Email"><b>Exam Price </b></label>:</td>
    <td>   
    <s:textfield theme="simple" name="examDetailsDto.ostr_price" cssClass="text_field4" id="ostr_price" tabindex="8" maxlength="6" value="0"/> <i><b>E.g : 0, 5, 10</b></i>
    </td> 
   
  </tr>
  <tr>
    <td colspan="5">&nbsp;</td>
  </tr>
  <tr>
  	<td></td>
    <td colspan="4" align="left" style="color: red;"><b>Note :</b><i> Above mention negative mark are awarded to each and every wrong answer. If you don't want any negative mark enter 0.</i></td>
  </tr>
</table>
</div>


<br/>
<div class="dms_display_message" id="info2"><s:property value="info2"/></div>

<br/>
<div align="center">

<div class="clear"></div>

		<table width="95%" border="1" bordercolor="#B3CBD6" cellspacing="0" cellpadding="0" id="requestList">
	
		   <tr>
		  <td colspan="5" style="background: #eee; color: #000000;"><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Section Details</b></td>
		  <td height="35px" style="background: #eee; color: #000000;" colspan="2"><div align="right"><a class="btn-mini btn-black btn-plus" onclick="addNewRow1();"><span></span>Add</a> &nbsp;&nbsp;<a class="btn-mini btn-black btn-minus" onclick="removeRow1();"><span></span>Remove</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div></td>
		  </tr>
		  <tr style="background: #eee; color: #000000;">
		  	  <td width="7%" height="30px">&nbsp;&nbsp;&nbsp; <b>Sl No.</b></td>
		  	  <td width="18%">&nbsp;&nbsp;&nbsp; <b>Category</b></td>
		  	  <td width="18%">&nbsp;&nbsp;&nbsp; <b>Sub Category</b></td>
		  	  <td width="18%">&nbsp;&nbsp;&nbsp; <b>Section</b></td>
		  	  <td width="13%">&nbsp;&nbsp;&nbsp; <b>Active Question</b></td>
		      <td width="13%">&nbsp;&nbsp;&nbsp; <b>No of Questions</b></td>
		      <td width="13%">&nbsp;&nbsp;&nbsp; <b>Total Marks</b></td>
		  </tr>
		  
		  <tr id="itemrow1">
		  	  <td class="itemcenter5">&nbsp;&nbsp;&nbsp;1</td>
		      <td class="itemcenter5">
		       		<div class="styled-select2">
		    		<s:if test="categoryDetailsDtoList == null">
						<select id="onum_category_slno1" name="category" tabindex="1">
							<option value="0">Select</option>
						</select>
					</s:if>
					<s:else>
		    			<s:select theme="simple" list="categoryDetailsDtoList"
								id="onum_category_slno1" listKey="onum_slno"
								listValue="ostr_category_name"
								name="category"
								headerKey="0" headerValue="Select"
								onChange="showSubCategoryDetails('1');" tabindex="1"></s:select>
			 		</s:else> 
			 		</div>
			  </td>
			  <td class="itemcenter5">
		        <div id="sub_category_details1">
		    	<div class="styled-select2">
			    	<s:if test="subCategoryDetailsDtoList == null">
							<select id="onum_sub_category_slno1" name="sub_category" tabindex="1">
								<option value="0">Select</option>
							</select>
					</s:if>
					<s:else>
			    			<s:select theme="simple" list="subCategoryDetailsDtoList"
									id="onum_sub_category_slno1" listKey="onum_slno"
									listValue="ostr_sub_category_name"
									name="sub_category"
									headerKey="0" headerValue="Select"
									onChange="showSectionDetailsList('1');" tabindex="2"></s:select>
				 	</s:else> 
			 	</div>
			 	</div>
			  </td>
			  <td class="itemcenter5">
		       <div id="section_details1">
				    <div class="styled-select2">    
				    <s:if test="sectionDetailsDtoList == null">
								<select id="section1" name="section" tabindex="1">
									<option value="0">Select</option>
								</select>
					</s:if>
					<s:else>
				    			<s:select theme="simple" list="sectionDetailsDtoList"
										id="section1" listKey="onum_slno"
										listValue="ostr_section_name"
										name="section"
										headerKey="0" headerValue="Select"
										onChange="showSectionDetails('1');" tabindex="1"></s:select>
					 </s:else> 
					 </div>
			  </div>
		             
			  </td>	
			  <td align="right"><input type="text" name="total_active_question" id="total_active_question1" value="0" class="text_field2" style="text-align: right;" readonly="readonly"></td>
		      <td align="right"><input type="text" name="question" id="question1" value="0" class="text_field2" onblur="calulateQuestion();" style="text-align: right;"></td>
		      <td align="right"><input type="text" name="mark" id="mark1" class="text_field2" value="0" onblur="calulateQuestion();" style="text-align: right;"></td>
		  </tr>
		  </table>
		  
		  
		  
		  
		  
		  <table width="95%" border="1" bordercolor="#B3CBD6" cellspacing="0" cellpadding="0" id="requestList2" class="Table" style="margin-top: -21px;">
		  <tr>
		      <td colspan="2" class="itemcenter6" width="74%" height="30px;"> </td>
		      <td align="right" colspan="1" class="itemcenter6" width="13%" height="30px;" style="font-weight: bold; font-size: 13px;">Total Question</td>
		      <td align="right" class="itemcenter6" width="13%" height="30px;"><div id="total_question" style="font-weight: bold; font-size: 13px;">0</div></td>
		  </tr>
		  <tr>

		      <td colspan="2" class="itemcenter6" height="30px;"> </td>
		      <td colspan="1" class="itemcenter6" height="30px;" style="font-weight: bold; font-size: 13px;" align="right">Total Marks</td>
		      <td class="itemcenter6" height="30px;"><div id="total_mark" style="font-weight: bold; font-size: 13px;" align="right">0</div></td>
		  </tr>		
		</table>
</div>
<input type="hidden" name="table_loop_size" id="table_loop_size" value="1">


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


<input type="hidden" name="contextPath" id="contextPath" value="<%=request.getContextPath()%>">
</s:form>


</body>
</html> 