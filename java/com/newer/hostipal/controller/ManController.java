package com.newer.hostipal.controller;



import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.newer.hospital.utils.RandomValidateCodeUtil;
import com.newer.hospital.utils.SecurityCode;
import com.newer.hospital.utils.SecurityImage;
import com.newer.hostipal.pojo.Department;
import com.newer.hostipal.pojo.Doctorinfo;
import com.newer.hostipal.pojo.Drug;
import com.newer.hostipal.pojo.Druglayui;
import com.newer.hostipal.pojo.ManagerInfo;
import com.newer.hostipal.pojo.PatCartlayui;
import com.newer.hostipal.pojo.Patcard;
import com.newer.hostipal.service.IHosservice;

import net.sf.json.JSONArray;

@RestController
public class ManController {
	@Resource(name = "hosService")
	private IHosservice ser =null; 
	
//	@RequestMapping(value = "getVerify")
//	public void getVerify(HttpServletRequest request, HttpServletResponse response) {
//	
//	 try {
//	  response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
//	  response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
//	  response.setHeader("Cache-Control", "no-cache");
//	  response.setDateHeader("Expire", 0);
//	  RandomValidateCodeUtil randomValidateCode = new RandomValidateCodeUtil();
//	  randomValidateCode.getRandcode(request, response);//输出验证码图片方法
//	 } catch (Exception e) {
//		 e.printStackTrace();
//	 }
//	}
	
	@RequestMapping("/img")
	 public void imgcode(OutputStream os,HttpSession session) {
	  String str=SecurityCode.getSecurityCode();
	  BufferedImage bufimg=SecurityImage.getImage(str);
	  session.setAttribute("code", str);
	  System.out.println("str"+str);
	  try {
	   ImageIO.write(bufimg, "jpg", os);
	  } catch (IOException e) {
	   // TODO Auto-generated catch block
	   e.printStackTrace();
	  }
	 }
	
	@GetMapping("selectdep")
	public  ResponseEntity<List<Department>> select(){
		List<Department> list =ser.queryDepart();
		ResponseEntity<List<Department>>   res=new ResponseEntity<List<Department>> (list, HttpStatus.OK);
	
		
		return res;
	}
	@Cacheable("doctor")
	@GetMapping("selectdoc")
	public  ResponseEntity<List<Doctorinfo>> selectdoc(){
		List<Doctorinfo> list =ser.queryDoct();
		
	ResponseEntity<List<Doctorinfo>>   res= new ResponseEntity<List<Doctorinfo>> (list, HttpStatus.OK);
	
		
		return res; 
	}
	/**
	 * 将方法的运行结果进行缓存；以后再要相同的数据，直接从缓存中获取，不用调用方法
	 * @param pc_id
	 * @return
	 */
	@Cacheable("card")
	@GetMapping("selectpcd")
	public  ResponseEntity<PatCartlayui> selectpatcard(@RequestParam(name = "pc_id",required = false)String pc_id){
		PatCartlayui pc =new PatCartlayui();
		if("".equals(pc_id)||pc_id==null) {
			List<Patcard> list =ser.querypatcard();
			pc.setData(list);
			//pc.setData(lists);
			pc.setCode("0");
			pc.setMsg("");
			pc.setCount(0);
		}else {
			Integer id =Integer.parseInt(pc_id);
			pc_id ="%"+pc_id+"%";
			List<Patcard> list =ser.querypatcardbyidc(pc_id);
			
			 
			List<Patcard> lists =ser.querypatcardbyid(id);
//		ResponseEntity<List<Patcard>>   res= new ResponseEntity<List<Patcard>> (list, HttpStatus.OK);
		for (Patcard patcard : lists) {
			if(list.contains(patcard)) {
				
			}else {
				list.add(patcard);
			}
			
		}
		pc.setData(list);
		//pc.setData(lists);
		pc.setCode("0");
		pc.setMsg("");
		pc.setCount(0);
		}
	
	

   
	ResponseEntity<PatCartlayui>   res= new ResponseEntity<PatCartlayui> (pc, HttpStatus.OK);

		return res;
	}
	
//	@GetMapping("querycard")
//	public  ResponseEntity<PatCartlayui> selectpatcards(){
//		List<Patcard> list =ser.querypatcardbyid(pc_id);
//		
////	ResponseEntity<List<Patcard>>   res= new ResponseEntity<List<Patcard>> (list, HttpStatus.OK);
//	
//	PatCartlayui pc =new PatCartlayui();
//	pc.setData(list);
//	pc.setCode("0");
//	pc.setMsg("");
//	pc.setCount(0);
//   
//	ResponseEntity<PatCartlayui>   res= new ResponseEntity<PatCartlayui> (pc, HttpStatus.OK);
//
//		return res;
//	}
	
	
	
