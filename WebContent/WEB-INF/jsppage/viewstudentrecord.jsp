<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<link rel="stylesheet" type="text/css" media="all" href="css2/main.css" />
<link rel="stylesheet" type="text/css" media="all" href="css/displayTagMenu.css" />
<script type="text/javascript" src="js/las.js"></script>
<script type="text/javascript">
		function newUserRegistrationValidation() {
		
		var headline = document.getElementById('roll_no').value;
		if (headline == '') {
			alert('Please Enter Roll no');
			document.getElementById('roll_no').focus();

			return false;
		}
				
		return true;

	}
</script>
<center style="font-size: 15px; height: 25px; font-weight: bold; margin-top: 5px;"><font color="black">View Student Record</font></center>
<hr/>
<center>
<br/>
<form action="searchstudent" method="post" onsubmit="return(newUserRegistrationValidation())">
Enter Student Roll No :<input type="text" name="roll_no" id="roll_no" style="width: 160px; height: 25px;" required="required">&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Search" style="width: 70px; height: 30px;">
</form> 
<br/>
<font color="red"><s:property value="info"/></font>
</center>
<hr/>
	 <display:table export="false" name="studentDetailsDtoList" class="table" requestURI="" id="studentDetailsDtoList"  id="requestList" pagesize="8">
   	 <display:column style="width: 100px; font-weight: bold;" property="gnum_roll_no" title="Roll No" sortable="true"/>
  	 <display:column style="width: 150px; font-weight: bold;" property="gstr_student_first_name" title="Student Name" sortable="true"/>
   	 <display:column style="width: 100px; font-weight: bold;" property="gstr_class" title="Class" sortable="true"/>
   	 <display:column style="width: 100px; font-weight: bold;" property="gstr_dob" title="DOB" sortable="true"/>
   	 <display:column style="width: 100px; font-weight: bold;" property="gstr_gender" title="Gender" sortable="true"/>
   	 <display:column style="width: 100px; font-weight: bold;" property="gstr_phone_no" title="Phone No" sortable="true"/>
   	 <display:column style="width: 100px; font-weight: bold;" property="gstr_mobile_no1" title="Mobile No" sortable="true"/>
   	 <display:column style="width: 100px; font-weight: bold;" property="gstr_email_id" title="Email Id" sortable="true"/>
   	 <display:column style="width: 50px;" url="/editstudentDetail?" paramId="roll_no" paramProperty="gnum_roll_no"  title="Edit" value="<img src='images/edit1.png'>" sortable="true"/> 
     <display:column style="width: 50px;" url="/deletestudentDetail?" paramId="roll_no" paramProperty="gnum_roll_no"  title="Delete"  value="<img src='images/delete1.png'>" sortable="true"/>
  	
</display:table>
