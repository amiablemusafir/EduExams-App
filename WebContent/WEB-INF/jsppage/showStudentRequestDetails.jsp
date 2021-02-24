<!-- 
Author: Sumit Singh
Start Date: 27th March, 2014
Modify Date:
Modify By:
Motive: Admission Details
 -->
<%@page import="com.thoughtworks.xstream.core.util.Base64Encoder" %>
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
function deleteCategory(categoryId){
	
	var showBill=confirm("Are you sure you want to delete");
	
	if(showBill == true){
			
		 var contextPath = $('#contextPath').val();
			
		 contextPath = contextPath + "/studentDeleteExamRequestDetail?slno="+categoryId;
	
		 window.location.href = contextPath;
	}
	
}

function newUserRegistrationValidation() {
		
	$("#exam_name_error").html("");
	$("#remark_error").html("");
	
	var onum_id = document.getElementById('onum_id').value;
	if (onum_id == '0') {
		$("#exam_name_error").html("Please Select Exam Name");
		document.getElementById('onum_id').focus();

		return false;
	}

	var content = document.getElementById('ostr_user_remark').value;
	if (content == '') {
		$("#remark_error").html("Please Enter Remark");
		document.getElementById('ostr_user_remark').focus();

		return false;
	}
		
	return true;

}
</script>
</head>
<body>
<div class="grid_10">
	<div class="box round first grid">

    <h2>Request For Examination</h2>
	<br/>
	
	<div align="center">
	<s:form autocomplete="off" action="saveExamRequestDetails" name="examRequestDetails" method="post" onsubmit="return(newUserRegistrationValidation())">
	<s:hidden name="randomStingJsp" id="randomStingJsp"/>
	
	<div class="dms_display_message" id="info"><s:property value="info" /></div>
	
		<table width="70%" border="0" cellspacing="0" cellpadding="0">
								<tr>	
									<td width="10%" height="10px;">&nbsp;</td>
									<td class="label">&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
								<tr>	
									<td width="10%"></td>
									<td class="label"><b>Exam Name : </b><font color="red">*</font><s:hidden name="examRequestDetailsDto.onum_id" /></td>
									<td>
									 <div class="styled-select2">
									    <select id="onum_id" name="examRequestDetailsDto.examDetailsDto.onum_id" tabindex="1" onChange="showExamDetails();">
											<option value="0">Select</option>
											<s:if test="examDetailsDtoList != null">
												<s:if test="%{examDetailsDtoList.isEmpty()}"></s:if>
											<s:else>
												<s:iterator value="examDetailsDtoList" id="requestList">
													<option value="${requestList.onum_id}">${requestList.ostr_exam_name}</option>
												</s:iterator>
											</s:else>
											</s:if>
										</select>
									 </div>									
									</td>
								</tr>
								<tr>
									<td width="10%"></td>
									<td></td>
									<td><div id="exam_name_error" class="message1"></div></td>
								</tr>
								<tr>	
									<td width="10%"></td>
									<td class="label"><b>Remark : </b><font color="red">*</font></td>
									<td><s:textarea cols="20" rows="6" theme="simple" name="examRequestDetailsDto.ostr_user_remark" id="ostr_user_remark" /></td>
								</tr>
								
								<tr>
									<td width="10%"></td>
									<td></td>
									<td><div id="remark_error" class="message1"></div></td>
								</tr>
								</table>
								
								
								<div class="clear"></div>
								<hr style="width:95%; border-bottom:1px dotted  #CCCCCC;" />
								<table width="100%">
								<tr>
									<td>
									<center>
										<input type="submit" value="Submit" style="width: 100px; height: 30px;" class="btn"/>&nbsp;&nbsp;&nbsp;
										<input type="reset" value="Reset" style="width: 100px; height: 30px;" class="btn"/>
									</center>
									</td>
								</tr>
								</table>
										
			
			</s:form>
			</div>
	</div>
	</div>

<div class="grid_10">
	<div class="box round first grid">
		 <div class="block">
			<table class="data display datatable" id="example" border="1" bordercolor="#B3CBD6">		
			<thead>
			<tr>
				<th width="10%">Sl No.</th>
				<th width="20%">Exam Name</th>
				<th width="10%">Date</th>
				<th width="10%">Status</th>
				<th width="40%">Admin Remark</th>
				<th width="10%">Delete</th>
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
				<tr class="odd">
					<td><%=i%></td>

					<td>${requestList.examDetailsDto.ostr_exam_name}</td>
					
					<td><s:property value="odt_request_date" /></td>
					
					<td></td>
					
					<td><s:property value="ostr_admin_remark" /></td>
					<td><input type="button" name="delete" value="Delete" onclick="deleteCategory('${requestList.onum_id}');" class="btn btn-small"/></td>
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

<input type="hidden" id="contextPath" value="<%=request.getContextPath() %>" >
</body>
</html>   
