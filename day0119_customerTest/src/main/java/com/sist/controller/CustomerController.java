package com.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sist.dao.CustomerDAO;
import com.sist.vo.CustomerVO;
@Controller
public class CustomerController {
	
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
	 * 요청한 서비스이름과 같은 view로 설정할 땐
	 * setViewName 생략가능
	 */
	//뷰가 자동으로 요청한 이름으로 찾게되어있으니 요청한 이름이아니라 다른 이름으로 갈때만 설정해주면된다.
	@RequestMapping("/detailCustomer.do")
	public ModelAndView detail(int custid) {
		ModelAndView mav = new ModelAndView();
		/*
		CustomerVO c = dao.getCustomer(custid);
		mav.addObject("c",c);
		*/
		mav.addObject("c", dao.getCustomer(custid) );
		//mav.setViewName("detailCustomer");
		return mav;
	}
	
}
