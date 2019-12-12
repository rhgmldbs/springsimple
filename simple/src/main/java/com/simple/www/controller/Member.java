package com.simple.www.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
		mv.setView(rv);
		return mv;
	}

}
