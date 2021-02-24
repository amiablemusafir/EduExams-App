package com.sms.admin.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import com.oes.dto.NewsAndEventsDto;
import com.sms.admin.dto.AdminDetailDto;
import com.sms.admin.dto.UserRoleMasterDto;

public interface IAdmindao {

	public List<AdminDetailDto> getAdminDetailDto(String user_id) throws Exception;
	
	public void saveOrUpdatUserDetailDto(AdminDetailDto adminDetailDto) throws Exception;

	public List<AdminDetailDto> checkAvailabilityByLoginId(String login_id) throws Exception;
	
	public List<AdminDetailDto> checkAvailabilityByEmailId(String email_id) throws Exception;

	public AdminDetailDto getAdminDetailDtoById(Integer user_id) throws Exception;
	
	// check user availability by Login ID, Secrete Question and answer
	public List<AdminDetailDto> userAvailabilityBySecurityQus(String login_id, String secrete_question, String answer) throws Exception; 
	
	// Save User Role Master Dto
	public void saveUserRoleMasterDto(UserRoleMasterDto userRoleMasterDto) throws DataAccessException;
	
	public List<AdminDetailDto> getAdminDetailDtoByStudentId(Integer student_id) throws Exception;
		
	public List<AdminDetailDto> getAllAdminDetailDtoByStudentId(Integer student_id) throws Exception;
	
	
	
	
}
