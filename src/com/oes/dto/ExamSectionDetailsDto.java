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

@Entity @Table(name = "oes_exam_section_details") @Proxy(lazy=false)
public class ExamSectionDetailsDto implements Serializable{
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)    
	@Column(name = "onum_id")
	private Integer onum_id;
	
	@ManyToOne
	@JoinColumn(name = "onum_exam_id")
	private ExamDetailsDto  examDetailsDto;
	
	@ManyToOne
	@JoinColumn(name = "onum_section_id")
	private SectionDetailsDto sectionDetailsDto;
	
	@Column(name = "onum_total_question")
    private Integer onum_total_question;
	
	@Column(name = "onum_total_marks")
    private Integer onum_total_marks;
	
	@Column(name = "onum_remaining_question")
    private Integer onum_remaining_question;
	
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

	public SectionDetailsDto getSectionDetailsDto() {
		return sectionDetailsDto;
	}

	public void setSectionDetailsDto(SectionDetailsDto sectionDetailsDto) {
		this.sectionDetailsDto = sectionDetailsDto;
	}

	public Integer getOnum_total_question() {
		return onum_total_question;
	}

	public void setOnum_total_question(Integer onum_total_question) {
		this.onum_total_question = onum_total_question;
	}

	public Integer getOnum_total_marks() {
		return onum_total_marks;
	}

	public void setOnum_total_marks(Integer onum_total_marks) {
		this.onum_total_marks = onum_total_marks;
	}

	public Integer getOnum_remaining_question() {
		return onum_remaining_question;
	}

	public void setOnum_remaining_question(Integer onum_remaining_question) {
		this.onum_remaining_question = onum_remaining_question;
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
