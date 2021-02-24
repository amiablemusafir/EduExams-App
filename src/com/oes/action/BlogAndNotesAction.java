package com.oes.action;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.oes.common.exception.POLLINGBusinessException;
import com.oes.constants.CommonConstants;
import com.oes.dto.ContentDetailsDto;
import com.oes.dto.BlogDetailsDto;
import com.oes.dto.SpotLightDetailsDto;
import com.oes.service.IMasterDetailsServices;
import com.oes.service.IBlogDetailsServices;
import com.sms.admin.dto.AdminDetailDto;
import com.sms.util.ServiceLocator;
import com.opensymphony.xwork2.ActionSupport;


public class BlogAndNotesAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private String messages;
	private String info;
	
	private BlogDetailsDto blogDetailsDto;
	private List<BlogDetailsDto> blogDetailsDtoList;
	private List<ContentDetailsDto> contentDetailsDtoList;
	
	
	public List<ContentDetailsDto> getContentDetailsDtoList() {
		return contentDetailsDtoList;
	}
	public void setContentDetailsDtoList(
			List<ContentDetailsDto> contentDetailsDtoList) {
		this.contentDetailsDtoList = contentDetailsDtoList;
	}
	public BlogDetailsDto getBlogDetailsDto() {
		return blogDetailsDto;
	}
	public void setBlogDetailsDto(
			BlogDetailsDto blogDetailsDto) {
		this.blogDetailsDto = blogDetailsDto;
	}
	public List<BlogDetailsDto> getBlogDetailsDtoList() {
		return blogDetailsDtoList;
	}
	public void setBlogDetailsDtoList(
			List<BlogDetailsDto> blogDetailsDtoList) {
		this.blogDetailsDtoList = blogDetailsDtoList;
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
	
	public String showStudentMaterials() throws POLLINGBusinessException {
		String flag = CommonConstants.FAILURE_ERROR;
		try {
			String slno = request.getParameter("contenttype");
			String decSlno = URLDecoder.decode(slno, "UTF-8");
			
			blogDetailsDtoList = this.getBlogManagementDetailsServices().getBlogDetailsDtoListByContentId(Integer.parseInt(decSlno));
			
			List<SpotLightDetailsDto> spotLightDetailsDtoList = new ArrayList<SpotLightDetailsDto>();
			spotLightDetailsDtoList = this.getBlogManagementDetailsServices().getSpotLightDetailsDtoListByContentId(Integer.parseInt(decSlno));
			
			if(spotLightDetailsDtoList != null && spotLightDetailsDtoList.size()>0) {
				SpotLightDetailsDto spotLightDetailsDto = new SpotLightDetailsDto();
				spotLightDetailsDto = spotLightDetailsDtoList.get(0);				
				request.getSession().setAttribute("spotLightDetailsDto", spotLightDetailsDto);
			}
			
			request.getSession().setAttribute("blogDetailsDtoList", blogDetailsDtoList);
			flag = CommonConstants.SUCCESS_FLAG;				
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return flag;
	}
	
	public String showStudentMaterialsDetails() throws POLLINGBusinessException {
		String flag = CommonConstants.FAILURE_ERROR;
		try {
			String slno = request.getParameter("contenttype");
			String decSlno = URLDecoder.decode(slno, "UTF-8");
						
			blogDetailsDto = this.getBlogManagementDetailsServices().findBlogDetailsDtoById(Integer.parseInt(decSlno));
			blogDetailsDtoList = this.getBlogManagementDetailsServices().getBlogDetailsDtoListOnlyThree(blogDetailsDto);
			
			List<BlogDetailsDto> tempBlogDetailsDtoList = new ArrayList<BlogDetailsDto>();
			int i = 0;
			for(BlogDetailsDto dto : blogDetailsDtoList) {
				if(i<3) {
					tempBlogDetailsDtoList.add(dto);
				}
				i++;
			}
			
			request.getSession().setAttribute("blogDetailsDtoList", tempBlogDetailsDtoList);			
			request.getSession().setAttribute("blogDetailsDto", blogDetailsDto);
			
			flag = CommonConstants.SUCCESS_FLAG;				
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return flag;
	}
	
	public String showBlogManagementDetails() throws POLLINGBusinessException
	{
		String flag = CommonConstants.FAILURE_ERROR;
		this.populateMenu();
		try {
			if(request.getSession().getAttribute("adminDetailDto") == null) {
				return "login";
			}
			
			contentDetailsDtoList = this.getMasterDetailsServices().getContentDetailsDtoList();
			blogDetailsDtoList = this.getBlogManagementDetailsServices().getBlogDetailsDtoList(blogDetailsDto);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		flag = CommonConstants.SUCCESS_FLAG;
		return flag;		
	}	
	
	public String saveOrUpdateBlogManagementDetailsDto() throws Exception{
		
        String flag = CommonConstants.FAILURE_ERROR; 
        if(request.getSession().getAttribute("adminDetailDto") == null) {
			return "login";
		}
		AdminDetailDto adminDetailDto = new AdminDetailDto();
		adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
		Integer id = blogDetailsDto.getOnum_id();
		
		String message = blogDetailsDto.getOstr_message();
		System.out.println("message "+message);

		if(message.equals("")){
	    	
	    	   System.out.println("message is null");
		    	
		       this.showBlogManagementDetails();
		       
		       info = "Please Enter Message";
		       
		       flag = CommonConstants.FAILURE_ERROR;
	    	
	    } else if(id == null){
	    		 
	    		System.out.println("Course Master");
			    		
		        blogDetailsDto.setOnum_is_active(1);
		        blogDetailsDto.setOdt_entry_date(new Date());
		        blogDetailsDto.setAdminDetailDto(adminDetailDto);
		        
		        this.getBlogManagementDetailsServices().updateBlogDetailsDto(blogDetailsDto);
		        this.showBlogManagementDetails();
		        blogDetailsDto = null;
				info = "Details has been inserted successfully";					 		
				flag = CommonConstants.SUCCESS_FLAG; 				       
		} else {   		 
				blogDetailsDto.setOnum_is_active(1);
				blogDetailsDto.setOdt_entry_date(new Date());
	            blogDetailsDto.setAdminDetailDto(adminDetailDto);	    
				
				this.getBlogManagementDetailsServices().updateBlogDetailsDto(blogDetailsDto);
				this.showBlogManagementDetails();
				blogDetailsDto = null;
				 		
		        info = "Details has been updated successfully";
				flag = CommonConstants.SUCCESS_FLAG;
		}
	    System.out.println(flag);
	    return flag;
	}
		
		
	public String editBlogManagementDetail() throws Exception{
			
			String flag = CommonConstants.ERROR_FLAG;
			try{
				
				this.showBlogManagementDetails();
				populateMenu();
				String id = request.getParameter("slno");
				
				blogDetailsDto = this.getBlogManagementDetailsServices().findBlogDetailsDtoById(Integer.parseInt(id));
				flag = CommonConstants.SUCCESS_FLAG;
			}
			catch(Exception er){
				er.printStackTrace();
			}			
			return flag;
	}
		
		
	public String deleteBlogManagementDetail() throws Exception{
			
			String flag = CommonConstants.ERROR_FLAG;
			try{
				String id = request.getParameter("slno");
				blogDetailsDto = this.getBlogManagementDetailsServices().findBlogDetailsDtoById(Integer.parseInt(id));
				
				blogDetailsDto.setOnum_is_active(0);
				blogDetailsDto.setOdt_entry_date(new Date());
					
				this.getBlogManagementDetailsServices().updateBlogDetailsDto(blogDetailsDto);
					
				blogDetailsDto = null;
				info = "Details has been deleted successfully";
				this.showBlogManagementDetails();
				flag = CommonConstants.SUCCESS_FLAG;
			} catch(Exception er) {
				er.printStackTrace();
			}
			return flag;
	}
	

	private IBlogDetailsServices getBlogManagementDetailsServices() {
			Object serviceObj = ServiceLocator.getInstance().getService(CommonConstants.BLOG_DETAILS);
				return serviceObj == null ? null : (IBlogDetailsServices) serviceObj;
	}

	// Admin service locater
	private IMasterDetailsServices getMasterDetailsServices () {
		Object serviceObj = ServiceLocator.getInstance().getService(com.oes.constants.CommonConstants.MASTER_DETAILS);
			return serviceObj == null ? null : (IMasterDetailsServices) serviceObj;
	}

}
