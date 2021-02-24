package com.sms.admin.daoImpl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.sms.admin.dao.IPermissionMasterDao;
import com.sms.admin.dto.PermissionMasterDto;


public class PermissionMasterDaoImpl implements IPermissionMasterDao{
	
	public HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	public List<PermissionMasterDto> getPermissionMasterDto() throws DataAccessException{
		String queryStringName = "from PermissionMasterDto as permission_mst where permission_mst.inum_is_active = 1 ";
		
		return this.hibernateTemplate.find(queryStringName);
	}
	
	
	public Integer checkAvailPermissionMaster(String permissionname) throws DataAccessException{
		
		String queryStringName = "select count(inum_permission_id) from PermissionMasterDto as permission_mst where permission_mst.istr_permission_name = '"+permissionname+"' " +
				"and inum_is_active = 1";
		List countList = this.hibernateTemplate.find(queryStringName);
		return Integer.parseInt((countList.get(0).toString()==null)?"0":countList.get(0).toString());
	}
	
	public void savePermissionMasterDto(PermissionMasterDto permissionMasterDto) throws DataAccessException{
		
		this.hibernateTemplate.saveOrUpdate(permissionMasterDto);
   }
	
	 public PermissionMasterDto findPermissionMasterById(Integer permissionId) throws DataAccessException{
		 
			try {
				 
				PermissionMasterDto permissionMasterDto = (PermissionMasterDto) this.getHibernateTemplate().get("com.sms.admin.dto.PermissionMasterDto",permissionId);
						return permissionMasterDto;
					} catch (RuntimeException re) {
						throw re;
					}
	 }

	public List<PermissionMasterDto> getParentPermissionName() throws Exception {

		String queryStringName = "from PermissionMasterDto as permission_mst where permission_mst.inum_is_active = 1 and permission_mst.inum_parent_permission_id = 0 ";
		
		return this.hibernateTemplate.find(queryStringName);
	}

}
