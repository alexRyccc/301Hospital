package com.newer.hostipal.controller;



import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newer.hostipal.pojo.Arrange;
import com.newer.hostipal.pojo.ArrangeWeek;
import com.newer.hostipal.pojo.Arrangelayui;
import com.newer.hostipal.pojo.Doctorinfo;
import com.newer.hostipal.service.IHosservice;
@RequestMapping("/arrang")
@RestController

public class ArrangeController {
	
	@Resource(name = "hosService")
	private IHosservice ser =null; 
	 
	@GetMapping("/query/{depid}/{datetime}")
	public Arrangelayui add(@PathVariable("depid") Integer depid,@PathVariable("datetime") Integer datetime) {
		Arrangelayui arr =new Arrangelayui();
		List<Arrange> list =ser.querybydepid(depid,datetime);
		arr.setData(list);
		arr.setCode("0");
		arr.setMsg("");
		arr.setCount(0);
		
		return arr;		

	}
	
	@GetMapping("/querys/{d_id}")
	@Cacheable(cacheNames = {"doctor"}) 	
	public  ResponseEntity<List<Doctorinfo>> que(@PathVariable("d_id") Integer d_id) {
	
		List<Doctorinfo> list =ser.queryDoctbydep(d_id);
		
		
	
		ResponseEntity<List<Doctorinfo>>   res= new ResponseEntity<List<Doctorinfo>> (list, HttpStatus.OK);
		return res;		

	}
	@PostMapping("/querys/{weeks}/{de}")
	public String adddoc(@RequestBody ArrangeWeek arrangeweek,@PathVariable("weeks") Integer weeks,@PathVariable("de") Integer de) {
		
		System.out.println(arrangeweek.toString());
	//	Integer weeks =arrangeweek.getWeeks();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal=Calendar.getInstance();
		cal.set(Calendar.YEAR, 2019);
		cal.set(Calendar.WEEK_OF_YEAR, weeks); 
		cal.set(Calendar.DAY_OF_WEEK,0);
		String Sunday = sdf.format(cal.getTime());
		Date Sundays=cal.getTime();  
		Date Sundayss=cal.getTime();  
		java.sql.Date  Sundaysss =new java.sql.Date(Sundayss.getTime());

		cal.set(Calendar.DAY_OF_WEEK,6);
		String SATURDAY = sdf.format(cal.getTime());
		Date SATURDAYs=cal.getTime();  
		Date SATURDAYss=cal.getTime();  
		java.sql.Date  SATURDAYsss =new java.sql.Date(SATURDAYss.getTime());
		
		cal.set(Calendar.DAY_OF_WEEK,5);
		String FRIDAY = sdf.format(cal.getTime());
		Date FRIDAYs=cal.getTime();  
		Date FRIDAYss=cal.getTime();  
		java.sql.Date  FRIDAYsss =new java.sql.Date(FRIDAYss.getTime());
		
		cal.set(Calendar.DAY_OF_WEEK,4);
		String THURSDAY = sdf.format(cal.getTime());
		Date THURSDAYs=cal.getTime();  
		Date THURSDAYss=cal.getTime();  
		java.sql.Date  THURSDAYsss =new java.sql.Date(THURSDAYss.getTime());
		
		cal.set(Calendar.DAY_OF_WEEK,3);
		String WEDNESDAY = sdf.format(cal.getTime());
		Date WEDNESDAYs=cal.getTime();  
		Date WEDNESDAYss=cal.getTime();  
		java.sql.Date  WEDNESDAYsss =new java.sql.Date(WEDNESDAYss.getTime());
		
		cal.set(Calendar.DAY_OF_WEEK,2);
		String TUESDAY = sdf.format(cal.getTime());
		Date TUESDAYs=cal.getTime();  
		Date TUESDAYss=cal.getTime();  
		java.sql.Date  TUESDAYsss =new java.sql.Date(TUESDAYss.getTime());
		cal.set(Calendar.DAY_OF_WEEK,1);
		String MONDAY = sdf.format(cal.getTime());
		Date MONDAYs=cal.getTime();  
		java.sql.Date  MONDAYsss =new java.sql.Date(MONDAYs.getTime());
		ser.deletearrange(MONDAYsss, de);
		ser.addarrange(arrangeweek.getPerson18(), arrangeweek.getPerson19(), arrangeweek.getPerson20(), MONDAYsss, de);//周一
		ser.deletearrange(TUESDAYsss, de);
		ser.addarrange(arrangeweek.getPerson0(), arrangeweek.getPerson1(), arrangeweek.getPerson2(), TUESDAYsss, de);//周二
		ser.deletearrange(WEDNESDAYsss, de);
		ser.addarrange(arrangeweek.getPerson3(), arrangeweek.getPerson4(), arrangeweek.getPerson5(), WEDNESDAYsss, de);//周三
		ser.deletearrange(THURSDAYsss, de);
		ser.addarrange(arrangeweek.getPerson6(), arrangeweek.getPerson7(), arrangeweek.getPerson8(), THURSDAYsss, de);//周四
		ser.deletearrange(FRIDAYsss, de);
		ser.addarrange(arrangeweek.getPerson9(), arrangeweek.getPerson10(), arrangeweek.getPerson11(), FRIDAYsss, de);//周五
		ser.deletearrange(SATURDAYsss, de);
		ser.addarrange(arrangeweek.getPerson12(), arrangeweek.getPerson13(), arrangeweek.getPerson14(), SATURDAYsss, de);//周六
		ser.deletearrange(Sundaysss, de);
		ser.addarrange(arrangeweek.getPerson15(), arrangeweek.getPerson16(), arrangeweek.getPerson17(), Sundaysss, de);//周日
		
		
		return "排班成功";
//		System.out.println(String.format("周一：%s___周二：%s___周三：%s___周四：%s___周五：%s___周六：%s___周日：%s___", 
//				MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,Sunday));
//		return String.format("周一：%s___周二：%s___周三：%s___周四：%s___周五：%s___周六：%s___周日：%s___", 
//				MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,Sunday);
		
	}
	
	@DeleteMapping("/querys/{weeks}/{de}")
	public String Deletedoc(@PathVariable("weeks") Integer weeks,@PathVariable("de") Integer de) {
		System.out.println("week:"+weeks);
		System.out.println("de"+de);
		if(ser.deleteaweek(de, weeks)) {
			return"删除成功";
		}
		
		return"删除失败";
	}
}
