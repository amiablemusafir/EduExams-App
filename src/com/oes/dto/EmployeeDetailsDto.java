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

@Entity @Table(name = "oes_employee_details") @Proxy(lazy=false)
public class EmployeeDetailsDto {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)    
	@Column(name = "inum_employee_id")
	private Integer inum_employee_id;
	
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
	
	@Column(name = "istr_designation")
	private String istr_designation;
	
	@Column(name = "istr_department")
	private String istr_department;
		
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
	
	
	
	@Column(name = "istr_exam1")
	private String istr_exam1;
	@Column(name = "istr_board1")
	private String istr_board1;
	@Column(name = "istr_y_o_p1")
	private String istr_y_o_p1;
	@Column(name = "istr_mark1")
	private String istr_mark1;
	@Column(name = "istr_name_of_school1")
	private String istr_name_of_school1;
	
	@Column(name = "istr_exam2")
	private String istr_exam2;
	@Column(name = "istr_board2")
	private String istr_board2;
	@Column(name = "istr_y_o_p2")
	private String istr_y_o_p2;
	@Column(name = "istr_mark2")
	private String istr_mark2;
	@Column(name = "istr_name_of_school2")
	private String istr_name_of_school2;
	
	@Column(name = "istr_exam3")
	private String istr_exam3;
	@Column(name = "istr_board3")
	private String istr_board3;
	@Column(name = "istr_y_o_p3")
	private String istr_y_o_p3;
	@Column(name = "istr_mark3")
	private String istr_mark3;
	@Column(name = "istr_name_of_school3")
	private String istr_name_of_school3;
	
	
	@Column(name = "istr_company_name1")
	private String istr_company_name1;
	@Column(name = "istr_total_exp1")
	private String istr_total_exp1;
	@Column(name = "istr_from_date1")
	private String istr_from_date1;
	@Column(name = "istr_to_date1")
	private String istr_to_date1;
	@Column(name = "istr_remarks1")
	private String istr_remarks1;
	
	
	@Column(name = "istr_company_name2")
	private String istr_company_name2;
	@Column(name = "istr_total_exp2")
	private String istr_total_exp2;
	@Column(name = "istr_from_date2")
	private String istr_from_date2;
	@Column(name = "istr_to_date2")
	private String istr_to_date2;
	@Column(name = "istr_remarks2")
	private String istr_remarks2;
	
	
	@Column(name = "idt_entry_date")
	private java.util.Date idt_entry_date;
	
	@Column(name = "inum_is_active")
	private Integer inum_is_active;

	@ManyToOne
	@JoinColumn(name = "onum_user_id")
	private AdminDetailDto adminDetailDto;
	
	@ManyToOne
	@JoinColumn(name = "onum_institute_id")
	private InstituteDetailsDto instituteDetailsDto;
	
	
	public InstituteDetailsDto getInstituteDetailsDto() {
		return instituteDetailsDto;
	}

	public void setInstituteDetailsDto(InstituteDetailsDto instituteDetailsDto) {
		this.instituteDetailsDto = instituteDetailsDto;
	}

	public AdminDetailDto getAdminDetailDto() {
		return adminDetailDto;
	}

	public void setAdminDetailDto(AdminDetailDto adminDetailDto) {
		this.adminDetailDto = adminDetailDto;
	}

	
	public Integer getInum_employee_id() {
		return inum_employee_id;
	}

	public void setInum_employee_id(Integer inum_employee_id) {
		this.inum_employee_id = inum_employee_id;
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

	public String getIstr_designation() {
		return istr_designation;
	}

	public void setIstr_designation(String istr_designation) {
		this.istr_designation = istr_designation;
	}

	public String getIstr_department() {
		return istr_department;
	}

	public void setIstr_department(String istr_department) {
		this.istr_department = istr_department;
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

	public String getIstr_exam1() {
		return istr_exam1;
	}

	public void setIstr_exam1(String istr_exam1) {
		this.istr_exam1 = istr_exam1;
	}

	public String getIstr_board1() {
		return istr_board1;
	}

	public void setIstr_board1(String istr_board1) {
		this.istr_board1 = istr_board1;
	}

	public String getIstr_y_o_p1() {
		return istr_y_o_p1;
	}

	public void setIstr_y_o_p1(String istr_y_o_p1) {
		this.istr_y_o_p1 = istr_y_o_p1;
	}

	public String getIstr_mark1() {
		return istr_mark1;
	}

	public void setIstr_mark1(String istr_mark1) {
		this.istr_mark1 = istr_mark1;
	}

	public String getIstr_name_of_school1() {
		return istr_name_of_school1;
	}

	public void setIstr_name_of_school1(String istr_name_of_school1) {
		this.istr_name_of_school1 = istr_name_of_school1;
	}

	public String getIstr_exam2() {
		return istr_exam2;
	}

	public void setIstr_exam2(String istr_exam2) {
		this.istr_exam2 = istr_exam2;
	}

	public String getIstr_board2() {
		return istr_board2;
	}

	public void setIstr_board2(String istr_board2) {
		this.istr_board2 = istr_board2;
	}

	public String getIstr_y_o_p2() {
		return istr_y_o_p2;
	}

	public void setIstr_y_o_p2(String istr_y_o_p2) {
		this.istr_y_o_p2 = istr_y_o_p2;
	}

	public String getIstr_mark2() {
		return istr_mark2;
	}

	public void setIstr_mark2(String istr_mark2) {
		this.istr_mark2 = istr_mark2;
	}

	public String getIstr_name_of_school2() {
		return istr_name_of_school2;
	}

	public void setIstr_name_of_school2(String istr_name_of_school2) {
		this.istr_name_of_school2 = istr_name_of_school2;
	}

	public String getIstr_exam3() {
		return istr_exam3;
	}

	public void setIstr_exam3(String istr_exam3) {
		this.istr_exam3 = istr_exam3;
	}

	public String getIstr_board3() {
		return istr_board3;
	}

	public void setIstr_board3(String istr_board3) {
		this.istr_board3 = istr_board3;
	}

	public String getIstr_y_o_p3() {
		return istr_y_o_p3;
	}

	public void setIstr_y_o_p3(String istr_y_o_p3) {
		this.istr_y_o_p3 = istr_y_o_p3;
	}

	public String getIstr_mark3() {
		return istr_mark3;
	}

	public void setIstr_mark3(String istr_mark3) {
		this.istr_mark3 = istr_mark3;
	}

	public String getIstr_name_of_school3() {
		return istr_name_of_school3;
	}

	public void setIstr_name_of_school3(String istr_name_of_school3) {
		this.istr_name_of_school3 = istr_name_of_school3;
	}

	public String getIstr_company_name1() {
		return istr_company_name1;
	}

	public void setIstr_company_name1(String istr_company_name1) {
		this.istr_company_name1 = istr_company_name1;
	}

	public String getIstr_total_exp1() {
		return istr_total_exp1;
	}

	public void setIstr_total_exp1(String istr_total_exp1) {
		this.istr_total_exp1 = istr_total_exp1;
	}

	public String getIstr_from_date1() {
		return istr_from_date1;
	}

	public void setIstr_from_date1(String istr_from_date1) {
		this.istr_from_date1 = istr_from_date1;
	}

	public String getIstr_to_date1() {
		return istr_to_date1;
	}

	public void setIstr_to_date1(String istr_to_date1) {
		this.istr_to_date1 = istr_to_date1;
	}

	public String getIstr_remarks1() {
		return istr_remarks1;
	}

	public void setIstr_remarks1(String istr_remarks1) {
		this.istr_remarks1 = istr_remarks1;
	}

	public String getIstr_company_name2() {
		return istr_company_name2;
	}

	public void setIstr_company_name2(String istr_company_name2) {
		this.istr_company_name2 = istr_company_name2;
	}

	public String getIstr_total_exp2() {
		return istr_total_exp2;
	}

	public void setIstr_total_exp2(String istr_total_exp2) {
		this.istr_total_exp2 = istr_total_exp2;
	}

	public String getIstr_from_date2() {
		return istr_from_date2;
	}

	public void setIstr_from_date2(String istr_from_date2) {
		this.istr_from_date2 = istr_from_date2;
	}

	public String getIstr_to_date2() {
		return istr_to_date2;
	}

	public void setIstr_to_date2(String istr_to_date2) {
		this.istr_to_date2 = istr_to_date2;
	}

	public String getIstr_remarks2() {
		return istr_remarks2;
	}

	public void setIstr_remarks2(String istr_remarks2) {
		this.istr_remarks2 = istr_remarks2;
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
}
