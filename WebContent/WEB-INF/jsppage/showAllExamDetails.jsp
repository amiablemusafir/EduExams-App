<!-- 
Author: Sumit Singh
Start Date: 19th March, 2014
Modify Date:
Modify By:
 -->
<%@page import="com.oes.action.Encryption"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.oes.dto.StudentMappedExamDetailsDto"%>
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

function showExamDetails(i) {
	
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

<s:form theme="simple" name="enquiryDetail" action="searchStudentsDetailsByCretariaDetails" method="post" onsubmit="">
<s:hidden name="randomStingJsp" id="randomStingJsp"/>

<div class="grid_10">
	<div class="box round first grid">
		<h2>All Exam Details</h2>

	  <%
	    List<StudentMappedExamDetailsDto> studentMappedExamDetailsDtoList = new ArrayList<StudentMappedExamDetailsDto>();
	    studentMappedExamDetailsDtoList = (ArrayList<StudentMappedExamDetailsDto>) request.getSession().getAttribute("studentMappedExamDetailsDtoList"); 
	  %>
		<div class="dms_display_message"><s:property value="info"/></div>
	
		<div class="block">
    	<table class="data display datatable" id="example" border="1" bordercolor="#B3CBD6"><thead>
			<tr>
				<th width="10%" height="30px;">Sl No.</th>
				<th>Course Name</th>
				<th>Exam Name</th>
				<th>Date</th>
				<th></th>
				
			</tr>
		</thead>
		<tbody>
		<%if(studentMappedExamDetailsDtoList != null && studentMappedExamDetailsDtoList.size()>0) {
			int i = 1;
			for(StudentMappedExamDetailsDto dto : studentMappedExamDetailsDtoList) {
			%>
			<tr>
				<td width="5%" height="35px;"><%=i%></td>
				<td><b><%=dto.getExamDetailsDto().getCourseDetailsDto().getOstr_course_name() %></b></td>
				<td><b><%=dto.getExamDetailsDto().getOstr_exam_name() %></b></td>
				<td><b><%=dto.getExamDetailsDto().getOdt_exam_date()%></b></td>
				<td>
				<center>
					<input type="button" value="Start Exam" onclick="showExamDetails('<%=Encryption.encryptText(dto.getExamDetailsDto().getOnum_id().toString()) %>');" style="width: 100px; height: 30px;" class="btn"/>
				</center>
				</td>
				</tr>				
			<%
			i++;
			}
		}%>
	</tbody>
	</table>

	</div>
	</div>
	</div>
</s:form>
<input type="hidden" id="contextPath" value="<%=request.getContextPath() %>">
</body>
</html> 