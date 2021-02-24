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

@Entity @Table(name = "oes_exam_request_details") @Proxy(lazy=false)
public class ExamRequestDetailsDto implements Serializable{
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)    
	@Column(name = "onum_id")
	private Integer onum_id;
	
	@ManyToOne
	@JoinColumn(name = "onum_exam_id")
	private ExamDetailsDto  examDetailsDto;
	
	@ManyToOne
	@JoinColumn(name = "onum_student_id")
	private StudentDetailsDto studentDetailsDto;
	
	@Column(name = "ostr_user_remark")
    private String ostr_user_remark;
	
	@Column(name = "ostr_admin_remark")
    private String ostr_admin_remark;
	
	@Column(name = "odt_request_date")
    private String odt_request_date;
	
	@Column(name = "onum_status")
    private Integer onum_status;
	
    @Column(name = "onum_is_active")
    private Integer onum_is_active;
	
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

	public StudentDetailsDto getStudentDetailsDto() {
		return studentDetailsDto;
	}

	public void setStudentDetailsDto(StudentDetailsDto studentDetailsDto) {
		this.studentDetailsDto = studentDetailsDto;
	}

	public String getOstr_user_remark() {
		return ostr_user_remark;
	}

	public void setOstr_user_remark(String ostr_user_remark) {
		this.ostr_user_remark = ostr_user_remark;
	}

	public String getOstr_admin_remark() {
		return ostr_admin_remark;
	}

	public void setOstr_admin_remark(String ostr_admin_remark) {
		this.ostr_admin_remark = ostr_admin_remark;
	}

	public String getOdt_request_date() {
		return odt_request_date;
	}

	public void setOdt_request_date(String odt_request_date) {
		this.odt_request_date = odt_request_date;
	}

	public Integer getOnum_status() {
		return onum_status;
	}

	public void setOnum_status(Integer onum_status) {
		this.onum_status = onum_status;
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
