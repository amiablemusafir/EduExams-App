package com.sms.admin.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sms.admin.dto.PermissionMasterDto;
import com.sms.common.exception.IHMSException;


public interface IPermissionMasterServices {

	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = IHMSException.class
	)
	public List<PermissionMasterDto> getPermissionMasterDto() throws IHMSException;
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = IHMSException.class
	)
	public Integer checkAvailPermissionMaster(String permissionname) throws IHMSException;
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = IHMSException.class
	)
	public void savePermissionMasterDto(PermissionMasterDto permissionMasterDto) throws IHMSException;
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = IHMSException.class
	)
	 public PermissionMasterDto findPermissionMasterById(Integer permissionId) throws IHMSException;

	
	public List<PermissionMasterDto> getParentPermissionName() throws Exception;
	
}
