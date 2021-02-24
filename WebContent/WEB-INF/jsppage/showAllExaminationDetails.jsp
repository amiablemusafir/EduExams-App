<!-- 
Author: Sumit Singh
Start Date: 27th March, 2014
Modify Date:
Modify By:
Motive: Admission Details
-->
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
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>XamDesk</title>
<style>
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
    padding: 15px;
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
/* For mobile phones: */
[class*="col-"] {
    width: 100%;
}
@media only screen and (min-width: 768px) {
    /* For desktop: */
    .col-3 {width: 15%; min-height: 600px;}
    .col-4 {width: 20%;}
    .col-5 {width: 100%;}
    .col-6 {width: 80%;}
}
</style>
<script type="text/javascript">
var id_value = 0;

$(document).ajaxStart(function(){
    $("#wait").css("display", "block");
});
$(document).ajaxComplete(function(){
    $("#wait").css("display", "none");
});

function showExamDEtails(course_id, i) {
	
	var el1 = document.getElementById("li_tag"+id_value);
	el1.classList.remove("current_page_item");
	
	var el2 = document.getElementById("li_tag"+i);
	el2.classList.add("current_page_item");
	id_value = i;
	
	$("#exam_details_page").html("");
	//alert("Hello :"+course_id);
	//alert(i);
	
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
</head>
<body>
<%
		List<CourseDetailsDto> courseDetailsDtoList = new ArrayList<CourseDetailsDto>(); 
		courseDetailsDtoList = (ArrayList<CourseDetailsDto>)request.getSession().getAttribute("courseDetailsDtoList");
		
		if(courseDetailsDtoList != null && courseDetailsDtoList.size()>0) {
			%>
			<div class="grid_10">
				<div class="box round first grid">
				<h2>Examination</h2>
					<div class="row">	
					<div class="col-3 menu" style="height: auto;">
		  			<ul style="margin-top: 10px; font-family: Lucida Sans, sans-serif;">		    		
					<%
					int i = 0;
					for(CourseDetailsDto dto : courseDetailsDtoList) {
						if(i == 0) {
							%>
							<li class="current_page_item" id="li_tag<%=i%>" style=" margin-left: 5px; margin-right: 5px;" onclick="showExamDEtails('<%=dto.getOnum_slno()%>','<%=i%>');"><%=dto.getOstr_course_name()%></li>
							<%
						} else {
							%>
							<li id="li_tag<%=i%>" style="margin-left: 5px; margin-right: 5px;" onclick="showExamDEtails('<%=dto.getOnum_slno()%>','<%=i%>');"><%=dto.getOstr_course_name()%></li>
							<%
						}
						i++;
					}
					%>
					</ul>
					</div>
					<div class="col-6">
						<div id="wait" title="Wait...." style="display: none;">
						  	<div align="center" style="margin-top: 100px;">
									<img alt="" src="image/wait.gif" width="70px" height="70px"><br/>
									Loading...
							</div>
						</div>
						
						<div id="exam_details_page">		  					
						<%
						List<ExamDetailsDto> examDetailsDtoList = new ArrayList<ExamDetailsDto>(); 
						examDetailsDtoList = (ArrayList<ExamDetailsDto>)request.getSession().getAttribute("examDetailsDtoList");
						
						ExamDetailsDto examDetailsDto = new ExamDetailsDto();
						if(examDetailsDtoList != null && examDetailsDtoList.size()>0) {
							examDetailsDto = examDetailsDtoList.get(0);							
							%>
							<h1 style="margin-top: 5px;"><%=examDetailsDto.getCourseDetailsDto().getOstr_course_name() %></h1>
		  		    		<p><%=examDetailsDto.getCourseDetailsDto().getOstr_course_details() %></p>	  		    	
		  		    		<%
		  		    		List<StudentMappedExamDetailsDto> studentMappedExamDetailsDtoList = new ArrayList<StudentMappedExamDetailsDto>(); 
		  		    		studentMappedExamDetailsDtoList = (ArrayList<StudentMappedExamDetailsDto>)request.getSession().getAttribute("studentMappedExamDetailsDtoList");
							
		  		    		for(ExamDetailsDto dto : examDetailsDtoList) {
		  		    			%>
		  		    			<div class="col-4">
								<div class="aside">
									
									<%
									if(dto.getObl_exam_pic() != null) {
										%><img id="blah" src="<%=dto.getObl_exam_pic() %>" style="width : 100%; height : 100%;"/><%
									} else {
										%><img id="blah" src="image/xamdesk_default_exam.jpg" style="width : 100%; height : 100%;"/><%
									}
									%>
									<p><%=dto.getOstr_exam_name()%></p>
									<div class="col-5">
									<div class="buy_section">
									<%
									int j = 0;
									if(studentMappedExamDetailsDtoList != null && studentMappedExamDetailsDtoList.size()>0) {
										for(StudentMappedExamDetailsDto stdDto : studentMappedExamDetailsDtoList) {
											if(stdDto.getExamDetailsDto().getOnum_id().equals(dto.getOnum_id())) {
												j = 1;
											}										
										}
									}
									
									if(j == 0) {
										%><p style="color: #000000;"><b><img src="img/rupee.png" style="height: 12px;"> <%=dto.getOstr_price()%> &nbsp;&nbsp;</b>
										<%if(dto.getOstr_price().equals("0")) {%>
										<input type="submit" name="Try" value="Try" style="width: 60px; height: 30px; margin-top: 3px; margin-bottom: 3px;" class="btn" onclick="submitpage('<%=Encryption.encryptText(dto.getOnum_id().toString())%>');"></p><%
										} else {%>
										<input type="submit" name="Buy" value="Buy" style="width: 60px; height: 30px; margin-top: 3px; margin-bottom: 3px;" class="btn" onclick="submitpage('<%=Encryption.encryptText(dto.getOnum_id().toString())%>');"></p><%	
										}
									} else {
										%><p style="color: #000000;"><b><img src="img/rupee.png" style="height: 12px;"><strike><%=dto.getOstr_price()%> </strike>&nbsp;&nbsp;</b><%
										if(dto.getOstr_price().equals("0")) {%>
										<input type="submit" disabled="disabled" name="Try" value="Try" style="width: 60px; height: 30px; margin-top: 3px; margin-bottom: 3px;" onclick="submitpage('<%=Encryption.encryptText(dto.getOnum_id().toString())%>');"></p>
										<%} else {%>
										<input type="submit" disabled="disabled" name="Buy" value="Buy" style="width: 60px; height: 30px; margin-top: 3px; margin-bottom: 3px;" onclick="submitpage('<%=Encryption.encryptText(dto.getOnum_id().toString())%>');"></p>	
										<%}
									}
									%>
									</div>
									</div>
									</div>
									</div>
								<%
		  		    		}
						}
						%>
					</div>
					</div>		
					</div>
					
					<div class="footer_small" style="margin-bottom: -30px;">
				  		<p>We are updating our examination every week, All the Best.</p>
					</div>
				</div>
			</div>
			<%
		}
		%>

<div class="clear"></div>	
<input type="hidden" id="contextPath" value="<%=request.getContextPath() %>" >


</body>
</html>