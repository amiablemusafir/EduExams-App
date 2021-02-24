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

<script src="js/tinymce/tinymce.dev.js"></script>
<script src="js/tinymce/plugins/table/plugin.dev.js"></script>
<script src="/js/tinymce/plugins/paste/plugin.dev.js"></script>
<script src="/js/tinymce/plugins/spellchecker/plugin.dev.js"></script>

<script type="text/javascript">
function deleteCategory(categoryId){
	
	var showBill=confirm("Are you sure you want to delete");
	
	if(showBill == true){
			
		 var contextPath = $('#contextPath').val();
			
		 contextPath = contextPath + "/deleteBlogDetail?slno="+categoryId;
	
		 window.location.href = contextPath;
	}
	
}

function newUserRegistrationValidation() {
		
	/* alert(tinymce.get('create_blog').getContent()); */
	
	$("#message_error").html("");
	$("#info").html("");
	
	var onum_slno = document.getElementById('onum_slno').value;
	if (onum_slno == '0') {
		$("#info").html("Please Select Content Type");
		document.getElementById('onum_slno').focus();

		return false;
	}
	
	var ostr_headline = document.getElementById('onum_slno').value;
	if (ostr_headline == '') {
		$("#info").html("Please Enter Headline");
		document.getElementById('ostr_headline').focus();

		return false;
	}
	
	var ostr_image_url = document.getElementById('ostr_image_url').value;
	if (ostr_headline == '') {
		$("#info").html("Please Enter Image Url");
		document.getElementById('ostr_image_url').focus();

		return false;
	}
	
	var ostr_short_description = document.getElementById('ostr_short_description').value;
	if (ostr_short_description == '') {
		$("#info").html("Please Enter Short Description");
		document.getElementById('ostr_short_description').focus();

		return false;
	}
	
	var ostr_message = tinymce.get('create_blog').getContent();
	if (ostr_message == '') {
		$("#info").html("Please Enter Message");
		document.getElementById('create_blog').focus();

		return false;
	} else {
		$("#ostr_message").val(ostr_message);
	}
		
	return true;

}
</script>
<script>
	tinymce.init({
		selector: "textarea#create_blog",
		theme: "modern",
		plugins: [
			"advlist autolink link image lists charmap print preview hr anchor pagebreak spellchecker",
			"searchreplace wordcount visualblocks visualchars code fullscreen insertdatetime media nonbreaking",
			"save table contextmenu directionality emoticons template paste textcolor importcss"
		],
		content_css: "css/development.css",
		add_unload_trigger: false,

		toolbar1: "undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image | print preview media fullpage | forecolor backcolor emoticons table",
		toolbar2: "custompanelbutton textbutton spellchecker",

		image_advtab: true,

		style_formats: [
			{title: 'Bold text', format: 'h1'},
			{title: 'Red text', inline: 'span', styles: {color: '#ff0000'}},
			{title: 'Red header', block: 'h1', styles: {color: '#ff0000'}},
			{title: 'Example 1', inline: 'span', classes: 'example1'},
			{title: 'Example 2', inline: 'span', classes: 'example2'},
			{title: 'Table styles'},
			{title: 'Table row 1', selector: 'tr', classes: 'tablerow1'}
		],

		template_replace_values : {
			username : "Sumit Singh"
		},

		template_preview_replace_values : {
			username : "Xamdesk"
		},

		//file_browser_callback: function() {},

		templates: [ 
			{title: 'Some title 1', description: 'Some desc 1', content: '<strong class="red">My content: {$username}</strong>'}, 
			{title: 'Some title 2', description: 'Some desc 2', url: 'development.html'} 
		],

		setup: function(ed) {
			ed.addButton('custompanelbutton', {
				type: 'panelbutton',
				text: 'Panel',
				panel: {
					type: 'form',
					items: [
						{type: 'button', text: 'Ok'},
						{type: 'button', text: 'Cancel'}
					]
				}
			});

			ed.addButton('textbutton', {
				type: 'button',
				text: 'Text'
			});
		},

		spellchecker_callback: function(method, words, callback) {
			if (method == "spellcheck") {
				var suggestions = {};

				for (var i = 0; i < words.length; i++) {
					suggestions[words[i]] = ["First", "second"];
				}

				callback(suggestions);
			}
		}
	});
	
