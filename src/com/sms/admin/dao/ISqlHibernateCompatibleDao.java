package com.sms.admin.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.sms.admin.dto.RolePermissionMasterDto;

public interface ISqlHibernateCompatibleDao {

	public List permissionNotInRolePermission(int roleId) throws DataAccessException;
	public List permissionInRolePermission(int roleId) throws DataAccessException;
	
	public List examNotInBatchExaminationMapping(int batchId, Integer user_id) throws Exception;
	public List examInBatchExaminationMapping(int batchId, Integer user_id) throws Exception;

	public String findLoginIdExists(String loginId) throws DataAccessException;
	
	
	
}
