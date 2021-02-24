package com.oes.dto;

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

@Entity @Table(name = "oes_notice") @Proxy(lazy=false)
public class NoticeDto {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)    
	@Column(name = "gnum_slno")
	private Integer gnum_slno;
	
	@Column(name = "gstr_notice_headline")
	private String gstr_notice_headline;
	
	@Column(name = "gstr_notice")
	private String gstr_notice;
	
	@Column(name = "gnum_is_active")
    private Integer gnum_is_active;
	
	@Column(name = "odt_entry_date")
    private Date odt_entry_date;

	@ManyToOne
	@JoinColumn(name = "onum_user_id")
	private AdminDetailDto adminDetailDto;
	
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
    public Integer getGnum_slno() {
		return gnum_slno;
	}
	public void setGnum_slno(Integer gnum_slno) {
		this.gnum_slno = gnum_slno;
	}
	public String getGstr_notice() {
		return gstr_notice;
	}
	public void setGstr_notice(String gstr_notice) {
		this.gstr_notice = gstr_notice;
	}
	public Integer getGnum_is_active() {
		return gnum_is_active;
	}
	public void setGnum_is_active(Integer gnum_is_active) {
		this.gnum_is_active = gnum_is_active;
	}
	public String getGstr_notice_headline() {
		return gstr_notice_headline;
	}
	public void setGstr_notice_headline(String gstr_notice_headline) {
		this.gstr_notice_headline = gstr_notice_headline;
	}
    
}
