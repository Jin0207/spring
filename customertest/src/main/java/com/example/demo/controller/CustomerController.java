package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	@RequestMapping(value = "insertCustomer.do", method = RequestMethod.GET)
	public void insertForm() {
	}
	
	@RequestMapping(value = "insertCustomer.do", method = RequestMethod.POST)
	public ModelAndView insert(CustomerVO c) {
		ModelAndView mav = new ModelAndView("redirect:/listCustomer.do");
		int re = dao.insert(c);
		if(re != 1) {
			mav.setViewName("error");
			mav.addObject("msg", "고객등록에 실패하였습니다.");
		}
		return mav;
	}
	@RequestMapping("/detailCustomer.do")
	public void detail(Model model,int custid) {
		model.addAttribute("c", dao.findByNo(custid));
	}
	
	@RequestMapping(value = "updateCustomer.do", method = RequestMethod.GET)
	public void updateForm(Model model, int custid) {
		model.addAttribute("c", dao.findByNo(custid));
	}
	
	@RequestMapping(value = "updateCustomer.do", method = RequestMethod.POST)
	public ModelAndView updateForm(CustomerVO c) {
		ModelAndView mav = new ModelAndView("redirect:/listCustomer.do");
		int re = dao.update(c);
		if(re != 1) {
			mav.setViewName("error");
			mav.addObject("msg", "고객정보수정에 실패하였습니다.");
		}
		return mav;
	}
	
	@RequestMapping("/deleteCustomer.do")
	public ModelAndView delete(int custid) {
		ModelAndView mav = new ModelAndView("redirect:/listCustomer.do");
		int re = dao.delete(custid);
		
		if(re != 1) {
			mav.setViewName("error");
			mav.addObject("msg", "고개정보 삭제에 실패하였습니다.");
		}
		
		return mav;
	}
}
