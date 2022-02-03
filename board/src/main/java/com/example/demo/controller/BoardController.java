package com.example.demo.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	/*
	 * 매개변수로 int를 주면 내부적으로 Integer.parseInt(request.getParameter(해당변수명))
	 * 이 동작하는데 null일 경우에는 오류가 발생한다. 그래서 int를 매개변수로 줄땐 default 값을 준다.
	 */
	@RequestMapping("/listBoard")
	public void list(
			HttpSession session,//정렬칼럼,검색칼럼,검색어를 상태유지하기 위하여 session변수를 매개변수로 정의합니다. 
			Model model,//View페이지에서 필요한 데이터를 유지하기 위하여 Model을 선언합ㄴ디ㅏ.
			String searchColumn, // 검색칼럼을 받아오기 위한 변수
			String keyword,   //검색어를 받아오기 위한 변수
			String orderColumn,//정렬칼럼을 받아 오기 위한 변수
			@RequestParam(value = "pageNUM", defaultValue = "1")  int pageNUM//페이지 번호를 받아오기 위한 변수
			
			) {
	
		
		//만약에 새로운 정렬이 없고 세션에 정렬칼럼명이 저장되어 있다면
		//세션에 저장된 정렬칼럼명을 읽어온다.
		if(orderColumn == null && session.getAttribute("orderColumn")!=null) {
			orderColumn = (String)session.getAttribute("orderColumn");
		}
		
		
		//만약, 새로운 검색어가 없고
		//세션에 검색어가 저장되어 있다면
		//세션에 저장된 검색칼럼명과 검색어를 읽어온다.
		if( keyword == null ) {
			if(session.getAttribute("keyword") != null ) {
				searchColumn = (String)session.getAttribute("searchColumn");
				keyword = (String)session.getAttribute("keyword");
			}
		}
		
		System.out.println("정렬칼럼:"+orderColumn);
		System.out.println("pageNUM:"+pageNUM);
		System.out.println("검색칼럼:"+searchColumn);
		System.out.println("검색어:|"+keyword+"|");
//		if(orderColumn == null) {
//			orderColumn = "no";
//		}
		
		//현재페이지에 보여줄 시작레코드와 마지막레코드의 위치를 계산한다.
		int start = (pageNUM-1)* dao.pageSIZE + 1;
		int end = start + dao.pageSIZE - 1;
		
		//Dao가 게시물 목록을 검색할 때 필요한 
		//정보(정렬칼럼명, 검색칼럼명, 검색어, 현재페이지에 보여줄 시작레코드,마지막레코드)
		//들을 map에 저장한다.
		HashMap map= new HashMap();
		map.put("orderColumn", orderColumn);
		map.put("searchColumn", searchColumn);
		map.put("keyword", keyword);
		map.put("start", start);
		map.put("end", end);
		
		//dao를 통해 검색한 결과를 model에 저장한다.
		//이대 findAll메소드에서 전체레코드수를 구하고 
		//그 값을 갖고 전체페이지수도 계산합니다.
		model.addAttribute("list", dao.findAll(map));
		
		//dao에 계산된 전체페이지수를 model에 상태유지합니다.
		model.addAttribute("totalPage", dao.totalPage);
		
		//만약에 정렬하였다면 정렬 칼럼이름을 세션에 저장하여 상태유지 합니다.
		if(orderColumn != null) {
			session.setAttribute("orderColumn", orderColumn);
		}
		
		//만약에 검색하였다면 
		//검색한 칼럼이름과 검색어를 세션에 저장하여 상태유지 합니다
		if(keyword != null) {
			session.setAttribute("searchColumn", searchColumn);
			session.setAttribute("keyword", keyword);
		}
	}
	
	@RequestMapping(value="/insertBoard", method=RequestMethod.GET)
	public void insertForm(Model model) {
		model.addAttribute("no", dao.getNextNo());
	}
	
	
	@RequestMapping(value="/insertBoard", method=RequestMethod.POST)
	public ModelAndView insertSubmit(HttpServletRequest request, BoardVO b) {
		String ip = request.getRemoteAddr();
		b.setIp(ip);
		
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
		dao.updateHit(no);
		 model.addAttribute("b", dao.findByNo(no));
	}
	
	@RequestMapping(value = "/deleteBoard", method=RequestMethod.GET)
	public void deleteForm(int no, Model model) {
		model.addAttribute("no",no);
	}
	
	@RequestMapping(value = "/deleteBoard", method=RequestMethod.POST)
	public ModelAndView deleteSubmit(int no, String pwd, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("redirect:/listBoard");
		String oldFname = dao.findByNo(no).getFname();
		
		HashMap map = new HashMap();
		map.put("no", no);
		map.put("pwd", pwd);
		
		int re = dao.delete(map);
		if(re==1) {
			
			if(oldFname != null && !oldFname.equals("")) {
				String path = request.getRealPath("upload");
				File file = new File(path + "/" + oldFname);
				file.delete();
			}
			
		}else {
			mav.setViewName("error");
			mav.addObject("msg", "게시물 삭제에 실패하였습니다.");
		}
		
		return mav;
	}
}
