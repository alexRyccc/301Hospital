package com.newer.hostipal.pojo;

import java.io.Serializable;

public class Drug implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int drugid;
	private String drugname;
	private String drugtype;
	private Double drugprice;
	private String drugde;
	private String drugre;
	private String drugstatus;
	private String drugcom;
	private String  drugcon;
	
	public String getDrugcon() {
		return drugcon;
	}
	public void setDrugcon(String drugcon) {
		this.drugcon = drugcon;
	}
	public int getDrugid() {
		return drugid;
	}
	public void setDrugid(int drugid) {
		this.drugid = drugid;
	}
	public String getDrugname() {
		return drugname;
	}
	public void setDrugname(String drugname) {
		this.drugname = drugname;
	}
	public String getDrugtype() {
		return drugtype;
	}
	public void setDrugtype(String drugtype) {
		this.drugtype = drugtype;
	}
	public Double getDrugprice() {
		return drugprice;
	}
	public void setDrugprice(Double drugprice) {
		this.drugprice = drugprice;
	}
	public String getDrugde() {
		return drugde;
	}
	public void setDrugde(String drugde) {
		this.drugde = drugde;
	}
	public String getDrugre() {
		return drugre;
	}
	public void setDrugre(String drugre) {
		this.drugre = drugre;
	}
	public String getDrugstatus() {
		return drugstatus;
	}
	public void setDrugstatus(String drugstatus) {
		this.drugstatus = drugstatus;
	}
	public String getDrugcom() {
		return drugcom;
	}
	public void setDrugcom(String drugcom) {
		this.drugcom = drugcom;
	}
	
	
}
