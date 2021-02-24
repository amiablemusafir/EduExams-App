<!-- 
Author: Sumit Singh
Start Date: 27th March, 2014
Modify Date:
Modify By:
Motive: Student Result List
 -->
<%@page import="com.oes.dto.ResultDescriptionDto"%>
<%@page import="com.oes.dto.QuestionDetailsDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.oes.dto.ExamQuestionDetailsDto"%>
<%@page import="java.util.List"%>
<%@page import="com.oes.dto.ExamDetailsDto"%>
<%@page import="com.sms.admin.dto.AdminDetailDto"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.oes.dto.ResultReviewSubjectDto"%>
<%@page import="java.util.Map"%>
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
	function printResultDetails() {
		
		var divToPrint = document.getElementById('page-wrap');
		var popupWin = window.open('', '_blank', 'width=900,height=600');
		popupWin.document.open();
		popupWin.document.write('<html><link href="style/dms.css" rel="stylesheet"><link href="style/dms_form.css" rel="stylesheet"><body onload="window.print()">' + divToPrint.innerHTML + '</html>');
		popupWin.document.close();
			
	}
	function closeResultDetails(id) {
		document.getElementById("homepage").submit();
	}
	
	
	
	function showParagraph1(i) {
		$("#showparagraph1"+i).show();
	}
	function hideParagraph1(i) {
		$("#showparagraph1"+i).hide();
	}
	
	function showParagraph2(i) {
		$("#showparagraph2"+i).show();
	}
	function hideParagraph2(i) {
		$("#showparagraph2"+i).hide();
	}
	
	function showParagraph3(i) {
		$("#showparagraph3"+i).show();
	}
	function hideParagraph3(i) {
		$("#showparagraph3"+i).hide();
	}	

	function showParagraph4(i) {
		$("#showparagraph4"+i).show();
	}
	function hideParagraph4(i) {
		$("#showparagraph4"+i).hide();
	}	
	
	
	var current_page = 1;
	function changeExamSection(num) {
		
		$("#page_error").html("");
		var section_all = $("#section_all"+num).val();
		
		var page_status_bar = $("#page_status_bar"+section_all).val();
		if(page_status_bar == 1) {
			if(current_page != section_all) {
				$("#pageDetails"+section_all).show();
				$("#pageDetails"+current_page).hide();
				current_page = section_all;
			}
		} else {
			$("#section_all"+num).val(num);
			$("#page_error").html("We didn't find any data for selected category");
		}
	}
	
	
	var current_question = 1;
	function prev(i) {
		
		current_question = i;
		$("#BODY"+i).show();
		i = parseInt(i)+1;
		$("#BODY"+i).hide();
	}
	
	function next(i) {
		
		current_question = i;
		$("#BODY"+i).show();
		i = parseInt(i)-1;		
		$("#BODY"+i).hide();
	}
	
	function changeExamNo(i) {
		if(i != current_question) {
			$("#BODY"+i).show();
			$("#BODY"+current_question).hide();
			current_question = i;
		}
	}
	
	
	var current_question_CORRECT_ANSWER = 1;
	function prev_CORRECT_ANSWER(i) {
		
		current_question_CORRECT_ANSWER = i;
		$("#BODY_CORRECT_ANSWER"+i).show();
		i = parseInt(i)+1;
		$("#BODY_CORRECT_ANSWER"+i).hide();
	}
	
	function next_CORRECT_ANSWER(i) {
		
		current_question_CORRECT_ANSWER = i;
		$("#BODY_CORRECT_ANSWER"+i).show();
		i = parseInt(i)-1;		
		$("#BODY_CORRECT_ANSWER"+i).hide();
	}
	
	function changeExamNo_CORRECT_ANSWER(i) {
		if(i != current_question_CORRECT_ANSWER) {
			$("#BODY_CORRECT_ANSWER"+i).show();
			$("#BODY_CORRECT_ANSWER"+current_question_CORRECT_ANSWER).hide();
			current_question_CORRECT_ANSWER = i;
		}
	}
	

	
	var current_question_INCORRECT_ANSWER = 1;
	function prev_INCORRECT_ANSWER(i) {
		
		current_question_INCORRECT_ANSWER = i;
		$("#BODY_INCORRECT_ANSWER"+i).show();
		i = parseInt(i)+1;
		$("#BODY_INCORRECT_ANSWER"+i).hide();
	}
	
	function next_INCORRECT_ANSWER(i) {
		
		current_question_INCORRECT_ANSWER = i;
		$("#BODY_INCORRECT_ANSWER"+i).show();
		i = parseInt(i)-1;		
		$("#BODY_INCORRECT_ANSWER"+i).hide();
	}
	
	function changeExamNo_INCORRECT_ANSWER(i) {
		if(i != current_question_INCORRECT_ANSWER) {
			$("#BODY_INCORRECT_ANSWER"+i).show();
			$("#BODY_INCORRECT_ANSWER"+current_question_INCORRECT_ANSWER).hide();
			current_question_INCORRECT_ANSWER = i;
		}
	}
	
	var current_question_UNATTEMPTED_ANSWER = 1;
	function prev_UNATTEMPTED_ANSWER(i) {
		
		current_question_UNATTEMPTED_ANSWER = i;
		$("#BODY_UNATTEMPTED_ANSWER"+i).show();
		i = parseInt(i)+1;
		$("#BODY_UNATTEMPTED_ANSWER"+i).hide();
	}
	
	function next_UNATTEMPTED_ANSWER(i) {
		
		current_question_UNATTEMPTED_ANSWER = i;
		$("#BODY_UNATTEMPTED_ANSWER"+i).show();
		i = parseInt(i)-1;		
		$("#BODY_UNATTEMPTED_ANSWER"+i).hide();
	}
	
	function changeExamNo_UNATTEMPTED_ANSWER(i) {
		if(i != current_question_UNATTEMPTED_ANSWER) {
			$("#BODY_UNATTEMPTED_ANSWER"+i).show();
			$("#BODY_UNATTEMPTED_ANSWER"+current_question_UNATTEMPTED_ANSWER).hide();
			current_question_UNATTEMPTED_ANSWER = i;
		}
	}
