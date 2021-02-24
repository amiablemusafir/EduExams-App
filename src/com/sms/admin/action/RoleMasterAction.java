package com.sms.admin.action;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.sms.admin.dto.RoleMasterDto;
import com.sms.admin.service.IRoleMasterServices;
import com.sms.common.Enums;
import com.sms.common.exception.IHMSException;
import com.sms.constants.CommonConstants;
import com.sms.util.ServiceLocator;
import com.opensymphony.xwork2.ActionSupport;

public class RoleMasterAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private String messages;
	private RoleMasterDto roleMasterDto;
	private List<RoleMasterDto> roleMasterDtoList;
	private List<RoleMasterDto> checkAvailRoleList;
	private String info;
	private String role_desc;
	private String role_name;
	
	
	
	
	
	public String getInfo() {
		return info;
	}


	public void setInfo(String info) {
		this.info = info;
	}


	public RoleMasterDto getRoleMasterDto() {
		return roleMasterDto;
	}


	public void setRoleMasterDto(RoleMasterDto roleMasterDto) {
		this.roleMasterDto = roleMasterDto;
	}


	public List<RoleMasterDto> getRoleMasterDtoList() {
		return roleMasterDtoList;
	}


	public void setRoleMasterDtoList(List<RoleMasterDto> roleMasterDtoList) {
		this.roleMasterDtoList = roleMasterDtoList;
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
	
	
	
	
	public String getRole_desc() {
		return role_desc;
	}


	public void setRole_desc(String role_desc) {
		this.role_desc = role_desc;
	}


	public String getRole_name() {
		return role_name;
	}


	public void setRole_name(String role_name) {
		this.role_name = role_name;
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
	// TO show RoleMaster page
		public String showRoleMaster() throws IHMSException
		{
			String flag = CommonConstants.FAILURE_ERROR; 
			
			System.out.println("Enter in ShowRoleMaster action");
			populateMenu();
			messages ="Role Master Insert/Update";
			
			   roleMasterDtoList = null;
			
			   roleMasterDtoList = this.getRoleMasterServices().getRoleMasterDto(roleMasterDto);
			   
			//   roleMasterDto = new RoleMasterDto();
			
			flag = CommonConstants.SUCCESS_FLAG;
			
			return flag;
			
		}
		
		// Method to Save and Update Role Master data into RoleMaster Table
		public String saveRoleMaster() {
		System.out.println("saveRoleMaster...........>");
			
	        String flag = CommonConstants.FAILURE_ERROR; 
	        try
			{
			System.out.println("Enter in UpdateRoleMaster action");
			populateMenu();
			Pattern p = Pattern.compile("^[a-z0-9@._,&:-]", Pattern.CASE_INSENSITIVE);
			
		    String rolename = roleMasterDto.getIstr_role_name();
		    
		    System.out.println("Role Name : "+rolename);
		    
		    String roleDesc = roleMasterDto.getIstr_role_desc();
		   
		    System.out.println("Role Description : "+roleDesc);
		    
		    String pnum_role_id = request.getParameter("roleMasterDto.inum_role_id");
		    
		    System.out.println("Role ID : "+pnum_role_id);
		    
		    Matcher roleName = p.matcher(rolename); 
		    
		    boolean name = roleName.find();
		    
		     Matcher roledesc = p.matcher(roleDesc);
		     
		    boolean desciption = roledesc.find();
		    
		    
		    // if role name and role description are null
		    if(rolename.equals("")){
		    	
		    	 System.out.println("Role name is null OR Role Desc is null");
			    	
			       showRoleMaster();
			       
			       role_name = "Please enter Role Name";
			       
			       flag = CommonConstants.FAILURE_ERROR;
		    	
		    }
		    else if(name == false){
		    
		    	  showRoleMaster();
		    	  
				role_name = "Please enter valid Role Name";
				
				System.out.println("Scriptlet Characters are not allowed....");
		       
	           flag = CommonConstants.FAILURE_ERROR;
				
		       }
		       else if(pnum_role_id.equals("") || pnum_role_id == null || pnum_role_id.equals(null)){
		    		 
		    		System.out.println("ROle ID is null...."); 
		    		
		    		 checkAvailRoleList = this.getRoleMasterServices().checkAvailRoleMaster(rolename);
				    	
		    		 System.out.println("List Size : "+checkAvailRoleList.size());
		    		 
				    	if(checkAvailRoleList != null && checkAvailRoleList.size() > 0){
				    	
				    		showRoleMaster();
				    		
				    		roleMasterDto = new RoleMasterDto();
	    		
				    		info = "Role Name Already Exist";
				    		
				    		System.out.println("Record is already exist");
				    		
				    		flag = CommonConstants.FAILURE_ALREADY_EXIST;
				    	}
			            else
			            {
			            	
			            	System.out.println("Save Role Master");
				    		
				    		roleMasterDto.setInum_is_active(Enums.MasterStatus.ACTIVE.ordinal());
					 		
					 		this.getRoleMasterServices().updateRoleMasterDto(roleMasterDto);
					 		
					 		
					    	roleMasterDtoList = null;
					 		
					 		roleMasterDtoList = this.getRoleMasterServices().getRoleMasterDto(roleMasterDto);
					 		
					 		roleMasterDto = new RoleMasterDto();
						
					 		showRoleMaster();
					 		
					 		info = "Record Update successfully";
					 		
					 	
					 		flag = CommonConstants.SUCCESS_FLAG; 				       
				    		
				    	}
				 
		    		 
		    	 }
		    	 else{
		    		 
		    		 // if Role Id is not null
		    		 
		    		 System.out.println("Updates Role Master");
		    		
		    		 System.out.println("pnum_role_id is "+pnum_role_id);
		    		 
				      roleMasterDto.setInum_is_active(Enums.MasterStatus.ACTIVE.ordinal());  
				    
				      this.getRoleMasterServices().updateRoleMasterDto(roleMasterDto);
				      
				      roleMasterDtoList = this.getRoleMasterServices().getRoleMasterDto(roleMasterDto);
				      
				      showRoleMaster();
				
				      info = "Role has been updated successfully";
				      
				      roleMasterDto = new RoleMasterDto();
				      
				      System.out.println("End Update Role Master");
				      
		    		 
		    		 flag = CommonConstants.SUCCESS_FLAG;
		    		 
		    	 }
		    		
			}
	        catch
	        (Exception e)
	        {
	        	e.printStackTrace();
	        }
		    System.out.println(flag);
		    
			return flag;
		}
		
		
		// Edit Role Master details
		public String editRoleMasterDetail() throws Exception
		{
			
			String  flag = CommonConstants.FAILURE_ERROR;
			populateMenu();
			System.out.println("Edit Role Master");
			
			    String role_id =  request.getParameter("role_id");
			    
			    Integer roleId = Integer.parseInt(role_id);
			   
			    System.out.println("Role Id is "+roleId);
			    
			     roleMasterDto = new RoleMasterDto();
			  
			     roleMasterDto = this.getRoleMasterServices().findRoleMasterById(roleId);
			
			     System.out.println("End Method");
			     
			     flag = CommonConstants.SUCCESS_FLAG; 
			     
			     showRoleMaster();  
			     
			return flag;
			
		}
		
	
	// Delete Role Details Action	
	   public String deleteRoleMasterInfo() throws Exception{
		   
		   String  flag = CommonConstants.FAILURE_ERROR;
			
		    System.out.println("Delete Record from Role Master.....");
		    populateMenu();
		    Integer roleId = Integer.parseInt(request.getParameter("role_id"));
		    
		    System.out.println("Role Id is "+roleId);
		    
		       roleMasterDto =  this.getRoleMasterServices().findRoleMasterById(roleId);
		       
		       roleMasterDto.setInum_is_active(Enums.MasterStatus.INACTIVE.ordinal());
		       
		       this.getRoleMasterServices().updateRoleMasterDto(roleMasterDto);
		      
		      info = "Role has been deleted successfully";
		       
		      roleMasterDto = new RoleMasterDto();
		       
		    showRoleMaster();
		      
		   System.out.println("End Delete Role Master");
		      
			flag = CommonConstants.SUCCESS_FLAG;
			
		    return flag ;
	   }
		
	
	// service locater
		private IRoleMasterServices getRoleMasterServices(){
			Object serviceObj = ServiceLocator.getInstance().getService(
					CommonConstants.ROLE_MASTER_SERVICES);
			return serviceObj == null ? null
					: (IRoleMasterServices) serviceObj;
		}
}
