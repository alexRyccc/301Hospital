package com.newer.hostipal.pojo;

import java.io.Serializable;

public class ManagerInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer mid;
	private String mname;
	private String mpass;
	private String mcarno;
	private String verify;
	
	
	@Override
	public String toString() {
		return "ManagerInfo [mid=" + mid + ", mname=" + mname + ", mpass=" + mpass + ", mcarno=" + mcarno + ", verify="
				+ verify + ",  ]";
	}

	public String getVerify() {
		return verify;
	}

	public void setVerify(String verify) {
		this.verify = verify;
	}

	
	


	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	
	public String getMpass() {
		return mpass;
	}
	public void setMpass(String mpass) {
		this.mpass = mpass;
	}
	public String getMcarno() {
		return mcarno;
	}
	public void setMcarno(String mcarno) {
		this.mcarno = mcarno;
	}
	
	
}
