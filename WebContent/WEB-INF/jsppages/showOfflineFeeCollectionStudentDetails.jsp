<!-- 
Author: Sumit Singh
Start Date: 19th March, 2014
Modify Date:
Modify By:
 -->
<%@page import="com.oes.dto.StudentDetailsDto"%>
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
 
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<link rel="stylesheet" type="text/css" media="all" href="style/displayTag.css" /> 
<script type="text/javascript">
	function showDetails() {
		$("#hidebutton").show();
		$("#showbutton").hide();
		$("#showStudentDetails").show();
	}
	
	function hideDetails() {
		$("#showbutton").show();
		$("#hidebutton").hide();
		$("#showStudentDetails").hide();
	}
	
	
	function showFeeDetails() {
		$("#hideFeebutton").show();
		$("#showFeebutton").hide();
		$("#showLastFeeDetails").show();
	}
	
	function hideFeeDetails() {
		$("#showFeebutton").show();
		$("#hideFeebutton").hide();
		$("#showLastFeeDetails").hide();
	}
	
	
	function addNewRow1() {  
		
		var table_loop_size = $("#table_loop_size").val();
		table_loop_size = parseInt(table_loop_size) + 1;	
		var divHtml = "";
		divHtml = divHtml+'<tr id="itemrow'+table_loop_size+'">';
		divHtml = divHtml+'<td class="itemcenter5">'+table_loop_size+'</td>';
		divHtml = divHtml+'<td class="itemcenter5"><input type="text" name="cost" size="50"></td>';
		divHtml = divHtml+'<td><input type="text" name="amount" id="amount'+table_loop_size+'" value="0" class="text_field2" onblur="calulateAmount();" style="text-align: right;"></td>';
		divHtml = divHtml+'<td><input type="text" name="remark" id="remark'+table_loop_size+'" class="text_field2"></td>';
		divHtml = divHtml+'</tr>';
		
		$("#requestList").append(divHtml);	
		$("#table_loop_size").val(table_loop_size);
		this.calulateAmount();
	}
	
	function removeRow1() {
		var id = $("#table_loop_size").val();
		if(id != '1') {
			$("#itemrow"+id).remove();
			id = parseInt(id)-1;
			$("#table_loop_size").val(id);
		}
		this.calulateAmount();
	}
	
	function calulateAmount() {
		
		var id = $("#table_loop_size").val();
		var subTotal = '0';
		var total = '0';
		for(var i = 1; i<=id; i++) {
			
			var amount = $("#amount"+i).val();
			amount = parseFloat(amount);
			amount = amount.toFixed(2);
			$("#amount"+i).val(amount);
			
			if(amount != '') {
				subTotal = parseFloat(subTotal)+parseFloat(amount);
			}	
		}	
		var balance = $("#balance").val();
		total = parseFloat(subTotal)+parseFloat(balance);
		
		subTotal = subTotal.toFixed(2);
		$("#subtotal").html(subTotal);
		
		total = total.toFixed(2);
		$("#total").html(total);
		
		var amountpaid = $("#amountpaid").val();
		amountpaid = parseFloat(amountpaid);
		amountpaid = amountpaid.toFixed(2);
		$("#amountpaid").val(amountpaid);
		
		var due = parseFloat(total)-parseFloat(amountpaid);
		
		due = due.toFixed(2);
		$("#due").html(due);
	}
	
</script>
</head>
<body>
<div class="dms_bar">Offline Fee Collection Details</div>

<%StudentDetailsDto studentDetailsDto = (StudentDetailsDto)request.getSession().getAttribute("studentDetailsDto"); %>
<s:form theme="simple" name="enquiryDetail" action="searchStudentsDetailsByCretariaOfflineDetails" method="post" onsubmit="">
<div class="dms_admin_cover">
<div class="dms_display_message"><s:property value="info"/></div>
<div class="dms_admin_unique_detail">

<table width="80%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><label for="Unique ID">Unique ID</label>:</td>
    <td>   
    <%= studentDetailsDto.getIstr_unique_id()%>
    </td>
  </tr>
</table>
</div>

<div class="dms_admin_course">
<table width="94%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="25%" valign="middle">
    <label for="gender">Name</label>:</td>
    <td width="70%"><%= studentDetailsDto.getIstr_first_name()%>&nbsp;<%= studentDetailsDto.getIstr_last_name()%></td>
  </tr>
</table>
</div>


<div class="clear"></div>

<table style="width: 100%;">
<tr>
<td width="50%">
<div id="showbutton" align="center" style="margin-top: 20px;">
<a href="javascript:;"><input type="button" value=" Show All Details " tabindex="9" onclick="showDetails();"></a>
</div>

