package com.sist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sist.dao.CustomerDAO;
import com.sist.vo.CustomerVO;

@Controller
@RequestMapping("/updateCustomer.do")
public class UpdateCustomerController {

	@Autowired
	private CustomerDAO dao=null;
	
	public void setDao(CustomerDAO dao) {
		this.dao = dao;
	}

	@RequestMapping(value="/updateCustomer.do",method= RequestMethod.GET)
	public ModelAndView form(int custid) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("c", dao.getCustomer(custid));
		return mav;
	}
	
	@RequestMapping(value="/updateCustomer.do",method = RequestMethod.POST)
	public ModelAndView submit(CustomerVO c) {
		ModelAndView mav = new ModelAndView();
		int re = dao.updateCustomer(c);
		if(re ==1) {
			mav.setViewName("updateCustomerOK");
		}else {
			mav.addObject("msg", "수정에 실패하였습니다.");
			mav.setViewName("error");
		}
		return mav;
	}
}
