

package com.sms.admin.action;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.oes.action.common.CommonMethod;
import com.oes.action.common.CreateQuestionPaper;
import com.oes.action.common.LogerFileCommon;
import com.oes.action.common.SendMailTLS;
import com.oes.common.exception.POLLINGBusinessException;
import com.oes.dto.ChangePasswordDto;
import com.oes.dto.ContentDetailsDto;
import com.oes.dto.CourseDetailsDto;
import com.oes.dto.DashBoardDto;
import com.oes.dto.ExamDetailsDto;
import com.oes.dto.ExamQuestionDetailsDto;
import com.oes.dto.ExamSectionDetailsDto;
import com.oes.dto.ExamSubCategoryDetailsDto;
import com.oes.dto.MappedExamDetailsDto;
import com.oes.dto.NewsAndEventsDto;
import com.oes.dto.NotificationDetailsDto;
import com.oes.dto.ResultDescriptionDto;
import com.oes.dto.ResultDetailsDto;
import com.oes.dto.ResultReviewSubjectDto;
import com.oes.dto.StudentDetailsDto;
import com.oes.dto.StudentExamDetailsDto;
import com.oes.dto.StudentMappedExamDetailsDto;
import com.oes.service.IExaminationDetailsServices;
import com.oes.service.IMasterDetailsServices;
import com.oes.service.INewsAndEventsServices;
import com.oes.service.IStudentDetailsServices;
import com.opensymphony.xwork2.ActionSupport;
import com.sms.admin.dto.AdminDetailDto;
import com.sms.admin.dto.RoleMasterDto;
import com.sms.admin.dto.RolePermissionMasterDto;
import com.sms.admin.dto.UserRoleMasterDto;
import com.sms.admin.service.IAdminService;
import com.sms.admin.service.IRoleMasterServices;
import com.sms.admin.service.IRolePermissionService;
import com.sms.common.Enums;
import com.sms.constants.CommonConstants;
import com.sms.util.ServiceLocator;

public class AdminCommonAction extends ActionSupport implements ServletRequestAware, ServletResponseAware{

	private String randomStingJsp;
	HttpSession session = null;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private String randomString;
	
	static Connection con;
	static PreparedStatement st;
	static ResultSet rs;
		
	private String info;
	
	private List<ExamDetailsDto> examDetailsDtoList;
	private List<DashBoardDto> dashBoardDtoList;
	
	private NewsAndEventsDto newsAndEventsDto;
	private List<NewsAndEventsDto> newsAndEventsDtoList;
	
	private AdminDetailDto adminDetailDto;
	private List<AdminDetailDto> adminDetailDtoList = null;
	
	private StudentDetailsDto studentDetailsDto;
	
	private RoleMasterDto roleMasterDto;
	private List<RoleMasterDto> roleMasterList = null;
	private UserRoleMasterDto userRoleMasterDto;
	private List<RolePermissionMasterDto> rolePermissionDtoList = null;
	
	private String loginId;
	private String password;
	private String messages;
	
	private String user_id;
	private String old_password;
	private String new_password;
	private String confirm_password;
	
	private String o_password;
	private String n_password;
	private String c_password;
	
	private File myfile;
	private String myfileContentType;
	private String myfilename;
	
	
	public StudentDetailsDto getStudentDetailsDto() {
		return studentDetailsDto;
	}


	public void setStudentDetailsDto(StudentDetailsDto studentDetailsDto) {
		this.studentDetailsDto = studentDetailsDto;
	}


	public List<DashBoardDto> getDashBoardDtoList() {
		return dashBoardDtoList;
	}


	public void setDashBoardDtoList(List<DashBoardDto> dashBoardDtoList) {
		this.dashBoardDtoList = dashBoardDtoList;
	}


	public String getRandomStingJsp() {
		return randomStingJsp;
	}


	public void setRandomStingJsp(String randomStingJsp) {
		this.randomStingJsp = randomStingJsp;
	}


	public List<ExamDetailsDto> getExamDetailsDtoList() {
		return examDetailsDtoList;
	}


	public void setExamDetailsDtoList(List<ExamDetailsDto> examDetailsDtoList) {
		this.examDetailsDtoList = examDetailsDtoList;
	}


	public NewsAndEventsDto getNewsAndEventsDto() {
		return newsAndEventsDto;
	}


	public void setNewsAndEventsDto(NewsAndEventsDto newsAndEventsDto) {
		this.newsAndEventsDto = newsAndEventsDto;
	}


	public List<NewsAndEventsDto> getNewsAndEventsDtoList() {
		return newsAndEventsDtoList;
	}


	public void setNewsAndEventsDtoList(List<NewsAndEventsDto> newsAndEventsDtoList) {
		this.newsAndEventsDtoList = newsAndEventsDtoList;
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


	public String getMyfilename() {
		return myfilename;
	}


	public void setMyfilename(String myfilename) {
		this.myfilename = myfilename;
	}

	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getOld_password() {
		return old_password;
	}


	public void setOld_password(String old_password) {
		this.old_password = old_password;
	}


	public String getNew_password() {
		return new_password;
	}


	public void setNew_password(String new_password) {
		this.new_password = new_password;
	}


	public String getConfirm_password() {
		return confirm_password;
	}


	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}


	public String getO_password() {
		return o_password;
	}


	public void setO_password(String o_password) {
		this.o_password = o_password;
	}


	public String getN_password() {
		return n_password;
	}


	public void setN_password(String n_password) {
		this.n_password = n_password;
	}


	public String getC_password() {
		return c_password;
	}


	public void setC_password(String c_password) {
		this.c_password = c_password;
	}


	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	
	
	
	public String getInfo() {
		return info;
	}


	public void setInfo(String info) {
		this.info = info;
	}


	public List<AdminDetailDto> getAdminDetailDtoList() {
		return adminDetailDtoList;
	}


	public void setAdminDetailDtoList(List<AdminDetailDto> adminDetailDtoList) {
		this.adminDetailDtoList = adminDetailDtoList;
	}


	public RoleMasterDto getRoleMasterDto() {
		return roleMasterDto;
	}


	public void setRoleMasterDto(RoleMasterDto roleMasterDto) {
		this.roleMasterDto = roleMasterDto;
	}


	public UserRoleMasterDto getUserRoleMasterDto() {
		return userRoleMasterDto;
	}


	public void setUserRoleMasterDto(UserRoleMasterDto userRoleMasterDto) {
		this.userRoleMasterDto = userRoleMasterDto;
	}


	public List<RolePermissionMasterDto> getRolePermissionDtoList() {
		return rolePermissionDtoList;
	}


	public void setRolePermissionDtoList(
			List<RolePermissionMasterDto> rolePermissionDtoList) {
		this.rolePermissionDtoList = rolePermissionDtoList;
	}


	public String getMessages() {
		return messages;
	}


	public void setMessages(String messages) {
		this.messages = messages;
	}


	public List<RoleMasterDto> getRoleMasterList() {
		return roleMasterList;
	}


	public void setRoleMasterList(List<RoleMasterDto> roleMasterList) {
		this.roleMasterList = roleMasterList;
	}


	public AdminDetailDto getAdminDetailDto() {
		return adminDetailDto;
	}


	public void setAdminDetailDto(AdminDetailDto adminDetailDto) {
		this.adminDetailDto = adminDetailDto;
	}


	public String getLoginId() {
		return loginId;
	}


	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRandomString() {
		return randomString;
	}


	public void setRandomString(String randomString) {
		this.randomString = randomString;
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


	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
		
	}


	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		this.request = request;
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
	
	public String execute() throws Exception
	{
		String flag = CommonConstants.SUCCESS_FLAG;
		List<ContentDetailsDto> contentDetailsDtoList = new ArrayList<ContentDetailsDto>();
		contentDetailsDtoList = this.getMasterDetailsServices().getContentDetailsDtoList();
		request.getSession().setAttribute("contentDetailsDtoList", contentDetailsDtoList);
		
		return flag;
	}
	

	//home page
	public String homepage() throws Exception
	{
		String flag = CommonConstants.ERROR_FLAG;
		if(request.getSession().getAttribute("adminDetailDto") != null) {
			flag = CommonConstants.SUCCESS_FLAG;
		}
		return flag;
	}
	
