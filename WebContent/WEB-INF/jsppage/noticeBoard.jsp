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

		function viewNotice(notice) {
			
			$("#notice_board").html(notice);
			$("#notice_board").focus();
			
		}
</script>
</head>
<body>

<div class="grid_10">
	<div class="box round first grid">

    <h2>Notice Board</h2>
<div class="dms_display_message"><s:property value="info"/></div>
<div align="center">
<div style="background: url('image/notice_board.png') no-repeat; height: 272px; width: 673px; margin-top: 20px;">
	<br/>
	<br/>
	<br/>
	<br/>
	
	<div id="notice_board" style="width: 560px; margin-left: 5px; font-size: 16px; text-align: left; color: #fff; line-height: 17px; font-family: monospace;" >
	
	
	</div>

</div>
</div>
</div>
</div>

<div class="grid_10">
	<div class="box round first grid">


			 <div class="block">
			 <table class="data display datatable" id="example" border="1" bordercolor="#B3CBD6"><thead>
			<tr>
				<th class="coll_align" width="10%">Sl No.</th>
				<th class="coll_align" width="80%">Notice Board</th>
				<th class="coll_align" width="10%">View</th>
			</tr>
		</thead>
		<tbody>
		
		<s:if test="noticeDtoList != null">

			<s:if test="%{noticeDtoList.isEmpty()}">

			</s:if>
			<s:else>
			<%
				int i = 1;
			%>
			<s:iterator value="noticeDtoList" id="requestList">
				<tr class="odd">
					<td class="itemcenter5"><%=i%></td>
					<td class="itemcenter5"><s:property value="gstr_notice_headline" /></td>
					<td class="itemcenter5"><input type="button" name="View" value="View" onclick="viewNotice('${requestList.gstr_notice}');" class="btn btn-small"/></td>
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