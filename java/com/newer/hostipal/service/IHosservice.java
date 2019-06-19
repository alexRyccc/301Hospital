package com.newer.hostipal.service;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.newer.hostipal.pojo.Arrange;
import com.newer.hostipal.pojo.Department;
import com.newer.hostipal.pojo.Doctorinfo;
import com.newer.hostipal.pojo.Drug;
import com.newer.hostipal.pojo.DrugData;
import com.newer.hostipal.pojo.ManagerInfo;
import com.newer.hostipal.pojo.Patcard;

public interface IHosservice {
	public List<ManagerInfo> queryManage(); 
	public  ManagerInfo queryMngeByid(String mcarno, String mpass);
	public List<Department> queryDepart(); 
	public List<Doctorinfo> queryDoct();
	public List<Patcard> querypatcard();
	public List<Patcard> querypatcardbyid( Integer pc_id);
	public List<Patcard> querypatcardbyidc( String pc_idc);
	public List<Patcard> querypatcardbyiphone( String Pat_Telephone);
	public Patcard queyrPatcardbyid(Integer pc_id);
	public boolean addbalance(String pc_balance,Integer pc_id);
	public List<Arrange> querybydepid( Integer depid,Integer aweek);
	public List<Doctorinfo> queryDoctbydep(Integer d_id);
	public void addarrange(String MORID, String MIDID,String NIGID, Date ADATE, Integer DEPID);
	public void deletearrange (  Date ADATE, Integer DEPID);
	public boolean deleteaweek(Integer AWEEK,Integer DEPID);
	public List<Drug> queryDrug();
	public List<Drug> queryDrugbyprice(Integer price1, Integer price2);
	public boolean updatedruguse(Integer drugid);
	public boolean updatedrugstop(Integer drugid);
	public List<DrugData> querydrugtype ();
	public boolean adddrug(Drug drug);
}