	public String showOnlineExamTest() throws Exception {
		
		String flag = CommonConstants.SUCCESS_FLAG;
		
		String examKey = (String) request.getSession().getAttribute("exam_key");
		if(!examKey.equals("syso_my_exam")) {
			request.getSession().setAttribute("exam_key", "close_page");
		} else {
		
			Map<String, ArrayList<ExamQuestionDetailsDto>> questionDetailsMap = (Map<String, ArrayList<ExamQuestionDetailsDto>>) request.getSession().getAttribute("studentExamDetails");
			CreateQuestionPaper.createQuestionPaper(questionDetailsMap, request);
			
			adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
			request.getSession().setAttribute("adminDetailDto", adminDetailDto);
			
			ExamDetailsDto examDetailsDto = new ExamDetailsDto();
			examDetailsDto = (ExamDetailsDto) request.getSession().getAttribute("examDetailsDto");	
			request.getSession().setAttribute("examDetailsDto", examDetailsDto);
			
			StudentDetailsDto studentDetailsDto = new StudentDetailsDto();
			studentDetailsDto = this.getStudentDetailsServices().findStudentDetailsById(adminDetailDto.getInum_student_employee_id());
			
			List<StudentExamDetailsDto> studentExamDetailsDtoList = new ArrayList<StudentExamDetailsDto>();
			StudentExamDetailsDto studentExamDetailsDto = new StudentExamDetailsDto();
			
			studentExamDetailsDtoList = this.getExaminationDetailsServices().getStudentExamDetailsDtoListByStudentId(examDetailsDto.getOnum_id(), studentDetailsDto.getInum_student_id());
			if(studentExamDetailsDtoList != null && studentExamDetailsDtoList.size()>0) {
				studentExamDetailsDto = studentExamDetailsDtoList.get(0);
				
				Integer no_of_time_attempt = studentExamDetailsDto.getOnum_no_of_time_attempt();
				
				no_of_time_attempt = no_of_time_attempt+1;			
				studentExamDetailsDto.setOnum_no_of_time_attempt(no_of_time_attempt);
				
				if(no_of_time_attempt>=2) {
					studentExamDetailsDto.setOnum_exam_status(com.oes.action.common.Enums.ExamStatus.REQUESTFOREXAM.ordinal());	
				}
				
				this.getExaminationDetailsServices().saveandupdateStudentExamDetailsDto(studentExamDetailsDto);
				
			} else {
				studentExamDetailsDto = new StudentExamDetailsDto();
				
				studentExamDetailsDto.setExamDetailsDto(examDetailsDto);
				studentExamDetailsDto.setStudentDetailsDto(studentDetailsDto);
				studentExamDetailsDto.setOdt_entry_date(new Date());
				studentExamDetailsDto.setOnum_exam_status(com.oes.action.common.Enums.ExamStatus.APPROVED.ordinal());
				studentExamDetailsDto.setOnum_is_active(1);
				studentExamDetailsDto.setOnum_no_of_time_attempt(1);
				this.getExaminationDetailsServices().saveandupdateStudentExamDetailsDto(studentExamDetailsDto);
				
			}
			request.getSession().setAttribute("exam_key","key_expire");
		}		
		return flag;
	}
	
	public String descriptionPage() throws Exception {
	
		String flag = CommonConstants.SUCCESS_FLAG;
		Map<String, ArrayList<ExamQuestionDetailsDto>> questionDetailsMap = (Map<String, ArrayList<ExamQuestionDetailsDto>>) request.getSession().getAttribute("studentExamDetails");
		
		CreateQuestionPaper.createQuestionPaper(questionDetailsMap, request);
		
		adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
		request.getSession().setAttribute("adminDetailDto", adminDetailDto);
		
		request.getSession().setAttribute("exam_key", "syso_my_exam");
		
		if(adminDetailDto.getInum_account_status().equals(1)) {
			
			ExamDetailsDto examDetailsDto = new ExamDetailsDto();
			examDetailsDto = (ExamDetailsDto) request.getSession().getAttribute("examDetailsDto");	
			request.getSession().setAttribute("examDetailsDto", examDetailsDto);
			
			List<ExamSectionDetailsDto> examSectionDetailsDtoList = new ArrayList<ExamSectionDetailsDto>();
			examSectionDetailsDtoList = this.getExaminationDetailsServices().findExamSectionDetailsByExamId(examDetailsDto.getOnum_id());
			request.getSession().setAttribute("examSectionDetailsDtoList", examSectionDetailsDtoList);
			
			try {
				List<StudentExamDetailsDto> studentExamDetailsDtoList = new ArrayList<StudentExamDetailsDto>();
				studentExamDetailsDtoList = this.getExaminationDetailsServices().getStudentExamDetailsDtoListByStudentId(examDetailsDto.getOnum_id(), adminDetailDto.getInum_student_employee_id());
				
				int i = 0;
				if(studentExamDetailsDtoList != null && studentExamDetailsDtoList.size()>0) {
					StudentExamDetailsDto studentExamDetailsDto = new StudentExamDetailsDto();
					studentExamDetailsDto = studentExamDetailsDtoList.get(0);
					
					
					if(studentExamDetailsDto.getOnum_exam_status().equals(com.oes.action.common.Enums.ExamStatus.PENDING.ordinal())) {
						info = "You are not eligible to take this exam. Your Request is on pending state please contact administrator.";
						//examDetailsDtoList = this.getExaminationDetailsServices().getActiveExamDetailsDtoList(adminDetailDto);
						i = 1;
						flag = CommonConstants.ERROR_FLAG;
					} else if(studentExamDetailsDto.getOnum_exam_status().equals(com.oes.action.common.Enums.ExamStatus.REQUESTFOREXAM.ordinal())) {
						info = "You are not eligible to take this exam. Please Request for this exam.";
						//examDetailsDtoList = this.getExaminationDetailsServices().getActiveExamDetailsDtoList(adminDetailDto);
						i = 1;
						flag = CommonConstants.ERROR_FLAG;
					} else if(studentExamDetailsDto.getOnum_exam_status().equals(com.oes.action.common.Enums.ExamStatus.REJECT.ordinal())) {
						info = "You are not eligible to take this exam. Your Request has been rejected please request once again.";
						//examDetailsDtoList = this.getExaminationDetailsServices().getActiveExamDetailsDtoList(adminDetailDto);
						i = 1;
						flag = CommonConstants.ERROR_FLAG;
					}
				}
				
				if(i == 0) {
					Map<Integer, ExamSubCategoryDetailsDto> subCategoryMap = new HashMap<Integer, ExamSubCategoryDetailsDto> ();
					for(ExamSectionDetailsDto exDto : examSectionDetailsDtoList) {
						if(subCategoryMap.containsKey(exDto.getSectionDetailsDto().getSubCategoryDetailsDto().getOnum_slno())) {
							
							ExamSubCategoryDetailsDto examSubCategoryDetailsDto = new ExamSubCategoryDetailsDto();
							examSubCategoryDetailsDto = subCategoryMap.get(exDto.getSectionDetailsDto().getSubCategoryDetailsDto().getOnum_slno());
							
							Integer totalMark = exDto.getOnum_total_marks()+examSubCategoryDetailsDto.getOnum_total_marks();
							examSubCategoryDetailsDto.setOnum_total_marks(totalMark);
							
							Integer totalQuestion = exDto.getOnum_total_question()+examSubCategoryDetailsDto.getOnum_total_question();
							examSubCategoryDetailsDto.setOnum_total_question(totalQuestion);
							
							subCategoryMap.put(exDto.getSectionDetailsDto().getSubCategoryDetailsDto().getOnum_slno(), examSubCategoryDetailsDto);
							
						} else {
							
							ExamSubCategoryDetailsDto examSubCategoryDetailsDto = new ExamSubCategoryDetailsDto();
							
							examSubCategoryDetailsDto.setOnum_id(exDto.getSectionDetailsDto().getSubCategoryDetailsDto().getOnum_slno());
							examSubCategoryDetailsDto.setSubCategoryDetailsDto(exDto.getSectionDetailsDto().getSubCategoryDetailsDto());
							examSubCategoryDetailsDto.setOnum_total_marks(exDto.getOnum_total_marks());
							examSubCategoryDetailsDto.setOnum_total_question(exDto.getOnum_total_question());
							
							subCategoryMap.put(exDto.getSectionDetailsDto().getSubCategoryDetailsDto().getOnum_slno(), examSubCategoryDetailsDto);
						    // subCategoryMap.
						}				
					}
					request.getSession().setAttribute("subCategoryMap", subCategoryMap);
				}
				
				
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		} else if(adminDetailDto.getInum_account_status().equals(2)) {
			ExamDetailsDto examDetailsDto = new ExamDetailsDto();
			examDetailsDtoList = this.getExaminationDetailsServices().getActiveExamDetailsDtoList(adminDetailDto);
			
			if(examDetailsDtoList != null && examDetailsDtoList.size()>0) {
				
				examDetailsDto = examDetailsDtoList.get(0);
				request.getSession().setAttribute("examDetailsDto", examDetailsDto);
				
				List<ExamSectionDetailsDto> examSectionDetailsDtoList = new ArrayList<ExamSectionDetailsDto>();
				examSectionDetailsDtoList = this.getExaminationDetailsServices().findExamSectionDetailsByExamId(examDetailsDto.getOnum_id());
				request.getSession().setAttribute("examSectionDetailsDtoList", examSectionDetailsDtoList);
				
				List<ExamQuestionDetailsDto> examQuestionDetailsDtoList = new ArrayList<ExamQuestionDetailsDto>();
				examQuestionDetailsDtoList = this.getExaminationDetailsServices().getExamQuestionDetailsDtoListByExamId(examDetailsDto.getOnum_id());
				
				Map<String, List<ExamQuestionDetailsDto>> questionDetailsDtoMap = new HashMap<String, List<ExamQuestionDetailsDto>>();
				if(examQuestionDetailsDtoList != null && examQuestionDetailsDtoList.size()>0) {
					for(ExamQuestionDetailsDto dto : examQuestionDetailsDtoList) {
						
						if(questionDetailsDtoMap.containsKey(dto.getSectionDetailsDto().getOstr_section_name())) {
							
							List<ExamQuestionDetailsDto> list = new ArrayList<ExamQuestionDetailsDto>();
							list = questionDetailsDtoMap.get(dto.getSectionDetailsDto().getOstr_section_name());
							list.add(dto);
							questionDetailsDtoMap.put(dto.getSectionDetailsDto().getOstr_section_name(), list);
						
						} else {
							List<ExamQuestionDetailsDto> list = new ArrayList<ExamQuestionDetailsDto>();
							list.add(dto);
							questionDetailsDtoMap.put(dto.getSectionDetailsDto().getOstr_section_name(), list);							
						}						
					}					
					request.getSession().setAttribute("studentExamDetails", questionDetailsDtoMap);
					request.getSession().setAttribute("examDetailsDto", examDetailsDto);
					
				} else {
					info = "Sorry.. We didn't find any Examination. Please contact management.";
					flag = CommonConstants.ERROR_FLAG;
				}				
			} else {
				info = "Sorry.. We didn't find any Examination. Please contact management.";
				flag = CommonConstants.ERROR_FLAG;
			}
		} else {
			info = "Sorry.. We didn't find any Examination. Please contact management.";
			flag = CommonConstants.ERROR_FLAG;
		}
		return flag;
	
	}
	
	public String descriptionPage2() throws Exception {
		
		String flag = CommonConstants.SUCCESS_FLAG;
		
		return flag;
	
	}
	
	// Method To Show Login Page
	public String loginPage() throws Exception{
		
		String flag = CommonConstants.ERROR_FLAG;
		
		try {
		
			LogerFileCommon.setLogMessage("Login Page Action........");			
			String randomString = this.randomGeneratedString();	
			LogerFileCommon.setLogMessage("Random Generated String is :" + randomString);
	
			this.setRandomString(randomString);
	
			request.getSession().setAttribute("randomString", randomString);
			
			List<ContentDetailsDto> contentDetailsDtoList = new ArrayList<ContentDetailsDto>();
			contentDetailsDtoList = this.getMasterDetailsServices().getContentDetailsDtoList();
			request.getSession().setAttribute("contentDetailsDtoList", contentDetailsDtoList);
			
			//newsAndEventsDtoList = new ArrayList<NewsAndEventsDto>();
			//newsAndEventsDtoList = this.getNewsAndEventsServices().getNewsAndEventsDto(newsAndEventsDto);
			//request.getSession().setAttribute("newsAndEventsDtoList", newsAndEventsDtoList);
			
			//LogerFileCommon.setLogMessage(""+newsAndEventsDtoList.size());
			
		} catch(Exception er) {
			System.out.println(er);
			LogerFileCommon.setLogMessage(er.toString());
		}		
		
		flag = CommonConstants.SUCCESS_FLAG;		
		return flag;
	} 
	
	public String showNotification() throws Exception
	{
		String flag = CommonConstants.ERROR_FLAG;		
		try {
			if(request.getSession().getAttribute("adminDetailDto") != null) {
				flag = CommonConstants.SUCCESS_FLAG;
			}	
			adminDetailDto = new AdminDetailDto();
			adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
			
			List<NotificationDetailsDto> notificationDetailsDtoList = new ArrayList<NotificationDetailsDto>();
			if(adminDetailDto.getInum_role_id().equals(1)) {            // For Superadmin
				notificationDetailsDtoList = this.getMasterDetailsServices().getNotificationDetailsDtoList(1);
			} else if(adminDetailDto.getInum_role_id().equals(4)) {     // For Employee
				notificationDetailsDtoList = this.getMasterDetailsServices().getNotificationDetailsDtoList(2);		
			} else if(adminDetailDto.getInum_role_id().equals(2)) {     // For Student
				StudentDetailsDto studentDetailsDto = new StudentDetailsDto();
				studentDetailsDto = this.getStudentDetailsServices().findStudentDetailsById(adminDetailDto.getInum_student_employee_id());
				notificationDetailsDtoList = this.getMasterDetailsServices().getNotificationDetailsStudentDtoList(adminDetailDto.getInum_user_id(), studentDetailsDto.getAdminDetailDto().getInum_user_id());
			}	
			request.getSession().setAttribute("notificationDetailsDtoList", notificationDetailsDtoList);
		    this.populateMenu();		    
		} catch(Exception er){
			er.printStackTrace();
		}
		flag = CommonConstants.SUCCESS_FLAG;
		return flag;		
	}
	
	public String getAllExamDetails() throws Exception
	{
		String flag = CommonConstants.ERROR_FLAG;		
		try {
			if(request.getSession().getAttribute("adminDetailDto") != null) {
				flag = CommonConstants.SUCCESS_FLAG;
			}	
			adminDetailDto = new AdminDetailDto();
			adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
			
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

			     dashBoardDtoList = this.getMasterDetailsServices().getDashBoardDtoList();
			     request.getSession().setAttribute("dashBoardDtoList", dashBoardDtoList);
				 
			    
		     }
		     this.populateMenu();
		     flag = CommonConstants.SUCCESS_FLAG;
		} catch(Exception er){
			er.printStackTrace();
		}
		return flag;		
	}
	
