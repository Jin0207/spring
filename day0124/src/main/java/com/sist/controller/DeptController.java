package com.sist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.sist.dao.DeptDAO;

@Controller
public class DeptController {
	
	@Autowired
	private DeptDAO dao;

	public void setDao(DeptDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping(value="/listDept.do",produces = "text/plaine;charset=utf-8")
	@ResponseBody
	public String list() {
		Gson gson = new Gson();
		return gson.toJson(dao.findAll());
	}
	
	@RequestMapping("/deptTest.do")
	public void deptTest() {
		
	}
}
