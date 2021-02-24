package com.oes.action;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.json.JSONException;
import org.json.JSONObject;

import sun.misc.BASE64Encoder;

import com.oes.action.common.SendMailTLS;
import com.oes.common.exception.POLLINGBusinessException;
import com.oes.constants.CommonConstants;
import com.oes.dto.CourseDetailsDto;
import com.oes.dto.DashBoardDto;
import com.oes.dto.ExamDetailsDto;
import com.oes.dto.InstituteDetailsDto;
import com.oes.dto.MappedExamDetailsDto;
import com.oes.dto.StudentDetailsDto;
import com.oes.dto.StudentMappedExamDetailsDto;
import com.oes.service.IExaminationDetailsServices;
import com.oes.service.IMasterDetailsServices;
import com.oes.service.IStudentDetailsServices;
import com.sms.admin.dto.AdminDetailDto;
import com.sms.admin.dto.RolePermissionMasterDto;
import com.sms.admin.service.IAdminService;
import com.sms.admin.service.IRoleMasterServices;
import com.sms.admin.service.IRolePermissionService;
import com.sms.util.ServiceLocator;
import com.opensymphony.xwork2.ActionSupport;


public class StudentDetailsAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	private StudentDetailsDto studentDetailsDto = new StudentDetailsDto();
	static Connection con;
	static PreparedStatement st;
	static ResultSet rs;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private String messages;
	private List<StudentDetailsDto> studentDetailsDtoList;
	private List<StudentDetailsDto> checkAvailStudentDetailsList;
	private String info;
	private String code="";
	
	File myfile;
	String myfileContentType;
	String myfileFileName;
	String datafile;
	private String login_id;
	
	private String unique_id;
    private String first_name;
    private String last_name;
    private String dob;
    private String istr_gender;
    private String email_id;
    private String istr_pin_code;
	
	String password;
	
	
	public String getUnique_id() {
		return unique_id;
	}
	public void setUnique_id(String unique_id) {
		this.unique_id = unique_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getIstr_gender() {
		return istr_gender;
	}
	public void setIstr_gender(String istr_gender) {
		this.istr_gender = istr_gender;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getIstr_pin_code() {
		return istr_pin_code;
	}
	public void setIstr_pin_code(String istr_pin_code) {
		this.istr_pin_code = istr_pin_code;
	}
	public File getMyfile() {
		return myfile;
	}
	public void setMyfile(File myfile) {
		this.myfile = myfile;
	}
	public String getMyfileContentType() {
		return myfileContentType;
	}
	public void setMyfileContentType(String myfileContentType) {
		this.myfileContentType = myfileContentType;
	}
	public String getMyfileFileName() {
		return myfileFileName;
	}
	public void setMyfileFileName(String myfileFileName) {
		this.myfileFileName = myfileFileName;
	}
	public String getDatafile() {
		return datafile;
	}
	public void setDatafile(String datafile) {
		this.datafile = datafile;
	}
	
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public HttpServletResponse getResponse() {
		return response;
	}
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	public String getMessages() {
		return messages;
	}
	public void setMessages(String messages) {
		this.messages = messages;
	}
	public StudentDetailsDto getStudentDetailsDto() {
		return studentDetailsDto;
	}
	public void setStudentDetailsDto(StudentDetailsDto studentDetailsDto) {
		this.studentDetailsDto = studentDetailsDto;
	}
	public List<StudentDetailsDto> getStudentDetailsDtoList() {
		return studentDetailsDtoList;
	}
	public void setStudentDetailsDtoList(
			List<StudentDetailsDto> studentDetailsDtoList) {
		this.studentDetailsDtoList = studentDetailsDtoList;
	}
	public List<StudentDetailsDto> getCheckAvailStudentDetailsList() {
		return checkAvailStudentDetailsList;
	}
	public void setCheckAvailStudentDetailsList(
			List<StudentDetailsDto> checkAvailStudentDetailsList) {
		this.checkAvailStudentDetailsList = checkAvailStudentDetailsList;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public void populateMenu()
	{
		try
		{
			if(request.getParameter("currentMenu")!=null)
			{
				request.getSession().setAttribute("permissionSelect", request.getParameter("permissionSelect"));
				request.getSession().setAttribute("currentMenu", request.getParameter("currentMenu"));
			}
			else if(request.getParameter("permissionSelect")!=null)
			{
				request.getSession().setAttribute("permissionDtoSideMenuList", request.getSession().getAttribute("permissionDtoSideMenuList"));
				request.getSession().setAttribute("permissionSelect", request.getParameter("permissionSelect"));
				request.getSession().setAttribute("currentMenu", request.getSession().getAttribute("currentMenu"));
			}
			else
			{
				request.getSession().setAttribute("permissionDtoSideMenuList", request.getSession().getAttribute("permissionDtoSideMenuList"));
				request.getSession().setAttribute("permissionSelect", request.getSession().getAttribute("permissionSelect"));
				request.getSession().setAttribute("currentMenu", request.getSession().getAttribute("currentMenu"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public String showStudentDetails() throws POLLINGBusinessException
	{
		String flag = CommonConstants.FAILURE_ERROR;
		this.populateMenu();
		studentDetailsDto = new StudentDetailsDto();
		
		request.getSession().setAttribute("studentDetailsDto",null);
		if(request.getSession().getAttribute("adminDetailDto") == null) {
			return "login";
		}
		AdminDetailDto adminDetailDto = new AdminDetailDto();
		adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
		
		SimpleDateFormat st = new SimpleDateFormat("dd-MMM-yyyy");
		String redDate = st.format(new Date());
		
		studentDetailsDtoList = this.getStudentDetailsServices().getStudentDetailsDto(studentDetailsDto, adminDetailDto);
		studentDetailsDto.setIdt_registration_date(redDate);
		studentDetailsDto.setIstr_unique_id(this.generateUniqueId());
		
		System.out.println("Enter in showNotice action");
		
		flag = CommonConstants.SUCCESS_FLAG;
		return flag;
		
	}
	
	public String showStudentDetailsList() throws POLLINGBusinessException
	{
		String flag = CommonConstants.FAILURE_ERROR;
		this.populateMenu();
		
		request.getSession().setAttribute("studentDetailsDto",null);
		if(request.getSession().getAttribute("adminDetailDto") == null) {
			return "login";
		}
		AdminDetailDto adminDetailDto = new AdminDetailDto();
		adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
		
		studentDetailsDtoList = this.getStudentDetailsServices().getStudentDetailsDtoCompleteList(adminDetailDto);
		flag = CommonConstants.SUCCESS_FLAG;
		return flag;
		
	}
	
	public String showUpdateStudentDetails() throws POLLINGBusinessException
	{
		String flag = CommonConstants.FAILURE_ERROR;
		this.populateMenu();
		
		if(request.getSession().getAttribute("adminDetailDto") == null) {
			return "login";
		}
		
		AdminDetailDto adminDetailDto = new AdminDetailDto();
		adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
		studentDetailsDtoList = this.getStudentDetailsServices().getStudentDetailsListbyUniqueId(adminDetailDto.getIstr_login_id());
		
		if(studentDetailsDtoList != null && studentDetailsDtoList != null) {
			studentDetailsDto = studentDetailsDtoList.get(0);
			request.getSession().setAttribute("studentDetailsDto", studentDetailsDto);
		} else {
			return "homepage";
		}
		
		flag = CommonConstants.SUCCESS_FLAG;
		return flag;
		
	}
	
	public String showNewStudentRequestDetails() throws POLLINGBusinessException
	{
		String flag = CommonConstants.FAILURE_ERROR;
		this.populateMenu();
		
		request.getSession().setAttribute("studentDetailsDto",null);
		if(request.getSession().getAttribute("adminDetailDto") == null) {
			return "login";
		}
		studentDetailsDtoList = this.getStudentDetailsServices().getStudentDetailsDtoCompleteList(2);
		flag = CommonConstants.SUCCESS_FLAG;
		return flag;
		
	}
	
	
	
	public String searchStudentsDetailsByCriteria() throws Exception{
		
		String flag = CommonConstants.ERROR_FLAG;
		this.populateMenu();

		if(request.getSession().getAttribute("adminDetailDto") == null) {
			return "login";
		}
		
		AdminDetailDto adminDetailDto = new AdminDetailDto();
		adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
		
		System.out.println("Search Students Details By Criteria Action......");
		try	{			
			 String uniqueId = this.getUnique_id();
		  	 System.out.println("Unique ID : "+uniqueId);
		  	
			 String firstName = this.getFirst_name();
			 System.out.println("First Name : "+firstName);
			
			 String lastName = "";
			 if(getLast_name() != null) {
				 lastName = this.getLast_name();
				 System.out.println("Last Name : "+lastName);
			 } else {
				 
			 }
			 
			 String dateOfBirth = "";
			 if(getDob() != null) {
				 dateOfBirth = this.getDob();
				 System.out.println("Date OF Birth : "+dateOfBirth);
			 }
			 
			 String genderId = this.getIstr_gender();
			 System.out.println("Gender ID : "+genderId);
			
			 String emailId = "";
			 if(getEmail_id() != null) {
				 emailId = this.getEmail_id();
				 System.out.println("Email ID : "+emailId);		
			 }
			 
			 String pincode = "";
			 if(getIstr_pin_code() != null) {
				 pincode = this.getIstr_pin_code();
				 System.out.println("Pincode : "+pincode);			
			 }
			 
			 studentDetailsDtoList = new ArrayList<StudentDetailsDto>();
			 studentDetailsDtoList = this.getStudentDetailsServices().getStudentDetailsListbyCriteria(uniqueId, firstName, lastName, dateOfBirth, genderId, emailId, pincode, adminDetailDto);
				
			 flag = CommonConstants.SUCCESS_FLAG;
		} catch(Exception er){
			er.printStackTrace();
		}
		return flag;
	}
	
	public String saveStudentDetails() throws POLLINGBusinessException{
		
		String flag = CommonConstants.FAILURE_ERROR;
		if(request.getSession().getAttribute("adminDetailDto") == null) {
			return "login";
		}
		AdminDetailDto adminDetailDto = new AdminDetailDto();
		adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
		
		this.populateMenu();
        if(request.getSession().getAttribute("adminDetailDto") == null) {
        	return "login";
		}
		try {
			
			if(studentDetailsDto.getInum_student_id() == null){
	    		
	    		List<StudentDetailsDto> studentDetailsDtoList = this.getStudentDetailsServices().checkAvailStudentDetailsByUsername(studentDetailsDto.getIstr_first_name(), studentDetailsDto.getIstr_email());
	    		System.out.println("List Size : "+studentDetailsDtoList.size());	    		 
	    		
	    		if(studentDetailsDtoList != null && studentDetailsDtoList.size() > 0){
	    	    	
	        		this.showStudentDetails();		    		
	        		studentDetailsDto = null;
	        		info = "Unique ID is already generated for mentioned email id. Kindly use the Forget Password to know about your password.";			    		
	        		flag = "already_exist";
	        	
	        	} else {
					BufferedImage imgFile = getImageAndReduceSize(getMyfile());
					ByteArrayOutputStream bas = new ByteArrayOutputStream();
					ImageIO.write(imgFile, "jpg", bas);
					
					byte[] fileContents = bas.toByteArray();
						    		
					BASE64Encoder encodeData = new BASE64Encoder();
					String fileData = encodeData.encode(fileContents);
						    			
					studentDetailsDto.setIbl_std_pic(fileData);			    			    		
						    		
					studentDetailsDto.setIdt_entry_date(new Date());
					studentDetailsDto.setInum_is_active(2);
					studentDetailsDto.setInum_status(2);
					studentDetailsDto.setAdminDetailDto(adminDetailDto);
					
					SimpleDateFormat st = new SimpleDateFormat("dd-MMM-yyyy");
					String redDate = st.format(new Date());
					
					studentDetailsDto.setIdt_registration_date(redDate);
					
					this.getStudentDetailsServices().updateStudentDetailsDto(studentDetailsDto);
					
					AdminDetailDto adminDetailDto2 = new AdminDetailDto();
					
					adminDetailDto2.setIdt_entry_date(new Date());
					adminDetailDto2.setInum_account_status(2);
					adminDetailDto2.setInum_is_active(1);
					adminDetailDto2.setInum_is_verified(2);
					adminDetailDto2.setInum_role_id(3);
					adminDetailDto2.setInum_account_status(2);
					adminDetailDto2.setIstr_address(studentDetailsDto.getIstr_street_address());
					adminDetailDto2.setIstr_email(studentDetailsDto.getIstr_email());
					adminDetailDto2.setIstr_dob(studentDetailsDto.getIstr_date_of_birth());
					adminDetailDto2.setIstr_login_id(studentDetailsDto.getIstr_unique_id());
					adminDetailDto2.setIstr_password("");
					adminDetailDto2.setIstr_user_name(studentDetailsDto.getIstr_first_name());
					adminDetailDto2.setInum_student_employee_id(studentDetailsDto.getInum_student_id());
					if(adminDetailDto.getInstituteDetailsDto() == null) {
						InstituteDetailsDto detailsDto = new InstituteDetailsDto();
						adminDetailDto2.setInstituteDetailsDto(detailsDto);	
					} else {
						adminDetailDto2.setInstituteDetailsDto(adminDetailDto.getInstituteDetailsDto());
					}					
					
					String password = this.randomGeneratedString();
					
					adminDetailDto2.setIstr_password(this.Md5value(password));
					this.getAdminManagementServices().saveOrUpdatUserDetailDto(adminDetailDto2);
					adminDetailDto2 = null;
					
					try {
						this.sendMailToRegisteredUser(studentDetailsDto, password);
						info = "Data has been submited successfully. Please check Email id for Username and Password.";
						
					} catch (Exception e) {
						info = "Data has been submited successfully but due to some technical problem we are unable to send you user registration mail, So we request you to please contact Xamdesk using contact us page.";
						e.printStackTrace();
					}
					studentDetailsDto = null;
					this.showStudentDetails();
					flag = CommonConstants.SUCCESS_FLAG;	
	        	}
			} else {
				
				System.out.println("My File Name"+getMyfileFileName());
				if(getMyfileFileName() != null) {
					BufferedImage imgFile = getImageAndReduceSize(getMyfile());
					ByteArrayOutputStream bas = new ByteArrayOutputStream();
					ImageIO.write(imgFile, "jpg", bas);
						
					byte[] fileContents = bas.toByteArray();
						    		
					BASE64Encoder encodeData = new BASE64Encoder();
					String fileData = encodeData.encode(fileContents);
							    			
					studentDetailsDto.setIbl_std_pic(fileData);			    			    		
				}	    		
				studentDetailsDto.setIdt_entry_date(new Date());
				studentDetailsDto.setInum_is_active(1); 
				studentDetailsDto.setAdminDetailDto(adminDetailDto);
				
				SimpleDateFormat st = new SimpleDateFormat("dd-MMM-yyyy");
				String redDate = st.format(new Date());
					
				studentDetailsDto.setIdt_registration_date(redDate);
					
				this.getStudentDetailsServices().updateStudentDetailsDto(studentDetailsDto);
									
				info = "Student details has been Updated successfully.";
				studentDetailsDto = null;
				this.showStudentDetails();
				flag = "update_success";	
				
			}
	 	 } catch (Exception e) {
			e.printStackTrace();
	 	 }		
      	 return flag;
	}
	
	
	
	public String updateStudentDetailsDto() throws POLLINGBusinessException{
		
		String flag = CommonConstants.FAILURE_ERROR;
		this.populateMenu();
        if(request.getSession().getAttribute("adminDetailDto") == null) {
        	return "login";
		}
		try {
			
			if(studentDetailsDto.getInum_student_id() == null){
	    		
				info = "You are not authorised to update your profile.";	
	    		
			} else {		
				
				StudentDetailsDto detailsDto = new StudentDetailsDto();
				detailsDto = this.getStudentDetailsServices().findStudentDetailsById(studentDetailsDto.getInum_student_id());
				
				if(getMyfileFileName() != null) {
					
					BufferedImage imgFile = getImageAndReduceSize(getMyfile());
					ByteArrayOutputStream bas = new ByteArrayOutputStream();
					ImageIO.write(imgFile, "jpg", bas);
						
					byte[] fileContents = bas.toByteArray();
						    		
					BASE64Encoder encodeData = new BASE64Encoder();
					String fileData = encodeData.encode(fileContents);
							    			
					studentDetailsDto.setIbl_std_pic(fileData);			    			    		
				} else {
					studentDetailsDto.setIbl_std_pic(detailsDto.getIbl_std_pic());
				}
				
				studentDetailsDto.setIdt_entry_date(new Date());
				studentDetailsDto.setInum_is_active(detailsDto.getInum_is_active()); 
				
				SimpleDateFormat st = new SimpleDateFormat("dd-MMM-yyyy");
				String redDate = st.format(new Date());
					
				studentDetailsDto.setIdt_registration_date(redDate);
					
				this.getStudentDetailsServices().updateStudentDetailsDto(studentDetailsDto);
									
				info = "Profile details has been Updated successfully.";
				studentDetailsDto = null;
				detailsDto = null;
				this.showUpdateStudentDetails();
				flag = CommonConstants.SUCCESS_FLAG;	
				
			}
	 	 } catch (Exception e) {
			e.printStackTrace();
	 	 }		
      	 return flag;
	}
	
	
	
	public String saveUserDetails() throws POLLINGBusinessException{
		
		String flag = CommonConstants.FAILURE_ERROR;
		try {
			
			String emailreg = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		    Boolean emailValidation = studentDetailsDto.getIstr_email().matches(emailreg);
		        
		    Pattern contact_pattern = Pattern.compile("\\d{10}");
			Matcher mobileValidation = contact_pattern.matcher(studentDetailsDto.getInum_mobile_number());
			
			String captchatext = request.getParameter("captchatext");
			String reqCaptcha = (String) request.getSession().getAttribute("captcha");
			
			if(studentDetailsDto.getIstr_first_name().equals("")) {
	    		
	    		info = "Please Enter First Name";
	    		return flag;
	    		
	    	} else if(studentDetailsDto.getIstr_email().equals("") || studentDetailsDto.getIstr_email() == null) {
		    	
		    	info = "Please enter email id";
		    	return flag;	
		    	
		    } else if(emailValidation == false) {
			    	
		    	info = "Please enter valid email id";
		    	return flag;	    	
			 
		    } else if(studentDetailsDto.getInum_mobile_number().equals("") || studentDetailsDto.getInum_mobile_number() == null) {
		    	
		    	info = "Please enter mobile number";
		    	return flag;
		    
		    } else if(!mobileValidation.matches()) {
		    	
		    	info = "Please enter valid mobile number";
		    	return flag;
		    	
		    } 
			
			// Check here only by email id 27/2/17
			List<StudentDetailsDto> studentDetailsDtoList = this.getStudentDetailsServices().checkAvailStudentDetailsByUsername(studentDetailsDto.getIstr_first_name(), studentDetailsDto.getIstr_email());
	    	System.out.println("List Size : "+studentDetailsDtoList.size());	    		 
	    		
	    	if(studentDetailsDtoList != null && studentDetailsDtoList.size() > 0){
	    	    	
	    		this.showStudentDetails();		    		
	        	studentDetailsDto = null;
	        	info = "Unique ID is already generated for mentioned email id. Kindly use the Forget Password to know about your password.";			    		
	        	flag = CommonConstants.SUCCESS_FLAG;
	        	
	        } else {
									
	        	SimpleDateFormat st = new SimpleDateFormat("dd-MMM-yyyy");
	    		String redDate = st.format(new Date());
	    		
	    		studentDetailsDto.setIdt_registration_date(redDate);
	    		studentDetailsDto.setIstr_unique_id(this.generateUniqueId());
				studentDetailsDto.setIdt_entry_date(new Date());
				studentDetailsDto.setInum_is_active(2);
				studentDetailsDto.setInum_status(2);
					
				this.getStudentDetailsServices().updateStudentDetailsDto(studentDetailsDto);
					
				AdminDetailDto adminDetailDto = new AdminDetailDto();
					
				adminDetailDto.setIdt_entry_date(new Date());
				adminDetailDto.setInum_account_status(2);
				adminDetailDto.setInum_is_active(1);
				adminDetailDto.setInum_is_verified(2);
				adminDetailDto.setInum_role_id(3);
				adminDetailDto.setInum_account_status(2);
				adminDetailDto.setIstr_address(studentDetailsDto.getIstr_street_address());
				adminDetailDto.setIstr_email(studentDetailsDto.getIstr_email());
				adminDetailDto.setIstr_login_id(studentDetailsDto.getIstr_unique_id());
				adminDetailDto.setIstr_dob(studentDetailsDto.getIstr_date_of_birth());
				adminDetailDto.setIstr_password("");
				adminDetailDto.setIstr_mobile_no(studentDetailsDto.getInum_mobile_number());
				adminDetailDto.setIstr_user_name(studentDetailsDto.getIstr_first_name());
				adminDetailDto.setInum_student_employee_id(studentDetailsDto.getInum_student_id());
				
				List<InstituteDetailsDto> instituteList = new ArrayList<InstituteDetailsDto>();
				instituteList = this.getMasterDetailsServices().checkAvailInstituteDetails("Xamdesk");
				if(instituteList != null && instituteList.size()>0) {
					adminDetailDto.setInstituteDetailsDto(instituteList.get(0));	
				} else {			
					InstituteDetailsDto detailsDto = new InstituteDetailsDto();
					adminDetailDto.setInstituteDetailsDto(detailsDto);	
				}
				String password = this.randomGeneratedString();
					
				adminDetailDto.setIstr_password(this.Md5value(password));
				this.getAdminManagementServices().saveOrUpdatUserDetailDto(adminDetailDto);
				adminDetailDto = null;
					
				try {
					this.sendMailToRegisteredUser(studentDetailsDto, password);
					info = "Data has been submited successfully. Please check Email id for Username and Password.";					
				} catch (Exception e) {
					e.printStackTrace();
					info = "Data has been submited successfully but due to some technical problem we are unable to send you user registration mail, So we request you to please contact Xamdesk using contact us page.";
				}
				studentDetailsDto = null;
				this.showStudentDetails();
				flag = CommonConstants.SUCCESS_FLAG;	
			} 
	 	 } catch (Exception e) {
			e.printStackTrace();
	 	 }		
      	 return flag;
	}
	
	/*Facebook login Method*/
	public String saveSocialUserDetails() throws POLLINGBusinessException{
		
		String flag = CommonConstants.FAILURE_ERROR;
		try {
		      String rid = request.getParameter("request_ids");
		      if (rid != null) {
		    	  response.sendRedirect("https://www.facebook.com/dialog/oauth?client_id="+Setup.FACEBOOK_CLIENT_ID+"&redirect_uri="+Setup.FACEBOOK_REDIRECT_URI+"");
		      } else {
		    	  String code = request.getParameter("code");
		    	  if (code != null) {
			          URL url = new URL("https://graph.facebook.com/oauth/access_token?client_id="+Setup.FACEBOOK_CLIENT_ID+"&redirect_uri="+Setup.FACEBOOK_REDIRECT_URI+"&client_secret="+Setup.FACEBOOK_CLIENT_SECRET+"&code=" +code);
			          HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			          conn.setRequestMethod("GET");
			          conn.setConnectTimeout(20000);
			          String outputString = "";
			          BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		          	  String line;
		          	  while ((line = reader.readLine()) != null) {
		          		  outputString = outputString + line;
		          	  }
		              System.out.println(outputString);
		          	  String accessToken = null;
		          	  System.out.println("outputString::::::::::::"+outputString);
		          	  
		          	  if (outputString.indexOf("access_token") != -1) {
		        	  	 JSONObject json = new JSONObject(outputString);
		        		 accessToken = json.getString("access_token");
		        		 System.out.println("accessToken ::::::::::::"+accessToken);
		                 //accessToken = outputString.substring(13, outputString.indexOf("&"));
		              }
		              System.out.println(accessToken);
		              url = new URL("https://graph.facebook.com/me?locale=en_US&fields=email,gender,first_name,last_name&access_token=" +accessToken);
		              System.out.println(url);
		              URLConnection conn1 = url.openConnection();
		              conn1.setConnectTimeout(7000);
		              outputString = "";
		          	  reader = new BufferedReader(new InputStreamReader(conn1.getInputStream()));
			          
		          	  while ((line = reader.readLine()) != null) {
			        	  outputString = outputString + line;
			          }
		          	  reader.close();
		          	  System.out.println(outputString);
			          try {
				  			JSONObject json = new JSONObject(outputString);
				  			first_name = json.getString("first_name");
				  			last_name = json.getString("last_name");
				  			email_id = json.getString("email");
				  			istr_gender = json.getString("gender");
				  			
			  		  } catch (JSONException e) {
			  			  e.printStackTrace();
			  			  throw new RuntimeException("ERROR in parsing FB graph data. " + e);
			  		  }
		        }
		      }
		      if(email_id.equals("") || email_id == null) {
					return flag;
			  }			
			  // Check here only by email id 27/2/17
			  List<AdminDetailDto> adminDetailDtos = new ArrayList<AdminDetailDto>();
		      adminDetailDtos = this.getAdminManagementServices().checkAvailabilityByEmailId(email_id);
				
		      if(adminDetailDtos != null && adminDetailDtos.size() > 0){
		    	  /*Allow the user to login into portal*/
		    	  AdminDetailDto adminDetailDto = adminDetailDtos.get(0);
		    	  this.userAuthenticationMappings(adminDetailDto);
		    	  return "login";		    	 
		      } else {										
		          SimpleDateFormat st = new SimpleDateFormat("dd-MMM-yyyy");
		    	  String redDate = st.format(new Date());
		    		
		    	  studentDetailsDto.setIstr_email(email_id);
		    	  studentDetailsDto.setIstr_first_name(first_name);
		    	  studentDetailsDto.setIstr_last_name(last_name);
		    		
		    	  studentDetailsDto.setIdt_registration_date(redDate);
		    	  studentDetailsDto.setIstr_unique_id(this.generateUniqueId());
				  studentDetailsDto.setIdt_entry_date(new Date());
				  studentDetailsDto.setInum_is_active(2);
				  studentDetailsDto.setInum_status(2);
						
				  this.getStudentDetailsServices().updateStudentDetailsDto(studentDetailsDto);
						
				  AdminDetailDto adminDetailDto = new AdminDetailDto();
						
				  adminDetailDto.setIdt_entry_date(new Date());
				  adminDetailDto.setInum_account_status(2);
				  adminDetailDto.setInum_is_active(1);
				  adminDetailDto.setInum_is_verified(2);
				  adminDetailDto.setInum_role_id(3);
				  adminDetailDto.setInum_account_status(2);
				  adminDetailDto.setIstr_address(studentDetailsDto.getIstr_street_address());
				  adminDetailDto.setIstr_email(studentDetailsDto.getIstr_email());
				  adminDetailDto.setIstr_login_id(studentDetailsDto.getIstr_unique_id());
				  adminDetailDto.setIstr_dob(studentDetailsDto.getIstr_date_of_birth());
				  adminDetailDto.setIstr_password("");
				  adminDetailDto.setIstr_mobile_no(studentDetailsDto.getInum_mobile_number());
				  adminDetailDto.setIstr_user_name(studentDetailsDto.getIstr_first_name());
				  adminDetailDto.setInum_student_employee_id(studentDetailsDto.getInum_student_id());
				
				  List<InstituteDetailsDto> instituteList = new ArrayList<InstituteDetailsDto>();
				  instituteList = this.getMasterDetailsServices().checkAvailInstituteDetails("Xamdesk");
				  if(instituteList != null && instituteList.size()>0) {
					  adminDetailDto.setInstituteDetailsDto(instituteList.get(0));	
				  } else {			
					  InstituteDetailsDto detailsDto = new InstituteDetailsDto();
					  adminDetailDto.setInstituteDetailsDto(detailsDto);	
				  }
				  String password = this.randomGeneratedString();
						
				  adminDetailDto.setIstr_password(this.Md5value(password));
				  this.getAdminManagementServices().saveOrUpdatUserDetailDto(adminDetailDto);
				  request.getSession().setAttribute("adminDetailDto", adminDetailDto);
		    	  flag = CommonConstants.SUCCESS_FLAG;
						
				  try {
					  this.sendMailToRegisteredUser(studentDetailsDto, password);
					  info = "Data has been submited successfully. Please check Email id for Username and Password.";
					  flag = CommonConstants.SUCCESS_FLAG;	
				  } catch (Exception e) {
					  e.printStackTrace();
					  info = "Data has been submited successfully but due to some technical problem we are unable to send you user registration mail, So we request you to please contact Xamdesk using contact us page.";
					  flag = CommonConstants.SUCCESS_FLAG;	
				  }
				  studentDetailsDto = null;
				  this.showStudentDetails();					
			  }
		    } catch (Exception e) {
		    	e.printStackTrace();
		    	flag = CommonConstants.ERROR_FLAG;	       	
		    }		 
			return flag;
	}
	
	
	/*GOOGLE login Method*/
	public String saveGoogleSocialUserDetails() throws POLLINGBusinessException{
		
		String flag = CommonConstants.FAILURE_ERROR;
		try {
			String code = request.getParameter("code");
			String urlParameters = "code=" +code +"&client_id=" + Setup.GOOGLE_CLIENT_ID +"&client_secret=" + Setup.GOOGLE_CLIENT_SECRET +"&redirect_uri=" + Setup.GOOGLE_REDIRECT_URL +"&grant_type=authorization_code";
			URL url = new URL("https://accounts.google.com/o/oauth2/token");
			URLConnection conn = url.openConnection();
			conn.setDoOutput(true);
			OutputStreamWriter writer = new OutputStreamWriter(
			conn.getOutputStream());
			        
			writer.write(urlParameters);
			writer.flush();
			String data = "";
			BufferedReader reader = new BufferedReader(new InputStreamReader(
			conn.getInputStream()));
			String line;
			        
			while ((line = reader.readLine()) != null) {
				data = data + line;
			}
			String s = GsonUtility.getJsonElementString("access_token", data);
			url = new URL("https://www.googleapis.com/oauth2/v1/userinfo?access_token=" +s);
			conn = url.openConnection();
			data = "";
			
			reader = new BufferedReader(new InputStreamReader(
			conn.getInputStream()));
			while ((line = reader.readLine()) != null) {
			    data = data + line;
			}
			System.out.println(data);
	        try {
		  		JSONObject json = new JSONObject(data);
		  		first_name = json.getString("given_name");
		  		last_name = json.getString("family_name");
		  		email_id = json.getString("email");
		  		if(first_name.equals("")) {
		  			first_name = json.getString("name");
		  		}
		  			
	  		} catch (JSONException e) {
	  		    e.printStackTrace();
	  		    throw new RuntimeException("ERROR in parsing FB graph data. " + e);
	  		}        
			writer.close();
			reader.close();
			System.out.println(data);
				    	
		    if(email_id.equals("") || email_id == null) {
		    	return flag;
			}			
			// Check here only by email id 27/2/17
			List<AdminDetailDto> adminDetailDtos = new ArrayList<AdminDetailDto>();
		    adminDetailDtos = this.getAdminManagementServices().checkAvailabilityByEmailId(email_id);
				
		    if(adminDetailDtos != null && adminDetailDtos.size() > 0){
		       /*Allow the user to login into portal*/
		       AdminDetailDto adminDetailDto = adminDetailDtos.get(0);
		       this.userAuthenticationMappings(adminDetailDto);
		       return "login";		    	 
		    } else {										
		       SimpleDateFormat st = new SimpleDateFormat("dd-MMM-yyyy");
		       String redDate = st.format(new Date());
		    		
		       studentDetailsDto.setIstr_email(email_id);
		       studentDetailsDto.setIstr_first_name(first_name);
		       studentDetailsDto.setIstr_last_name(last_name);
		    		
		       studentDetailsDto.setIdt_registration_date(redDate);
		       studentDetailsDto.setIstr_unique_id(this.generateUniqueId());
			   studentDetailsDto.setIdt_entry_date(new Date());
			   studentDetailsDto.setInum_is_active(2);
			   studentDetailsDto.setInum_status(2);
						
			   this.getStudentDetailsServices().updateStudentDetailsDto(studentDetailsDto);
			   AdminDetailDto adminDetailDto = new AdminDetailDto();
						
			   adminDetailDto.setIdt_entry_date(new Date());
			   adminDetailDto.setInum_account_status(2);
			   adminDetailDto.setInum_is_active(1);
			   adminDetailDto.setInum_is_verified(2);
			   adminDetailDto.setInum_role_id(3);
			   adminDetailDto.setInum_account_status(2);
			   adminDetailDto.setIstr_address(studentDetailsDto.getIstr_street_address());
			   adminDetailDto.setIstr_email(studentDetailsDto.getIstr_email());
			   adminDetailDto.setIstr_login_id(studentDetailsDto.getIstr_unique_id());
			   adminDetailDto.setIstr_dob(studentDetailsDto.getIstr_date_of_birth());
			   adminDetailDto.setIstr_password("");
			   adminDetailDto.setIstr_mobile_no(studentDetailsDto.getInum_mobile_number());
			   adminDetailDto.setIstr_user_name(studentDetailsDto.getIstr_first_name());
			   adminDetailDto.setInum_student_employee_id(studentDetailsDto.getInum_student_id());
				
			   List<InstituteDetailsDto> instituteList = new ArrayList<InstituteDetailsDto>();
			   instituteList = this.getMasterDetailsServices().checkAvailInstituteDetails("Xamdesk");
			   if(instituteList != null && instituteList.size()>0) {
				  adminDetailDto.setInstituteDetailsDto(instituteList.get(0));	
			   } else {			
				  InstituteDetailsDto detailsDto = new InstituteDetailsDto();
				  adminDetailDto.setInstituteDetailsDto(detailsDto);	
			   }
			   String password = this.randomGeneratedString();
			   adminDetailDto.setIstr_password(this.Md5value(password));
			   this.getAdminManagementServices().saveOrUpdatUserDetailDto(adminDetailDto);
			   request.getSession().setAttribute("adminDetailDto", adminDetailDto);
		       flag = CommonConstants.SUCCESS_FLAG;
						
			   try {
				  this.sendMailToRegisteredUser(studentDetailsDto, password);
				  info = "Data has been submited successfully. Please check Email id for Username and Password.";
				  flag = CommonConstants.SUCCESS_FLAG;	
			  } catch (Exception e) {
				  e.printStackTrace();
				  info = "Data has been submited successfully but due to some technical problem we are unable to send you user registration mail, So we request you to please contact Xamdesk using contact us page.";
				  flag = CommonConstants.SUCCESS_FLAG;	
			  }
			  studentDetailsDto = null;
			  this.showStudentDetails();					
			}
		 } catch (Exception e) {
		   	e.printStackTrace();
		   	flag = CommonConstants.ERROR_FLAG;	       	
		 }		 
		 return flag;
	}
	
	public String confirmationUserDetails() throws Exception {
		
		String  flag = CommonConstants.FAILURE_ERROR;
		try {
			if(request.getSession().getAttribute("adminDetailDto") == null) {
				return flag;
			} 
			AdminDetailDto adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
			this.userAuthenticationMappings(adminDetailDto);
			flag = CommonConstants.SUCCESS_FLAG; 		
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return flag;		
	}
	
	public void userAuthenticationMappings(AdminDetailDto adminDetailDto) throws Exception {
		
		request.getSession().setAttribute("adminDetailDto", adminDetailDto);
		request.getSession().setAttribute("username", adminDetailDto.getIstr_user_name());
		 
	    String user_name =	adminDetailDto.getIstr_user_name();
	    request.getSession().setAttribute("userName", user_name);
	    Integer role_id = adminDetailDto.getInum_role_id();
	    List<RolePermissionMasterDto> rolePermissionDtoList =  this.getRolePermissionManagementServices().findPermissionByRole(role_id);
	    if(rolePermissionDtoList!=null && rolePermissionDtoList.size()>0){
	    	request.getSession().setAttribute("rolePermissionDtoList", rolePermissionDtoList);
	    }
	     
	     List<CourseDetailsDto> courseDetailsDtoList = new ArrayList<CourseDetailsDto>();
	     courseDetailsDtoList = this.getMasterDetailsServices().getCourseDetailsDtoList();
	      
	     List<ExamDetailsDto> examDetailsDtoList = new ArrayList<ExamDetailsDto>();
	     
	     if(courseDetailsDtoList != null && courseDetailsDtoList.size()>0) {
	    	 request.getSession().setAttribute("courseDetailsDtoList", courseDetailsDtoList);
			    
	    	 examDetailsDtoList = this.getExaminationDetailsServices().getExamDetailsDtoListByCourseId(courseDetailsDtoList.get(0).getOnum_slno());
	    	 request.getSession().setAttribute("examDetailsDtoList", examDetailsDtoList);
	    	 
	    	 List<StudentMappedExamDetailsDto> studentMappedExamDetailsDtoList = new ArrayList<StudentMappedExamDetailsDto>();
			 studentMappedExamDetailsDtoList = this.getExaminationDetailsServices().getStudentMappedExamDetailsDtoListByStudentId(adminDetailDto.getInum_user_id());
			 request.getSession().setAttribute("studentMappedExamDetailsDtoList", studentMappedExamDetailsDtoList);

		     List<DashBoardDto> dashBoardDtoList = this.getMasterDetailsServices().getDashBoardDtoList();
		     request.getSession().setAttribute("dashBoardDtoList", dashBoardDtoList);						    
	     }
	     
	     List<MappedExamDetailsDto> list = new ArrayList<MappedExamDetailsDto>();
	     list = this.getExaminationDetailsServices().getMappedExamDetailsDtoListByStudentId(adminDetailDto.getInum_user_id());
	     if(list != null && list.size()>0) {
	    	 request.getSession().setAttribute("register_button_status", "1");
	     } else {
	    	 request.getSession().setAttribute("register_button_status", "0");
	     }
	     
	     request.getSession().setAttribute("adminDetailDto", adminDetailDto);
	    
	}
	
	public String editStudentDetails() throws Exception
	{
		
		String  flag = CommonConstants.FAILURE_ERROR;
		this.populateMenu();
		if(request.getSession().getAttribute("adminDetailDto") == null) {
			return "login";
		}    	
		String sl_no =  request.getParameter("sl_no");
		Integer slno = Integer.parseInt(sl_no);
		System.out.println("sl no is "+slno);
		
		studentDetailsDto = new StudentDetailsDto();
		studentDetailsDto = this.getStudentDetailsServices().findStudentDetailsById(slno);		
		request.getSession().setAttribute("studentDetailsDto", studentDetailsDto);
		
		flag = CommonConstants.SUCCESS_FLAG; 
		return flag;
		
	}
	
	
	public String deleteStudentInfo() throws Exception{
		   
		   String  flag = CommonConstants.FAILURE_ERROR;
		   if(request.getSession().getAttribute("adminDetailDto") == null) {
			   return "login";
		   }
		   Integer slno = Integer.parseInt(request.getParameter("sl_no"));
		   studentDetailsDto =  this.getStudentDetailsServices().findStudentDetailsById(slno);
		   studentDetailsDto.setInum_is_active(0);
		   this.getStudentDetailsServices().updateStudentDetailsDto(studentDetailsDto);
		   
		   AdminDetailDto adminDetailDto = new AdminDetailDto();
		   List<AdminDetailDto> adminDetailDtoList = new ArrayList<AdminDetailDto>();
		  
		   adminDetailDtoList = this.getAdminManagementServices().getAdminDetailDto(studentDetailsDto.getIstr_unique_id());
		   if(adminDetailDtoList != null && adminDetailDtoList.size()>0) {
			   adminDetailDto = adminDetailDtoList.get(0);
			   
			   adminDetailDto.setInum_role_id(3);
			   adminDetailDto.setInum_account_status(2);
			   adminDetailDto.setIstr_user_name(studentDetailsDto.getIstr_first_name());
			   
			   this.getAdminManagementServices().saveOrUpdatUserDetailDto(adminDetailDto);
			   adminDetailDto = null;
			   adminDetailDtoList = null;
		   }
		   
		   info = "Student Details has been deleted successfully";
		   studentDetailsDto = new StudentDetailsDto();
		   flag = CommonConstants.SUCCESS_FLAG;
		   showStudentDetails();
		   return flag ;
	}
	
	public String changeStudentStatus() throws Exception{
		   
		   String  flag = CommonConstants.FAILURE_ERROR;
		   if(request.getSession().getAttribute("adminDetailDto") == null) {
			   return "login";
		   }
		   Integer slno = Integer.parseInt(request.getParameter("sl_no"));
		   studentDetailsDto =  this.getStudentDetailsServices().findStudentDetailsById(slno);
		   
		   if(studentDetailsDto.getInum_is_active().equals(1)) {
			   studentDetailsDto.setInum_is_active(0);
			   studentDetailsDto.setInum_status(0);
			   AdminDetailDto adminDetailDto = new AdminDetailDto();
			   List<AdminDetailDto> adminDetailDtoList = new ArrayList<AdminDetailDto>();
			  
			   adminDetailDtoList = this.getAdminManagementServices().getAdminDetailDto(studentDetailsDto.getIstr_unique_id());
			   if(adminDetailDtoList != null && adminDetailDtoList.size()>0) {
				   adminDetailDto = adminDetailDtoList.get(0);
				   
				   adminDetailDto.setInum_role_id(3);
				   adminDetailDto.setInum_account_status(2);
				   adminDetailDto.setIstr_user_name(studentDetailsDto.getIstr_first_name());
				   
				   this.getAdminManagementServices().saveOrUpdatUserDetailDto(adminDetailDto);
				   adminDetailDto = null;
				   adminDetailDtoList = null;
			   }
		   } else {
			   studentDetailsDto.setInum_is_active(1);
			   studentDetailsDto.setInum_status(1);
			   AdminDetailDto adminDetailDto = new AdminDetailDto();
			   List<AdminDetailDto> adminDetailDtoList = new ArrayList<AdminDetailDto>();
			  
			   adminDetailDtoList = this.getAdminManagementServices().getAdminDetailDto(studentDetailsDto.getIstr_unique_id());
			   if(adminDetailDtoList != null && adminDetailDtoList.size()>0) {
				   adminDetailDto = adminDetailDtoList.get(0);
				   
				   adminDetailDto.setInum_role_id(2);
				   adminDetailDto.setInum_account_status(1);
				   adminDetailDto.setIstr_user_name(studentDetailsDto.getIstr_first_name());
				   
				   this.getAdminManagementServices().saveOrUpdatUserDetailDto(adminDetailDto);
				   adminDetailDto = null;
				   adminDetailDtoList = null;
			   }
		   }
		   this.getStudentDetailsServices().updateStudentDetailsDto(studentDetailsDto);
		   info = "Student Details has change successfully";
		   studentDetailsDto = new StudentDetailsDto();
		   this.showStudentDetailsList();
		   flag = CommonConstants.SUCCESS_FLAG;
		   return flag ;
	}
	
	public String approveStudentStatus() throws Exception{
		   
		   String  flag = CommonConstants.FAILURE_ERROR;
		   if(request.getSession().getAttribute("adminDetailDto") == null) {
			   return "login";
		   }
		   Integer slno = Integer.parseInt(request.getParameter("sl_no"));
		   studentDetailsDto =  this.getStudentDetailsServices().findStudentDetailsById(slno);
		   
		   studentDetailsDto.setInum_is_active(1);
		   studentDetailsDto.setInum_status(1);
		   
		   this.getStudentDetailsServices().updateStudentDetailsDto(studentDetailsDto);
		   AdminDetailDto adminDetailDto = new AdminDetailDto();
		   List<AdminDetailDto> adminDetailDtoList = new ArrayList<AdminDetailDto>();
		  
		   adminDetailDtoList = this.getAdminManagementServices().getAdminDetailDto(studentDetailsDto.getIstr_unique_id());
		   if(adminDetailDtoList != null && adminDetailDtoList.size()>0) {
			   adminDetailDto = adminDetailDtoList.get(0);
			   
			   adminDetailDto.setInum_role_id(2);
			   adminDetailDto.setInum_account_status(1);
			   adminDetailDto.setIstr_user_name(studentDetailsDto.getIstr_first_name());
			   
			   this.getAdminManagementServices().saveOrUpdatUserDetailDto(adminDetailDto);
			   adminDetailDto = null;
			   adminDetailDtoList = null;
		   }
		   info = "Student Details has approved successfully";
		   studentDetailsDto = new StudentDetailsDto();
		   this.showNewStudentRequestDetails();
		   flag = CommonConstants.SUCCESS_FLAG;
		   return flag ;
	}
	
	public String rejectStudentStatus() throws Exception{
		   
		   String  flag = CommonConstants.FAILURE_ERROR;
		   if(request.getSession().getAttribute("adminDetailDto") == null) {
			   return "login";
		   }
		   Integer slno = Integer.parseInt(request.getParameter("sl_no"));
		   studentDetailsDto =  this.getStudentDetailsServices().findStudentDetailsById(slno);
		   
		   studentDetailsDto.setInum_is_active(0);
		   studentDetailsDto.setInum_status(0);
		   
		   this.getStudentDetailsServices().updateStudentDetailsDto(studentDetailsDto);
		   AdminDetailDto adminDetailDto = new AdminDetailDto();
		   List<AdminDetailDto> adminDetailDtoList = new ArrayList<AdminDetailDto>();
		  
		   adminDetailDtoList = this.getAdminManagementServices().getAdminDetailDto(studentDetailsDto.getIstr_unique_id());
		   if(adminDetailDtoList != null && adminDetailDtoList.size()>0) {
			   adminDetailDto = adminDetailDtoList.get(0);
			   
			   adminDetailDto.setInum_role_id(3);
			   adminDetailDto.setInum_account_status(2);
			   adminDetailDto.setIstr_user_name(studentDetailsDto.getIstr_first_name());
			   
			   this.getAdminManagementServices().saveOrUpdatUserDetailDto(adminDetailDto);
			   adminDetailDto = null;
			   adminDetailDtoList = null;
		   }
		   info = "Student Details has rejected successfully";
		   studentDetailsDto = new StudentDetailsDto();
		   this.showNewStudentRequestDetails();
		   flag = CommonConstants.SUCCESS_FLAG;
		   return flag ;
	}
	
	public void sendMailToRegisteredUser(StudentDetailsDto studentDetailsDto, String password) {

		Calendar cal = Calendar.getInstance();
		String date = " Date:" + cal.getTime();
		String url = "www.xamdesk.com";

		String emailBody = "Hi "+studentDetailsDto.getIstr_first_name()+"<br/><br/>Here is your member account login information for Xamdesk as requested. Please be sure to change your password after login."+
				   "<br/><br/><h4>Your Member Account</h4><br/><br/>Username :&nbsp;&nbsp;&nbsp;"+studentDetailsDto.getIstr_unique_id()+"<br/>Password :&nbsp;&nbsp;&nbsp;"+password+
				   "<br/><br/>If you have any enquiries, please do not hesitate to contact our support team who are available 24/7 to assist you. Call (+91) 9958903074.<br/><br/>Regards<br/>Xamdesk Team";

		
		System.out.println("emailBody************************************"+ emailBody);
		SendMailTLS sendMailTLS = new SendMailTLS(studentDetailsDto.getIstr_email(), "XAMDESK ("+studentDetailsDto.getIstr_unique_id()+") : User Registration Mail", emailBody);
		sendMailTLS.sendEmail();
	}
		
	// Resize of Image 
	protected BufferedImage getImageAndReduceSize(File imageFile){
			   
		BufferedImage originalImage = null;
		try {
		    originalImage = ImageIO.read(imageFile);
	    } catch (IOException e) {
		    e.printStackTrace();
	    }
			  
		int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
		//call function
		BufferedImage resizeImageJpg = resizeImage(originalImage, type);
		return resizeImageJpg;
	}
			  
			  
	// Reduce the height and width of images
	protected BufferedImage resizeImage(BufferedImage originalImage, int type){
	       BufferedImage resizedImage = new BufferedImage(400, 600, type);
	       Graphics2D g = resizedImage.createGraphics();
	       g.drawImage(originalImage, 0, 0, 400, 600, null);
	       g.dispose();

	       return resizedImage;
	}
	
	public String generateUniqueId(){
		
		//code start to create unique id for a student 
		DateFormat dateFormat = new SimpleDateFormat("yy");		
		String yy = dateFormat.format(new Date());
		System.out.println("To get yy(e.g-14)"+yy);
		String unique_id = "";
		Integer maxUniqueId = 0;
		Integer finalMaxUniqueId = 0;
		
		
		
		try {
			List<StudentDetailsDto> userDetailsList = this.getStudentDetailsServices().getAllStudentDetailsDto(studentDetailsDto);
			if(userDetailsList != null && userDetailsList.size() > 0){
				unique_id = "XD/"+yy+"/%";
				List<StudentDetailsDto> userDetailsDtoList = this.getStudentDetailsServices().checkMaxUniqueByYear(unique_id);
				if(userDetailsDtoList != null && userDetailsDtoList.size() > 0){
					for (int i = 0; i < userDetailsDtoList.size(); i++) {
					
						String maxIdValue =  userDetailsDtoList.get(i).getIstr_unique_id();
						String[] uniqueIdArray = maxIdValue.split("/");
					
						maxUniqueId = Integer.parseInt(uniqueIdArray[2]);
						if(maxUniqueId > finalMaxUniqueId) {
							finalMaxUniqueId = maxUniqueId;
						}	    					
					}   
				
					finalMaxUniqueId++;
					unique_id = "XD/"+yy+"/"+finalMaxUniqueId;
					System.out.println("The final unique id is :::::::"+unique_id);
				
				} else {
					unique_id = "XD/"+yy+"/101";
				}		    			
			} else {
				unique_id = "XD/"+yy+"/101";
			}	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		// end of code 
		return unique_id;
	}
	
	// this method is used for generating string
	public String randomGeneratedString() {

		final int PASSWORD_LENGTH = 8;
		StringBuffer sb = new StringBuffer();
		for (int x = 0; x < PASSWORD_LENGTH; x++) {
			sb.append((char) ((int) (Math.random() * 26) + 97));
		}
		String a = sb.toString();
		System.out.println(a);

		return a;
	}

	// Method Of MD5 algorithm...........
	public String Md5value(String pass) throws Exception,
		NoSuchAlgorithmException {
		MessageDigest m = MessageDigest.getInstance("MD5");
		m.reset();

		m.update(pass.getBytes());
		byte[] digest = m.digest();
		BigInteger bigInt = new BigInteger(1, digest);
		String hashtext = bigInt.toString(16);
		while (hashtext.length() < 32) {
			hashtext = "0" + hashtext;
		}
		return hashtext;
	}
	
	private IStudentDetailsServices getStudentDetailsServices(){
		Object serviceObj = ServiceLocator.getInstance().getService(CommonConstants.STUDENT_DETAILS);
				return serviceObj == null ? null : (IStudentDetailsServices) serviceObj;
	}
	// Admin service locater
	private IAdminService getAdminManagementServices() {
		Object serviceObj = ServiceLocator.getInstance().getService(com.sms.constants.CommonConstants.ADMIN_MANAGEMENT_SERVICE);
			return serviceObj == null ? null : (IAdminService) serviceObj;
	}
	// Admin service locater
	private IMasterDetailsServices getMasterDetailsServices () {
		Object serviceObj = ServiceLocator.getInstance().getService(com.oes.constants.CommonConstants.MASTER_DETAILS);
			return serviceObj == null ? null : (IMasterDetailsServices) serviceObj;
	}
	// Role Permission Master Service Locater
	private IRolePermissionService getRolePermissionManagementServices() {
			Object serviceObj = ServiceLocator.getInstance().getService(com.sms.constants.CommonConstants.ROLE_PERMISSION_SERVICE);
			return serviceObj == null ? null : (IRolePermissionService) serviceObj;
	}
		// Role Master Service Locater
	private IRoleMasterServices getRoleMasterServices(){
			Object serviceObj = ServiceLocator.getInstance().getService(com.sms.constants.CommonConstants.ROLE_MASTER_SERVICES);
			return serviceObj == null ? null : (IRoleMasterServices) serviceObj;
	}
	
	// Examination service locater
	private IExaminationDetailsServices getExaminationDetailsServices() {
			Object serviceObj = ServiceLocator.getInstance().getService(com.oes.constants.CommonConstants.EXAMINATION_DETAILS);
			return serviceObj == null ? null : (IExaminationDetailsServices) serviceObj;
	}	
		
	
}
