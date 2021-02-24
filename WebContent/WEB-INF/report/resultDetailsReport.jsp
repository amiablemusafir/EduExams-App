<!-- 
Author: Sumit Singh
Start Date: 27th March, 2014
Modify Date:
Modify By:
Motive: Admission Details
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
<title>Xamdesk | Result</title>
<link rel='shortcut icon' type='image/x-icon' href='image/favicon.ico' />

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="css/sunny/jquery-ui-1.10.4.custom.css" rel="stylesheet">
<script src="js_sunny/jquery-1.10.2.js"></script>
<script src="js_sunny/jquery-ui-1.10.4.custom.js"></script>


<script type="text/javascript">
$(document).ready(function(){
	$( "#idt_from_date" ).datepicker({
	    changeMonth: true,
		changeYear: true,
		maxDate: '0',
		dateFormat: 'dd-mm-yy',
		onClose: function( selectedDate ) {
	    	$( "#idt_to_date" ).datepicker( "option", "minDate", selectedDate );
	    }
	});
	   
	$( "#idt_to_date" ).datepicker({
		changeMonth: true,
		changeYear: true,
		maxDate: '0',
		dateFormat: 'dd-mm-yy',
		onClose: function( selectedDate ) {
	   		$("#idt_from_date" ).datepicker( "option", "maxDate", selectedDate );
	    }
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
	popupWin.document.write('<html><body onload="window.print()">' + divToPrint.innerHTML + '</html>');
	popupWin.document.close();
}

</script>
<style type="text/css">
		.myButton {
			-moz-box-shadow:inset 0px 1px 0px 0px #cf866c;
			-webkit-box-shadow:inset 0px 1px 0px 0px #cf866c;
			box-shadow:inset 0px 1px 0px 0px #cf866c;
			background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #d0451b), color-stop(1, #bc3315));
			background:-moz-linear-gradient(top, #d0451b 5%, #bc3315 100%);
			background:-webkit-linear-gradient(top, #d0451b 5%, #bc3315 100%);
			background:-o-linear-gradient(top, #d0451b 5%, #bc3315 100%);
			background:-ms-linear-gradient(top, #d0451b 5%, #bc3315 100%);
			background:linear-gradient(to bottom, #d0451b 5%, #bc3315 100%);
			filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#d0451b', endColorstr='#bc3315',GradientType=0);
			background-color:#d0451b;
			-moz-border-radius:3px;
			-webkit-border-radius:3px;
			border-radius:3px;
			border:1px solid #942911;
			display:inline-block;
			cursor:pointer;
			color:#ffffff;
			font-family:Arial;
			font-size:13px;
			padding:6px 24px;
			text-decoration:none;
			text-shadow:0px 1px 0px #854629;
		}
		.myButton:hover {
			background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #bc3315), color-stop(1, #d0451b));
			background:-moz-linear-gradient(top, #bc3315 5%, #d0451b 100%);
			background:-webkit-linear-gradient(top, #bc3315 5%, #d0451b 100%);
			background:-o-linear-gradient(top, #bc3315 5%, #d0451b 100%);
			background:-ms-linear-gradient(top, #bc3315 5%, #d0451b 100%);
			background:linear-gradient(to bottom, #bc3315 5%, #d0451b 100%);
			filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#bc3315', endColorstr='#d0451b',GradientType=0);
			background-color:#bc3315;
		}
		.myButton:active {
			position:relative;
			top:1px;
		}		
		.myBu {
			font-size: 14px;
			cursor:pointer;
			text-shadow:0px 1px 0px #854629;
			text-align: center;
			padding-top: 5px;
		    display: inline-block;
		    margin-left: 3px;
		    margin-top: 5px;
		    height: 18px;
		    width:25px;
		    border-radius: 25%;
		    background-color: #1ab4f0;
		    border:1px solid #ffffff;	   
		}
</style>

<link rel="stylesheet" href="style/report.css">
</head>

<body>
<%
AdminDetailDto adminDetailDto = new AdminDetailDto();
adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
%>
<div id="home_button" align="right"><a href="<%=request.getContextPath()%>/homepage"><img src="image/home.jpg"></a> <a href="#" onclick="printPage();"><img src="image/print.jpg"></a></div>
<s:form theme="simple" name="" action="searchStudentsDetailsReportByCretariaReport" method="post">

<div>
	<table width="100%">
	<tr>
	<td colspan="5">
	<div>
	<%if(adminDetailDto != null) {%>
		<h2 align="center"><%=adminDetailDto.getInstituteDetailsDto().getOstr_institute_name()%></h2>
		<h4 align="center"><%=adminDetailDto.getInstituteDetailsDto().getOstr_address1()%></h4>
		<h4 align="center"><%=adminDetailDto.getInstituteDetailsDto().getOstr_address2()%>, <%=adminDetailDto.getInstituteDetailsDto().getOstr_phone_no()%></h4>
		
		<h3 align="center">Result Report</h3>
		
		
		<h3 align="center"><div class="oes_display_message" id="info"><s:property value="info" /></div></h3>
	<%}%>
	</div>
	</td>
	<td colspan="7">
					<table style="width: 100%;">
					<tr>
					<th colspan="4"><div align="center">Student Result Details</div></th>
					</tr>
					<tr>
						<td width="20%">From Date :</td>
						<td width="20%">
						<s:textfield theme="simple" name="idt_from_date" cssClass="text_field" id="idt_from_date" tabindex="2" cssStyle="height: 30px; width: 120px;" readonly="true"/>
						</td>
						
						<td width="20%">To Date :</td>
						<td width="20%">
						<s:textfield theme="simple" name="idt_to_date" cssClass="text_field" id="idt_to_date" tabindex="2" cssStyle="height: 30px; width: 120px;" readonly="true"/>
						</td>					   							   
					</tr>
					
					
					<tr>
						<td>Exam Name :</td>
					    <td>  
					    
					    <select id="onum_id" name="onum_id" tabindex="1" onChange="showExamDetails();" style="height: 30px; width: 120px;">
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
					    </td>	
						<td>Unique Id :</td>
						<td>
						<s:textfield theme="simple" name="istr_unique_id" cssClass="text_field" id="istr_unique_id" tabindex="2"  cssStyle="height: 30px; width: 120px;"/>
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

			<tr style="font-size: 16px;">
				<th width="5%">Sl No.</th>
				<th width="10%">Unique Id</th>
				<th width="20%">Name</th>
				<th width="10%">Mobile No</th>
				<th width="5%">Gender</th>
				<th width="15%">Exam Name</th>
				<th width="10%">Date</th>
				<th width="5%">Right</th>
				<th width="5%">Wrong</th>
				<th width="5%">Left</th>
				<th width="5%">Marks</th>
				<th width="5%">Rank</th>
			</tr>
		
		
		<s:if test="resultDetailsDtoList != null">

			<s:if test="%{resultDetailsDtoList.isEmpty()}">
				<td colspan="12"><p align="center">Record Not Found</p></td>
			</s:if>
			<s:else>
			<%
				int i = 1;
			%>
			<s:iterator value="resultDetailsDtoList" id="requestList">
				<tr style="font-size: 14px;">
					<td><%=i%></td>

					<td><s:property value="studentDetailsDto.istr_unique_id" /></td>

					<td><s:property value="studentDetailsDto.istr_first_name" />&nbsp;<s:property value="studentDetailsDto.istr_last_name" /></td>
					
					<td><s:property value="studentDetailsDto.inum_mobile_number" /></td>
					
					<td><s:property value="studentDetailsDto.istr_gender" /></td>
					
					<td>${examDetailsDto.ostr_exam_name}</td>
					
					<td><s:property value="ostr_date" /></td>
					
					<td><s:property value="onum_wright" /></td>
					
					<td><s:property value="onum_wrong" /></td>
					
					<td><s:property value="onum_left" /></td>
										
					<td><s:property value="odec_total_mark" /></td>
					
					<td><s:property value="onum_rank" /></td>
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
<div style="display: none;">
<div id="page-wrap">
	<div align="center">
	<%if(adminDetailDto != null) {%>
		<h2 align="center"><%=adminDetailDto.getInstituteDetailsDto().getOstr_institute_name()%></h2>
	<%}%>
	</div>
	<table width="100%" border="1">
			<tr style="font-size: 11px;">
				<th>Sl No.</th>
				<th>Unique Id</th>
				<th>Name</th>
				<th>Mobile No</th>
				<th>Gender</th>
				<th>Exam Name</th>
				<th>Date</th>
				<th>Right</th>
				<th>Wrong</th>
				<th>Left</th>
				<th>Marks</th>
				<th>Rank</th>
			</tr>
		
		
		<s:if test="resultDetailsDtoList != null">

			<s:if test="%{resultDetailsDtoList.isEmpty()}">
				<td colspan="12"><p align="center">Record Not Found</p></td>
			</s:if>
			<s:else>
			<%
				int i = 1;
			%>
			<s:iterator value="resultDetailsDtoList" id="requestList">
				<tr style="font-size: 9px;">
					<td><%=i%></td>

					<td><s:property value="studentDetailsDto.istr_unique_id" /></td>

					<td><s:property value="studentDetailsDto.istr_first_name" />&nbsp;<s:property value="studentDetailsDto.istr_last_name" /></td>
					
					<td><s:property value="studentDetailsDto.inum_mobile_number" /></td>
					
					<td><s:property value="studentDetailsDto.istr_gender" /></td>
					
					<td>${examDetailsDto.ostr_exam_name}</td>
					
					<td><s:property value="ostr_date" /></td>
					
					<td><s:property value="onum_wright" /></td>
					
					<td><s:property value="onum_wrong" /></td>
					
					<td><s:property value="onum_left" /></td>
										
					<td><s:property value="odec_total_mark" /></td>
					
					<td><s:property value="onum_rank" /></td>
				</tr>
			<%
				i++;
			%>
			</s:iterator>
			</s:else>
		</s:if>
	</table>
</div>
</div>

<input type="hidden" id="contextPath" value="<%= request.getContextPath() %>">	
</s:form>
</body>
</html>