</script>
<style>
*:focus {
	outline: 1px solid red !important;
}
</style>
</head>
<body>
<div class="grid_10">
	<div class="box round first grid">

    <h2>Create Student Materials</h2>
	<div class="dms_display_message" id="info"><s:property value="info" /></div>	
	
	<div align="center">
	<s:form autocomplete="off" action="saveOrUpdateBlogDetailsDto" name="saveOrUpdateBlogDetailsDto" method="post" onsubmit="return(newUserRegistrationValidation())">
	<s:hidden name="randomStingJsp" id="randomStingJsp"/>
	<table width="80%">
	<tr>
  		<td width="20%"><label for="Unique ID"><b>Content Type</b></label>:</td>
    	<td>   
    	<div class="styled-select2">
    	<s:if test="contentDetailsDtoList == null">
				<select id="onum_slno" name="blogDetailsDto.contentDetailsDto.onum_slno" tabindex="1">
					<option value="0">Select</option>
				</select>
		</s:if>
		<s:else>
    			<s:select theme="simple" list="contentDetailsDtoList"
						id="onum_slno" listKey="onum_slno"
						listValue="ostr_content_name"
						name="blogDetailsDto.contentDetailsDto.onum_slno"
						headerKey="0" headerValue="Select"
						onChange="" tabindex="1"></s:select>
	 	</s:else> 
	 	</div>
     	</td>
  	</tr>
  	<tr>
  		<td><label for="Unique ID"><b>Content Headline</b></label>:</td>
    	<td><s:textfield theme="simple" name="blogDetailsDto.ostr_headline" cssClass="text_field" id="ostr_headline" tabindex="6" cssStyle="width: 100%"/></td>
    </tr>
    	
    <tr>
  		<td><label for="Unique ID"><b>Image URL</b></label>:</td>
    	<td><s:textfield theme="simple" name="blogDetailsDto.ostr_image_url" cssClass="text_field" id="ostr_image_url" tabindex="6" cssStyle="width: 100%"/></td>
    </tr>
    <tr>
  		<td><label for="Unique ID"><b>Image URL</b></label>:</td>
    	<td><s:textarea theme="simple" cols="78" rows="4" cssStyle="width: 100%; height: 70px;" name="blogDetailsDto.ostr_short_description" id="ostr_short_description" tabindex="3"/></td>
    </tr>
  	<tr>	
		<td></td>
		<td><div class="message1" id="content_error"><i>Not more than 40 words.</i></div></td>
 	</tr>
 	</table>
	
	
	
	<textarea id="create_blog" name="create_blog" rows="15" cols="80" style="width: 80%"><s:property value="blogDetailsDto.ostr_message" /></textarea>
	<s:hidden name="blogDetailsDto.ostr_message" id="ostr_message"></s:hidden>							
	<s:hidden name="blogDetailsDto.onum_id"></s:hidden>
	
								
	<table width="100%">
	<tr>
		<td>
		<div align="center">
			<input type="submit" value="Submit" style="width: 100px; height: 30px;" class="btn"/>&nbsp;&nbsp;&nbsp;
			<input type="reset" value="Reset" style="width: 100px; height: 30px;" class="btn"/>
		</div>
		</td>
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
				<th width="10%">Sl No.</th>
				<th width="10%">Content Type</th>
				<th>Headline</th>
				<th width="10%">Edit</th>
				<th width="10%">Delete</th>
			</tr>
		 </thead>
		<tbody>
		
		<s:if test="blogDetailsDtoList != null">

			<s:if test="%{blogDetailsDtoList.isEmpty()}">
				
			</s:if>
			<s:else>
			<%
				int i = 1;
			%>
			<s:iterator value="blogDetailsDtoList" id="requestList">
				<tr>
					<td><%=i%></td>

					<td><s:property value="contentDetailsDto.ostr_content_name" /></td>
					
					<td><s:property value="ostr_headline" /></td>
					
					<td><a href="editBlogDetail?slno=${requestList.onum_id}"><img src='image/Edit-Male-User-icon.png'></a></td>
					<td><a href="#" onclick="deleteCategory('${requestList.onum_id}');"><img src='image/user_remove.png'></a></td>
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
