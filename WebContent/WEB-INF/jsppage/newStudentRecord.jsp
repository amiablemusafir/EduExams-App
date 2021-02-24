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
function approveStudentStatus(id){
	
	var contextPath = $('#contextPath').val();
	contextPath = contextPath+"/approveStudentStatus?sl_no="+id;
	window.location.href = contextPath;
}

function rejectStudentStatus(id){
	
	var contextPath = $('#contextPath').val();
	contextPath = contextPath+"/rejectStudentStatus?sl_no="+id;
	window.location.href = contextPath;
}
</script>
</head>
<body>
<%
   String pageRequest =  (String)request.getSession().getAttribute("pageRequest");
   System.out.println("Page Request::::::::::"+pageRequest);
%>
<div class="grid_10">
<div class="box round first grid">

<h2>New Student Request</h2>

<s:form theme="simple" name="enquiryDetail" action="searchStudentsDetailsByCretariaDetails" method="post" onsubmit="">
<s:hidden name="randomStingJsp" id="randomStingJsp"/>

	<div class="dms_display_message"><s:property value="info"/></div>
	<table width="100%" border="1" bordercolor="#B3CBD6" cellspacing="0" cellpadding="0" id="requestList">
	
		<thead>
			<tr height="35px" style="background: #eee; color: #000000;">
				<th>Sl No.</th>
				<th>Unique Id</th>
				<th>Student Name</th>
				<th>Gender</th>
				<th>Phone No</th>
				<th>Email Id</th>
				<th width="10%">Approve</th>
				<th width="10%">Reject</th>
			</tr>
		</thead>
		<tbody>
		
		<s:if test="studentDetailsDtoList != null">
			<s:if test="%{studentDetailsDtoList.isEmpty()}">
				<tr class="odd">
						<td height="30px" colspan="8"><CENTER><b>No Request Found</b></CENTER></td>
				</tr>
			</s:if>
			<s:else>
			<%
				int i = 1;
			%>
			<s:iterator value="studentDetailsDtoList" id="requestList">
				<tr class="odd">
					<td width="5%" height="40px"><b><%=i%></b></td>
					<td><b><s:property value="istr_unique_id"/></b></td>
					<td><b><s:property value="istr_first_name"/>&nbsp;<s:property value="istr_last_name"/></b></td>
					<td><b><s:property value="istr_gender"/></b></td>
					<td><b><s:property value="inum_mobile_number"/></b></td>
					<td><b><s:property value="istr_email"/></b></td>
					
					<td width="5%">
						<center>
						 <input type="button" value="Approve" class="btn" onclick="approveStudentStatus('${requestList.inum_student_id}');">
						</center>
					</td>
					<td width="5%">
						<center>
						 <input type="button" value="Reject" class="btn" onclick="rejectStudentStatus('${requestList.inum_student_id}');">
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

</s:form>
</div>
</div>

<input type="hidden" id="contextPath" value="<%=request.getContextPath() %>">
</body>
</html> 