package com.sms.admin.serviceImpl;

import java.util.List;

import com.sms.admin.dao.IRolePermissionDao;
import com.sms.admin.dao.ISqlHibernateCompatibleDao;
import com.sms.admin.dto.PermissionMasterDto;
import com.sms.admin.dto.RolePermissionMasterDto;
import com.sms.admin.service.IRolePermissionService;
import com.sms.common.exception.IHMSException;

public class RolePermissionServiceImpl implements IRolePermissionService{


	public IRolePermissionDao rolePermissionDao;
	private ISqlHibernateCompatibleDao sqlHibernateCompatibleDao;
	
	
	public IRolePermissionDao getRolePermissionDao() {
		return rolePermissionDao;
	}



	public void setRolePermissionDao(IRolePermissionDao rolePermissionDao) {
		this.rolePermissionDao = rolePermissionDao;
	}



	public ISqlHibernateCompatibleDao getSqlHibernateCompatibleDao() {
		return sqlHibernateCompatibleDao;
	}



	public void setSqlHibernateCompatibleDao(
			ISqlHibernateCompatibleDao sqlHibernateCompatibleDao) {
		this.sqlHibernateCompatibleDao = sqlHibernateCompatibleDao;
	}



	public List<RolePermissionMasterDto> findPermissionByRole(Integer role_id)
			throws Exception {
		// TODO Auto-generated method stub
		return this.getRolePermissionDao().findPermissionByRole(role_id);
	}

	public void deleteRolePermissionMasterDetails(RolePermissionMasterDto rolePermissionMasterDto)
			throws IHMSException {
		// TODO Auto-generated method stub
		
		  this.getRolePermissionDao().deleteRolePermissionMasterDetails(rolePermissionMasterDto);
		
	}

    public void saveRolePermissionMasterDetails(RolePermissionMasterDto rolePermissionMasterDto)
			throws IHMSException {
		// TODO Auto-generated method stub
		
    	this.getRolePermissionDao().saveRolePermissionMasterDetails(rolePermissionMasterDto);
	}
    
    public List findLeftList(int searchId) throws IHMSException {
		 System.out.println("findLeftList.......");
		return this.getSqlHibernateCompatibleDao().permissionNotInRolePermission(searchId);
	}

	public List findRightList(int searchId) throws IHMSException {
		// TODO Auto-generated method stub
		return this.getSqlHibernateCompatibleDao().permissionInRolePermission(searchId);
	}

	public List<PermissionMasterDto> getPermissionBasedOnParentPermissionId(
			String currentMenu,List<RolePermissionMasterDto> rolePermissionDtoList) throws IHMSException {
		return this.getRolePermissionDao().getPermissionBasedOnParentPermissionId(currentMenu,rolePermissionDtoList);
	}
	
}
