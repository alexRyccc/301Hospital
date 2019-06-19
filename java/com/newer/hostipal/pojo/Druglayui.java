package com.newer.hostipal.pojo;

import java.io.Serializable;
import java.util.List;

public class Druglayui implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Drug> data;
	private Integer count;
	private String msg;
	private String code;
	
	public List<Drug> getData() {
		return data;
	}
	public void setData(List<Drug> data) {
		this.data = data;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
	
}