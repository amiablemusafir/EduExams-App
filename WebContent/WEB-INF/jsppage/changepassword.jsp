<%@ taglib prefix="s" uri="/struts-tags"%>
<center style="font-size: 15px; height: 25px; font-weight: bold; margin-top: 5px;"><font color="black">Change Password</font></center>
<hr/>
<s:form autocomplete="off" action="changepassword" method="post">
<s:hidden name="randomStingJsp" id="randomStingJsp"/>
<table>
	<tr>
	<td height="15" width="30"></td>
	<td></td>
	<td></td>
	</tr>
	
	<tr>
	<td></td>
	<td>Username <font color="red">*</font>:</td>
	<td><s:textfield theme="simple" size="30"  name="user_name"/></td>
	</tr>
	
	<tr>
	<td></td>
	<td>Old Password <font color="red">*</font>:</td>
	<td><s:password theme="simple" size="30"  name="old_password"/></td>
	</tr>
	
	<tr>
	<td height="15px"></td>
	<td></td>
	<td></td>
	</tr>
	
	<tr>
	<td></td>
	<td>New Password <font color="red">*</font>:</td>
	<td><s:password theme="simple" size="30"  name="new_password"/></td>
	</tr>

	<tr>
	<td></td>
	<td>Confirm Password <font color="red">*</font>:</td>
	<td><s:password theme="simple" size="30"  name="confirm_password"/></td>
	</tr>
	
	<tr>
	<td></td>
	<td height="25"></td>
	<td><font color="red" style="font-size: 12px;"><s:property value="info"/></font></td>
	</tr>
</table>

<table>
	<tr>
	<td></td>
	<td></td>
	<td><input style="width: 80px; height: 30px; margin-left: 55px;" class="p_button p_button-submit" type="submit" value="Submit"/>
	<input style="width: 80px; height: 30px;" class="p_button p_button-submit" type="reset" value="Reset"/></td>
	</tr>

</table>
</s:form>

