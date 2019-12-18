package com.simple.www.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.simple.www.dao.ReBoardDAO;
import com.simple.www.util.PageUtil;

@Controller
@RequestMapping("/board")
public class ReBoard {

	
	@Autowired
	ReBoardDAO rbDAO;
	
	
	@RequestMapping("/reBoardForm.van")
	
	public ModelAndView reBoardForm(ModelAndView mv, PageUtil pageUtil) {
		
		int nowPage = 1;
		
		//할일
		//	1. 게시물 전체 갯수를 구하고
		int total= rbDAO.getTotalCnt();
		if(pageUtil.getNowPage() == 0)	{
			nowPage=1;
			
		}else {
			
			nowPage = pageUtil.getNowPage();
			
		}
		//2. pageUtil 데이터 셋팅하고	
		pageUtil.setVar(nowPage, total,3, 3);
		
		//3. 질의 명령 보내고 결과 받고 
		
		List list = rbDAO.getRBList(pageUtil);
		
		//4.데이터 전달하고
		mv.addObject("LIST",list);
		mv.addObject("PAGE",pageUtil);
		
		
		//5. 뷰를 부르고
		mv.setViewName("board/reboard");
		
		
		return mv;
	}
}
