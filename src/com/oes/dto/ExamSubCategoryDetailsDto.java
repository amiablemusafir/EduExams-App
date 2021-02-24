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

public class ExamSubCategoryDetailsDto implements Serializable{
	
	private Integer onum_id;	
	private SubCategoryDetailsDto subCategoryDetailsDto;	
	private Integer onum_total_question;	
	private Integer onum_total_marks;
	
	public Integer getOnum_id() {
		return onum_id;
	}

	public void setOnum_id(Integer onum_id) {
		this.onum_id = onum_id;
	}

	public SubCategoryDetailsDto getSubCategoryDetailsDto() {
		return subCategoryDetailsDto;
	}

	public void setSubCategoryDetailsDto(SubCategoryDetailsDto subCategoryDetailsDto) {
		this.subCategoryDetailsDto = subCategoryDetailsDto;
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
}
