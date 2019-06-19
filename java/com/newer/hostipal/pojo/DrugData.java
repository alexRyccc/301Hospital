package com.newer.hostipal.pojo;

import java.io.Serializable;

public class DrugData implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer   drugtype;
	private String  typename;
	public Integer getDrugtype() {
		return drugtype;
	}
	public void setDrugtype(Integer drugtype) {
		this.drugtype = drugtype;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	
}
