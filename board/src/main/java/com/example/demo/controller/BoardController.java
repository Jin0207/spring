package com.example.demo.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.BoardDAO;
import com.example.demo.vo.BoardVO;

@Controller
public class BoardController {
	@Autowired
	private BoardDAO dao;

	public void setDao(BoardDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/listBoard")
	public void findAll(Model model){
		model.addAttribute("list",dao.findAll());
	}
	
	@RequestMapping(value="/insertBoard", method=RequestMethod.GET)
	public void insertForm() {

	}
	
	
	@RequestMapping(value="/insertBoard", method=RequestMethod.POST)
	public ModelAndView insertSubmit(HttpServletRequest request, BoardVO b) {
		ModelAndView mav = new ModelAndView("redirect:/listBoard");
		
		String path = request.getRealPath("upload");
		System.out.println(path);
		b.setFname("");
		
		MultipartFile uploadFile = b.getUploadFile();
		String fname = uploadFile.getOriginalFilename();
		
		if(fname != null && !fname.equals("")) {
			b.setFname(fname);
		}
		
		int re = dao.insert(b);
		
		if(re != 1) {
			mav.setViewName("error");
			mav.addObject("msg", "게시물 등록 실패");
		}else {
			try {
				byte[] data = uploadFile.getBytes();
				if(fname != null && !fname.equals("")) {
					//파일을 서버의 하드디스크에 출력하기위한 스트림
					FileOutputStream fos = new FileOutputStream(path + "/" + fname);
					fos.write(data);
					fos.close();
				}
			} catch (Exception e) {
				System.out.println("예외발생:" + e.getMessage());
			}
		}
		
		return mav;
	}
	
	@RequestMapping(value = "/updateBoard", method = RequestMethod.GET)
	public void updateForm(Model model,int no) {
		detail(model, no);
	}
	
	@RequestMapping(value = "/updateBoard", method = RequestMethod.POST)
	public ModelAndView updateSubmit(HttpServletRequest request, BoardVO b) {
		
		ModelAndView mav = new ModelAndView("redirect:/listBoard");
		
		String path = request.getRealPath("upload");
		String oldFname = b.getFname();
		MultipartFile uploadFile = b.getUploadFile();
		String fname = uploadFile.getOriginalFilename();
		
		if( fname != null && !fname.equals("")) {
			b.setFname(fname);
		}
		
		int re = dao.update(b);
		
		if(re == 1) {
			
			if( fname != null && !fname.equals("")) {
				try {
					byte[] data = uploadFile.getBytes();
					
					FileOutputStream fos = new FileOutputStream(path + "/" + fname);
					fos.write(data);
					fos.close();
					
					if(oldFname != null && !oldFname.equals("")) {
						File file = new File(path + "/" + oldFname); 
						file.delete();
					}
					
				} catch (Exception e) {
					System.out.println("예외발생:" +e.getMessage());
				}
			}
			
		}else {
			mav.addObject("msg", "게시물 수정에 실패하였습니다.");
			mav.setViewName("error");
		}
		
		return mav;
	}
	
	@RequestMapping("/detailBoard")
	public void detail(Model model,int no) {
		 model.addAttribute("b", dao.findByNo(no));
	}
}
