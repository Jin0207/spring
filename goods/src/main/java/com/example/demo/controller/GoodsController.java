package com.example.demo.controller;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.GoodsDAO;
import com.example.demo.vo.GoodsVO;

@Controller
public class GoodsController {
	
	//의존관계 자동설정 - setter에 의한
	@Autowired
	private GoodsDAO dao;

	public void setDao(GoodsDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/listGoods")
	public void list(Model model) {
		model.addAttribute("list", dao.findAll());
	}
	
	@RequestMapping(value = "/insertGoods", method = RequestMethod.GET)
	public void insertForm() {
		
	}

	@RequestMapping(value = "/insertGoods", method = RequestMethod.POST)
	public ModelAndView insertSubmit(HttpServletRequest request, GoodsVO g) {
		String path = request.getRealPath("images");
		System.out.println("path:" + path);
		MultipartFile uploadFile = g.getUploadFile();
		String fname = uploadFile.getOriginalFilename();
		g.setFname(fname);
		
		try {
			byte[] data = uploadFile.getBytes();
			//파일의 기록
			FileOutputStream fos = new FileOutputStream(path + "/" + fname);
			fos.write(data);
			fos.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		int re = dao.insert(g);
		ModelAndView mav = new ModelAndView("redirect:/listGoods");
		
		if(re != 1) {
			mav.setViewName("error");
			mav.addObject("msg", "상품 등록에 실패하였습니다.");
		}
		
		return mav;
	}
	
	@RequestMapping("/detailGoods")
	public void detail(int no, Model model) {
		model.addAttribute("g",dao.findByNo(no));
	}
	
	@RequestMapping(value = "/updateGoods", method = RequestMethod.GET)
	public void updateForm(int no, Model model) {
		model.addAttribute("g", dao.findByNo(no));
	}
	
	@RequestMapping(value = "/updateGoods", method = RequestMethod.POST)
	public ModelAndView updateSubmit(HttpServletRequest request, GoodsVO g) {
		String path = request.getRealPath("images");
		String oldFname = g.getFname();
		
		MultipartFile uploadFile = g.getUploadFile();
		String fname = uploadFile.getOriginalFilename();
		byte[] data;
		
		try {
			data = uploadFile.getBytes();
			if(fname != null && !fname.equals("")) {
				g.setFname(fname);
				FileOutputStream fos = new FileOutputStream(path + "/" + fname);
				fos.write(data);
				fos.close();
			}
		}catch (Exception e) {
		}
		int re = dao.update(g);
		ModelAndView mav = new ModelAndView("redirect:/listGoods");
		
		if(re != 1) {
			mav.addObject("msg", "상품수정에 실패하였습니다.");
			mav.setViewName("error");
		}else {
			if(fname != null && !fname.equals("")) {
				File file = new File(path + "/" + oldFname);
				file.delete();
			}
		}
		return mav;
	}
	
	@RequestMapping("/deleteGoods")
	public ModelAndView delete(HttpServletRequest request, int no) {
		String oldFname = dao.findByNo(no).getFname();
		
		ModelAndView mav = new ModelAndView("redirect:/listGoods");

		int re = dao.delete(no);

		if(re != 1) {
			mav.setViewName("error");
			mav.addObject("msg", "상품삭제에 실패하였습니다");
		}else {
			String path = request.getRealPath("images");
			System.out.println(path);
			if(oldFname != null && !oldFname.equals("")) {
				File file = new File(path + "/" + oldFname);
				file.delete();
			}
		}
		
		return mav;
	}

}
