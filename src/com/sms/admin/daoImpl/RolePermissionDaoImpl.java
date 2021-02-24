package com.sms.admin.daoImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.sms.admin.dao.IRolePermissionDao;
import com.sms.admin.dto.PermissionMasterDto;
import com.sms.admin.dto.RolePermissionMasterDto;


public class RolePermissionDaoImpl implements IRolePermissionDao{

	public HibernateTemplate hibernateTemplate;

	
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}



	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}



	public List<RolePermissionMasterDto> findPermissionByRole(Integer role_id)
			throws Exception {
	  
		String query = "from RolePermissionMasterDto as rolePermissiondto where rolePermissiondto.roleMasterDto.inum_role_id = '"+role_id+"' and rolePermissiondto.permissionMasterDto.inum_is_active = 1  and rolePermissiondto.inum_is_active = 1";
		
		  List<RolePermissionMasterDto> rolePermissionList = this.getHibernateTemplate().find(query);
		return rolePermissionList;
	}
	public void deleteRolePermissionMasterDetails(RolePermissionMasterDto rolePermissionMasterDto) throws DataAccessException
	{
		
		this.getHibernateTemplate().delete(rolePermissionMasterDto);
	}

	
	public void saveRolePermissionMasterDetails(RolePermissionMasterDto rolePermissionMasterDto) throws DataAccessException {
		
		this.getHibernateTemplate().saveOrUpdate(rolePermissionMasterDto);
		
	}


	public List<PermissionMasterDto> getPermissionBasedOnParentPermissionId(
			String currentMenu,List<RolePermissionMasterDto> rolePermissionDtoList) throws DataAccessException {
		
		/*select permission0_.inum_permission_id as inum1_1_, permission0_.idt_entry_date as idt2_1_, permission0_.inum_is_active as inum3_1_, permission0_.inum_is_parent as inum4_1_, permission0_.inum_parent_permission_id as inum5_1_, permission0_.istr_permission_desc as istr6_1_, permission0_.istr_permission_name as istr7_1_, permission0_.istr_permission_url as istr8_1_ 
		from admin_permission_mst permission0_ 
		where permission0_.inum_parent_permission_id=110
		and permission0_.inum_is_parent =1
		
		or permission0_.inum_parent_permission_id in (
		select permission0_.inum_permission_id 
		from admin_permission_mst permission0_ 
		where permission0_.inum_parent_permission_id=100
		and permission0_.inum_is_parent=1)
		
		or permission0_.inum_parent_permission_id in (
		select permission0_.inum_parent_permission_id 
		from admin_permission_mst permission0_ 
		where permission0_.inum_permission_id=110
		and permission0_.inum_is_parent =1 and permission0_.inum_is_active=1)
		
		
		*/
		
		String queryPermission = "from PermissionMasterDto as rolePermissiondto where rolePermissiondto.inum_permission_id = '"+currentMenu+"' and rolePermissiondto.inum_is_parent=1 and rolePermissiondto.inum_is_active = 1";
		List<PermissionMasterDto> permissionList=this.getHibernateTemplate().find(queryPermission);
		
		String queryParentPermission = "from PermissionMasterDto as rolePermissiondto where rolePermissiondto.inum_parent_permission_id = '"+currentMenu+"' and rolePermissiondto.inum_is_parent=1 and rolePermissiondto.inum_is_active = 1";
		List<PermissionMasterDto> parentPermissionList=this.getHibernateTemplate().find(queryParentPermission);
		
		
		List<Integer> permissionlist1=new ArrayList<Integer>();
		List<Integer> permissionlist2=new ArrayList<Integer>();
		
		List<Integer> permissionlistUser=new ArrayList<Integer>();
		
		for(RolePermissionMasterDto rpdto:rolePermissionDtoList)
		{
			permissionlistUser.add(rpdto.getPermissionMasterDto().getInum_permission_id());
		}
		
		for(PermissionMasterDto hdto:permissionList)
		{
			permissionlist1.add(hdto.getInum_parent_permission_id());	
		}
		
		for(PermissionMasterDto hdto:parentPermissionList)
		{
			
			permissionlist2.add(hdto.getInum_permission_id());
		}
		
		String query = "from PermissionMasterDto as rolePermissiondto where rolePermissiondto.inum_parent_permission_id = '"+currentMenu+"' and rolePermissiondto.inum_is_active = 1";
		
		if(permissionlist1!=null && permissionlist1.size()>0)
		{
			String joinedPermission = Arrays.toString(permissionlist1.toArray()).replaceAll("\\[|\\]", "");
			query+=" or rolePermissiondto.inum_parent_permission_id in ("+joinedPermission+") ";
			
		}
		
		
		if(permissionlist2!=null && permissionlist2.size()>0)
		{
			String joinedParentPermission = Arrays.toString(permissionlist2.toArray()).replaceAll("\\[|\\]", "");
			query+=" or rolePermissiondto.inum_parent_permission_id in ("+joinedParentPermission+")";
		}
		String joinedUserPermission = Arrays.toString(permissionlistUser.toArray()).replaceAll("\\[|\\]", "");
		query+=" and rolePermissiondto.inum_permission_id in ("+joinedUserPermission+")";
		System.out.println("query@@@@@@@@@@@@@@@@@@@------------->"+query);
		List<PermissionMasterDto> rolePermissionList = this.getHibernateTemplate().find(query);
		
		return rolePermissionList;
	}
	

}