<div id="hidebutton" align="center" style="margin-top: 20px; display: none;">
<a href="javascript:;"><input type="button" value=" Hide Details " tabindex="9" onclick="hideDetails();"></a>
</div>
</td>
<td width="50%">
<div id="showFeebutton" align="center" style="margin-top: 20px;">
<a href="javascript:;"><input type="button" value=" Show Last Fee Details " tabindex="9" onclick="showFeeDetails();"></a>
</div>

<div id="hideFeebutton" align="center" style="margin-top: 20px; display: none;">
<a href="javascript:;"><input type="button" value=" Hide Fee Details " tabindex="9" onclick="hideFeeDetails();"></a>
</div>

</td>
</tr>
</table>

</div>
<div class="clear"></div>


<div id="showStudentDetails" style="display: none;">
<div class="dms_admin_cover">
<div class="dms_bar">Student Complete Details</div>
<div class="dms_display_message"><s:property value="info"/></div>

<div class="dms_admin_unique_detail">
<table width="80%" border="0" cellpadding="0" cellspacing="0">
  <tr height="30px">
    <td><label for="Unique ID">Unique ID</label>:</td>
    <td>   
    <%= studentDetailsDto.getIstr_unique_id()%>
    </td>
  </tr>
  <tr height="30px">
    <td><label for="firstname">Name</label>:</td>
    <td>
      <%= studentDetailsDto.getIstr_first_name()%>&nbsp;<%= studentDetailsDto.getIstr_last_name()%>
    </td>
  </tr>
  <tr height="30px">
    <td><label for="lastname">Class</label>:</td>
    <td>
      <%= studentDetailsDto.getIstr_class()%>
    </td>
  </tr>
  <tr height="30px">
   <td><label for="DateofBirth">Date of Birth</label>:</td>
    <td>
    <%= studentDetailsDto.getIstr_date_of_birth()%>
    </td>
  </tr>
  <tr height="30px">
   <td><label for="DateofBirth">Pic of Student</label>:</td>
    <td>
    <%if(studentDetailsDto.getIbl_std_pic() != null){
		%><img id="blah2" src='data:image/jpg;base64,<%= studentDetailsDto.getIbl_std_pic()%>' style="width: 142px; height: 160px;"/>
	<%}%>
    </td>
  </tr>
 </table>
 
</div>

<div class="dms_admin_course">
<table width="94%" border="0" cellpadding="0" cellspacing="0">
  <tr height="30px">
    <td width="25%" valign="middle">
    <label for="gender">Father Name</label>:</td>
    <td width="70%">
    <%= studentDetailsDto.getIstr_father_name()%></td>
    </tr>
  
    <tr height="30px">
    <td><label for="Email">Mobile No </label>:</td>
    <td>
   	<%= studentDetailsDto.getInum_mobile_number()%>
    </td>
    </tr>
  
  
    <tr height="30px">
    <td><label for="Pincode">Email Id</label>:</td>
    <td>
    <%= studentDetailsDto.getIstr_email()%>
    </td>
    
    <tr height="30px">
    <td><label for="Pincode">Gender</label>:</td>
    <td>
    <%= studentDetailsDto.getIstr_gender()%>
    </td>
</tr>
</table>
</div>
</div>
</div>


<div id="showLastFeeDetails" style="display: none;">
<div class="dms_admin_cover">
<div class="dms_bar">Last Fee Details</div>
<div class="dms_display_message"><s:property value="info"/></div>

<div class="dms_admin_unique_detail">
<table width="80%" border="0" cellpadding="0" cellspacing="0">
  <tr height="30px">
    <td><label for="Unique ID">Date Of Payment</label>:</td>
    <td>   
    23-02-2015
    </td>
  </tr>
  <tr height="30px">
    <td><label for="firstname">Amount</label>:</td>
    <td>
      4000.00
    </td>
  </tr>
  <tr height="30px">
    <td><label for="lastname">Received By</label>:</td>
    <td>
      Global Kids Pride
    </td>
 </table>
 
</div>
<div class="dms_admin_course">
<table width="94%" border="0" cellpadding="0" cellspacing="0">
  <tr height="30px">
    <td width="40%" valign="middle">
    <label for="gender">Payment By</label>:</td>
    <td width="60%">
    	Nadim Sharma
    </tr>
  
    <tr height="30px">
    <td><label for="Email">Mode Of Payment </label>:</td>
    <td>
   		Cash
    </td>
    </tr>
    
    <tr height="30px">
    <td><label for="Email">Balance Amount </label>:</td>
    <td>
   		<div><input type="hidden" name="balance" id="balance" value="100.00">100.00</div> 
    </td>
    </tr>
   