</script>
<style type="text/css">
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
			height: auto;			
		}
		
		#container2 {
			width: 100%;
			min-height: 310px;
			overflow-y: scroll;
			background-color: #eee;
		}	
		.item1 {
			width: 20%;	
			overflow: hidden;
			height: 400px;
			overflow-y: scroll;
			float: left;
			background-color: #eee;
			-webkit-box-shadow: 1px 1px 15px 0px rgba(0,0,0,0.75);
			-moz-box-shadow: 1px 1px 15px 0px rgba(0,0,0,0.75);
			-ms-box-shadow: 1px 1px 15px 0px rgba(0,0,0,0.75);
			-o-box-shadow: 1px 1px 15px 0px rgba(0,0,0,0.75);
			box-shadow: 1px 1px 15px 0px rgba(0,0,0,0.75);
			margin: .0em 2em;
			border-radius: 2%;
		    border:1px solid #ffffff;
		}
				
		.item2 {
			width: 75%;
			float: left;
			background-color: #eee;
			-webkit-box-shadow: 1px 1px 15px 0px rgba(0,0,0,0.75);
			-moz-box-shadow: 1px 1px 15px 0px rgba(0,0,0,0.75);
			-ms-box-shadow: 1px 1px 15px 0px rgba(0,0,0,0.75);
			-o-box-shadow: 1px 1px 15px 0px rgba(0,0,0,0.75);
			box-shadow: 1px 1px 15px 0px rgba(0,0,0,0.75);
			margin: .0em .0em;
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
		
		.myBuWrong {
			font-size: 16px;
			cursor:pointer;
			text-shadow:0px 1px 0px #854629;
			text-align: center;
			padding-top: 5px;
		    display: inline-block;
		    margin-left: 3px;
		    margin-top: 3px;
		    height: 25px;
		    width:30px;
		    border-radius: 20%;
		    background-color: #fd6049;
		    border:2px solid #ffffff;	   
		}
		
		.myBuRight {
			font-size: 16px;
			cursor:pointer;
			text-shadow:0px 1px 0px #854629;
			text-align: center;
			padding-top: 5px;
		    display: inline-block;
		    margin-left: 3px;
		    margin-top: 3px;
		    height: 25px;
		    width:30px;
		    border-radius: 20%;
		    background-color: #6dc30b;
		    border:2px solid #ffffff;	   
		}
	
		.myBuNormal {
			font-size: 16px;
			cursor:pointer;
			text-shadow:0px 1px 0px #854629;
			text-align: center;
			padding-top: 5px;
		    display: inline-block;
		    margin-left: 3px;
		    margin-top: 3px;
		    height: 25px;
		    width:30px;
		    border-radius: 20%;
		    background-color: #bfbfbf;
		    border:2px solid #ffffff;	   
		}
		
		
		.myBuWrongSmall {
			font-size: 16px;
			cursor:pointer;
			text-shadow:0px 1px 0px #854629;
			text-align: center;
			padding-top: 5px;
		    display: inline-block;
		    margin-left: 3px;
		    margin-top: 3px;
		    height: 10px;
		    width: 15px;
		    border-radius: 20%;
		    background-color: #fd6049;
		    border:2px solid #ffffff;	   
		}
		
		.myBuRightSmall {
			font-size: 16px;
			cursor:pointer;
			text-shadow:0px 1px 0px #854629;
			text-align: center;
			padding-top: 5px;
		    display: inline-block;
		    margin-left: 3px;
		    margin-top: 3px;
		    height: 10px;
		    width: 15px;
		    border-radius: 20%;
		    background-color: #6dc30b;
		    border:2px solid #ffffff;	   
		}
	
		.myBuNormalSmall {
			font-size: 16px;
			cursor:pointer;
			text-shadow:0px 1px 0px #854629;
			text-align: center;
			padding-top: 5px;
		    display: inline-block;
		    margin-left: 3px;
		    margin-top: 3px;
		    height: 10px;
		    width: 15px;
		    border-radius: 20%;
		    background-color: #bfbfbf;
		    border:2px solid #ffffff;	   
		}
		
		
		.bullet {
    		background-color: #34495e;
    		color: #fff;
    		width: 40px;
    		height: 55px;
    		border-radius: 7%;
    		position: relative;
			float: left;
			text-align : center;
			line-height: 2.5em;			
			margin-top: 0.5em;
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
			margin-top: 0.5em;
		}
		
		.correctanswer {		
			width: 100%;
   			background-color: #6dc30b;
   			line-height: 1.5em;
			margin-top: 0.4em;
		    min-height: 50px;
		    min-width: 100%;
		    border-radius: 5%;
		    position: relative;
			float: left;
			text-align : left;
			margin-top: 0.7em;
		}
		
		.normalanswer {		
			width: 100%;
   			background-color: #bfbfbf;
   			line-height: 1.5em;
			margin-top: 0.4em;
		    min-height: 50px;
		    min-width: 100%;
		    border-radius: 5%;
		    position: relative;
		    margin-left: 3.25em;
			float: left;
			text-align : left;
			margin-top: 0.7em;
		}
		.wronganswer {		
			width: 100%;
   			background-color: #fd6049;
   			line-height: 1.5em;
			margin-top: 0.4em;
		    min-height: 50px;
		    min-width: 100%;
		    border-radius: 5%;
		    position: relative;
			float: left;
			text-align : left;
			margin-top: 0.7em;
		}
		.label_normal {
		    width: 100%;
		    border-radius: 3px;
		    border: 1px solid #D1D3D4;
		    background-color: #bfbfbf;
		}
		.label_right {
		    width: 100%;
		    border-radius: 3px;
		    border: 1px solid #D1D3D4;
		    background-color: #6dc30b;
		}
		.label_wrong {
		    width: 100%;
		    border-radius: 3px;
		    border: 1px solid #D1D3D4;
		    background-color: #fd6049;
		}
		/* hide input */
		input.radio:empty {
			margin-left: -999px;
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
		
	</style>
<body>
<div id="page-wrap">
<div class="grid_10">
	<div class="box round first grid">
    <h2>Review</h2>
    ${info}
	<s:form action="homepage" name="homepage" id="homepage" method="post">
	<s:hidden name="randomStingJsp" id="randomStingJsp"/>
	</s:form>
	<br/>
	<div align="center">
	<table width="90%" style="border-collapse: collapse;">
	<tr>
		<td width="33%" align="left"><div class="stat-col"><span>Course</span></div></td>
		<td width="34%%" align="left"><div class="stat-col"><span>Examination</span></div></td>
		<td width="33%" align="left"><div class="stat-col"><span>Date</span></div></td>
	</tr>
	<tr>
		<td width="33%" align="center" style="color: #ffffff; padding: 6px; border: 0px solid #eee; height: 25px; font-size: 14px; font-weight: bold; background-color: #ffb400; background-image: -webkit-gradient(linear, left top, left bottom, from(#ffc22e), to(#d19400)); background-image: -webkit-linear-gradient(top, #ffc22e, #d19400);"><s:property value="resultDetailsDto.examDetailsDto.courseDetailsDto.ostr_course_name"/></td>
		<td width="34%%" align="center" style="color: #ffffff; padding: 6px; border: 0px solid #eee; height: 25px; font-size: 14px; font-weight: bold; background-color: #47196e; background: -webkit-gradient(linear, left top, left bottom, from(#a072c7), to(#47196e)); background: -webkit-linear-gradient(top, #a072c7, #47196e);"><s:property value="resultDetailsDto.examDetailsDto.ostr_exam_name"/></td>
		<td width="33%" align="center" style="color: #ffffff; padding: 6px; border: 0px solid #eee; height: 25px; font-size: 14px; font-weight: bold;background-color: #5c8000; background-image: -webkit-gradient(linear, left top, left bottom, from(#a3c747), to(#5c8000)); background-image: -webkit-linear-gradient(top, #a3c747, #5c8000);"><s:property value="resultDetailsDto.ostr_date"/></td>
	</tr>
	</table>
	
	<table width="auto">
	<tr>
	<td>
	<table width="100%">
	<s:if test="resultDetailsDto.onum_rank == 0">
	<tr>
		<td>
			<div align="center">
				<b style="font-weight: bold; font-size: 14px;">Your score card will be generate at the end of the month.</b>
			</div>
		</td>
	</tr>
	</s:if>
	<s:else>
	<tr>
		<td>
			<div align="center">
				<b style="font-weight: bold; font-size: 16px;">Score Card : <s:property value="resultDetailsDto.onum_rank"/></b>
			</div>
		</td>
	</tr>
	<tr><td>&nbsp;</td></tr>
	<tr><td><div align="center" style="font-style: italic;"><b>Note :</b> The above score card is generated on the basis of month in which you took the exam.</div></td></tr>
	
	</s:else>
	</table>
	
	<div class="stat-col">
        <span>Questions</span>
        
        <p class="purple"><img src="img/icon-question.png" alt="" />&nbsp;<s:property value="resultDetailsDto.onum_total_question"/></p>
    </div>

    <div class="stat-col">
		<span>Accuracy</span>
		<p class="yellow"><img src="img/icon-accuracy.png" alt="" />&nbsp;<s:property value="resultDetailsDto.odec_accuracy"/>%</p>
	</div>

    <div class="stat-col">
        <span>Correct</span>
        <p class="green"><img src="img/icon-correct.png" alt="" />&nbsp;<s:property value="resultDetailsDto.onum_wright"/></p>
    </div>

    <div class="stat-col">
        <span>Wrong</span>
        <p class="red"><img src="img/icon-wrong.png" alt="" />&nbsp;<s:property value="resultDetailsDto.onum_wrong"/></p>
    </div>

    <div class="stat-col">
        <span>Unattempted</span>
        <p class="blue"><img src="img/icon-unattempted.png" alt="" />&nbsp;<s:property value="resultDetailsDto.onum_left"/></p>
    </div>

    <div class="stat-col">
        <span>Total Score</span>
        <p class="purple"><img src="img/icon-total-score.png" alt="" />&nbsp;<s:property value="resultDetailsDto.odec_total_obtain_mark"/></p>
    </div>

    <div class="stat-col last">
        <span>Negative Score</span>
        <p class="darkblue"><img src="img/icon-negative-score.png" alt="" />&nbsp;<s:property value="resultDetailsDto.odec_total_negative_mark"/></p>
    </div>

    <div class="clear"></div>
    </td>
    <tr>   
    </table> 
    </div>
	</div>
</div>


<%
Map<Integer, ResultReviewSubjectDto> subjectMapDetails = new HashMap<Integer, ResultReviewSubjectDto>();
subjectMapDetails = (HashMap<Integer, ResultReviewSubjectDto>) request.getSession().getAttribute("subjectMapDetails");

if(subjectMapDetails != null && subjectMapDetails.size()>0) {
%>
<div class="grid_10">
<div class="box round first grid">

    <h2>Subject Analysis</h2><br/>
	<div align="center">
		<table width="100%" style="border-collapse: collapse;">
		<tr style="background: #eee;">
			<th width="40%" style="background: #333; height: 30px; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left; font-size: 14px; font-weight: bold;">SUBJECT</th>
			<th width="15%" style="background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left; font-size: 14px; font-weight: bold;">TOTAL QUESTION</th>
			<th width="15%" style="background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left; font-size: 14px; font-weight: bold;">CORRECT</th>
			<th width="15%" style="background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left; font-size: 14px; font-weight: bold;">WRONG</th>
			<th width="15%" style="background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left; font-size: 14px; font-weight: bold;">UNATTEMPTED</th>
		</tr>
		<%for(Integer number : subjectMapDetails.keySet()) {
			ResultReviewSubjectDto resultReviewSubjectDto = new ResultReviewSubjectDto();
			resultReviewSubjectDto = subjectMapDetails.get(number);%>
			<tr style="background: #eee;">
			<td align="left" style="padding: 6px; border: 1px solid #ccc; height: 25px; font-size: 14px; font-weight: bold;"><%=resultReviewSubjectDto.getSectionDetailsDto().getSubCategoryDetailsDto().getOstr_sub_category_name()%></td>
			<td align="center" style="padding: 6px; border: 1px solid #ccc; height: 25px; font-size: 14px; font-weight: bold;"><%=resultReviewSubjectDto.getTotal_question()%></td>
			<td align="center" style="padding: 6px; border: 1px solid #ccc; height: 25px; font-size: 14px; font-weight: bold;"><%=resultReviewSubjectDto.getTotal_right()%></td>
			<td align="center" style="padding: 6px; border: 1px solid #ccc; height: 25px; font-size: 14px; font-weight: bold;"><%=resultReviewSubjectDto.getTotal_wrong()%></td>
			<td align="center" style="padding: 6px; border: 1px solid #ccc; height: 25px; font-size: 14px; font-weight: bold;"><%=resultReviewSubjectDto.getTotal_left()%></td>	
			</tr>
		<%}
		%>
		</table>
	</div>	
</div>
</div>
<%
}
List<ResultDescriptionDto> resultDescriptionDtoList = new ArrayList<ResultDescriptionDto>();
resultDescriptionDtoList = (ArrayList<ResultDescriptionDto>) request.getSession().getAttribute("resultDescriptionDtoList");

Integer all_section_size = resultDescriptionDtoList.size();
Integer status = 1;
Integer keyId = 1;
Integer i = 0;
Integer page_status = 0;
%>

<div id="page_error" align="center" style="font-weight: bold; color: #ffffff; font-size: 14px;"></div>

<div id="pageDetails1">
<div class="grid_10">
<div class="box round first grid">
<h2>Review Examination</h2><br/><br/>
<div id="container">
<%
    if(resultDescriptionDtoList != null && resultDescriptionDtoList.size()>0) {
    	  for(ResultDescriptionDto decDto : resultDescriptionDtoList) {
    		 page_status = 1;
    		 if(status.equals(1)) {%>    		
  				<div id="BODY<%=status%>">
  			<%} else {%>
  				<div id="BODY<%=status%>" style="display: none;">
  	    	<%}%>
  	  		   <div class="item2">
					<div id="page<%=i%>"><br/>
						<div id="container2">
    		  			<%
						if(decDto != null) {
							if(1 == 1) {%>
							<div align="center">
							<%
							if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getSectionDetailsDto().getInum_is_paragraph().equals(1)) { %>
							<a onclick="showParagraph1('<%=i%>');" style="cursor:pointer;">Show Paragraph</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a onclick="hideParagraph1('<%=i%>');" style="cursor:pointer;">Hide Paragraph</a>
							<div id="showparagraph1<%=i%>" style="display: none;">
							<table width="95%" border="0">
						    <tr>
						    	<td colspan="4" style="font-size: 15px;"><div style="text-align: justify; margin-left: 5px; margin-right: 5px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getSectionDetailsDto().getParagraphDetailsDto().getOstr_paragraph_descriprion()%></div></td>
						    </tr>
						    </table>
						    </div>
						    
						    <%}%>
							<table width="95%" border="0">
							<tr>
								<td width="40px;" valign="top" style="font-size: 18px; font-weight: bold;"><div class="bullet"><%=i+1%></div></td><td colspan="3" style="font-size: 14px; font-weight: bold;"><div class="question"><div style="padding: 15px 15px 15px 15px;">
								<%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_question()%>
								<%
								if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_question() != null){
									%><br/><img id="blah_question" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_question()%>' style="max-width: 100%; max-height: 100%; margin-left: 5px;"/><%
								}%>
								</div></div></td>
							</tr>
							</table>
							</div>
							<%if(decDto.getOnum_selected_option() == null) {%>
								<table width="90%" border="0" style="margin-left: 3.25em;">
								<tr>
									<td style="font-weight: bold;">
									<input type="radio" name="answer<%=i%>" value="1" id="radio<%=keyId%><%=i%>1" class="radio" disabled="disabled"/>
									<label class="label_normal" for="radio<%=i%>1"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option1()%></div>
									<%
									if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option1() != null){%>
										<img id="blah_option1" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option1()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
									}
									%>
									</label></td>
								</tr>
								<tr>
									<td style="font-weight: bold;">
									<input type="radio" name="answer<%=i%>" value="2" id="radio<%=keyId%><%=i%>2" class="radio" disabled="disabled"/>
									<label class="label_normal" for="radio<%=i%>2"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option2()%></div>
									<%
									if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option2() != null){%>
										<img id="blah_option2" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option2()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
									}
									%>
									</label>
									</td>
								</tr>
								<tr>
									<td style="font-weight: bold;">
									<input type="radio" name="answer<%=i%>" value="3" id="radio<%=keyId%><%=i%>3" class="radio" disabled="disabled"/>
									<label class="label_normal" for="radio<%=i%>3"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option3()%></div>
									<%
									if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option3() != null){%>
										<img id="blah_option3" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option3()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
									}
									%>
									</label>
									</td>
								</tr>
								<tr>
									<td style="font-weight: bold;">
									<input type="radio" name="answer<%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
									<label class="label_normal" for="radio<%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option4()%></div>
									<%
									if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option4() != null){%>
										<img id="blah_option4" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option4()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
									}
									%>
									</label>
									</td>
								</tr>								
								</table>								
							<%} else { %>
								<table width="90%" border="0" style="margin-left: 3.25em;">
								<tr>
									<td style="font-weight: bold;">
									<%if(1 == decDto.getOnum_selected_option()) {
										if(decDto.getOnum_selected_option().equals(decDto.getOnum_correct_option())) {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_right" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option1()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option1() != null){%>
												<img id="blah_option1" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option1()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%	
										} else {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_wrong" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option1()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option1() != null){%>
												<img id="blah_option1" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option1()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%
										}
									} else {
										if(1 == decDto.getOnum_correct_option()) {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_right" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option1()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option1() != null){%>
												<img id="blah_option1" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option1()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%				
										} else {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_normal" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option1()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option1() != null){%>
												<img id="blah_option1" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option1()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%
										}										
									}
									%>									
									</td>
								</tr>
								<tr>
									<td style="font-weight: bold;">
									<%if(2 == decDto.getOnum_selected_option()) {
										if(decDto.getOnum_selected_option().equals(decDto.getOnum_correct_option())) {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_right" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option2()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option2() != null){%>
												<img id="blah_option2" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option2()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%	
										} else {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_wrong" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option2()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option2() != null){%>
												<img id="blah_option2" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option2()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%
										}
									} else {
										if(2 == decDto.getOnum_correct_option()) {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_right" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option2()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option2() != null){%>
												<img id="blah_option2" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option2()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%				
										} else {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_normal" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option2()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option2() != null){%>
												<img id="blah_option2" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option2()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%
										}										
									}
									%>									
									</td>
								</tr>
								<tr>
									<td style="font-weight: bold;">
									<%if(3 == decDto.getOnum_selected_option()) {
										if(decDto.getOnum_selected_option().equals(decDto.getOnum_correct_option())) {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_right" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option3()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option3() != null){%>
												<img id="blah_option3" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option3()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%	
										} else {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_wrong" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option3()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option3() != null){%>
												<img id="blah_option3" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option3()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%
										}
									} else {
										if(3 == decDto.getOnum_correct_option()) {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_right" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option3()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option3() != null){%>
												<img id="blah_option3" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option3()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%				
										} else {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_normal" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option3()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option3() != null){%>
												<img id="blah_option3" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option3()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%
										}										
									}
									%>									
									</td>
								</tr>
								<tr>
									<td style="font-weight: bold;">
									<%if(4 == decDto.getOnum_selected_option()) {
										if(decDto.getOnum_selected_option().equals(decDto.getOnum_correct_option())) {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_right" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option4()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option4() != null){%>
												<img id="blah_option4" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option4()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%	
										} else {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_wrong" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option4()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option4() != null){%>
												<img id="blah_option4" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option4()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%
										}
									} else {
										if(4 == decDto.getOnum_correct_option()) {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_right" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option4()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option4() != null){%>
												<img id="blah_option4" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option4()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%				
										} else {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_normal" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option4()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option4() != null){%>
												<img id="blah_option4" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option4()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%
										}										
									}
									%>									
									</td>
								</tr>								
								</table>								
							 <% }%>		
							<div style="margin-top: 10px; margin-left: 10px;">
							<hr style="width:95%; border-bottom:1px dotted  #CCCCCC;" />
								<div class="question">
								<table width="95%" border="0">
								<tr>
									<td width="5%"></td>
									<td style="font-size: 12px; font-weight: bold;" width="15%">Correct Answer :</td>
									<td style="font-size: 12px; font-weight: bold;" align="left">
									<%if(1 == decDto.getOnum_correct_option()) { %>
										<div align="left"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option1()%></div>
									<%} else if(2 == decDto.getOnum_correct_option()) { %>
										<div align="left"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option2()%></div>
									<%} else if(3 == decDto.getOnum_correct_option()) { %>
										<div align="left"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option3()%></div>
									<%} else if(4 == decDto.getOnum_correct_option()) { %>
										<div align="left"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option4()%></div>
									<%} %>
									</td>
								</tr>
								<tr>
									<td width="5%"></td>
									<td style="font-size: 12px; font-weight: bold;" width="15%" valign="top">Solution :</td>
									<td style="font-size: 12px; align="left">
									<%if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_solution() == "" && decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_solution() == null) { %>
										<div align="left">NA</div>
									<%} else if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_solution() != null) { %>
										<div align="left"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_solution() %></div>
									<%} 
									
									if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_solution() != null) { %>
										<br/><div align="left"><img id="blah_option4" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_solution()%>' style="max-width: 100%; max-height: 100%;"/></div>
									<%} %>
									</td>
								</tr>
								</table>
								</div>
								
							</div>	 
							 			
							<div style="margin-top: 10px; margin-left: 10px;">
							<hr style="width:95%; border-bottom:1px dotted  #CCCCCC;" />
							
							<table width="100%">
								<tr>
								<td width="5%"></td>	
								<td width="10%">
								<%if(i != 0) {%>
									<input type="button" onclick="prev('<%=status-1%>')" value="Previous" name="Previous" style="width:80px;" class="btn">
								<%}%>
								</td>
								<td width="70%"></td>
								<td width="10%">
								<%if(all_section_size.equals(status)) {%>
									
								<%} else {%>
									 <input type="button"  onclick="next('<%=status+1%>')" value="Next" name="Next" style="width:80px;" class="btn">
								<%}%>
								</td>
								<td width="5%"></td>
								</tr>
							</table>
							</div>
							
							<%}
						}
						%>
    		  			</div>
    	  			</div>
    	  		</div>
    	  	<%if(status.equals(1)) {%>    		
  				</div>
  			<%} else {%>
  				</div>
  	    	<%}%>    	  	
    	  	<%
    	  	status++;
    	  	i++;
    	  }
    }
