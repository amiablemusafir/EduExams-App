package com.sms.admin.dto;

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

@Entity @Table(name="ihms_religion_mst") @Proxy(lazy=false)
public class ReligionMasterDto implements Serializable {

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

  @Id @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="inum_religion_id")
  private Integer inum_religion_id;
  
  @Column(name="istr_religion_name")
  private String istr_religion_name;
  
  @Column(name="inum_is_active")
  private Integer inum_is_active;
  
  @Column(name="idt_entry_date")
  private Date idt_entry_date;

public Integer getInum_religion_id() {
	return inum_religion_id;
}

public void setInum_religion_id(Integer inum_religion_id) {
	this.inum_religion_id = inum_religion_id;
}

public String getIstr_religion_name() {
	return istr_religion_name;
}

public void setIstr_religion_name(String istr_religion_name) {
	this.istr_religion_name = istr_religion_name;
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
  
}
