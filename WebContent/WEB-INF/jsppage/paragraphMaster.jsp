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

<script type="text/javascript">
		function deleteCategory(categoryId){
			
			var showBill=confirm("Are you sure you want to delete");
			
			if(showBill == true){
				
				 var contextPath = $('#contextPath').val();
					
				 contextPath = contextPath + "/deleteParagraphDetail?slno="+categoryId;
			
				 window.location.href = contextPath;
			}
			
		}


		function newUserRegistrationValidation() {
		
		var name = document.getElementById('ostr_paragraph_name').value;
		if (name == '') {
			
			alert('Please Enter Paragraph Name');
			document.getElementById('ostr_paragraph_name').focus();
			return false;
		}
		
		var ostr_paragraph_descriprion = document.getElementById('ostr_paragraph_descriprion').value;
		if (ostr_paragraph_descriprion == '') {
			
			alert('Please Enter Paragraph Description');
			document.getElementById('ostr_paragraph_descriprion').focus();
			return false;
		}
				
		return true;

	}
		
	</script>
</head>
<body>
	
<div class="grid_10">
	<div class="box round first grid">

    <h2>Paragraph Master</h2>
	<div align="center">
	<s:form autocomplete="off" action="saveParagraphDetailsDto" name="paragraphMasterDto" method="post" onsubmit="return(newUserRegistrationValidation())">
	<s:hidden name="randomStingJsp" id="randomStingJsp"/>
	<br/>
	<div class="message1" id="info"><s:property value="info"/></div>


	<table width="100%" style="margin-left: 20px;">
	
	 <tr>
	    <td width="20%" class="sms_admin_align" >
	    <s:hidden name="paragraphDetailsDto.onum_slno" />
	    <s:hidden name="paragraphDetailsDto.onum_is_active" />
	    <s:hidden name="paragraphDetailsDto.odt_entry_date" />    
	    
	    <b><label for="Source Name">Paragraph Name</label>:</b></td>
	    <td width="80%" >
	    	<s:textfield theme="simple" cssClass="text_field" cssStyle="width: 436px;" name="paragraphDetailsDto.ostr_paragraph_name" id="ostr_paragraph_name" tabindex="2" />
	    </td>
	 	</tr>
		<tr>	
			<td></td>
			<td><div class="message1"><s:property value="course_name"/></div></td>
	 	</tr>
	 	<tr>
	 		<td><b><label for="Source Name">Paragraph Description</label>:</b></td>
	    	<td>
	    		<s:textarea theme="simple" cols="70" rows="8" name="paragraphDetailsDto.ostr_paragraph_descriprion" id="ostr_paragraph_descriprion" tabindex="2"></s:textarea>
	    	</td>
		</tr>
	 <tr>
		<td colspan="2"><p>&nbsp;</p></td>
	</tr>
	
	</table>

	<!--  Button Start  -->
	<table width="98%" border="0" cellspacing="0" cellpadding="0">
	  <tr>    
	    <td width="100%">
	    <div align="center">   
		    <input type="submit" value="Submit" name="submit" tabindex="8" style="width:120px;" class="btn">
		    &nbsp;&nbsp;
		    <input type="reset" name="reset" value="Reset" tabindex="9" style="width:120px;" class="btn">
	    </div> 
	    </td>
	  </tr>
	</table>
	<!--  Button End  -->
</s:form>
</div>
</div>
</div>

<div class="grid_10">
	<div class="box round first grid">
		<div class="block">
		<table class="data display datatable" id="example" border="1" bordercolor="#B3CBD6">
			<thead>
			<tr>
				<th class="coll_align" width="10%">Sl No.</th>
				<th class="coll_align" width="70%">Paragraph Name</th>
				<th class="coll_align" width="10%">Edit</th>
				<th class="coll_align" width="10%">Delete</th>
			</tr>
		</thead>
		<tbody>
		
		<s:if test="paragraphDetailsDtoList != null">

			<s:if test="%{paragraphDetailsDtoList.isEmpty()}">

			</s:if>
			<s:else>
			<%
				int i = 1;
			%>
			<s:iterator value="paragraphDetailsDtoList" id="requestList">
				<tr class="odd">
					<td class="itemcenter5" width="5%"><%=i%></td>
					
					<td class="itemcenter5"><s:property value="ostr_paragraph_name" /></td>

					<td class="itemcenter5" width="5%"><a href="editParagraphDetail?slno=${requestList.onum_slno}"><img src='image/Edit-Male-User-icon.png'></a></td>

					<td class="itemcenter5" width="5%"><a href="#" onclick="deleteCategory('${requestList.onum_slno}');"><img src='image/user_remove.png'></a></td>
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
