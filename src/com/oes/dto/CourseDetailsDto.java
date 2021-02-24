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

@Entity @Table(name = "oes_course_details") @Proxy(lazy=false)
public class CourseDetailsDto implements Serializable{
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)    
	@Column(name = "onum_slno")
	private Integer onum_slno;
	
	@Column(name = "ostr_course_name")
	private String ostr_course_name;
	
	@Column(name = "ostr_course_details")
    private String ostr_course_details;
	
	@Column(name = "oimg_url")
	private String oimg_url;
	
	@Column(name = "onum_is_active")
    private Integer onum_is_active;
	
	@Column(name = "odt_entry_date")
    private Date odt_entry_date;

	@ManyToOne
	@JoinColumn(name = "onum_user_id")
	private AdminDetailDto adminDetailDto;
	
	public AdminDetailDto getAdminDetailDto() {
		return adminDetailDto;
	}

	public void setAdminDetailDto(AdminDetailDto adminDetailDto) {
		this.adminDetailDto = adminDetailDto;
	}

	
	public Integer getOnum_slno() {
		return onum_slno;
	}

	public void setOnum_slno(Integer onum_slno) {
		this.onum_slno = onum_slno;
	}

	public String getOstr_course_name() {
		return ostr_course_name;
	}

	public void setOstr_course_name(String ostr_course_name) {
		this.ostr_course_name = ostr_course_name;
	}

	public String getOstr_course_details() {
		return ostr_course_details;
	}

	public void setOstr_course_details(String ostr_course_details) {
		this.ostr_course_details = ostr_course_details;
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

	public String getOimg_url() {
		return oimg_url;
	}

	public void setOimg_url(String oimg_url) {
		this.oimg_url = oimg_url;
	}
	
    
    	    
}
