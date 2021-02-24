/*
 * Author: Himanshu Bharti
 * Start Date: 25th Feb, 2014
 * Modify Date: 
 * Modify By:
 * Motive: User Role Master Data
 */


package com.sms.admin.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity @Table(name="admin_user_role_mst") @Proxy(lazy=false)
public class UserRoleMasterDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="inum_user_role_id")
	private Integer pnum_user_role_id;
	
	@ManyToOne
	@JoinColumn(name = "inum_role_id")
	private RoleMasterDto roleMasterDto;
	
	@ManyToOne
	@JoinColumn(name = "inum_user_id")
	private AdminDetailDto adminDetailDto;
	
	@Column(name="inum_is_active")
	private Integer pnum_is_active;
	
	@Column(name="idt_entry_date")
	private Date pdt_entry_date;
	
	@ManyToOne
	@JoinColumn(name="inum_enter_user_id")
	private AdminDetailDto adminDto;
	
	public Integer getPnum_user_role_id() {
		return pnum_user_role_id;
	}
	public void setPnum_user_role_id(Integer pnum_user_role_id) {
		this.pnum_user_role_id = pnum_user_role_id;
	}
	public RoleMasterDto getRoleMasterDto() {
		return roleMasterDto;
	}
	public void setRoleMasterDto(RoleMasterDto roleMasterDto) {
		this.roleMasterDto = roleMasterDto;
	}
	public AdminDetailDto getAdminDetailDto() {
		return adminDetailDto;
	}
	public void setAdminDetailDto(AdminDetailDto adminDetailDto) {
		this.adminDetailDto = adminDetailDto;
	}
	public Integer getPnum_is_active() {
		return pnum_is_active;
	}
	public void setPnum_is_active(Integer pnum_is_active) {
		this.pnum_is_active = pnum_is_active;
	}
	public Date getPdt_entry_date() {
		return pdt_entry_date;
	}
	public void setPdt_entry_date(Date pdt_entry_date) {
		this.pdt_entry_date = pdt_entry_date;
	}
	public AdminDetailDto getAdminDto() {
		return adminDto;
	}
	public void setAdminDto(AdminDetailDto adminDto) {
		this.adminDto = adminDto;
	}
	
	

}