	// Method to authenticate user action
	public String userAuthentication() throws Exception 
	{
		
		String flag = CommonConstants.ERROR_FLAG;		
		try {			
			String login_id = this.getLoginId();			
			login_id = login_id.replaceAll("\\s", "");
			
			String pstr_password = this.getPassword();
			
			request.getSession().setAttribute("resultDetailsDto", null);
			request.getSession().setAttribute("subjectMapDetails", null);
			request.getSession().setAttribute("studentDetailsDto", null);
			
			adminDetailDtoList = this.getAdminManagementServices().getAdminDetailDto(login_id);
			if(adminDetailDtoList!=null && adminDetailDtoList.size()>0) {
				for(AdminDetailDto adminDetailDto : adminDetailDtoList) {
				
					   String pstr_login_id = adminDetailDto.getIstr_login_id();
					   if(login_id.equalsIgnoreCase(pstr_login_id)){
						
						String password = adminDetailDto.getIstr_password();
						String random_string = (String) request.getSession().getAttribute("randomString");
						
						password = password + random_string;
						System.out.println(password);
						System.out.println(pstr_password);
						// Md5 Algo convert password into Hash code
						password = this.Md5value(password);
						// Check Password is equal or not
						if(pstr_password.equalsIgnoreCase(password)){
							 session = request.getSession();
							 
							 request.getSession().setAttribute("adminDetailDto", adminDetailDto);
							 request.getSession().setAttribute("username", adminDetailDto.getIstr_user_name());
							 this.setRandomStingJsp(CommonMethod.generateStringValidation(request));
							 
						     String user_name =	adminDetailDto.getIstr_user_name();
						     request.getSession().setAttribute("userName", user_name);
						     Integer role_id = adminDetailDto.getInum_role_id();
						     rolePermissionDtoList =  this.getRolePermissionManagementServices().findPermissionByRole(role_id);
						     if(rolePermissionDtoList!=null && rolePermissionDtoList.size()>0){
						    	  request.getSession().setAttribute("rolePermissionDtoList", rolePermissionDtoList);
						     }
						     if(adminDetailDto.getInum_role_id().equals(2)) {
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
	
									 dashBoardDtoList = this.getMasterDetailsServices().getDashBoardDtoList();
								     request.getSession().setAttribute("dashBoardDtoList", dashBoardDtoList);						    
							     }
							     
							     List<MappedExamDetailsDto> list = new ArrayList<MappedExamDetailsDto>();
							     list = this.getExaminationDetailsServices().getMappedExamDetailsDtoListByStudentId(adminDetailDto.getInum_user_id());
							     if(list != null && list.size()>0) {
							    	 request.getSession().setAttribute("register_button_status", "1");
							     } else {
							    	 request.getSession().setAttribute("register_button_status", "0");
							     }
							     
							     if(adminDetailDto.getInum_student_employee_id() != null) {
							    	 studentDetailsDto = new StudentDetailsDto();
							    	 studentDetailsDto = this.getStudentDetailsServices().findStudentDetailsById(adminDetailDto.getInum_student_employee_id());
							    	 request.getSession().setAttribute("studentDetailsDto", studentDetailsDto);
							    	 this.homePageResultSearchDetails();
							     }
						     }
						     
						     
						     request.getSession().setAttribute("adminDetailDto", adminDetailDto);
						     this.populateMenu();
						     if(adminDetailDto.getInum_account_status().equals(2)){
						         if(adminDetailDto.getInum_is_verified().equals(1)){
						        	 this.user_id = adminDetailDto.istr_login_id;
						        	 flag = CommonConstants.CHANGE_PASSWORD;
						    	 } else if(adminDetailDto.getInum_is_verified().equals(0)){
						    		 flag = CommonConstants.ERROR_FLAG;
						    	 } else if(adminDetailDto.getInum_is_verified().equals(2)){
						    		 flag = CommonConstants.SUCCESS_FLAG;	
						    	 }
					   } else {
							   
						   System.out.println("..................................");
						   flag = CommonConstants.SUCCESS_FLAG;				
					   }
							
				} else{
							
					System.out.println("Password does not match....");
					messages = "Invalid Username or password";
					flag = CommonConstants.ERROR_FLAG;
				}
			} else {
				messages = "User does not exist";
				flag = CommonConstants.ERROR_FLAG;
			}
		  }
		} else {
			
			adminDetailDtoList = this.getAdminManagementServices().checkAvailabilityByEmailId(login_id);
			if(adminDetailDtoList!=null && adminDetailDtoList.size()>0) {
				for(AdminDetailDto adminDetailDto : adminDetailDtoList) {
					
					   String pstr_login_id = adminDetailDto.getIstr_email();
					   if(login_id.equalsIgnoreCase(pstr_login_id)){
						
						String password = adminDetailDto.getIstr_password();
						String random_string = (String) request.getSession().getAttribute("randomString");
						
						password = password + random_string;
						System.out.println(password);
						System.out.println(pstr_password);
						// Md5 Algo convert password into Hash code
						password = this.Md5value(password);
						// Check Password is equal or not
						if(pstr_password.equalsIgnoreCase(password)){
							 session = request.getSession();
							 
							 request.getSession().setAttribute("adminDetailDto", adminDetailDto);
							 request.getSession().setAttribute("username", adminDetailDto.getIstr_user_name());
							 this.setRandomStingJsp(CommonMethod.generateStringValidation(request));
							 
						     String user_name =	adminDetailDto.getIstr_user_name();
						     request.getSession().setAttribute("userName", user_name);
						     Integer role_id = adminDetailDto.getInum_role_id();
						     rolePermissionDtoList =  this.getRolePermissionManagementServices().findPermissionByRole(role_id);
						     if(rolePermissionDtoList!=null && rolePermissionDtoList.size()>0){
						    	  request.getSession().setAttribute("rolePermissionDtoList", rolePermissionDtoList);
						     }
						     
						     if(adminDetailDto.getInum_role_id().equals(2)) {
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
	
								     dashBoardDtoList = this.getMasterDetailsServices().getDashBoardDtoList();
								     request.getSession().setAttribute("dashBoardDtoList", dashBoardDtoList);
								 }
							    
							     List<MappedExamDetailsDto> list = new ArrayList<MappedExamDetailsDto>();
							     list = this.getExaminationDetailsServices().getMappedExamDetailsDtoListByStudentId(adminDetailDto.getInum_user_id());
							     if(list != null && list.size()>0) {
							    	 request.getSession().setAttribute("register_button_status", "1");
							     } else {
							    	 request.getSession().setAttribute("register_button_status", "0");
							     }
							     if(adminDetailDto.getInum_student_employee_id() != null) {
							    	 studentDetailsDto = new StudentDetailsDto();
							    	 studentDetailsDto = this.getStudentDetailsServices().findStudentDetailsById(adminDetailDto.getInum_student_employee_id());
							    	 request.getSession().setAttribute("studentDetailsDto", studentDetailsDto);
							    	 this.homePageResultSearchDetails();
							     }
						     }
						     request.getSession().setAttribute("adminDetailDto", adminDetailDto);
						     this.populateMenu();
						     if(adminDetailDto.getInum_account_status().equals(2)){
						         if(adminDetailDto.getInum_is_verified().equals(1)){
						        	 this.user_id = adminDetailDto.istr_login_id;
						        	 flag = CommonConstants.CHANGE_PASSWORD;
						    	 } else if(adminDetailDto.getInum_is_verified().equals(0)){
						    		 flag = CommonConstants.ERROR_FLAG;
						    	 } else if(adminDetailDto.getInum_is_verified().equals(2)){
						    		 flag = CommonConstants.SUCCESS_FLAG;	
						    	 }
						     } else {
							   
						   		System.out.println("..................................");
						   		flag = CommonConstants.SUCCESS_FLAG;				
					   		}
							
						} else {
							
							System.out.println("Password does not match....");
							messages = "Invalid Username or password";
							flag = CommonConstants.ERROR_FLAG;
						}
					} else {
						messages = "User does not exist";
						flag = CommonConstants.ERROR_FLAG;
					}
				}
			} else {
				messages = "User does not exist";
				flag = CommonConstants.ERROR_FLAG;					
			}
		}
	} catch(Exception er){
		er.printStackTrace();
	}
	System.out.println("Messages ::"+messages);
	return flag;
	}
	
	// Method To check Login ID Availability Action
	public void checkUserAvailabilityByLoginId() throws Exception{
		
		System.out.println("Check User Availability By Login ID ......");
		
		StringBuffer sbPage = new StringBuffer();
		
		String login_id = request.getParameter("login_id");
		
		try {
		
		adminDetailDtoList = this.
		getAdminManagementServices().
		checkAvailabilityByLoginId(login_id);
		
		if(adminDetailDtoList != null && adminDetailDtoList.size()>0){
			
			sbPage.append("1");
			
		}
		else{
			
			sbPage.append("0");
			
		}
		
		response.setContentType("text/html");
		response.setHeader("Cache-Control", "no-cache");
		
			response.getWriter().write(sbPage.toString());
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	// Method To show User Registration form Action
	public String showUserRegistrationForm() throws Exception{
		
		System.out.println("Show User Registration Action");
		
		String flag = CommonConstants.ERROR_FLAG;
		
		try{
			
			this.populateMenu();
			roleMasterDto = new RoleMasterDto();
			adminDetailDto = new AdminDetailDto();
			roleMasterList = this.getRoleMasterServices().getRoleMasterDto(roleMasterDto);
			
			System.out.println("List Size : "+roleMasterList.size());
	 		flag = CommonConstants.SUCCESS_FLAG;
	 	
		}
		catch(Exception er){
			
			er.printStackTrace(); 
		}
		
		System.out.println("Flag ::: "+flag);
		
		return flag;
	}

	// Method to Save User Registration Details Action
	public String saveUserRegistrationDetail() throws Exception{
		
		System.out.println("User Registration.......");
		
		String flag = CommonConstants.ERROR_FLAG;
		
		try {		
			String regEx = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z0-9-]{2,4}\\b";
			 
			Integer role_id = adminDetailDto.getInum_role_id();
			
			System.out.println("User Role ID : "+role_id);
			
            String login_id = adminDetailDto.getIstr_login_id();
			
			System.out.println("Login ID : "+login_id);
			
			String user_password = adminDetailDto.getIstr_password();
			
			System.out.println("User Password : "+user_password);
			
			String secrete_question = adminDetailDto.getIstr_secrete_question();
			
			System.out.println("Secrete Question : "+secrete_question);
			
			String answer = adminDetailDto.getIstr_answer();
			
			System.out.println("Answer : "+answer);
			
            String user_name = adminDetailDto.getIstr_user_name();
			
		 	System.out.println("User Name : "+user_name);
			
		 	String user_email = adminDetailDto.getIstr_email();
			
		 	System.out.println("User Email : "+user_email);
		 	
		 	String user_designation = adminDetailDto.getIstr_designation();
		 	
		 	System.out.println("User Designation : "+user_designation);
		 	
		 	String user_address = adminDetailDto.getIstr_address();
		 	
		 	System.out.println("User Address : "+user_address);
		 	
		 	String user_mobile = adminDetailDto.getIstr_mobile_no();
		 	
		 	System.out.println("User Mobile : "+user_mobile);
		 	
		 	Pattern p = Pattern.compile(regEx);
			
		 	if(role_id == 0) {

		 		this.showUserRegistrationForm();
		 		
		 		messages = "Please select User Type ";
		 		
		 		flag = CommonConstants.ERROR_FLAG;
		 	} 
		 	else if(login_id.equals(""))
		 	{

		 		this.showUserRegistrationForm();
		 		
		 		messages = "Please enter Login Id ";
		 		
		 		flag = CommonConstants.ERROR_FLAG; 
		 	}  
		 	else if(user_password.equals(""))
		 	{

		 		this.showUserRegistrationForm();
		 		
		 		messages = "Please enter Password ";
		 		
		 		flag = CommonConstants.ERROR_FLAG;
		 	} 
		 	
		 	else if(secrete_question.equals(""))
		 	{

		 		this.showUserRegistrationForm();
		 		
		 		messages = "Please select Security Question ";
		 		
		 		flag = CommonConstants.ERROR_FLAG;
		 	} 
		 	
		 	else if(secrete_question.equals(""))
		 	{

		 		this.showUserRegistrationForm();  
		 		
		 		messages = "Please select Security Question ";
		 		
		 		flag = CommonConstants.ERROR_FLAG;
		 	} 
		 	else if(answer.equals(""))
		 	{

		 		this.showUserRegistrationForm(); 
		 		
		 		messages = "Please enter Answer ";
		 		
		 		flag = CommonConstants.ERROR_FLAG;
		 	} 
		 	
		 	else if(user_name.equals(""))
		 	{

		 		this.showUserRegistrationForm(); 
		 		
		 		messages = "Please enter Name ";
		 		
		 		flag = CommonConstants.ERROR_FLAG;
		 	} 
		 	
		 	else if(user_email.equals("")) 
		 	{

		 		this.showUserRegistrationForm(); 
		 		
		 		messages = "Please enter Email ";
		 		
		 		flag = CommonConstants.ERROR_FLAG;
		 	} 
		 	
		 	else if(user_designation.equals(""))
		 	{

		 		this.showUserRegistrationForm(); 
		 		
		 		messages = "Please enter Designation ";
		 		
		 		flag = CommonConstants.ERROR_FLAG;
		 	} 
		 	
		 	else if(user_mobile.equals(""))
		 	{

		 		this.showUserRegistrationForm(); 
		 		
		 		messages = "Please enter Mobile ";
		 		
		 		flag = CommonConstants.ERROR_FLAG;
		 	
		 	} else {
		 		
		 		   // check user availability by login id 
		 		   adminDetailDtoList = this.
		 		   getAdminManagementServices().checkAvailabilityByLoginId(adminDetailDto.getIstr_login_id());
		 		   System.out.println("Admin List Size : "+adminDetailDtoList.size());
		 		   if(adminDetailDtoList!=null && adminDetailDtoList.size()>0){
		 		    	
		 			 	roleMasterList = this.getRoleMasterServices().getRoleMasterDto(roleMasterDto);
		 			 	adminDetailDto.setIstr_answer("");
		 		    	messages = "Login ID is not available";
		 		        
		 		    	flag = CommonConstants.ERROR_FLAG;
		 		    	
		 		    } else {
		 		    	
		 		    	Matcher m = p.matcher(adminDetailDto.getIstr_email());
		 				if(!adminDetailDto.getIstr_email().matches(EMAIL_PATTERN)){
		 		    		
		 		    		System.out.println("Email Address is not valid.......");
		 		    	    roleMasterList = this.getRoleMasterServices().getRoleMasterDto(roleMasterDto);
		 		   			messages = "Please Enter Valid Email Id";
		 		   			adminDetailDto.setIstr_answer("");
					 		flag = CommonConstants.SUCCESS_FLAG;
		 		    		
		 				} else {

		 					adminDetailDto.setInum_account_status(Enums.UserFlagStatus.ADMIN.ordinal());
		 		    		adminDetailDto.setInum_is_active(Enums.MasterStatus.ACTIVE.ordinal());
					 		adminDetailDto.setIdt_entry_date(new Date());
					 		
					 		// Save admin detail dto 
					 		this.getAdminManagementServices().saveOrUpdatUserDetailDto(adminDetailDto);
					 			
					 		
					 	    // initialize admin dto
					 		// get admin dto (Login User Dto)
					 		AdminDetailDto adminDto = new AdminDetailDto();
					 		adminDto = (AdminDetailDto)request.getSession().getAttribute("adminDetailDto");
					 		
					 		
					 		//initialize Role Master Dto
					 		roleMasterDto = new RoleMasterDto();
					 		roleMasterDto = this.getRoleMasterServices().findRoleMasterById(role_id);

					 		// initialize user role master dto
					 		userRoleMasterDto = new UserRoleMasterDto();
					 		userRoleMasterDto.setRoleMasterDto(roleMasterDto);
					 		userRoleMasterDto.setAdminDetailDto(adminDetailDto);
					 		userRoleMasterDto.setAdminDto(adminDto);
					 		userRoleMasterDto.setPnum_is_active(Enums.MasterStatus.ACTIVE.ordinal());
					 		userRoleMasterDto.setPdt_entry_date(new Date());
					 	
					 		
					 		// save User Role Master dto
					 		this.getAdminManagementServices().saveUserRoleMasterDto(userRoleMasterDto);
					 		
					 		
					 		
					 		this.showUserRegistrationForm();
					 		
					 		messages = "User Registration registered successfully";
					 		
					 		flag = CommonConstants.SUCCESS_FLAG;
		 		    		
		 		    		
		 		    	}
		 		 }
		 		    
		 	}
		 	
		} catch(Exception er) {
			er.printStackTrace();
		}
		this.showUserRegistrationForm();
		request.getSession().setAttribute("permissionDtoSideMenuList", null);		
		System.out.println("Flag : : : : "+flag);
		
		return flag;
	}
	
	// show change password and secret question form
	public String changePasswordNSecretQusForm() throws Exception{
		
		System.out.println("Change Password and Secret Question");
		
		String flag = CommonConstants.ERROR_FLAG;
		
		try{
		
			System.out.println("Test.............");
			
			this.populateMenu();
			
			flag = CommonConstants.SUCCESS_FLAG;
			
		}
		catch(Exception er){
			er.printStackTrace();
		}
		
		
		return flag;
	}
	
	// To Change Password/ Secret Question 
	public String savechangePasswordOrSecretQuestion() throws Exception
		{
			System.out.println("Hello");
			String password=null;
			String hash_password = null;
			String old_password = null;
			String hash_sec_question = null;
			String hash_answer = null;
			String old_sec_question = null;
			String password_checkBox="";
			String secret_checkBox="";
			
			//adminDetailDto = new AdminDetailDto();
			
			String flag = CommonConstants.FAILURE_ERROR;
			try {
				
			    Pattern p = Pattern.compile("^[a-z0-9@._,&:-]", Pattern.CASE_INSENSITIVE);
			
				
		
				if(request.getParameter("checkbox1")!=null && !"".equals(request.getParameter("checkbox1")))
				{
					password_checkBox = request.getParameter("checkbox1");
					System.out.println("CheckBox For Password : "+password_checkBox);
				}
		
				
				if(request.getParameter("checkbox2")!=null && !"".equals(request.getParameter("checkbox2")))
				{
					secret_checkBox = request.getParameter("checkbox2");
					System.out.println("CheckBox For Secret Question : "+secret_checkBox);
				}
				
				
				adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
				
				System.out.println("Admin Name : "+adminDetailDto.getIstr_user_name());
				
				System.out.println("password : "+adminDetailDto.getIstr_password());
				
				
				// if password check box is selected
				if(password_checkBox.equals("on")){
								
					 // if password is not null or empty
					if(request.getParameter("pstr_Pass")!=null && request.getParameter("pstr_Pass")!=""){
					
						String confirm_passwrod = request.getParameter("confirm_Password");
						  
						System.out.println("Confirm password :::"+confirm_passwrod);
						
						String istr_passwrod = request.getParameter("pstr_Pass");
						  
						System.out.println("Password ::: "+istr_passwrod);
						
					//if password and confirm password both are equal	
					if(istr_passwrod.equals(confirm_passwrod)){
						
					  
					  System.out.println("Get Password : "+istr_passwrod);
					  
					  String encrypt_password = this.Md5value(istr_passwrod);
					  
					  System.out.println("Encrypted Password : "+encrypt_password);
						
					  
					  String old_hash_password = adminDetailDto.getIstr_password();
					  
					  
					  if(old_hash_password.equals(encrypt_password)){
						  
						  messages = "Please select different Password ";
						  
						  flag = CommonConstants.ERROR_FLAG;
						  
						  return flag;
						  
					  }
					  else{
						  
						  
						  // set password in admin detail dto
						  adminDetailDto.setIstr_password(encrypt_password);
						 	
						  
					  }
						
					}
					else // if password and confirm password both are not equal
					{
						
						messages = "Password does not match";
						
						flag = CommonConstants.ERROR_FLAG;
						
						return flag;
					}
						
						
					}
					else // if password is empty
					{
						
						messages = "Please enter Password";
						
						System.out.println(messages);
						
						flag = CommonConstants.ERROR_FLAG;
						
						
					}
				}
				
				
				
				 // if secret check box is selected
				if(secret_checkBox.equals("on")){
					
					
					String secret_question = request.getParameter("pstr_secrete_question");
					
					String secret_answer = request.getParameter("pstr_Answer");
					
				
					// if secret question or secret answer is empty
					if(secret_question.equals("0") || secret_answer.equals("")){
						
						messages = "Please select Security Question";
						
						System.out.println(messages);
						
						flag = CommonConstants.ERROR_FLAG;
						
					}
					else // if secret question or secret answer is not empty
					{
						 // Set secret question and answer in admin detail dto
					
						
						  adminDetailDto.setIstr_secrete_question(this.Md5value(secret_question));
						  adminDetailDto.setIstr_answer(this.Md5value(secret_answer));
					
		
						  
					}
					
					
				}
				
			  // if both check boxes are not selected.
				if(!password_checkBox.equals("on") && !secret_checkBox.equals("on")){
					
					
					messages = "Please select any check box";
					
					System.out.println("Message : "+messages);
					
					flag = CommonConstants.ERROR_FLAG;
					
				}
				else{
					
					System.out.println("if any check box is selected");
					
					this.getAdminManagementServices().saveOrUpdatUserDetailDto(adminDetailDto);
					
					request.getSession().setAttribute("adminDetailDto", adminDetailDto);
					
					messages = "Details have been submitted successfully.";
					
					flag = CommonConstants.SUCCESS_FLAG;
					
				}
				


			}
				catch (Exception e) {
				//flag = CommonConstants.FAILURE_FLAG;
				e.printStackTrace();

			}
			
			
			return flag;
		}
	
	//To show personal profile update form
	public String showPersonalProfileUpdate() throws Exception{
		
		System.out.println("Show Personal Profile Update");
		
		String flag = CommonConstants.ERROR_FLAG;
		
		try{
			
			this.populateMenu();
			
			adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
			
			System.out.println("User Name : "+adminDetailDto.getIstr_user_name());
			
			Integer user_id = adminDetailDto.getInum_user_id();
			
			adminDetailDto = new AdminDetailDto();
			
			adminDetailDto = this.getAdminManagementServices().getAdminDetailDtoById(user_id);
			
			System.out.println("admin Name "+adminDetailDto.getIstr_user_name());
			
			if(adminDetailDto!=null){
			
				
				
				flag = CommonConstants.SUCCESS_FLAG;
				
			}
			
		}
		catch(Exception er){
			er.printStackTrace();
		}
		
		
		System.out.println("Flag : "+flag);
		return flag;
	}
		
	// TO update user profile details
	public String updateUserDetails() throws Exception{
		
		System.out.println("Update User Details");
		
		String flag = CommonConstants.ERROR_FLAG;
		
		try{
			
			Integer user_id = adminDetailDto.getInum_user_id();
			
			System.out.println("Used ID : "+user_id);
			
	 		String user_name = adminDetailDto.getIstr_user_name();
	 		
	 		String user_mobile = adminDetailDto.getIstr_mobile_no();
			
	 		String user_email = adminDetailDto.getIstr_email();
			
	 		String user_designation = adminDetailDto.getIstr_designation();
			
	 		String user_address = adminDetailDto.getIstr_address();
	 		
	 		if(user_name.equals("") || user_mobile.equals("") || user_email.equals("") || user_designation.equals("") || user_address.equals("")){
	 			
	 			messages = "Please enter necessary details";
	 		
	 			System.out.println(messages);
	 			
	 			flag = CommonConstants.ERROR_FLAG;
	 			
	 		}
	 		else if(!user_email.matches(EMAIL_PATTERN))
	 		{
                messages = "Invalid Email Id";
	 			
                System.out.println(messages);
                
	 			flag = CommonConstants.ERROR_FLAG;
	 			
	 		}
	 		else if(!user_mobile.matches("\\d{10}"))
	 		{
                messages = "Please enter valid Mobile Number";
	 			
                System.out.println(messages);
                
	 			flag = CommonConstants.ERROR_FLAG;
	 			
	 		}
	 		else
	 		{
	 			
	 		
	 		// save or update current admin detail dto
				this.getAdminManagementServices().saveOrUpdatUserDetailDto(adminDetailDto);
				
				request.getSession().setAttribute("adminDetailDto", adminDetailDto);
				
				messages = "Your Profile has been updated successfully";
				
				flag = CommonConstants.SUCCESS_FLAG;
	 			
	 		}
	 		
	 		
			
		}
		catch(Exception er){
			er.printStackTrace();
		}
		
		System.out.println("Flag : "+flag);
		
		return flag;
	}
	
	// To show Forgot password page in fancy box
	public String showForgetPasswordForm() throws Exception{
		
		System.out.println("Show Forgot Password Form");
		
		String flag = CommonConstants.ERROR_FLAG;
		
		try{
			
			this.populateMenu();			
			flag = CommonConstants.SUCCESS_FLAG;
			
		}
		catch(Exception er){
			er.printStackTrace();
		}
		
		System.out.println(flag);
		
		return flag;
	}
	
	// To validate Secret question and answer information
	public void validationSecreteInfomation() throws Exception{
		
		StringBuffer responseBuffer = new StringBuffer();
		
		String login_id = request.getParameter("login_id");
		
		System.out.println("Login ID : "+login_id);
		
		String secret_question = request.getParameter("hash_secret_question");
		
		String answer = request.getParameter("hash_answer");
		
		    adminDetailDtoList = this.
		    		getAdminManagementServices().
		    		userAvailabilityBySecurityQus(login_id, secret_question, answer);
		   
		    if(adminDetailDtoList!=null && adminDetailDtoList.size()>0){
		    	
		      System.out.println("Entry Is Correct");
		    	
		    	responseBuffer.append("1");
		    	 
		    }
		    else{
		    	
		    	System.out.println("Wrong Details");
		    	
		    	responseBuffer.append("0");
		    	
		    }
		
		
		response.setContentType("text/html");
		response.setHeader("Cache-Control", "no-cache");
		try {

			response.getWriter().write(responseBuffer.toString());
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
	}

	
	public void changeOldPasswordAction() throws Exception{
		
		
		StringBuffer responseBuffer = new StringBuffer();
		
		try{
			
	    String login_id = request.getParameter("login_id");
			
		String password = request.getParameter("password");
		
		System.out.println("Login ID : "+login_id);
		
		System.out.println("Password : "+password);
		
		adminDetailDtoList = this.
		getAdminManagementServices().
		checkAvailabilityByLoginId(login_id);
		
		if(adminDetailDtoList!=null && adminDetailDtoList.size()>0){
			
			for(AdminDetailDto adminDetailDto : adminDetailDtoList){
				
			   adminDetailDto.setIstr_password(password);
			   
			   this.getAdminManagementServices().saveOrUpdatUserDetailDto(adminDetailDto);
			   
			   responseBuffer.append("1");
				
			}
			
		}
		
			
		}
		catch(Exception er){
			
			er.printStackTrace();
		}
		
		
		response.setContentType("text/html");
		response.setHeader("Cache-Control", "no-cache");
		try {

			response.getWriter().write(responseBuffer.toString());
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}
	
	// Log out Action
	public String logoutAction() throws Exception {
		
		String flag = CommonConstants.SUCCESS_FLAG;
		try{	 
			adminDetailDto = new AdminDetailDto();
			adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
			
			request.getSession().setAttribute("adminDetailDto", null);
			request.getSession().setAttribute("userName", null);
			request.getSession().setAttribute("username", null);
			request.getSession().setAttribute("resultDetailsDto", null);
			request.getSession().setAttribute("subjectMapDetails", null);
			request.getSession().setAttribute("studentDetailsDto", null);
			
			request.getSession().setAttribute("info", "");
	        this.setRandomStingJsp(null);
			request.getSession().setAttribute("rolePermissionDtoList", null);
			
			if(adminDetailDto.getInstituteDetailsDto() == null) {
				return flag;
			} else {
				response.sendRedirect(adminDetailDto.getInstituteDetailsDto().getOstr_website_url());
			}
			request = null;
			response = null;
		} catch(Exception er){
			er.printStackTrace();
			return flag;
		}
		return flag;
	}
	
	//Change Password By: Sumit Kumar Singh
	public String studentChangePassword() throws Exception {
		
		String flag = CommonConstants.ERROR_FLAG;
		String user_id = getUser_id();
		System.out.println("user id :"+user_id);
		
		try{	 
			 if(user_id == null || user_id.equals("")){
	    	
				flag = CommonConstants.HOME_PAGE;
				return flag;	    	
			 } 		
			 String old_password = getOld_password();
			 new_password = getNew_password();
			 String confirm_password = getConfirm_password();
			 
			 char[] newPasswordArray = new_password.toCharArray();
			 System.out.println("Size of array :"+newPasswordArray.length);
			 
			 if(old_password.equals("")){
	    
				 o_password = "Please enter Old Password";
				 flag = CommonConstants.FAILURE_ERROR;
			
			 } else if(new_password.equals("")){
	    
				 n_password = "Please enter New Password";
	    		 flag = CommonConstants.FAILURE_ERROR;
			
			 } else if(confirm_password.equals("")){
	    
				 c_password = "Please enter Confirm Password";
				 flag = CommonConstants.FAILURE_ERROR;
				 
			 } else if(!new_password.equalsIgnoreCase(confirm_password)){
				    
				n_password = "Old Password and New password does not match";
				flag = CommonConstants.FAILURE_ERROR;
						
			 } else {	
			 
				 adminDetailDtoList = this.getAdminManagementServices().getAdminDetailDto(user_id);
				 System.out.println("Size of List is "+adminDetailDtoList.size());		
				 if(adminDetailDtoList!=null && adminDetailDtoList.size()>0){
			
					 for(AdminDetailDto adminDetailDto : adminDetailDtoList){
			
						 String pstr_login_id = adminDetailDto.getIstr_login_id();
						 System.out.println("User Login Id is "+pstr_login_id);
						 if(user_id.equals(pstr_login_id)){
					   
							 String password = adminDetailDto.getIstr_password();
							 System.out.println("USer Password is "+password);
					
							 if(old_password.equalsIgnoreCase(password)){						
						   
								 adminDetailDto.setIstr_password(new_password);
								 adminDetailDto.setInum_is_verified(2);
						   
								 this.getAdminManagementServices().saveOrUpdatUserDetailDto(adminDetailDto);
								 adminDetailDto = null;
								 info = "Password change successfully";
								 flag = CommonConstants.SUCCESS_FLAG;						
						
							 } else {
						
								 o_password = "Invalid Password";
								 System.out.println("Password does not match....");						
								 flag = CommonConstants.ERROR_FLAG;
							 }					
						 } else {					
							 flag = CommonConstants.ERROR_FLAG;					
						 }			
					 }
				 }
			 }
		}	
		catch(Exception er){
			er.printStackTrace();
		}	
			return flag;
	}
	
	//Change Password By: Sumit Kumar Singh
	public String changePasswordDetails() throws Exception {
			
		String flag = CommonConstants.ERROR_FLAG;
		
		String status = request.getParameter("status");
		System.out.println("status is :"+status);			
		try{	 
		   if(status.equals("0")) {			   
			   messages = "Please Enter Username Or Email Id";
			   return flag;			   
		   } else if(status.equals("1")) {
			   
			   String username = request.getParameter("istr_login_id");
			   if(username.equals("")) {
				   messages = "Please Enter Username Or Email Id";
				   return flag;				   
			   } 
			   adminDetailDtoList = this.getAdminManagementServices().checkAvailabilityByLoginId(username);				
			   if(!(adminDetailDtoList != null && adminDetailDtoList.size()>0)){
				   messages = "Please Enter Valid Credentials";
				   return flag;				   				   
			   } else {
				   adminDetailDto = adminDetailDtoList.get(0);
				   //Logic to send password in mail
				   String password = this.randomGeneratedString();
						
				   adminDetailDto.setIstr_password(this.Md5value(password));
				   this.getAdminManagementServices().saveOrUpdatUserDetailDto(adminDetailDto);
				
				   String rndString = this.randomString();
				   rndString = rndString+""+adminDetailDto.getInum_user_id().toString()+""+rndString;
				   
				   ChangePasswordDto changePasswordDto = new ChangePasswordDto();
				   changePasswordDto.setAdminDetailDto(adminDetailDto);
				   changePasswordDto.setOnum_is_active(1);
				   changePasswordDto.setOstr_link(rndString);
				   
				   this.getMasterDetailsServices().updateChangePasswordDto(changePasswordDto);
				   changePasswordDto = null;
				   
				   messages = "Password reset request successfully sent to account email address";
				   try {
					   this.sendMailToRegisteredUser(adminDetailDto, rndString);
				   } catch (Exception e) {
					   e.printStackTrace();
				   }				   
			   }		   
		   } else if(status.equals("2")) {
			   
			   String email_id = request.getParameter("istr_email_id");
			   if(email_id.equals("")) {
				   messages = "Please Enter Username Or Email Id";
				   return flag;				   
			   } 
			   adminDetailDtoList = this.getAdminManagementServices().checkAvailabilityByEmailId(email_id);			
			   if(!(adminDetailDtoList != null && adminDetailDtoList.size()>0)){
				   messages = "Please Enter Valid Credentials";
				   return flag;				   				   
			   } else {
				   adminDetailDto = adminDetailDtoList.get(0);
				   //Logic to send password in mail
				   String password = this.randomGeneratedString();
						
				   adminDetailDto.setIstr_password(this.Md5value(password));
				   this.getAdminManagementServices().saveOrUpdatUserDetailDto(adminDetailDto);

				   String rndString = this.randomString();
				   rndString = rndString+""+adminDetailDto.getInum_user_id().toString()+""+rndString;
				   
				   ChangePasswordDto changePasswordDto = new ChangePasswordDto();
				   changePasswordDto.setAdminDetailDto(adminDetailDto);
				   changePasswordDto.setOnum_is_active(1);
				   changePasswordDto.setOstr_link(rndString);
				   
				   this.getMasterDetailsServices().updateChangePasswordDto(changePasswordDto);
				   changePasswordDto = null;
				   messages = "Password reset request successfully sent to account email address";
				   try {
					   this.sendMailToRegisteredUser(adminDetailDto, rndString);
				   } catch (Exception e) {
					   e.printStackTrace();
				   }			   
			   }		   
		   }
		} catch(Exception er){
			er.printStackTrace();
		}	
		return flag;
	}
	
	
	public String setNewPasswordDetails() throws Exception {
		String flag = CommonConstants.ERROR_FLAG;
		
		String key = request.getParameter("key");
		String unique_id = request.getParameter("unique_id");
		
		System.out.println("Key is :"+key);			
		System.out.println("Unigue Id :"+unique_id);		
		try{	
			List<ChangePasswordDto> changePasswordDtoList = new ArrayList<ChangePasswordDto>();
			changePasswordDtoList = this.getMasterDetailsServices().checkAvailChangePasswordDto(key);
			
			if(changePasswordDtoList != null && changePasswordDtoList.size()>0) {
				 ChangePasswordDto changePasswordDto = new ChangePasswordDto();
				 changePasswordDto = changePasswordDtoList.get(0);
				 
				 if(changePasswordDto.getAdminDetailDto().getIstr_login_id().equals(unique_id)) {
					request.getSession().setAttribute("changePwdAdminDetailDto", changePasswordDto.getAdminDetailDto()); 	
					flag = CommonConstants.SUCCESS_FLAG;	
				 } else {
					 messages = "Password reset token is no longer valid"; 
				 }	
			} else {
				 messages = "Password reset token is no longer valid";
			}			
		} catch(Exception er){
			er.printStackTrace();
		}	
		return flag;
	}
	
	
	public String setNewPasswordAuthentication() throws Exception {
		
		String flag = CommonConstants.ERROR_FLAG;
		AdminDetailDto adminDetailDto = new AdminDetailDto();
		adminDetailDto = (AdminDetailDto)request.getSession().getAttribute("changePwdAdminDetailDto");
		
		try{	 
			 if(adminDetailDto == null || adminDetailDto.getInum_user_id() == null){	    	
				flag = "failed";
				return flag;	    	
			 } 		
			 new_password = getNew_password();
			 confirm_password = getConfirm_password();
			 
			 char[] newPasswordArray = new_password.toCharArray();
			 System.out.println("Size of array :"+newPasswordArray.length);
			 
			 if(new_password.equals("")){
	    
				messages = "Please enter New Password";
	    		flag = CommonConstants.FAILURE_ERROR;
			
			 } else if(confirm_password.equals("")){
	    
				messages = "Please enter Confirm Password";
				flag = CommonConstants.FAILURE_ERROR;
				 
			 } else if(!new_password.equalsIgnoreCase(confirm_password)){
				    
				messages = "Old Password and New password does not match";
				flag = CommonConstants.FAILURE_ERROR;
						
			 } else {			 
				 adminDetailDto.setIstr_password(new_password);
				 adminDetailDto.setInum_is_verified(2);
						   
			     this.getAdminManagementServices().saveOrUpdatUserDetailDto(adminDetailDto);
				 
			     /*Delete entry from change password table*/
			     List<ChangePasswordDto> changePasswordDtoList = new ArrayList<ChangePasswordDto>();
				 changePasswordDtoList = this.getMasterDetailsServices().getChangePasswordDtoListByUserId(adminDetailDto.getInum_user_id());
					
				 if(changePasswordDtoList != null && changePasswordDtoList.size()>0) {
					for(ChangePasswordDto dto : changePasswordDtoList) {
						dto.setOnum_is_active(0);
						this.getMasterDetailsServices().updateChangePasswordDto(dto);
					}					 
				 }
			     
			     request.getSession().setAttribute("adminDetailDto", adminDetailDto);
				 request.getSession().setAttribute("username", adminDetailDto.getIstr_user_name());
				 this.setRandomStingJsp(CommonMethod.generateStringValidation(request));
				 
			     String user_name =	adminDetailDto.getIstr_user_name();
			     request.getSession().setAttribute("userName", user_name);
			     Integer role_id = adminDetailDto.getInum_role_id();
			     rolePermissionDtoList =  this.getRolePermissionManagementServices().findPermissionByRole(role_id);
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

				     dashBoardDtoList = this.getMasterDetailsServices().getDashBoardDtoList();
				     request.getSession().setAttribute("dashBoardDtoList", dashBoardDtoList);			    
			     }
			     
			     this.populateMenu();
			     if(adminDetailDto.getInum_account_status().equals(2)){
			         if(adminDetailDto.getInum_is_verified().equals(1)){
			        	 this.user_id = adminDetailDto.istr_login_id;
			        	 flag = CommonConstants.CHANGE_PASSWORD;
			    	 } else if(adminDetailDto.getInum_is_verified().equals(0)){
			    		 flag = CommonConstants.ERROR_FLAG;
			    	 } else if(adminDetailDto.getInum_is_verified().equals(2)){
			    		 flag = CommonConstants.SUCCESS_FLAG;	
			    	 }
			     } else {				   
			   		System.out.println("..................................");
			   		flag = CommonConstants.SUCCESS_FLAG;				
		   		}
			    flag = CommonConstants.SUCCESS_FLAG;				
			 }
			 request.getSession().setAttribute("changePwdAdminDetailDto", null);
		}	
		catch(Exception er){
			er.printStackTrace();
		}	
		return flag;
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
	
	public String randomString() {

		final int PASSWORD_LENGTH = 20;
		StringBuffer sb = new StringBuffer();
		for (int x = 0; x < PASSWORD_LENGTH; x++) {
			sb.append((char) ((int) (Math.random() * 26) + 97));
		}
		String a = sb.toString();
		return a.toUpperCase();
	}

	// Method Of MD5 algorithm...........
	public String Md5value(String pass) throws Exception, NoSuchAlgorithmException {
			
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
		
	//contactUsForm By: Sumit Kumar Singh
	public String contactUsForm() throws Exception {
				
			String flag = CommonConstants.ERROR_FLAG;
			try{	 
				String name = request.getParameter("your_name");
				String phone_no = request.getParameter("phone_no");
				String message = request.getParameter("message");
				String captchatext = request.getParameter("captchatext");
				
				String reqCaptcha = (String) request.getSession().getAttribute("captcha");
				if(reqCaptcha.equals(captchatext)) {
					this.sendMailToContactUs(name, phone_no, message);
					info = "Thank You. We got your request and we will try to fulfill your request as soon as possible.";
				} else {
					info = "Please enter valid text shown in below image";	
				}
				flag = CommonConstants.SUCCESS_FLAG; 
			} catch(Exception er){
				info = "Sorry.. Due to some technical problem we are unable to process your request.";
				er.printStackTrace();
			}	
			return flag;
	}
		
		
	public void sendMailToRegisteredUser(AdminDetailDto adminDetailDto, String rndString) {

			Calendar cal = Calendar.getInstance();
			String date = " Date:" + cal.getTime();
			String url = "www.xamdesk.com";

			String emailBody = "Hi "+adminDetailDto.getIstr_user_name()+"<br/><br/>Someone recently requested a password change for your Account Manager. If this was you, you can set a new password here."+
					   "<br/><br/><a href=\"https://www.xamdesk.com/set-account-password?key="+rndString+"&unique_id="+adminDetailDto.getIstr_login_id()+"\" style=\"color:#ffffff;font-size:15px;font-weight:bold;text-decoration:none\" target=\"_blank\">Reset Password</a>"+
					   "<br/><br/>If you don't want to change your password or didn't request this, just ignore and delete this message."+
					   "<br/><br/>If you have any enquiries, please do not hesitate to contact our support team who are available 24/7 to assist you. Call (+91) 9958903074.<br/><br/>Regards<br/>Xamdesk Team";

			 
			System.out.println("emailBody************************************"+ emailBody);
			SendMailTLS sendMailTLS = new SendMailTLS(adminDetailDto.getIstr_email(), "Account Manager - Password Reset", emailBody);
			sendMailTLS.sendEmail();
	}
		
	public void sendMailToContactUs(String name, String phone_no, String message) {

			Calendar cal = Calendar.getInstance();
			String url = "www.xamdesk.com";

			String emailBody = "New Contact Us Request <br/><br/>'"+ url +"' <br/><br/> Name: "+name+" \n <br/>Phone No:  "+phone_no+"\n \n <br/><br/>Message: "+message+" <br/><br/><br/>Thanks & Regards \n\n <br/>Xamdesk";
			
			System.out.println("emailBody************************************"+ emailBody);
			SendMailTLS sendMailTLS = new SendMailTLS("support@xamdesk.com", "Contact Us Mail", emailBody);
			sendMailTLS.sendEmail();
	}	
	
	public String homePageResultSearchDetails() throws POLLINGBusinessException
	{
		String flag = CommonConstants.FAILURE_ERROR;
		if(request.getSession().getAttribute("adminDetailDto") == null) {
			return "login";
		}
		List<ResultDetailsDto> resultDetailsDtoList = new ArrayList<ResultDetailsDto>();
		ResultDetailsDto resultDetailsDto = new ResultDetailsDto();		
		try {
			AdminDetailDto adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
			studentDetailsDto = this.getStudentDetailsServices().findStudentDetailsById(adminDetailDto.getInum_student_employee_id());
			resultDetailsDtoList = this.getExaminationDetailsServices().getResultDetailsDtoListByStudentId(studentDetailsDto.getInum_student_id());
			
			if(resultDetailsDtoList != null && resultDetailsDtoList.size()>0) {
				resultDetailsDto = resultDetailsDtoList.get(0);
					
				/*Logic to calculate result subject analysis*/
				List<ResultDescriptionDto> resultDescriptionDtoList = new ArrayList<ResultDescriptionDto>();
				resultDescriptionDtoList = this.getExaminationDetailsServices().getResultDescriptionDtoByResultDetailsId(resultDetailsDto.getOnum_result_details_id());
				Map<Integer, ResultReviewSubjectDto> subjectMapDetails = new HashMap<Integer, ResultReviewSubjectDto>();
				List<ResultReviewSubjectDto> reviewSubjectDtoList = new ArrayList<ResultReviewSubjectDto>();
					
				if(resultDescriptionDtoList != null && resultDescriptionDtoList.size()>0) {
					for(ResultDescriptionDto dto : resultDescriptionDtoList) {
						if(subjectMapDetails.containsKey(dto.getExamQuestionDetailsDto().getSectionDetailsDto().getSubCategoryDetailsDto().getOnum_slno())) {
							ResultReviewSubjectDto resultReviewSubjectDto = new ResultReviewSubjectDto();
							
							resultReviewSubjectDto = subjectMapDetails.get(dto.getExamQuestionDetailsDto().getSectionDetailsDto().getSubCategoryDetailsDto().getOnum_slno());
							if(dto.getOnum_selected_option() == null) {
								//Unattempted
								Integer total = resultReviewSubjectDto.getTotal_left(); 
								total = total+1;
								resultReviewSubjectDto.setTotal_left(total);
							} else if(dto.getOnum_selected_option().equals(dto.getOnum_correct_option())) {
								//correct
								Integer total = resultReviewSubjectDto.getTotal_right(); 
								total = total+1;
								resultReviewSubjectDto.setTotal_right(total);
							} else {							
								//wrong
								Integer total = resultReviewSubjectDto.getTotal_wrong(); 
								total = total+1;
								resultReviewSubjectDto.setTotal_wrong(total);
							}
							Integer total_question = resultReviewSubjectDto.getTotal_question();
							total_question = total_question+1;
							resultReviewSubjectDto.setTotal_question(total_question);
							subjectMapDetails.put(dto.getExamQuestionDetailsDto().getSectionDetailsDto().getSubCategoryDetailsDto().getOnum_slno(), resultReviewSubjectDto);
						} else {
							ResultReviewSubjectDto resultReviewSubjectDto = new ResultReviewSubjectDto();
							resultReviewSubjectDto.setSectionDetailsDto(dto.getExamQuestionDetailsDto().getSectionDetailsDto());
							if(dto.getOnum_selected_option() == null) {
								//Unattempted
								resultReviewSubjectDto.setTotal_left(1);
								resultReviewSubjectDto.setTotal_right(0);
								resultReviewSubjectDto.setTotal_wrong(0);
							} else if(dto.getOnum_selected_option().equals(dto.getOnum_correct_option())) {
								//correct
								resultReviewSubjectDto.setTotal_right(1);
								resultReviewSubjectDto.setTotal_wrong(0);
								resultReviewSubjectDto.setTotal_left(0);
							} else {							
								//wrong
								resultReviewSubjectDto.setTotal_wrong(1);
								resultReviewSubjectDto.setTotal_right(0);
								resultReviewSubjectDto.setTotal_left(0);
							}
							resultReviewSubjectDto.setTotal_question(1);
							subjectMapDetails.put(dto.getExamQuestionDetailsDto().getSectionDetailsDto().getSubCategoryDetailsDto().getOnum_slno(), resultReviewSubjectDto);
						}					
					}			
				}
				request.getSession().setAttribute("resultDetailsDto", resultDescriptionDtoList.get(0).getResultDetailsDto());
				request.getSession().setAttribute("subjectMapDetails", subjectMapDetails);
			} else {
				info="Due to some technical problem we are not able to show you result please contact administrator";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		flag = CommonConstants.SUCCESS_FLAG;
		return flag;
		
	}
		
	// Examination service locater
	private IExaminationDetailsServices getExaminationDetailsServices() {
		Object serviceObj = ServiceLocator.getInstance().getService(com.oes.constants.CommonConstants.EXAMINATION_DETAILS);
			return serviceObj == null ? null : (IExaminationDetailsServices) serviceObj;
	}	
	// Admin service locater
	private IAdminService getAdminManagementServices() {
		Object serviceObj = ServiceLocator.getInstance().getService(
				CommonConstants.ADMIN_MANAGEMENT_SERVICE);
		return serviceObj == null ? null
				: (IAdminService) serviceObj;
	}
	// Role Permission Master Service Locater
	private IRolePermissionService getRolePermissionManagementServices() {
		Object serviceObj = ServiceLocator.getInstance().getService(
				CommonConstants.ROLE_PERMISSION_SERVICE);
		return serviceObj == null ? null
				: (IRolePermissionService) serviceObj;
	}
	// Role Master Service Locater
	private IRoleMasterServices getRoleMasterServices(){
		Object serviceObj = ServiceLocator.getInstance().getService(
				CommonConstants.ROLE_MASTER_SERVICES);
		return serviceObj == null ? null
				: (IRoleMasterServices) serviceObj;
	}
	
	private INewsAndEventsServices getNewsAndEventsServices(){
		Object serviceObj = ServiceLocator.getInstance().getService(com.oes.constants.CommonConstants.NEWS_AND_EVENTS);
				return serviceObj == null ? null
				: (INewsAndEventsServices) serviceObj;
	}

	private IStudentDetailsServices getStudentDetailsServices(){
		Object serviceObj = ServiceLocator.getInstance().getService(com.oes.constants.CommonConstants.STUDENT_DETAILS);
				return serviceObj == null ? null : (IStudentDetailsServices) serviceObj;
	}
	
	// Admin service locater
	private IMasterDetailsServices getMasterDetailsServices () {
		Object serviceObj = ServiceLocator.getInstance().getService(com.oes.constants.CommonConstants.MASTER_DETAILS);
			return serviceObj == null ? null : (IMasterDetailsServices) serviceObj;
	}
}
