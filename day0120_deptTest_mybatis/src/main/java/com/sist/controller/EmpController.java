package com.sist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sist.dao.EmpDAO;

@Controller
public class EmpController {
	@Autowired
	private EmpDAO dao;

	public void setDao(EmpDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/listEmp.do")
	public ModelAndView listEmp() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", dao.listEmp());
		return mav;
	}
}
