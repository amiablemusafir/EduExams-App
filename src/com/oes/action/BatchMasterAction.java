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
import com.oes.dto.BatchMasterDto;
import com.oes.service.IMasterDetailsServices;
import com.sms.admin.dto.AdminDetailDto;
import com.sms.util.ServiceLocator;
import com.opensymphony.xwork2.ActionSupport;

public class BatchMasterAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private String messages;
	private String info;
	private BatchMasterDto batchMasterDto;
	private List<BatchMasterDto> batchMasterDtoList;
	
	public BatchMasterDto getBatchMasterDto() {
		return batchMasterDto;
	}
	public void setBatchMasterDto(BatchMasterDto batchMasterDto) {
		this.batchMasterDto = batchMasterDto;
	}
	public List<BatchMasterDto> getBatchMasterDtoList() {
		return batchMasterDtoList;
	}
	public void setBatchMasterDtoList(List<BatchMasterDto> batchMasterDtoList) {
		this.batchMasterDtoList = batchMasterDtoList;
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
	
	public String showBatchMaster() throws POLLINGBusinessException
	{
		String flag = CommonConstants.FAILURE_ERROR;
		this.populateMenu();
		try {
			if(request.getSession().getAttribute("adminDetailDto") == null) {
				return "login";
			}
			AdminDetailDto adminDetailDto = new AdminDetailDto();
			adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
			
			batchMasterDtoList = this.getMasterDetailsServices().getBatchMasterDtoList(adminDetailDto);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		flag = CommonConstants.SUCCESS_FLAG;
		return flag;		
	}
	
	
	// Method to Save and Update batch Master data into batchMaster Table
	public String saveOrUpdateBatchMasterDto() throws Exception{
		
	        String flag = CommonConstants.FAILURE_ERROR; 
			
			Pattern p = Pattern.compile("^[a-zA-Z0-9][a-zA-Z0-9 ]+$", Pattern.CASE_INSENSITIVE);
			if(request.getSession().getAttribute("adminDetailDto") == null) {
				return "login";
			}
			AdminDetailDto adminDetailDto = new AdminDetailDto();
			adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
			
			Integer batchId = batchMasterDto.getOnum_slno();
			System.out.println("Batch ID : "+batchId);
			
			String batchName = batchMasterDto.getOstr_batch_name();
			System.out.println("Batch Name "+batchName);

			boolean batchNameFlag = p.matcher(batchName).find();
		    
		   if(batchName.equals("")){
		    	
		    	 System.out.println("Batch Name is null");
			    	
			       this.showBatchMaster();
			       
			       info = "Please Enter Batch Name";
			       
			       flag = CommonConstants.FAILURE_ERROR;
		    	
		    }
		    else if(batchNameFlag == false){
		    
		    	this.showBatchMaster();
		    	  
				info = "Please Enter Valid Batch Name";
				
				System.out.println("Scriptlet Characters are not allowed....");
		       
	           flag = CommonConstants.FAILURE_ERROR;
				
		    }
		    else if(batchId == null){
		    		 
		    		System.out.println("If batch ID is null...."); 
		    		
		    		
		    		List<BatchMasterDto> batchMasterDtosList = this.getMasterDetailsServices().checkAvailBatchMaster(batchName, adminDetailDto);
		    		System.out.println("List Size : "+batchMasterDtosList.size());
		    		 
				    if(batchMasterDtosList != null && batchMasterDtosList.size() > 0){
				    	
				    		this.showBatchMaster();
				    		
				    		batchMasterDto = new BatchMasterDto();
	    		
				    		info = "Batch Name Already Exist";
				    		
				    		System.out.println("Record is already exist");
				    		
				    		flag = CommonConstants.FAILURE_ERROR;
				    } else {
			            	
			            	System.out.println("batch Master");
				    		
			            	batchMasterDto.setOnum_is_active(1);
			            	batchMasterDto.setOdt_entry_date(new Date());
			            	batchMasterDto.setAdminDetailDto(adminDetailDto);
			            	
			            	this.getMasterDetailsServices().updateBatchMasterDto(batchMasterDto, adminDetailDto);
			            	
			            	this.showBatchMaster();
			            	batchMasterDto = null;
					 		info = "Batch details has been inserted successfully";					 		
					 		flag = CommonConstants.SUCCESS_FLAG; 				       
				    		
				    	}
		    	 } else {
		    		 List<BatchMasterDto> batchMasterDtosList = this.getMasterDetailsServices().getBatchMasterDtoList(adminDetailDto);
		            	Integer status = 0;
		            	if(batchMasterDtosList != null && batchMasterDtosList.size() > 0){
		            		
		            		for(BatchMasterDto dto : batchMasterDtosList){
		            			if(!(dto.getOnum_slno().equals(batchMasterDto.getOnum_slno()))) {
		            				if(dto.getOstr_batch_name().equals(batchMasterDto.getOstr_batch_name())){
		            					
		            					status = 1;
		            				}					            				
		            			}
		            		}					            		
		            	}
		            	
		            	if(status.equals(1)) {
		            		this.showBatchMaster();
		            		info = "Batch Name Already Exist";
		            		System.out.println("Record is already exist");							    		
				    		flag = CommonConstants.FAILURE_ERROR;
			           	} else {
		    		 
			           		batchMasterDto.setOnum_is_active(1);
			           		batchMasterDto.setOdt_entry_date(new Date());
			           		batchMasterDto.setAdminDetailDto(adminDetailDto);
			           		
			            	this.getMasterDetailsServices().updateBatchMasterDto(batchMasterDto, adminDetailDto);
			            	
			            	this.showBatchMaster();
			            	batchMasterDto = null;
					 		
			            	info = "Batch details has been updated successfully";
					     
			            	flag = CommonConstants.SUCCESS_FLAG;
			           	}
		    	 }
		    		
		    	
		    System.out.println(flag);
		    
			return flag;
		}
		
		
		// Method To edit batch Master Details
		public String editBatchMasterDetail() throws Exception{
			
			String flag = CommonConstants.ERROR_FLAG;
			
			try{
				if(request.getSession().getAttribute("adminDetailDto") == null) {
					return "login";
				}
				AdminDetailDto adminDetailDto = new AdminDetailDto();
				adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
				
				this.showBatchMaster();
				populateMenu();
				String batch_id = request.getParameter("slno");
				System.out.println("batch ID : "+batch_id);
				
				batchMasterDto = this.getMasterDetailsServices().findBatchMasterById(Integer.parseInt(batch_id), adminDetailDto);
	          
				flag = CommonConstants.SUCCESS_FLAG;
				
			}
			catch(Exception er){
				er.printStackTrace();
			}
			
			return flag;
		}
		
		// Method To delete batch Master Details
		public String deleteBatchMasterDetail() throws Exception{
				
				String flag = CommonConstants.ERROR_FLAG;
				
				try{
					
					if(request.getSession().getAttribute("adminDetailDto") == null) {
						return "login";
					}
					AdminDetailDto adminDetailDto = new AdminDetailDto();
					adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
					
					
					String slno = request.getParameter("slno");
					System.out.println("batch ID : "+slno);
					
					batchMasterDto = this.getMasterDetailsServices().findBatchMasterById(Integer.parseInt(slno), adminDetailDto);
				
					batchMasterDto.setOnum_is_active(0);
					batchMasterDto.setOdt_entry_date(new Date());
					
					this.getMasterDetailsServices().updateBatchMasterDto(batchMasterDto, adminDetailDto);
					
					batchMasterDto = null;
					info = "Batch details has been deleted successfully";
					this.showBatchMaster();
					flag = CommonConstants.SUCCESS_FLAG;
					
				}
				catch(Exception er){
					er.printStackTrace();
				}
				
				return flag;
			}
	
	// Admin service locater
	private IMasterDetailsServices getMasterDetailsServices () {
		Object serviceObj = ServiceLocator.getInstance().getService(com.oes.constants.CommonConstants.MASTER_DETAILS);
			return serviceObj == null ? null : (IMasterDetailsServices) serviceObj;
	}

}
