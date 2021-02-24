package com.sms.admin.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.sms.admin.dto.PermissionMasterDto;

public interface IPermissionMasterDao {

	    public List<PermissionMasterDto> getPermissionMasterDto() throws DataAccessException;
	    
	    //method to check availability of permission name into Permission master table  
	    public Integer checkAvailPermissionMaster(String permissionname) throws DataAccessException;
	    
	  //method to update PermissionMasterDto Data
	  	public void savePermissionMasterDto(PermissionMasterDto permissionMasterDto) throws DataAccessException;
	  	
	 // method to populate PermissionMasterDto by roleId
	    public PermissionMasterDto findPermissionMasterById(Integer permissionId) throws DataAccessException;

	   //method to get Permission name which are having parents permission id is zero
	   public List<PermissionMasterDto> getParentPermissionName() throws Exception; 
	    
	    
}
