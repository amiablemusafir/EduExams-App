<%@page import="com.itextpdf.text.log.SysoLogger"%>
<%@page import="com.oes.dto.ExamDetailsDto"%>
<%@page import="com.sms.admin.dto.AdminDetailDto"%>
<%@page import="com.oes.dto.ExamQuestionDetailsDto"%>
<%@page language="java" import="java.util.*"%>
<%@page import="com.oes.dto.QuestionDetailsDto"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Xamdesk | Test Paper</title>   
    <link rel='shortcut icon' type='image/x-icon' href='image/favicon.ico' />
    
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="css/sunny/jquery-ui-1.10.4.custom.css" rel="stylesheet">
	<script src="js_sunny/jquery-1.10.2.js"></script>
	<script src="js_sunny/jquery-ui-1.10.4.custom.js"></script>
		 
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script type="text/javascript">
	
	
	$(document).keydown(function(e) {
	    e.preventDefault();
	});
	
	var current_key = "1";
	var current_id = "0";
	var is_reminder = "0";
	var close_status = "0";
	
	$( document ).ready(function() {
		
		<%if(request.getSession().getAttribute("exam_key") != null) {
	  		if(request.getSession().getAttribute("exam_key").equals("close_page")) {
	  		%>	  		
	  			var win = window.open("about:blank","_self");
	  			win.close();
	  		<%
	  		}
	    }
	  	%>
		
		var date = new Date();
		var mydate = date.getDate();
		mydate = mydate+"/";
		var month = date.getMonth();
		month++;
		mydate = mydate+""+month;
		mydate = mydate+"/";
		mydate = mydate+""+date.getFullYear();
		mydate = mydate+"  | Time : ";
		mydate = mydate+""+date.getHours();
		mydate = mydate+":"+date.getMinutes();
		mydate = mydate+":"+date.getSeconds();
		
		$("#current_date").html("&nbsp;Date : "+mydate);
		$("#page10").show();
		$("#asidebar10").css("background-color","#EF171F");
		$("#bottom_bar10").css("background-color","#EF171F");
		
		document.onkeydown = function() {
			var x = event.keyCode;
			if(((x == 70) || (x == 78) || (x == 79) || (x == 80)) && (event.ctrlKey) || (x > 111 && x< 124)) {
				event.cancelBubble = true;
				event.returnValue = false;
				event.keyCode = false;
				return false;
			}
		}
		
		$(window).on('beforeunload', function() {
			if(close_status == "0") {
				//return confirm("Are you sure you want to leave this Exam?");
			}
		});
		
		 //if IE4+
		 document.onselectstar=new Function ("return false")
		 document.oncontextmenu=new Function ("return false")
		 //if NS6
		 //alert("hello");
		 if (window.sidebar) {
			 document.onmousedown=disableselect
			 document.onclick=reEnable
		 }
	 	//alert("hello");
	});
	
	
	function launchFullscreen(element) {
    	if(element.requestFullScreen) {
		    element.requestFullScreen();
		} else if(element.mozRequestFullScreen) {
		    element.mozRequestFullScreen();
		} else if(element.webkitRequestFullScreen) {
		    element.webkitRequestFullScreen();
		}
	}

	function cancelFullscreen() {
		if(document.cancelFullScreen) {
		    document.cancelFullScreen();
		} else if(document.mozCancelFullScreen) {
		    document.mozCancelFullScreen();
		} else if(document.webkitCancelFullScreen) {
		    document.webkitCancelFullScreen();
		}
	}

	launchFullscreen(document.documentElement);
	
	
	function prev(i,key) {
		
		current_id = i;
		current_key = key;
		var j = i;
		$("#page"+key+""+i).show();
		i = parseInt(i)+1;
		$("#page"+key+""+i).hide();
		var a = $("#selected"+key+j).val();
		if(a == "0") {
			$("#asidebar"+key+""+j).css("background-color","#EF171F");
			$("#bottom_bar"+key+""+j).css("background-color","#EF171F");
		}
		
		$("#asidebar"+key+""+j).focus();
	}
	
	function next(i,key) {
		
		current_id = i;
		current_key = key;
		var j = i;
		$("#page"+key+""+i).show();
		i = parseInt(i)-1;
		
		$("#page"+key+""+i).hide();
		var a = $("#selected"+key+""+j).val();
		if(a == "0") {
			$("#asidebar"+key+""+j).css("background-color","#EF171F");
			$("#bottom_bar"+key+""+j).css("background-color","#EF171F");
		}
		$("#asidebar"+key+""+j).toggleClass('focus');;
	}
	
	function current(i,key) {

		$("#asidebar"+key+""+i).focus();
		$("#page"+current_key+""+current_id).hide();
		$("#page"+key+""+i).show();
		
		var a = $("#selected"+key+""+i).val();
		if(a == "0") {
			$("#asidebar"+key+""+i).css("background-color","#EF171F");
			$("#bottom_bar"+key+""+i).css("background-color","#EF171F");
		} else if(a == "1") {
			$("#asidebar"+key+""+i).css("background-color","#2ECA0D");
			$("#bottom_bar"+key+""+i).css("background-color","#2ECA0D");
		}
		current_id = i;
		current_key = key;
		is_reminder = "0";
	}
	
	function reminder(i,key) {
		$("#asidebar"+key+""+i).focus();
		$("#asidebar"+key+""+i).css("background-color","#F7E20E");
		$("#bottom_bar"+key+""+i).css("background-color","#F7E20E");
	}
	
	//function finish() {
	//	var r = confirm("Are you sure!\nYou want to finish the exam.");
	//	if(r == true) {
	//		close_status = "1";
			
	//		document.getElementById("saveUserResultDetails").submit();
			    	
	//    	//var win = window.open("about:blank","_self");
	//		//win.close();
	//	}
	//}
	
	function finish() {
		$( "#finish-dialog-confirm" ).dialog({
	    	resizable: false,
	      	height: 220,
	      	width: 380,
	      	modal: true,
	      	buttons: {
	        	"Confirm": function() {
	        	close_status = "1";
	        		$("#dialog" ).dialog({
	        			resizable: false,
	        	      	height: 220,
	        	      	width: 380,
	        	      	modal: true,
	        	      	closeOnEscape: false
	        		});
				document.getElementById("saveUserResultDetails").submit();
	            $( this ).dialog( "close" );
	        },
	        	Cancel: function() {
	          		$( this ).dialog( "close" );
	        	}
	      	}
	    });
	}
	
	function changeStatusAnswer(i,key) {
		$("#selected"+key+""+i).val("1");
		$("#asidebar"+key+""+i).css("background-color","#2ECA0D");
		$("#bottom_bar"+key+""+i).css("background-color","#2ECA0D");
	}
	
	function resetButton(i,key) {
		
		 $("#asidebar"+key+""+i).focus();
		 $("#asidebar"+key+""+i).css("background-color","#EF171F");
		 $("#bottom_bar"+key+""+i).css("background-color","#EF171F");
		 var ele = document.getElementsByName("answer"+key+""+i);
		 $("#selected"+key+""+i).val("0");
		 
		 for(var i=0;i<ele.length;i++) {
			 ele[i].checked = false;
		 }
	 } 
	 
	 function disableselect(e) {
		 return false;
	 }
	 
	 function reEnable() {
		 return true;
	 }
	 
	 function count(element) {
		 
		 var startTime = document.getElementById('hms').innerHTML;
		 var pieces = startTime.split(":");
		 var time = new Date();
		 time.setHours(pieces[0]);
		 time.setMinutes(pieces[1]);
		 time.setSeconds(pieces[2]);
		 
	
		 
		 var timedif = new Date(time.valueOf()-1000);
		 var newtime = timedif.toTimeString().split(" ")[0];
		 
		
		 if(newtime != "00:00:00") {
			 document.getElementById('hms').innerHTML = newtime;
			 setTimeout(count, 1000);
		 } else {
			 document.getElementById('hms').innerHTML = newtime;
			 close_status = "1";
			 $("#dialog" ).dialog({
     			resizable: false,
     	      	height: 220,
     	      	width: 380,
     	      	modal: true,
     	      	closeOnEscape: false
     		 });
			 document.getElementById("saveUserResultDetails").submit();
		     
		     //var win = window.open("about:blank","_self");
			 //win.close();
		 }
	  }
	 
	  function changeExamSection() {
		 
		  var istr_section_id = $("#istr_section_id").val();
		  var all_section = $("#all_section_size").val();
		  
		  $("#page"+current_key+""+current_id).hide();
			
		  
		  for(var i = 1; i<=all_section; i++) {
			
			 var sta = "SECTION"+i;
			 if(sta == istr_section_id) {
				 $("#SECTION"+i).show();
				 $("#BODY"+i).show();
				 
				 current_key = i;
				 current_id = 0;
				 $("#page"+i+"0").show();
				 var a = $("#selected"+i+"0").val();
				 if(a == "0") {
					
				 	$("#asidebar"+i+"0").css("background-color","#EF171F");
				 	$("#bottom_bar"+i+"0").css("background-color","#EF171F");
				 }	
			 } else {
				 $("#SECTION"+i).hide();
				 $("#BODY"+i).hide();
			 }
			  
		  }		  
	 }
	  
	 function changeExamNo(key,q_no) {
		
		  $("#istr_section_id").val("SECTION"+key);
		  $("#page"+current_key+""+current_id).hide();
			
		  var all_section = $("#all_section_size").val();
		  
		  for(var i = 1; i<=all_section; i++) {
			
			 var sta = "SECTION"+i;
			 var key_val = "SECTION"+key;
			 if(sta == key_val) {
				 $("#SECTION"+i).show();
				 $("#BODY"+i).show();
				 
				 current_key = key;
				 current_id = q_no;
				 $("#page"+i+""+q_no).show();
				 
				 var a = $("#selected"+i+""+q_no).val();
				 if(a == "0") {
					 $("#asidebar"+i+""+q_no).focus();
					 $("#asidebar"+i+""+q_no).css("background-color","#EF171F");
				 	$("#bottom_bar"+i+""+q_no).css("background-color","#EF171F");
				 }	
			 } else {
				 $("#SECTION"+i).hide();
				 $("#BODY"+i).hide();
			 }
			  
		  }	
	 } 
	</script>
	
	<style type="text/css">
		
		body {
			background-color: #f1f3f2;
			-webkit-user-select: none;
			-moz-user-select: none;
			-ms-user-select: none;
			 user-select: none;
		}
		
		.ui-dialog-titlebar-close{
		    display: none;
		}

		#container_body {
			width: 100%;
			height: 100%;
			overflow-y: scroll;
		}
		
		#container_bottom {
			width: 97%;
			float: left;
			color: #ffffff;
			float: left;			
			border: 1px solid #ffffff;
			min-height: 20px;
			background: #032947;
			-webkit-box-shadow: 1px 1px 15px 0px rgba(0,0,0,0.75);
		    -moz-box-shadow: 1px 1px 15px 0px rgba(0,0,0,0.75);
		    -ms-box-shadow: 1px 1px 15px 0px rgba(0,0,0,0.75);
		    -o-box-shadow: 1px 1px 15px 0px rgba(0,0,0,0.75);
		    box-shadow: 1px 1px 15px 0px rgba(0,0,0,0.75);
			margin: 1em .8em;
		}
		
		#container_top {
			width: 97%;
			float: left;
			color: #ffffff;
			float: left;			
			border: 1px solid #ffffff;
			min-height: 20px;
			background: #032947;
			-webkit-box-shadow: 1px 1px 15px 0px rgba(0,0,0,0.75);
		    -moz-box-shadow: 1px 1px 15px 0px rgba(0,0,0,0.75);
		    -ms-box-shadow: 1px 1px 15px 0px rgba(0,0,0,0.75);
		    -o-box-shadow: 1px 1px 15px 0px rgba(0,0,0,0.75);
		    box-shadow: 1px 1px 15px 0px rgba(0,0,0,0.75);
			margin: 1em .8em;
		}
		
		#container {
			width: 100%;
			height: 510px;
			
		}
		
		#container2 {
			width: 100%;
			min-height: 310px;
			overflow-y: scroll;
			background-color: #eee;
		}	
		
		.item1 {
			width: 12%;
			overflow: hidden;
			height: 400px;
			overflow-y: scroll;
			white-space: nowrap;
			float: left;
			background-color: #eee;
			-webkit-box-shadow: 1px 1px 15px 0px rgba(0,0,0,0.75);
			-moz-box-shadow: 1px 1px 15px 0px rgba(0,0,0,0.75);
			-ms-box-shadow: 1px 1px 15px 0px rgba(0,0,0,0.75);
			-o-box-shadow: 1px 1px 15px 0px rgba(0,0,0,0.75);
			box-shadow: 1px 1px 15px 0px rgba(0,0,0,0.75);
			margin: .0em 0.9em;
			border-radius: 2%;
		    border:1px solid #ffffff;
		}
		
		.item2 {
			width: 83%;
			overflow: hidden;
			white-space: nowrap;
			float: left;
			background-color: #eee;
			-webkit-box-shadow: 1px 1px 15px 0px rgba(0,0,0,0.75);
			-moz-box-shadow: 1px 1px 15px 0px rgba(0,0,0,0.75);
			-ms-box-shadow: 1px 1px 15px 0px rgba(0,0,0,0.75);
			-o-box-shadow: 1px 1px 15px 0px rgba(0,0,0,0.75);
			box-shadow: 1px 1px 15px 0px rgba(0,0,0,0.75);
			margin: .0em .5em;
			border-radius: 2%;
		    border:1px solid #ffffff;
		}
		
		.left {
			border:1px solid #942911;
			padding:1px 1px;
			display: inline-block;
		    margin-left: 3px;
		    margin-top: 5px;
		    height: 20px;
		    border-radius: 25%;
		    background-color: lightgrey;
		    width:20px;
		    border:solid #ffffff 1px; 
			background-color: #EF171F;
		}
		
		.completed {
			border:1px solid #942911;
			padding:1px 1px;
			display: inline-block;
		    margin-left: 3px;
		    margin-top: 5px;
		    height: 20px;
		    border-radius: 25%;
		    background-color: lightgrey;
		    width:20px;
		    border:solid #ffffff 1px; 
			background-color: #2ECA0D;
		}
		
		.reminder {
			border:1px solid #942911;
			padding:1px 1px;
			display: inline-block;
		    margin-left: 3px;
		    margin-top: 5px;
		    height: 20px;
		    border-radius: 25%;
		    background-color: lightgrey;
		    width:20px;
		    border:solid #ffffff 1px; 
			background-color: #F7E20E;
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
	
		
		label {
		    width: 100%;
		    border-radius: 3px;
		    border: 1px solid #D1D3D4;
		}
		/* hide input */
		input.radio:empty {
			margin-left: -2999px;
		}
		
		/* style label */
		input.radio:empty ~ label {
			position: relative;
			float: left;
			line-height: 2.5em;
			margin-top: 0.4em;
			cursor: pointer;
			-webkit-user-select: none;
			-moz-user-select: none;
			-ms-user-select: none;
			user-select: none;
		}
		
		input.radio:empty ~ label:before {
			position: absolute;
			display: block;
			top: 0;
			bottom: 0;
			left: 0;
			content: '';
			width: 2.5em;
			background: #cfd5d2;
			border-radius: 3px 0 0 3px;
		}
		
		/* toggle hover */
		input.radio:hover:not(:checked) ~ label:before {
			content:'\2714';
			text-indent: .9em;
			color: #000000;
		}
		
		input.radio:hover:not(:checked) ~ label {
			color: #000000;
		}
		
		/* toggle on */
		input.radio:checked ~ label:before {
			content:'\2714';
			text-indent: .9em;
			color: #9CE2AE;
			background-color: #2ECA0D;
		}
		
		input.radio:checked ~ label {
			color: #777;
		}
		
		/* radio focus */
		input.radio:focus ~ label:before {
			box-shadow: 0 0 0 3px #999;
		}
		
		.bullet {
    		background-color: #34495e;
    		color: #fff;
    		width: 40px;
    		height: 50px;
    		border-radius: 7%;
    		position: relative;
			float: left;
			text-align : center;
			line-height: 2.5em;			
			margin-top: 0.7em;
		}
		
		.question {		
			width: 100%;
   			background-color: #fffae7;
   			line-height: 1.5em;
			margin-top: 0.4em;
		    min-height: 50px;
		    min-width: 100%;
		    border-radius: 1%;
		    position: relative;
			float: left;
			text-align : left;
			margin-top: 0.7em;
		}
	</style>
  </head>

  <body onload="count();">
  
  <!-- 
  <div style="padding:20px;">
    <button onclick="launchFullscreen(document.documentElement);" class="sexyButton">Launch Fullscreen</button>
    <button onclick="cancelFullscreen();" class="sexyButton">Hide Fullscreen</button>
  </div>
   -->
		
		
  <div id="container_body">
    <%
    AdminDetailDto adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
    ExamDetailsDto examDetailsDto = (ExamDetailsDto) request.getSession().getAttribute("examDetailsDto");	
    
    Map<String, List<ExamQuestionDetailsDto>> questionDetailsDtoMap = new HashMap<String, List<ExamQuestionDetailsDto>>();
    questionDetailsDtoMap = (Map<String, List<ExamQuestionDetailsDto>>) request.getSession().getAttribute("studentExamDetails");
    Integer total_question = 0;
    List<ExamQuestionDetailsDto> dtoList = new ArrayList<ExamQuestionDetailsDto>();
    if(questionDetailsDtoMap != null && questionDetailsDtoMap.size()>0) {
    	for(String key2 : questionDetailsDtoMap.keySet()) {
			dtoList = questionDetailsDtoMap.get(key2);
			total_question = total_question+dtoList.size();
    	}   	
    }
    
    Integer all_section_size = questionDetailsDtoMap.size();
    %>
    <input name="all_section_size" id="all_section_size" value="<%=all_section_size%>" type="hidden"/>
    
    <table width="100%">
    	<tr>
    		<td width="1%"></td>
    		<td width="84%"><img alt="Xamdesk" src="images/logo.png" style="width: 230px; height: 60px; position: fixed; border: 2px solid #ffffff; border-top-color: #032947; min-height: 20px;  background: #032947; -webkit-box-shadow: 1px 1px 15px 0px rgba(0,0,0,0.75); -moz-box-shadow: 1px 1px 15px 0px rgba(0,0,0,0.75); -ms-box-shadow: 1px 1px 15px 0px rgba(0,0,0,0.75); -o-box-shadow: 1px 1px 15px 0px rgba(0,0,0,0.75); box-shadow: 1px 1px 15px 0px rgba(0,0,0,0.75); padding-left: 10px; padding-right: 10px; top: 0px; font-weight: bold;"/></td>
    		<td width="15%"><div id="top_timer" style="color: #ffffff; position: fixed; border: 2px solid #ffffff; border-top-color: #032947; min-height: 20px; background: #032947; -webkit-box-shadow: 1px 1px 15px 0px rgba(0,0,0,0.75); -moz-box-shadow: 1px 1px 15px 0px rgba(0,0,0,0.75); -ms-box-shadow: 1px 1px 15px 0px rgba(0,0,0,0.75); -o-box-shadow: 1px 1px 15px 0px rgba(0,0,0,0.75); box-shadow: 1px 1px 15px 0px rgba(0,0,0,0.75); padding-left: 10px; padding-right: 10px; top: 0px; font-weight: bold;" align="center">Time Left<br/><div id="hms" style="font-size: 35px; "><%=examDetailsDto.getOdt_exam_time()%>:00</div></div></td>
    	</tr>
    </table>
    
    <table width="100%" style="margin-top: 65px;">
   		<tr>
   			<td width="2%"></td>
   			<td width="76%"><div id="current_date" style="font-weight: bold;"></div></td>
    		<td width="20%" style="font-weight: bold; font-size: 18px;" align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Total Question : <%=total_question%></td>
    		<td width="2%"></td>
    	</tr>
    </table>
    
    <form action="saveUserResultDetails" id="saveUserResultDetails" name="saveUserResultDetails" method="post">
    <table width="100%">
    	<tr>
    		<td width="2%"></td>
    		<td width="55%"><div style="font-weight: bold; font-size: 18px; color: #410303;">Hello <%=adminDetailDto.getIstr_user_name()%> ( <%=adminDetailDto.getIstr_login_id() %> )</div></td>
    		<td width="2%" align="right"><div class="left"></div></td>
    		<td width="7%" style="font-weight: bold;" align="left">Un-attempted</td>
    		<td width="2%" align="right"><div class="completed"></div></td>
    		<td width="6%" style="font-weight: bold;" align="left">Completed</td>
    		<td width="2%" align="right"><div class="reminder"></div></td>
    		<td width="6%" style="font-weight: bold;" align="left">Reminder</td>
    		<td width="2%"></td>
    	</tr>
    </table>
       
	<div id="container_top">
		    		
		<br/>
		<centre>
		<table width="100%" style="color: #ffffff;">
		<tr>
		<td width="5%">
		</td>
		<td width="30%">
		
		<table width="100%" style="color: #ffffff;">
		<tr>
		    <td width="20%">&nbsp;</td>
		    
		    <td width="30%">Section :</td>
		    <td width="50%">
		    <div class="styled-select2">
		    <select name="istr_section_id" id="istr_section_id" style="width: 190px; height: 25px; background-color: lightgrey;" onchange="changeExamSection();">
		    <%
		    Integer key_status = 1;
		    for(String key2 : questionDetailsDtoMap.keySet()) {
    						
		    	dtoList = questionDetailsDtoMap.get(key2);
		    	if(key_status.equals(1)) {
		    		%><option value="SECTION<%=key_status%>" selected="selected"><%=key2%></option><% 
		    	} else {
		    		%><option value="SECTION<%=key_status%>"><%=key2%></option><%	
		    	}
		    	key_status++;
		    }
		    %>	    			
		    </select>
		 	</div>
			</td>  
		    
		    <td width="5%">&nbsp;</td>				    			
		    </tr>
		    </table>
		    </td>
		    
		    <td width="65%">
		    <%
		    Integer key_sta = 1;
		    for(String key2 : questionDetailsDtoMap.keySet()) {
    						
		    	dtoList = questionDetailsDtoMap.get(key2);
		    	if(key_sta.equals(1)) {
		    		%>
		    		<div id="SECTION<%=key_sta%>">
		    		<table width="100%" style="color: #ffffff;">
		    		<tr>
		    		<td width="10%"></td>
		    		
		    		<td width="50%">Section Name : <%=key2%></td>   			
		    			
		    		<td width="5%">&nbsp;</td>
		    
		    		<td width="35%">Total Question : <%=dtoList.size()%></td>
		    		</tr>
					</table>		 
		    		</div>  		
		    		<% 
		    	} else {
		    		%>
		    		<div id="SECTION<%=key_sta%>" style="display: none;">
		    		<table width="100%" style="color: #ffffff;">
		    		<tr>
		    		<td width="10%"></td>
		    		
		    		<td width="50%">Section Name : <%=key2%></td>   			
		    			
		    		<td width="5%">&nbsp;</td>
		    
		    		<td width="35%">Total Question : <%=dtoList.size()%></td>
		    		</tr>
					</table>
		    		</div>  		
		    		<%	
		    	}
		    	key_sta++;
		    }
		    %>
		    </td>
		    </tr>
		    </table>		   			
		<br/>
		</centre>
	</div>
    
    <%
    Integer status = 1;
    Integer keyId = 1;
    if(questionDetailsDtoMap != null && questionDetailsDtoMap.size()>0) {
    	for(String key : questionDetailsDtoMap.keySet()) {
    		
    		dtoList = questionDetailsDtoMap.get(key);
    		if(status.equals(1)) {
    		%>    		
    			<div id="BODY<%=status%>">
    		<%
    		} else {%>
    			<div id="BODY<%=status%>" style="display: none;">
    	  <%}%>
    		
    		
		    <div id="container">
		    	<div class="item1">
		    	<div id="tableContainer" class="tableContainer">
		    	<table border="0" cellpadding="0" cellspacing="0" width="100%" class="scrollTable">
		    	<thead class="fixedHeader">
		    	<tr>
		    		<th style="background-color: lightgrey;" aligh="left">Question</th>
		    	</tr>
		    	</thead>
		    	<tbody class="scrollContent">
		    		<tr>
		    			<td style="height: 5px;"></td>
		    		</tr>
		    		<%
		    		if(dtoList != null && dtoList.size()>0) {
		    			for(int j = 1; j<=dtoList.size(); j++) {
		    			%>	
		    			<tr>
		    				<td align="center" height="10px;" id="asidebar<%=keyId%><%=j-1%>" onclick="current('<%=j-1%>', '<%=keyId%>')" style="cursor:pointer; background-color: #cfd5d2; border: 2px solid transparent; border-radius: 10px; color: #000; min-height: 12px; text-align: center; margin-top: 10px; line-height: 1.5em; margin-top: 0.4em;">
		    				 Question <%=j%></td>
		    			</tr>
		    			<tr>
		    				<td style="height: 5px;"></td>
		    			</tr>	
		    			<%
		    			}	    			
		    		}    		
		    		%>    	
		    	</tbody>
		    	</table>
		    	</div>
		    	</div>
		    	
		    	<div class="item2">
		    	<%
		    	if(dtoList != null && dtoList.size()>0) {
		    		int j = dtoList.size()-1;
		    		for(int i = 0; i<dtoList.size(); i++) {
		    			QuestionDetailsDto dto = new QuestionDetailsDto();
		    			dto = dtoList.get(i).getQuestionDetailsDto();
		    			%>
		    			<div id="page<%=keyId%><%=i%>" style="display: none;">
		    			<br/>
		    			<div id="container2">
		    			<center>
		    				<%
							if(dto != null) {
								if(dto.getSectionDetailsDto().getInum_is_paragraph().equals(1)) { %>
						    			<div style="width: 45%; float: left;">
						    			<table width="100%" border="0">
						    				<tr>
						    					<td colspan="4" style="font-size: 15px;"><div style="text-align: justify; margin-left: 5px; margin-right: 5px;"><%=dto.getSectionDetailsDto().getParagraphDetailsDto().getOstr_paragraph_descriprion()%></div></td>
						    				</tr>
						    			</table>
						    			</div>
						    			<div style="width: 55%; float: right;">
						    			<table width="98%" border="0">
						    		<%} else {%>
						    			<div>
						    			<table width="70%" border="0">
						    		<%} %>					    			
					    				<tr>
					    					<td width="40px;" valign="top"><div class="bullet"><%=i+1%></div></td><td colspan="3" style="font-size: 15px; font-weight: bold;"><div class="question"><%=dto.getOstr_question()%>
					    					<br/>
					    					<%
											  if(dto != null){
												if(dto.getObl_question() != null){
													%><img id="blah_question" src='data:image/jpg;base64,<%= dto.getObl_question()%>' style="margin-left: 5px; margin-right: 5px; max-width: 98%; max-height: 98%;"/><%
												}
											 }
											 %>
											 </div>
											</td>
					    				</tr>
					    				<tr>
					    					<td colspan="4" height="10%">&nbsp;</td>
					    				</tr>
					    				<tr>
					    					<td colspan="4" style="font-weight: bold;">
					    						<input type="radio" name="answer<%=keyId%><%=i%>" value="1" id="radio<%=keyId%><%=i%>1" class="radio"  onclick="changeStatusAnswer('<%=i%>', '<%=keyId%>')"/>
												<label for="radio<%=keyId%><%=i%>1"><div style="margin-left: 3.25em;"><%=dto.getOstr_option1()%></div>
												<%if(dto != null){
														if(dto.getObl_option1() != null){%>
															<img id="blah_option1" src='data:image/jpg;base64,<%= dto.getObl_option1()%>' style="margin-left: 35px; max-width: 92%; max-height: 92%;"/><%
														}
												 }%>
												</label>
											</td>
					    				</tr>
					    				<tr>
					    					<td colspan="4" style="font-weight: bold;">
					    						<input type="radio" name="answer<%=keyId%><%=i%>" value="2" id="radio<%=keyId%><%=i%>2" class="radio"  onclick="changeStatusAnswer('<%=i%>', '<%=keyId%>')"/>
												<label for="radio<%=keyId%><%=i%>2"><div style="margin-left: 3.25em;"><%=dto.getOstr_option2()%></div>
												<%if(dto != null){
														if(dto.getObl_option2() != null){%>
															<img id="blah_option2" src='data:image/jpg;base64,<%= dto.getObl_option2()%>' style="margin-left: 35px; max-width: 92%; max-height: 92%;"/><%
														}
												 }%>
												</label>
											</td>
										</tr>
					    				<tr>
					    					<td colspan="4" style="font-weight: bold;">
					    						<input type="radio" name="answer<%=keyId%><%=i%>" value="3" id="radio<%=keyId%><%=i%>3" class="radio"  onclick="changeStatusAnswer('<%=i%>', '<%=keyId%>')"/>
												<label for="radio<%=keyId%><%=i%>3"><div style="margin-left: 3.25em;"><%=dto.getOstr_option3()%></div>
												<%if(dto != null){
														if(dto.getObl_option3() != null){%>
															<img id="blah_option3" src='data:image/jpg;base64,<%= dto.getObl_option3()%>' style="margin-left: 35px; max-width: 92%; max-height: 92%;"/><%
														}
												 }%>
												</label>
											</td>
					    				</tr>
					    				<tr>
					    					<td colspan="4" style="font-weight: bold;">
					    						<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio"  onclick="changeStatusAnswer('<%=i%>', '<%=keyId%>')"/>
												<label for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em;"><%=dto.getOstr_option4()%></div>
												<%if(dto != null){
														if(dto.getObl_option4() != null){%>
															<img id="blah_option4" src='data:image/jpg;base64,<%= dto.getObl_option4()%>' style="margin-left: 35px; max-width: 92%; max-height: 92%;"/><%
														}
												 }%>
												</label>
											</td>
					    				</tr>
					    				<%if(dto.getObl_option5() != null || dto.getOstr_option5() != "" || dto.getOstr_option5() != null){%>
					    				<tr>
					    					<td colspan="4" style="font-weight: bold;">
					    						<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>5" class="radio"  onclick="changeStatusAnswer('<%=i%>', '<%=keyId%>')"/>
												<label for="radio<%=keyId%><%=i%>5"><div style="margin-left: 3.25em;"><%=dto.getOstr_option5()%></div>
												<%if(dto != null){
														if(dto.getObl_option5() != null){%>
															<img id="blah_option5" src='data:image/jpg;base64,<%= dto.getObl_option5()%>' style="margin-left: 35px; max-width: 92%; max-height: 92%;"/><%
														}
												 }%>
												</label>
											</td>
					    				</tr>	
					    				<%} %>
					    				<tr>
					    					<td colspan="4" height="10%"><input type="hidden" name="selected<%=keyId%><%=i%>" id="selected<%=keyId%><%=i%>" value="0"></td>
					    				</tr>
					    			</table>
					    			</div>
					    	<%}%>
		    			</center>
		    		</div>
		    		
		    		<div style="margin-top: 10px; margin-left: 10px;">
		    		
					<hr style="width:95%; border-bottom:1px dotted  #CCCCCC;" />

		    		<table width="100%">
		    			<tr>
		    				<td width="5%"></td>	
		    				<td width="10%">
		    				<%if(i != 0) {%>
		    					<button type="button" onclick="prev('<%=i-1%>', '<%=keyId%>')" style="background-color: #DF7401" class="myButton">&nbsp;Previous&nbsp;</button>
		    				<%}%>
		    				</td>
		    				<td width="45%"></td>
		    				<td width="40%">
		    					<button type="button" onclick="resetButton('<%=i%>', '<%=keyId%>')" style="background-color: #DF7401" class="myButton">&nbsp;Reset&nbsp;</button>&nbsp;&nbsp;
		    					<button type="button" onclick="reminder('<%=i%>', '<%=keyId%>')" style="background-color: #DF7401"  class="myButton">&nbsp;Reminder&nbsp;</button>&nbsp;&nbsp;
		    					<%if(i != j) {%>
		    						<button type="button" onclick="next('<%=i+1%>', '<%=keyId%>')" style="background-color: #DF7401" class="myButton">&nbsp;&nbsp;&nbsp;Next&nbsp;&nbsp;&nbsp;</button>
		    					<%} else {
		    						  if(all_section_size.equals(keyId)) {%>
		    							<button type="button" onclick="finish()" style="background-color: #DF7401" class="myButton">&nbsp;&nbsp;&nbsp;Finish&nbsp;&nbsp;&nbsp;</button>
		    						<%} else {
		    							Integer keyIdInc = keyId+1;
		    							%>
		    							<button type="button" onclick="changeExamNo('<%=keyIdInc%>','0');" style="background-color: #DF7401" class="myButton">&nbsp;Next Section&nbsp;</button>
		    						<%}
		    					}%>
		    				</td>
		    			</tr>
		    		</table>
		    		<br/>
		    		</div>
		    		
		    	</div>
		    	<%
		    	}
		    }
		    %>
		    </div>
		    </div>
		    </div>
    	<%
    	keyId++;
    	status++;
		}
    }
    %>
    <div id="container_bottom">
    <div style="margin-left: 15px; margin-right: 15px;">
    <b style="color: #ffffff;">Question Palette :</b><br/>
    <%
    if(questionDetailsDtoMap != null && questionDetailsDtoMap.size()>0) {
    	List<ExamQuestionDetailsDto> dtoDetailsList = new ArrayList<ExamQuestionDetailsDto>();
    	
    	Integer qu_no = 1;
    	Integer ques_no = 1;
    	
    	for(String key : questionDetailsDtoMap.keySet()) {
    		dtoDetailsList = questionDetailsDtoMap.get(key);
    		int i = 0;
    		for(ExamQuestionDetailsDto qu_dto : dtoDetailsList) {
	   		%>	
	    		<div class="myBu" id="bottom_bar<%=qu_no%><%=i%>" onclick="changeExamNo('<%=qu_no%>','<%=i%>');"><%=ques_no%></div>
	   		<%
	   		i++;
	   		ques_no++;
    		}
    		qu_no++;
    	}	    			
    }    		
    %>
    </div>
    <br/>
    </div>
  </div> 
  
  <div id="finish-dialog-confirm" title="Finish the Exam?" style="display: none;">
  <p>These will be finish the examination.<br/> Are you sure?</p>
  </div>
  
  <div id="close-dialog-confirm" title="Finish the Exam?" style="display: none;">
  <p>These will be close the examination.<br/> Are you sure?</p>
  </div>
  <div id="dialog" title="Wait.." style="display: none;">
  	<div align="center">
			<img alt="" src="image/wait2.gif" width="50px" height="50px"><br/>
			Please wait while we are submitting your exam.....
	</div>
  </div>
  
  <input type="hidden" id="contextPath" value="<%=request.getContextPath() %>">
  </form>
  </div>	
  </body>
</html>
