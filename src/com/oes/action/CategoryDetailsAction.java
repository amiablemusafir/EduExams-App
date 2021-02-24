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
import com.oes.dto.CategoryDetailsDto;
import com.oes.service.IMasterDetailsServices;
import com.sms.admin.dto.AdminDetailDto;
import com.sms.admin.service.IAdminService;
import com.sms.util.ServiceLocator;
import com.opensymphony.xwork2.ActionSupport;


public class CategoryDetailsAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private String messages;
	private String info;
	private CategoryDetailsDto categoryDetailsDto;
	private List<CategoryDetailsDto> categoryDetailsDtoList;
	
	public CategoryDetailsDto getCategoryDetailsDto() {
		return categoryDetailsDto;
	}
	public void setCategoryDetailsDto(CategoryDetailsDto categoryDetailsDto) {
		this.categoryDetailsDto = categoryDetailsDto;
	}
	public List<CategoryDetailsDto> getCategoryDetailsDtoList() {
		return categoryDetailsDtoList;
	}
	public void setCategoryDetailsDtoList(
			List<CategoryDetailsDto> categoryDetailsDtoList) {
		this.categoryDetailsDtoList = categoryDetailsDtoList;
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
	
	public String showCategoryDetails() throws POLLINGBusinessException
	{
		String flag = CommonConstants.FAILURE_ERROR;
		this.populateMenu();
		try {
			if(request.getSession().getAttribute("adminDetailDto") == null) {
				return "login";
			}
			AdminDetailDto adminDetailDto = new AdminDetailDto();
			adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
			
			categoryDetailsDtoList = this.getMasterDetailsServices().getCategoryDetailsDtoList(adminDetailDto.getInum_user_id());
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		flag = CommonConstants.SUCCESS_FLAG;
		return flag;
		
	}
	
	
	// Method to Save and Update Category Master data into CourseMaster Table
	public String saveOrUpdateCategoryDetailsDto() throws Exception{
		
	        String flag = CommonConstants.FAILURE_ERROR; 
			
			Pattern p = Pattern.compile("^[a-zA-Z0-9][a-zA-Z0-9 ]+$", Pattern.CASE_INSENSITIVE);
			
			if(request.getSession().getAttribute("adminDetailDto") == null) {
				return "login";
			}
			AdminDetailDto adminDetailDto = new AdminDetailDto();
			adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
			
			Integer categoryId = categoryDetailsDto.getOnum_slno();
			System.out.println("Course ID : "+categoryId);
			
			String categoryName = categoryDetailsDto.getOstr_category_name();
			System.out.println("Course Name "+categoryName);

			boolean categoryNameFlag = p.matcher(categoryName).find();
		    
		   if(categoryName.equals("")){
		    	
		    	 System.out.println("Category Name is null");
			    	
			       this.showCategoryDetails();
			       
			       info = "Please Enter Category Name";
			       
			       flag = CommonConstants.FAILURE_ERROR;
		    	
		    }
		    else if(categoryNameFlag == false){
		    
		    	this.showCategoryDetails();
		    	  
				info = "Please Enter Valid Category Name";
				
				System.out.println("Scriptlet Characters are not allowed....");
		       
	           flag = CommonConstants.FAILURE_ERROR;
				
		    }
		    else if(categoryId == null){
		    		 
		    		System.out.println("If category ID is null...."); 
		    		
		    		
		    		List<CategoryDetailsDto> categoryMasterDtosList = this.getMasterDetailsServices().checkAvailCategoryDetailsDto(categoryName);
		    		System.out.println("List Size : "+categoryMasterDtosList.size());
		    		 
				    if(categoryMasterDtosList != null && categoryMasterDtosList.size() > 0){
				    	
				    		this.showCategoryDetails();
				    		
				    		categoryDetailsDto = new CategoryDetailsDto();
	    		
				    		info = "Category Name Already Exist";
				    		
				    		System.out.println("Record is already exist");
				    		
				    		flag = CommonConstants.FAILURE_ERROR;
				    } else {
			            	
			            	System.out.println("Category Master");
				    		
			            	categoryDetailsDto.setOnum_is_active(1);
			            	categoryDetailsDto.setOdt_entry_date(new Date());
			            	categoryDetailsDto.setAdminDetailDto(adminDetailDto);
			            	
			            	this.getMasterDetailsServices().updateCategoryDetailsDto(categoryDetailsDto);
			            	
			            	this.showCategoryDetails();
			            	categoryDetailsDto = null;
					 		info = "Category details has been inserted successfully";					 		
					 		flag = CommonConstants.SUCCESS_FLAG; 				       
				    		
				    	}
		    	 } else {
		    		 List<CategoryDetailsDto> categoryMasterDtosList = this.getMasterDetailsServices().getCategoryDetailsDtoList();
		            	Integer status = 0;
		            	if(categoryMasterDtosList != null && categoryMasterDtosList.size() > 0){
		            		
		            		for(CategoryDetailsDto dto : categoryMasterDtosList){
		            			if(!(dto.getOnum_slno().equals(categoryDetailsDto.getOnum_slno()))) {
		            				if(dto.getOstr_category_name().equals(categoryDetailsDto.getOstr_category_name())){
		            					
		            					status = 1;
		            				}					            				
		            			}
		            		}					            		
		            	}
		            	
		            	if(status.equals(1)) {
		            		this.showCategoryDetails();
		            		info = "Category Name Already Exist";
		            		System.out.println("Record is already exist");							    		
				    		flag = CommonConstants.FAILURE_ERROR;
			           	} else {
		    		 
			           		categoryDetailsDto.setOnum_is_active(1);
			           		categoryDetailsDto.setOdt_entry_date(new Date());
			           		categoryDetailsDto.setAdminDetailDto(adminDetailDto);
			           		
			            	this.getMasterDetailsServices().updateCategoryDetailsDto(categoryDetailsDto);
			            	
			            	this.showCategoryDetails();
			            	categoryDetailsDto = null;
					 		
			            	info = "Category details has been updated successfully";
					     
			            	flag = CommonConstants.SUCCESS_FLAG;
			           	}
		    	 }
		    		
		    	
		    System.out.println(flag);
		    
			return flag;
		}
		
		
		// Method To edit Category Master Details
		public String editCategoryMasterDetail() throws Exception{
			
			String flag = CommonConstants.ERROR_FLAG;
			
			try{
				
				this.showCategoryDetails();
				populateMenu();
				String category_id = request.getParameter("slno");
				System.out.println("category ID : "+category_id);
				
				categoryDetailsDto = this.getMasterDetailsServices().findCategoryDetailsById(Integer.parseInt(category_id));
	          
				flag = CommonConstants.SUCCESS_FLAG;
				
			}
			catch(Exception er){
				er.printStackTrace();
			}
			
			return flag;
		}
		
		// Method To delete Category Master Details
		public String deleteCategoryMasterDetail() throws Exception{
				
				String flag = CommonConstants.ERROR_FLAG;
				
				try{
					
					
					
					String slno = request.getParameter("slno");
					System.out.println("Category ID : "+slno);
					
					categoryDetailsDto = this.getMasterDetailsServices().findCategoryDetailsById(Integer.parseInt(slno));
				
					categoryDetailsDto.setOnum_is_active(0);
					categoryDetailsDto.setOdt_entry_date(new Date());
					
					this.getMasterDetailsServices().updateCategoryDetailsDto(categoryDetailsDto);
					
					categoryDetailsDto = null;
					info = "Course details has been deleted successfully";
					this.showCategoryDetails();
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
