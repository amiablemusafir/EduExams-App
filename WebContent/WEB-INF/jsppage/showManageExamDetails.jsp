<!-- 
Author: Sumit Singh
Start Date: 19th March, 2014
Modify Date:
Modify By:
 -->
<%@page import="com.oes.dto.ExamDetailsDto"%>
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
<%
    String pageRequest =  (String)request.getSession().getAttribute("pageRequest");
    System.out.println("Page Request::::::::::"+pageRequest);

	ExamDetailsDto examDetailsDto = (ExamDetailsDto) request.getSession().getAttribute("examDetailsDto");	
%>
<s:form theme="simple" name="saveExamSectionDetail" action="" method="post" onsubmit="return submitData() ">
<s:hidden name="randomStingJsp" id="randomStingJsp"/>
<div class="grid_10">
	<div class="box round first grid">

    <h2>Show Exam Details</h2>
	<div class="dms_display_message" id="info"><s:property value="info"/></div>
	
	<div align="center">
	<table width="80%" border="0" cellpadding="0" cellspacing="0">
		<tr>
    	<td><label for="Unique ID">Exam Name</label>:</td>
    	<td>   
    	<input type="text" name="examDetailsDto.ostr_exam_name" class="text_field" id="ostr_exam_name" tabindex="1" readonly="readonly" value="<%=examDetailsDto.getOstr_exam_name() %>"/>
    	</td>
    	
    	<td width="10%"></td>
    	
    	<td>
	    <label for="gender">Course</label>:</td>
	    <td>   
	    <s:textfield theme="simple" name="examDetailsDto.courseDetailsDto.ostr_course_name" cssClass="text_fieldd" id="ostr_course_name" tabindex="2" readonly="true"/>
	    </td>
  	</tr>
  	<tr>
    	<td><label for="firstname">Date</label>:</td>
    	<td>
       	<s:textfield theme="simple" name="examDetailsDto.odt_exam_date" cssClass="text_field" id="odt_exam_date" tabindex="2" readonly="true"/>
    	</td>

  		<td width="10%"></td>
	    <td><label for="Email">Time </label>:</td>
	    <td>
	   
	    <s:textfield theme="simple" name="examDetailsDto.odt_exam_time" cssClass="text_fieldd" id="odt_exam_time" tabindex="6" readonly="true"/>
	    </td>
    </tr>
    <tr>
  	<td><label for="lastname">Description</label>:</td>
    <td colspan="4">
      <textarea cols="80" rows="4" name="examDetailsDto.ostr_exam_description" id="ostr_exam_description" tabindex="3" readonly="readonly" style="width: 79%"><%=examDetailsDto.getOstr_exam_description()%></textarea>
    </td>
  </tr>
</table>
</div>

<div class="clear"></div>
<hr style="width:95%; border-bottom:1px dotted  #CCCCCC;" />

		<div align="center">
		<table width="80%" cellspacing="0" cellpadding="0"  border="1" bordercolor="#B3CBD6">
	
		  <tr style="background: #eee; color: #000000;">
		  	  <td width="10%" height="30px">&nbsp;&nbsp;&nbsp; Sl No.</td>
		  	  <td width="25%">&nbsp;&nbsp;&nbsp; Section Name</td>
		  	  <td width="20%">&nbsp;&nbsp;&nbsp; No of Questions</td>
		      <td width="15%">&nbsp;&nbsp;&nbsp; Total Marks</td>
		  </tr>
		  
		  
		  <s:if test="examSectionDetailsDtoList != null">
			<s:if test="%{examSectionDetailsDtoList.isEmpty()}">
				
			</s:if>
			<s:else>
			<%
				int i = 1;
			%>
			<s:iterator value="examSectionDetailsDtoList" id="requestList">
				<tr id="itemrow1">
					<td class="itemcenter5" width="10%" class="itemcenter5" height="30px">&nbsp;&nbsp;&nbsp;<b><%=i%></b></td>
					<td class="itemcenter5" class="itemcenter5" height="30px">&nbsp;&nbsp;&nbsp;<b><s:property value="sectionDetailsDto.ostr_section_name" /></b></td>
					<td class="itemcenter5" class="itemcenter5" height="30px">&nbsp;&nbsp;&nbsp;<b><s:property value="onum_total_question" /></b></td>
					<td class="itemcenter5" class="itemcenter5" height="30px">&nbsp;&nbsp;&nbsp;<b><s:property value="onum_total_marks" /></b></td>
				</tr>
			<%
				i++;
			%>
			</s:iterator>
			</s:else>
		</s:if>
	 </table>
	 </div>
	
	<br/>
	<br/>
	<center>
	<input type="button" value="Active/Inactive" onclick="changeExamStatus('<%=request.getSession().getAttribute("sl_no")%>');" class="btn">
	&nbsp;&nbsp;
	<input type="button" value="Delete" onclick="deleteDetails('<%=request.getSession().getAttribute("sl_no")%>');" class="btn">
	</center>
	<br/>
	<br/> 
</div>
<input type="hidden" name="table_loop_size" id="table_loop_size" value="1">


<div class="clear"></div>
</div>


<input type="hidden" name="contextPath" id="contextPath" value="<%=request.getContextPath()%>">
</s:form>
</body>
</html> 