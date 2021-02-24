/*
 * Author: Himanshu Bharti
 * Start Date: 24th Sep, 2013
 * Modify Date: 
 * Modify By:
 * Motive: Permission Master Data
 */


package com.sms.admin.dto;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Loader;
import org.hibernate.annotations.Proxy;

import java.util.Date;

@Entity @Table(name="admin_permission_mst") @Proxy(lazy=false)
public class PermissionMasterDto implements Serializable{
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	
	@Column(name="inum_permission_id")
	 public Integer inum_permission_id;
	@Column(name="istr_permission_name") public String istr_permission_name;
	@Column(name="istr_permission_desc") public String istr_permission_desc;
	@Column(name="istr_permission_url") public String istr_permission_url;
	@Column(name="inum_is_parent") public Integer inum_is_parent;
	@Column(name="inum_parent_permission_id") public Integer inum_parent_permission_id;
	 
    @Column(name="inum_is_active") public Integer inum_is_active;
	 @Column(name="idt_entry_date") public Date idt_entry_date;
	 
	 
	 
	
	 
	public Integer getInum_permission_id() {
		return inum_permission_id;
	}
	public void setInum_permission_id(Integer inum_permission_id) {
		this.inum_permission_id = inum_permission_id;
	}
	public String getIstr_permission_name() {
		return istr_permission_name;
	}
	public void setIstr_permission_name(String istr_permission_name) {
		this.istr_permission_name = istr_permission_name;
	}
	public String getIstr_permission_desc() {
		return istr_permission_desc;
	}
	public void setIstr_permission_desc(String istr_permission_desc) {
		this.istr_permission_desc = istr_permission_desc;
	}
	public String getIstr_permission_url() {
		return istr_permission_url;
	}
	public void setIstr_permission_url(String istr_permission_url) {
		this.istr_permission_url = istr_permission_url;
	}
	
	
	
	
	public Integer getInum_is_parent() {
		return inum_is_parent;
	}
	public void setInum_is_parent(Integer inum_is_parent) {
		this.inum_is_parent = inum_is_parent;
	}
	public Integer getInum_parent_permission_id() {
		return inum_parent_permission_id;
	}
	public void setInum_parent_permission_id(Integer inum_parent_permission_id) {
		this.inum_parent_permission_id = inum_parent_permission_id;
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
	
	 
	 
	
}
