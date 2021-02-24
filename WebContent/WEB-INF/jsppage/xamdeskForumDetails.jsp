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
    <h2>Xamdesk Forum</h2>
	<div align="center" style="padding: 30px 30px 30px 30px;">
	<img src="image/xamdesk_uc1.png" alt="under construction" style="height: 35%; width: 35%;"/>
	</div>
</div>	
</div>
<input type="hidden" id="contextPath" value="<%=request.getContextPath() %>" >
</body>