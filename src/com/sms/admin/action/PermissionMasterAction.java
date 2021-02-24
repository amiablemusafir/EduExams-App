package com.sms.admin.action;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;



import com.sms.admin.dto.PermissionMasterDto;
import com.sms.admin.service.IPermissionMasterServices;
import com.sms.common.Enums;
import com.sms.common.exception.IHMSException;
import com.sms.constants.CommonConstants;
import com.sms.util.ServiceLocator;
import com.opensymphony.xwork2.ActionSupport;

public class PermissionMasterAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private String messages;
	private List<PermissionMasterDto> permissionMasterDtoList;
	private PermissionMasterDto permissionMasterDto;
	private List<PermissionMasterDto> checkAvailPermissionList;
	private String info;

	

	
	
	
	public String getInfo() {
		return info;
	}


	public void setInfo(String info) {
		this.info = info;
	}


	public List<PermissionMasterDto> getPermissionMasterDtoList() {
		return permissionMasterDtoList;
	}


	public void setPermissionMasterDtoList(
			List<PermissionMasterDto> permissionMasterDtoList) {
		this.permissionMasterDtoList = permissionMasterDtoList;
	}


	public PermissionMasterDto getPermissionMasterDto() {
		return permissionMasterDto;
	}


	public void setPermissionMasterDto(PermissionMasterDto permissionMasterDto) {
		this.permissionMasterDto = permissionMasterDto;
	}


	public String getMessages() {
		return messages;
	}


	public void setMessages(String messages) {
		this.messages = messages;
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
	
	// TO show PermissionMaster page
		public String showPermissionMaster() throws Exception{
			
			String flag = CommonConstants.FAILURE_ERROR;
			
			System.out.println(" Permission Insert/Update ");
			
			try{
				populateMenu();
				 permissionMasterDtoList =  this.getPermissionMasterServices().getPermissionMasterDto();
				  
				 System.out.println("....."+permissionMasterDtoList.get(0).getIstr_permission_name());
				   
				flag = CommonConstants.SUCCESS_FLAG;
		
				
			}
			catch(Exception er){
				er.printStackTrace();
			}
				
			return flag;
			
		}
		
		
		// show Parent Permission Combo
		public void showParentPermissionCombo() throws Exception{
			
			System.out.println("Show Parent Permission Combo");
			
			try{
				
				StringBuffer sbBuffer = new StringBuffer();
				
				String is_parent = request.getParameter("is_parent");
				 
				System.out.println("Is Parent : "+is_parent);
			
				if(!is_parent.equals("")){
					
					sbBuffer.append("<td><div align='right'><label for='Parent Permission'>Parent Permission:</label></div></td>");
					
					sbBuffer.append("<td><div class='styled-select2'>");
					
					sbBuffer.append("<select name='permissionMasterDto.inum_parent_permission_id' id='parent_permission_id'>");
					
					sbBuffer.append("<option value='0'>Select Parent</option>");
					
				    permissionMasterDtoList = this.getPermissionMasterServices().getParentPermissionName();
					
				    System.out.println("Permission Master List : "+permissionMasterDtoList.size());
				    
				    if(permissionMasterDtoList!=null && permissionMasterDtoList.size()>0){
				    	
				    	for(PermissionMasterDto permissionMasterDto : permissionMasterDtoList){
				    		
				    		System.out.println("Permission Name : "+permissionMasterDto.getIstr_permission_name());
				    		
				    		sbBuffer.append("<option value='"+permissionMasterDto.getInum_permission_id()+"'>"+permissionMasterDto.getIstr_permission_name()+"</option>");	
				    		
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
		
		
		// Method to save and Update Permission Master Data
		public String savePermissionMasterInfo() throws Exception
		{
			String flag = CommonConstants.FAILURE_ERROR;
			populateMenu();
			System.out.println("Enter in Save Permission Master Action");
			
			String permissionName = permissionMasterDto.getIstr_permission_name();
			String permissionDesc = permissionMasterDto.getIstr_permission_desc();
			String permissionUrl = permissionMasterDto.getIstr_permission_url();
			Integer pnum_permission_id = permissionMasterDto.getInum_parent_permission_id();
			//String pnum_permission_id = request.getParameter("permissionMasterDto.inum_permission_id");
			
			Pattern p = Pattern.compile("^[a-z0-9@._,&:-]", Pattern.CASE_INSENSITIVE);
			Matcher permissionname =  p.matcher(permissionName);
			Matcher permissiondesc = p.matcher(permissionDesc);
			 
			boolean name = permissionname.find();
			boolean description = permissiondesc.find();
			
			System.out.println(permissionName);
			System.out.println(permissionDesc);
			System.out.println(permissionUrl);
			System.out.println(pnum_permission_id);
			 
			if(permissionName.equals("")) {
				
				info = "Please enter valid Permission Detail";
				System.out.println("name and desc should not be null");
					   	
				showPermissionMaster();
				flag = CommonConstants.FAILURE_ERROR;
			} else if(name == false) {
				
			    info = "Scriptlet Characters are not allowed";
			    System.out.println("Scriptlet Characters are not allowed....");
				showPermissionMaster();
				flag = CommonConstants.FAILURE_ERROR;
						
			} else if(pnum_permission_id.equals("")) {
				
				System.out.println("Save Permission Detail");
				System.out.println("pnum_permission_id is "+pnum_permission_id);
				Integer count =  this.getPermissionMasterServices().checkAvailPermissionMaster(permissionName);
									    	
				if(!count.toString().equals("0")) {
								    	
					showPermissionMaster();
					info = "Permission Name Already Exist";	
					permissionMasterDto = new PermissionMasterDto();
					flag = CommonConstants.FAILURE_ALREADY_EXIST;
			
				} else {
								    		
					System.out.println("Save Permission Action");
					try {
		    			permissionMasterDto.setInum_is_active(Enums.MasterStatus.ACTIVE.ordinal());
		    			permissionMasterDto.setInum_parent_permission_id(0);
			    		this.getPermissionMasterServices().savePermissionMasterDto(permissionMasterDto);
						showPermissionMaster();		    				
							  
						info = "Permission has been inserted Successfully";
						permissionMasterDto = new PermissionMasterDto();
						System.out.println("Permission Record Successfully insert");
										    			 
						flag = CommonConstants.SUCCESS_FLAG;
		    				
		    		} catch(Exception er) {
		    			er.printStackTrace();
		    		}
				}	
			} else {
				System.out.println("Updates Permisssion Action");
				try {
					System.out.println("pnum_permission_id is "+pnum_permission_id);
					permissionMasterDto.setInum_is_active(Enums.MasterStatus.ACTIVE.ordinal());
					this.getPermissionMasterServices().savePermissionMasterDto(permissionMasterDto);
					showPermissionMaster();
					info = "Permission has been updated Successfully";
					permissionMasterDto = new PermissionMasterDto();
					flag = CommonConstants.SUCCESS_FLAG;
				} catch(Exception er) {
					er.printStackTrace();
				}
			}
			System.out. println("Flag : "+flag);
			return flag;
		}
		
	
		// Edit Permission Master details
		public String editPermissionMasterDetail() throws Exception
		{
					
					String  flag = CommonConstants.FAILURE_ERROR;
					populateMenu();
					System.out.println("Edit Permission Master");
					
					 try{
					    
					    Integer permissionId = Integer.parseInt(request.getParameter("permission_id"));
					   
					    System.out.println("Permission Id is "+permissionId);
					    
					    permissionMasterDto = new PermissionMasterDto();
					  
					    showPermissionMaster(); 
					    
					   
					    
					    permissionMasterDto = this.getPermissionMasterServices().findPermissionMasterById(permissionId);
					    
					    System.out.println("End Method");  
					    flag = CommonConstants.SUCCESS_FLAG; 
					    }
					    catch(Exception e){
					    
					    	System.out.println(e);
					    	
					    }
					   
					return flag;
					
				}
				
	  
	    // Delete Permission Master Details Action			
		public String deletePermissionMasterDetails() throws Exception 
		{
            String  flag = CommonConstants.FAILURE_ERROR;
	    	
			System.out.println("Delete Permission Master Details");
			
			try{
				populateMenu();
				    Integer permissionId = Integer.
				    		parseInt(request.getParameter("permission_id"));
				   
				    System.out.println("Permission Id is "+permissionId);
				    
				    permissionMasterDto = new PermissionMasterDto();
				  
				    permissionMasterDto = this.
				    		getPermissionMasterServices().
				    		findPermissionMasterById(permissionId);
				    
		            permissionMasterDto.
		            setInum_is_active(Enums.MasterStatus.INACTIVE.ordinal());
					
		            this.
		            getPermissionMasterServices().
		            savePermissionMasterDto(permissionMasterDto);
		            
		            info = "Permission detail has been deleted";
				    
		            permissionMasterDto = new PermissionMasterDto();
		            
		            showPermissionMaster();
		            
					flag = CommonConstants.SUCCESS_FLAG; 
				
			}
			catch(Exception er){
				
			er.printStackTrace();	
				
			}
			
		   
		      
		return flag;
			
		}
	
	
	
	// service locater
			private IPermissionMasterServices getPermissionMasterServices(){
				Object serviceObj = ServiceLocator.getInstance().getService(
						CommonConstants.PERMISSION_MASTER_SERVICES);
				return serviceObj == null ? null
						: (IPermissionMasterServices) serviceObj;
			}
		
	
}
