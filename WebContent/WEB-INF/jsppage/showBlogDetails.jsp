<!-- 
Author: Sumit Singh
Start Date: 19th March, 2014
Modify Date:
Modify By:
 -->
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
 
</head>
<body>
		<div class="grid_10">
		<div class="box round first grid">
		<h2>Latest Events & Examination Details</h2>

		<br/>

		<div align="center">
		<s:if test="postOfficeMannualDetailsDtoList != null">
			<s:if test="%{postOfficeMannualDetailsDtoList.isEmpty()}">
					<br/>
					<br/>
					<div style="font-size: 15px;"><b>We didn't find any record.</b></div>
  					
			</s:if>
			<s:else>
			<table width="98%" border="1"  bordercolor="#B3CBD6">	
			<%int i = 1; %>
			<s:iterator value="postOfficeMannualDetailsDtoList" id="requestList">
  					<tr>
  						<td width="5%" style="font-size: 15px;" valign="middle"><%=i%>) </td>
  						<td width="80%" style="font-size: 15px;"><s:property value="ostr_message"/></td>
    					<td width="15%" valign="middle"><a href="${requestList.ostr_link}" target="_blank">Click Here..</a></td>
  					</tr>  
				
				<%i++;%>			
			</s:iterator>
			</table>
			</s:else>
		</s:if>

		</div>
		</div>
	</div>
</body>
</html> 