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
import com.oes.dto.SubCategoryDetailsDto;
import com.oes.service.IMasterDetailsServices;
import com.sms.admin.dto.AdminDetailDto;
import com.sms.admin.service.IAdminService;
import com.sms.util.ServiceLocator;
import com.opensymphony.xwork2.ActionSupport;

public class SubCategoryDetailsAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private String messages;
	private String info;
	private SubCategoryDetailsDto subCategoryDetailsDto;
	private List<SubCategoryDetailsDto> subCategoryDetailsDtoList;
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
	public SubCategoryDetailsDto getSubCategoryDetailsDto() {
		return subCategoryDetailsDto;
	}
	public void setSubCategoryDetailsDto(SubCategoryDetailsDto subCategoryDetailsDto) {
		this.subCategoryDetailsDto = subCategoryDetailsDto;
	}
	public List<SubCategoryDetailsDto> getSubCategoryDetailsDtoList() {
		return subCategoryDetailsDtoList;
	}
	public void setSubCategoryDetailsDtoList(
			List<SubCategoryDetailsDto> subCategoryDetailsDtoList) {
		this.subCategoryDetailsDtoList = subCategoryDetailsDtoList;
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
	
	public String showSubCategoryDetails() throws POLLINGBusinessException
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
			subCategoryDetailsDtoList = this.getMasterDetailsServices().getSubCategoryDetailsDtoList(adminDetailDto.getInum_user_id());
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		flag = CommonConstants.SUCCESS_FLAG;
		return flag;
		
	}
	
	
	// Method to Save and Update SubCategory Master data into CourseMaster Table
	public String saveOrUpdateSubCategoryDetailsDto() throws Exception{
		
	        String flag = CommonConstants.FAILURE_ERROR; 
	       
	        if(request.getSession().getAttribute("adminDetailDto") == null) {
				return "login";
			}
			AdminDetailDto adminDetailDto = new AdminDetailDto();
			adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
			
			Pattern p = Pattern.compile("^[a-zA-Z0-9][a-zA-Z0-9 ]+$", Pattern.CASE_INSENSITIVE);
			
			Integer subCategoryId = subCategoryDetailsDto.getOnum_slno();
			System.out.println("Course ID : "+subCategoryId);
			
			String subCategoryName = subCategoryDetailsDto.getOstr_sub_category_name();
			System.out.println("Course Name "+subCategoryName);

			boolean subCategoryNameFlag = p.matcher(subCategoryName).find();
		    
		   if(subCategoryName.equals("")){
		    	
		    	 System.out.println("SubCategory Name is null");
			    	
			       this.showSubCategoryDetails();
			       
			       info = "Please Enter SubCategory Name";
			       
			       flag = CommonConstants.FAILURE_ERROR;
		    	
		    }
		    else if(subCategoryNameFlag == false){
		    
		    	this.showSubCategoryDetails();
		    	  
				info = "Please Enter Valid SubCategory Name";
				
				System.out.println("Scriptlet Characters are not allowed....");
		       
	           flag = CommonConstants.FAILURE_ERROR;
				
		    }
		    else if(subCategoryId == null){
		    		 
		    		System.out.println("If subCategory ID is null...."); 		    		
		    		
		    		List<SubCategoryDetailsDto> subCategoryMasterDtosList = this.getMasterDetailsServices().checkAvailSubCategoryDetailsDto(subCategoryName, subCategoryDetailsDto.getCategoryDetailsDto().getOnum_slno());
		    		System.out.println("List Size : "+subCategoryMasterDtosList.size());
		    		 
				    if(subCategoryMasterDtosList != null && subCategoryMasterDtosList.size() > 0){
				    	
				    		this.showSubCategoryDetails();
				    		
				    		subCategoryDetailsDto = new SubCategoryDetailsDto();
	    		
				    		info = "Sub Category Name Already Exist";
				    		
				    		System.out.println("Record is already exist");
				    		
				    		flag = CommonConstants.FAILURE_ERROR;
				    } else {
			            	
			            	System.out.println("SubCategory Master");
				    		
			            	subCategoryDetailsDto.setOnum_is_active(1);
			            	subCategoryDetailsDto.setOdt_entry_date(new Date());
			            	subCategoryDetailsDto.setAdminDetailDto(adminDetailDto);
			            	
			            	this.getMasterDetailsServices().updateSubCategoryDetailsDto(subCategoryDetailsDto);
			            	
			            	this.showSubCategoryDetails();
			            	subCategoryDetailsDto = null;
					 		info = "SubCategory details has been inserted successfully";					 		
					 		flag = CommonConstants.SUCCESS_FLAG; 				       
				    		
				    	}
		    	 } else {
		    		 List<SubCategoryDetailsDto> subCategoryMasterDtosList = this.getMasterDetailsServices().getSubCategoryDetailsDtoList();
		            	Integer status = 0;
		            	if(subCategoryMasterDtosList != null && subCategoryMasterDtosList.size() > 0){
		            		
		            		for(SubCategoryDetailsDto dto : subCategoryMasterDtosList){
		            			if(!(dto.getOnum_slno().equals(subCategoryDetailsDto.getOnum_slno()))) {
		            				if(dto.getOstr_sub_category_name().equals(subCategoryDetailsDto.getOstr_sub_category_name())){
		            					
		            					status = 1;
		            				}					            				
		            			}
		            		}					            		
		            	}
		            	
		            	if(status.equals(1)) {
		            		this.showSubCategoryDetails();
		            		info = "SubCategory Name Already Exist";
		            		System.out.println("Record is already exist");							    		
				    		flag = CommonConstants.FAILURE_ERROR;
			           	} else {
		    		 
			           		subCategoryDetailsDto.setOnum_is_active(1);
			           		subCategoryDetailsDto.setOdt_entry_date(new Date());
			            	subCategoryDetailsDto.setAdminDetailDto(adminDetailDto);
			           		
			            	this.getMasterDetailsServices().updateSubCategoryDetailsDto(subCategoryDetailsDto);
			            	
			            	this.showSubCategoryDetails();
			            	subCategoryDetailsDto = null;
					 		
			            	info = "SubCategory details has been updated successfully";
					     
			            	flag = CommonConstants.SUCCESS_FLAG;
			           	}
		    	 }    		
		    	
		    System.out.println(flag);		    
			return flag;
		}
		
		
		// Method To edit SubCategory Master Details
		public String editSubCategoryMasterDetail() throws Exception{
			
			String flag = CommonConstants.ERROR_FLAG;
			
			try{
				
				this.showSubCategoryDetails();
				populateMenu();
				String subCategory_id = request.getParameter("slno");
				System.out.println("subCategory ID : "+subCategory_id);
				
				subCategoryDetailsDto = this.getMasterDetailsServices().findSubCategoryDetailsById(Integer.parseInt(subCategory_id));
	          
				flag = CommonConstants.SUCCESS_FLAG;
				
			}
			catch(Exception er){
				er.printStackTrace();
			}
			
			return flag;
		}
		
		// Method To delete SubCategory Master Details
		public String deleteSubCategoryMasterDetail() throws Exception{
				
				String flag = CommonConstants.ERROR_FLAG;
				
				try{
					
					
					
					String slno = request.getParameter("slno");
					System.out.println("SubCategory ID : "+slno);
					
					subCategoryDetailsDto = this.getMasterDetailsServices().findSubCategoryDetailsById(Integer.parseInt(slno));
				
					subCategoryDetailsDto.setOnum_is_active(0);
					subCategoryDetailsDto.setOdt_entry_date(new Date());
					
					this.getMasterDetailsServices().updateSubCategoryDetailsDto(subCategoryDetailsDto);
					
					subCategoryDetailsDto = null;
					info = "Sub Category details has been deleted successfully";
					this.showSubCategoryDetails();
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
