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

@Entity @Table(name = "oes_score_generation") @Proxy(lazy=false)
public class ScoreGenerationDto {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)    
	@Column(name = "onum_score_generation_id")
	private Integer onum_score_generation_id;
	
	@ManyToOne
	@JoinColumn(name = "onum_exam_id")
	private ExamDetailsDto examDetailsDto;
	
	@Column(name = "onum_month")
    private Integer onum_month;	
		
	@Column(name = "onum_is_active")
    private Integer onum_is_active;
	
	@Column(name = "odt_entry_date")
    private Date odt_entry_date;

	public Integer getOnum_score_generation_id() {
		return onum_score_generation_id;
	}

	public void setOnum_score_generation_id(Integer onum_score_generation_id) {
		this.onum_score_generation_id = onum_score_generation_id;
	}

	public ExamDetailsDto getExamDetailsDto() {
		return examDetailsDto;
	}

	public void setExamDetailsDto(ExamDetailsDto examDetailsDto) {
		this.examDetailsDto = examDetailsDto;
	}

	public Integer getOnum_month() {
		return onum_month;
	}

	public void setOnum_month(Integer onum_month) {
		this.onum_month = onum_month;
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
