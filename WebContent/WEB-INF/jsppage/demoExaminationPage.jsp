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

<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<link rel="stylesheet" type="text/css" media="all" href="style/displayTag.css" />
</head>


<body>
<div class="grid_10">
	<div class="box round first grid">

	<h2>Demo Exam Details</h2>
	<s:form autocomplete="off" action="showDemoTestDescription" name="showDemoTestDescription" method="post">
		<s:hidden name="randomStingJsp" id="randomStingJsp"/>
				
		<div class="message1" id="info"><s:property value="info"/></div>
		<div class="clear"></div>	
		<br/>
		<center><p style="font-size: 17px;">Click below button to Start your Exam..</p></center>
		<div class="clear"></div>	
		<br/>
		<br/>
		<br/>
		<center><input type="submit" name="Start Examination" value="Start Examination" style="width: 200px; height: 40px;" class="btn"></center>
		<div class="clear"></div>	
		<br/>
		<br/>


	</s:form>
	</div>	
</div>


<div class="clear"></div>	
<input type="hidden" id="contextPath" value="<%=request.getContextPath() %>" >
</body>
</html>   
