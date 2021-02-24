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

@Entity @Table(name = "oes_student_exam_details") @Proxy(lazy=false)
public class StudentExamDetailsDto {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)    
	@Column(name = "onum_student_exam_id")
	private Integer onum_student_exam_id;
	
	@ManyToOne
	@JoinColumn(name = "onum_exam_id")
	private ExamDetailsDto examDetailsDto;
	
	@ManyToOne
	@JoinColumn(name = "onum_student_id")
	private StudentDetailsDto studentDetailsDto;
	
	@Column(name = "onum_exam_status")
	private Integer onum_exam_status;
	
	@Column(name = "onum_no_of_time_attempt")
	private Integer onum_no_of_time_attempt;
	
	@Column(name = "onum_is_active")
    private Integer onum_is_active;
	
	@Column(name = "odt_entry_date")
    private Date odt_entry_date;

	public Integer getOnum_student_exam_id() {
		return onum_student_exam_id;
	}

	public void setOnum_student_exam_id(Integer onum_student_exam_id) {
		this.onum_student_exam_id = onum_student_exam_id;
	}

	public StudentDetailsDto getStudentDetailsDto() {
		return studentDetailsDto;
	}

	public void setStudentDetailsDto(StudentDetailsDto studentDetailsDto) {
		this.studentDetailsDto = studentDetailsDto;
	}

	public ExamDetailsDto getExamDetailsDto() {
		return examDetailsDto;
	}

	public void setExamDetailsDto(ExamDetailsDto examDetailsDto) {
		this.examDetailsDto = examDetailsDto;
	}

	public Integer getOnum_exam_status() {
		return onum_exam_status;
	}

	public void setOnum_exam_status(Integer onum_exam_status) {
		this.onum_exam_status = onum_exam_status;
	}

	public Integer getOnum_no_of_time_attempt() {
		return onum_no_of_time_attempt;
	}

	public void setOnum_no_of_time_attempt(Integer onum_no_of_time_attempt) {
		this.onum_no_of_time_attempt = onum_no_of_time_attempt;
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
