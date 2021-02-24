package com.sms.admin.serviceImpl;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sms.admin.dao.IRoleMasterDao;
import com.sms.admin.dto.RoleMasterDto;
import com.sms.admin.service.IRoleMasterServices;
import com.sms.common.exception.IHMSException;

public class RoleMasterServicesImpl implements IRoleMasterServices {
	
	private IRoleMasterDao roleMasterDao;

	public IRoleMasterDao getRoleMasterDao() {
		return roleMasterDao;
	}

	public void setRoleMasterDao(IRoleMasterDao roleMasterDao) {
		this.roleMasterDao = roleMasterDao;
	}
	
	public List<RoleMasterDto> getRoleMasterDto(RoleMasterDto roleMasterDto)
			throws IHMSException {
		// TODO Auto-generated method stub
		return this.getRoleMasterDao().getRoleMasterDto(roleMasterDto);
	}

	
	public void updateRoleMasterDto(RoleMasterDto roleMasterDto)
			throws IHMSException {
		// TODO Auto-generated method stub	
		this.getRoleMasterDao().updateRoleMasterDto(roleMasterDto);
		
	}

	public List<RoleMasterDto> checkAvailRoleMaster(String rolename)
			throws IHMSException {
		// TODO Auto-generated method stub
		return this.getRoleMasterDao().checkAvailRoleMaster(rolename);
	}

	public RoleMasterDto findRoleMasterById(Integer roleId)
			throws IHMSException {
		// TODO Auto-generated method stub
		return this.getRoleMasterDao().findRoleMasterById(roleId);
	}
		
    

	
}
