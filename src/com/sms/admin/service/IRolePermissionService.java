package com.sms.admin.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sms.admin.dto.PermissionMasterDto;
import com.sms.admin.dto.RolePermissionMasterDto;
import com.sms.common.exception.IHMSException;

public interface IRolePermissionService {
	public List findLeftList(int searchId) throws IHMSException;
	public List findRightList(int searchId) throws IHMSException;
	public List<RolePermissionMasterDto> findPermissionByRole(Integer role_id) throws Exception;
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = IHMSException.class
	)
	public void deleteRolePermissionMasterDetails(RolePermissionMasterDto rolePermissionMasterDto) throws IHMSException;

	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = IHMSException.class
	)
	public void saveRolePermissionMasterDetails(RolePermissionMasterDto rolePermissionMasterDto) throws IHMSException;
	public List<PermissionMasterDto> getPermissionBasedOnParentPermissionId(String currentMenu, List<RolePermissionMasterDto> rolePermissionDtoList)throws IHMSException;

}
