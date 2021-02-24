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

@Entity @Table(name = "oes_news_events") @Proxy(lazy=false)
public class NewsAndEventsDto implements Serializable{
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)    
	@Column(name = "gnum_slno")
	private Integer gnum_slno;
	
	@Column(name = "gstr_headline")
	private String gstr_headline;
	
	@Column(name = "gstr_content")
    private String gstr_content;
	
	@Column(name = "gnum_is_active")
    private Integer gnum_is_active;
	
	@Column(name = "gdt_entry_date")
    private Date gdt_entry_date;
	

	@ManyToOne
	@JoinColumn(name = "onum_user_id")
	private AdminDetailDto adminDetailDto;
	
	public AdminDetailDto getAdminDetailDto() {
		return adminDetailDto;
	}

	public void setAdminDetailDto(AdminDetailDto adminDetailDto) {
		this.adminDetailDto = adminDetailDto;
	}

	
    public Integer getGnum_slno() {
		return gnum_slno;
	}
	public void setGnum_slno(Integer gnum_slno) {
		this.gnum_slno = gnum_slno;
	}
	public String getGstr_headline() {
		return gstr_headline;
	}
	public void setGstr_headline(String gstr_headline) {
		this.gstr_headline = gstr_headline;
	}
	public String getGstr_content() {
		return gstr_content;
	}
	public void setGstr_content(String gstr_content) {
		this.gstr_content = gstr_content;
	}
	public Integer getGnum_is_active() {
		return gnum_is_active;
	}
	public void setGnum_is_active(Integer gnum_is_active) {
		this.gnum_is_active = gnum_is_active;
	}
	public Date getGdt_entry_date() {
		return gdt_entry_date;
	}
	public void setGdt_entry_date(Date gdt_entry_date) {
		this.gdt_entry_date = gdt_entry_date;
	}
	    
}
