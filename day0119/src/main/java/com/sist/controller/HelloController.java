package com.sist.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//����� ��û�� ���� �����ϴ� ��Ʈ�ѷ�
@Controller
public class HelloController {
	//����� ��û�� ���� �����ϴ� �޼ҵ�
	@RequestMapping("/hello.do")
	//servlet.ModelAndView
	public ModelAndView hello() {
		System.out.println("��Ʈ�ѷ� ������");
		ModelAndView mav = new ModelAndView();
		//mav.setViewName("/WEN-INF/views/hello.jsp");
		mav.setViewName("hello");
		mav.addObject("msg", "hello spring!!");
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("���");
		list.add("����");
		list.add("����");
		
		mav.addObject("list", list);
		return mav; 
	}
}
