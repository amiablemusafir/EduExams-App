package com.sms.admin.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.sms.admin.dto.AdminDetailDto;
import com.sms.admin.dto.UserRoleMasterDto;
import com.sms.common.exception.IHMSException;

public interface IAdminService 
{

	public List<AdminDetailDto> getAdminDetailDto(String user_id) throws Exception;

	public void saveOrUpdatUserDetailDto(AdminDetailDto adminDetailDto) throws Exception;
	
	public List<AdminDetailDto> checkAvailabilityByLoginId(String login_id) throws Exception;
	
	public List<AdminDetailDto> checkAvailabilityByEmailId(String email_id) throws Exception;
	
	public AdminDetailDto getAdminDetailDtoById(Integer user_id)
			throws Exception;
	
	public List<AdminDetailDto> userAvailabilityBySecurityQus(String login_id,
			String secrete_question, String answer) throws Exception;
	

	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = IHMSException.class
	)
	public void saveUserRoleMasterDto(UserRoleMasterDto userRoleMasterDto) throws IHMSException;
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = IHMSException.class
	)
	public List<AdminDetailDto> getAdminDetailDtoByStudentId(Integer student_id) throws Exception;
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = IHMSException.class
	)
	public List<AdminDetailDto> getAllAdminDetailDtoByStudentId(
			Integer student_id) throws Exception;
		
}
