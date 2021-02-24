<!-- 
Author: Sumit Singh
Start Date: 19th March, 2014
Modify Date:
Modify By:
 -->
<%@page import="com.oes.dto.ExamRequestDetailsDto"%>
<%@page import="com.oes.dto.ExamDetailsDto"%>
<%@page import="com.oes.action.common.Enums"%>
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
	function submitData() {
		
		$("#info").html("");
		var istr_remark=$("#istr_remark").val();
		if(istr_remark == "")
		{
			$("#info").html("Please enter Your Remark");
			$("#istr_remark").focus();
			return false;
		}
		return true;	
	}
	
	function changeStatus(i) {
		
		$("#info").html("");
		var istr_remark=$("#istr_remark").val();
		if(istr_remark == "")
		{
			$("#info").html("Please enter Your Remark");
			$("#istr_remark").focus();
			return false;
		}
		
		var contextPath = $('#contextPath').val();
		contextPath = contextPath+"/manageExamRequestStatus?status="+i+"&istr_remark="+istr_remark;
		window.location.href = contextPath;
		
	}
</script>
</head>
<body>
<%
ExamRequestDetailsDto examRequestDetailsDto = new ExamRequestDetailsDto();
examRequestDetailsDto = (ExamRequestDetailsDto) request.getSession().getAttribute("examRequestDetailsDto");
%>
<s:form theme="simple" name="saveExamSectionDetail" action="saveManageExamDetailsPageAdmin" method="post" onsubmit="return submitData()">
<s:hidden name="randomStingJsp" id="randomStingJsp"/>

<div class="grid_10">
	<div class="box round first grid">

<h2>Request Details</h2>
<br/>
<div align="center">
<table width="80%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><label for="Unique ID">Unique Id </label>:</td>
    <td><s:textfield theme="simple" name="examRequestDetailsDto.studentDetailsDto.istr_unique_id" cssClass="text_field" readonly="true"/>
    <s:hidden name="examRequestDetailsDto.onum_id"></s:hidden>
    </td>
    
    <td width="10%"></td>
    
    <td><label for="firstname">First Name </label>:</td>
	<td><s:textfield theme="simple" name="examRequestDetailsDto.studentDetailsDto.istr_first_name" cssClass="text_field" readonly="true"/></td>
    
  </tr>
  <tr>
    <td><label for="firstname">Last Name </label>:</td>
    <td><s:textfield theme="simple" name="examRequestDetailsDto.studentDetailsDto.istr_last_name" cssClass="text_field" id="odt_exam_date" readonly="true"/></td>
 
 	<td width="10%"></td>
 
    <td><label for="firstname">Date of Birth </label>:</td>
    <td><s:textfield theme="simple" name="examRequestDetailsDto.studentDetailsDto.istr_date_of_birth" cssClass="text_field" readonly="true"/></td>
  </tr>
  <tr>
    <td><label for="firstname">Phone No </label>:</td>
    <td><s:textfield theme="simple" name="examRequestDetailsDto.studentDetailsDto.inum_mobile_number" cssClass="text_field" readonly="true"/></td>
 
 	<td width="10%"></td>
 
    <td><label for="firstname">Email Id </label>:</td>
    <td><s:textfield theme="simple" name="examRequestDetailsDto.studentDetailsDto.istr_email" cssClass="text_field" readonly="true"/></td>
  </tr>
  <tr>
    <td><label for="firstname">Address </label>:</td>
    <td><s:textfield theme="simple" name="examRequestDetailsDto.studentDetailsDto.istr_district_name" cssClass="text_field" readonly="true"/></td>
 	<td></td>
 	<td></td>
 	<td></td>
  </tr>  
 </table> 
</div>
</div>

</div>

<div class="grid_10">
<div class="box round first grid">

<div class="dms_display_message" id="info"><s:property value="info"/></div>

<div align="center">
<table width="80%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><label for="Unique ID">Exam Name </label>:</td>
    <td><input type="text" name="examRequestDetailsDto.examDetailsDto.ostr_exam_name" class="text_field" readonly="readonly" value="<%=examRequestDetailsDto.getExamDetailsDto().getOstr_exam_name()%>"/></td>
  
 	<td width="10%"></td>
 	
 	<td><label for="firstname">No of Time Attempt </label>:</td>
	<td><s:textfield theme="simple" name="studentExamDetailsDto.onum_no_of_time_attempt" cssClass="text_field" id="onum_no_of_time_attempt" readonly="true"/></td>
  </tr>
  <tr>
    <td><label for="firstname">User Remark </label>:</td>
    <td><s:textarea theme="simple" cols="20" rows="4" name="examRequestDetailsDto.ostr_user_remark" readonly="true"/></td>
 
	<td width="10%"></td>
	
	<td><label for="firstname">Your Remark </label>:</td>
        <td>
        <s:if test="examRequestDetailsDto.onum_status == 1">
			<textarea theme="simple" cols="20" rows="4" name="istr_remark" id="istr_remark" tabindex="1"/></textarea>
		</s:if>
		<s:if test="examRequestDetailsDto.onum_status == 3">
			<s:textarea theme="simple" cols="20" rows="4" name="examRequestDetailsDto.ostr_admin_remark" id="istr_remark" readonly="true" tabindex="1"/>
		</s:if>
		<s:if test="examRequestDetailsDto.onum_status == 2">
			<s:textarea theme="simple" cols="20" rows="4" name="examRequestDetailsDto.ostr_admin_remark" id="istr_remark" readonly="true" tabindex="1"/>
		</s:if>
    </td>
	
	 
  </tr>
 
 </table> 
</div>

<div class="dms_display_message" id="info">Status : 
<s:if test="examRequestDetailsDto.onum_status == 1">
Pending
</s:if>
<s:if test="examRequestDetailsDto.onum_status == 3">
Approved
</s:if>
<s:if test="examRequestDetailsDto.onum_status == 2">
Rejected
</s:if>
</div>

<s:if test="examRequestDetailsDto.onum_status == 1">

<div class="dms_request_button"><table width="98%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    
    <td width="100%">
    <div align="center">    
    <input type="button" value="Approved" name="approved" tabindex="2" onclick="changeStatus(1);" style="width:90px;" class="btn">
    &nbsp;&nbsp;
    <input type="button" name="reject" value="Reject" tabindex="3" onclick="changeStatus(2);" style="width:90px;" class="btn">
    &nbsp;&nbsp;
    <input type="button" value="Cancel" name="Cancel" tabindex="4" style="width:90px;" class="btn">
    </div>
    </td>
  </tr>
</table>
</div>
<!--  Button End  -->
</s:if>
</div>
</div>

<input type="hidden" name="contextPath" id="contextPath" value="<%=request.getContextPath()%>">
</s:form>
</body>
</html> 