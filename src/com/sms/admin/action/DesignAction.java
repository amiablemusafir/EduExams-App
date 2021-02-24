package com.sms.admin.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.oes.dto.ContentDetailsDto;
import com.oes.service.IMasterDetailsServices;
import com.opensymphony.xwork2.ActionSupport;
import com.sms.util.ServiceLocator;

public class DesignAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public String execute(){
		
		if(request.getSession().getAttribute("adminDetailDto") == null) {
			return "login";
		}
		return SUCCESS;
	}
	
	public String showDesignPage() throws Exception {
		return SUCCESS;
	}
	
	public String designPage() throws Exception {
		if(request.getSession().getAttribute("contentDetailsDtoList") == null) {
			List<ContentDetailsDto> contentDetailsDtoList = new ArrayList<ContentDetailsDto>();
			contentDetailsDtoList = this.getMasterDetailsServices().getContentDetailsDtoList();
			request.getSession().setAttribute("contentDetailsDtoList", contentDetailsDtoList);
		}
		return SUCCESS;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response; 
		
	}
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		
	}
	// Admin service locater
	private IMasterDetailsServices getMasterDetailsServices () {
		Object serviceObj = ServiceLocator.getInstance().getService(com.oes.constants.CommonConstants.MASTER_DETAILS);
			return serviceObj == null ? null : (IMasterDetailsServices) serviceObj;
	}
}
