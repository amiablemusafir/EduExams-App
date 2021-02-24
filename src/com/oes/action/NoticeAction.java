package com.oes.action;

import java.util.Date;
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
import com.oes.dto.NoticeDto;
import com.oes.service.INoticeServices;
import com.sms.admin.dto.AdminDetailDto;
import com.sms.util.ServiceLocator;
import com.opensymphony.xwork2.ActionSupport;


public class NoticeAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private String messages;
	private NoticeDto noticeDto;
	private List<NoticeDto> noticeDtoList;
	private List<NoticeDto> checkAvailNoticeList;
	private String info;
	
	public String getMessages() {
		return messages;
	}


	public void setMessages(String messages) {
		this.messages = messages;
	}


	public NoticeDto getNoticeDto() {
		return noticeDto;
	}


	public void setNoticeDto(NoticeDto noticeDto) {
		this.noticeDto = noticeDto;
	}


	public List<NoticeDto> getNoticeDtoList() {
		return noticeDtoList;
	}


	public void setNoticeDtoList(List<NoticeDto> noticeDtoList) {
		this.noticeDtoList = noticeDtoList;
	}


	public List<NoticeDto> getCheckAvailNoticeList() {
		return checkAvailNoticeList;
	}


	public void setCheckAvailNoticeList(List<NoticeDto> checkAvailNoticeList) {
		this.checkAvailNoticeList = checkAvailNoticeList;
	}


	public String getInfo() {
		return info;
	}


	public void setInfo(String info) {
		this.info = info;
	}
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	public void setServletRequest(HttpServletRequest request) {
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
	
	public String showNoticDetails() throws POLLINGBusinessException
	{
		
		String flag = CommonConstants.FAILURE_ERROR;
		this.populateMenu();
		if(request.getSession().getAttribute("adminDetailDto") == null) {
			return "login";
		}
		AdminDetailDto adminDetailDto = new AdminDetailDto();
		adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
				
		System.out.println("Enter in showNotice action");
		noticeDtoList = null;
		noticeDtoList = this.getNoticeServices().getNoticeDtoForStudent(adminDetailDto);
		   
		flag = CommonConstants.SUCCESS_FLAG;
		return flag;
	}
	
	public String showNotice() throws POLLINGBusinessException
	{
		
		String flag = CommonConstants.FAILURE_ERROR;
		this.populateMenu();
		if(request.getSession().getAttribute("adminDetailDto") == null) {
			return "login";
		}
		AdminDetailDto adminDetailDto = new AdminDetailDto();
		adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
				
		System.out.println("Enter in showNotice action");
		noticeDtoList = null;
		noticeDtoList = this.getNoticeServices().getNoticeDto(adminDetailDto);
		   
		flag = CommonConstants.SUCCESS_FLAG;
		return flag;
	}
	
	
	// Method to Save and Update Role Master data into RoleMaster Table
	public String saveNotice() throws POLLINGBusinessException{
			
		this.populateMenu();
		String flag = CommonConstants.FAILURE_ERROR; 
		
		if(request.getSession().getAttribute("adminDetailDto") == null) {
			return "login";
		}
		AdminDetailDto adminDetailDto = new AdminDetailDto();
		adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
				
		String notice = noticeDto.getGstr_notice();
		String gnum_slno = request.getParameter("noticeDto.gnum_slno");
			    
	    if(gnum_slno.equals("")) {
	    	System.out.println("hello 5");
		   	checkAvailNoticeList = this.getNoticeServices().checkAvailNotice(notice);
		   	System.out.println("hello 11");
		   	if(checkAvailNoticeList!=null && checkAvailNoticeList.size()>0){
						    	
				showNotice();
				noticeDto = new NoticeDto();
        		info = "Record is already exist";
								
				flag = CommonConstants.FAILURE_ALREADY_EXIST;
			} else {
			    			
				System.out.println("Save Role Master");
				String getNotice = noticeDto.getGstr_notice();
				if(getNotice.length() > 70) {
					String headline = getNotice.substring(0, 70);
					headline = headline+" .....";
					noticeDto.setGstr_notice_headline(headline);
				} else {
					noticeDto.setGstr_notice_headline(noticeDto.getGstr_notice());
				}
				noticeDto.setGnum_is_active(1);
				noticeDto.setOdt_entry_date(new Date());
				noticeDto.setAdminDetailDto(adminDetailDto);
				this.getNoticeServices().updateNoticeDto(noticeDto);
				noticeDtoList = null;
				showNotice();
				info = "<div class='dms_display_message'>Record Insert successfully</div>";
				flag = CommonConstants.SUCCESS_FLAG;
			} 
	    } else {
			System.out.println("gnum_slno is "+gnum_slno);
			String getNotice = noticeDto.getGstr_notice();
			        
			if(getNotice.length() > 70) {
				String headline = getNotice.substring(0, 70);
				headline = headline+" .....";
				noticeDto.setGstr_notice_headline(headline);
			} else {
				noticeDto.setGstr_notice_headline(noticeDto.getGstr_notice());
			}
			noticeDto.setGnum_is_active(1); 
			noticeDto.setOdt_entry_date(new Date());
			noticeDto.setAdminDetailDto(adminDetailDto);
						
			this.getNoticeServices().updateNoticeDto(noticeDto);
			showNotice();
			info = "<div class='dms_display_message'>Record Has been updated successfully</div>";
			noticeDto = null;
			flag = CommonConstants.SUCCESS_FLAG;
		}
		return flag;
	}
	
	public String editNotice() throws Exception
	{
		
		String  flag = CommonConstants.FAILURE_ERROR;
		this.populateMenu();
		if(request.getSession().getAttribute("adminDetailDto") == null) {
			return "login";
		}
    	String slno_id =  request.getParameter("slno");
		Integer slno = Integer.parseInt(slno_id);
		noticeDto = new NoticeDto();
		noticeDto = this.getNoticeServices().findNoticeById(slno);
		flag = CommonConstants.SUCCESS_FLAG; 
		showNotice();  
		return flag;
		
	}
	
	
	public String deleteNoticeInfo() throws Exception{
		   
		   String  flag = CommonConstants.FAILURE_ERROR;
		   this.populateMenu();
		   if(request.getSession().getAttribute("adminDetailDto") == null) {
				return "login";
		   }
		   Integer slno = Integer.parseInt(request.getParameter("slno"));
		   noticeDto =  this.getNoticeServices().findNoticeById(slno);
		   noticeDto.setGnum_is_active(0);
		   this.getNoticeServices().updateNoticeDto(noticeDto);
		   info = "<div class='dms_display_message'>Record has been deleted</div>";
		   noticeDto = null;
		   showNotice();
		   flag = CommonConstants.SUCCESS_FLAG;
		   return flag ;
	}
			
	
	private INoticeServices getNoticeServices(){
		Object serviceObj = ServiceLocator.getInstance().getService(CommonConstants.NOTICE);
				return serviceObj == null ? null
				: (INoticeServices) serviceObj;
	}
	
	


}	