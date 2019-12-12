package com.simple.www.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.simple.www.dao.MemberDAO;
import com.simple.www.vo.MemberVO;

@Controller
@RequestMapping("/member/")
public class Member {

	@Autowired
	MemberDAO mDAO;

	@RequestMapping("login.van")
	public ModelAndView loginForm(ModelAndView mv) {

		mv.setViewName("member/login");

		return mv;
	}

	@RequestMapping("join.van")
	public ModelAndView joinForm(ModelAndView mv) {
		mv.setViewName("member/join");

		return mv;
	}

	@RequestMapping("joinProc.van")
	public ModelAndView joinproc(ModelAndView mv, MemberVO vo, HttpSession session, RedirectView rv) {
		int cnt = mDAO.joinProc(vo);

		if (cnt == 1) {
			session.setAttribute("SID", vo.getId());
			rv.setUrl("/www/main.van");
			mv.setView(rv);
		} else {
			
			rv.setUrl("/www/member/join.van");
			mv.setView(rv);
		}
		return mv;
	}

	@RequestMapping("loginProc.van")
	public ModelAndView loginProc(HttpSession session, RedirectView rv, ModelAndView mv, MemberVO vo) {
		int cnt = mDAO.loginProc(vo);
		if (cnt == 1) {
			// 이 경우는 아이디와 비밀번호가 일치하는 회원이 한명 있다는 이야기이므로
			// 로그인 처리를 해주면되는데
			// 로그인 처리는 세션에 아이디를 입력해주기로 하자.
			session.setAttribute("SID", vo.getId());
			rv.setUrl("/www/main.van");
			mv.setView(rv);

		} else {
			// 이경우는 로그인의 실패한 경우이므로
			// 다시 로그인페이지로 이동 시킨다
			rv.setUrl("/www/member/login.van");
			mv.setView(rv);
		}
		return mv;
	}

	@RequestMapping("logout.van")
	public ModelAndView logout(ModelAndView mv, RedirectView rv, HttpSession session) {

		session.setAttribute("SID", "");
		rv.setUrl("/www/");
		mv.setView(rv); //객체 형식으로 받고
		return mv;
	}
	@RequestMapping("showName.van")
	public ModelAndView showname(ModelAndView mv, MemberVO vo , HttpServletRequest req) {
		String name =mDAO.showName(vo);
		System.out.println("이름은 = "+name);
		req.setAttribute("NAME", name);
		mv.setViewName("member/showName"); //스트링 형식으로 받고
		
		return mv;
	}
	
	@RequestMapping("showId.van")
	public ModelAndView showId(ModelAndView mv) {
		List<MemberVO> list=mDAO.showId();
		mv.addObject("LIST", list);
		mv.setViewName("member/showId");
		return mv;
	}
	
	@RequestMapping("idCheck.van")
	@ResponseBody
	public MemberVO idCheck(String id) {
	MemberVO vo = mDAO.idCheck(id);
	
	
		
		
		/*
	 우리가 현재 필요한 데이터는 json 형식의 데이터다
	 데이터의 숫자가 적을 경우는 해당 json 형식의 데이터를 만들어 주는것이 문제 없지만
	 여러개라면 문제가 될 수 있다.
	 코드의 길이가 늘어날 수 있고
	 확인하는 작업이 불편해진다.
	 
	 
	 만약 vo의 모든 변수에 대한 데이터를 json 형식으로 변환시켜야 한다면
	 모든 변수의 키값을 만들고 데이터를 입력해줘야 하겠다.
	 
	 다행이도 스프링에서는 json 문서를 쉽게 만들 수 있는 방법을 제공하고 있다
	 
	 
	 방법]
	 	실행함수의 반환값을 VO ㄹ타입으로  정하고
	 	함수에 
	 		@ResponseBody
	 		라는 어노테이션을 붙여주면 된다.
	 		
	 	VO에 선언된 변수이름을 키값으로 하고 
	 	입력된 데이터를 벨류로 해서
	 	json 문서를 알아서 만들어 준다.
	 	
	  	
	 */
		return vo;
}
	
}