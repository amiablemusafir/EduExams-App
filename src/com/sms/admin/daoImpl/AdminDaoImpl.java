package com.sms.admin.daoImpl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.sms.admin.dao.IAdmindao;
import com.sms.admin.dto.AdminDetailDto;
import com.sms.admin.dto.UserRoleMasterDto;

public class AdminDaoImpl implements IAdmindao {
	
	public HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}


	public List<AdminDetailDto> getAdminDetailDto(String user_id)
			throws Exception {
		List<AdminDetailDto> adminList = null;
		
		String query = "from AdminDetailDto as adminDetailDto where adminDetailDto.inum_is_active = 1 and UPPER(adminDetailDto.istr_login_id) = UPPER('"+user_id+"')";
		
	    adminList = this.getHibernateTemplate().find(query);
		
		return adminList;
	}

	public void saveOrUpdatUserDetailDto(AdminDetailDto adminDetailDto)
			throws Exception {
	
		this.getHibernateTemplate().saveOrUpdate(adminDetailDto);
		
	}

	public List<AdminDetailDto> checkAvailabilityByLoginId(String login_id)
			throws Exception {

		String query = "from AdminDetailDto as admin_detail where admin_detail.inum_is_active = 1 and UPPER(admin_detail.istr_login_id) = UPPER('"+login_id+"')";
		
		return this.getHibernateTemplate().find(query);
	}
	
	public List<AdminDetailDto> checkAvailabilityByEmailId(String email_id)
			throws Exception {

		String query = "from AdminDetailDto as admin_detail where admin_detail.inum_is_active = 1 and UPPER(admin_detail.istr_email) = UPPER('"+email_id+"')";
		
		return this.getHibernateTemplate().find(query);
	}

	public AdminDetailDto getAdminDetailDtoById(Integer user_id)
			throws Exception {
		
		return (AdminDetailDto) this.getHibernateTemplate().get("com.sms.admin.dto.AdminDetailDto", user_id);
	}

	public List<AdminDetailDto> userAvailabilityBySecurityQus(String login_id,
			String secrete_question, String answer) throws Exception {
	
		String query = "from AdminDetailDto as admin_detail where admin_detail.inum_is_active = 1 and " +
				"admin_detail.istr_login_id = '"+login_id+"' and admin_detail.istr_secrete_question = '"+secrete_question+"' " +
				"and admin_detail.istr_answer = '"+answer+"'";
		
		return this.getHibernateTemplate().find(query);
	}

	
	public void saveUserRoleMasterDto(UserRoleMasterDto userRoleMasterDto)throws DataAccessException {
		
		this.getHibernateTemplate().saveOrUpdate(userRoleMasterDto);
		
	}

	public List<AdminDetailDto> getAdminDetailDtoByStudentId(Integer student_id) throws Exception {
		
		List<AdminDetailDto> adminList = null;		
		String query = "from AdminDetailDto as adminDetailDto where adminDetailDto.inum_student_id = '"+student_id+"' and adminDetailDto.inum_is_active = 1";		
	    adminList = this.getHibernateTemplate().find(query);
		return adminList;
	}
	

	public List<AdminDetailDto> getAllAdminDetailDtoByStudentId(Integer student_id) throws Exception {
		
		List<AdminDetailDto> adminList = null;		
		String query = "from AdminDetailDto as adminDetailDto " +
				"where adminDetailDto.inum_student_id = '"+student_id+"'";		
	    adminList = this.getHibernateTemplate().find(query);
		return adminList;
	}

}
