package com.sms.admin.action;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;



import com.sms.admin.dto.PermissionMasterDto;
import com.sms.admin.dto.RoleMasterDto;
import com.sms.admin.dto.RolePermissionMasterDto;
import com.sms.admin.service.IAdminService;
import com.sms.admin.service.IPermissionMasterServices;
import com.sms.admin.service.IRoleMasterServices;
import com.sms.admin.service.IRolePermissionService;
import com.sms.common.Enums;
import com.sms.common.exception.IHMSException;
import com.sms.constants.CommonConstants;
import com.sms.util.ServiceLocator;
import com.opensymphony.xwork2.ActionSupport;


public class RolePermissionMasterAction extends ActionSupport implements ServletRequestAware, ServletResponseAware{

	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private String messages;
	private RolePermissionMasterDto rolePermissionMasterDto; 
	private PermissionMasterDto permissionMasterDto;
	private RoleMasterDto roleMasterDto;
	private List<RoleMasterDto> roleMasterList;
	private List permissionMasterList;
	private List rolePermissionMasterList;
	private List<RolePermissionMasterDto> rolePermissionMasterNameList;
	private List<RolePermissionMasterDto> rolePermissionMasterDtoList;
	private String error_info;
	
	private AdminCommonAction adminCommonAction = new AdminCommonAction();
	
	
	
	
	
	public String getError_info() {
		return error_info;
	}


	public void setError_info(String error_info) {
		this.error_info = error_info;
	}


	public RolePermissionMasterDto getRolePermissionMasterDto() {
		return rolePermissionMasterDto;
	}


	public void setRolePermissionMasterDto(
			RolePermissionMasterDto rolePermissionMasterDto) {
		this.rolePermissionMasterDto = rolePermissionMasterDto;
	}


	public List<RoleMasterDto> getRoleMasterList() {
		return roleMasterList;
	}


