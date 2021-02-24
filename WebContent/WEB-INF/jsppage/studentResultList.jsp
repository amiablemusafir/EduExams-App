<!-- 
Author: Sumit Singh
Start Date: 27th March, 2014
Modify Date:
Modify By:
Motive: Student Result List
 -->
<%@page import="com.sms.admin.dto.AdminDetailDto"%>
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
		
		function viewResultDetails(id) {			
			$("#student_id").val(id);
			document.getElementById("showStudentResultDetailsPage").submit();
		}
</script>

<body>
<%
AdminDetailDto adminDetailDto = new AdminDetailDto();
adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto"); %>
<div class="grid_10">
	<div class="box round first grid">
    <h2>Result Details</h2>

	<br/>
	${info}

	<s:form action="showStudentResultDetailsPage" name="showStudentResultDetailsPage" id="showStudentResultDetailsPage" method="post">
	<s:hidden name="randomStingJsp" id="randomStingJsp"/>
	
	<s:hidden name="student_id" id="student_id"/>
	
	</s:form>
	<div>
	<table class="data display datatable" id="example" border="1" bordercolor="#B3CBD6">
		<thead>
			<tr>
				
				<%if(adminDetailDto != null ) {
					if(adminDetailDto.getInum_role_id().equals(3) || adminDetailDto.getInum_role_id().equals(2)) {
						%>
						<th>Sl No.</th>
						<th>Course</th>
						<th>Exam Name</th>
						<th>Date</th>
						<th>Time</th>
						<th>Details</th>
						<%
					} else {
						%>
						<th width="10%">Sl No.</th>
						<th width="10%">Regd Id</th>
						<th width="20%">Name</th>
						<th width="10%">Course</th>
						<th width="20%">Exam Name</th>
						<th width="10%">Date</th>
						<th width="10%">Time</th>
						<th width="10%">Details</th>
						<%
					}
				}%>
				
			</tr>
		</thead>
		<tbody>
		<%if(adminDetailDto != null ) {
					if(adminDetailDto.getInum_role_id().equals(3) || adminDetailDto.getInum_role_id().equals(2)) {
						%>
						<s:if test="resultDetailsDtoList != null">
		
						<s:if test="%{resultDetailsDtoList.isEmpty()}">
							
						</s:if>
						<s:else>
						<%
							int i = 1;
						%>
						<s:iterator value="resultDetailsDtoList" id="requestList">
							<tr class="odd">
								<td><%=i%></td>
								<td><s:property value="examDetailsDto.courseDetailsDto.ostr_course_name" /></td>
								<td>${requestList.examDetailsDto.ostr_exam_name}</td>
								<td><s:property value="ostr_date" /></td>
								<td><s:property value="ostr_time" /></td>
								<td><input type="button" name="Review" value="Review" onclick="viewResultDetails('${requestList.onum_result_details_id}');" class="btn btn-small"/></td>
							</tr>
						<%
							i++;
						%>
						</s:iterator>
						</s:else>
					</s:if>
						<%
					} else {
						%>
						<s:if test="resultDetailsDtoList != null">
		
						<s:if test="%{resultDetailsDtoList.isEmpty()}">
							
						</s:if>
						<s:else>
						<%
							int i = 1;
						%>
						<s:iterator value="resultDetailsDtoList" id="requestList">
							<tr class="odd">
								<td><%=i%></td>
								<td><s:property value="studentDetailsDto.istr_unique_id" /></td>
								<td><s:property value="studentDetailsDto.istr_first_name"/>&nbsp;<s:property value="studentDetailsDto.istr_last_name"/></td>
								<td><s:property value="examDetailsDto.courseDetailsDto.ostr_course_name" /></td>
								<td>${requestList.examDetailsDto.ostr_exam_name}</td>
								<td><s:property value="ostr_date" /></td>
								<td><s:property value="ostr_time" /></td>
								<td><input type="button" name="Review" value="Review" onclick="viewResultDetails('${requestList.onum_result_details_id}');" class="btn btn-small"/></td>
							</tr>
						<%
							i++;
						%>
						</s:iterator>
						</s:else>
					</s:if>
					<%
					}
		}%>
		
	</tbody>
	</table>
	
	</div>
	</div>
</div>
<input type="hidden" id="contextPath" value="<%=request.getContextPath() %>" >

</body>