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

@Entity @Table(name = "oes_exam_details") @Proxy(lazy=false)
public class ExamDetailsDto implements Serializable{
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)    
	@Column(name = "onum_id")
	private Integer onum_id;
	
	@ManyToOne
	@JoinColumn(name = "onum_course_id")
	private CourseDetailsDto  courseDetailsDto;
	
	@Column(name = "ostr_exam_name")
	private String ostr_exam_name;
	
	@Column(name = "ostr_exam_description")
    private String ostr_exam_description;
	
    @Column(name = "odt_exam_date")
    private String odt_exam_date;
    
    @Column(name = "odt_exam_time")
    private String odt_exam_time;
    
	@Column(name = "obl_exam_pic")
	private String obl_exam_pic;
	
	@Column(name = "ostr_price")
	private String ostr_price;
	
	@Column(name = "ostr_exam_pattern")
	private String ostr_exam_pattern;
	
	@Column(name = "ostr_negative_mark")
	private String ostr_negative_mark;
	
    @Column(name = "onum_is_active")
    private Integer onum_is_active;
	
	@Column(name = "onum_exam_activation_flag")
    private Integer onum_exam_activation_flag;
	
	@Column(name = "odt_entry_date")
    private Date odt_entry_date;

	public String getOstr_exam_pattern() {
		return ostr_exam_pattern;
	}

	public void setOstr_exam_pattern(String ostr_exam_pattern) {
		this.ostr_exam_pattern = ostr_exam_pattern;
	}

	public String getOstr_negative_mark() {
		return ostr_negative_mark;
	}

	public void setOstr_negative_mark(String ostr_negative_mark) {
		this.ostr_negative_mark = ostr_negative_mark;
	}

	@ManyToOne
	@JoinColumn(name = "onum_user_id")
	private AdminDetailDto adminDetailDto;
	
	public AdminDetailDto getAdminDetailDto() {
		return adminDetailDto;
	}

	public void setAdminDetailDto(AdminDetailDto adminDetailDto) {
		this.adminDetailDto = adminDetailDto;
	}

	
	public Integer getOnum_id() {
		return onum_id;
	}

	public void setOnum_id(Integer onum_id) {
		this.onum_id = onum_id;
	}

	public CourseDetailsDto getCourseDetailsDto() {
		return courseDetailsDto;
	}

	public void setCourseDetailsDto(CourseDetailsDto courseDetailsDto) {
		this.courseDetailsDto = courseDetailsDto;
	}

	public String getOstr_exam_name() {
		return ostr_exam_name;
	}

	public void setOstr_exam_name(String ostr_exam_name) {
		this.ostr_exam_name = ostr_exam_name;
	}

	public String getOstr_exam_description() {
		return ostr_exam_description;
	}

	public void setOstr_exam_description(String ostr_exam_description) {
		this.ostr_exam_description = ostr_exam_description;
	}

	public String getOdt_exam_date() {
		return odt_exam_date;
	}

	public void setOdt_exam_date(String odt_exam_date) {
		this.odt_exam_date = odt_exam_date;
	}

	public String getOdt_exam_time() {
		return odt_exam_time;
	}

	public void setOdt_exam_time(String odt_exam_time) {
		this.odt_exam_time = odt_exam_time;
	}

	public Integer getOnum_is_active() {
		return onum_is_active;
	}

	public void setOnum_is_active(Integer onum_is_active) {
		this.onum_is_active = onum_is_active;
	}

	public Integer getOnum_exam_activation_flag() {
		return onum_exam_activation_flag;
	}

	public void setOnum_exam_activation_flag(Integer onum_exam_activation_flag) {
		this.onum_exam_activation_flag = onum_exam_activation_flag;
	}

	public Date getOdt_entry_date() {
		return odt_entry_date;
	}

	public void setOdt_entry_date(Date odt_entry_date) {
		this.odt_entry_date = odt_entry_date;
	}

	public String getObl_exam_pic() {
		return obl_exam_pic;
	}

	public void setObl_exam_pic(String obl_exam_pic) {
		this.obl_exam_pic = obl_exam_pic;
	}

	public String getOstr_price() {
		return ostr_price;
	}

	public void setOstr_price(String ostr_price) {
		this.ostr_price = ostr_price;
	}	
}
