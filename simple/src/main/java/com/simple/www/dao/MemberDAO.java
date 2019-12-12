package com.simple.www.dao;

import java.util.*;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.simple.www.vo.*;

public class MemberDAO {

	@Autowired
	SqlSessionTemplate sqlSession;

	public int loginProc(MemberVO vo) {
		int cnt = sqlSession.selectOne("mSQL.Login", vo);

		return cnt;

	}

	public int joinProc(MemberVO vo) {
		int cnt = sqlSession.insert("mSQL.join", vo);

		return cnt;
	}

	public String showName(MemberVO vo) {
		String str = sqlSession.selectOne("mSQL.showName",vo);

		
		return str;
	}
	public List<MemberVO> showId(){
		List<MemberVO> list = sqlSession.selectList("mSQL.showId");
		
		
		return list;
		
	}
	public MemberVO idCheck(String id) {
		return sqlSession.selectOne("mSQL.idCount",id);
		
	}
	

}
