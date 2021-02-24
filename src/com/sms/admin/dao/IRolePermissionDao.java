package com.sms.admin.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.sms.admin.dto.PermissionMasterDto;
import com.sms.admin.dto.RolePermissionMasterDto;



public interface IRolePermissionDao {

public List<RolePermissionMasterDto> findPermissionByRole(Integer role_id) throws Exception;
public void deleteRolePermissionMasterDetails(RolePermissionMasterDto rolePermissionMasterDto) throws DataAccessException;	 
public void saveRolePermissionMasterDetails(RolePermissionMasterDto rolePermissionMasterDto) throws DataAccessException;
public List<PermissionMasterDto> getPermissionBasedOnParentPermissionId(String currentMenu, List<RolePermissionMasterDto> rolePermissionDtoList) throws DataAccessException;

}
