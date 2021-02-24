package com.oes.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.oes.action.common.Enums;
import com.oes.common.exception.POLLINGBusinessException;
import com.oes.constants.CommonConstants;
import com.oes.dto.NewsAndEventsDto;
import com.oes.service.INewsAndEventsServices;
import com.sms.admin.dto.AdminDetailDto;
import com.sms.util.ServiceLocator;
import com.opensymphony.xwork2.ActionSupport;

public class NewsAndEventsAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	static Connection con;
	static PreparedStatement st;
	static ResultSet rs;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private String messages;
	private NewsAndEventsDto newsAndEventsDto;
	private List<NewsAndEventsDto> newsAndEventsDtoList;
	private List<NewsAndEventsDto> checkAvailNewsAndEventsList;
	private String info;
	
	public List<NewsAndEventsDto> getCheckAvailNewsAndEventsList() {
		return checkAvailNewsAndEventsList;
	}
	public void setCheckAvailNewsAndEventsList(
			List<NewsAndEventsDto> checkAvailNewsAndEventsList) {
		this.checkAvailNewsAndEventsList = checkAvailNewsAndEventsList;
	}
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
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
	public NewsAndEventsDto getNewsAndEventsDto() {
		return newsAndEventsDto;
	}
	public void setNewsAndEventsDto(NewsAndEventsDto newsAndEventsDto) {
		this.newsAndEventsDto = newsAndEventsDto;
	}
	public List<NewsAndEventsDto> getNewsAndEventsDtoList() {
		return newsAndEventsDtoList;
	}
	public void setNewsAndEventsDtoList(List<NewsAndEventsDto> newsAndEventsDtoList) {
		this.newsAndEventsDtoList = newsAndEventsDtoList;
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
	



	// TO show NewAndEvents page
	public String showNewsAndEvents() throws POLLINGBusinessException
	{
		String flag = CommonConstants.FAILURE_ERROR; 
		this.populateMenu();
		try {
			System.out.println("Enter in showNewsAndEvents action");
			
			newsAndEventsDtoList = new ArrayList<NewsAndEventsDto>();
			newsAndEventsDtoList = this.getNewsAndEventsServices().getNewsAndEventsDto(newsAndEventsDto);
			System.out.println(newsAndEventsDtoList.size());
			flag = CommonConstants.SUCCESS_FLAG;
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("helloooooooooo");
		return flag;		
	}	
	
	// Method to Save and Update Role Master data into RoleMaster Table
	public String saveNewsAndEvents() throws POLLINGBusinessException{
			
		this.populateMenu();
				System.out.println("hello 1");
		        String flag = CommonConstants.FAILURE_ERROR;
		        if(request.getSession().getAttribute("adminDetailDto") == null) {
					return "login";
				}
				AdminDetailDto adminDetailDto = new AdminDetailDto();
				adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
				
		        Pattern p = Pattern.compile("^[a-z0-9@._,&:-]", Pattern.CASE_INSENSITIVE);
			    String headline = newsAndEventsDto.getGstr_headline();
			    String content = newsAndEventsDto.getGstr_content();
			    String gnum_slno = request.getParameter("newsAndEventsDto.gnum_slno");
			    Matcher headlineDesc = p.matcher(headline); 
			    boolean name = headlineDesc.find();
			    Matcher contentDesc = p.matcher(content);
			    boolean desciption = contentDesc.find();
			    
			    if(headline!=null && content!=null){
				  if(name == false){
					  showNewsAndEvents();
					  info = "<div class='message error'><h5>Error!</h5><p>Scriptlet Characters are not allowed</p></div>";
				      flag = CommonConstants.FAILURE_ERROR;
				  } else {
			    	if(desciption == false){
			    		showNewsAndEvents();
			    		info = "<div class='message error'><h5>Error!</h5><p>Scriptlet Characters are not allowed</p></div>";
			    		flag = CommonConstants.FAILURE_ERROR;
			    	} else {
			    		if(gnum_slno.equals("")) {
			    			 checkAvailNewsAndEventsList = this.getNewsAndEventsServices().checkAvailNewsAndEvents(headline);
			    		    	if(checkAvailNewsAndEventsList!=null && checkAvailNewsAndEventsList.size()>0){
						    	
						    		showNewsAndEvents();
						    		newsAndEventsDto = new NewsAndEventsDto();
         				    	    info = "<div class='message error'><h5>Error!</h5><p>Record is already exist, Try Again</p></div>";
						    		flag = CommonConstants.FAILURE_ALREADY_EXIST;
						    	} else {
			        		    	newsAndEventsDto.setGnum_is_active(1);
			        		    	newsAndEventsDto.setAdminDetailDto(adminDetailDto);
					 		 		this.getNewsAndEventsServices().updateNewsAndEventsDto(newsAndEventsDto);
					 		    	newsAndEventsDtoList = null;
					 		    	newsAndEventsDtoList = this.getNewsAndEventsServices().getNewsAndEventsDto(newsAndEventsDto);
					 		    	newsAndEventsDto = new NewsAndEventsDto();
					 		    	showNewsAndEvents();
					 		    	info = "<div class='message success'><h5>Success!</h5><p>Record Insert successfully.</p></div>";
						            flag = CommonConstants.SUCCESS_FLAG;
						    	}
					    	
					 	 } else {
						  		 newsAndEventsDto.setGnum_is_active(1);  
						  		 newsAndEventsDto.setAdminDetailDto(adminDetailDto);
					             newsAndEventsDtoList = this.getNewsAndEventsServices().getNewsAndEventsDto(newsAndEventsDto);
					             this.getNewsAndEventsServices().updateNewsAndEventsDto(newsAndEventsDto);
					             showNewsAndEvents();
					   	         info = "<div class='message success'><h5>Success!</h5><p>Record Has been updated successfully.</p></div>";
					             newsAndEventsDto = new NewsAndEventsDto();
					      		 flag = CommonConstants.SUCCESS_FLAG;
			    		 }
			    	 }
			      }
			   } else {
				      newsAndEventsDto = null;
			          showNewsAndEvents();
			          info = "<div class='message error'><h5>Error!</h5><p>Try Again Because Values are Null.</p></div>";
			          flag = CommonConstants.FAILURE_ERROR;
			  }
			  return flag;
	}
	
	public String editNewsAndEvents() throws Exception
	{
		this.populateMenu();
		String  flag = CommonConstants.FAILURE_ERROR;
		if(request.getSession().getAttribute("username") == null) {
			return "login";
		}
    	System.out.println("Edit Role Master");
		String slno_id =  request.getParameter("slno");
		Integer slno = Integer.parseInt(slno_id);
		System.out.println("Role Id is "+slno);
		newsAndEventsDto = new NewsAndEventsDto();
		newsAndEventsDto = this.getNewsAndEventsServices().findNewsAndEventsById(slno);
		System.out.println("End Method");
		flag = CommonConstants.SUCCESS_FLAG; 
		showNewsAndEvents();  
		return flag;
		
	}
	
	public String showNewsPannel() throws Exception
	{
		
		String  flag = CommonConstants.FAILURE_ERROR;
    	String slno_id =  request.getParameter("slno");
		Integer slno = Integer.parseInt(slno_id);
		newsAndEventsDto = new NewsAndEventsDto();
		newsAndEventsDto = this.getNewsAndEventsServices().findNewsAndEventsById(slno);
		request.getSession().setAttribute("newsAndEventsDto", newsAndEventsDto);
		flag = CommonConstants.SUCCESS_FLAG; 
		return flag;
		
	}
	
	public String deleteNewsAndEventsInfo() throws Exception{
		   
		this.populateMenu();
		   String  flag = CommonConstants.FAILURE_ERROR;
		   if(request.getSession().getAttribute("username") == null) {
				return flag;
		   }
		   Integer slno = Integer.parseInt(request.getParameter("slno"));
		   newsAndEventsDto =  this.getNewsAndEventsServices().findNewsAndEventsById(slno);
		   newsAndEventsDto.setGnum_is_active(Enums.AdminStatus.NO.ordinal());
		   System.out.println("Delete Flag is "+Enums.AdminStatus.NO.ordinal());
		   this.getNewsAndEventsServices().updateNewsAndEventsDto(newsAndEventsDto);
		   info = "<div class='message success'><h5>Success!</h5><p>Record has been deleted</p><div>";
		   newsAndEventsDto = new NewsAndEventsDto();
		   showNewsAndEvents();
		   flag = CommonConstants.SUCCESS_FLAG;
		   return flag ;
	   }
			
	
	private INewsAndEventsServices getNewsAndEventsServices(){
		Object serviceObj = ServiceLocator.getInstance().getService(CommonConstants.NEWS_AND_EVENTS);
				return serviceObj == null ? null
				: (INewsAndEventsServices) serviceObj;
	}
	
}	