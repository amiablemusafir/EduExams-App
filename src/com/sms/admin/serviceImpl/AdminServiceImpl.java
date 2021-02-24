package com.sms.admin.serviceImpl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sms.admin.dao.IAdmindao;
import com.sms.admin.dto.AdminDetailDto;
import com.sms.admin.dto.UserRoleMasterDto;
import com.sms.admin.service.IAdminService;
import com.sms.common.exception.IHMSException;

public class AdminServiceImpl implements IAdminService{

	public IAdmindao adminManagementDao;

	public IAdmindao getAdminManagementDao() {
		return adminManagementDao;
	}

	public void setAdminManagementDao(IAdmindao adminManagementDao) {
		this.adminManagementDao = adminManagementDao;
	}

	
	public List<AdminDetailDto> getAdminDetailDto(String user_id)
			throws Exception {
		return this.getAdminManagementDao().getAdminDetailDto(user_id);
	}

	public void saveOrUpdatUserDetailDto(AdminDetailDto adminDetailDto)
			throws Exception {
		
		this.getAdminManagementDao().saveOrUpdatUserDetailDto(adminDetailDto);
		
	}

	public List<AdminDetailDto> checkAvailabilityByLoginId(String login_id)
			throws Exception {
		
		return this.getAdminManagementDao().checkAvailabilityByLoginId(login_id);
	}
	
	public List<AdminDetailDto> checkAvailabilityByEmailId(String email_id)
			throws Exception {
		
		return this.getAdminManagementDao().checkAvailabilityByEmailId(email_id);
	}

	public AdminDetailDto getAdminDetailDtoById(Integer user_id)
			throws Exception {
	
		return this.getAdminManagementDao().getAdminDetailDtoById(user_id);
	}

	public List<AdminDetailDto> userAvailabilityBySecurityQus(String login_id,
			String secrete_question, String answer) throws Exception {
		
		return this.getAdminManagementDao().userAvailabilityBySecurityQus(login_id, secrete_question, answer);
	}

	
	public void saveUserRoleMasterDto(UserRoleMasterDto userRoleMasterDto) throws IHMSException
	{
			this.getAdminManagementDao().saveUserRoleMasterDto(userRoleMasterDto);
			
	}

	public List<AdminDetailDto> getAdminDetailDtoByStudentId(Integer student_id) throws Exception {
		
		return this.getAdminManagementDao().getAdminDetailDtoByStudentId(student_id);
	}
	
	public List<AdminDetailDto> getAllAdminDetailDtoByStudentId(
			Integer student_id) throws Exception {

		return this.getAdminManagementDao().getAllAdminDetailDtoByStudentId(student_id);
	}

}
