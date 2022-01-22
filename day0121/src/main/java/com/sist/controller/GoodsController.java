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
	public ModelAndView insertSubmit(HttpServletRequest request , //업로드할 폴더의 실경로를 알아오기 위하여 httpServletRequest객체를 매개변수로 선언
			GoodsVO g) {
		
		//request객체를 통하여 업로드할 폴더의 실제 경로를 읽어옴
		String path = request.getRealPath("images");
		System.out.println("path: "+path);
		
		// vo에 업로드한 파일의 정보(이름,내용)을 받아온다.
		MultipartFile uploadFile = g.getUploadFile();
		//업로드한 파일의 이름을 가져옴
		String fname = uploadFile.getOriginalFilename();
		
		byte[] data;
		try {
			//업로드한 파일의 내용을 가져옴
			data = uploadFile.getBytes();
			// 서버에 파일을 출력하기 위한 스트림 생성
			FileOutputStream fos = new FileOutputStream(path + "/" + fname);
			//서버에 파일 출력
			fos.write(data);
			fos.close();
		} catch (Exception e) {
			System.out.println("예외발생:" + e.getMessage());
			// TODO: handle exception
		}
		
		
		g.setFname(fname);
		int re = dao.insert(g);
		ModelAndView mav = new ModelAndView("redirect:/listGoods.do");
		
		if(re != 1) {
			mav.addObject("msg", "상품등록에 실패하였습니다.");
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
		
		//원래 사진이름을 미리 변수에 담음
		String oldFname = g.getFname();
		
		//업로드한 파일의 정보를 받아옴
		MultipartFile uploadFile = g.getUploadFile();
		String fname = uploadFile.getOriginalFilename();
		byte[] data;
		try {
			data = uploadFile.getBytes();

			//만약, 사진도 수정했다면
			//업로드 파일이 있다면 파일을 복사한다.
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
			mav.addObject("msg", "상품 수정에 실패하였습니다.");
			mav.setViewName("error");
		}else {//수정에 성공했을 때
			if(fname != null && !fname.equals("")) {// 내용뿐만아니라 사진도 수정했다면
				File file = new File(path + "/" + oldFname);
				//원래 사진 삭제
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
			mav.addObject("msg", "상품삭제에 실패하였습니다.");
			mav.setViewName("error");
		}else {
			File file = new File(path + "/" + fname);
			file.delete();
		}
		
		return mav;
	}
}
