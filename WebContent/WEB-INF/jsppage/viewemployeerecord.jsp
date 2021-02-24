<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<link href="css/displayTag.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.1/themes/base/jquery-ui.css" />
<link rel="stylesheet" type="text/css" media="all" href="css2/main.css" />
<link rel="stylesheet" type="text/css" media="all" href="css/displayTagMenu.css" />
<center style="font-size: 15px; height: 25px; font-weight: bold; margin-top: 5px;"><font color="black">View Employee Record</font></center>
<hr/>
<center>
<br/>
<form action="searchemployee" method="post">
Enter Employee Id :<input type="text" name="emp_id" id="emp_id" style="width: 160px; height: 25px;" required="required">&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Search" style="width: 70px; height: 30px;">
</form> 
<br/>
<font color="red"><s:property value="info"/></font>
</center>
<hr/>
     <display:table export="false" name="employeeDetailsDtoList" class="table" requestURI="" id="employeeDetailsDtoList"  id="requestList" pagesize="8">
   	 <display:column style="width: 100px; font-weight: bold;" property="gnum_emp_id" title="Emp Id" sortable="true"/>
  	 <display:column style="width: 300px; font-weight: bold;" property="gstr_employee_name" title="Employee Name" sortable="true"/>
   	 <display:column style="width: 100px; font-weight: bold;" property="gstr_gender" title="Class" sortable="true"/>
   	 <display:column style="width: 100px; font-weight: bold;" property="gstr_dob" title="DOB" sortable="true"/>
   	 <display:column style="width: 100px; font-weight: bold;" property="gstr_subject" title="Subject" sortable="true"/>
   	 <display:column style="width: 100px; font-weight: bold;" property="gstr_phone_no" title="Phone No" sortable="true"/>
   	 <display:column style="width: 100px; font-weight: bold;" property="gstr_mobile_no1" title="Mobile No" sortable="true"/>
   	 <display:column style="width: 100px; font-weight: bold;" property="gstr_email_id" title="Email Id" sortable="true"/>
   	 <display:column style="width: 50px;" url="/editemployeeDetail?" paramId="emp_id" paramProperty="gnum_emp_id"  title="Edit" value="<img src='images/edit1.png'>" sortable="true"/> 
     <display:column style="width: 50px;" url="/deleteemployeeDetail?" paramId="emp_id" paramProperty="gnum_emp_id"  title="Delete"  value="<img src='images/delete1.png'>" sortable="true"/>
  	
	</display:table>
