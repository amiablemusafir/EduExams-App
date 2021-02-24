package com.oes.action;

import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.oes.common.exception.POLLINGBusinessException;
import com.oes.constants.CommonConstants;
import com.oes.dto.CourseDetailsDto;
import com.oes.service.IMasterDetailsServices;
import com.sms.admin.dto.AdminDetailDto;
import com.sms.admin.service.IAdminService;
import com.sms.util.ServiceLocator;
import com.opensymphony.xwork2.ActionSupport;

public class CourseDetailsAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private String messages;
	private String info;
	private CourseDetailsDto courseDetailsDto;
	private List<CourseDetailsDto> courseDetailsDtoList;
	
	public CourseDetailsDto getCourseDetailsDto() {
		return courseDetailsDto;
	}
	public void setCourseDetailsDto(CourseDetailsDto courseDetailsDto) {
		this.courseDetailsDto = courseDetailsDto;
	}
	public List<CourseDetailsDto> getCourseDetailsDtoList() {
		return courseDetailsDtoList;
	}
	public void setCourseDetailsDtoList(List<CourseDetailsDto> courseDetailsDtoList) {
		this.courseDetailsDtoList = courseDetailsDtoList;
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
	
	public String showCourseDetails() throws POLLINGBusinessException
	{
		String flag = CommonConstants.FAILURE_ERROR;
		this.populateMenu();
		try {
			if(request.getSession().getAttribute("adminDetailDto") == null) {
				return "login";
			}
			AdminDetailDto adminDetailDto = new AdminDetailDto();
			adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
			
			courseDetailsDtoList = this.getMasterDetailsServices().getCourseDetailsDtoList(adminDetailDto.getInum_user_id());
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		flag = CommonConstants.SUCCESS_FLAG;
		return flag;		
	}
	
	
	// Method to Save and Update Course Master data into CourseMaster Table
	public String saveOrUpdateCourseDetailsDto() throws Exception{
		
	        String flag = CommonConstants.FAILURE_ERROR; 
			
			Pattern p = Pattern.compile("^[a-zA-Z0-9][a-zA-Z0-9 ]+$", Pattern.CASE_INSENSITIVE);
			if(request.getSession().getAttribute("adminDetailDto") == null) {
				return "login";
			}
			AdminDetailDto adminDetailDto = new AdminDetailDto();
			adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
			
			Integer courseId = courseDetailsDto.getOnum_slno();
			System.out.println("Course ID : "+courseId);
			
			String courseName = courseDetailsDto.getOstr_course_name();
			System.out.println("Course Name "+courseName);

			boolean courseNameFlag = p.matcher(courseName).find();
		    
		   if(courseName.equals("")){
		    	
		    	 System.out.println("Course Name is null");
			    	
			       this.showCourseDetails();
			       
			       info = "Please Enter Course Name";
			       
			       flag = CommonConstants.FAILURE_ERROR;
		    	
		    }
		    else if(courseNameFlag == false){
		    
		    	this.showCourseDetails();
		    	  
				info = "Please Enter Valid Course Name";
				
				System.out.println("Scriptlet Characters are not allowed....");
		       
	           flag = CommonConstants.FAILURE_ERROR;
				
		    }
		    else if(courseId == null){
		    		 
		    		System.out.println("If course ID is null...."); 
		    		
		    		
		    		List<CourseDetailsDto> courseMasterDtosList = this.getMasterDetailsServices().checkAvailCourseDetails(courseName);
		    		System.out.println("List Size : "+courseMasterDtosList.size());
		    		 
				    if(courseMasterDtosList != null && courseMasterDtosList.size() > 0){
				    	
				    		this.showCourseDetails();
				    		
				    		courseDetailsDto = new CourseDetailsDto();
	    		
				    		info = "Course Name Already Exist";
				    		
				    		System.out.println("Record is already exist");
				    		
				    		flag = CommonConstants.FAILURE_ERROR;
				    } else {
			            	
			            	System.out.println("Course Master");
				    		
			            	courseDetailsDto.setOnum_is_active(1);
			            	courseDetailsDto.setOdt_entry_date(new Date());
			            	courseDetailsDto.setAdminDetailDto(adminDetailDto);
			            	
			            	this.getMasterDetailsServices().updateCourseDetailsDto(courseDetailsDto);
			            	
			            	this.showCourseDetails();
			            	courseDetailsDto = null;
					 		info = "Course details has been inserted successfully";					 		
					 		flag = CommonConstants.SUCCESS_FLAG; 				       
				    		
				    	}
		    	 } else {
		    		 List<CourseDetailsDto> courseMasterDtosList = this.getMasterDetailsServices().getCourseDetailsDtoList();
		            	Integer status = 0;
		            	if(courseMasterDtosList != null && courseMasterDtosList.size() > 0){
		            		
		            		for(CourseDetailsDto dto : courseMasterDtosList){
		            			if(!(dto.getOnum_slno().equals(courseDetailsDto.getOnum_slno()))) {
		            				if(dto.getOstr_course_name().equals(courseDetailsDto.getOstr_course_name())){
		            					
		            					status = 1;
		            				}					            				
		            			}
		            		}					            		
		            	}
		            	
		            	if(status.equals(1)) {
		            		this.showCourseDetails();
		            		info = "Course Name Already Exist";
		            		System.out.println("Record is already exist");							    		
				    		flag = CommonConstants.FAILURE_ERROR;
			           	} else {
		    		 
			           		courseDetailsDto.setOnum_is_active(1);
			           		courseDetailsDto.setOdt_entry_date(new Date());
			           		courseDetailsDto.setAdminDetailDto(adminDetailDto);
			           		
			            	this.getMasterDetailsServices().updateCourseDetailsDto(courseDetailsDto);
			            	
			            	this.showCourseDetails();
			            	courseDetailsDto = null;
					 		
			            	info = "Course details has been updated successfully";
					     
			            	flag = CommonConstants.SUCCESS_FLAG;
			           	}
		    	 }
		    		
		    	
		    System.out.println(flag);
		    
			return flag;
		}
		
		
		// Method To edit Course Master Details
		public String editCourseMasterDetail() throws Exception{
			
			String flag = CommonConstants.ERROR_FLAG;
			
			try{
				
				this.showCourseDetails();
				populateMenu();
				String course_id = request.getParameter("slno");
				System.out.println("course ID : "+course_id);
				
				courseDetailsDto = this.getMasterDetailsServices().findCourseDetailsById(Integer.parseInt(course_id));
	          
				flag = CommonConstants.SUCCESS_FLAG;
				
			}
			catch(Exception er){
				er.printStackTrace();
			}
			
			return flag;
		}
		
		// Method To delete Course Master Details
		public String deleteCourseMasterDetail() throws Exception{
				
				String flag = CommonConstants.ERROR_FLAG;
				
				try{
					
					
					
					String slno = request.getParameter("slno");
					System.out.println("course ID : "+slno);
					
					courseDetailsDto = this.getMasterDetailsServices().findCourseDetailsById(Integer.parseInt(slno));
				
					courseDetailsDto.setOnum_is_active(0);
					courseDetailsDto.setOdt_entry_date(new Date());
					
					this.getMasterDetailsServices().updateCourseDetailsDto(courseDetailsDto);
					
					courseDetailsDto = null;
					info = "Course details has been deleted successfully";
					this.showCourseDetails();
					flag = CommonConstants.SUCCESS_FLAG;
					
				}
				catch(Exception er){
					er.printStackTrace();
				}
				
				return flag;
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

}