%>
<input type="hidden" name="page_status_bar1" id="page_status_bar1" value="<%=page_status%>">	 
<div class="item1">
<div id="tableContainer" class="tableContainer">
	<table border="0" cellpadding="0" cellspacing="0" width="100%" class="scrollTable">
	<thead>
	<tr>
		 <th style="background-color: lightgrey; font-weight: bold; font-size: 14px;" height="30px;">Question</th>
	</tr>
	</thead>
		<tbody class="scrollContent">
		<tr>
			<td style="height: 5px;"></td>
		</tr>
		</tbody>
	</table>
</div>
<div align="center">
<select name="section_all1" id="section_all1" style="width: 90%; margin-bottom: 15px; height: 30px; background-color: #ffffff;" onchange="changeExamSection('1');">
	
	<option value="1" selected="selected">Show All Questions</option>
	<option value="2">Show Correct Answers</option>	
	<option value="3">Show Incorrect Answers</option>	
	<option value="4">Show Unattempted Questions</option>	
</select> 
</div>
<div align="left">    
			<%
			int num = 1;
			Integer k = 1;
	    	
	    	if(resultDescriptionDtoList != null && resultDescriptionDtoList.size()>0) {
				for(ResultDescriptionDto decDto : resultDescriptionDtoList) {
					if(decDto.getOnum_selected_option() == null) {
						%><div class="myBuNormal" id="bottom_bar<%=k%>" onclick="changeExamNo('<%=k%>');"><%=k%></div><%
					} else {
						if(decDto.getOnum_selected_option().equals(decDto.getOnum_correct_option())) {
							%><div class="myBuRight" id="bottom_bar<%=k%>" onclick="changeExamNo('<%=k%>');"><%=k%></div><%									
						} else {
							%><div class="myBuWrong" id="bottom_bar<%=k%>" onclick="changeExamNo('<%=k%>');"><%=k%></div><%		
						}
					}
					
		   			k++;
		   			num++;
	    		}
			} 
			%>	
