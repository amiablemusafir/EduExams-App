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
<script type="text/javascript">
		function deleteCategory(categoryId){
			
			var showBill=confirm("Are you sure you want to delete");			
			if(showBill == true) {					
				 var contextPath = $('#contextPath').val();
					
				 contextPath = contextPath + "/deleteNewsAndEventsDetail?slno="+categoryId;
			
				 window.location.href = contextPath;
			}			
		}

		function newUserRegistrationValidation() {
		
			var headline = document.getElementById('gstr_headline').value;
			if (headline == '') {
				alert('Please Enter Headline');
				document.getElementById('gstr_headline').focus();

				return false;
			}
			var content = document.getElementById('gstr_content').value;
			if (content == '') {
				alert('Please Enter Content');
				document.getElementById('gstr_content').focus();

				return false;
			}
		
			return true;
		}
</script>
</head>
<body>
	
<div class="grid_10">
	<div class="box round first grid">

    <h2>Add/Update News & Events</h2>
	<s:form autocomplete="off" action="news" name="newsAndEventsDto" method="post" onsubmit="return(newUserRegistrationValidation())" class="form">
	<s:hidden name="randomStingJsp" id="randomStingJsp"/>
	<br/>
	<div id="info">${info}</div>
    
    
    	
	<table width="98%" border="0" cellspacing="0" cellpadding="0">
	<tr>	
		<td width="10%" height="10px;">&nbsp;</td>
		<td class="label">&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	                   						
	<tr>	
		<td width="10%"></td>
		<td class="col1"> <label><B>Headline : </B><font color="red">*</font><s:hidden name="newsAndEventsDto.gnum_slno" /></label></td>
		<td><s:textfield theme="simple" cssStyle="width: 80%;" name="newsAndEventsDto.gstr_headline" id="gstr_headline" cssClass="success"/></td>
	</tr>
	
	<tr>
		<td width="10%"></td>
		<td></td>
		<td><p>&nbsp;<s:fielderror fieldName="error1" cssStyle="color: red;"></s:fielderror></p></td>
	</tr>
	
	<tr>	
		<td width="10%"></td>
		<td style=" "><B>Content : </B><font color="red">*</font></td>
		<td><br/><s:textarea cols="80" rows="6" cssStyle="width: 80%; height: 70px;" theme="simple" name="newsAndEventsDto.gstr_content" id="gstr_content" /></td>
	</tr>
					
	<tr>
		<td width="10%"></td>
		<td></td>
		<td><p>&nbsp;<s:fielderror fieldName="error2" cssStyle="color: red;"></s:fielderror></p></td>
	</tr>
	</table>
								
	<!--  Button Start  -->
	<table width="98%" border="0" cellspacing="0" cellpadding="0">
	<tr>    
		<td width="100%">
		<div align="center">   
		<input type="submit" value="Submit" name="submit" tabindex="8" style="width:90px;" class="btn">
		&nbsp;&nbsp;
		<input type="reset" name="reset" value="Reset" tabindex="9" style="width:90px;" class="btn">
		&nbsp;&nbsp;
		<input type="button" value="Cancel" name="Cancel" style="width:90px;" class="btn">
		</div> 
		</td>
	</tr>
	</table>
	<!--  Button End  -->
			
			
	</s:form>
			
			
	<div class="clear"></div>
	</div>
	</div>
	
	<div class="grid_10">

            <div class="box round first grid">
	
	
	
	 <div class="block">

                    

                    

                    

                    <table class="data display datatable" id="example" border="1" bordercolor="#B3CBD6">

					<thead>
		<tr>
				<th width="15%">Sl No.</th>
				<th>Headline</th>
				<th width="15%">Edit</th>
				<th width="15%">Delete</th>
			</tr>
		</thead>
		<tbody>
		
		<s:if test="newsAndEventsDtoList != null">

			<s:if test="%{newsAndEventsDtoList.isEmpty()}">

			</s:if>
			<s:else>
			<%
				int i = 1;
			%>
			<s:iterator value="newsAndEventsDtoList" id="requestList">
				<tr class="gradeA">
					<td width="15%"><%=i%></td>

					<td><s:property value="gstr_headline" /></td>

					<td><a href="editNewsAndEventsDetail?slno=${requestList.gnum_slno}"><img src='image/Edit-Male-User-icon.png'></a></td>

					<td><a href="#" onclick="deleteCategory('${requestList.gnum_slno}');"><img src='image/user_remove.png'></a></td>
				</tr>
			<%
				i++;
			%>
			</s:iterator>
			</s:else>
		</s:if>
	</tbody>
	</table>
</div>
</div>
</div>

<input type="hidden" id="contextPath" value="<%=request.getContextPath() %>" >
</body>
</html>   
