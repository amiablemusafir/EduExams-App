<!-- 
Author: Sumit Singh
Start Date: 27th March, 2014
Modify Date:
Modify By:
Motive: Admission Details
-->
<%@page import="com.sms.admin.dto.AdminDetailDto"%>
<%@page import="com.oes.dto.ResultDetailsDto"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.oes.dto.ResultReviewSubjectDto"%>
<%@page import="java.util.Map"%>
<%@page import="com.oes.dto.StudentDetailsDto"%>
<%@page import="com.thoughtworks.xstream.core.util.Base64Encoder" %>
<%@page import="com.oes.dto.DashBoardDto"%>
<%@page import="com.oes.action.Encryption"%>
<%@page import="com.oes.dto.StudentMappedExamDetailsDto"%>
<%@page import="com.oes.dto.ExamDetailsDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.oes.dto.CourseDetailsDto"%>
<%@page import="java.util.List"%>
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
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html>
<html>
<head>
<sx:head/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>XamDesk</title>
<script type="text/javascript">
dojo.event.topic.publish("show_resultDetails");
</script>
<style>
.button {
  display: inline-block;
  border-radius: 4px;
  background-color: #f4511e;
  border: none;
  color: #FFFFFF;
  text-align: center;
  font-size: 14px;
  padding: 9px;
  width: 100px;
  transition: all 0.5s;
  cursor: pointer;
}

.button span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

.button span:after {
  content: '\00bb';
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.5s;
}

.button:hover span {
  padding-right: 25px;
}

.button:hover span:after {
  opacity: 1;
  right: 0;
}


{
    box-sizing: border-box;
}
.row::after {
    content: "";
    clear: both;
    display: table;
}
/* [class*="col-"] {
    float: left;
    padding: 15px;
} */

.col-3 {float: left; padding: 15px;}
.col-4 {float: left; padding: 15px;}
.col-5 {float: left;}
.col-6 {float: left; padding: 15px;}

.menu {
	background-color: #e1eef5;
    border-right: 1px solid #3A5665;
    padding: 0px;
    margin: 0px;
    cursor: pointer;
    margin-bottom: 0px;
    padding: 10px;
}
.menu ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
}
.menu li {
    padding: 8px;
    margin-bottom: 7px;
    background-color: #33b5e5;
    color: #ffffff;
    box-shadow: 0 1px 3px rgba(0,0,0,0.12), 0 1px 2px rgba(0,0,0,0.24);
}

.menu li a {
	color: #fff;
	text-decoration: none;
	text-transform: uppercase;
	font-weight: 800;
	font-size: 0.95em;
	letter-spacing: 0.075em;
	border-radius: 6px;
	outline: 0;
}

.menu li.current_page_item {
	background-color: rgba(245, 175, 71, 0.72);
}

.menu li:hover {
    background-color: #0099cc;
}
.aside {
   
    color: #ffffff;
    text-align: center;
    font-size: 12px;
    box-shadow: 0 1px 3px rgba(0,0,0,0.12), 0 1px 2px rgba(0,0,0,0.24);
    -webkit-border-radius: 20px 20px 0px 0px;
	-moz-border-radius: 20px 20px 0px 0px;
	 border-radius: 10px 10px 0px 0px;
	 border:2px solid #FFFFFF;
	 background:  #33b5e5;
	 -webkit-box-shadow: #B3B3B3 15px 15px 15px;
	
}
#asidecourse {
    padding: 15px;
    color: #ffffff;
    text-align: center;
    font-size: 15px;
    box-shadow: 0 1px 3px rgba(0,0,0,0.12), 0 1px 2px rgba(0,0,0,0.24);
    -webkit-border-radius: 20px 20px 0px 0px;
	-moz-border-radius: 20px 20px 20px 20px;
	 border-radius: 10px 10px 10px 10px;
	 border:2px solid #FFFFFF;
	 background:  #73bee8;
	 -webkit-box-shadow: #B3B3B3 5px 5px 5px;
	 cursor: pointer;
	 font-family: "Times New Roman", Times, serif;
}

#asidecourse:hover {
 	padding: 15px;
    color: #ffffff;
    text-align: center;
    font-size: 15px;
    box-shadow: 0 1px 3px rgba(0,0,0,0.12), 0 1px 2px rgba(0,0,0,0.24);
    -webkit-border-radius: 20px 20px 0px 0px;
	-moz-border-radius: 20px 20px 20px 20px;
	 border-radius: 10px 10px 10px 10px;
	 border:2px solid #FFFFFF;
	 
	 -webkit-box-shadow: #B3B3B3 5px 5px 5px;
	 cursor: pointer;
    background: #FFA833;
    font-family: "Times New Roman", Times, serif;
}

