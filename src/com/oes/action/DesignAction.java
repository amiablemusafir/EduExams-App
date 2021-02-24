package com.oes.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.oes.action.common.CaptchaClass;
import com.opensymphony.xwork2.ActionSupport;

public class DesignAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	private HttpServletRequest request;
	private HttpServletResponse response;
	
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
	
	
	public String execute(){
		
		this.populateMenu();
		if(request.getSession().getAttribute("username") == null) {
			return "login";
		}
		return SUCCESS;
	}
	
	public String designPage(){
		
		this.populateMenu();
		return SUCCESS;
	}
	
	public String showCaptcha() {
		
		CaptchaClass cClass = new CaptchaClass();
		try {
		
			cClass.processRequest(request, response);
		
		} catch (Exception e) {
			//e.printStackTrace();
		} 
		return SUCCESS;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response; 
		
	}
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		
	}
}
