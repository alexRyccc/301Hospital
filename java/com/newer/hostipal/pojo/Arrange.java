package com.newer.hostipal.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Arrange implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int arrid;
	private String morid;
	private String midid;
	private String nigid;
	@JsonFormat(pattern="yyyy-MM-dd")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date adate;
	private String depid;
	private String mon;
	private String mi;
	private String nig;
	private String aweek;
	private String dyas;
	
	
	@Override
	public String toString() {
		return "Arrange [arrid=" + arrid + ", morid=" + morid + ", midid=" + midid + ", nigid=" + nigid + ", adate="
				+ adate + ", depid=" + depid + ", mon=" + mon + ", mi=" + mi + ", nig=" + nig + "]";
	}
	
	public String getDyas() {
		return dyas;
	}

	public void setDyas(String dyas) {
		this.dyas = dyas;
	}

	public String getAweek() {
		return aweek;
	}

	public void setAweek(String aweek) {
		this.aweek = aweek;
	}

	public String getMon() {
		return mon;
	}

	public void setMon(String mon) {
		this.mon = mon;
	}

	public String getMi() {
		return mi;
	}

	public void setMi(String mi) {
		this.mi = mi;
	}

	public String getNig() {
		return nig;
	}

	public void setNig(String nig) {
		this.nig = nig;
	}

	public String getDepid() {
		return depid;
	}

	public void setDepid(String depid) {
		this.depid = depid;
	}
	public int getArrid() {
		return arrid;
	}
	public void setArrid(int arrid) {
		this.arrid = arrid;
	}
	public String getMorid() {
		return morid;
	}
	public void setMorid(String morid) {
		this.morid = morid;
	}
	public String getMidid() {
		return midid;
	}
	public void setMidid(String midid) {
		this.midid = midid;
	}
	public String getNigid() {
		return nigid;
	}
	public void setNigid(String nigid) {
		this.nigid = nigid;
	}
	public Date getAdate() {
		return adate;
	}
	public void setAdate(Date adate) {
		this.adate = adate;
	}
	
	
}
