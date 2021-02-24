package com.oes.dto;

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

@Entity @Table(name = "oes_dashboard") @Proxy(lazy=false)
public class DashBoardDto {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)    
	@Column(name = "onum_slno")
	private Integer onum_slno;
	
	@Column(name = "ostr_dashboard")
	private String ostr_dashboard;
	
	@Column(name = "ostr_notice")
	private String ostr_notice;
	
	@Column(name = "onum_is_active")
    private Integer onum_is_active;

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

	public String getOstr_dashboard() {
		return ostr_dashboard;
	}

	public void setOstr_dashboard(String ostr_dashboard) {
		this.ostr_dashboard = ostr_dashboard;
	}

	public String getOstr_notice() {
		return ostr_notice;
	}

	public void setOstr_notice(String ostr_notice) {
		this.ostr_notice = ostr_notice;
	}

	public Integer getOnum_is_active() {
		return onum_is_active;
	}

	public void setOnum_is_active(Integer onum_is_active) {
		this.onum_is_active = onum_is_active;
	}
}
