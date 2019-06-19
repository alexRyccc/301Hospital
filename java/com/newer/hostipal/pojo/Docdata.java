package com.newer.hostipal.pojo;

import java.io.Serializable;

public class Docdata implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer pos_Id ;
	private String pos_name;
	public Integer getPos_Id() {
		return pos_Id;
	}
	public void setPos_Id(Integer pos_Id) {
		this.pos_Id = pos_Id;
	}
	public String getPos_name() {
		return pos_name;
	}
	public void setPos_name(String pos_name) {
		this.pos_name = pos_name;
	}
	
}
