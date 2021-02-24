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
function deleteDetails(categoryId){
	
	var showBill=confirm("Are you sure you want to delete");
	if(showBill == true){
			
		 var contextPath = $('#contextPath').val();
			
		 contextPath = contextPath + "/deleteExamDetail?sl_no="+categoryId;
	
		 window.location.href = contextPath;
	}	
}


function changeExamStatus(id){
	
	var contextPath = $('#contextPath').val();
	contextPath = contextPath+"/changeExamStatus?sl_no="+id;
	window.location.href = contextPath;
}

function showDetails(id){
	
	var contextPath = $('#contextPath').val();
	contextPath = contextPath+"/showExamDetails?sl_no="+id;
	window.location.href = contextPath;
}
</script>
</head>
<body>
<s:form theme="simple" name="enquiryDetail" action="searchStudentsDetailsByCretariaDetails" method="post" onsubmit="">
<s:hidden name="randomStingJsp" id="randomStingJsp"/>

<div class="grid_10">
	<div class="box round first grid">
		<h2>New Student Request</h2>
		<div class="block">
    	
		<div class="dms_display_message"><s:property value="info"/></div>
		
		<table class="data display datatable" id="example" border="1" bordercolor="#B3CBD6">
		<thead>
			<tr>
				<th>Sl No.</th>
				<th>Exam Name</th>
				<th>Course Name</th>
				<th>Date</th>
				<th>Active/Inactive</th>
				<th>Details</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
		
		<s:if test="examDetailsDtoList != null">
			<s:if test="%{examDetailsDtoList.isEmpty()}">
				
			</s:if>
			<s:else>
			<%
				int i = 1;
			%>
			<s:iterator value="examDetailsDtoList" id="requestList">
				<tr>
					<td width="10%"><%=i%></td>
					<td width="20%">${requestList.ostr_exam_name}</td>
					<td width="25%"><s:property value="courseDetailsDto.ostr_course_name" /></td>
					<td width="10%"><s:property value="odt_exam_date" /></td>
					
					<td width="15%">
						<center>
						<s:if test="onum_exam_activation_flag == 1">
						 <input type="button" value="Inactive" onclick="changeExamStatus('${requestList.onum_id}');" class="btn btn-small">
						</s:if>
						<s:if test="onum_exam_activation_flag == 0">
						 <input type="button" value="Active" onclick="changeExamStatus('${requestList.onum_id}');" class="btn btn-small">
						</s:if>
						</center>
					</td>
					
					<td width="10%">
						<center>
						 <input type="button" value="Show Details" onclick="showDetails('${requestList.onum_id}');" class="btn btn-small">
						</center>
					</td>
					<td width="10%">
						<center>
						 <input type="button" value="Delete" onclick="deleteDetails('${requestList.onum_id}');" class="btn btn-small">
						</center>
					</td>
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
<input type="hidden" id="contextPath" value="<%=request.getContextPath() %>">
</body>
</html> 