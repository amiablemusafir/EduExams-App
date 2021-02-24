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
import com.oes.dto.InstituteDetailsDto;
import com.oes.service.IMasterDetailsServices;
import com.sms.admin.dto.AdminDetailDto;
import com.sms.admin.service.IAdminService;
import com.sms.util.ServiceLocator;
import com.opensymphony.xwork2.ActionSupport;

public class InstituteDetailsAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private String messages;
	private String info;
	private InstituteDetailsDto instituteDetailsDto;
	private List<InstituteDetailsDto> instituteDetailsDtoList;
	
	public InstituteDetailsDto getInstituteDetailsDto() {
		return instituteDetailsDto;
	}
	public void setInstituteDetailsDto(InstituteDetailsDto instituteDetailsDto) {
		this.instituteDetailsDto = instituteDetailsDto;
	}
	public List<InstituteDetailsDto> getInstituteDetailsDtoList() {
		return instituteDetailsDtoList;
	}
	public void setInstituteDetailsDtoList(List<InstituteDetailsDto> instituteDetailsDtoList) {
		this.instituteDetailsDtoList = instituteDetailsDtoList;
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
	
	public String showInstituteDetails() throws POLLINGBusinessException
	{
		String flag = CommonConstants.FAILURE_ERROR;
		this.populateMenu();
		try {
			if(request.getSession().getAttribute("adminDetailDto") == null) {
				return "login";
			}
			instituteDetailsDtoList = this.getMasterDetailsServices().getInstituteDetailsDtoList();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		flag = CommonConstants.SUCCESS_FLAG;
		return flag;
		
	}
	
	
	// Method to Save and Update Course Master data into CourseMaster Table
	public String saveOrUpdateInstituteDetailsDto() throws Exception{
		
	        String flag = CommonConstants.FAILURE_ERROR; 
			
			Pattern p = Pattern.compile("^[a-zA-Z0-9][a-zA-Z0-9 ]+$", Pattern.CASE_INSENSITIVE);
			if(request.getSession().getAttribute("adminDetailDto") == null) {
				return "login";
			}
			AdminDetailDto adminDetailDto = new AdminDetailDto();
			adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
			
			Integer instituteId = instituteDetailsDto.getOnum_slno();
			System.out.println("Course ID : "+instituteId);
			
			String instituteName = instituteDetailsDto.getOstr_institute_name();
			System.out.println("Course Name "+instituteName);

			boolean instituteNameFlag = p.matcher(instituteName).find();
		    
		   if(instituteName.equals("")){
		    	
		    	 System.out.println("Course Name is null");
			    	
			       this.showInstituteDetails();
			       
			       info = "Please Enter Course Name";
			       
			       flag = CommonConstants.FAILURE_ERROR;
		    	
		    }
		    else if(instituteNameFlag == false){
		    
		    	this.showInstituteDetails();
		    	  
				info = "Please Enter Valid Course Name";
				
				System.out.println("Scriptlet Characters are not allowed....");
		       
	           flag = CommonConstants.FAILURE_ERROR;
				
		    }
		    else if(instituteId == null){
		    		 
		    		System.out.println("If institute ID is null...."); 
		    		
		    		
		    		List<InstituteDetailsDto> instituteMasterDtosList = this.getMasterDetailsServices().checkAvailInstituteDetails(instituteName);
		    		System.out.println("List Size : "+instituteMasterDtosList.size());
		    		 
				    if(instituteMasterDtosList != null && instituteMasterDtosList.size() > 0){
				    	
				    		this.showInstituteDetails();
				    		
				    		instituteDetailsDto = new InstituteDetailsDto();
	    		
				    		info = "Course Name Already Exist";
				    		
				    		System.out.println("Record is already exist");
				    		
				    		flag = CommonConstants.FAILURE_ERROR;
				    } else {
			            	
			            	System.out.println("Course Master");
				    		
			            	instituteDetailsDto.setOnum_is_active(1);
			            	instituteDetailsDto.setOdt_entry_date(new Date());
			            	instituteDetailsDto.setAdminDetailDto(adminDetailDto);
			            	
			            	this.getMasterDetailsServices().updateInstituteDetailsDto(instituteDetailsDto);
			            	
			            	this.showInstituteDetails();
			            	instituteDetailsDto = null;
					 		info = "Course details has been inserted successfully";					 		
					 		flag = CommonConstants.SUCCESS_FLAG; 				       
				    		
				    	}
		    	 } else {
		    		 List<InstituteDetailsDto> instituteMasterDtosList = this.getMasterDetailsServices().getInstituteDetailsDtoList();
		            	Integer status = 0;
		            	if(instituteMasterDtosList != null && instituteMasterDtosList.size() > 0){
		            		
		            		for(InstituteDetailsDto dto : instituteMasterDtosList){
		            			if(!(dto.getOnum_slno().equals(instituteDetailsDto.getOnum_slno()))) {
		            				if(dto.getOstr_institute_name().equals(instituteDetailsDto.getOstr_institute_name())){
		            					
		            					status = 1;
		            				}					            				
		            			}
		            		}					            		
		            	}
		            	
		            	if(status.equals(1)) {
		            		this.showInstituteDetails();
		            		info = "Course Name Already Exist";
		            		System.out.println("Record is already exist");							    		
				    		flag = CommonConstants.FAILURE_ERROR;
			           	} else {
		    		 
			           		instituteDetailsDto.setOnum_is_active(1);
			           		instituteDetailsDto.setOdt_entry_date(new Date());
			           		instituteDetailsDto.setAdminDetailDto(adminDetailDto);
			           		
			            	this.getMasterDetailsServices().updateInstituteDetailsDto(instituteDetailsDto);
			            	
			            	this.showInstituteDetails();
			            	instituteDetailsDto = null;
					 		
			            	info = "Course details has been updated successfully";
					     
			            	flag = CommonConstants.SUCCESS_FLAG;
			           	}
		    	 }
		    		
		    	
		    System.out.println(flag);
		    
			return flag;
		}
		
		
		// Method To edit Course Master Details
		public String editInstituteMasterDetail() throws Exception{
			
			String flag = CommonConstants.ERROR_FLAG;
			
			try{
				
				this.showInstituteDetails();
				populateMenu();
				String institute_id = request.getParameter("slno");
				System.out.println("institute ID : "+institute_id);
				
				instituteDetailsDto = this.getMasterDetailsServices().findInstituteDetailsById(Integer.parseInt(institute_id));
	          
				flag = CommonConstants.SUCCESS_FLAG;
				
			}
			catch(Exception er){
				er.printStackTrace();
			}
			
			return flag;
		}
		
		// Method To delete Course Master Details
		public String deleteInstituteMasterDetail() throws Exception{
				
				String flag = CommonConstants.ERROR_FLAG;
				
				try{
					
					
					
					String slno = request.getParameter("slno");
					System.out.println("institute ID : "+slno);
					
					instituteDetailsDto = this.getMasterDetailsServices().findInstituteDetailsById(Integer.parseInt(slno));
				
					instituteDetailsDto.setOnum_is_active(0);
					instituteDetailsDto.setOdt_entry_date(new Date());
					
					this.getMasterDetailsServices().updateInstituteDetailsDto(instituteDetailsDto);
					
					instituteDetailsDto = null;
					info = "Institute details has been deleted successfully";
					this.showInstituteDetails();
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
