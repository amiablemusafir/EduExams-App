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
			
		 contextPath = contextPath + "/deleteExamRequestDetail?sl_no="+categoryId;
	
		 window.location.href = contextPath;
	}	
}


function showRequestDetails(id){
	
	var contextPath = $('#contextPath').val();
	contextPath = contextPath+"/showManageExamRequestDetails?sl_no="+id;
	window.location.href = contextPath;
}

function showAllRequest(){
	
	var contextPath = $('#contextPath').val();
	contextPath = contextPath+"/showManageExamRequestDetailsPage";
	window.location.href = contextPath;
}

function showPendingRequest(){
	
	var contextPath = $('#contextPath').val();
	contextPath = contextPath+"/showManageExamPendingRequest";
	window.location.href = contextPath;
}

function showApprovedRequest(){
	
	var contextPath = $('#contextPath').val();
	contextPath = contextPath+"/showManageExamApprovedRequest";
	window.location.href = contextPath;
}

function showRejectRequest(){
	
	var contextPath = $('#contextPath').val();
	contextPath = contextPath+"/showManageExamRejectRequest";
	window.location.href = contextPath;
}
</script>
</head>
<body>
<s:form theme="simple" name="enquiryDetail" action="searchStudentsDetailsByCretariaDetails" method="post" onsubmit="">
<s:hidden name="randomStingJsp" id="randomStingJsp"/>


<div class="grid_10">
	<div class="box round first grid">

    <h2>Exam Request Details</h2>
	<div class="dms_display_message"><s:property value="info"/></div>

	<table width="100%">
	<tr>
	<td width="50%"></td>
	<td><input type="button" value="All Request" onclick="showAllRequest();" class="btn btn-navy"></td>
	<td><input type="button" value="Pending Request" onclick="showPendingRequest();" class="btn btn-navy"></td>
	<td><input type="button" value="Approved Request" onclick="showApprovedRequest();" class="btn btn-navy"></td>
	<td><input type="button" value="Reject Request" onclick="showRejectRequest();" class="btn btn-navy"></td>
	</tr>
	</table>
	
	<div class="block">
	<table class="data display datatable" id="example" border="1" bordercolor="#B3CBD6"><thead>
			<tr>
				<th class="coll_align" colspan="6"><div class="dms_display_message"><s:property value="header_info"/></div></th>
			</tr>
			<tr>
				<th>Sl No.</th>
				<th>Unique Id</th>
				<th>Request Date</th>
				<th>Exam Name</th>
				<th>View</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
		
		<s:if test="examRequestDetailsDtoList != null">
			<s:if test="%{examRequestDetailsDtoList.isEmpty()}">
				
			</s:if>
			<s:else>
			<%
				int i = 1;
			%>
			<s:iterator value="examRequestDetailsDtoList" id="requestList">
				<tr>
					<td width="10%"><%=i%></td>
					<td><s:property value="studentDetailsDto.istr_unique_id" /></td>
					<td><s:property value="odt_request_date" /></td>
					<td>${requestList.examDetailsDto.ostr_exam_name}</td>
					<td width="10%">
						<center>
						 <input type="button" value="Show Details" onclick="showRequestDetails('${requestList.onum_id}');" class="btn btn-small">
						</center>
					</td>
					<td class="itemcenter5" width="10%">
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