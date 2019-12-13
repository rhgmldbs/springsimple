package com.simple.www.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.simple.www.dao.MemberDAO;
import com.simple.www.vo.BoardVO;


@Controller
@RequestMapping("/board/")
public class Board {

	@Autowired
	MemberDAO mDAO;
	
	
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
	
}
