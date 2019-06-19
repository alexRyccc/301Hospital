package com.newer.hostipal.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newer.hostipal.pojo.Department;
import com.newer.hostipal.pojo.Drug;
import com.newer.hostipal.pojo.DrugData;
import com.newer.hostipal.pojo.Druglayui;
import com.newer.hostipal.service.IHosservice;

@RestController
@RequestMapping("/drug")
public class DrugsController {
	@Resource(name = "hosService")
	private IHosservice ser =null; 
	
	
	private static final Logger log = LoggerFactory.getLogger(DrugsController.class);
	
	@GetMapping("/durgs/{price11}/{price22}")
	public ResponseEntity<Druglayui> query(@PathVariable("price11")Integer price1,@PathVariable("price22")Integer price2){

		Druglayui pc =new Druglayui();
		List<Drug> list =ser.queryDrugbyprice(price1, price2);
		pc.setData(list);
		//pc.setData(lists);
		pc.setCode("0");
		pc.setMsg("");
		pc.setCount(0);
		ResponseEntity<Druglayui>   res= new ResponseEntity<Druglayui> (pc, HttpStatus.OK);
		return res;
		
	}
	@GetMapping("/durgx")
	public ResponseEntity<Druglayui> query(){
		System.out.println("进入");
		Druglayui pc =new Druglayui();
		List<Drug> list =ser.queryDrug();
		pc.setData(list);
		//pc.setData(lists);
		pc.setCode("0");
		pc.setMsg("");
		pc.setCount(0);
		ResponseEntity<Druglayui>   res= new ResponseEntity<Druglayui> (pc, HttpStatus.OK);
		return res;
		
	}
	@PostMapping("/stop")
	public String stop(@RequestBody List<Drug> drug) {
		for (Drug id : drug) {
		Integer	drugid =id.getDrugid();
		System.out.println("name"+id.getDrugname()+"drugid"+drugid);
		ser.updatedrugstop(drugid);
		
		
	}
		return "停用成功";

}
	
	@PostMapping("/uses")
	public String uses(@RequestBody List<Drug> drug) {
		for (Drug id : drug) {
		Integer	drugid =id.getDrugid();
		System.out.println("name"+id.getDrugname()+"drugid"+drugid);
		ser.updatedruguse(drugid);
		
		
	}
		return "启用成功";

}	
	@GetMapping("dept")
	public  ResponseEntity<List<DrugData>> select(){
		List<DrugData> list =ser.querydrugtype();
		ResponseEntity<List<DrugData>>   res=new ResponseEntity<List<DrugData>> (list, HttpStatus.OK);
	
		
		return res;
	}
	@PostMapping("/add")
	public String add(@RequestBody Drug drug) {
		if(ser.adddrug(drug)) {
			return "成功";
		}
		return "失败";
		
	}
}
