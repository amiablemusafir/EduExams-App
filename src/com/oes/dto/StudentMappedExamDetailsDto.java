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

@Entity @Table(name = "oes_student_mapped_exam_details") @Proxy(lazy=false)
public class StudentMappedExamDetailsDto implements Serializable{
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)    
	@Column(name = "onum_id")
	private Integer onum_id;
	
	@ManyToOne
	@JoinColumn(name = "onum_exam_id")
	private ExamDetailsDto examDetailsDto;
	
	@ManyToOne
	@JoinColumn(name = "onum_user_id")
	private AdminDetailDto adminDetailDto;
	    	
    @Column(name = "onum_is_active")
    private Integer onum_is_active;
	
	@Column(name = "onum_exam_activation_flag")
    private Integer onum_exam_activation_flag;
	
	@Column(name = "odt_entry_date")
    private Date odt_entry_date;

	public Integer getOnum_id() {
		return onum_id;
	}

	public void setOnum_id(Integer onum_id) {
		this.onum_id = onum_id;
	}

	public ExamDetailsDto getExamDetailsDto() {
		return examDetailsDto;
	}

	public void setExamDetailsDto(ExamDetailsDto examDetailsDto) {
		this.examDetailsDto = examDetailsDto;
	}

	public AdminDetailDto getAdminDetailDto() {
		return adminDetailDto;
	}

	public void setAdminDetailDto(AdminDetailDto adminDetailDto) {
		this.adminDetailDto = adminDetailDto;
	}

	public Integer getOnum_is_active() {
		return onum_is_active;
	}

	public void setOnum_is_active(Integer onum_is_active) {
		this.onum_is_active = onum_is_active;
	}

	public Integer getOnum_exam_activation_flag() {
		return onum_exam_activation_flag;
	}

	public void setOnum_exam_activation_flag(Integer onum_exam_activation_flag) {
		this.onum_exam_activation_flag = onum_exam_activation_flag;
	}

	public Date getOdt_entry_date() {
		return odt_entry_date;
	}

	public void setOdt_entry_date(Date odt_entry_date) {
		this.odt_entry_date = odt_entry_date;
	}	
}
