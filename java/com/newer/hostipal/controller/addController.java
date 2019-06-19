package com.newer.hostipal.controller;



import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.annotation.MapperScan;
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
import com.newer.hostipal.pojo.Department;
import com.newer.hostipal.pojo.Doctorinfo;
import com.newer.hostipal.pojo.ManagerInfo;
import com.newer.hostipal.pojo.PatCartlayui;
import com.newer.hostipal.pojo.Patcard;
import com.newer.hostipal.service.IHosservice;

import net.sf.json.JSONArray;
@RequestMapping("/add")
@RestController

public class addController {
	
	@Resource(name = "hosService")
	private IHosservice ser =null; 
	 
	
	@PostMapping("/appcard")
	public String add(@RequestBody Patcard pat) {		
		System.out.println(pat.toString());
		
			return "成功";
		
		
	}

}
