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
import com.oes.dto.ContentDetailsDto;
import com.oes.service.IMasterDetailsServices;
import com.sms.admin.dto.AdminDetailDto;
import com.sms.admin.service.IAdminService;
import com.sms.util.ServiceLocator;
import com.opensymphony.xwork2.ActionSupport;

public class ContentDetailsAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private String messages;
	private String info;
	private ContentDetailsDto contentDetailsDto;
	private List<ContentDetailsDto> contentDetailsDtoList;
	
	public ContentDetailsDto getContentDetailsDto() {
		return contentDetailsDto;
	}
	public void setContentDetailsDto(ContentDetailsDto contentDetailsDto) {
		this.contentDetailsDto = contentDetailsDto;
	}
	public List<ContentDetailsDto> getContentDetailsDtoList() {
		return contentDetailsDtoList;
	}
	public void setContentDetailsDtoList(List<ContentDetailsDto> contentDetailsDtoList) {
		this.contentDetailsDtoList = contentDetailsDtoList;
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
	
	public String showContentDetails() throws POLLINGBusinessException
	{
		String flag = CommonConstants.FAILURE_ERROR;
		this.populateMenu();
		try {
			if(request.getSession().getAttribute("adminDetailDto") == null) {
				return "login";
			}
			contentDetailsDtoList = this.getMasterDetailsServices().getContentDetailsDtoList();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		flag = CommonConstants.SUCCESS_FLAG;
		return flag;
		
	}
	
	
	// Method to Save and Update Content Master data into ContentMaster Table
	public String saveOrUpdateContentDetailsDto() throws Exception{
		
	        String flag = CommonConstants.FAILURE_ERROR; 
			
			Pattern p = Pattern.compile("^[a-zA-Z0-9][a-zA-Z0-9 ]+$", Pattern.CASE_INSENSITIVE);
			if(request.getSession().getAttribute("adminDetailDto") == null) {
				return "login";
			}
			AdminDetailDto adminDetailDto = new AdminDetailDto();
			adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
			
			Integer contentId = contentDetailsDto.getOnum_slno();
			System.out.println("Content ID : "+contentId);
			
			String contentName = contentDetailsDto.getOstr_content_name();
			System.out.println("Content Name "+contentName);

			boolean contentNameFlag = p.matcher(contentName).find();
		    
		   if(contentName.equals("")){
		    	
		    	 System.out.println("Content Name is null");
			    	
			       this.showContentDetails();
			       
			       info = "Please Enter Content Name";
			       
			       flag = CommonConstants.FAILURE_ERROR;
		    	
		    }
		    else if(contentNameFlag == false){
		    
		    	this.showContentDetails();
		    	  
				info = "Please Enter Valid Content Name";
				
				System.out.println("Scriptlet Characters are not allowed....");
		       
	           flag = CommonConstants.FAILURE_ERROR;
				
		    }
		    else if(contentId == null){
		    		 
		    		System.out.println("If content ID is null...."); 
		    		
		    		
		    		List<ContentDetailsDto> contentMasterDtosList = this.getMasterDetailsServices().checkAvailContentDetails(contentName);
		    		System.out.println("List Size : "+contentMasterDtosList.size());
		    		 
				    if(contentMasterDtosList != null && contentMasterDtosList.size() > 0){
				    	
				    		this.showContentDetails();
				    		
				    		contentDetailsDto = new ContentDetailsDto();
	    		
				    		info = "Content Name Already Exist";
				    		
				    		System.out.println("Record is already exist");
				    		
				    		flag = CommonConstants.FAILURE_ERROR;
				    } else {
			            	
			            	System.out.println("Content Master");
				    		
			            	contentDetailsDto.setOnum_is_active(1);
			            	contentDetailsDto.setOdt_entry_date(new Date());
			            	contentDetailsDto.setAdminDetailDto(adminDetailDto);
			            	
			            	this.getMasterDetailsServices().updateContentDetailsDto(contentDetailsDto);
			            	
			            	this.showContentDetails();
			            	contentDetailsDto = null;
					 		info = "Content details has been inserted successfully";					 		
					 		flag = CommonConstants.SUCCESS_FLAG; 				       
				    		
				    	}
		    	 } else {
		    		 List<ContentDetailsDto> contentMasterDtosList = this.getMasterDetailsServices().getContentDetailsDtoList();
		            	Integer status = 0;
		            	if(contentMasterDtosList != null && contentMasterDtosList.size() > 0){
		            		
		            		for(ContentDetailsDto dto : contentMasterDtosList){
		            			if(!(dto.getOnum_slno().equals(contentDetailsDto.getOnum_slno()))) {
		            				if(dto.getOstr_content_name().equals(contentDetailsDto.getOstr_content_name())){
		            					
		            					status = 1;
		            				}					            				
		            			}
		            		}					            		
		            	}
		            	
		            	if(status.equals(1)) {
		            		this.showContentDetails();
		            		info = "Content Name Already Exist";
		            		System.out.println("Record is already exist");							    		
				    		flag = CommonConstants.FAILURE_ERROR;
			           	} else {
		    		 
			           		contentDetailsDto.setOnum_is_active(1);
			           		contentDetailsDto.setOdt_entry_date(new Date());
			           		contentDetailsDto.setAdminDetailDto(adminDetailDto);
			           		
			            	this.getMasterDetailsServices().updateContentDetailsDto(contentDetailsDto);
			            	
			            	this.showContentDetails();
			            	contentDetailsDto = null;
					 		
			            	info = "Content details has been updated successfully";
					     
			            	flag = CommonConstants.SUCCESS_FLAG;
			           	}
		    	 }
		    		
		    	
		    System.out.println(flag);
		    
			return flag;
		}
		
		
		// Method To edit Content Master Details
		public String editContentMasterDetail() throws Exception{
			
			String flag = CommonConstants.ERROR_FLAG;
			
			try{
				
				this.showContentDetails();
				populateMenu();
				String content_id = request.getParameter("slno");
				System.out.println("content ID : "+content_id);
				
				contentDetailsDto = this.getMasterDetailsServices().findContentDetailsById(Integer.parseInt(content_id));
	          
				flag = CommonConstants.SUCCESS_FLAG;
				
			}
			catch(Exception er){
				er.printStackTrace();
			}
			
			return flag;
		}
		
		// Method To delete Content Master Details
		public String deleteContentMasterDetail() throws Exception{
				
				String flag = CommonConstants.ERROR_FLAG;
				
				try{
					
					
					
					String slno = request.getParameter("slno");
					System.out.println("content ID : "+slno);
					
					contentDetailsDto = this.getMasterDetailsServices().findContentDetailsById(Integer.parseInt(slno));
				
					contentDetailsDto.setOnum_is_active(0);
					contentDetailsDto.setOdt_entry_date(new Date());
					
					this.getMasterDetailsServices().updateContentDetailsDto(contentDetailsDto);
					
					contentDetailsDto = null;
					info = "Content details has been deleted successfully";
					this.showContentDetails();
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
