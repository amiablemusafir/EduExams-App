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

@Entity @Table(name = "oes_result_description") @Proxy(lazy=false)
public class ResultDescriptionDto implements Serializable{
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)    
	@Column(name = "onum_result_description_id")
	private Integer onum_result_description_id;
	
	@ManyToOne
	@JoinColumn(name = "onum_result_details_id")
	private ResultDetailsDto resultDetailsDto;
	
	@ManyToOne
	@JoinColumn(name = "onum_exam_question_details_id")
	private ExamQuestionDetailsDto examQuestionDetailsDto;
	
	@Column(name = "onum_selected_option")
	private Integer onum_selected_option;
	
	@Column(name = "onum_correct_option")
    private Integer onum_correct_option;
	
    @Column(name = "onum_is_active")
    private Integer onum_is_active;
	
	@Column(name = "odt_entry_date")
    private Date odt_entry_date;

	public Integer getOnum_result_description_id() {
		return onum_result_description_id;
	}

	public void setOnum_result_description_id(Integer onum_result_description_id) {
		this.onum_result_description_id = onum_result_description_id;
	}

	public ResultDetailsDto getResultDetailsDto() {
		return resultDetailsDto;
	}

	public void setResultDetailsDto(ResultDetailsDto resultDetailsDto) {
		this.resultDetailsDto = resultDetailsDto;
	}

	public ExamQuestionDetailsDto getExamQuestionDetailsDto() {
		return examQuestionDetailsDto;
	}

	public void setExamQuestionDetailsDto(
			ExamQuestionDetailsDto examQuestionDetailsDto) {
		this.examQuestionDetailsDto = examQuestionDetailsDto;
	}

	public Integer getOnum_selected_option() {
		return onum_selected_option;
	}

	public void setOnum_selected_option(Integer onum_selected_option) {
		this.onum_selected_option = onum_selected_option;
	}

	public Integer getOnum_correct_option() {
		return onum_correct_option;
	}

	public void setOnum_correct_option(Integer onum_correct_option) {
		this.onum_correct_option = onum_correct_option;
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