</table>
</div>
</div>
</div>


<div class="dms_admin_cover">
<div class="dms_bar">Payment Details</div>
<div class="dms_admin_unique_detail">

<table width="80%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><label for="Unique ID">Paid By</label>:</td>
    <td>   
    <s:textfield theme="simple" name="newsAndEventsDto.gstr_headline" id="gstr_headline" />
    </td>
  </tr>
</table>
</div>

<div class="dms_admin_course">
<table width="94%" border="0" cellpadding="0" cellspacing="0">
  <tr>
  	<td width="40%"><label for="Unique ID">Payment Mode</label>:</td>
    <td width="60%" valign="middle">
    <div class="styled-select2">
	<select name="homeworkUploadDto.gstr_class" id="gstr_class">
				<option value="- select class -">- select -</option>
				<option value="Play Group">Cash</option>
				<option value="Nursery">Cheque</option>
				<option value="KG">Demand Draft</option>
				<option value="Class 1">Card</option>
	</select>
	</div>
    </td>
  </tr>
</table>
</div>


<div class="clear"></div>
<hr style="width:95%; border-bottom:1px dotted  #CCCCCC;" />

		<table width="95%" border="1" bordercolor="#FFFFFF" cellspacing="0" cellpadding="0" id="requestList">
	
		  <tr>
		  <td colspan="3"></td>
		  <td height="35px" style="background: #eee; color: #000000;"><div align="center"><input type="button" value="&nbsp;+&nbsp;" tabindex="9" onclick="addNewRow1();"><a href="javascript:;"> &nbsp;&nbsp;<input type="button" value="&nbsp;-&nbsp;" tabindex="9" onclick="removeRow1();"></a></div></td>
		  </tr>
		  <tr style="background: #eee; color: #000000;">
		  	  <td width="10%" height="30px">&nbsp;&nbsp;&nbsp; Sl No.</td>
		  	  <td width="60%">&nbsp;&nbsp;&nbsp; Description</td>
		      <td width="15%">&nbsp;&nbsp;&nbsp; Amount</td>
		      <td width="15%">&nbsp;&nbsp;&nbsp; Remark</td>
		  </tr>
		  
		  <tr id="itemrow1">
		  	  <td class="itemcenter5">1</td>
		      <td class="itemcenter5"><input type="text" name="cost" size="50"></td>
		      <td><input type="text" name="amount" id="amount1" value="0" class="text_field2" onblur="calulateAmount();" style="text-align: right;"></td>
		      <td><input type="text" name="remark" id="remark1" class="text_field2"></td>
		  </tr>
		  </table>
		  
		  
		  
		  
		  
		  <table width="95%" border="1" bordercolor="#FFFFFF" cellspacing="0" cellpadding="0" id="requestList2" class="Table">

		  <tr>
		      <td colspan="2" class="itemcenter6" width="70%"> </td>
		      <td colspan="1" class="itemcenter6" width="15%">Subtotal</td>
		      <td class="itemcenter6" width="15%"><div id="subtotal">0</div></td>
		  </tr>
		  <tr>

		      <td colspan="2" class="itemcenter6"> </td>
		      <td colspan="1" class="itemcenter6">Total</td>
		      <td class="itemcenter6"><div id="total">0</div></td>
		  </tr>
		  <tr>
		      <td colspan="2" class="itemcenter6"> </td>
		      <td colspan="1" class="itemcenter6">Amount Paid</td>

		      <td class="itemcenter6"><input type="text" name="amountpaid" id="amountpaid" value="0" class="text_field2" onblur="calulateAmount();"></td>
		  </tr>
		  <tr>
		      <td colspan="2" class="itemcenter6"> </td>
		      <td colspan="1" class="itemcenter6">Balance Due</td>
		      <td class="itemcenter6"><div id="due">0</div></td>
		  </tr>
		
		</table>
</div>
<input type="hidden" name="table_loop_size" id="table_loop_size" value="1">


<div class="clear"></div>
<hr style="width:95%; border-bottom:1px dotted  #CCCCCC;" />

<div class="dms_request_button"><table width="98%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td><div align="center"><input type="submit" value="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Pay&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" name="submit" tabindex="8" onclick="getSearch1();"></div></td>
  </tr>
</table>
</div>
<div class="clear"></div>
<hr style="width:95%; border-bottom:1px dotted  #CCCCCC;" />


</s:form>
<input type="hidden" id="contextPath" value="<%=request.getContextPath() %>">
</body>
</html> 