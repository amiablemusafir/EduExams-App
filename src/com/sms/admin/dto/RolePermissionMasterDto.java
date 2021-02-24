/*
 * Author: Himanshu Bharti
 * Start Date: 9th Sep, 2013
 * Modify Date: 
 * Modify By:
 * Motive: Role Permission Master Data
 */


package com.sms.admin.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import org.hibernate.annotations.Proxy;


@Entity @Table(name="admin_role_permission_mst") @Proxy(lazy=false)
public class RolePermissionMasterDto implements Serializable
{
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="inum_role_permission_id") 
	public Integer inum_role_permission_id;
	
		
	@ManyToOne
	@JoinColumn(name = "inum_role_id") public RoleMasterDto roleMasterDto;
	@ManyToOne
	@JoinColumn(name = "inum_permission_id") public PermissionMasterDto permissionMasterDto; 
	
	   
	@Column(name="inum_is_active") public Integer inum_is_active;
	@Column(name="idt_entry_date") public Date idt_entry_date;
	@Column(name="inum_user_id") public Integer inum_user_id;
	
	@Transient
	public String strChosenitems;
	
	
	public Integer getInum_role_permission_id() {
		return inum_role_permission_id;
	}
	public void setInum_role_permission_id(Integer inum_role_permission_id) {
		this.inum_role_permission_id = inum_role_permission_id;
	}
	public RoleMasterDto getRoleMasterDto() {
		return roleMasterDto;
	}
	public void setRoleMasterDto(RoleMasterDto roleMasterDto) {
		this.roleMasterDto = roleMasterDto;
	}
	public PermissionMasterDto getPermissionMasterDto() {
		return permissionMasterDto;
	}
	public void setPermissionMasterDto(PermissionMasterDto permissionMasterDto) {
		this.permissionMasterDto = permissionMasterDto;
	}
	public Integer getInum_is_active() {
		return inum_is_active;
	}
	public void setInum_is_active(Integer inum_is_active) {
		this.inum_is_active = inum_is_active;
	}
	public Date getIdt_entry_date() {
		return idt_entry_date;
	}
	public void setIdt_entry_date(Date idt_entry_date) {
		this.idt_entry_date = idt_entry_date;
	}
	public Integer getInum_user_id() {
		return inum_user_id;
	}
	public void setInum_user_id(Integer inum_user_id) {
		this.inum_user_id = inum_user_id;
	}
	public String getStrChosenitems() {
		return strChosenitems;
	}
	public void setStrChosenitems(String strChosenitems) {
		this.strChosenitems = strChosenitems;
	}
	
	
	
	
	
}
