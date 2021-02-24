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

@Entity @Table(name = "oes_result_details") @Proxy(lazy=false)
public class ResultDetailsDto implements Serializable{
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)    
	@Column(name = "onum_result_details_id")
	private Integer onum_result_details_id;
	
	@ManyToOne
	@JoinColumn(name = "onum_exam_id")
	private ExamDetailsDto examDetailsDto;
	
	@ManyToOne
	@JoinColumn(name = "onum_student_id")
	private StudentDetailsDto studentDetailsDto;
	
	@Column(name = "ostr_date")
	private String ostr_date;
	
	@Column(name = "ostr_time")
    private String ostr_time;
	
    @Column(name = "onum_wright")
    private Integer onum_wright;
    
    @Column(name = "onum_wrong")
    private Integer onum_wrong;
	
    @Column(name = "onum_left")
    private Integer onum_left;
    
    @Column(name = "odec_total_mark")
    private Double odec_total_mark;
    
    @Column(name = "odec_accuracy")
    private Double odec_accuracy;
    
    @Column(name = "onum_total_question")
    private Integer onum_total_question;
    
    @Column(name = "odec_total_obtain_mark")
    private Double odec_total_obtain_mark;

    @Column(name = "odec_total_negative_mark")
    private Double odec_total_negative_mark;
    
    @Column(name = "onum_rank")
    private Integer onum_rank;
	
	@Column(name = "onum_is_active")
    private Integer onum_is_active;
	
	@Column(name = "odt_entry_date")
    private Date odt_entry_date;

	public Double getOdec_accuracy() {
		return odec_accuracy;
	}

	public void setOdec_accuracy(Double odec_accuracy) {
		this.odec_accuracy = odec_accuracy;
	}

	public Integer getOnum_total_question() {
		return onum_total_question;
	}

	public void setOnum_total_question(Integer onum_total_question) {
		this.onum_total_question = onum_total_question;
	}

	public Double getOdec_total_obtain_mark() {
		return odec_total_obtain_mark;
	}

	public void setOdec_total_obtain_mark(Double odec_total_obtain_mark) {
		this.odec_total_obtain_mark = odec_total_obtain_mark;
	}

	public Double getOdec_total_negative_mark() {
		return odec_total_negative_mark;
	}

	public void setOdec_total_negative_mark(Double odec_total_negative_mark) {
		this.odec_total_negative_mark = odec_total_negative_mark;
	}

	public Integer getOnum_result_details_id() {
		return onum_result_details_id;
	}

	public void setOnum_result_details_id(Integer onum_result_details_id) {
		this.onum_result_details_id = onum_result_details_id;
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

	public String getOstr_date() {
		return ostr_date;
	}

	public void setOstr_date(String ostr_date) {
		this.ostr_date = ostr_date;
	}

	public String getOstr_time() {
		return ostr_time;
	}

	public void setOstr_time(String ostr_time) {
		this.ostr_time = ostr_time;
	}

	public Integer getOnum_wright() {
		return onum_wright;
	}

	public void setOnum_wright(Integer onum_wright) {
		this.onum_wright = onum_wright;
	}

	public Integer getOnum_wrong() {
		return onum_wrong;
	}

	public void setOnum_wrong(Integer onum_wrong) {
		this.onum_wrong = onum_wrong;
	}

	public Integer getOnum_left() {
		return onum_left;
	}

	public void setOnum_left(Integer onum_left) {
		this.onum_left = onum_left;
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

	public Double getOdec_total_mark() {
		return odec_total_mark;
	}

	public void setOdec_total_mark(Double odec_total_mark) {
		this.odec_total_mark = odec_total_mark;
	}

	public Integer getOnum_rank() {
		return onum_rank;
	}

	public void setOnum_rank(Integer onum_rank) {
		this.onum_rank = onum_rank;
	}	
	
}
