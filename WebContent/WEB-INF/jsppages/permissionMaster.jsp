<!-- 
Author: Himanshu Bharti
Start Date: 24th Sep, 2013
Modify Date: 
Modify By:
Motive: To enter Permission Master Data
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
function getPermissionDetails() {
	
	var data = $("#inum_is_parent").val();
	if(data == '1') {
	
		var contextPath=$("#contextPath").val();	
		var url=contextPath+"/showParentPermissionCombo";
	 	var datam={is_parent : data, flag : "GET_PARENT_PERMISSION_COMBO"};
	  		$.ajax({
	   			type: "POST",
	   			url: url,
	   			data: datam,
	   
	   			success: function(response){
	   			 	 $("#permission_parent_id").html(response);
	   			}             
	  	});			
	} else {
		$("#permission_parent_id").html("");
	}
}


</script>
<script type="text/javascript">

function deleteCategory(categoryId){
	
	var showBill=confirm("Are you sure you want to delete");
	
	if(showBill == true){
			
		 var contextPath = $('#contextPath').val();
			
		 contextPath = contextPath + "/deletePermissionMasterDetails.action?permission_id="+categoryId;
	
		 window.location.href = contextPath;
	}
	
}
</script>
</head>
<s:actionerror />
<body>
<div class="grid_10">
	<div class="box round first grid">

    <h2>Role Permission Master</h2>
	<div align="center">
	<s:form autocomplete="off" name="permissionMasterDto" action="savePermissionMaster"  method="post" onsubmit="">
	<div class="dms_display_message" id="info"><s:property value="info"/></div>
	<br/>
	<table width="40%">

	  <tr>
	    <td align="right"><s:hidden name="permissionMasterDto.inum_permission_id" /><label for="Permission Name"><B>Permission Name</B></label>:</td>
	    <td><s:textfield theme="simple" cssClass="text_field" name="permissionMasterDto.istr_permission_name" id="istr_permission_name" /></td>
	  </tr>
	  <tr>
	    <td align="right"><label for="Permission Name"><B>Permission URL</B></label>:</td>
	    <td><s:textfield theme="simple" cssClass="text_field" name="permissionMasterDto.istr_permission_url" id="istr_permission_url" /></td>
	  </tr>
 
	  <tr>
	    <td align="right"><label for="Role Name"><B>Permission Description</B></label>:</td>
	    <td><s:textfield theme="simple" cssClass="text_field" name="permissionMasterDto.istr_permission_desc" id="istr_permission_desc" /></td>
	  </tr>
	  <tr>
	    <td align="right"><label for="Role Name"><B>Is Parent</B></label>:</td>
	    <td><div class="styled-select2"><s:select theme="simple" list="#{'0':'Select','0':'No','1':'Yes'}" name="permissionMasterDto.inum_is_parent" id="inum_is_parent" 
		 cssClass="parent_class" onchange="getPermissionDetails();"></s:select></div></td>
	  </tr>

	 <tr id="permission_parent_id">
			<td colspan="2"><s:hidden name='permissionMasterDto.inum_parent_permission_id' id='parent_permission_id' value="0"/></td>
	 </tr>

	 <tr><td>&nbsp;</td></tr>
	 <tr>
		<td colspan="2"><div align="center"><input type="submit" value="Submit" class="btn"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="reset" value="Reset" class="btn"/></div></td>
	 </tr>
	</table>

<br/>
<br/>
<input type="hidden" name="contextPath" id="contextPath" value="<%=request.getContextPath()%>">
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
					<th>Permission Name</th>
					<th>Description</th>
					<th width="10%">Edit</th>
					<th width="10%">Delete</th>
				</tr>
			 </thead>
			 <tbody>
		
			<s:if test="permissionMasterDtoList != null">

			<s:if test="%{permissionMasterDtoList.isEmpty()}">

			</s:if>
			<s:else>
			<%
				int i = 1;
			%>
			<s:iterator value="permissionMasterDtoList" id="requestList">
				<tr>
					<td><%=i%></td>
					<td><s:property value="istr_permission_name" /></td>
					<td><s:property value="istr_permission_desc" /></td>
					<td><a href="editPermissionMasterDetail.action?permission_id=${requestList.inum_permission_id}"><img src='image/Edit-Male-User-icon.png'></a></td>
					<td><a href="#" onclick="deleteCategory('${requestList.inum_permission_id}');"><img src='image/user_remove.png'></a></td>
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
 
</body>
</html>