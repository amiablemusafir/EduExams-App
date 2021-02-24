package com.oes.dto;

public class ResultReviewSubjectDto {
	
	private SectionDetailsDto sectionDetailsDto;	
	private Integer total_question;
	private Integer total_right;
	private Integer total_wrong;
	private Integer total_left;
	
	public SectionDetailsDto getSectionDetailsDto() {
		return sectionDetailsDto;
	}
	public void setSectionDetailsDto(SectionDetailsDto sectionDetailsDto) {
		this.sectionDetailsDto = sectionDetailsDto;
	}
	public Integer getTotal_question() {
		return total_question;
	}
	public void setTotal_question(Integer total_question) {
		this.total_question = total_question;
	}
	public Integer getTotal_right() {
		return total_right;
	}
	public void setTotal_right(Integer total_right) {
		this.total_right = total_right;
	}
	public Integer getTotal_wrong() {
		return total_wrong;
	}
	public void setTotal_wrong(Integer total_wrong) {
		this.total_wrong = total_wrong;
	}
	public Integer getTotal_left() {
		return total_left;
	}
	public void setTotal_left(Integer total_left) {
		this.total_left = total_left;
	}
}
