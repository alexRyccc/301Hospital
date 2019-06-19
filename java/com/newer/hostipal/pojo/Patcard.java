package com.newer.hostipal.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Patcard implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String pat_id;
	private String pat_Sex;
	private String pat_Name;
	private Integer pat_Age;
	private String pat_Telephone;
	private String pat_Address;
	private Integer pc_id;
	private String pc_idc;
	private String pc_balance;
	private String pc_type;
	@JsonFormat(pattern="yyyy-MM-dd")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date pc_date;
	
	
	@Override
	public String toString() {
		return "Patcard [pat_id=" + pat_id + ", pat_Sex=" + pat_Sex + ", pat_Name=" + pat_Name + ", pat_Age=" + pat_Age
				+ ", pat_Telephone=" + pat_Telephone + ", pat_Address=" + pat_Address + ", pc_id=" + pc_id + ", pc_idc="
				+ pc_idc + ", pc_balance=" + pc_balance + ", pc_type=" + pc_type + ", pc_date=" + pc_date + "]";
	}
	public String getPat_id() {
		return pat_id;
	}
	public void setPat_id(String pat_id) {
		this.pat_id = pat_id;
	}
	public String getPat_Sex() {
		return pat_Sex;
	}
	public void setPat_Sex(String pat_Sex) {
		this.pat_Sex = pat_Sex;
	}
	public String getPat_Name() {
		return pat_Name;
	}
	public void setPat_Name(String pat_Name) {
		this.pat_Name = pat_Name;
	}
	public Integer getPat_Age() {
		return pat_Age;
	}
	public void setPat_Age(Integer pat_Age) {
		this.pat_Age = pat_Age;
	}
	public String getPat_Telephone() {
		return pat_Telephone;
	}
	public void setPat_Telephone(String pat_Telephone) {
		this.pat_Telephone = pat_Telephone;
	}
	public String getPat_Address() {
		return pat_Address;
	}
	public void setPat_Address(String pat_Address) {
		this.pat_Address = pat_Address;
	}
	public Integer getPc_id() {
		return pc_id;
	}
	public void setPc_id(Integer pc_id) {
		this.pc_id = pc_id;
	}
	public String getPc_idc() {
		return pc_idc;
	}
	public void setPc_idc(String pc_idc) {
		this.pc_idc = pc_idc;
	}
	public String getPc_balance() {
		return pc_balance;
	}
	public void setPc_balance(String pc_balance) {
		this.pc_balance = pc_balance;
	}
	public String getPc_type() {
		return pc_type;
	}
	public void setPc_type(String pc_type) {
		this.pc_type = pc_type;
	}
	public Date getPc_date() {
		return pc_date;
	}
	public void setPc_date(Date pc_date) {
		this.pc_date = pc_date;
	}
	
	
}
