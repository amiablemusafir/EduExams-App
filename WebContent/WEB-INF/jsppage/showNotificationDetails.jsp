<!-- 
Author: Sumit Singh
Start Date: 27th March, 2014
Modify Date:
Modify By:
Motive: Admission Details
 -->
<%@page import="java.util.ArrayList"%>
<%@page import="com.oes.dto.NotificationDetailsDto"%>
<%@page import="java.util.List"%>
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
    <h2>Notifications</h2>
	<div class="block">
	<%
	List<NotificationDetailsDto> notificationDetailsDtoList = new ArrayList<NotificationDetailsDto>();
	notificationDetailsDtoList = (ArrayList<NotificationDetailsDto>) request.getSession().getAttribute("notificationDetailsDtoList");
	
	if(notificationDetailsDtoList != null && notificationDetailsDtoList.size()>0) {
		int i = 1;
		for(NotificationDetailsDto dto : notificationDetailsDtoList) {
			if(i == 1) {
			%>	
			<div class="message info">
	            <p style="float: left;">Date : <%=dto.getOstr_date()%></p>
				<p style="float: right;">By : <%=dto.getAdminDetailDto().getIstr_user_name()%></p>
				<h5><%=dto.getOstr_notification_details()%></h5>
            </div>
			<%
			} else if(i == 2) {
			%>	
			<div class="message success">
	            <p style="float: left;">Date : <%=dto.getOstr_date()%></p>
				<p style="float: right;">By : <%=dto.getAdminDetailDto().getIstr_user_name()%></p>
				<h5><%=dto.getOstr_notification_details()%></h5>
			</div>		
			<%				
			} else if(i == 3) {
			%>	
			<div class="message warning">
				<p style="float: left;">Date : <%=dto.getOstr_date()%></p>
				<p style="float: right;">By : <%=dto.getAdminDetailDto().getIstr_user_name()%></p>
				<h5><%=dto.getOstr_notification_details()%></h5>
				
			</div>
			<%
			} else if(i == 4) {
			%>
			<div class="message error">
				<p style="float: left;">Date : <%=dto.getOstr_date()%></p>
				<p style="float: right;">By : <%=dto.getAdminDetailDto().getIstr_user_name()%></p>
				<h5><%=dto.getOstr_notification_details()%></h5>
            </div>
			<%
			i = 0;
			}		
			i++;
		}		
	} else {
	%>
	<div align="center"><b>We didn't find any notification.</b></div>
	<%
	} 
	%>
    </div>
	</div>
	<div class="clear">
	</div>
</div>
<input type="hidden" id="contextPath" value="<%=request.getContextPath() %>" >
</body>