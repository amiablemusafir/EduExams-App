/*
 * Author: Himanshu Bharti
 * Start Date: 9th Sep, 2013
 * Modify Date: 
 * Modify By:
 * Motive: Role Permission Master Data
 */


package com.oes.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import org.hibernate.annotations.Proxy;


@Entity @Table(name="examination_batch_mapping") @Proxy(lazy=false)
public class ExaminationBatchMappingDto implements Serializable
{
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="inum_exam_batch_id") 
	public Integer inum_exam_batch_id;
	
		
	@ManyToOne
	@JoinColumn(name = "inum_batch_id") public BatchMasterDto batchMasterDto;
	
	@ManyToOne
	@JoinColumn(name = "inum_exam_id") public ExamDetailsDto examDetailsDto; 
	
	@Column(name="inum_is_active") public Integer inum_is_active;
	@Column(name="idt_entry_date") public Date idt_entry_date;
	@Column(name="inum_user_id") public Integer inum_user_id;
	
	@Transient
	public String strChosenitems;
	
	public Integer getInum_exam_batch_id() {
		return inum_exam_batch_id;
	}
	public void setInum_exam_batch_id(Integer inum_exam_batch_id) {
		this.inum_exam_batch_id = inum_exam_batch_id;
	}
	public BatchMasterDto getBatchMasterDto() {
		return batchMasterDto;
	}
	public void setBatchMasterDto(BatchMasterDto batchMasterDto) {
		this.batchMasterDto = batchMasterDto;
	}
	public ExamDetailsDto getExamDetailsDto() {
		return examDetailsDto;
	}
	public void setExamDetailsDto(ExamDetailsDto examDetailsDto) {
		this.examDetailsDto = examDetailsDto;
	}
	public Integer getInum_is_active() {
		return inum_is_active;
	}
	public void setInum_is_active(Integer inum_is_active) {
		this.inum_is_active = inum_is_active;
	}
	public Date getIdt_entry_date() {
		return idt_entry_date;
	}
	public void setIdt_entry_date(Date idt_entry_date) {
		this.idt_entry_date = idt_entry_date;
	}
	public Integer getInum_user_id() {
		return inum_user_id;
	}
	public void setInum_user_id(Integer inum_user_id) {
		this.inum_user_id = inum_user_id;
	}
	public String getStrChosenitems() {
		return strChosenitems;
	}
	public void setStrChosenitems(String strChosenitems) {
		this.strChosenitems = strChosenitems;
	}
}
