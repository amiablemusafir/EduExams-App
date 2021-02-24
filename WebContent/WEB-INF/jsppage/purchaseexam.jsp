<!-- 
Author: Sumit Singh
Start Date: 27th March, 2014
Modify Date:
Modify By:
Motive: Admission Details
 -->
<%@page import="com.oes.dto.ExamSubCategoryDetailsDto"%>
<%@page import="com.oes.action.Encryption"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.oes.dto.ExamQuestionDetailsDto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="com.oes.dto.ExamDetailsDto"%>
<%@page import="com.sms.admin.dto.AdminDetailDto"%>
<%@page import="com.oes.dto.ExamSectionDetailsDto"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></head>
<style type="text/css">
		#container_body {
			width: 97%;
			float: left;
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
	</style>
	<script type="text/javascript">
	function submitpage(examId) {	
		var contextPath = $('#contextPath').val();
		contextPath = contextPath+"/purchaseExaminationDetailsCnf?slno="+examId;
		window.location.href = contextPath;	
	}

	</script>
<body>	
<div class="grid_10">
	<div class="box round first grid">
    <h2>Examination Details</h2>
    <div>
		<%
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
	    		<td align="center" style="font-size: 18px; font-weight: bold;"><img src="<%=examDetailsDto.getObl_exam_pic()%>" /><br/><%=examDetailsDto.getOstr_exam_name()%></td>
	   		</tr>
	   		
	   		<tr>
	    		<td align="center">&nbsp;</td>
	   		</tr>
	   		<tr>
	    		<td style="font-size: 20px;" align="center"><b>Instructions for the candidates & examination details</b></td>
	   		</tr>
	   		<tr>
	    		<td align="center"><hr/>&nbsp;</td>
	   		</tr>
	   		<tr>
	    		<td style="font-size: 12px;">
	    		<b>a) &nbsp;&nbsp;Total time duration for the exam is <%=examDetailsDto.getOdt_exam_time()%> (HH:MM).
	    		</b></td>
	   		</tr>
	   		<tr>
	    		<td>&nbsp;</td>
	   		</tr>
	   		<tr>
	    		<td style="font-size: 12px;">
	    		<b>b) &nbsp;&nbsp;There is no negative marking for the answer. So try to attempt all questions. 
	    		</b></td>
	   		</tr>
	   		<tr>
	    		<td>&nbsp;</td>
	   		</tr>
	   		<tr>
	    		<td style="font-size: 12px;">
	    		<b>c) &nbsp;&nbsp;You can choose the section as per your will from drop down menu on your question paper. 
	    		</b></td>
	   		</tr>
	   		<tr>
	    		<td>&nbsp;</td>
	   		</tr>
	   		<tr>
	    		<td style="font-size: 12px;">
	    		<b>d) &nbsp;&nbsp;You can leave the exam whenever you want. Just go to last question of the last section there you will find finish button. 
	    		</b></td>
	   		</tr>
	   		<tr>
	    		<td>&nbsp;</td>
	   		</tr>
	   		<% if(examDetailsDto.getOstr_price().equals("0.00") || examDetailsDto.getOstr_price().equals("0")) { %>
	   		<tr>
	    		<td style="font-size: 12px;">
	    		<b>e) &nbsp;&nbsp;The selected examination is <b style="color: red;">FREE</b> and you don't have to pay any charges for this examination. 
	    		</b></td>
	   		</tr>
	   		<% } %>
	    </table>
		
	   
	   <table width="100%">			
	   		<tr>
	    		<td align="center" colspan="3"><hr/></td>
	   		</tr>
	   		<tr>
	    		<td align="left" style="font-size: 14px; font-weight: bold; height: 40px;" colspan="1">Exam Name - <b><%=examDetailsDto.getOstr_exam_name()%></b></td>
	    		<td align="left" style="font-size: 14px; font-weight: bold; height: 40px;" colspan="1">Total Questions - <%=total_question%></td>
	   			<td align="right" style="font-size: 14px; font-weight: bold; height: 40px;" colspan="1">Time - <%=examDetailsDto.getOdt_exam_time()%> (HH:MM)</td>
	   		</tr>
	    </table>
	    
	   	<table style="border-collapse: collapse;" width="100%" border="1">
	   		<tr>
	    		<th align="center" colspan="4" style="background: #333; border: 1px solid #ccc; color: white; font-weight: bold; height: 20px;">Section Details</th>
	   		</tr>
	   		<tr>
	    		<th align="center" style="background: #333; border: 1px solid #ccc; color: white; font-weight: bold; height: 20px;">Sl No.</th>
	    		<th align="center" style="background: #333; border: 1px solid #ccc; color: white; font-weight: bold; height: 20px;">Section Name</th>
	    		<th align="center" style="background: #333; border: 1px solid #ccc; color: white; font-weight: bold; height: 20px;">Total Question</th>
	    		<th align="center" style="background: #333; border: 1px solid #ccc; color: white; font-weight: bold; height: 20px;">Total Mark</th>
	   		</tr>
	   		<%
	   		if(subCategoryMap != null && subCategoryMap.size()>0) {
	   			int i = 1;
	   			ExamSubCategoryDetailsDto dto = new ExamSubCategoryDetailsDto();
   				for(Integer subCategoryId: subCategoryMap.keySet()) {
   					
   					dto = subCategoryMap.get(subCategoryId);
	   				%>
			   		<tr>
			    		<td style="padding: 6px; background : #B3CBD6; border: 1px solid #ccc; border-color: #000000; text-align: left; font-size: 16px;"><div align="center"><%=i%></div></td>
			    		<td style="padding: 6px; background : #B3CBD6; border: 1px solid #ccc; border-color: #000000;  text-align: left; color: #00000; font-size: 12px;"><div style="color: #00000; font-size: 12px; font-weight: bold;"><%=dto.getSubCategoryDetailsDto().getOstr_sub_category_name() %></div></td>
			    		<td style="padding: 6px; background : #B3CBD6; border: 1px solid #ccc; border-color: #000000;  text-align: left; color: #00000; font-size: 12px;"><div align="center" style="color: #00000; font-size: 12px; font-weight: bold;"><%=dto.getOnum_total_question()%></div></td>
			    		<td style="padding: 6px; background : #B3CBD6; border: 1px solid #ccc; border-color: #000000;  text-align: left; color: #00000; font-size: 12px;"><div align="center" style="color: #00000; font-size: 12px; font-weight: bold;"><%=dto.getOnum_total_marks()%></div></td>
			   		</tr>
	   				<%
	   				i++;
	   			}
	   		}
	   		%>
	   		<tr>
			    <td colspan="4" style="padding: 6px; background : #B3CBD6; border: 1px solid #ccc; text-align: left; font-size: 16px;">
	   			<div style="color: #000000; font-size: 14px;" align="center"><b>Description </b></div><br/><div style="color: #000000; font-size: 12px; padding: 6px; line-height: 25px;"><%=examDetailsDto.getOstr_exam_description()%></div><br/>
	   			</td>	   	
	    	</table>
	    	
	    	<div style="color: rgb(249, 4, 4); font-size: 14px;" align="center"><b>Rs. <%=examDetailsDto.getOstr_price()%>/- </b></div>
	    </div> 
	    </div>
	    
	    
	    <div class="clear"></div>
		<hr style="width:95%; border-bottom:1px dotted  #CCCCCC;" />
	    	<div align="center">
	    	<input type="submit" class="btn" name="Buy" value="Submit & Confirm" style="width: 170px; height: 50px; margin-top: 3px; margin-bottom: 3px; color: #ffffff; font-size: 14px;" onclick="submitpage('<%=Encryption.encryptText(examDetailsDto.getOnum_id().toString())%>');">
	    	</div>
	   
	</div>
</div>

<input type="hidden" id="contextPath" value="<%=request.getContextPath() %>" >
</body>
</html>   
