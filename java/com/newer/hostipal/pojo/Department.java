package com.newer.hostipal.pojo;

import java.io.Serializable;

public class Department implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer d_id;
	private String d_name;
	private String d_intro;
	private String d_status;
	public Integer getD_id() {
		return d_id;
	}
	public void setD_id(Integer d_id) {
		this.d_id = d_id;
	}
	public String getD_name() {
		return d_name;
	}
	public void setD_name(String d_name) {
		this.d_name = d_name;
	}
	public String getD_intro() {
		return d_intro;
	}
	public void setD_intro(String d_intro) {
		this.d_intro = d_intro;
	}
	public String getD_status() {
		return d_status;
	}
	public void setD_status(String d_status) {
		this.d_status = d_status;
	}
	
	
}
