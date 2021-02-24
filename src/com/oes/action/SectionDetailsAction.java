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
import com.oes.dto.ParagraphDetailsDto;
import com.oes.dto.SectionDetailsDto;
import com.oes.dto.SubCategoryDetailsDto;
import com.oes.service.IMasterDetailsServices;
import com.sms.admin.dto.AdminDetailDto;
import com.sms.admin.service.IAdminService;
import com.sms.util.ServiceLocator;
import com.opensymphony.xwork2.ActionSupport;

public class SectionDetailsAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private String messages;
	private String info;
	private SectionDetailsDto sectionDetailsDto;
	private List<SectionDetailsDto> sectionDetailsDtoList;
	private CategoryDetailsDto categoryDetailsDto;
	private List<CategoryDetailsDto> categoryDetailsDtoList;
	
	private SubCategoryDetailsDto subCategoryDetailsDto;
	private List<SubCategoryDetailsDto> subcategoryDetailsDtoList;
	
	private ParagraphDetailsDto paragraphDetailsDto;
	private List<ParagraphDetailsDto> paragraphDetailsDtoList;
	
	public ParagraphDetailsDto getParagraphDetailsDto() {
		return paragraphDetailsDto;
	}
	public void setParagraphDetailsDto(ParagraphDetailsDto paragraphDetailsDto) {
		this.paragraphDetailsDto = paragraphDetailsDto;
	}
	public List<ParagraphDetailsDto> getParagraphDetailsDtoList() {
		return paragraphDetailsDtoList;
	}
	public void setParagraphDetailsDtoList(
			List<ParagraphDetailsDto> paragraphDetailsDtoList) {
		this.paragraphDetailsDtoList = paragraphDetailsDtoList;
	}
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
	public List<SubCategoryDetailsDto> getSubcategoryDetailsDtoList() {
		return subcategoryDetailsDtoList;
	}
	public void setSubcategoryDetailsDtoList(
			List<SubCategoryDetailsDto> subcategoryDetailsDtoList) {
		this.subcategoryDetailsDtoList = subcategoryDetailsDtoList;
	}
	public SectionDetailsDto getSectionDetailsDto() {
		return sectionDetailsDto;
	}
	public void setSectionDetailsDto(SectionDetailsDto sectionDetailsDto) {
		this.sectionDetailsDto = sectionDetailsDto;
	}
	public List<SectionDetailsDto> getSectionDetailsDtoList() {
		return sectionDetailsDtoList;
	}
	public void setSectionDetailsDtoList(
			List<SectionDetailsDto> sectionDetailsDtoList) {
		this.sectionDetailsDtoList = sectionDetailsDtoList;
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
	
	public String showSectionDetails() throws POLLINGBusinessException
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
			sectionDetailsDtoList = this.getMasterDetailsServices().getSectionDetailsDtoList(adminDetailDto.getInum_user_id());
			paragraphDetailsDtoList = this.getMasterDetailsServices().getParagraphDetailsDtoList(adminDetailDto.getInum_user_id());
			if(sectionDetailsDto != null) {
				//System.out.println("====="+sectionDetailsDto.getCategoryDetailsDto().getOnum_slno());
				subcategoryDetailsDtoList = this.getMasterDetailsServices().getSubCategoryDetailsDtoListByCategoryId(sectionDetailsDto.getCategoryDetailsDto().getOnum_slno());
			} else {
				subcategoryDetailsDtoList = null;
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		flag = CommonConstants.SUCCESS_FLAG;
		return flag;
		
	}
	
	
	// Method to Save and Update Section Master data into CourseMaster Table
	public String saveOrUpdateSectionDetailsDto() throws Exception{
		
	        String flag = CommonConstants.FAILURE_ERROR; 
	        if(request.getSession().getAttribute("adminDetailDto") == null) {
				return "login";
			}
			AdminDetailDto adminDetailDto = new AdminDetailDto();
			adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
			
			Pattern p = Pattern.compile("^[a-zA-Z0-9][a-zA-Z0-9 ]+$", Pattern.CASE_INSENSITIVE);
			
			Integer sectionId = sectionDetailsDto.getOnum_slno();
			System.out.println("Course ID : "+sectionId);
			
			String sectionName = sectionDetailsDto.getOstr_section_name();
			System.out.println("Course Name "+sectionName);

			boolean sectionNameFlag = p.matcher(sectionName).find();
			
			if(sectionDetailsDto.getInum_is_paragraph().equals(0)) {
				sectionDetailsDto.setParagraphDetailsDto(null);
			}
		    
		    if(sectionName.equals("")){
		    	
		    	 System.out.println("Section Name is null");
			    	
			       this.showSectionDetails();
			       
			       info = "Please Enter Section Name";
			       
			       flag = CommonConstants.FAILURE_ERROR;
		    	
		    }
		    else if(sectionNameFlag == false){
		    
		    	this.showSectionDetails();
		    	  
				info = "Please Enter Valid Section Name";
				
				System.out.println("Scriptlet Characters are not allowed....");
		       
	           flag = CommonConstants.FAILURE_ERROR;
				
		    }
		    else if(sectionId == null){
		    		 
		    		System.out.println("If section ID is null...."); 
		    		
		    		
		    		List<SectionDetailsDto> sectionMasterDtosList = this.getMasterDetailsServices().checkAvailSectionDetailsDto(sectionName);
		    		System.out.println("List Size : "+sectionMasterDtosList.size());
		    		 
				    if(sectionMasterDtosList != null && sectionMasterDtosList.size() > 0){
				    	
				    		this.showSectionDetails();
				    		
				    		sectionDetailsDto = new SectionDetailsDto();
	    		
				    		info = "Section Name Already Exist";
				    		
				    		System.out.println("Record is already exist");
				    		
				    		flag = CommonConstants.FAILURE_ERROR;
				    } else {
			            	
			            	System.out.println("Section Master");
				    		
			            	sectionDetailsDto.setOnum_is_active(1);
			            	sectionDetailsDto.setOdt_entry_date(new Date());
			            	sectionDetailsDto.setOnum_remaining_question(0);
			            	sectionDetailsDto.setAdminDetailDto(adminDetailDto);
			            	
			            	this.getMasterDetailsServices().updateSectionDetailsDto(sectionDetailsDto);
			            	
			            	this.showSectionDetails();
			            	sectionDetailsDto = null;
					 		info = "Section details has been inserted successfully";					 		
					 		flag = CommonConstants.SUCCESS_FLAG; 				       
				    		
				    	}
		    	 } else {
		    		 List<SectionDetailsDto> sectionMasterDtosList = this.getMasterDetailsServices().getSectionDetailsDtoList();
		            	Integer status = 0;
		            	if(sectionMasterDtosList != null && sectionMasterDtosList.size() > 0){
		            		
		            		for(SectionDetailsDto dto : sectionMasterDtosList){
		            			if(!(dto.getOnum_slno().equals(sectionDetailsDto.getOnum_slno()))) {
		            				if(dto.getOstr_section_name().equals(sectionDetailsDto.getOstr_section_name())){
		            					
		            					status = 1;
		            				}					            				
		            			}
		            		}					            		
		            	}
		            	
		            	if(status.equals(1)) {
		            		this.showSectionDetails();
		            		info = "Section Name Already Exist";
		            		System.out.println("Record is already exist");							    		
				    		flag = CommonConstants.FAILURE_ERROR;
			           	} else {
		    		 
			           		sectionDetailsDto.setOnum_is_active(1);
			           		sectionDetailsDto.setOdt_entry_date(new Date());
			           		sectionDetailsDto.setAdminDetailDto(adminDetailDto);
			           		
			            	this.getMasterDetailsServices().updateSectionDetailsDto(sectionDetailsDto);
			            	
			            	this.showSectionDetails();
			            	sectionDetailsDto = null;
					 		
			            	info = "Section details has been updated successfully";					     
			            	flag = CommonConstants.SUCCESS_FLAG;
			           	}
		    	 }
		    		
		    	
		    System.out.println(flag);
		    
			return flag;
		}
		
		
		// Method To edit Section Master Details
		public String editSectionMasterDetail() throws Exception{
			
			String flag = CommonConstants.ERROR_FLAG;
			
			try{
				
				populateMenu();
				String section_id = request.getParameter("slno");
				System.out.println("section ID : "+section_id);
				
				sectionDetailsDto = this.getMasterDetailsServices().findSectionDetailsById(Integer.parseInt(section_id));
				this.showSectionDetails();				
				flag = CommonConstants.SUCCESS_FLAG;
				
			}
			catch(Exception er){
				er.printStackTrace();
			}
			
			return flag;
		}
		
		// Method To delete Section Master Details
		public String deleteSectionMasterDetail() throws Exception{
				
				String flag = CommonConstants.ERROR_FLAG;
				
				try{
					
					
					
					String slno = request.getParameter("slno");
					System.out.println("Section ID : "+slno);
					
					sectionDetailsDto = this.getMasterDetailsServices().findSectionDetailsById(Integer.parseInt(slno));
				
					sectionDetailsDto.setOnum_is_active(0);
					sectionDetailsDto.setOdt_entry_date(new Date());
					
					this.getMasterDetailsServices().updateSectionDetailsDto(sectionDetailsDto);
					
					sectionDetailsDto = null;
					info = "Course details has been deleted successfully";
					this.showSectionDetails();
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
