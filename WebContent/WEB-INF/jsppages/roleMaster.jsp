<!-- 
Author: Himanshu Bharti
Start Date: 24th Sep, 2013
Modify Date:
Modify By:
Motive: To enter Role Master Data
 -->
<%@page isThreadSafe="true" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% 
	response.setHeader("pragma","no-cache");//HTTP 1.1 
	response.setHeader("Cache-Control","no-cache"); 
	response.setHeader("Cache-Control","no-store"); 
	response.setHeader("Cache-Control","must-revalidate");
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
			
		 contextPath = contextPath + "/deleteRoleMasterDetail.action?role_id="+categoryId;
	
		 window.location.href = contextPath;
	}
	
}
</script>
</head>

<body>
<div class="grid_10">
	<div class="box round first grid">

    <h2>Role Master</h2>

	<div align="center">
	<s:form autocomplete="off" action="saveRoleMaster" name="roleMasterDto" method="post" onsubmit="">
	<div class="dms_display_message"><s:property value="info"/></div>

	<table width="60%">

	 <tr>
	    <td>
	   		<s:hidden name="roleMasterDto.inum_role_id" />    
		    <label for="Board Name"><b>Role Name</b></label>:</td>
	    <td>
	    	<s:textfield theme="simple" cssClass="text_field" name="roleMasterDto.istr_role_name" id="istr_role_name" tabindex="1" />
	    </td>
	 </tr>
 <tr>	
	<td></td>
	<td><div class="message1"><s:property value="role_name"/></div></td>
 </tr>
 <tr>
 <td>
    <label for="Board Name"><b>Role Description</b></label>:</td>
 <td>
    <s:textfield theme="simple" cssClass="text_field" name="roleMasterDto.istr_role_desc" id="istr_role_desc" tabindex="2" />
    
    </td>
 </tr>
 <tr>	
	<td></td>
	<td><div class="message1"><s:property value="role_desc"/></div></td>
 </tr>	
 <tr>
	<td colspan="2"><p>&nbsp;</p></td>
</tr>
<tr>
	<td colspan="2"><div align="center">
	
	<input class="btn" type="submit" value="Submit" tabindex="2"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input class="btn" type="reset" value="Reset" tabindex="3"/>
	
	</div></td>
</tr>
</table>


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
					<th width="15%">Sl No.</th>
					<th>Role</th>
					<th>Description</th>
					<th width="10%">Edit</th>
					<th width="10%">Delete</th>
				</tr>
			 </thead>
			 <tbody>
		
			<s:if test="roleMasterDtoList != null">

			<s:if test="%{roleMasterDtoList.isEmpty()}">

			</s:if>
			<s:else>
			<%
				int i = 1;
			%>
			<s:iterator value="roleMasterDtoList" id="requestList">
				<tr>
					<td><%=i%></td>
					<td><s:property value="istr_role_name" /></td>
					<td><s:property value="istr_role_desc" /></td>
					<td><a href="editRoleMasterDetail.action?role_id=${requestList.inum_role_id}"><img src='image/Edit-Male-User-icon.png'></a></td>
					<td><a href="#" onclick="deleteCategory('${requestList.inum_role_id}');"><img src='image/user_remove.png'></a></td>
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

<input type="hidden" id="contextPath" value="<%= request.getContextPath() %>" >

</body>
</html> 