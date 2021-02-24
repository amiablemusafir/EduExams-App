package com.sms.admin.serviceImpl;


import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sms.admin.dao.IPermissionMasterDao;
import com.sms.admin.dto.PermissionMasterDto;
import com.sms.admin.service.IPermissionMasterServices;
import com.sms.common.exception.IHMSException;

public class PermissionMasterServicesImpl implements IPermissionMasterServices {

	private IPermissionMasterDao permissionMasterDao;

	public IPermissionMasterDao getPermissionMasterDao() {
		return permissionMasterDao;
	}

	public void setPermissionMasterDao(IPermissionMasterDao permissionMasterDao) {
		this.permissionMasterDao = permissionMasterDao;
	} 
	
	public List<PermissionMasterDto> getPermissionMasterDto()
			throws IHMSException {
		// TODO Auto-generated method stub
		return this.getPermissionMasterDao().getPermissionMasterDto();
	}

	public Integer checkAvailPermissionMaster(
			String permissionname) throws IHMSException {
		// TODO Auto-generated method stub
		return this.getPermissionMasterDao().checkAvailPermissionMaster(permissionname);
	}

	public void savePermissionMasterDto(PermissionMasterDto permissionMasterDto)
			throws IHMSException {
		// TODO Auto-generated method stub
		this.getPermissionMasterDao().savePermissionMasterDto(permissionMasterDto);
	}

		public PermissionMasterDto findPermissionMasterById(Integer permissionId)
			throws IHMSException {
		// TODO Auto-generated method stub
		return this.getPermissionMasterDao().findPermissionMasterById(permissionId);
	}

		public List<PermissionMasterDto> getParentPermissionName() throws Exception {
				
				return this.getPermissionMasterDao().getParentPermissionName();
			
		}

	
	
	
}
