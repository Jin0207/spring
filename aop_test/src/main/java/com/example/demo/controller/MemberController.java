package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.MemberDAO;

@Controller
public class MemberController {
	
	@Autowired
	private MemberDAO dao;
	
	@RequestMapping("/insertMember")
	@ResponseBody
	public String insert() {
		dao.insert();
		return "회원추가";
	}

	@RequestMapping("/updateMember")
	@ResponseBody
	public String update() {
		dao.update();
		return "회원수정";
	}
}
