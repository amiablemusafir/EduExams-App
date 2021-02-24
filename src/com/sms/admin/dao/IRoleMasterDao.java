package com.sms.admin.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.sms.admin.dto.RoleMasterDto;


public interface IRoleMasterDao {

	
	// method to populate ContactDetailsDto data
		public List<RoleMasterDto> getRoleMasterDto(RoleMasterDto roleMasterDto) throws DataAccessException;
		
		//method to update ContactDetailsDto Data
		public void updateRoleMasterDto(RoleMasterDto roleMasterDto) throws DataAccessException;
		
		// method to check availability of contact name into Role Master table
	    public List<RoleMasterDto> checkAvailRoleMaster(String rolename) throws DataAccessException;
		
	 // method to populate ContactDetailsDto by Id
	    public RoleMasterDto findRoleMasterById(Integer roleId) throws DataAccessException;
	  	
}
