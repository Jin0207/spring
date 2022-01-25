package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.CustomerDao;
import com.example.demo.vo.CustomerVO;

@Controller
public class CustomerController {
	//dao에대한 의존관계를 setter를 통해서 자동으로 설정되게함
	@Autowired
	private CustomerDao dao;

	public void setDao(CustomerDao dao) {
		this.dao = dao;
	}
	
	//실제로 사용자의 요청에의해서 동작할 메소드
	// 뷰를 지정하지않고 모델에다가 상태유지
	@RequestMapping("/listCustomer.do")
	public void list(Model model) {
		model.addAttribute("list", dao.findAll());
	}
	
}