	public void setRoleMasterList(List<RoleMasterDto> roleMasterList) {
		this.roleMasterList = roleMasterList;
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
	
	public String showRolePermissionMasterForm() throws Exception
	{
		String flag = CommonConstants.FAILURE_ERROR;
		populateMenu();
		System.out.println(" Show Role Permission Master Action");
		
		rolePermissionMasterDto = new RolePermissionMasterDto();
		
		roleMasterList = this.getRoleMasterServices().getRoleMasterDto(roleMasterDto);
		
		flag = CommonConstants.SUCCESS_FLAG;
		
		return flag;
		
	}
	
	
	// method to populate Role Permission Boxes
	public void getRolePermissionBoxes() throws IHMSException 
	{
		
		System.out.println("Role Permission boxes Action");
		
		String DropDownMode = request.getParameter("SelectMode");
		String stateOption = "";
		String searchId = request.getParameter("searchBy");
		System.out.println("SearchId = "+searchId);
		System.out.println("DropDownMode is "+DropDownMode);
		
		if (DropDownMode.equalsIgnoreCase("permissionName")) {
			if (searchId != null && searchId != "") {
			
			System.out.println("PermissionName");	
			permissionMasterList =	this.getRolePermissionMasterServices().findLeftList(Integer.parseInt(searchId));
			System.out.println("permissionMasterListsize is "+permissionMasterList.size());
			rolePermissionMasterList = this.getRolePermissionMasterServices().findRightList(Integer.parseInt(searchId));
			System.out.println("rolePermissionMasterListsize is "+rolePermissionMasterList.size());
			String optionLeftList = "<select name='rolePermissionMasterDto.leftList' multiple='true' style='height:190px;width:300px'>";
				for (int u = 0; u < permissionMasterList.size(); u++) {
					Map permissionDetailMap = (HashMap) permissionMasterList.get(u);
					optionLeftList += "<option value="
							+ permissionDetailMap.get("inum_permission_id")
									.toString()
							+ ">"
							+ permissionDetailMap.get("istr_permission_name")
									.toString() + "</option>";
				}
				optionLeftList += "</select>";
				
				
				
				
				String optionRightList = "<select name='rolePermissionMasterDto.rightList' multiple='true' style='height:190px;width:300px'>";
				for (int u = 0; u < rolePermissionMasterList.size(); u++) {
					Map permissionDetailMap = (HashMap) rolePermissionMasterList.get(u);
					optionRightList += "<option value="
							+ permissionDetailMap.get("inum_permission_id")
									.toString()
							+ ">"
							+ permissionDetailMap.get("istr_permission_name")
									.toString() + "</option>";
				}
				optionRightList += "</select>";

				stateOption = optionLeftList + "^" + optionRightList;
				System.out.println("stateoption"+stateOption);
			}
     	  }
		
		response.setContentType("text/html");
		response.setHeader("Cache-Control", "no-cache");
		try {

			response.getWriter().write(stateOption);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}


		}
		
		
	//to save role permission master data
	
		public String saveRolePermissionMasterDetail() throws Exception
		{
			String flag = CommonConstants.FAILURE_ERROR;
			
			System.out.println("Save Role Permission Master Action...");
			populateMenu();
			int role_id = rolePermissionMasterDto.getRoleMasterDto().getInum_role_id();
			
			System.out.println("Role id = "+role_id);
			
			if(role_id == 0){
				
				System.out.println("Role Id is Zero");
			
	            messages = "Please select role";//"Try Again, Atleast shift one permission";
				
	            this.showRolePermissionMasterForm();
	            
				flag = CommonConstants.INPUT_FLAG;
			
				
			}
			else{
		
			try{	
			
			   rolePermissionMasterNameList = this.getRolePermissionMasterServices().findPermissionByRole(role_id);
			   System.out.println("Size = "+rolePermissionMasterNameList.size());
			   if(rolePermissionMasterNameList!= null && rolePermissionMasterNameList.size()>0){
				   for(RolePermissionMasterDto rolePermissionrDto: rolePermissionMasterNameList){
					   System.out.println("id is "+rolePermissionrDto.getInum_role_permission_id());
					   this.getRolePermissionMasterServices().deleteRolePermissionMasterDetails(rolePermissionrDto);
					   error_info = "Role Permission has been shifted successfully";
				   }
			   }
			   
			   String chosenitem[] = rolePermissionMasterDto.getStrChosenitems().replace("@", "#").split("#");
			   System.out.println("Chosenitem length = "+chosenitem.length);
			   for(int i=0;i<chosenitem.length;i++ ){
				   
				   String dataElement=chosenitem[i];
				   
				   
				   rolePermissionMasterDto.setInum_user_id(Enums.MasterStatus.INACTIVE.ordinal());
				   rolePermissionMasterDto.setInum_is_active(Enums.MasterStatus.ACTIVE.ordinal());
				   rolePermissionMasterDto.setIdt_entry_date(new Date());
				   System.out.println("Date has been filled");
				   
				   if(rolePermissionMasterDto.getRoleMasterDto()==null){
					   
					   rolePermissionMasterDto.setRoleMasterDto(new RoleMasterDto());
					   rolePermissionMasterDto.getRoleMasterDto().setInum_role_id(role_id);
					   
				   }
				   
				   System.out.println("Conti...1");
				   rolePermissionMasterDto.setPermissionMasterDto(new PermissionMasterDto());
				   rolePermissionMasterDto.getPermissionMasterDto().setInum_permission_id(Integer.parseInt(chosenitem[i]));
				    this.getRolePermissionMasterServices().saveRolePermissionMasterDetails(rolePermissionMasterDto);
				    error_info = "Role Permission has been shifted";
					rolePermissionMasterDto = new RolePermissionMasterDto();
	     
					 System.out.println("Conti...2");
			   }
   
			   System.out.println("Method End......");
			  
			   
		
			}
			catch(Exception e){
				e.printStackTrace();
			}
		
			 this.showRolePermissionMasterForm();
				flag = CommonConstants.SUCCESS_FLAG;
			
			
			}
			
			return flag;
		}
		
		
    
      
   // Admin Master service locater
  	private IAdminService getAdminManagementServices(){
  		Object serviceObj = ServiceLocator.getInstance().getService(
  				CommonConstants.ADMIN_MANAGEMENT_SERVICE);
  		return serviceObj == null ? null
  				: (IAdminService) serviceObj;
  	}
	
	
	// Role Master service locater
			private IRoleMasterServices getRoleMasterServices(){
				Object serviceObj = ServiceLocator.getInstance().getService(
						CommonConstants.ROLE_MASTER_SERVICES);
				return serviceObj == null ? null
						: (IRoleMasterServices) serviceObj;
			}
	
			
			// Permission Master service locater
						private IPermissionMasterServices getPermissionMasterServices(){
							Object serviceObj = ServiceLocator.getInstance().getService(
									CommonConstants.PERMISSION_MASTER_SERVICES);
							return serviceObj == null ? null
									: (IPermissionMasterServices) serviceObj;
						}
					
			
	// Role Permission Master service locater
			private IRolePermissionService getRolePermissionMasterServices(){
				Object serviceObj = ServiceLocator.getInstance().getService(
						CommonConstants.ROLE_PERMISSION_SERVICE);
				return serviceObj == null ? null
						: (IRolePermissionService) serviceObj;
			}
	
}
