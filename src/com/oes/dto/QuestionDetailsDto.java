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

@Entity @Table(name = "oes_question_details") @Proxy(lazy=false)
public class QuestionDetailsDto implements Serializable{
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)    
	@Column(name = "onum_id")
	private Integer onum_id;
	
	@ManyToOne
	@JoinColumn(name = "onum_section_id")
	private  SectionDetailsDto  sectionDetailsDto;
	
	@ManyToOne
	@JoinColumn(name = "onum_category_id")
	private  CategoryDetailsDto  categoryDetailsDto;
	
	@ManyToOne
	@JoinColumn(name = "onum_sub_category_id")
	private  SubCategoryDetailsDto  subCategoryDetailsDto;
	
	@Column(name = "ostr_solution")
    private String ostr_solution;
	
	@Column(name = "obl_solution")
    private String obl_solution;
	
	@Column(name = "ostr_question")
    private String ostr_question;
	
	@Column(name = "obl_question")
    private String obl_question;
	
    @Column(name = "ostr_option1")
    private String ostr_option1;
    
    @Column(name = "obl_option1")
    private String obl_option1;

    
    @Column(name = "ostr_option2")
    private String ostr_option2;
    
    @Column(name = "obl_option2")
    private String obl_option2;
	
    @Column(name = "ostr_option3")
    private String ostr_option3;
	
    @Column(name = "obl_option3")
    private String obl_option3;
	
    @Column(name = "ostr_option4")
    private String ostr_option4;
    
    @Column(name = "obl_option4")
    private String obl_option4;
    
    @Column(name = "ostr_option5")
    private String ostr_option5;
    
    @Column(name = "obl_option5")
    private String obl_option5;
	
    @Column(name = "ostr_correct_option")
    private String ostr_correct_option;
	
    @Column(name = "odt_entry_date")
    private Date odt_entry_date;

    @Column(name = "onum_is_active")
    private Integer onum_is_active;
    
    @Column(name = "onum_question_status")
    private Integer onum_question_status;
    

	@ManyToOne
	@JoinColumn(name = "onum_user_id")
	private AdminDetailDto adminDetailDto;
	
	public String getOstr_option5() {
		return ostr_option5;
	}

	public void setOstr_option5(String ostr_option5) {
		this.ostr_option5 = ostr_option5;
	}

	public String getObl_option5() {
		return obl_option5;
	}

	public void setObl_option5(String obl_option5) {
		this.obl_option5 = obl_option5;
	}

	public AdminDetailDto getAdminDetailDto() {
		return adminDetailDto;
	}

	public void setAdminDetailDto(AdminDetailDto adminDetailDto) {
		this.adminDetailDto = adminDetailDto;
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

	public String getOstr_solution() {
		return ostr_solution;
	}

	public void setOstr_solution(String ostr_solution) {
		this.ostr_solution = ostr_solution;
	}

	public String getObl_solution() {
		return obl_solution;
	}

	public void setObl_solution(String obl_solution) {
		this.obl_solution = obl_solution;
	}

	public Integer getOnum_id() {
		return onum_id;
	}

	public void setOnum_id(Integer onum_id) {
		this.onum_id = onum_id;
	}

	public SectionDetailsDto getSectionDetailsDto() {
		return sectionDetailsDto;
	}

	public void setSectionDetailsDto(SectionDetailsDto sectionDetailsDto) {
		this.sectionDetailsDto = sectionDetailsDto;
	}

	public String getOstr_question() {
		return ostr_question;
	}

	public void setOstr_question(String ostr_question) {
		this.ostr_question = ostr_question;
	}

	public String getOstr_option1() {
		return ostr_option1;
	}

	public void setOstr_option1(String ostr_option1) {
		this.ostr_option1 = ostr_option1;
	}

	public String getOstr_option2() {
		return ostr_option2;
	}

	public void setOstr_option2(String ostr_option2) {
		this.ostr_option2 = ostr_option2;
	}

	public String getOstr_option3() {
		return ostr_option3;
	}

	public void setOstr_option3(String ostr_option3) {
		this.ostr_option3 = ostr_option3;
	}

	public String getOstr_option4() {
		return ostr_option4;
	}

	public void setOstr_option4(String ostr_option4) {
		this.ostr_option4 = ostr_option4;
	}

	public String getOstr_correct_option() {
		return ostr_correct_option;
	}

	public void setOstr_correct_option(String ostr_correct_option) {
		this.ostr_correct_option = ostr_correct_option;
	}

	public Date getOdt_entry_date() {
		return odt_entry_date;
	}
	
	public String getObl_question() {
		return obl_question;
	}

	public void setObl_question(String oblQuestion) {
		obl_question = oblQuestion;
	}

	public String getObl_option1() {
		return obl_option1;
	}

	public void setObl_option1(String oblOption1) {
		obl_option1 = oblOption1;
	}

	public String getObl_option2() {
		return obl_option2;
	}

	public void setObl_option2(String oblOption2) {
		obl_option2 = oblOption2;
	}

	public String getObl_option3() {
		return obl_option3;
	}

	public void setObl_option3(String oblOption3) {
		obl_option3 = oblOption3;
	}

	public String getObl_option4() {
		return obl_option4;
	}

	public void setObl_option4(String oblOption4) {
		obl_option4 = oblOption4;
	}

	public void setOdt_entry_date(Date odt_entry_date) {
		this.odt_entry_date = odt_entry_date;
	}

	public Integer getOnum_is_active() {
		return onum_is_active;
	}

	public void setOnum_is_active(Integer onum_is_active) {
		this.onum_is_active = onum_is_active;
	}

	public Integer getOnum_question_status() {
		return onum_question_status;
	}

	public void setOnum_question_status(Integer onum_question_status) {
		this.onum_question_status = onum_question_status;
	}
}
