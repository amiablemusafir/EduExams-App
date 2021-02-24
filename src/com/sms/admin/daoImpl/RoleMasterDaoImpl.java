package com.sms.admin.daoImpl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.sms.admin.dao.IRoleMasterDao;
import com.sms.admin.dto.RoleMasterDto;


public class RoleMasterDaoImpl implements IRoleMasterDao{
	
	public HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public List<RoleMasterDto> getRoleMasterDto(RoleMasterDto roleMasterDto) throws DataAccessException{
		String queryStringName = "from RoleMasterDto as role_mst where role_mst.inum_is_active = 1";
	return this.hibernateTemplate.find(queryStringName);	
	}
	
	public void updateRoleMasterDto(RoleMasterDto roleMasterDto) throws DataAccessException{
		
		this.hibernateTemplate.saveOrUpdate(roleMasterDto);
	}
	
	public List<RoleMasterDto> checkAvailRoleMaster(String rolename) throws DataAccessException{
		
		String queryStringName = "from RoleMasterDto as role_mst where role_mst.istr_role_name = '"+rolename+"' and inum_is_active = 1";
		return this.hibernateTemplate.find(queryStringName);
	}
	
	
	public RoleMasterDto findRoleMasterById(Integer roleId) throws DataAccessException{
		try {					 
			RoleMasterDto roleMasterDto = (RoleMasterDto) this.getHibernateTemplate().get("com.sms.admin.dto.RoleMasterDto",roleId);
			return roleMasterDto;
		} catch (RuntimeException re) {
			throw re;
		}
		
	}


}
