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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="/tags/custom-tag"%>
<s:actionerror />
<html>

<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="style/dms.css" rel="stylesheet">
<script type="text/javascript" src="js/stock.js"></script>

<script type="text/javascript">
 function moveRightSingle(list1,list2)
 {	
	
	 		$("#info").html("");
			var	firstMenuObj  = document.getElementsByName(list1)[0];
			var secondMenuObj = document.getElementsByName(list2)[0];
			if(firstMenuObj.value=="")
			{
				$("#info").html("Please select the Data First");
				return false;
			}	
			var totalElement  = firstMenuObj.length;
			var val1 = "";
			var val2 = "";
			
			var t1 = 0;
			var flag=0;
			var i;
			for( i=0;i<totalElement;i++)
			{
				if(firstMenuObj.options[i].selected)
				{
					
					flag++;
				}	
			}	
							
			for(i=0;i<totalElement;i++)
			{
				if(firstMenuObj.options[i].selected)
				{
					
					val1 = firstMenuObj.options[i].value;
					val2 = firstMenuObj.options[i].text;			
				
					t1 = secondMenuObj.length;							
					secondMenuObj.length = (t1+1);				
					
					secondMenuObj.options[t1].value = val1;
					secondMenuObj.options[t1].text  = val2;					
					
				}
			}
					
	       deleteThis(secondMenuObj,firstMenuObj);			
			secondMenuObj.selectedIndex=secondMenuObj.options.length-1;
			
			populateList();	
			
}
function populateList()
{
	var	firstMenuObj  = document.getElementsByName('examinationBatchMappingDto.rightList')[0];
	document.getElementsByName('examinationBatchMappingDto.strChosenitems')[0].value="";
	for(var i=0;i<firstMenuObj.length;i++)
	{
		//if(firstMenuObj.options[i].selected)
		//{
			val1 = firstMenuObj.options[i].value;
			val2 = firstMenuObj.options[i].text;
			document.getElementsByName('examinationBatchMappingDto.strChosenitems')[0].value+=firstMenuObj.options[i].value+'@';				
			
		//}
	}
	//alert(document.getElementsByName('rolePermissionMasterDto.strChosenitems')[0].value);

}
function deleteThis(srcMenuObj,targetMenuObj)
{	
			var t =0;
			var val1 = "";
			var val2 = "";		
			var len  = targetMenuObj.length;
			var len2 = srcMenuObj.length;					
			var a1 = new Array(len);
			var a2 = new Array(len);	
			var a3 = new Array(len2);	
			
			for(var i=0;i<len;i++)
			{		
				a1[i]= targetMenuObj.options[i].value;
				a2[i]= targetMenuObj.options[i].text;					
			}	
			
			for( i=0;i<len2;i++)
			{		
				a3[i]= srcMenuObj.options[i].value;
			}
				
			targetMenuObj.length = 0;	
			var counter = 0;	
			var k = 0;	
			var flag = 0;
					
			for(i=0;i<len;i++)
			{		
					flag = 0;
				for(k=0;k<len2;k++)
				{		
					if(a1[i]==a3[k])
					{	
						flag = 1;					
					}					
				}		
				if(flag==0)
				{
					targetMenuObj.length = (counter+1);
					targetMenuObj.options[counter].value = a1[i];
					targetMenuObj.options[counter].text  = a2[i]; 
					counter++;			
				}		
			}			
}

	function OnTransferBtnClick(blnFromLeft) {
		//var lstLeft = ;
		var LeftListBox = document.getElementById('inum_permission_id');
		//alert(LeftListBox);
		var RightListBox = document.getElementById('inum_role_permission_id');
		var ListItems = new Array();
		FromList = (blnFromLeft ? LeftListBox : RightListBox);
		ToList = (blnFromLeft ? RightListBox : LeftListBox);
		for ( var i = (FromList.options.length - 1); i >= 0; i--)
			if (FromList.options[i].selected) {
				ListItems[ListItems.length] = new Option(
						FromList.options[i].text);
				FromList.options[i] = null;
			}
		for ( var i = ListItems.length - 1; i >= 0; i--)
			ToList.options[ToList.options.length] = ListItems[i];
	}

</script>
</head>
<%
String contextPath = request.getContextPath();
%>

<body>
<div class="grid_10">
	<div class="box round first grid">

    <h2>Role Permission Master</h2>
	<s:form autocomplete="off" name="examinationBatchMappingDto" action="saveExaminationBatchMappingDto.action" onsubmit="" method="post">
	<div class="dms_display_message" id="info" style="color: maroon;"><s:property value="messages"/></div>
		<s:hidden name="contextPath" />
		<s:hidden name="examinationBatchMappingDto.strChosenitems" id="examinationBatchMappingDto.strChosenitems" />
			
		 <table width="100%">
		   
			<tr>
				<td width="45%" class="dms_admin_align" style="color: #000;"><b>Batch Name</b><font color="red">*</font>:</td>
				<td width="55%">
				<div class="styled-select2">
				<s:select theme="simple" cssClass="select" list="batchMasterDtoList"
						id="onum_slno" listKey="onum_slno"
						listValue="ostr_batch_name"
						name="batchMasterDto.onum_slno"
						headerKey="0" headerValue="Select Batch"
						onChange="updateBatchExamDetails();">
					</s:select></div>
				</td>
				<td>&nbsp;</td>
			</tr>
			
			<tr><td colspan="2"><br/><br/></td></tr>
			
			<tr>
			
			
			
			<td colspan="2" width="98%" align="center">
					<table>
					<tr>
				<td><div id="leftList" style="display: none">
						<select class="styled-dms_list" name='examinationBatchMappingDto.leftList' multiple="multiple" style="width:100px;height:auto;"></select>
					</div></td>
				<td>
					<div id="listButton" style="display: none;">
						<table>
						<tr>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;<input Type='Button' Name='btnLtoR' Value='> >' class='btn' onclick='moveRightSingle("examinationBatchMappingDto.leftList","examinationBatchMappingDto.rightList")' />&nbsp;&nbsp;&nbsp;&nbsp;</td>
						</tr>
						
						<tr>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;<input class='btn' Type='Button' Name='btnRtoL' Value='< <' onclick='moveRightSingle("examinationBatchMappingDto.rightList","examinationBatchMappingDto.leftList")'/>&nbsp;&nbsp;&nbsp;&nbsp;</td>
						</tr>
						</table>
						 
						
					</div>
				</td>
				<td><div id="rightList" style="display: none;">
						<select class="styled-dms_list" name='examinationBatchMappingDto.rightList' multiple="multiple" style="width:100px;height:auto;"></select>
					</div></td>
			</tr>
					</table>
			</td>
			</tr>
			<tr>
				<td colspan="4"><p>&nbsp;</p>
				</td>
				<td>&nbsp;
				</td>
				<td>&nbsp;
				</td>
			</tr>	
			<tr>
				<td colspan="4"><div align="center"><input class="btn" type="submit" value="Submit" id="submit"/></div></td>
				<td>&nbsp;
				</td>
				<td>&nbsp;
				</td>
			</tr>
		</table>
		<br/>
		<br/>

<input type="hidden" name="contextPath" id="contextPath" value="<%=request.getContextPath() %>" >
</s:form>
</div>
</div>
</body>
</html>