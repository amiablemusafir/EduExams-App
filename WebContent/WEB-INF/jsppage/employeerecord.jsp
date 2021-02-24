<!-- 
Author: Sumit Singh
Start Date: 27th March, 2014
Modify Date:
Modify By:
Motive: Admission Details
 -->
<%@page import="com.oes.dto.EmployeeDetailsDto"%>
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

<link href="css/themes/base/jquery.ui.all.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-ui/jquery.ui.widget.min.js" type="text/javascript"></script>
<script src="js/jquery-ui/jquery.ui.datepicker.min.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery-ui/jquery.ui.core.min.js"></script>

<script type="text/javascript">

function readURL(input) {
     if (input.files && input.files[0]) {
         var reader = new FileReader();

         reader.onload = function (e) {
             $('#blah')
                 .attr('src', e.target.result)
                 .width(140)
                 .height(160);
             };
         reader.readAsDataURL(input.files[0]);
     }
 } 
 
 $(function() {
	 
	 $( "#date_of_birth" ).datepicker({
		dateFormat: 'dd-MM-yy',
   		changeMonth: true,
   		changeYear: true,
   		yearRange: '1960:'+(new Date).getFullYear()  
	  });
});
 
 </script>  
 <script type="text/javascript">
 function EmployeeValidation() {
	 
	 
	 $('#first_name').html('');
	 $('#last_name').html('');
	 $('#dob').html('');
	 $('#gender').html('');
	 $('#father_name').html('');
	 $('#mobile_number').html('');
	 $('#email_id').html('');
	 $('#dictrict').html('');
	 $('#town').html('');
	 $('#state').html('');
	 $('#pincode').html('');
	 $('#pic_of_student').html('');
	 $('#telephone').html('');
	
	 var result = '';
	 var pattern = new RegExp(/^[0-9]{1,10}$/);
		 
	 
	 	var first_name = document.getElementById('istr_first_name').value;
		if (first_name == '') {
			$('#first_name').html('Please enter First Name');
			document.getElementById('istr_first_name').focus();

			return false;
		}
		
		
		var last_name = document.getElementById('istr_last_name').value;
		if (last_name == '') {
			$('#last_name').html('Please enter Last Name');
			document.getElementById('istr_last_name').focus();

			return false;
		}
		
		
		var dob = document.getElementById('date_of_birth').value;
		if (dob == '') {
			$('#dob').html('Please enter Date Of Birth');
			document.getElementById('date_of_birth').focus();

			return false;
		}
		
		
		var gender = document.getElementById('istr_gender').value;	
		if (gender == 0) {
			$('#gender').html('Please select Gender');
			document.getElementById('istr_gender').focus();
			return false;
		}
		
		var exiImg = document.getElementById('blah');
	 	var fup = document.getElementById('myfilename');
	  	var fileName = fup.value;
		var ext = fileName.substring(fileName.lastIndexOf('.') + 1);
		
		if(fileName != ''){
		
			if(!(ext == "gif" || ext == "GIF" || ext == "JPEG" || ext == "jpeg" || ext == "jpg" || ext == "JPG" || ext == "png" || ext == "PNG"))
			{
				$('#pic_of_employee').html('Upload Gif,Png or Jpg images only');
				fup.focus();
				return false;
			}
			
			//alert(fup.files[0].size);
			for(var i=0;i<fup.files.length;i++){
		 	   var fileSize = fup.files[i].size/1024/1024;
		 	   if(fileSize>1.5){
		 		  $('#pic_of_employee').html('Image size should be less then 1.5 MB');   
		 		  fup.focus();
		 		  return false;
		 	   }
		    }
 		}
		
		if(exiImg == null) {
			if(!(ext == "gif" || ext == "GIF" || ext == "JPEG" || ext == "jpeg" || ext == "jpg" || ext == "JPG" || ext == "png" || ext == "PNG"))
			{
				$('#pic_of_employee').html('Upload Gif,Png or Jpg images only..');
				fup.focus();
				return false;
			}
		}		
		
		var father_name = document.getElementById('istr_father_name').value;
		if (father_name == '') {
			$('#father_name').html('Please enter Father Name');
			document.getElementById('istr_father_name').focus();

			return false;
		}
		
		var telephone = document.getElementById('inum_landline_number').value;
		if (telephone != '') {
			if (!isInteger(telephone)) {
				$('#telephone').html('Please enter Contact Number');
				document.getElementById('inum_landline_number').focus();
				return false;
			}
			if(telephone.length != 10) {
				$('#telephone').html('Please enter the valid Contact Number');
				document.getElementById('inum_landline_number').focus();
				return false;
			}
		}
		
		var mobile_number = document.getElementById('inum_mobile_number').value;
		if (mobile_number == '') {
			$('#mobile_number').html('Please enter the Mobile Number');
			document.getElementById('inum_mobile_number').focus();

			return false;
		}
		
		if (!isInteger(mobile_number)) {
			$('#mobile_number').html('Please enter the valid Mobile Number');
			document.getElementById('inum_mobile_number').focus();
			return false;
		}
		if(mobile_number.length != 10) {
			$('#mobile_number').html('Mobile Number should be of 10 digits');
			document.getElementById('inum_mobile_number').focus();
			return false;
		}
		
		var email_id = document.getElementById('istr_email').value;
		if (email_id == '') {
			$('#email_id').html('Please enter Email Id');
			document.getElementById('istr_email').focus();

			return false;
		}
		
		if (!checkEmail(email_id)) {
			$('#email_id').html('Please enter the valid Email Id');
			document.getElementById('istr_email').focus();

			return false;
		}
		
		var state = document.getElementById('istr_state_name').value;
		if (state == "") {
			$('#state').html('Please select State');
			document.getElementById('istr_state_name').focus();

			return false;
		}
		
		var district = document.getElementById('istr_district_name').value;
		if (district == "") {		
			$('#dictrict').html('Please select District');
			document.getElementById('istr_district_name').focus();
			return false;
		}	
		
		var town = document.getElementById('istr_town_name').value;
		if (town == "") {
			$('#town').html('Please select Town');
			document.getElementById('istr_town_name').focus();

			return false;
		}	
		
		
		var pin_code = document.getElementById('istr_pin_code').value;
		if (pin_code == "") {
			$('#pincode').html('Please enter valid Pincode');
			document.getElementById('istr_pin_code').focus();
			return false;
		}
		
		return true;
 }
 
 function checkEmail(inputvalue) 
 {
 	var pattern = /^[_\.\!\#\$\%\&\'\*\+\-\/\=\?\^\`\{\|\}\~A-Za-z0-9](([_\.\!\#\$\%\&\'\*\+\-\/\=\?\^\`\{\|\}\~]?[a-zA-Z0-9_\.\!\#\$\%\&\'\*\+\-\/\=\?\^\`\{\|\}\~]+)*)@([a-zA-Z0-9-\s].+\.[a-zA-Z]{2,5})$/;
 	if (pattern.test(inputvalue)) {
 		return true;
 	} else {
 		return false;
 	}
 }
 function isInteger(s) {
	var i;
	for (i = 0; i < s.length; i++) {
	var c = s.charAt(i);
	if (((c < "0") || (c > "9")))
		return false;
	}
	return true;
}

function isValidPersantage(num) {
	
	var num2 = parseInt(num);
	if (((num2>=0) && (num2<=100))) {
		return true;
	}	
	return false;
}
</script>
</head>
<body>
<div class="grid_10">
<div class="box round first grid">

<h2>Employee Registration Form</h2>
<%EmployeeDetailsDto employeeDetailsDto = (EmployeeDetailsDto)request.getSession().getAttribute("employeeDetailsDto"); %>

<div align="left">
<s:form theme="simple" autocomplete="off" id="employeeDetailsDto" action="saveOrUpdateEmployeeDetailsDto" enctype="multipart/form-data" name="employeeDetailsDto"  method="post" onsubmit="return(EmployeeValidation());">
<s:hidden name="randomStingJsp" id="randomStingJsp"/>

<div class="dms_display_message"><s:property value="info"/></div>
<!--Admin Basic Information start -->
<table width="50%" border="0" cellpadding="0" cellspacing="0" style="margin-left: 50px;">
<tr>
<td width="60%"><label for="Unique ID"><b>Employee ID</b></label>:</td>
<td width="40%">

 <s:textfield theme="simple" name="employeeDetailsDto.istr_unique_id" cssClass="text_field" id="uniqueId" tabindex="1" readonly="true"/>
 <s:hidden theme="simple" name="employeeDetailsDto.inum_employee_id"/> 
 <s:hidden theme="simple" name="employeeDetailsDto.idt_entry_date"/>
 <s:hidden theme="simple" name="employeeDetailsDto.inum_is_active"/>
    
</td>
</tr>
<tr>
<td><label for="Registration Date"><b>Registration Date</b></label>:</td>
<td>

 <s:textfield theme="simple" name="employeeDetailsDto.idt_registration_date" cssClass="text_field" id="registrationDate" tabindex="2" readonly="true"/>

</td>
</tr>
<tr>
<td><label for="First Name"><b>First Name</b></label>:<span style="color:#F00; font-size:12px;">*</span></td>
<td>

 <s:textfield theme="simple" name="employeeDetailsDto.istr_first_name" cssClass="text_field" id="istr_first_name" tabindex="3"/>

</td>
</tr>
<tr>	
	<td></td>
	<td><div id="first_name" class="message1"></div>
	<div class="message1"><s:property value="first_name"/></div>
	</td>
 </tr>
<tr>
<td ><label for="Last Name"><b>Last Name</b></label>:<span style="color:#F00; font-size:12px;">*</span></td>
<td >

  <s:textfield theme="simple" name="employeeDetailsDto.istr_last_name" cssClass="text_field" id="istr_last_name" tabindex="4"/>

</td>
</tr>
<tr>	
	<td></td>
	<td><div id="last_name" class="message1"></div>
	<div class="message1"><s:property value="last_name"/></div>
	</td>
  </tr>
<tr>
<td><label for="Date of Birth"><b>Date of Birth</b></label>:<span style="color:#F00; font-size:12px;">*</span></td>
<td>

<s:textfield theme="simple" name="employeeDetailsDto.istr_date_of_birth" cssClass="text_field" id="date_of_birth" tabindex="5"/>

</td>
</tr>
<tr>	
	<td></td>
	<td><div id="dob" class="message1"></div>
	<div class="message1"><s:property value="dob"/></div>
	</td>
 </tr>
<tr>
<td><label for="Gender"><b>Gender</b></label>:<span style="color:#F00; font-size:12px;">*</span></td>
<td>
<div class="styled-select2">
<select name="employeeDetailsDto.istr_gender" id="istr_gender">
<option value="0">Select</option>
<%if(employeeDetailsDto != null) {
  if(employeeDetailsDto.getIstr_gender() != null) {
%>
<%if(employeeDetailsDto.getIstr_gender().equals("Male")) {%>
	<option value="Male" selected="selected">Male</option>
<%} else {%>
	<option value="Male">Male</option>
<%} %>	

<%if(employeeDetailsDto.getIstr_gender().equals("Female")) {%>
	<option value="Female" selected="selected">Female</option>
<%} else {%>
	<option value="Female">Female</option>
<%}
} else {
	%>
	<option value="Male">Male</option>
	<option value="Female">Female</option>
<%} %>
<%} else {%>
	<option value="Male">Male</option>
	<option value="Female">Female</option>
<%} %>
</select>
</div></td>
</tr>
<tr>	
	<td></td>
	<td><div id="gender" class="message1"></div>
	<div class="message1"><s:property value="gender"/></div>
	</td>
  </tr>
 <tr>
<tr>
 
<tr>
<td><label for="Gender"><b>Institute Name</b></label>:<span style="color:#F00; font-size:12px;">*</span></td>
<td>
<div class="styled-select2">
		<s:if test="instituteDetailsDtoList == null">
				<select id="onum_institute_id" name="employeeDetailsDto.instituteDetailsDto.onum_slno" tabindex="1">
					<option value="0">Select</option>
				</select>
		</s:if>
		<s:else>
    			<s:select theme="simple" list="instituteDetailsDtoList"
						id="onum_institute_id" listKey="onum_slno"
						listValue="ostr_institute_name"
						name="employeeDetailsDto.instituteDetailsDto.onum_slno"
						headerKey="0" headerValue="Select"
						onChange="" tabindex="1"></s:select>
	 	</s:else>   
</div></td>
</tr>
<tr>	
	<td></td>
	<td><div id="gender" class="message1"></div>
	<div class="message1"><s:property value="gender"/></div>
	</td>
  </tr>
 <tr>
 <tr>
 
<td><label for="Current_class"><b>Designation</b></label>:<span style="color:#F00; font-size:12px;">*</span></td>
<td>
<s:textfield theme="simple" name="employeeDetailsDto.istr_designation" cssClass="text_field" id="istr_designation" tabindex="8"/>

</td>
</tr>
<tr>	
	<td></td>
	<td><div id="designation" class="message1"></div>
	<div class="message1"><s:property value="current_class"/></div>
	</td>
</tr>
<tr>
<td><label for="School/College"><b>Department</b></label>:<span style="color:#F00; font-size:12px;"></span></td>
<td>

<s:textfield theme="simple" name="employeeDetailsDto.istr_department" cssClass="text_field" id="istr_department" tabindex="8"/>


</td>
</tr>
<tr>	
	<td></td>
	<td><div id="department" class="message1"></div>
	<div class="message1"><s:property value="class_teacher"/></div>
	</td>
  </tr>

<tr>
<td colspan="2">&nbsp;</td>
</tr>

<tr>
<td><label for="Your ambition to get through in"><b>Pic of Student</b></label>:<span style="color:#F00; font-size:12px;">*</span></td>
<td><s:file  name="myfile" id="myfilename" onchange="readURL(this);" ></s:file></td>
</tr>

<tr>
<td></td>
<td><% Base64Encoder encoder=new Base64Encoder();

	  if(employeeDetailsDto != null){
		    if(employeeDetailsDto.getIbl_std_pic() != null){
		       	%><img id="blah" src='data:image/jpg;base64,<%= employeeDetailsDto.getIbl_std_pic()%>' style="width: 140px; height: 160px;"/>
		       				     
			<%}else {
	
				%><img id="blah" src="image/student-symbol-images.png" /><%

 			 }
	 } else {
		
		%><img id="blah" src="image/student-symbol-images.png" /><%
	
     }%>
</td>
</tr>

<tr>	
	<td colspan="2">
	<div id="pic_of_employee" class="message1"></div>
	<div class="message1"><s:property value="pic_of_employee"/></div>
	</td>
</tr>


<tr>
<td height="50px;" colspan="2"></td>
</tr>


<tr>
<td><label for="Fathername"><b>Father's Name:</b></label><span style="color:#F00; font-size:12px;">*</span></td>
<td>

<s:textfield theme="simple" name="employeeDetailsDto.istr_father_name" cssClass="text_field" id="istr_father_name" tabindex="11"/>

</td>
</tr>

<tr>	
	<td></td>
	<td><div id="father_name" class="message1"></div>
	<div class="message1"><s:property value="father_name"/></div>
	</td>
</tr>

<tr>
<td><label for="Father's Occupation"><b>Father's Occupation</b></label>:</td>
<td>

<s:textfield theme="simple" name="employeeDetailsDto.istr_father_occupation" cssClass="text_field" id="istr_father_occupation" tabindex="12"/>

</td>
</tr>
<tr>
<td width="40%"><label for="Mother's Name"><b>Mother's Name</b></label>:</td>
<td width="60%">

<s:textfield theme="simple" name="employeeDetailsDto.istr_mother_name" cssClass="text_field" id="istr_mother_name" tabindex="13"/>

</td>
</tr>
<tr>
<td width="40%"><label for="Landline Number"><b>Landline Number</b></label>:</td>
<td width="60%">

<s:textfield theme="simple" name="employeeDetailsDto.inum_landline_number" cssClass="text_field" id="inum_landline_number" tabindex="14"/>

</td>
</tr>
<tr>	
	<td></td>
	<td><div id="telephone" class="message1"></div>
	</td>
</tr>
<tr>
<td><label for="Mobile Number"><b>Mobile Number</b></label>:<span style="color:#F00; font-size:12px;">*</span></td>
<td>

<s:textfield theme="simple" name="employeeDetailsDto.inum_mobile_number" cssClass="text_field" id="inum_mobile_number" tabindex="15" maxlength="10"/>


</td>
</tr>
<tr>	
	<td></td>
	<td><div id="mobile_number" class="message1"></div>
	<div class="message1"><s:property value="mobile_number"/></div>
	</td>
</tr>
<tr>
<td><label for="Email"><b>Email ID</b></label>:<span style="color:#F00; font-size:12px;">*</span></td>
<td>

<s:textfield theme="simple" name="employeeDetailsDto.istr_email" cssClass="text_field" id="istr_email" tabindex="16"/>

</td>
</tr>
<tr>	
	<td></td>
	<td><div id="email_id" class="message1"></div>
	<div class="message1"><s:property value="email_id"/></div>
	</td>
</tr>


<tr>
<td height="50px;" colspan="2"></td>
</tr>



<tr>
<td><label for="streetAddress"><b>Street Address</b></label>:</td>
<td>

<s:textarea theme="simple" cssClass="purpose_textarea" name="employeeDetailsDto.istr_street_address" rows="3" cols="20" placeholder="Please write your address here." tabindex="17"></s:textarea>

</td>
</tr>

<tr>
<td width="40%"><label for="State"><b>State</b></label>:<span style="color:#F00; font-size:12px;">*</span></td>
<td width="60%" >
<s:textfield theme="simple" name="employeeDetailsDto.istr_state_name" cssClass="text_field" id="istr_state_name" tabindex="16"/>
</td>
</tr>
<tr>	
	<td></td>
	<td><div id="state" class="message1"></div>
	<div class="message1"><s:property value="state"/></div>
	</td>
</tr>

<tr>
<td><label for="District"><b>District</b></label>:<span style="color:#F00; font-size:12px;">*</span></td>
<td>
<s:textfield theme="simple" name="employeeDetailsDto.istr_district_name" cssClass="text_field" id="istr_district_name" tabindex="16"/>
</td>
</tr>
<tr>	
	<td></td>
	<td><div id="dictrict" class="message1"></div>
	<div class="message1"><s:property value="dictrict"/></div>
	</td>
</tr>

<tr>
<td><label for="Town"><b>Town</b></label>:<span style="color:#F00; font-size:12px;">*</span></td>
<td>
<s:textfield theme="simple" name="employeeDetailsDto.istr_town_name" cssClass="text_field" id="istr_town_name" tabindex="16"/>
</td>
</tr>
<tr>	
	<td></td>
	<td><div id="town" class="message1"></div>
	<div class="message1"><s:property value="town"/></div>
	</td>
</tr>
<tr>
<td><label for="Pincode"><b>Pin Code</b></label>:<span style="color:#F00; font-size:12px;">*</span></td>
<td>
<s:textfield theme="simple" name="employeeDetailsDto.istr_pin_code" cssClass="text_field" id="istr_pin_code" tabindex="16"/>
</td>
</tr>
<tr>	
	<td></td>
	<td><div id="pincode" class="message1"></div>
	<div class="message1"><s:property value="pincode"/></div>
	</td>
</tr>
<!--Admin Other Information And Address End -->
</table>



<div class="clear"></div>
<hr style="width:95%; border-bottom:1px dotted  #CCCCCC;" />
<!--Exam center table Start -->

<table width="100%" border="1" bordercolor="#B3CBD6" cellspacing="0" cellpadding="0" id="requestList">
	<tr style="background: #eee; color: #000000; height: 30px;">
			<th colspan="5">Enter Last Three Higher Education Details</th>
		</tr>
		<tr style="background: #eee; color: #000000; height: 30px;">
		    <th>Examination</th>
		    <th>Board</th>
		    <th>Year of Passing</th>
		    <th>% Marks</th>
		    <th>Name of School/College</th> 
		</tr>
	
<tr>
<td><center><s:textfield theme="simple" name="employeeDetailsDto.istr_exam1" cssClass="text_field2" id="istr_exam1" tabindex="8"/></center></td> 
<td><center><s:textfield theme="simple" name="employeeDetailsDto.istr_board1" cssClass="text_field2" id="istr_board1" tabindex="8"/></center></td>
<td><center><s:textfield theme="simple" name="employeeDetailsDto.istr_y_o_p1" cssClass="text_field2" id="istr_y_o_p1" tabindex="8"/></center></td> 
<td><center><s:textfield theme="simple" name="employeeDetailsDto.istr_mark1" cssClass="text_field2" id="istr_mark1" tabindex="8"/></center></td>
<td><center><s:textfield theme="simple" name="employeeDetailsDto.istr_name_of_school1" cssClass="text_field2" id="istr_name_of_school1" tabindex="8"/></center></td> 
</tr>

<tr>
<td><center><s:textfield theme="simple" name="employeeDetailsDto.istr_exam2" cssClass="text_field2" id="istr_exam2" tabindex="8"/></center></td> 
<td><center><s:textfield theme="simple" name="employeeDetailsDto.istr_board2" cssClass="text_field2" id="istr_board2" tabindex="8"/></center></td>
<td><center><s:textfield theme="simple" name="employeeDetailsDto.istr_y_o_p2" cssClass="text_field2" id="istr_y_o_p2" tabindex="8"/></center></td> 
<td><center><s:textfield theme="simple" name="employeeDetailsDto.istr_mark2" cssClass="text_field2" id="istr_mark2" tabindex="8"/></center></td>
<td><center><s:textfield theme="simple" name="employeeDetailsDto.istr_name_of_school2" cssClass="text_field2" id="istr_name_of_school2" tabindex="8"/></center></td> 
</tr>

<tr>
<td><center><s:textfield theme="simple" name="employeeDetailsDto.istr_exam3" cssClass="text_field2" id="istr_exam3" tabindex="8"/></center></td> 
<td><center><s:textfield theme="simple" name="employeeDetailsDto.istr_board3" cssClass="text_field2" id="istr_board3" tabindex="8"/></center></td>
<td><center><s:textfield theme="simple" name="employeeDetailsDto.istr_y_o_p3" cssClass="text_field2" id="istr_y_o_p3" tabindex="8"/></center></td> 
<td><center><s:textfield theme="simple" name="employeeDetailsDto.istr_mark3" cssClass="text_field2" id="istr_mark3" tabindex="8"/></center></td>
<td><center><s:textfield theme="simple" name="employeeDetailsDto.istr_name_of_school3" cssClass="text_field2" id="istr_name_of_school3" tabindex="8"/></center></td> 
</tr>

</table>
</div>



<!--Exam center table Start -->
	<table width="100%" border="1" bordercolor="#B3CBD6" cellspacing="0" cellpadding="0" id="requestList">
	<tr style="background: #eee; color: #000000; height: 30px;">
			<th colspan="5">Enter Last Two Company Details</th>
	</tr>
	
	<tr style="background: #eee; color: #000000; height: 30px;">
	    <th>Company Name</th>
	    <th>Total Experience</th>
	    <th>From Date</th>
	    <th>To Date</th>
	    <th>Remarks</th> 
	</tr>
	
<tr>
<td><center><s:textfield theme="simple" name="employeeDetailsDto.istr_company_name1" cssClass="text_field2" id="istr_company_name1" tabindex="8"/></center></td> 
<td><center><s:textfield theme="simple" name="employeeDetailsDto.istr_total_exp1" cssClass="text_field2" id="istr_total_exp1" tabindex="8"/></center></td>
<td><center><s:textfield theme="simple" name="employeeDetailsDto.istr_from_date1" cssClass="text_field2" id="istr_from_date1" tabindex="8"/></center></td> 
<td><center><s:textfield theme="simple" name="employeeDetailsDto.istr_to_date1" cssClass="text_field2" id="istr_to_date1" tabindex="8"/></center></td>
<td><center><s:textfield theme="simple" name="employeeDetailsDto.istr_remarks1" cssClass="text_field2" id="istr_remarks1" tabindex="8"/></center></td> 
</tr>

<tr>
<td><center><s:textfield theme="simple" name="employeeDetailsDto.istr_company_name2" cssClass="text_field2" id="istr_company_name2" tabindex="8"/></center></td> 
<td><center><s:textfield theme="simple" name="employeeDetailsDto.istr_total_exp2" cssClass="text_field2" id="istr_total_exp2" tabindex="8"/></center></td>
<td><center><s:textfield theme="simple" name="employeeDetailsDto.istr_from_date2" cssClass="text_field2" id="istr_from_date2" tabindex="8"/></center></td> 
<td><center><s:textfield theme="simple" name="employeeDetailsDto.istr_to_date2" cssClass="text_field2" id="istr_to_date2" tabindex="8"/></center></td>
<td><center><s:textfield theme="simple" name="employeeDetailsDto.istr_remarks2" cssClass="text_field2" id="istr_remarks2" tabindex="8"/></center></td> 
</tr>
</table>
<!--Exam center table  End -->
<hr style="width:95%; border-bottom:1px dotted  #CCCCCC;" />
<!--  Button Start  -->
			<table width="98%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td>
					<div align="center">
						<input type="submit" value="Save" name="submit" tabindex="27" style="width: 120px; height: 40px;" class="btn">
						&nbsp;<input type="reset" name="reset" value="Reset" tabindex="28" style="width: 120px; height: 40px;" class="btn">&nbsp;
						<input type="reset" name="reset" value="Cancel" tabindex="29" style="width: 120px; height: 40px;" class="btn">
					</div>
					</td>
				</tr>
			</table>
		
<div class="clear"></div>
<hr style="width:95%; border-bottom:1px dotted  #CCCCCC;" />

</s:form>
</div>
</div>


<input type="hidden" id="contextPath" value="<%=request.getContextPath() %>" >
</body>
</html>   
