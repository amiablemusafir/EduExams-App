package com.oes.action;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.oes.common.exception.POLLINGBusinessException;
import com.oes.constants.CommonConstants;
import com.oes.dto.ParagraphDetailsDto;
import com.oes.service.IMasterDetailsServices;
import com.sms.admin.dto.AdminDetailDto;
import com.sms.admin.dto.PermissionMasterDto;
import com.sms.admin.service.IAdminService;
import com.sms.util.ServiceLocator;
import com.opensymphony.xwork2.ActionSupport;

public class ParagraphDetailsAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private String messages;
	private String info;
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
	
	public String showParagraphDetails() throws POLLINGBusinessException
	{
		String flag = CommonConstants.FAILURE_ERROR;
		this.populateMenu();
		try {
			if(request.getSession().getAttribute("adminDetailDto") == null) {
				return "login";
			}
			AdminDetailDto adminDetailDto = new AdminDetailDto();
			adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
			
			paragraphDetailsDtoList = this.getMasterDetailsServices().getParagraphDetailsDtoList(adminDetailDto.getInum_user_id());
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		flag = CommonConstants.SUCCESS_FLAG;
		return flag;		
	}
	
	
	// Method to Save and Update Course Master data into CourseMaster Table
	public String saveOrUpdateParagraphDetailsDto() throws Exception{
		
	        String flag = CommonConstants.FAILURE_ERROR; 
	        if(request.getSession().getAttribute("adminDetailDto") == null) {
				return "login";
			}
			AdminDetailDto adminDetailDto = new AdminDetailDto();
			adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
			
	        try {
				Pattern p = Pattern.compile("^[a-zA-Z0-9][a-zA-Z0-9 ]+$", Pattern.CASE_INSENSITIVE);
				
				Integer id = paragraphDetailsDto.getOnum_slno();
				System.out.println("Course ID : "+id);
				
				String name = paragraphDetailsDto.getOstr_paragraph_name();
				
				boolean nameFlag = p.matcher(name).find();
			    
			   if(name.equals("")){
			    	
			    	   this.showParagraphDetails();
				       
				       info = "Please Enter Paragraph Name";
				       
				       flag = CommonConstants.FAILURE_ERROR;
			    	
			    }
			    else if(nameFlag == false){
			    
			    	this.showParagraphDetails();
			    	  
					info = "Please Enter Valid Paragraph Name";
					
					System.out.println("Scriptlet Characters are not allowed....");
			       
		           flag = CommonConstants.FAILURE_ERROR;
					
			    }
			    else if(id == null){
			    		 
			    		System.out.println("If course ID is null...."); 
			    		
			    		
			    		List<ParagraphDetailsDto> paragraphMasterDtosList = this.getMasterDetailsServices().checkAvailParagraphDetails(name);
			    		System.out.println("List Size : "+paragraphMasterDtosList.size());
			    		 
					    if(paragraphMasterDtosList != null && paragraphMasterDtosList.size() > 0){
					    	
					    		this.showParagraphDetails();
					    		
					    		paragraphDetailsDto = new ParagraphDetailsDto();
		    		
					    		info = "Paragraph Name Already Exist";
					    		
					    		System.out.println("Record is already exist");
					    		
					    		flag = CommonConstants.FAILURE_ERROR;
					    } else {
				            	
				            	System.out.println("Course Master");
					    		
				            	paragraphDetailsDto.setOnum_is_active(1);
				            	paragraphDetailsDto.setOdt_entry_date(new Date());
				            	paragraphDetailsDto.setAdminDetailDto(adminDetailDto);
				            	
				            	this.getMasterDetailsServices().updateParagraphDetailsDto(paragraphDetailsDto);
				            	
				            	this.showParagraphDetails();
				            	paragraphDetailsDto = null;
						 		info = "Paragraph details has been inserted successfully";					 		
						 		flag = CommonConstants.SUCCESS_FLAG; 				       
					    		
					    	}
			    	 } else {
			    		 List<ParagraphDetailsDto> paragraphMasterDtosList = this.getMasterDetailsServices().getParagraphDetailsDtoList();
			            	Integer status = 0;
			            	if(paragraphMasterDtosList != null && paragraphMasterDtosList.size() > 0){
			            		
			            		for(ParagraphDetailsDto dto : paragraphMasterDtosList){
			            			if(!(dto.getOnum_slno().equals(paragraphDetailsDto.getOnum_slno()))) {
			            				if(dto.getOstr_paragraph_name().equals(paragraphDetailsDto.getOstr_paragraph_name())){
			            					
			            					status = 1;
			            				}					            				
			            			}
			            		}					            		
			            	}
			            	
			            	if(status.equals(1)) {
			            		this.showParagraphDetails();
			            		info = "Paragraph Name Already Exist";
			            		System.out.println("Record is already exist");							    		
					    		flag = CommonConstants.FAILURE_ERROR;
				           	} else {
			    		 
				           		paragraphDetailsDto.setOnum_is_active(1);
				           		paragraphDetailsDto.setOdt_entry_date(new Date());
				           		paragraphDetailsDto.setAdminDetailDto(adminDetailDto);
				           		
				            	this.getMasterDetailsServices().updateParagraphDetailsDto(paragraphDetailsDto);
				            	
				            	this.showParagraphDetails();
				            	paragraphDetailsDto = null;
						 		
				            	info = "Paragraph details has been updated successfully";
						     
				            	flag = CommonConstants.SUCCESS_FLAG;
				           	}
			    	 }
		    		
	        } catch(Exception ex) {
	        	ex.printStackTrace();
	        }
		    System.out.println(flag);
		    
			return flag;
		}
		
		
		// Method To edit Paragraph Master Details
		public String editParagraphMasterDetail() throws Exception{
			
			String flag = CommonConstants.ERROR_FLAG;
			try{				
				this.showParagraphDetails();
				populateMenu();
				String id = request.getParameter("slno");
				
				paragraphDetailsDto = this.getMasterDetailsServices().findParagraphDetailsById(Integer.parseInt(id));
	            flag = CommonConstants.SUCCESS_FLAG;				
			}
			catch(Exception er){
				er.printStackTrace();
			}			
			return flag;
		}
		
		// Method To delete Paragraph Master Details
		
		public String deleteParagraphMasterDetail() throws Exception{
				
				String flag = CommonConstants.ERROR_FLAG;
				
				try{
					String slno = request.getParameter("slno");
					System.out.println("ID : "+slno);
					
					paragraphDetailsDto = this.getMasterDetailsServices().findParagraphDetailsById(Integer.parseInt(slno));
				
					paragraphDetailsDto.setOnum_is_active(0);
					paragraphDetailsDto.setOdt_entry_date(new Date());
					
					this.getMasterDetailsServices().updateParagraphDetailsDto(paragraphDetailsDto);
					
					paragraphDetailsDto = null;
					info = "Paragraph details has been deleted successfully";
					this.showParagraphDetails();
					flag = CommonConstants.SUCCESS_FLAG;
					
				}
				catch(Exception er){
					er.printStackTrace();
				}
				
				return flag;
			}
		
		// show Paragraph Details
		public void showComboParagraphDetails() throws Exception{
			
			System.out.println("Show Parent Permission Combo");
			
			try{
				
				StringBuffer sbBuffer = new StringBuffer();
				String is_paragraph = request.getParameter("is_paragraph");				 
				System.out.println("Is Parent : "+is_paragraph);
				
				if(!is_paragraph.equals("")){
					
					sbBuffer.append("<td><div><b><label for='Parent Permission'>Paragraph :</label></b></div></td>");
					sbBuffer.append("<td><div class='styled-select2'>");					
					sbBuffer.append("<select name='sectionDetailsDto.paragraphDetailsDto.onum_slno' id='onum_paragraph_id'>");					
					sbBuffer.append("<option value='0'>Select Paragraph</option>");
					
				    paragraphDetailsDtoList = this.getMasterDetailsServices().getParagraphDetailsDtoList();
					
				    System.out.println("paragraph Master List : "+paragraphDetailsDtoList.size());
				    
				    if(paragraphDetailsDtoList!=null && paragraphDetailsDtoList.size()>0){
				    	
				    	for(ParagraphDetailsDto dto : paragraphDetailsDtoList){
				    		
				    		System.out.println("Permission Name : "+dto.getOstr_paragraph_name());
				    		sbBuffer.append("<option value='"+dto.getOnum_slno()+"'>"+dto.getOstr_paragraph_name()+"</option>");	
				    	}
				    }
					sbBuffer.append("</select></div>");
					sbBuffer.append("</td>");
					
					response.setContentType("text/html");
					response.setHeader("Cache-Control", "no-cache");
					try {
						response.getWriter().write(sbBuffer.toString());
					} catch (IOException ioe) {
						ioe.printStackTrace();
					}					
				}					
			}
			catch(Exception er){
				er.printStackTrace();
			}			
		}
	
			// Admin service locater
			private IMasterDetailsServices getMasterDetailsServices () {
				Object serviceObj = ServiceLocator.getInstance().getService(com.oes.constants.CommonConstants.MASTER_DETAILS);
					return serviceObj == null ? null : (IMasterDetailsServices) serviceObj;
			}

}
