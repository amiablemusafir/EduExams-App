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
</head>


<body>
<div class="grid_10">
	<div class="box round first grid">

    <h2>Generate Score Card</h2>
    
    	<div align="center">
    	<s:form autocomplete="off" action="generateScoreCardDetails" name="generateScoreCardDetails" method="post" onsubmit="return(validation());">
		<s:hidden name="randomStingJsp" id="randomStingJsp"/>
		
		<div class="dms_display_message" id="info">${info}</div>
		
		
		<table width="40%" border="0" cellpadding="0" cellspacing="0">

			<tr>
				<td><b>Select Exam</b></td>
				<td align="right">
				<div class="styled-select2">
				
				<select id="onum_id" name="ostr_exam_name" tabindex="1">
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
				<td><b>Select Month</b></td>
				<td align="right">
				<div class="styled-select2">
				<select id="onum_month" name="onum_month" tabindex="1">
					<option value="0">Select</option>
					<option value="1">January</option>
					<option value="2">February</option>
					<option value="3">March</option>
					<option value="4">April</option>
					<option value="5">May</option>
					<option value="6">June</option>
					<option value="7">July</option>
					<option value="8">August</option>
					<option value="9">September</option>
					<option value="10">October</option>
					<option value="11">November</option>
					<option value="12">December</option>
				</select>
				</div>
				</td>				
			</tr>
			<tr><td colspan="2">&nbsp;</td></tr>
			<tr><td colspan="2">
				<div align="center">
				<input type="submit" name="GSC" value="Generate Score Card" style="width: 180px; height: 40px;" class="btn"/>
				</div>
				</td>
			</tr>
				
			<tr><td colspan="2">&nbsp;</td></tr>
			<tr><td colspan="2">
				<div align="left" style="font-style: italic;"><b>Note :</b> You are only eligible to generate the score card for past month.</div>
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

<div align="center">
<table width="90%">
<tr><td>&nbsp;</td></tr>
<tr>
	<td>
		<div align="center">
			<b style="font-weight: bold; font-size: 28px;">Your Generate Score Card.</b>
		</div>
	</td>
</tr>
<tr><td>&nbsp;</td></tr>
</table>

<table width="90%">
<tr>
	<td>&nbsp;&nbsp;&nbsp;</td>
	<td align="right"><b>Exam Name :</b></td>
	<td align="left"><s:textfield theme="simple" cssClass="text_field" name="exam_name" readonly="true"/></td>
	<td align="right"><b>Month :</b></td>
	<td align="left"><s:textfield theme="simple" cssClass="text_field" name="month_name" readonly="true"/></td>
</tr>
<tr><td colspan="5">&nbsp;</td></tr>
</table>

<table width="100%" id="example" border="1" bordercolor="#B3CBD6">
		<thead>
			<tr style="background-color: #B3CBD6;">
				<th colspan="6"><div align="center" height="30px">Student Details</div></th>
			</tr>
			<tr style="background-color: #B3CBD6;">
				<th width="10%">Sl No.</th>
				<th width="20%">Unique Id</th>
				<th width="30%">Name</th>
				<th width="20%">Phone</th>
				<th width="10%">Mark</th>
				<th width="10%">Score</th>
			</tr>
		</thead>
		<tbody>
		
		<s:if test="resultDetailsDtoList != null">
		
			<s:if test="%{resultDetailsDtoList.isEmpty()}">
				<tr class="odd">
					<td colspan="6" align="center" height="30px"><center>No Data Found</center></td>
				</tr>
			</s:if>
			<s:else>
			<%
				int i = 1;
			%>
			<s:iterator value="resultDetailsDtoList" id="requestList">
				<tr class="odd">
					<td width="5%" height="25px"><%=i%></td>
					<td height="25px"><s:property value="studentDetailsDto.istr_unique_id" /></td>
					<td height="25px"><s:property value="studentDetailsDto.istr_first_name" />&nbsp;<s:property value="studentDetailsDto.istr_last_name" /></td>
					<td height="25px"><s:property value="studentDetailsDto.inum_mobile_number" /></td>
					<td height="25px"><s:property value="odec_total_mark"/></td>
					<td height="25px"><s:property value="onum_rank" /></td>
				</tr>
			<%
				i++;
			%>
			</s:iterator>
			</s:else>
		</s:if>
		<s:else>
				<tr class="odd">
					<td colspan="6" align="center" height="30px"><center>No Data Found</center></td>
				</tr>
		</s:else>
	</tbody>
	</table>

</div>
</div>
</div>
</div>

<input type="hidden" id="contextPath" value="<%=request.getContextPath() %>" >
</body>
</html>   
