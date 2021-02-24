package com.oes.dto;

import java.io.File;
import java.sql.Blob;
import java.sql.Date;
import java.sql.Timestamp;

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

@Entity @Table(name = "oes_student_details") @Proxy(lazy=false)
public class StudentDetailsDto {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)    
	@Column(name = "inum_student_id")
	private Integer inum_student_id;
	
	@Column(name = "istr_unique_id")
	private String istr_unique_id;
	
	@Column(name = "idt_registration_date")
	private String idt_registration_date;
	
	@Column(name = "istr_first_name")
	private String istr_first_name;
	
	@Column(name = "istr_last_name")
	private String istr_last_name;
	
	@Column(name = "istr_date_of_birth")
	private String istr_date_of_birth;
	
	@Column(name = "istr_gender")
	private String istr_gender;
	
	@Column(name = "istr_class")
	private String istr_class;
	
	@Column(name = "istr_class_teacher")
	private String istr_class_teacher;
	
	@Column(name = "istr_section")
	private String istr_section;
	
	@Column(name = "ibl_std_pic")
	private String ibl_std_pic;
	
	@Column(name = "istr_father_name")
	private String istr_father_name;
	
	@Column(name = "istr_father_occupation")
	private String istr_father_occupation;
	
	@Column(name = "istr_mother_name")
	private String istr_mother_name;
	
	@Column(name = "inum_landline_number")
	private String inum_landline_number;
	
	@Column(name = "inum_mobile_number")
	private String inum_mobile_number;
	
	@Column(name = "istr_email")
	private String istr_email;
	
	@Column(name = "istr_street_address")
	private String istr_street_address;
	
	@Column(name = "istr_state_name")
	private String istr_state_name;
	
	@Column(name = "istr_district_name")
	private String istr_district_name;
	
	@Column(name = "istr_town_name")
	private String istr_town_name;
	
	@Column(name = "istr_pin_code")
	private String istr_pin_code;
	
	@Column(name = "idt_entry_date")
	private java.util.Date idt_entry_date;
	
	@Column(name = "inum_is_active")
	private Integer inum_is_active;
	
	@Column(name = "inum_status")
	private Integer inum_status;

	@ManyToOne
	@JoinColumn(name = "onum_user_id")
	private AdminDetailDto adminDetailDto;
	
	public AdminDetailDto getAdminDetailDto() {
		return adminDetailDto;
	}

	public void setAdminDetailDto(AdminDetailDto adminDetailDto) {
		this.adminDetailDto = adminDetailDto;
	}

	
	public Integer getInum_student_id() {
		return inum_student_id;
	}

	public void setInum_student_id(Integer inum_student_id) {
		this.inum_student_id = inum_student_id;
	}

	public String getIstr_unique_id() {
		return istr_unique_id;
	}

	public void setIstr_unique_id(String istr_unique_id) {
		this.istr_unique_id = istr_unique_id;
	}

	public String getIdt_registration_date() {
		return idt_registration_date;
	}

	public void setIdt_registration_date(String idt_registration_date) {
		this.idt_registration_date = idt_registration_date;
	}

	public String getIstr_first_name() {
		return istr_first_name;
	}

	public void setIstr_first_name(String istr_first_name) {
		this.istr_first_name = istr_first_name;
	}

	public String getIstr_last_name() {
		return istr_last_name;
	}

	public void setIstr_last_name(String istr_last_name) {
		this.istr_last_name = istr_last_name;
	}

	public String getIstr_date_of_birth() {
		return istr_date_of_birth;
	}

	public void setIstr_date_of_birth(String istr_date_of_birth) {
		this.istr_date_of_birth = istr_date_of_birth;
	}

	public String getIstr_gender() {
		return istr_gender;
	}

	public void setIstr_gender(String istr_gender) {
		this.istr_gender = istr_gender;
	}

	public String getIstr_class() {
		return istr_class;
	}

	public void setIstr_class(String istr_class) {
		this.istr_class = istr_class;
	}

	public String getIstr_class_teacher() {
		return istr_class_teacher;
	}

	public void setIstr_class_teacher(String istr_class_teacher) {
		this.istr_class_teacher = istr_class_teacher;
	}

	public String getIstr_section() {
		return istr_section;
	}

	public void setIstr_section(String istr_section) {
		this.istr_section = istr_section;
	}

	public String getIbl_std_pic() {
		return ibl_std_pic;
	}

	public void setIbl_std_pic(String ibl_std_pic) {
		this.ibl_std_pic = ibl_std_pic;
	}

	public String getIstr_father_name() {
		return istr_father_name;
	}

	public void setIstr_father_name(String istr_father_name) {
		this.istr_father_name = istr_father_name;
	}

	public String getIstr_father_occupation() {
		return istr_father_occupation;
	}

	public void setIstr_father_occupation(String istr_father_occupation) {
		this.istr_father_occupation = istr_father_occupation;
	}

	public String getIstr_mother_name() {
		return istr_mother_name;
	}

	public void setIstr_mother_name(String istr_mother_name) {
		this.istr_mother_name = istr_mother_name;
	}

	public String getInum_landline_number() {
		return inum_landline_number;
	}

	public void setInum_landline_number(String inum_landline_number) {
		this.inum_landline_number = inum_landline_number;
	}

	public String getInum_mobile_number() {
		return inum_mobile_number;
	}

	public void setInum_mobile_number(String inum_mobile_number) {
		this.inum_mobile_number = inum_mobile_number;
	}

	public String getIstr_email() {
		return istr_email;
	}

	public void setIstr_email(String istr_email) {
		this.istr_email = istr_email;
	}

	public String getIstr_street_address() {
		return istr_street_address;
	}

	public void setIstr_street_address(String istr_street_address) {
		this.istr_street_address = istr_street_address;
	}

	public String getIstr_state_name() {
		return istr_state_name;
	}

	public void setIstr_state_name(String istr_state_name) {
		this.istr_state_name = istr_state_name;
	}

	public String getIstr_district_name() {
		return istr_district_name;
	}

	public void setIstr_district_name(String istr_district_name) {
		this.istr_district_name = istr_district_name;
	}

	public String getIstr_town_name() {
		return istr_town_name;
	}

	public void setIstr_town_name(String istr_town_name) {
		this.istr_town_name = istr_town_name;
	}

	public String getIstr_pin_code() {
		return istr_pin_code;
	}

	public void setIstr_pin_code(String istr_pin_code) {
		this.istr_pin_code = istr_pin_code;
	}

	public java.util.Date getIdt_entry_date() {
		return idt_entry_date;
	}

	public void setIdt_entry_date(java.util.Date idt_entry_date) {
		this.idt_entry_date = idt_entry_date;
	}

	public Integer getInum_is_active() {
		return inum_is_active;
	}

	public void setInum_is_active(Integer inum_is_active) {
		this.inum_is_active = inum_is_active;
	}

	public Integer getInum_status() {
		return inum_status;
	}

	public void setInum_status(Integer inumStatus) {
		inum_status = inumStatus;
	}
}
