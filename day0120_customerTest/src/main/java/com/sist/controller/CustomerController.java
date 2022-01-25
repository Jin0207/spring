package com.sist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sist.dao.CustomerDAO;
import com.sist.vo.CustomerVO;
@Controller
public class CustomerController {
	
	@Autowired
	private CustomerDAO dao;

	public void setDao(CustomerDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/listCustomer.do")
	public ModelAndView listCustomer() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("list", dao.listAll());
		mav.setViewName("listCustomer");
		return mav;
	}
	
	/*
	 * ��û�� �����̸��� ���� view�� ������ ��
	 * setViewName ��������
	 */
	//�䰡 �ڵ����� ��û�� �̸����� ã�ԵǾ������� ��û�� �̸��̾ƴ϶� �ٸ� �̸����� ������ �������ָ�ȴ�.
	@RequestMapping("/detailCustomer.do")
	public ModelAndView detail(int custid) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("c", dao.getCustomer(custid) );
		return mav;
	}
	
}
