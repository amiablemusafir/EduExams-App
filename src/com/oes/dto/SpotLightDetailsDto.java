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

@Entity @Table(name = "oes_spotlight_details") @Proxy(lazy=false)
public class SpotLightDetailsDto implements Serializable{
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)    
	@Column(name = "onum_id")
	private Integer onum_id;
	
	@Column(name = "ostr_message")
    private String ostr_message;
	
	@Column(name = "ostr_headline")
    private String ostr_headline;
	
	@Column(name = "ostr_sub_headline")
    private String ostr_sub_headline;
	
	@Column(name = "ostr_short_description")
    private String ostr_short_description;
	
	@Column(name = "ostr_image_url")
    private String ostr_image_url;
	
	@Column(name = "onum_is_active")
    private Integer onum_is_active;
	
	@Column(name = "odt_entry_date")
    private Date odt_entry_date;
	
	@ManyToOne
	@JoinColumn(name = "onum_content_id")
	private ContentDetailsDto contentDetailsDto;

	@ManyToOne
	@JoinColumn(name = "onum_user_id")
	private AdminDetailDto adminDetailDto;
	
	
	public String getOstr_sub_headline() {
		return ostr_sub_headline;
	}

	public void setOstr_sub_headline(String ostr_sub_headline) {
		this.ostr_sub_headline = ostr_sub_headline;
	}

	public String getOstr_short_description() {
		return ostr_short_description;
	}

	public void setOstr_short_description(String ostr_short_description) {
		this.ostr_short_description = ostr_short_description;
	}

	public String getOstr_image_url() {
		return ostr_image_url;
	}

	public void setOstr_image_url(String ostr_image_url) {
		this.ostr_image_url = ostr_image_url;
	}

	public String getOstr_headline() {
		return ostr_headline;
	}

	public void setOstr_headline(String ostr_headline) {
		this.ostr_headline = ostr_headline;
	}

	public ContentDetailsDto getContentDetailsDto() {
		return contentDetailsDto;
	}

	public void setContentDetailsDto(ContentDetailsDto contentDetailsDto) {
		this.contentDetailsDto = contentDetailsDto;
	}

	public AdminDetailDto getAdminDetailDto() {
		return adminDetailDto;
	}

	public void setAdminDetailDto(AdminDetailDto adminDetailDto) {
		this.adminDetailDto = adminDetailDto;
	}

	
	public Integer getOnum_id() {
		return onum_id;
	}

	public void setOnum_id(Integer onum_id) {
		this.onum_id = onum_id;
	}

	public String getOstr_message() {
		return ostr_message;
	}

	public void setOstr_message(String ostr_message) {
		this.ostr_message = ostr_message;
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
}