</div>
</div>
<div align="center">
<table border="0" cellpadding="0" cellspacing="0" width="17%" class="scrollTable">
	<thead>
	<tr>
		 <td width="10%" style="background-color: #fefefe; font-weight: bold; font-size: 10px;" height="30px;" valign="middle"><div class="myBuRightSmall" ></div></td>
		 <td width="90%" style="background-color: #fefefe; font-weight: bold; font-size: 10px;" height="30px;" valign="middle">Correct Answers</td>
	</tr>
	</thead>
	<thead>
	<tr>
		 <td width="10%" style="background-color: #fefefe; font-weight: bold; font-size: 10px;" height="30px;" valign="middle"><div class="myBuWrongSmall" ></div></td>
		 <td style="background-color: #fefefe; font-weight: bold; font-size: 10px;" height="30px;" valign="middle">Incorrect Answers</td>
	</tr>
	</thead>
	<thead>
	<tr>
	 	 <td width="10%" style="background-color: #fefefe; font-weight: bold; font-size: 10px;" height="30px;" valign="middle"><div class="myBuNormalSmall" ></div></td>		
		 <td style="background-color: #fefefe; font-weight: bold; font-size: 10px;" height="30px;"valign="middle">Unattempted Questions</td>
	</tr>
	</thead>
</table>
</div>
</div>
</div>
</div>
</div> 
</div>


