package com.newer.hostipal.service.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.newer.hostipal.mapper.HosMapper;
import com.newer.hostipal.pojo.Arrange;
import com.newer.hostipal.pojo.Department;
import com.newer.hostipal.pojo.Doctorinfo;
import com.newer.hostipal.pojo.Drug;
import com.newer.hostipal.pojo.DrugData;
import com.newer.hostipal.pojo.ManagerInfo;
import com.newer.hostipal.pojo.Patcard;
import com.newer.hostipal.service.IHosservice;
@Service(value = "hosService")
@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED) // Propagation事务传播行为
public class HosServiceimpl implements IHosservice{
	
	@Autowired
	private HosMapper hos =null;
	@Override
	public List<ManagerInfo> queryManage() {
		// TODO Auto-generated method stub
		return hos.queryManage();
	}
	@Override
	public ManagerInfo queryMngeByid(String mcarno, String mpass) {
		
		return hos.queryMngeByid(mcarno, mpass);
	
	}
	public List<Department> queryDepart() {
		
		return hos.queryDepart();
	}

	public List<Doctorinfo> queryDoct() {
		
		return hos.queryDoct(); 
	}

	public List<Patcard> querypatcard() {
		return hos.querypatcard();
	}
	@Override
	public List<Patcard> querypatcardbyid(Integer pc_id) {
		// TODO Auto-generated method stub
		return hos.querypatcardbyid(pc_id);
	}
	@Override
	public List<Patcard> querypatcardbyidc(String pc_idc) {
		// TODO Auto-generated method stub
		
		return hos.querypatcardbyidc(pc_idc);
	}
	@Override
	public List<Patcard> querypatcardbyiphone(String Pat_Telephone) {
		// TODO Auto-generated method stub
		return hos.querypatcardbyiphone(Pat_Telephone);
	}
	@Override
	public Patcard queyrPatcardbyid(Integer pc_id) {
		// TODO Auto-generated method stub
		return hos.queyrPatcardbyid(pc_id); 
	}
	@Override
	public boolean addbalance(String pc_balance, Integer pc_id) {
		return hos.addbalance(pc_balance, pc_id);
		
	}
	@Override
	public List<Arrange> querybydepid(Integer depid,Integer aweek) {
		
		return hos.querybydepid(depid,aweek);
	}
	@Override
	public List<Doctorinfo> queryDoctbydep(Integer d_id) {
		// TODO Auto-generated method stub
		return hos.queryDoctbydep(d_id);
	}
	@Override
	public void addarrange(String MORID, String MIDID, String NIGID, Date ADATE, Integer DEPID) {
		hos.addarrange(MORID, MIDID, NIGID, ADATE, DEPID);
		
	}
	@Override
	public void deletearrange(Date ADATE, Integer DEPID) {
		hos.deletearrange(ADATE, DEPID);
		
	}
	@Override
	public boolean deleteaweek(Integer AWEEK, Integer DEPID) {
		System.out.println("AWEEK"+AWEEK +"DEPID"+DEPID);
		return hos.deleteaweek(AWEEK, DEPID);
		
	}
	@Override
	public List<Drug> queryDrug() {
		
		return hos.queryDrug(); 
	}
	@Override
	public List<Drug> queryDrugbyprice(Integer price1, Integer price2) {
		// TODO Auto-generated method stub
		return hos.queryDrugbyprice(price1, price2);
	}
	@Override
	public boolean updatedruguse(Integer drugid) {
		// TODO Auto-generated method stub
		return hos.updatedruguse(drugid);
	}
	@Override
	public boolean updatedrugstop(Integer drugid) {
		// TODO Auto-generated method stub
		return hos.updatedrugstop(drugid);
	}
	@Override
	public List<DrugData> querydrugtype() {
		
		return hos.querydrugtype();
	}
	@Override
	public boolean adddrug(Drug drug) {
		
		return hos.adddrug(drug);
	}

}