.buy_section {
	 box-shadow: 0 1px 3px rgba(0,0,0,0.12), 0 1px 2px rgba(0,0,0,0.24);
    -webkit-border-radius: 5px 5px 5px 5px;
	-moz-border-radius: 5px 5px 5px 5px;
	 border-radius: 5px 5px 5px 5px;
     background-color: rgb(239, 192, 119);
     -webkit-box-shadow: #B3B3B3 15px 15px 15px;    
     color: #ffffff;
     font-size: 12px;
}
.footer_small {
    background-color: #0099cc;
    color: #000000;
    text-align: center;
    font-size: 12px;
    padding: 10px;
}

ul#countdown{text-align:center;padding: 0px 0px 0px 0px;}
ul#countdown span {
	color: #FFF;
	font-size: 5em;
	font-weight: bold;
	text-align: center;
	display: inline-block;
	padding: 15px 30px;
}
ul#countdown h3{
	color: #fff;
	padding: 10px;
	margin-top: 0em;
}
ul#countdown li{
	display:inline-block;
	width: 15%;
}
ul#countdown li p.timeRefDays,
ul#countdown li p.timeRefHours,
ul#countdown li p.timeRefMinutes,
ul#countdown li p.timeRefSeconds {
	color: rgb(255, 255, 255);
	text-transform: uppercase;
	font-size: 1.2em;
}
.frist{
	background:#A7D802;
	-webkit-box-shadow: rgba(206, 206, 206, 0.84) 10px 10px 10px;
	-moz-box-shadow: rgba(206, 206, 206, 0.84) 10px 10px 10px;
	box-shadow: rgba(206, 206, 206, 0.84) 10px 10px 10px;
	border-radius: 5px 5px 5px 5px;
	border:2px solid #FFFFFF;  
}
.second{
	background:#E9A300;
	-webkit-box-shadow: rgba(206, 206, 206, 0.84) 10px 10px 10px;
	-moz-box-shadow: rgba(206, 206, 206, 0.84) 10px 10px 10px;
	box-shadow: rgba(206, 206, 206, 0.84) 10px 10px 10px;
	border-radius: 5px 5px 5px 5px;
	border:2px solid #FFFFFF;
}
.three{
	background:#F4C400;
	-webkit-box-shadow: rgba(206, 206, 206, 0.84) 10px 10px 10px;
	-moz-box-shadow: rgba(206, 206, 206, 0.84) 10px 10px 10px;
	box-shadow: rgba(206, 206, 206, 0.84) 10px 10px 10px;
	border-radius: 5px 5px 5px 5px;
	border:2px solid #FFFFFF;
}
.four{
	background:#A12BB8;
	-webkit-box-shadow: rgba(206, 206, 206, 0.84) 10px 10px 10px;
	-moz-box-shadow: rgba(206, 206, 206, 0.84) 10px 10px 10px;
	box-shadow: rgba(206, 206, 206, 0.84) 10px 10px 10px;
	border-radius: 5px 5px 5px 5px;
	border:2px solid #FFFFFF;
}


/* For mobile phones: */
[class*="col-"] {
    width: 100%;
}
@media only screen and (min-width: 768px) {
    /* For desktop: */
    .col-3 {width: 15%; height: 600px;}
    .col-4 {width: 16%;}
    .col-5 {width: 100%;}
    .col-6 {width: 80%;}
}
</style>
<script src="js/countdown.js" type="text/javascript"></script>	
	 
<script type="text/javascript">
$(document).ready(function() {
	   
	$("#countdown").countdown({
		date: "20 january 2019 11:30:00",
		format: "on"
	},
			
	function() {
		// callback function
		// alert("hello sumit");
	});
});	

function bodyLoad() {
	var btn_status = $("#button_status").val();
	if(btn_status == '1') {
		$("#button_details2").show();
		$("#button_details1").hide();
	} else {
		$("#button_details1").show();
		$("#button_details2").hide();
	}
}
var id_value = 0;