<div id="pageDetails2" style="display: none;">
<div class="grid_10">
<div class="box round first grid">
<h2>Review Examination</h2><br/><br/>
<div id="container">
<%
	status = 1;
    keyId = 1;
    i = 0;
    page_status = 0;
    if(resultDescriptionDtoList != null && resultDescriptionDtoList.size()>0) {
    	  for(ResultDescriptionDto decDto : resultDescriptionDtoList) {
    	  if(decDto.getOnum_correct_option().equals(decDto.getOnum_selected_option())) { 
    		 page_status = 1;  
    		 if(status.equals(1)) {%>    		
  				<div id="BODY_CORRECT_ANSWER<%=status%>">
  			<%} else {%>
  				<div id="BODY_CORRECT_ANSWER<%=status%>" style="display: none;">
  	    	<%}%>
			   <div class="item2">
					<div id="page<%=i%>"><br/>
						<div id="container2">
    		  			<%
						if(decDto != null) {
							if(1 == 1) {%>
							<div align="center">
							<%
							if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getSectionDetailsDto().getInum_is_paragraph().equals(1)) { %>
							<a onclick="showParagraph2('<%=i%>');" style="cursor:pointer;">Show Paragraph</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a onclick="hideParagraph2('<%=i%>');" style="cursor:pointer;">Hide Paragraph</a>
							<div id="showparagraph2<%=i%>" style="display: none;">
							<table width="95%" border="0">
						    <tr>
						    	<td colspan="4" style="font-size: 15px;"><div style="text-align: justify; margin-left: 5px; margin-right: 5px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getSectionDetailsDto().getParagraphDetailsDto().getOstr_paragraph_descriprion()%></div></td>
						    </tr>
						    </table>
						    </div>
						    
						    <%}%>
							<table width="95%" border="0">
							<tr>
								<td width="40px;" valign="top" style="font-size: 18px; font-weight: bold;"><div class="bullet"><%=i+1%></div></td><td colspan="3" style="font-size: 14px; font-weight: bold;"><div class="question"><div style="padding: 15px 15px 15px 15px;">
								<%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_question()%>
								<%
								if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_question() != null){
									%><br/><img id="blah_question" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_question()%>' style="max-width: 100%; max-height: 100%; margin-left: 5px;"/><%
								}%>
								</div></div></td>
							</tr>
							</table>
							</div>
							<%if(decDto.getOnum_selected_option() == null) {%>
								<table width="90%" border="0" style="margin-left: 3.25em;">
								<tr>
									<td style="font-weight: bold;">
									<input type="radio" name="answer<%=i%>" value="1" id="radio<%=keyId%><%=i%>1" class="radio" disabled="disabled"/>
									<label class="label_normal" for="radio<%=i%>1"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option1()%></div>
									<%
									if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option1() != null){%>
										<img id="blah_option1" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option1()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
									}
									%>
									</label></td>
								</tr>
								<tr>
									<td style="font-weight: bold;">
									<input type="radio" name="answer<%=i%>" value="2" id="radio<%=keyId%><%=i%>2" class="radio" disabled="disabled"/>
									<label class="label_normal" for="radio<%=i%>2"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option2()%></div>
									<%
									if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option2() != null){%>
										<img id="blah_option2" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option2()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
									}
									%>
									</label>
									</td>
								</tr>
								<tr>
									<td style="font-weight: bold;">
									<input type="radio" name="answer<%=i%>" value="3" id="radio<%=keyId%><%=i%>3" class="radio" disabled="disabled"/>
									<label class="label_normal" for="radio<%=i%>3"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option3()%></div>
									<%
									if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option3() != null){%>
										<img id="blah_option3" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option3()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
									}
									%>
									</label>
									</td>
								</tr>
								<tr>
									<td style="font-weight: bold;">
									<input type="radio" name="answer<%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
									<label class="label_normal" for="radio<%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option4()%></div>
									<%
									if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option4() != null){%>
										<img id="blah_option4" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option4()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
									}
									%>
									</label>
									</td>
								</tr>								
								</table>								
							<%} else { %>
								<table width="90%" border="0" style="margin-left: 3.25em;">
								<tr>
									<td style="font-weight: bold;">
									<%if(1 == decDto.getOnum_selected_option()) {
										if(decDto.getOnum_selected_option().equals(decDto.getOnum_correct_option())) {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_right" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option1()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option1() != null){%>
												<img id="blah_option1" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option1()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%	
										} else {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_wrong" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option1()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option1() != null){%>
												<img id="blah_option1" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option1()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%
										}
									} else {
										if(1 == decDto.getOnum_correct_option()) {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_right" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option1()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option1() != null){%>
												<img id="blah_option1" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option1()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%				
										} else {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_normal" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option1()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option1() != null){%>
												<img id="blah_option1" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option1()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%
										}										
									}
									%>									
									</td>
								</tr>
								<tr>
									<td style="font-weight: bold;">
									<%if(2 == decDto.getOnum_selected_option()) {
										if(decDto.getOnum_selected_option().equals(decDto.getOnum_correct_option())) {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_right" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option2()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option2() != null){%>
												<img id="blah_option2" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option2()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%	
										} else {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_wrong" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option2()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option2() != null){%>
												<img id="blah_option2" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option2()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%
										}
									} else {
										if(2 == decDto.getOnum_correct_option()) {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_right" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option2()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option2() != null){%>
												<img id="blah_option2" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option2()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%				
										} else {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_normal" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option2()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option2() != null){%>
												<img id="blah_option2" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option2()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%
										}										
									}
									%>									
									</td>
								</tr>
								<tr>
									<td style="font-weight: bold;">
									<%if(3 == decDto.getOnum_selected_option()) {
										if(decDto.getOnum_selected_option().equals(decDto.getOnum_correct_option())) {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_right" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option3()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option3() != null){%>
												<img id="blah_option3" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option3()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%	
										} else {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_wrong" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option3()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option3() != null){%>
												<img id="blah_option3" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option3()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%
										}
									} else {
										if(3 == decDto.getOnum_correct_option()) {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_right" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option3()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option3() != null){%>
												<img id="blah_option3" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option3()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%				
										} else {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_normal" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option3()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option3() != null){%>
												<img id="blah_option3" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option3()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%
										}										
									}
									%>									
									</td>
								</tr>
								<tr>
									<td style="font-weight: bold;">
									<%if(4 == decDto.getOnum_selected_option()) {
										if(decDto.getOnum_selected_option().equals(decDto.getOnum_correct_option())) {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_right" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option4()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option4() != null){%>
												<img id="blah_option4" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option4()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%	
										} else {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_wrong" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option4()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option4() != null){%>
												<img id="blah_option4" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option4()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%
										}
									} else {
										if(4 == decDto.getOnum_correct_option()) {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_right" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option4()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option4() != null){%>
												<img id="blah_option4" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option4()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%				
										} else {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_normal" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option4()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option4() != null){%>
												<img id="blah_option4" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option4()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%
										}										
									}
									%>									
									</td>
								</tr>								
								</table>								
							 <% }%>		
							<div style="margin-top: 10px; margin-left: 10px;">
							<hr style="width:95%; border-bottom:1px dotted  #CCCCCC;" />
								<div class="question">
								<table width="95%" border="0">
								<tr>
									<td width="5%"></td>
									<td style="font-size: 12px; font-weight: bold;" width="15%">Correct Answer :</td>
									<td style="font-size: 12px; font-weight: bold;" align="left">
									<%if(1 == decDto.getOnum_correct_option()) { %>
										<div align="left"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option1()%></div>
									<%} else if(2 == decDto.getOnum_correct_option()) { %>
										<div align="left"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option2()%></div>
									<%} else if(3 == decDto.getOnum_correct_option()) { %>
										<div align="left"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option3()%></div>
									<%} else if(4 == decDto.getOnum_correct_option()) { %>
										<div align="left"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option4()%></div>
									<%} %>
									</td>
								</tr>
								<tr>
									<td width="5%"></td>
									<td style="font-size: 12px; font-weight: bold;" width="15%" valign="top">Solution :</td>
									<td style="font-size: 12px; align="left">
									<%if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_solution() == "" && decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_solution() == null) { %>
										<div align="left">NA</div>
									<%} else if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_solution() != null) { %>
										<div align="left"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_solution() %></div>
									<%} 
									
									if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_solution() != null) { %>
										<br/><div align="left"><img id="blah_option4" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_solution()%>' style="max-width: 100%; max-height: 100%;"/></div>
									<%} %>
									</td>
								</tr>
								</table>
								</div>
								
							</div>	 
							 			
							<div style="margin-top: 10px; margin-left: 10px;">
							<hr style="width:95%; border-bottom:1px dotted  #CCCCCC;" />
							
							<table width="100%">
								<tr>
								<td width="5%"></td>	
								<td width="10%">
								<%if(i != 0) {%>
									<input type="button" onclick="prev_CORRECT_ANSWER('<%=status-1%>')" value="Previous" name="Previous" style="width:80px;" class="btn">
								<%}%>
								</td>
								<td width="70%"></td>
								<td width="10%">
								<%if(decDto.getResultDetailsDto().getOnum_wright().equals(status)) {%>
									
								<%} else {%>
									 <input type="button"  onclick="next_CORRECT_ANSWER('<%=status+1%>')" value="Next" name="Next" style="width:80px;" class="btn">
								<%}%>
								</td>
								<td width="5%"></td>
								</tr>
							</table>
							</div>
							
							<%}
						}
						%>
    		  			</div>
    	  			</div>
    	  		</div>
    	  	<%if(status.equals(1)) {%>    		
  				</div>
  			<%} else {%>
  				</div>
  	    	<%}%> 
    	  	<%
    	  	status++;
    	  	i++;
    	  }
    	  }
    }
%>
<input type="hidden" name="page_status_bar2" id="page_status_bar2" value="<%=page_status%>">	 
<div class="item1">
<div id="tableContainer" class="tableContainer">
	<table border="0" cellpadding="0" cellspacing="0" width="100%" class="scrollTable">
	<thead>
	<tr>
		 <th style="background-color: lightgrey; font-weight: bold; font-size: 14px;" height="30px;">Question</th>
	</tr>
	</thead>
		<tbody class="scrollContent">
		<tr>
			<td style="height: 5px;"></td>
		</tr>
		</tbody>
	</table>
</div>
<div align="center">
<select name="section_all2" id="section_all2" style="width: 90%; margin-bottom: 15px; height: 30px; background-color: #ffffff;" onchange="changeExamSection('2');">
	<option value="1">Show All Questions</option>
	<option value="2" selected="selected">Show Correct Answers</option>	
	<option value="3">Show Incorrect Answers</option>	
	<option value="4">Show Unattempted Questions</option>	
</select>    
</div>
<div align="left"> 
			<%
			num = 1;
			k = 1;
	    	
	    	if(resultDescriptionDtoList != null && resultDescriptionDtoList.size()>0) {
				for(ResultDescriptionDto decDto : resultDescriptionDtoList) {
					if(decDto.getOnum_correct_option().equals(decDto.getOnum_selected_option())) {
						if(decDto.getOnum_selected_option() == null) {
							%><div class="myBuNormal" id="bottom_bar<%=k%>" onclick="changeExamNo('<%=k%>');"><%=k%></div><%
						} else {
							if(decDto.getOnum_selected_option().equals(decDto.getOnum_correct_option())) {
								%><div class="myBuRight" id="bottom_bar<%=k%>" onclick="changeExamNo_CORRECT_ANSWER('<%=k%>');"><%=k%></div><%									
							} else {
								%><div class="myBuWrong" id="bottom_bar<%=k%>" onclick="changeExamNo_CORRECT_ANSWER('<%=k%>');"><%=k%></div><%		
							}
						}
						
			   			k++;
			   			num++;
					}
	    		}
			} 
			%>	
</div>
</div>
<div align="center">
<table border="0" cellpadding="0" cellspacing="0" width="17%" class="scrollTable">
	<thead>
	<tr>
		 <td width="10%" style="background-color: #fefefe; font-weight: bold; font-size: 10px;" height="30px;" valign="middle"><div class="myBuRightSmall" ></div></td>
		 <td width="90%" style="background-color: #fefefe; font-weight: bold; font-size: 10px;" height="30px;" valign="middle">Correct Answers</td>
	</tr>
	</thead>
	<thead>
	<tr>
		 <td width="10%" style="background-color: #fefefe; font-weight: bold; font-size: 10px;" height="30px;" valign="middle"><div class="myBuWrongSmall" ></div></td>
		 <td style="background-color: #fefefe; font-weight: bold; font-size: 10px;" height="30px;" valign="middle">Incorrect Answers</td>
	</tr>
	</thead>
	<thead>
	<tr>
	 	 <td width="10%" style="background-color: #fefefe; font-weight: bold; font-size: 10px;" height="30px;" valign="middle"><div class="myBuNormalSmall" ></div></td>		
		 <td style="background-color: #fefefe; font-weight: bold; font-size: 10px;" height="30px;"valign="middle">Unattempted Questions</td>
	</tr>
	</thead>
</table>
</div>

</div>
</div>
</div>
</div>




