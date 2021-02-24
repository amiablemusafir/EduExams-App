<!-- 
Author: Sumit Singh
Start Date: 27th March, 2014
Modify Date:
Modify By:
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

<script type="text/javascript">
		function deleteCategory(categoryId){
			
			var showBill=confirm("Are you sure you want to delete");
			
			if(showBill == true){
					
				 var contextPath = $('#contextPath').val();
					
				 contextPath = contextPath + "/deleteNoticeDetail?slno="+categoryId;
			
				 window.location.href = contextPath;
			}
			
		}
</script>
<body>


<div class="grid_10">
	<div class="box round first grid">

    <h2>Manage Notice Board</h2>
	<br/>
	${info}

	<s:form autocomplete="off" action="noticeDetails" method="post" class="form">
	<s:hidden name="randomStingJsp" id="randomStingJsp"/>
	
	<table style="margin-left: 40px;" width="98%">
		<tr>
		<td></td>
		<td></td>
		</tr>
		
		<tr>
		<td><b>Notice</b><font color="red">*</font>:<s:hidden name="noticeDto.gnum_slno" /></td>
		<td><br/><s:textarea cols="79" rows="4"  cssStyle="width: 80%; height: 70px;"  theme="simple" name="noticeDto.gstr_notice" id="gstr_notice" />
		</td>
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
</div>
</div>

<div class="grid_10">
	<div class="box round first grid">
		 <div class="block">
			 <table class="data display datatable" id="example" border="1" bordercolor="#B3CBD6">
			 <thead>
				<tr>
					<th width="15%">Sl No.</th>
					<th>Notice Board</th>
					<th width="10%">Edit</th>
					<th width="10%">Delete</th>
				</tr>
			 </thead>
			 <tbody>
		
			<s:if test="noticeDtoList != null">

			<s:if test="%{noticeDtoList.isEmpty()}">

			</s:if>
			<s:else>
			<%
				int i = 1;
			%>
			<s:iterator value="noticeDtoList" id="requestList">
				<tr>
					<td><%=i%></td>
					<td><s:property value="gstr_notice_headline" /></td>
					<td><a href="editNoticeDetail?slno=${requestList.gnum_slno}"><img src='image/Edit-Male-User-icon.png'></a></td>
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