$(document).ajaxStart(function(){
    $("#wait").css("display", "block");
});
$(document).ajaxComplete(function(){
    $("#wait").css("display", "none");
});
function goback(){
	$("#course_details").show();
	$("#exam_details_page").html("");
	$("#backbutton").hide();
}
function showExamDEtails(course_id, i) {
	$("#exam_details_page").html("");
	//alert("Hello :"+course_id);
	//alert(i);
	$("#course_details").hide();
	if(course_id != "0") {
		var contextPath=$("#contextPath").val();	
		var url=contextPath+"/getExamSectionDetails";
	 	var datam={course_id : course_id, flag : "COURSE_EXAM_DETAILS"};
	  		$.ajax({
	   			type: "POST",
	   			url: url,
	   			data: datam,
	   
	   			success: function(response){
	   			 	$("#exam_details_page").html(response);
	   			 	$("#backbutton").show();
	   			}             
	  		});	
	} else {
		$("#exam_details_page").html("");
	}		
	
}

function submitpage(examId) {	
	var contextPath = $('#contextPath').val();
	contextPath = contextPath+"/purchaseExaminationDetails?slno="+examId;
	window.location.href = contextPath;	
}
</script>
<script type="text/javascript">
function registerforexamination() {
	
	var exam_details = $("#examination_details").val();
	
	if(exam_details != "") {
		var contextPath=$("#contextPath").val();	
		var url=contextPath+"/getExamSectionDetails";
	 	var datam={exam_details : exam_details, flag : "REGISTER_EXAM_DETAILS"};
	  		$.ajax({
	   			type: "POST",
	   			url: url,
	   			data: datam,
	   
	   			success: function(response){
	   			 	if(response == 'true') {
	   			 		$("#button_details").html("<b style='font-size: 12px; font-weight: bold; color: #40a0e9;'>Thanku for register with this examination.</b><br/><br/><input type='submit' value='Start Examination' style='width: 250px; height: 50px;  opacity: 0.65; cursor: not-allowed;' disabled='disabled'/>");
	   			 		$("#button_status").val('1');
	   			 	} else {
	   			 		alert("Due to some technical problem we are unable to submit your request");
	   			 	}
	   			}             
	  		});	
	} else {
		alert("Due to some technical problem we are unable to submit your request");
	}	
}
</script>
</head>
<body onload="bodyLoad();">

		<%
		List<DashBoardDto> dashBoardDtoList = new ArrayList<DashBoardDto>(); 
		dashBoardDtoList = (ArrayList<DashBoardDto>)request.getSession().getAttribute("dashBoardDtoList");
		
		if(dashBoardDtoList != null && dashBoardDtoList.size()>0) {
		
		DashBoardDto boardDto = new DashBoardDto();
		boardDto = dashBoardDtoList.get(0);
		
		String btn_status =  (String) request.getSession().getAttribute("register_button_status");
		%>	
		<input type="hidden" name="button_status" value="<%=btn_status%>" id="button_status"/>
		<%=boardDto.getOstr_dashboard()%>		
		
		<%
		AdminDetailDto adminDetailDto = new AdminDetailDto();
		adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
		
		if(adminDetailDto.getInum_role_id().equals(2)) {
		%>
		<div class="grid_10">
			<div class="box round first grid">
			<h2>New Assignment</h2>
				
			</div>
		</div>		
		
		<div class="grid_6">
			<div class="box round first grid">
			<h2>Result Details</h2>
			<div class="row">
				<%
				ResultDetailsDto resultDetailsDto = new ResultDetailsDto();
				resultDetailsDto = (ResultDetailsDto) request.getSession().getAttribute("resultDetailsDto");
				%>
				<table width="100%" style="border-collapse: collapse; text-align: left;">
				<tr>
					<td width="50%" style="padding: 15px; border-bottom: 1px solid #ddd; text-align: left;">Exam Name:&nbsp;&nbsp;<b><%=resultDetailsDto.getExamDetailsDto().getOstr_exam_name()%></b></td>
					<td width="30%" style="padding: 15px; border-bottom: 1px solid #ddd; text-align: left;">Date:&nbsp;&nbsp;<b><%=resultDetailsDto.getOstr_date()%></b></td>
					<td width="20%" style="padding: 15px; border-bottom: 1px solid #ddd; text-align: left;"><a href="showResultPage.action"><u>Click for Details</u></a></td>
				</tr>
				</table>
				<div style="max-height: 325px; min-height: 325px; overflow: scroll; margin-top: -20px; margin-bottom: -20px;">
				<%
				Map<Integer, ResultReviewSubjectDto> subjectMapDetails = new HashMap<Integer, ResultReviewSubjectDto>();
				subjectMapDetails = (HashMap<Integer, ResultReviewSubjectDto>) request.getSession().getAttribute("subjectMapDetails");
				
				if(subjectMapDetails != null && subjectMapDetails.size()>0) {
				%>
				    <div align="center">
						<table width="100%" style="border-collapse: collapse;">
						<tr style="background: #eee;">
							<th width="40%" style="background: #333; height: 20px; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left; font-size: 10px; font-weight: bold;">SUBJECT</th>
							<th width="15%" style="background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left; font-size: 10px; font-weight: bold;">TOTAL QUESTION</th>
							<th width="15%" style="background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left; font-size: 10px; font-weight: bold;">CORRECT</th>
							<th width="15%" style="background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left; font-size: 10px; font-weight: bold;">WRONG</th>
							<th width="15%" style="background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left; font-size: 10px; font-weight: bold;">UNATTEMPTED</th>
						</tr>
						<%for(Integer number : subjectMapDetails.keySet()) {
							ResultReviewSubjectDto resultReviewSubjectDto = new ResultReviewSubjectDto();
							resultReviewSubjectDto = subjectMapDetails.get(number);%>
							<tr style="background: #eee;">
							<td align="left" style="padding: 6px; border: 1px solid #ccc; height: 15px; font-size: 11px; font-weight: bold;"><%=resultReviewSubjectDto.getSectionDetailsDto().getSubCategoryDetailsDto().getOstr_sub_category_name()%></td>
							<td align="center" style="padding: 6px; border: 1px solid #ccc; height: 15px; font-size: 11px; font-weight: bold;"><%=resultReviewSubjectDto.getTotal_question()%></td>
							<td align="center" style="padding: 6px; border: 1px solid #ccc; height: 15px; font-size: 11px; font-weight: bold;"><%=resultReviewSubjectDto.getTotal_right()%></td>
							<td align="center" style="padding: 6px; border: 1px solid #ccc; height: 15px; font-size: 11px; font-weight: bold;"><%=resultReviewSubjectDto.getTotal_wrong()%></td>
							<td align="center" style="padding: 6px; border: 1px solid #ccc; height: 15px; font-size: 11px; font-weight: bold;"><%=resultReviewSubjectDto.getTotal_left()%></td>	
							</tr>
						<%}
						%>
						</table>
					</div>			
				<%
				}
				%>				
				<div id="piechart" style="margin-top: -20px;"></div>
				<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
				
				<script type="text/javascript">
				// Load google charts
				google.charts.load('current', {'packages':['corechart']});
				google.charts.setOnLoadCallback(drawChart);
				
				// Draw the chart and set the chart values
				function drawChart() {
				  var data = google.visualization.arrayToDataTable([
				  ['Task', 'Result Review'],
				  ['CORRECT', <%=resultDetailsDto.getOnum_wright()%>],
				  ['WRONG', <%=resultDetailsDto.getOnum_wrong()%>],
				  ['UNATTEMPTED', <%=resultDetailsDto.getOnum_left()%>]
				]);				
				  // Optional; add a title and set the width and height of the chart
				  var options = {'title':'Result Review', 'width':550, 'height':300};
				  // Display the chart inside the <div> element with id="piechart"
				  var chart = new google.visualization.PieChart(document.getElementById('piechart'));
				  chart.draw(data, options);
				}
				</script>
				</div>
				</div>
			
				<!-- 
				<s:form name="searchResultDetails" id="searchResultDetails">	
					<div id="waitresultpage" style="display: none;">
						loading...
					</div>					
					
					<s:url id="d_urlresultsearch" action="homePageResultSearchDetails.action"></s:url>
					<sx:div id="details" href="%{d_urlresultsearch}" listenTopics="show_resultDetails" formId="searchResultDetails" indicator="waitresultpage" cssClass="loading"></sx:div>
				</s:form>	
				 -->		
			</div>
		</div>		
		
		<%
		StudentDetailsDto studentDetailsDto = new StudentDetailsDto();
		studentDetailsDto = (StudentDetailsDto) request.getSession().getAttribute("studentDetailsDto");
		%>
		
		<div class="grid_4">
			<div class="box round first grid">
			<h2>Profile Details</h2>
				<div class="row">
				<table width="100%" style="border-collapse: collapse; text-align: left;">
				<tr style="padding: 15px;">
					<td width="40%" rowspan="4" style="padding: 15px;">
					<% 
						Base64Encoder encoder=new Base64Encoder();
					    if(studentDetailsDto != null){
						    if(studentDetailsDto.getIbl_std_pic() != null){
						       	%><img id="blah2" src='data:image/jpg;base64,<%= studentDetailsDto.getIbl_std_pic()%>' style="width: 130px; height: 145px;"/>
						  <%}else {	
								%><img id="blah" src="image/student-symbol-images.png" /><%
					 	    }
						} else {		
							%><img id="blah" src="image/student-symbol-images.png" /><%	
					    }
					%>
					</td>
					<td width="60%"  style="padding: 15px; border-bottom: 1px solid #ddd; text-align: left;">Name: &nbsp;&nbsp;<b><%=studentDetailsDto.getIstr_first_name()%>&nbsp;<%=studentDetailsDto.getIstr_last_name()%></b></td>
				</tr>
				<tr>
					<td width="60%" style="padding: 15px; border-bottom: 1px solid #ddd; text-align: left;">DOB:&nbsp;&nbsp;<b><%=studentDetailsDto.getIstr_date_of_birth()%></b></td>
				</tr>
				<tr>
					<td width="60%" style="padding: 15px; border-bottom: 1px solid #ddd; text-align: left;">ID:&nbsp;&nbsp;<b><%=studentDetailsDto.getIstr_unique_id()%></b></td>
				</tr>
				<tr>
					<td  width="60%" style="padding: 15px; border-bottom: 1px solid #ddd; text-align: left;">Email:&nbsp;&nbsp;<b><%=studentDetailsDto.getIstr_email()%></b></td>
				</tr>
				<tr>
					<td width="60%" style="padding: 15px; border-bottom: 1px solid #ddd; text-align: left;">Mobile No:&nbsp;&nbsp;<b><%=studentDetailsDto.getInum_mobile_number()%></b></td>
					<td width="40%" style="padding: 15px; border-bottom: 1px solid #ddd; text-align: left;">Gender:&nbsp;&nbsp;<b><%=studentDetailsDto.getIstr_gender()%></b></td>
				</tr>
				
				<tr>
					<td colspan="2"  style="padding: 15px; border-bottom: 1px solid #ddd; text-align: left;">Batch:&nbsp;&nbsp;<b><%=studentDetailsDto.getIstr_class()%></b></td>
				</tr>
				<tr>
					<td colspan="2"  style="padding: 15px; border-bottom: 1px solid #ddd; text-align: left;">Note : If Profile details are not correct please update using update button or contact your administration.</td>
				</tr>
				</table>
				
				<table style=" margin-top: -10px; margin-bottom: -20px;" width="100%">
				<tr>
					<td align="center">
					<a href="showUpdateProfilePage" class="button" style="vertical-align:middle"><span>Update </span></a>
					</td>
				</tr>
				</table>
				</div>
			</div>
		</div>
		
		<%
		List<CourseDetailsDto> courseDetailsDtoList = new ArrayList<CourseDetailsDto>(); 
		courseDetailsDtoList = (ArrayList<CourseDetailsDto>)request.getSession().getAttribute("courseDetailsDtoList");
		
		if(courseDetailsDtoList != null && courseDetailsDtoList.size()>0) {
			%>
			<div class="grid_10">
				<div class="box round first grid">
				<h2>Examination</h2>
					<div class="row">	
					<div id="backbutton" style="display: none;">
					</div>
					
					<div id="course_details">
					<%
					for(CourseDetailsDto dto : courseDetailsDtoList) {
					%>
						<div class="col-4">
							<div id="asidecourse" onclick="showExamDEtails('<%=dto.getOnum_slno()%>','0');">
							<img id="blah" src="course-img/<%=dto.getOimg_url()%>"/><br/>
							<%=dto.getOstr_course_name()%>
							</div>
							
						</div>
					<%
					}
					%>
					</div>
					<div align="center">
						<div id="wait" title="Wait...." style="display: none;">
						  	<div align="center" style="margin-top: 100px;">
									<img alt="" src="image/wait.gif" width="70px" height="70px"><br/>
									Loading...
									<br/>
									<br/>
							</div>
						</div>				
					</div>		
					<div id="exam_details_page"></div>
					</div>
					<br/><br/>
					<div class="footer_small" style="margin-bottom: -30px;">
				  		<p>We are updating our examination every week, All the Best.</p>
					</div>
				</div>
				</div>
			<%
		}
		%>
	<%} 
	}%>
<div class="clear"></div>	
<input type="hidden" id="contextPath" value="<%=request.getContextPath() %>" >


</body>
</html>