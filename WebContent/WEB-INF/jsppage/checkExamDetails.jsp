<!-- 
Author: Sumit Singh
Start Date: 19th March, 2014
Modify Date:
Modify By:
 -->
<%@page import="com.oes.action.Encryption"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.oes.dto.StudentMappedExamDetailsDto"%>
<%@page import="java.util.List"%>
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
<link rel="stylesheet" href="style/report.css">

<script type="text/javascript">
	$(document).ajaxStart(function(){
	    $("#wait").css("display", "block");
	});
	$(document).ajaxComplete(function(){
	    $("#wait").css("display", "none");
	});
	function showExamDetails() {
		
		var exam_id = $("#onum_id").val();
		if(exam_id != "0") {
			var contextPath=$("#contextPath").val();	
			var url=contextPath+"/getExamSectionDetails";
		 	var datam={exam_id : exam_id, flag : "EXAM_DETAILS"};
		  		$.ajax({
		   			type: "POST",
		   			url: url,
		   			data: datam,
		   
		   			success: function(response){
		   			 	 $("#exam_details_page").html(response);
		   			}             
		  		});	
		} else {
			$("#exam_details_page").html("");
		}		
	}
	
	function closeExam() {
		$("#onum_id").val("0");
		$("#exam_details_page").html("");
	}
	
	function showExamDetailsPage(i) {
		
		var contextPath=$("#contextPath").val();			   
	 	var url=contextPath+"/getExamSectionDetails";
	 	var datam={exam_id : i, flag : "STUDENT_EXAM_DETAILS"};
	  	$.ajax({
	   		type: "POST",
	   		url: url,
	   		data: datam,
	   
	   		success: function(response){
			    if(response == 'true') {
			    	
			    	var xMax = screen.width;
			    	var yMax = screen.height;
			    		
			    	
			    	var contextPath = $('#contextPath').val();
			    	contextPath = contextPath+"/showDescription1";
			    	window.location.href = contextPath;
			    	<%-- var myWindow = window.open('<%=request.getContextPath()%>/showOnlineExamTest', 'CNN_WindowName','toolbar=no, scrollbars=no, resizable=no, top=0, left=0,width='+xMax+',height='+yMax+''); --%>
			    } else {
			    	info = "Due to some technical problem exam is not available please contact with Administrator."
			    }
	   		}             
	  	});		
		
	}
</script>

</head>
<body>
<s:form theme="simple" name="enquiryDetail" action="checkExamDetailsDto" method="post" onsubmit="return pageValidation();" enctype="multipart/form-data">
<s:hidden name="randomStingJsp" id="randomStingJsp"/>

<div class="grid_10">
<div class="box round first grid">

<h2>Check Exam Details</h2>
<div class="dms_display_message" id="info"><s:property value="info"/></div>
<br/>
<br/>
<br/>
 <%
  List<StudentMappedExamDetailsDto> studentMappedExamDetailsDtoList = new ArrayList<StudentMappedExamDetailsDto>();
  studentMappedExamDetailsDtoList = (ArrayList<StudentMappedExamDetailsDto>) request.getSession().getAttribute("studentMappedExamDetailsDtoList"); 
 %>
<div align="center">
<table width="80%" border="0" cellpadding="0" cellspacing="0">
  <tr>
  <td colspan="2"><div align="center" style="font-size: 16px; font-weight: bold;">Please Select Examination Details</div></td>
  </tr>
  <tr>
  	<td width="50%"><div align="right"><label for="Unique ID"><b>Examination Name</b></label>:</div></td>
    <td width="50%">   
    <div class="styled-select2">
		<select id="onum_id" name="ostr_exam_name" tabindex="1" onChange="showExamDetails();">
			<option value="0">Select</option>
			<%if(studentMappedExamDetailsDtoList != null && studentMappedExamDetailsDtoList.size()>0) {
				for(StudentMappedExamDetailsDto dto : studentMappedExamDetailsDtoList) {
				%>
				<option value="<%=Encryption.encryptText(dto.getExamDetailsDto().getOnum_id().toString())%>"><%=dto.getExamDetailsDto().getOstr_exam_name()%></option>
				<%
				}
			}%>
		</select>
     </div>
     </td>
  </tr>  
 </table>
</div>
<br/>
<hr/>
<div id="wait" title="Wait.." style="display: none;">
  	<div align="center">
			<img alt="" src="image/wait2.gif" width="50px" height="50px"><br/>
			Please wait while we are processing your request.....
	</div>
</div>

<div  align="center">
<!-- <table width="80%">
<tr>
<td> -->
<div id="exam_details_page"></div>
<!-- </td>
</tr>
</table> -->
</div>

</div>
</div>
<input type="hidden" name="contextPath" id="contextPath" value="<%=request.getContextPath()%>">
</s:form>
 
  
</body>
</html> 