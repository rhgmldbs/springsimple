package com.simple.www.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.simple.www.dao.FileDAO;
import com.simple.www.dao.MemberDAO;
import com.simple.www.services.FileService;
import com.simple.www.vo.BoardVO;
import com.simple.www.vo.GalleryVO;
import com.simple.www.vo.MemberVO;


@Controller
@RequestMapping("/board/")
public class Board {

	@Autowired
	MemberDAO mDAO;
	@Autowired
	FileService fileSrvc;
	@Autowired
	FileDAO fDAO;
	
	@RequestMapping("boardlist.van")
	public ModelAndView boardlist(ModelAndView mv) {
			List<BoardVO> list=mDAO.boardlist();
			mv.setViewName("board/list");
			mv.addObject("LIST", list);
			return mv;
			
		}
	
	
	
	
	@RequestMapping("writeform.van")
	public ModelAndView writeform(ModelAndView mv) {
	
		mv.setViewName("board/boardwrite");
		
		return mv;
		
	}
	
	@RequestMapping("boardwrite.van")
	public ModelAndView boardwrite(ModelAndView mv, BoardVO vo ,RedirectView rv) {
		
		mDAO.boardwrite(vo);
		rv.setUrl("/www/board/boardlist.van");
		mv.setView(rv);
		return mv;
	}
	
	
	@RequestMapping("uploading.van")
	public void uploadingform() {
		
	}
	
	@RequestMapping("gallery.van")
	public ModelAndView galleryproc(ModelAndView mv, GalleryVO vo,  HttpSession session, RedirectView rv) {
		
		fileSrvc.setDAO(fDAO);
		fileSrvc.Galleryup(session, vo);
	
		
		/* mv.addObject("CNT",vo); */
		rv.setUrl("/www/main.van");
		mv.setView(rv);
		

			
		return mv;
	}
	
	
	@RequestMapping("gallerylist.van")
	public ModelAndView gallerylist(ModelAndView mv) {
		List<GalleryVO> list = fDAO.gallerylist();
		mv.setViewName("/board/gallery");
		mv.addObject("LIST", list);
		
		
		return mv;
	}
	
	
	
}
