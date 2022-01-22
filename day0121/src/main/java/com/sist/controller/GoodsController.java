package com.sist.controller;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sist.dao.GoodsDAO;
import com.sist.vo.GoodsVO;

@Controller
public class GoodsController {
	@Autowired
	private GoodsDAO dao;

	public void setDao(GoodsDAO dao) {
		this.dao = dao;
	}

	@RequestMapping("/listGoods.do")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", dao.findAll());
		return mav;
	}
	
	@RequestMapping(value="/insertGoods.do", method = RequestMethod.GET)
	public void insertForm() {
		
	}
	
	@RequestMapping(value = "/insertGoods.do", method = RequestMethod.POST)
	public ModelAndView insertSubmit(HttpServletRequest request , //���ε��� ������ �ǰ�θ� �˾ƿ��� ���Ͽ� httpServletRequest��ü�� �Ű������� ����
			GoodsVO g) {
		
		//request��ü�� ���Ͽ� ���ε��� ������ ���� ��θ� �о��
		String path = request.getRealPath("images");
		System.out.println("path: "+path);
		
		// vo�� ���ε��� ������ ����(�̸�,����)�� �޾ƿ´�.
		MultipartFile uploadFile = g.getUploadFile();
		//���ε��� ������ �̸��� ������
		String fname = uploadFile.getOriginalFilename();
		
		byte[] data;
		try {
			//���ε��� ������ ������ ������
			data = uploadFile.getBytes();
			// ������ ������ ����ϱ� ���� ��Ʈ�� ����
			FileOutputStream fos = new FileOutputStream(path + "/" + fname);
			//������ ���� ���
			fos.write(data);
			fos.close();
		} catch (Exception e) {
			System.out.println("���ܹ߻�:" + e.getMessage());
			// TODO: handle exception
		}
		
		
		g.setFname(fname);
		int re = dao.insert(g);
		ModelAndView mav = new ModelAndView("redirect:/listGoods.do");
		
		if(re != 1) {
			mav.addObject("msg", "��ǰ��Ͽ� �����Ͽ����ϴ�.");
			mav.setViewName("error");
		}
		return mav;
	}
	
	@RequestMapping("/detailGoods.do")
	public ModelAndView getGoods(int no) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("g", dao.findByNo(no));
		return mav;
	}
	
	@RequestMapping(value = "/updateGoods.do", method = RequestMethod.GET)
	public ModelAndView updateForm( int no) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("g", dao.findByNo(no));
		return mav;
	}

	@RequestMapping(value = "/updateGoods.do", method = RequestMethod.POST)
	public ModelAndView updateSubmit(HttpServletRequest request,GoodsVO g) {
		String path = request.getRealPath("images");
		
		//���� �����̸��� �̸� ������ ����
		String oldFname = g.getFname();
		
		//���ε��� ������ ������ �޾ƿ�
		MultipartFile uploadFile = g.getUploadFile();
		String fname = uploadFile.getOriginalFilename();
		byte[] data;
		try {
			data = uploadFile.getBytes();

			//����, ������ �����ߴٸ�
			//���ε� ������ �ִٸ� ������ �����Ѵ�.
			if(fname != null && !fname.equals("")) {
				FileOutputStream fos = new FileOutputStream(path + "/" + fname);
				fos.write(data);
				fos.close();
				
				g.setFname(fname);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		int re = dao.update(g);
		ModelAndView mav = new ModelAndView("redirect:/listGoods.do");
		if(re != 1) {
			mav.addObject("msg", "��ǰ ������ �����Ͽ����ϴ�.");
			mav.setViewName("error");
		}else {//������ �������� ��
			if(fname != null && !fname.equals("")) {// ����Ӹ��ƴ϶� ������ �����ߴٸ�
				File file = new File(path + "/" + oldFname);
				//���� ���� ����
				file.delete();
			}
		}
		return mav;
	}
	
	@RequestMapping("/deleteGoods.do")
	public ModelAndView deleteGoods(HttpServletRequest request, int no) {
		
		String fname = dao.findByNo(no).getFname();
		String path = request.getRealPath("images");
		
		
		int re = dao.delte(no);
	
		ModelAndView mav = new ModelAndView("redirect:/listGoods.do");
		
		if(re != 1) {
			mav.addObject("msg", "��ǰ������ �����Ͽ����ϴ�.");
			mav.setViewName("error");
		}else {
			File file = new File(path + "/" + fname);
			file.delete();
		}
		
		return mav;
	}
}