<div id="pageDetails3" style="display: none;">
<div class="grid_10">
<div class="box round first grid">
<h2>Review Examination</h2><br/><br/>
<div id="container">
<%
	status = 1;
    keyId = 1;
    i = 0;
    page_status = 0;
    if(resultDescriptionDtoList != null && resultDescriptionDtoList.size()>0) {
    	  for(ResultDescriptionDto decDto : resultDescriptionDtoList) {
    	  if(decDto.getOnum_selected_option() != null) {
    	  if(!(decDto.getOnum_correct_option().equals(decDto.getOnum_selected_option()))) { 
    		 page_status = 1; 
    	  	 if(status.equals(1)) {%>    		
  				<div id="BODY_INCORRECT_ANSWER<%=status%>">
  			<%} else {%>
  				<div id="BODY_INCORRECT_ANSWER<%=status%>" style="display: none;">
  	    	<%}%>
  	  		   <div class="item2">
					<div id="page<%=i%>"><br/>
						<div id="container2">
    		  			<%
						if(decDto != null) {
							if(1 == 1) {%>
							<div align="center">
							<%
							if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getSectionDetailsDto().getInum_is_paragraph().equals(1)) { %>
							<a onclick="showParagraph3('<%=i%>');" style="cursor:pointer;">Show Paragraph</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a onclick="hideParagraph3('<%=i%>');" style="cursor:pointer;">Hide Paragraph</a>
							<div id="showparagraph3<%=i%>" style="display: none;">
							<table width="95%" border="0">
						    <tr>
						    	<td colspan="4" style="font-size: 15px;"><div style="text-align: justify; margin-left: 5px; margin-right: 5px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getSectionDetailsDto().getParagraphDetailsDto().getOstr_paragraph_descriprion()%></div></td>
						    </tr>
						    </table>
						    </div>
						    
						    <%}%>
							<table width="95%" border="0">
							<tr>
								<td width="40px;" valign="top" style="font-size: 18px; font-weight: bold;"><div class="bullet"><%=i+1%></div></td><td colspan="3" style="font-size: 14px; font-weight: bold;"><div class="question"><div style="padding: 15px 15px 15px 15px;">
								<%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_question()%>
								<%
								if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_question() != null){
									%><br/><img id="blah_question" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_question()%>' style="max-width: 100%; max-height: 100%; margin-left: 5px;"/><%
								}%>
								</div></div></td>
							</tr>
							</table>
							</div>
							<%if(decDto.getOnum_selected_option() == null) {%>
								<table width="90%" border="0" style="margin-left: 3.25em;">
								<tr>
									<td style="font-weight: bold;">
									<input type="radio" name="answer<%=i%>" value="1" id="radio<%=keyId%><%=i%>1" class="radio" disabled="disabled"/>
									<label class="label_normal" for="radio<%=i%>1"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option1()%></div>
									<%
									if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option1() != null){%>
										<img id="blah_option1" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option1()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
									}
									%>
									</label></td>
								</tr>
								<tr>
									<td style="font-weight: bold;">
									<input type="radio" name="answer<%=i%>" value="2" id="radio<%=keyId%><%=i%>2" class="radio" disabled="disabled"/>
									<label class="label_normal" for="radio<%=i%>2"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option2()%></div>
									<%
									if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option2() != null){%>
										<img id="blah_option2" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option2()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
									}
									%>
									</label>
									</td>
								</tr>
								<tr>
									<td style="font-weight: bold;">
									<input type="radio" name="answer<%=i%>" value="3" id="radio<%=keyId%><%=i%>3" class="radio" disabled="disabled"/>
									<label class="label_normal" for="radio<%=i%>3"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option3()%></div>
									<%
									if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option3() != null){%>
										<img id="blah_option3" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option3()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
									}
									%>
									</label>
									</td>
								</tr>
								<tr>
									<td style="font-weight: bold;">
									<input type="radio" name="answer<%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
									<label class="label_normal" for="radio<%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option4()%></div>
									<%
									if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option4() != null){%>
										<img id="blah_option4" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option4()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
									}
									%>
									</label>
									</td>
								</tr>								
								</table>								
							<%} else { %>
								<table width="90%" border="0" style="margin-left: 3.25em;">
								<tr>
									<td style="font-weight: bold;">
									<%if(1 == decDto.getOnum_selected_option()) {
										if(decDto.getOnum_selected_option().equals(decDto.getOnum_correct_option())) {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_right" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option1()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option1() != null){%>
												<img id="blah_option1" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option1()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%	
										} else {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_wrong" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option1()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option1() != null){%>
												<img id="blah_option1" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option1()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%
										}
									} else {
										if(1 == decDto.getOnum_correct_option()) {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_right" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option1()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option1() != null){%>
												<img id="blah_option1" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option1()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%				
										} else {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_normal" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option1()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option1() != null){%>
												<img id="blah_option1" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option1()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%
										}										
									}
									%>									
									</td>
								</tr>
								<tr>
									<td style="font-weight: bold;">
									<%if(2 == decDto.getOnum_selected_option()) {
										if(decDto.getOnum_selected_option().equals(decDto.getOnum_correct_option())) {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_right" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option2()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option2() != null){%>
												<img id="blah_option2" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option2()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%	
										} else {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_wrong" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option2()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option2() != null){%>
												<img id="blah_option2" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option2()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%
										}
									} else {
										if(2 == decDto.getOnum_correct_option()) {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_right" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option2()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option2() != null){%>
												<img id="blah_option2" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option2()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%				
										} else {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_normal" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option2()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option2() != null){%>
												<img id="blah_option2" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option2()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%
										}										
									}
									%>									
									</td>
								</tr>
								<tr>
									<td style="font-weight: bold;">
									<%if(3 == decDto.getOnum_selected_option()) {
										if(decDto.getOnum_selected_option().equals(decDto.getOnum_correct_option())) {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_right" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option3()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option3() != null){%>
												<img id="blah_option3" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option3()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%	
										} else {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_wrong" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option3()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option3() != null){%>
												<img id="blah_option3" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option3()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%
										}
									} else {
										if(3 == decDto.getOnum_correct_option()) {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_right" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option3()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option3() != null){%>
												<img id="blah_option3" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option3()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%				
										} else {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_normal" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option3()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option3() != null){%>
												<img id="blah_option3" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option3()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%
										}										
									}
									%>									
									</td>
								</tr>
								<tr>
									<td style="font-weight: bold;">
									<%if(4 == decDto.getOnum_selected_option()) {
										if(decDto.getOnum_selected_option().equals(decDto.getOnum_correct_option())) {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_right" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option4()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option4() != null){%>
												<img id="blah_option4" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option4()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%	
										} else {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_wrong" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option4()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option4() != null){%>
												<img id="blah_option4" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option4()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%
										}
									} else {
										if(4 == decDto.getOnum_correct_option()) {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_right" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option4()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option4() != null){%>
												<img id="blah_option4" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option4()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%				
										} else {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_normal" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option4()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option4() != null){%>
												<img id="blah_option4" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option4()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%
										}										
									}
									%>									
									</td>
								</tr>								
								</table>								
							 <% }%>		
							<div style="margin-top: 10px; margin-left: 10px;">
							<hr style="width:95%; border-bottom:1px dotted  #CCCCCC;" />
								<div class="question">
								<table width="95%" border="0">
								<tr>
									<td width="5%"></td>
									<td style="font-size: 12px; font-weight: bold;" width="15%">Correct Answer :</td>
									<td style="font-size: 12px; font-weight: bold;" align="left">
									<%if(1 == decDto.getOnum_correct_option()) { %>
										<div align="left"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option1()%></div>
									<%} else if(2 == decDto.getOnum_correct_option()) { %>
										<div align="left"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option2()%></div>
									<%} else if(3 == decDto.getOnum_correct_option()) { %>
										<div align="left"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option3()%></div>
									<%} else if(4 == decDto.getOnum_correct_option()) { %>
										<div align="left"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option4()%></div>
									<%} %>
									</td>
								</tr>
								<tr>
									<td width="5%"></td>
									<td style="font-size: 12px; font-weight: bold;" width="15%" valign="top">Solution :</td>
									<td style="font-size: 12px; align="left">
									<%if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_solution() == "" && decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_solution() == null) { %>
										<div align="left">NA</div>
									<%} else if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_solution() != null) { %>
										<div align="left"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_solution() %></div>
									<%} 
									
									if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_solution() != null) { %>
										<br/><div align="left"><img id="blah_option4" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_solution()%>' style="max-width: 100%; max-height: 100%;"/></div>
									<%} %>
									</td>
								</tr>
								</table>
								</div>
								
							</div>	 
							 			
							<div style="margin-top: 10px; margin-left: 10px;">
							<hr style="width:95%; border-bottom:1px dotted  #CCCCCC;" />
							
							<table width="100%">
								<tr>
								<td width="5%"></td>	
								<td width="10%">
								<%if(i != 0) {%>
									<input type="button" onclick="prev_INCORRECT_ANSWER('<%=status-1%>')" value="Previous" name="Previous" style="width:80px;" class="btn">
								<%}%>
								</td>
								<td width="70%"></td>
								<td width="10%">
								<%if(decDto.getResultDetailsDto().getOnum_wrong().equals(status)) {%>
									
								<%} else {%>
									 <input type="button"  onclick="next_INCORRECT_ANSWER('<%=status+1%>')" value="Next" name="Next" style="width:80px;" class="btn">
								<%}%>
								</td>
								<td width="5%"></td>
								</tr>
							</table>
							</div>
							
							<%}
						}
						%>
    		  			</div>
    	  			</div>
    	  		</div>
    	  	<%if(status.equals(1)) {%>    		
  				</div>
  			<%} else {%>
  				</div>
  	    	<%}%>
    	  	<%
    	  	status++;
    	  	i++;
    	  }
    	  }
    	  }
    }
