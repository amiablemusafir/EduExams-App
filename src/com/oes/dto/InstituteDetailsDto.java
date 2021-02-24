/*
 * Author: sumit singh
 * Start Date: 11th Feb, 2013
 * Modify Date: 
 * Modify By:
 * Motive: Role Master Data
 */


package com.oes.dto;

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

import com.sms.admin.dto.AdminDetailDto;

@Entity @Table(name = "oes_institute_details") @Proxy(lazy=false)
public class InstituteDetailsDto implements Serializable{
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)    
	@Column(name = "onum_slno")
	public Integer onum_slno;
	
	@Column(name = "ostr_institute_name")
	public String ostr_institute_name;
	
	@Column(name = "ostr_institute_logo")
	public String ostr_institute_logo;
	
	@Column(name = "ostr_address1")
	public String ostr_address1;
	
	@Column(name = "ostr_address2")
	public String ostr_address2;
	
	@Column(name = "ostr_website_url")
	public String ostr_website_url;
	
	@Column(name = "ostr_phone_no")
	public String ostr_phone_no;
		
	@Column(name = "onum_is_active")
	public Integer onum_is_active;
	
	@Column(name = "odt_entry_date")
	public Date odt_entry_date;

	@ManyToOne
	@JoinColumn(name = "onum_user_id")
	public AdminDetailDto adminDetailDto;

	public Integer getOnum_slno() {
		return onum_slno;
	}

	public void setOnum_slno(Integer onum_slno) {
		this.onum_slno = onum_slno;
	}

	public String getOstr_institute_name() {
		return ostr_institute_name;
	}

	public void setOstr_institute_name(String ostr_institute_name) {
		this.ostr_institute_name = ostr_institute_name;
	}

	public String getOstr_institute_logo() {
		return ostr_institute_logo;
	}

	public void setOstr_institute_logo(String ostr_institute_logo) {
		this.ostr_institute_logo = ostr_institute_logo;
	}

	public String getOstr_address1() {
		return ostr_address1;
	}

	public void setOstr_address1(String ostr_address1) {
		this.ostr_address1 = ostr_address1;
	}

	public String getOstr_address2() {
		return ostr_address2;
	}

	public void setOstr_address2(String ostr_address2) {
		this.ostr_address2 = ostr_address2;
	}

	public String getOstr_website_url() {
		return ostr_website_url;
	}

	public void setOstr_website_url(String ostr_website_url) {
		this.ostr_website_url = ostr_website_url;
	}

	public String getOstr_phone_no() {
		return ostr_phone_no;
	}

	public void setOstr_phone_no(String ostr_phone_no) {
		this.ostr_phone_no = ostr_phone_no;
	}

	public Integer getOnum_is_active() {
		return onum_is_active;
	}

	public void setOnum_is_active(Integer onum_is_active) {
		this.onum_is_active = onum_is_active;
	}

	public Date getOdt_entry_date() {
		return odt_entry_date;
	}

	public void setOdt_entry_date(Date odt_entry_date) {
		this.odt_entry_date = odt_entry_date;
	}

	public AdminDetailDto getAdminDetailDto() {
		return adminDetailDto;
	}

	public void setAdminDetailDto(AdminDetailDto adminDetailDto) {
		this.adminDetailDto = adminDetailDto;
	}    	    
}