	@PostMapping("register")
	public String lect(@RequestBody ManagerInfo man , HttpSession session){
	
	     String random = (String) session.getAttribute("code");
	     String inver =man.getVerify();
	     
	     if(random.equals(inver)) {
	    	 String name =man.getMcarno();
	 		String pass =man.getMpass();
	 		ManagerInfo mans =null;
	 		mans =ser.queryMngeByid(name, pass);
	 		
	 		if(mans!=null) {
	 			session.setAttribute("user", mans);
	 			System.out.println(mans);
	 			//ResponseEntity<ManagerInfo>   res=new ResponseEntity<ManagerInfo> (mans, HttpStatus.OK);	
	 			return "1";
	 		}
	 		
//	 		ResponseEntity<List<ManagerInfo>>   res=new ResponseEntity<List<ManagerInfo>> (list, HttpStatus.OK);	
//	 		return res;		
	 		return "2";
	 		
	     }else {
	    	
	    	 return "3";
	     }
		 
	}
	
	
	
	@PostMapping("memser")
	public String lect( HttpSession session){
		ManagerInfo obj=(ManagerInfo) session.getAttribute("user");
		System.out.println(obj+"--------------------------------------------");
		if(obj!=null) {
			String name =obj.getMname();
			
			return name; 
		}else {
			return null;
		}
		
		
	}
	@PostMapping("/add")
	public String add(@RequestBody Patcard pat) {		
		System.out.println("pat.getPc_balance():__"+pat.getPc_balance());
		System.out.println("pat.getPc_balance():__"+pat.getPc_id());
		Patcard pats =ser.queyrPatcardbyid(pat.getPc_id());
		Double doub =Double.parseDouble(pats.getPc_balance()) + Double.parseDouble(pat.getPc_balance());
		String pc_balance =String.valueOf(doub);
		if(ser.addbalance(pc_balance, pat.getPc_id())) {
			return "成功";
		}else {
			return "充值失败";
		}
		
	}
//	@GetMapping("/durgx")
//	public ResponseEntity<Druglayui> query(){
//		System.out.println("进入");
//		Druglayui pc =new Druglayui();
//		List<Drug> list =ser.queryDrug();
//		pc.setData(list);
//		//pc.setData(lists);
//		pc.setCode("0");
//		pc.setMsg("");
//		pc.setCount(0);
//		ResponseEntity<Druglayui>   res= new ResponseEntity<Druglayui> (pc, HttpStatus.OK);
//		return res;
//		
//	}
//	@GetMapping("/durgs/{price11}/{price22}")
//	public ResponseEntity<Druglayui> query(@PathVariable("price11")Integer price1,@PathVariable("price22")Integer price2){
//
//		Druglayui pc =new Druglayui();
//		List<Drug> list =ser.queryDrugbyprice(price1, price2);
//		pc.setData(list);
//		//pc.setData(lists);
//		pc.setCode("0");
//		pc.setMsg("");
//		pc.setCount(0);
//		ResponseEntity<Druglayui>   res= new ResponseEntity<Druglayui> (pc, HttpStatus.OK);
//		return res;
//		
//	}

}