%>
<input type="hidden" name="page_status_bar3" id="page_status_bar3" value="<%=page_status%>">
<div class="item1">
<div id="tableContainer" class="tableContainer">
	<table border="0" cellpadding="0" cellspacing="0" width="100%" class="scrollTable">
	<thead>
	<tr>
		 <th style="background-color: lightgrey; font-weight: bold; font-size: 14px;" height="30px;">Question</th>
	</tr>
	</thead>
		<tbody class="scrollContent">
		<tr>
			<td style="height: 5px;"></td>
		</tr>
		</tbody>
	</table>
</div>
<div align="center">
<select name="section_all3" id="section_all3" style="width: 90%; margin-bottom: 15px; height: 30px; background-color: #ffffff;" onchange="changeExamSection('3');">
	<option value="1">Show All Questions</option>
	<option value="2">Show Correct Answers</option>	
	<option value="3" selected="selected">Show Incorrect Answers</option>	
	<option value="4">Show Unattempted Questions</option>	
</select> 
</div>
<div align="left">    
			<%
			num = 1;
			k = 1;
	    	
	    	if(resultDescriptionDtoList != null && resultDescriptionDtoList.size()>0) {
				for(ResultDescriptionDto decDto : resultDescriptionDtoList) {
					if(decDto.getOnum_selected_option() != null) {
				    if(!(decDto.getOnum_correct_option().equals(decDto.getOnum_selected_option()))) { 
				    	
					if(decDto.getOnum_selected_option() == null) {
						%><div class="myBuNormal" id="bottom_bar<%=k%>" onclick="changeExamNo_INCORRECT_ANSWER('<%=k%>');"><%=k%></div><%
					} else {
						if(decDto.getOnum_selected_option().equals(decDto.getOnum_correct_option())) {
							%><div class="myBuRight" id="bottom_bar<%=k%>" onclick="changeExamNo_INCORRECT_ANSWER('<%=k%>');"><%=k%></div><%									
						} else {
							%><div class="myBuWrong" id="bottom_bar<%=k%>" onclick="changeExamNo_INCORRECT_ANSWER('<%=k%>');"><%=k%></div><%		
						}
					}
					
		   			k++;
		   			num++;
				    }
					}
	    		}
			} 
			%>	
</div>
</div>
<div align="center">
<table border="0" cellpadding="0" cellspacing="0" width="17%" class="scrollTable">
	<thead>
	<tr>
		 <td width="10%" style="background-color: #fefefe; font-weight: bold; font-size: 10px;" height="30px;" valign="middle"><div class="myBuRightSmall" ></div></td>
		 <td width="90%" style="background-color: #fefefe; font-weight: bold; font-size: 10px;" height="30px;" valign="middle">Correct Answers</td>
	</tr>
	</thead>
	<thead>
	<tr>
		 <td width="10%" style="background-color: #fefefe; font-weight: bold; font-size: 10px;" height="30px;" valign="middle"><div class="myBuWrongSmall" ></div></td>
		 <td style="background-color: #fefefe; font-weight: bold; font-size: 10px;" height="30px;" valign="middle">Incorrect Answers</td>
	</tr>
	</thead>
	<thead>
	<tr>
	 	 <td width="10%" style="background-color: #fefefe; font-weight: bold; font-size: 10px;" height="30px;" valign="middle"><div class="myBuNormalSmall" ></div></td>		
		 <td style="background-color: #fefefe; font-weight: bold; font-size: 10px;" height="30px;"valign="middle">Unattempted Questions</td>
	</tr>
	</thead>
</table>
</div>
</div>
</div>
</div>
</div>




