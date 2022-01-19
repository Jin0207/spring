package com.sist.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sist.dao.DeptDAO;
import com.sist.vo.DeptVO;

@Controller
@RequestMapping("/insertDept.do")
public class InsertDeptController {
	
	private DeptDAO dao;
	
	public void setDao(DeptDAO dao) {
		this.dao = dao;
	}

	//@RequestMapping(value= "/insertDept.do", method= RequestMethod.GET)
	@RequestMapping(method= RequestMethod.GET)
	//public ModelAndView form() {
	public void form() {
		//ModelAndView mav = new ModelAndView("insertDept");
		//mav.setViewName("insertDept");
		//return mav;
		
		//���� �並 �������� �ʰ� �����ϴ� ���� ������ ���� ��û�ϴ� ������ �ڵ������ȴ�.
	}
	
	//@RequestMapping(value = "/insertDeptOK.do", method = RequestMethod.POST)
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView submit(DeptVO d) { //Command Object
		ModelAndView mav = new ModelAndView();
		int re = dao.insert(d);
		
		if(re == 1) {
			mav.setViewName("insertDeptOK");
		}else {
			mav.addObject("msg", "�μ���Ͽ� �����Ͽ����ϴ�.");
			mav.setViewName("error");
		}
		
		return mav;
	}
}