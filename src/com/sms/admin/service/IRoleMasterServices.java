package com.sms.admin.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sms.admin.dto.RoleMasterDto;
import com.sms.common.exception.IHMSException;

public interface IRoleMasterServices {

	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = IHMSException.class
	)
	public List<RoleMasterDto> getRoleMasterDto(RoleMasterDto roleMasterDto) throws IHMSException;

	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = IHMSException.class
	)
	public void updateRoleMasterDto(RoleMasterDto roleMasterDto) throws IHMSException;
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = IHMSException.class
	)
	public List<RoleMasterDto> checkAvailRoleMaster(String rolename) throws IHMSException;
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = IHMSException.class
	)
	public RoleMasterDto findRoleMasterById(Integer roleId) throws IHMSException;
}