<div id="pageDetails4" style="display: none;">
<div class="grid_10">
<div class="box round first grid">
<h2>Review Examination</h2><br/><br/>
<div id="container">
<%
	status = 1;
    keyId = 1;
    i = 0;
    page_status = 0;
    if(resultDescriptionDtoList != null && resultDescriptionDtoList.size()>0) {
    	  for(ResultDescriptionDto decDto : resultDescriptionDtoList) {
    	  if(decDto.getOnum_selected_option() == null) {
    		 page_status = 1;
    		 if(status.equals(1)) {%>    		
  				<div id="BODY_UNATTEMPTED_ANSWER<%=status%>">
  			<%} else {%>
  				<div id="BODY_UNATTEMPTED_ANSWER<%=status%>" style="display: none;">
  	    	<%}%>
  	  		   <div class="item2">
					<div id="page<%=i%>"><br/>
						<div id="container2">
    		  			<%
						if(decDto != null) {
							if(1 == 1) {%>
							<div align="center">
							<%
							if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getSectionDetailsDto().getInum_is_paragraph().equals(1)) { %>
							<a onclick="showParagraph4('<%=i%>');" style="cursor:pointer;">Show Paragraph</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a onclick="hideParagraph4('<%=i%>');" style="cursor:pointer;">Hide Paragraph</a>
							<div id="showparagraph4<%=i%>" style="display: none;">
							<table width="95%" border="0">
						    <tr>
						    	<td colspan="4" style="font-size: 15px;"><div style="text-align: justify; margin-left: 5px; margin-right: 5px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getSectionDetailsDto().getParagraphDetailsDto().getOstr_paragraph_descriprion()%></div></td>
						    </tr>
						    </table>
						    </div>
						    
						    <%}%>
							<table width="95%" border="0">
							<tr>
								<td width="40px;" valign="top" style="font-size: 18px; font-weight: bold;"><div class="bullet"><%=i+1%></div></td><td colspan="3" style="font-size: 14px; font-weight: bold;"><div class="question"><div style="padding: 15px 15px 15px 15px;">
								<%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_question()%>
								<%
								if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_question() != null){
									%><br/><img id="blah_question" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_question()%>' style="max-width: 100%; max-height: 100%; margin-left: 5px;"/><%
								}%>
								</div></div></td>
							</tr>
							</table>
							</div>
							<%if(decDto.getOnum_selected_option() == null) {%>
								<table width="90%" border="0" style="margin-left: 3.25em;">
								<tr>
									<td style="font-weight: bold;">
									<input type="radio" name="answer<%=i%>" value="1" id="radio<%=keyId%><%=i%>1" class="radio" disabled="disabled"/>
									<label class="label_normal" for="radio<%=i%>1"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option1()%></div>
									<%
									if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option1() != null){%>
										<img id="blah_option1" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option1()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
									}
									%>
									</label></td>
								</tr>
								<tr>
									<td style="font-weight: bold;">
									<input type="radio" name="answer<%=i%>" value="2" id="radio<%=keyId%><%=i%>2" class="radio" disabled="disabled"/>
									<label class="label_normal" for="radio<%=i%>2"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option2()%></div>
									<%
									if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option2() != null){%>
										<img id="blah_option2" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option2()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
									}
									%>
									</label>
									</td>
								</tr>
								<tr>
									<td style="font-weight: bold;">
									<input type="radio" name="answer<%=i%>" value="3" id="radio<%=keyId%><%=i%>3" class="radio" disabled="disabled"/>
									<label class="label_normal" for="radio<%=i%>3"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option3()%></div>
									<%
									if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option3() != null){%>
										<img id="blah_option3" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option3()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
									}
									%>
									</label>
									</td>
								</tr>
								<tr>
									<td style="font-weight: bold;">
									<input type="radio" name="answer<%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
									<label class="label_normal" for="radio<%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option4()%></div>
									<%
									if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option4() != null){%>
										<img id="blah_option4" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option4()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
									}
									%>
									</label>
									</td>
								</tr>								
								</table>								
							<%} else { %>
								<table width="90%" border="0" style="margin-left: 3.25em;">
								<tr>
									<td style="font-weight: bold;">
									<%if(1 == decDto.getOnum_selected_option()) {
										if(decDto.getOnum_selected_option().equals(decDto.getOnum_correct_option())) {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_right" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option1()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option1() != null){%>
												<img id="blah_option1" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option1()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%	
										} else {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_wrong" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option1()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option1() != null){%>
												<img id="blah_option1" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option1()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%
										}
									} else {
										if(1 == decDto.getOnum_correct_option()) {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_right" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option1()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option1() != null){%>
												<img id="blah_option1" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option1()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%				
										} else {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_normal" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option1()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option1() != null){%>
												<img id="blah_option1" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option1()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%
										}										
									}
									%>									
									</td>
								</tr>
								<tr>
									<td style="font-weight: bold;">
									<%if(2 == decDto.getOnum_selected_option()) {
										if(decDto.getOnum_selected_option().equals(decDto.getOnum_correct_option())) {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_right" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option2()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option2() != null){%>
												<img id="blah_option2" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option2()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%	
										} else {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_wrong" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option2()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option2() != null){%>
												<img id="blah_option2" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option2()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%
										}
									} else {
										if(2 == decDto.getOnum_correct_option()) {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_right" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option2()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option2() != null){%>
												<img id="blah_option2" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option2()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%				
										} else {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_normal" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option2()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option2() != null){%>
												<img id="blah_option2" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option2()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%
										}										
									}
									%>									
									</td>
								</tr>
								<tr>
									<td style="font-weight: bold;">
									<%if(3 == decDto.getOnum_selected_option()) {
										if(decDto.getOnum_selected_option().equals(decDto.getOnum_correct_option())) {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_right" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option3()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option3() != null){%>
												<img id="blah_option3" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option3()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%	
										} else {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_wrong" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option3()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option3() != null){%>
												<img id="blah_option3" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option3()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%
										}
									} else {
										if(3 == decDto.getOnum_correct_option()) {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_right" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option3()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option3() != null){%>
												<img id="blah_option3" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option3()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%				
										} else {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_normal" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option3()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option3() != null){%>
												<img id="blah_option3" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option3()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%
										}										
									}
									%>									
									</td>
								</tr>
								<tr>
									<td style="font-weight: bold;">
									<%if(4 == decDto.getOnum_selected_option()) {
										if(decDto.getOnum_selected_option().equals(decDto.getOnum_correct_option())) {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_right" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option4()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option4() != null){%>
												<img id="blah_option4" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option4()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%	
										} else {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_wrong" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option4()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option4() != null){%>
												<img id="blah_option4" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option4()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%
										}
									} else {
										if(4 == decDto.getOnum_correct_option()) {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_right" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option4()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option4() != null){%>
												<img id="blah_option4" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option4()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%				
										} else {
											%>
											<input type="radio" name="answer<%=keyId%><%=i%>" value="4" id="radio<%=keyId%><%=i%>4" class="radio" disabled="disabled"/>
											<label class="label_normal" for="radio<%=keyId%><%=i%>4"><div style="margin-left: 3.25em; font-size: 12px;"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option4()%></div>
											<%
											if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option4() != null){%>
												<img id="blah_option4" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_option4()%>' style="max-width: 95%; max-height: 95%; margin-left: 30px;"/><%
											}
											%>
											</label>
											<%
										}										
									}
									%>									
									</td>
								</tr>								
								</table>								
							 <% }%>		
							<div style="margin-top: 10px; margin-left: 10px;">
							<hr style="width:95%; border-bottom:1px dotted  #CCCCCC;" />
								<div class="question">
								<table width="95%" border="0">
								<tr>
									<td width="5%"></td>
									<td style="font-size: 12px; font-weight: bold;" width="15%">Correct Answer :</td>
									<td style="font-size: 12px; font-weight: bold;" align="left">
									<%if(1 == decDto.getOnum_correct_option()) { %>
										<div align="left"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option1()%></div>
									<%} else if(2 == decDto.getOnum_correct_option()) { %>
										<div align="left"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option2()%></div>
									<%} else if(3 == decDto.getOnum_correct_option()) { %>
										<div align="left"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option3()%></div>
									<%} else if(4 == decDto.getOnum_correct_option()) { %>
										<div align="left"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_option4()%></div>
									<%} %>
									</td>
								</tr>
								<tr>
									<td width="5%"></td>
									<td style="font-size: 12px; font-weight: bold;" width="15%" valign="top">Solution :</td>
									<td style="font-size: 12px; align="left">
									<%if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_solution() == "" && decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_solution() == null) { %>
										<div align="left">NA</div>
									<%} else if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_solution() != null) { %>
										<div align="left"><%=decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getOstr_solution() %></div>
									<%} 
									
									if(decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_solution() != null) { %>
										<br/><div align="left"><img id="blah_option4" src='data:image/jpg;base64,<%= decDto.getExamQuestionDetailsDto().getQuestionDetailsDto().getObl_solution()%>' style="max-width: 100%; max-height: 100%;"/></div>
									<%} %>
									</td>
								</tr>
								</table>
								</div>
								
							</div>	 
							 			
							<div style="margin-top: 10px; margin-left: 10px;">
							<hr style="width:95%; border-bottom:1px dotted  #CCCCCC;" />
							
							<table width="100%">
								<tr>
								<td width="5%"></td>	
								<td width="10%">
								<%if(i != 0) {%>
									<input type="button" onclick="prev_UNATTEMPTED_ANSWER('<%=status-1%>')" value="Previous" name="Previous" style="width:80px;" class="btn">
								<%}%>
								</td>
								<td width="70%"></td>
								<td width="10%">
								<%if(decDto.getResultDetailsDto().getOnum_left().equals(status)) {%>
									
								<%} else {%>
									 <input type="button"  onclick="next_UNATTEMPTED_ANSWER('<%=status+1%>')" value="Next" name="Next" style="width:80px;" class="btn">
								<%}%>
								</td>
								<td width="5%"></td>
								</tr>
							</table>
							</div>
							
							<%}
						}
						%>
    		  			</div>
    	  			</div>
    	  		</div>
    	  	<%if(status.equals(1)) {%>    		
  				</div>
  			<%} else {%>
  				</div>
  	    	<%}%>
    	  	<%
    	  	status++;
    	  	i++;
    	  }
    	  }
    }
%>
<input type="hidden" name="page_status_bar4" id="page_status_bar4" value="<%=page_status%>">
<div class="item1">
<div id="tableContainer" class="tableContainer">
	<table border="0" cellpadding="0" cellspacing="0" width="100%" class="scrollTable">
	<thead>
	<tr>
		 <th style="background-color: lightgrey; font-weight: bold; font-size: 14px;" height="30px;">Question</th>
	</tr>
	</thead>
		<tbody class="scrollContent">
		<tr>
			<td style="height: 5px;"></td>
		</tr>
		</tbody>
	</table>
</div>
<div align="center">
<select name="section_all4" id="section_all4" style="width: 90%; margin-bottom: 15px; height: 30px; background-color: #ffffff;" onchange="changeExamSection('4');">
	<option value="1">Show All Questions</option>
	<option value="2">Show Correct Answers</option>	
	<option value="3">Show Incorrect Answers</option>	
	<option value="4" selected="selected">Show Unattempted Questions</option>	
</select>  
</div>
<div align="left">  
			<%
			num = 1;
			k = 1;
	    	
	    	if(resultDescriptionDtoList != null && resultDescriptionDtoList.size()>0) {
				for(ResultDescriptionDto decDto : resultDescriptionDtoList) {
				if(decDto.getOnum_selected_option() == null) {
					if(decDto.getOnum_selected_option() == null) {
						%><div class="myBuNormal" id="bottom_bar<%=k%>" onclick="changeExamNo_UNATTEMPTED_ANSWER('<%=k%>');"><%=k%></div><%
					} else {
						if(decDto.getOnum_selected_option().equals(decDto.getOnum_correct_option())) {
							%><div class="myBuRight" id="bottom_bar<%=k%>" onclick="changeExamNo_UNATTEMPTED_ANSWER('<%=k%>');"><%=k%></div><%									
						} else {
							%><div class="myBuWrong" id="bottom_bar<%=k%>" onclick="changeExamNo_UNATTEMPTED_ANSWER('<%=k%>');"><%=k%></div><%		
						}
					}
					
		   			k++;
		   			num++;
				}
	    		}
			} 
			%>	
</div>
</div>
<div align="center">
<table border="0" cellpadding="0" cellspacing="0" width="17%" class="scrollTable">
	<thead>
	<tr>
		 <td width="10%" style="background-color: #fefefe; font-weight: bold; font-size: 10px;" height="30px;" valign="middle"><div class="myBuRightSmall" ></div></td>
		 <td width="90%" style="background-color: #fefefe; font-weight: bold; font-size: 10px;" height="30px;" valign="middle">Correct Answers</td>
	</tr>
	</thead>
	<thead>
	<tr>
		 <td width="10%" style="background-color: #fefefe; font-weight: bold; font-size: 10px;" height="30px;" valign="middle"><div class="myBuWrongSmall" ></div></td>
		 <td style="background-color: #fefefe; font-weight: bold; font-size: 10px;" height="30px;" valign="middle">Incorrect Answers</td>
	</tr>
	</thead>
	<thead>
	<tr>
	 	 <td width="10%" style="background-color: #fefefe; font-weight: bold; font-size: 10px;" height="30px;" valign="middle"><div class="myBuNormalSmall" ></div></td>		
		 <td style="background-color: #fefefe; font-weight: bold; font-size: 10px;" height="30px;"valign="middle">Unattempted Questions</td>
	</tr>
	</thead>
</table>
</div>
</div>
</div>
</div>
</div>


<input type="hidden" id="contextPath" value="<%=request.getContextPath()%>" >
</body>