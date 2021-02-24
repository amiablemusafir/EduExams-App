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

@Entity @Table(name = "oes_change_password") @Proxy(lazy=false)
public class ChangePasswordDto {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)    
	@Column(name = "onum_slno")
	private Integer onum_slno;
	
	@Column(name = "ostr_link")
	private String ostr_link;
	
	@Column(name = "onum_is_active")
    private Integer onum_is_active;

	@ManyToOne
	@JoinColumn(name = "onum_user_id")
	private AdminDetailDto adminDetailDto;

	
	public Integer getOnum_slno() {
		return onum_slno;
	}

	public void setOnum_slno(Integer onum_slno) {
		this.onum_slno = onum_slno;
	}

	public String getOstr_link() {
		return ostr_link;
	}

	public void setOstr_link(String ostr_link) {
		this.ostr_link = ostr_link;
	}

	public Integer getOnum_is_active() {
		return onum_is_active;
	}

	public void setOnum_is_active(Integer onum_is_active) {
		this.onum_is_active = onum_is_active;
	}

	public AdminDetailDto getAdminDetailDto() {
		return adminDetailDto;
	}

	public void setAdminDetailDto(AdminDetailDto adminDetailDto) {
		this.adminDetailDto = adminDetailDto;
	}
}
