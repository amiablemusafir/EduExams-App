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

@Entity @Table(name = "oes_notification_details") @Proxy(lazy=false)
public class NotificationDetailsDto {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)    
	@Column(name = "onum_slno")
	private Integer onum_slno;
	
	@Column(name = "ostr_notification_details")
	private String ostr_notification_details;
	
	@Column(name = "ostr_date")
	private String ostr_date;
	
	@ManyToOne
	@JoinColumn(name = "onum_user_id")
	private AdminDetailDto adminDetailDto;
	
	@ManyToOne
	@JoinColumn(name = "onum_student_user_id")
	private AdminDetailDto studentsDetailDto;
	
	@Column(name = "ostr_status")
	private String ostr_status;	 // 1 For everyone, 2 For All Student, 3 Only for employees, 4 only for superadmin
	
	@Column(name = "onum_is_active")
    private Integer onum_is_active;

	@Column(name = "odt_entry_date")
    private Date odt_entry_date;
	
	public Date getOdt_entry_date() {
		return odt_entry_date;
	}

	public void setOdt_entry_date(Date odt_entry_date) {
		this.odt_entry_date = odt_entry_date;
	}

	public Integer getOnum_slno() {
		return onum_slno;
	}

	public void setOnum_slno(Integer onum_slno) {
		this.onum_slno = onum_slno;
	}

	public String getOstr_notification_details() {
		return ostr_notification_details;
	}

	public void setOstr_notification_details(String ostr_notification_details) {
		this.ostr_notification_details = ostr_notification_details;
	}

	public String getOstr_date() {
		return ostr_date;
	}

	public void setOstr_date(String ostr_date) {
		this.ostr_date = ostr_date;
	}

	public AdminDetailDto getAdminDetailDto() {
		return adminDetailDto;
	}

	public void setAdminDetailDto(AdminDetailDto adminDetailDto) {
		this.adminDetailDto = adminDetailDto;
	}

	public AdminDetailDto getStudentsDetailDto() {
		return studentsDetailDto;
	}

	public void setStudentsDetailDto(AdminDetailDto studentsDetailDto) {
		this.studentsDetailDto = studentsDetailDto;
	}

	public String getOstr_status() {
		return ostr_status;
	}

	public void setOstr_status(String ostr_status) {
		this.ostr_status = ostr_status;
	}

	public Integer getOnum_is_active() {
		return onum_is_active;
	}

	public void setOnum_is_active(Integer onum_is_active) {
		this.onum_is_active = onum_is_active;
	}
}
