package com.example.demo.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.MemberDAO;
import com.example.demo.vo.MemberVO;

import kr.co.youiwe.webservice.BitSms;
import lombok.Setter;

@Controller
@Setter
public class MemberController {
	
	@Autowired
	private MemberDAO dao;

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public void join_form() {
		
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public void join_submit(MemberVO m) {
		int re = dao.insert(m);
	
		if(re == 1) {
			System.out.println("회원을 등록하였습니다.");
		}
	}
	
	@RequestMapping("/sendNumber")
	@ResponseBody
	public String sendNumber(String phone) {
		Random random = new Random();
		int createNum = 0;
		String ranNum = "";
		
		for(int i =0; i<4; i++) {
			createNum = random.nextInt(9);
			ranNum += createNum;	
		}
		System.out.println(ranNum);
		System.out.println("phone: " + phone);
		new BitSms().sendMsg("010-2559-8279",phone, ranNum);
		return ranNum;
	}
	
	@RequestMapping("/sendTotal")
	@ResponseBody
	public String sendTotalMsg() {
		List<MemberVO> list = dao.findAll();
		String from = "01025598279";
		BitSms sms = new BitSms();
		
		for(MemberVO m : list) {
			String to = m.getPhone();
			String name = m.getName();
			int total = m.getTotal();
			String msg = name + "님의 이번달 요금은 " + total + "원 입니다.";
			sms.sendMsg(from, to, msg);
		}
		/*
		 * for(int i = 0; i<list.size(); i++) {
		 * //System.out.println(list.get(i).getPhone());
		 * //System.out.println(list.get(i).getTotal()); //new
		 * BitSms().sendMsg("010-2559-8279",list.get(i).getPhone(),
		 * list.get(i).getTotal()+""); }
		 */
		return "메세지를 모두 전송하였습니다.";
	}
}
