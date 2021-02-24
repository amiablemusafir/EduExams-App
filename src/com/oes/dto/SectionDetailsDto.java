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

@Entity @Table(name = "oes_section_details") @Proxy(lazy=false)
public class SectionDetailsDto implements Serializable{
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)    
	@Column(name = "onum_slno")
	private Integer onum_slno;
	
	@Column(name = "ostr_section_name")
	private String ostr_section_name;
	
	@Column(name = "onum_total_question")
    private Integer onum_total_question;
	
	@Column(name = "onum_remaining_question")
    private Integer onum_remaining_question;
	
	@Column(name = "ostr_section_details")
    private String ostr_section_details;
	
	@ManyToOne
	@JoinColumn(name = "onum_category_id")
	private CategoryDetailsDto categoryDetailsDto;
		
	@ManyToOne
	@JoinColumn(name = "onum_sub_category_id")
	private SubCategoryDetailsDto subCategoryDetailsDto;
		
	@ManyToOne
	@JoinColumn(name = "inum_paragraph_id")
	private ParagraphDetailsDto paragraphDetailsDto;
	
	@Column(name = "inum_is_paragraph")
    private Integer inum_is_paragraph;
	
	@Column(name = "onum_is_active")
    private Integer onum_is_active;
	
	@Column(name = "odt_entry_date")
    private Date odt_entry_date;

	@ManyToOne
	@JoinColumn(name = "onum_user_id")
	private AdminDetailDto adminDetailDto;
	
	public AdminDetailDto getAdminDetailDto() {
		return adminDetailDto;
	}

	public void setAdminDetailDto(AdminDetailDto adminDetailDto) {
		this.adminDetailDto = adminDetailDto;
	}

	
	public ParagraphDetailsDto getParagraphDetailsDto() {
		return paragraphDetailsDto;
	}

	public void setParagraphDetailsDto(ParagraphDetailsDto paragraphDetailsDto) {
		this.paragraphDetailsDto = paragraphDetailsDto;
	}

	public Integer getInum_is_paragraph() {
		return inum_is_paragraph;
	}

	public void setInum_is_paragraph(Integer inum_is_paragraph) {
		this.inum_is_paragraph = inum_is_paragraph;
	}

	public Integer getOnum_slno() {
		return onum_slno;
	}

	public void setOnum_slno(Integer onumSlno) {
		onum_slno = onumSlno;
	}

	public Integer getOnum_remaining_question() {
		return onum_remaining_question;
	}

	public void setOnum_remaining_question(Integer onumRemainingQuestion) {
		onum_remaining_question = onumRemainingQuestion;
	}

	public String getOstr_section_name() {
		return ostr_section_name;
	}

	public void setOstr_section_name(String ostrSectionName) {
		ostr_section_name = ostrSectionName;
	}

	public Integer getOnum_total_question() {
		return onum_total_question;
	}

	public void setOnum_total_question(Integer onumTotalQuestion) {
		onum_total_question = onumTotalQuestion;
	}

	public String getOstr_section_details() {
		return ostr_section_details;
	}

	public void setOstr_section_details(String ostrSectionDetails) {
		ostr_section_details = ostrSectionDetails;
	}

	public Integer getOnum_is_active() {
		return onum_is_active;
	}

	public void setOnum_is_active(Integer onumIsActive) {
		onum_is_active = onumIsActive;
	}

	public Date getOdt_entry_date() {
		return odt_entry_date;
	}

	public void setOdt_entry_date(Date odtEntryDate) {
		odt_entry_date = odtEntryDate;
	}

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

}
