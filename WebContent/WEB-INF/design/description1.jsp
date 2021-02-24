<%@page import="com.oes.dto.ExamSubCategoryDetailsDto"%>
<%@page import="com.oes.dto.ExamSectionDetailsDto"%>
<%@page import="com.oes.dto.ExamDetailsDto"%>
<%@page import="com.sms.admin.dto.AdminDetailDto"%>
<%@page import="com.oes.dto.ExamQuestionDetailsDto"%>
<%@page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="com.oes.dto.QuestionDetailsDto"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Xamdesk | Description</title>   
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
		var xMax = screen.width;
    	var yMax = screen.height;
    	
    	var myWindow = window.open('<%=request.getContextPath()%>/showOnlineExamTest', 'CNN_WindowName','toolbar=no, scrollbars=no, resizable=no, top=0, left=0,width='+xMax+',height='+yMax+'');
		
		var contextPath = $('#contextPath').val();
    	contextPath = contextPath+"/homepage";
    	window.location.href = contextPath;
	}
	function prev() {
		var contextPath = $('#contextPath').val();
    	contextPath = contextPath+"/homepage";
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
		    
		    Map<Integer, ExamSubCategoryDetailsDto> subCategoryMap = new HashMap<Integer, ExamSubCategoryDetailsDto> ();
		    subCategoryMap = (Map<Integer, ExamSubCategoryDetailsDto>) request.getSession().getAttribute("subCategoryMap");
		    
		
		%>
		<div id="container_page">
		<table width="100%">
			<tr>
	    		<td align="center"><img src="<%=examDetailsDto.getObl_exam_pic()%>" /></td>
	   		</tr>
	   		<tr>
	    		<td align="center" style="color: #ffffff; font-size: 25px;"><b><%=examDetailsDto.getOstr_exam_name()%></b></td>
	   		</tr>
	   		
	   		<tr>
	    		<td style="color: #ffffff; font-size: 20px;" align="center"><b>Instructions for the candidates & examination details</b></td>
	   		</tr>
	   		<tr>
	    		<td align="center"><hr/>&nbsp;</td>
	   		</tr>
	   		<tr>
	    		<td style="color: #ffffff; font-size: 18px;">
	    		<b>a) &nbsp;&nbsp;Total time duration for the exam is <%=examDetailsDto.getOdt_exam_time()%> (HH:MM).
	    		</b></td>
	   		</tr>
	   		<tr>
	    		<td style="color: #ffffff; font-size: 18px;">
	    		<b>b) &nbsp;&nbsp;There is no negative marking for the answer. So try to attempt all questions. 
	    		</b></td>
	   		</tr>
	   		<tr>
	    		<td style="color: #ffffff; font-size: 18px;">
	    		<b>c) &nbsp;&nbsp;You can choose the section as per your will from drop down menu on your question paper. 
	    		</b></td>
	   		</tr>
	   		<tr>
	    		<td style="color: #ffffff; font-size: 18px;">
	    		<b>d) &nbsp;&nbsp;You can leave the exam whenever you want. Just go to last question of the last section there you will find finish button. 
	    		</b></td>
	   		</tr>
	   		<tr>
	    		<td align="center">&nbsp;</td>
	   		</tr>
	    </table>
		
	   <table width="100%">
			<tr>
	    		<td align="center" style="color: #ffffff; font-size: 25px;"><b></b></td>
	   		</tr>
	   		<tr>
	    		<td align="center"><hr/></td>
	   		</tr>
	    </table>
	    
	    <div  align="center">
	    <table width="85%" border="0">
			<tr>
	    		<td align="left" style="color: #ffffff; font-size: 16px; font-weight: bold; height: 40px;" colspan="1">Exam Name - <b><%=examDetailsDto.getOstr_exam_name()%></b></td>
	    		<td align="left" style="color: #ffffff; font-size: 16px; font-weight: bold; height: 40px;" colspan="1">Total Questions - <%=total_question%></td>
	   			<td align="left" style="color: #ffffff; font-size: 16px; font-weight: bold; height: 40px;" colspan="1">Time - <%=examDetailsDto.getOdt_exam_time()%> (HH:MM)</td>
	   		</tr>
	   		
	   	</table>
	   	</div>
	   	<br/><br/>
	   	<table style="border-collapse: collapse;" width="100%" border="1">
	   		<tr>
	    		<th align="center" colspan="4" style="background: #333; border: 1px solid #ccc; color: white; font-weight: bold; height: 40px;">Section Details</th>
	   		</tr>
	   		<tr>
	    		<th align="center" style="background: #333; border: 1px solid #ccc; color: white; font-weight: bold; height: 40px;">Sl No.</th>
	    		<th align="center" style="background: #333; border: 1px solid #ccc; color: white; font-weight: bold; height: 40px;">Section Name</th>
	    		<th align="center" style="background: #333; border: 1px solid #ccc; color: white; font-weight: bold; height: 40px;">Total Question</th>
	    		<th align="center" style="background: #333; border: 1px solid #ccc; color: white; font-weight: bold; height: 40px;">Total Mark</th>
	   		</tr>
	   		<%
	   		if(subCategoryMap != null && subCategoryMap.size()>0) {
	   			int i = 1;
	   			ExamSubCategoryDetailsDto dto = new ExamSubCategoryDetailsDto();
   				for(Integer subCategoryId: subCategoryMap.keySet()) {   					
   					dto = subCategoryMap.get(subCategoryId);
	   				%>
			   		<tr>
			    		<td style="padding: 6px; background : #B3CBD6; border: 2px solid #ccc; border-color: #000000; text-align: left; font-size: 16px;"><div align="center"><%=i%></div></td>
			    		<td style="padding: 6px; background : #B3CBD6; border: 2px solid #ccc; border-color: #000000;  text-align: left; color: #00000; font-size: 16px;"><div style="color: #00000; font-size: 12px; font-weight: bold;"><%=dto.getSubCategoryDetailsDto().getOstr_sub_category_name() %></div></td>
			    		<td style="padding: 6px; background : #B3CBD6; border: 2px solid #ccc; border-color: #000000;  text-align: left; color: #00000; font-size: 16px;"><div align="center" style="color: #00000; font-size: 12px; font-weight: bold;"><%=dto.getOnum_total_question()%></div></td>
			    		<td style="padding: 6px; background : #B3CBD6; border: 2px solid #ccc; border-color: #000000;  text-align: left; color: #00000; font-size: 16px;"><div align="center" style="color: #00000; font-size: 12px; font-weight: bold;"><%=dto.getOnum_total_marks()%></div></td>
			   		</tr>
	   				<%
	   				i++;
	   			}
	   		}
	   		%>
	   		<tr>
	    		<td colspan="4"  style="padding: 6px; background : #B3CBD6; border: 1px solid #ccc; text-align: left; text-align: justify;"><br/>
	    		<b>Description : </b><%=examDetailsDto.getOstr_exam_description()%><br/></td>
	   		</tr>
	    </table>
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
	    <td width="10%" align="right"><button onclick="next()" style="background-color: #DF7401" class="myButton">Start Exam</button></td>
	    <td width="10%"></td>
	    </tr>
	    <tr><td colspan="5"><hr/></td></tr>
	    </table>	    
		<input type="hidden" id="contextPath" value="<%=request.getContextPath() %>">	    
  </body>
</html>
