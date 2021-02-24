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

@Entity @Table(name = "oes_exam_question_details") @Proxy(lazy=false)
public class ExamQuestionDetailsDto implements Serializable{
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)    
	@Column(name = "onum_exam_question_details_id")
	private Integer onum_exam_question_details_id;
	
	@ManyToOne
	@JoinColumn(name = "onum_exam_id")
	private ExamDetailsDto  examDetailsDto;
	
	@ManyToOne
	@JoinColumn(name = "onum_section_id")
	private SectionDetailsDto sectionDetailsDto;
	
	@ManyToOne
	@JoinColumn(name = "onum_question_id")
	private QuestionDetailsDto questionDetailsDto;
	
	@ManyToOne
	@JoinColumn(name = "onum_category_id")
	private CategoryDetailsDto categoryDetailsDto;
		
	@ManyToOne
	@JoinColumn(name = "onum_sub_category_id")
	private SubCategoryDetailsDto subCategoryDetailsDto;
	
	@Column(name = "markDetails")
	private Double markDetails; 
	
	@Column(name = "onum_is_active")
    private Integer onum_is_active;
	
	@Column(name = "odt_entry_date")
    private Date odt_entry_date;

	
	public CategoryDetailsDto getCategoryDetailsDto() {
		return categoryDetailsDto;
	}

	public void setCategoryDetailsDto(CategoryDetailsDto categoryDetailsDto) {
		this.categoryDetailsDto = categoryDetailsDto;
	}

	public SubCategoryDetailsDto getSubCategoryDetailsDto() {
		return subCategoryDetailsDto;
	}

	public void setSubCategoryDetailsDto(SubCategoryDetailsDto subCategoryDetailsDto) {
		this.subCategoryDetailsDto = subCategoryDetailsDto;
	}

	public Double getMarkDetails() {
		return markDetails;
	}

	public void setMarkDetails(Double markDetails) {
		this.markDetails = markDetails;
	}

	public Integer getOnum_exam_question_details_id() {
		return onum_exam_question_details_id;
	}

	public void setOnum_exam_question_details_id(
			Integer onum_exam_question_details_id) {
		this.onum_exam_question_details_id = onum_exam_question_details_id;
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

	public QuestionDetailsDto getQuestionDetailsDto() {
		return questionDetailsDto;
	}

	public void setQuestionDetailsDto(QuestionDetailsDto questionDetailsDto) {
		this.questionDetailsDto = questionDetailsDto;
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
