<!-- 
Author: Sumit Singh
Start Date: 27th March, 2014
Modify Date:
Modify By:
Motive: Admission Details
 -->
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
<title>IPO Online Exam</title>
<link rel='shortcut icon' type='image/x-icon' href='image/favicon.ico' />

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="css/sunny/jquery-ui-1.10.4.custom.css" rel="stylesheet">
<script src="js_sunny/jquery-1.10.2.js"></script>
<script src="js_sunny/jquery-ui-1.10.4.custom.js"></script>


<script type="text/javascript">
$(document).ready(function(){

	$( "#idt_dob" ).datepicker({
		changeMonth: true,
		changeYear: true,
		dateFormat: 'dd-MM-yy'
	});
	
	// Paginate table rows
	$('table tbody').paginate({
		status: $('#status'),
		controls: $('#paginate'),
		itemsPerPage: 5
	});	
});

function printPage() {
	var divToPrint = document.getElementById('page-wrap');
	var popupWin = window.open('', '_blank', 'width=900,height=600');
	popupWin.document.open();
	popupWin.document.write('<html><link href="style/report.css" rel="stylesheet" type="text/css" /><body onload="window.print()">' + divToPrint.innerHTML + '</html>');
	popupWin.document.close();
}

</script>
<link rel="stylesheet" href="style/report.css">
</head>

<body>
<div id="home_button" style="margin-top: 20px; margin-bottom: -55px; margin-right: 50px;" align="right"><a href="<%=request.getContextPath()%>/homepage"><img src="image/home.jpg"></a> <a href="#" onclick="printPage();"><img src="image/print.jpg"></a></div>
<s:form theme="simple" name="" action="searchEmployeeDetailsByCretariaReport" method="post">

<div id="page-wrap">
	<table>
	<tr>
	<td colspan="4">
	<div id="page-wrap">
		<h3 align="center">NARAYAN ONLINE INSTITUTE OF COMPETITION (NOIC)</h3>
		<h4 align="center">www.ipoonlineexam.in, www.ipoonlineexam.com</h4>
		<h3 align="center">Employee Report Details</h3>
		
		<br/>
		<h3 align="center"><div class="oes_display_message" id="info"><s:property value="info" /></div></h3>
	</div>
	</td>
	<td colspan="3">
					<table style="width: 100%;">
					<tr>
					<th colspan="4"><div align="center">Employee Details</div></th>
					</tr>
					<tr>
						<td width="20%">Unique ID :</td>
						<td width="20%">
							<s:textfield theme="simple" name="unique_id" cssClass="text_field" id="unique_id" tabindex="2" cssStyle="height: 30px; width: 120px;"/>
						</td>
						
						<td width="20%">DOB :</td>
						<td width="20%">
						 	<s:textfield theme="simple" name="dob" cssClass="text_field" id="idt_dob" tabindex="4" cssStyle="height: 30px; width: 120px;" readonly="true"/>
						</td>					   							   
					</tr>
					
					
					<tr>
						<td>First Name :</td>
					    <td>  
					    	<s:textfield theme="simple" name="first_name" cssClass="text_field" id="first_name" tabindex="2"  cssStyle="height: 30px; width: 120px;"/>
						</td>	
						<td>Last Name :</td>
						<td>
							<s:textfield theme="simple" name="last_name" cssClass="text_field" id="last_name" tabindex="2"  cssStyle="height: 30px; width: 120px;"/>
						</td>
					</tr>
					
					<tr>
				    <td colspan="4">
				    <div id="button_submit" align="center">
				    <input type="submit" value="Search" name="submit" tabindex="8"  class="myButton"/>
				    <input type="reset" name="reset" value="Reset" tabindex="9" class="myButton"/>
				    </div>
				    </td>
					</table>
						
				
			</td>
			</tr>
			<tr>
				<th class="coll_align" width="5%">Sl No.</th>
				<th class="coll_align" width="10%">Employee Id</th>
				<th class="coll_align" width="20%">Employee Name</th>
				<th class="coll_align" width="15%">DOB</th>
				<th class="coll_align" width="15%">Gender</th>
				<th class="coll_align" width="15%">Phone No</th>
				<th class="coll_align" width="20%">Email Id</th>
			</tr>
		
		<s:if test="employeeDetailsDtoList != null">

			<s:if test="%{employeeDetailsDtoList.isEmpty()}">
				<td colspan="12"><p align="center">Record Not Found</p></td>
			</s:if>
			<s:else>
			<%
				int i = 1;
			%>
			<s:iterator value="employeeDetailsDtoList" id="requestList">
				<tr>
					<td><%=i%></td>
					<td><s:property value="istr_unique_id" /></td>
					<td><s:property value="istr_first_name" />&nbsp;<s:property value="istr_last_name" /></td>
					<td><s:property value="istr_date_of_birth" /></td>					
					<td><s:property value="istr_gender" /></td>
					<td><s:property value="inum_mobile_number" /></td>
					<td><s:property value="istr_email" /></td>
					
				</tr>
			<%
				i++;
			%>
			</s:iterator>
			</s:else>
		</s:if>
	</table>
</div>





<input type="hidden" id="contextPath" value="<%= request.getContextPath() %>">	
</s:form>
</body>
</html>
