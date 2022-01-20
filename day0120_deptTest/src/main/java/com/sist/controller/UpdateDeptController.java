package com.sist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sist.dao.DeptDAO;
import com.sist.vo.DeptVO;

@Controller
@RequestMapping("/updateDept.do")
public class UpdateDeptController {
	
	@Autowired
	private DeptDAO dao;

	public void setDao(DeptDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView form(int dno) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", dao.getDept(dno));
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView submit(DeptVO d) {
		ModelAndView mav = new ModelAndView();
		int re = dao.update(d);
		
		if(re == 1) {
			mav.setViewName("updateDeptOK");
		}else {
			mav.addObject("msg", "수정에 실패하였습니다");
			mav.setViewName("error");
		}
		
		return mav; 
	}
	
}
