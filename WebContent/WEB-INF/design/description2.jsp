<%@page import="com.oes.dto.ExamDetailsDto"%>
<%@page import="com.sms.admin.dto.AdminDetailDto"%>
<%@page import="com.oes.dto.ExamQuestionDetailsDto"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="com.oes.dto.QuestionDetailsDto"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>IPO ONLINE EXAM</title>   
    <link rel='shortcut icon' type='image/x-icon' href='image/favicon.ico' />
     
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script src="js/jquery-1-10-2.js"></script>
	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
	
	<script type="text/javascript">
	function next() {
		var contextPath = $('#contextPath').val();
    	contextPath = contextPath+"/showDescription3";
    	window.location.href = contextPath;
	}
	function prev() {
		var contextPath = $('#contextPath').val();
    	contextPath = contextPath+"/showDescription1";
    	window.location.href = contextPath;
	}
	</script>
	
	<style type="text/css">
		#container_body {
			width: 97%;
			float: left;
			color: #ffffff;
			float: left;			
			border: 1px solid #ffffff;
			min-height: 20px;
			background: #032947;
			border-radius: 0%;
			-webkit-box-shadow: 1px 1px 15px 0px rgba(0,0,0,0.75);
		    -moz-box-shadow: 1px 1px 15px 0px rgba(0,0,0,0.75);
		    -ms-box-shadow: 1px 1px 15px 0px rgba(0,0,0,0.75);
		    -o-box-shadow: 1px 1px 15px 0px rgba(0,0,0,0.75);
		    box-shadow: 1px 1px 15px 0px rgba(0,0,0,0.75);
			margin: 1em .8em;
		}
		
		#container_bottom {
			width: 100%;
			height: auto;
			background-color: lightgrey;
			background: -webkit-linear-gradient(lightgrey, #000000);
			background: -moz-linear-gradient(lightgrey, #000000);
			background: -ms-linear-gradient(lightgrey, #000000);
			background: -o-linear-gradient(lightgrey, #000000);-webkit-box-shadow: 1px 1px 15px 0px rgba(0,0,0,0.75);
		}
		
		#container_page {
			width: 95%;
			float: left;
			margin: 2em 2em;
			margin-right: 2em;
		}
		
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
			width: 150px;
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
  </style>
  </head>

  <body onload="count();" style="background-color: #f1f3f2;">
	    <body onload="count();" style="background-color: silver;">
	    <div id="container_body">
		<%
			AdminDetailDto adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
		    ExamDetailsDto examDetailsDto = (ExamDetailsDto) request.getSession().getAttribute("examDetailsDto");	
		%>
		<div id="container_page">
		<table width="100%">
			
	    	<tr>
	    		<td align="center" style="color: #ffffff; font-size: 25px;"><b>Question Paper Instructions</b></td>
	   		</tr>
	   		<tr>
	    		<td align="center" style="color: #ffffff; font-size: 25px;"><hr/></td>
	   		</tr>
	   		
	   	</table>
	   	
	   	<div>
			<img alt="Question Paper Instructions" src="image/exam_paper.png" width="100%" height="480px;">
		</div>
		
		
		</div>
	    </div> 
	    
	    <div class="clear"></div>
		<hr style="width:95%; border-bottom:1px dotted  #CCCCCC;" />
	    	    
	    <table width="100%">
	    <tr><td colspan="5"></td></tr>
	    <tr>
	    <td width="10%"></td>
	    <td width="10%" align="left"><button onclick="prev()" style="background-color: #DF7401" class="myButton">Previous</button></td>
	    <td width="60%"></td>
	    <td width="10%" align="right"><button onclick="next()" style="background-color: #DF7401" class="myButton">Next</button></td>
	    <td width="10%"></td>
	    </tr>
	    <tr><td colspan="5"><hr/></td></tr>
	    </table>	    
		<input type="hidden" id="contextPath" value="<%=request.getContextPath() %>">	    
  </body>
</html>

