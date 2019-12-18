package com.simple.www.dao;

import java.util.List;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.simple.www.util.PageUtil;

public class ReBoardDAO {
@Autowired	
	SqlSessionTemplate sqlSession;


	//게시물 카운트 조회 전담 처리 함수
public int getTotalCnt() {
	return sqlSession.selectOne("rbSQL.getTotalCount");
	
}
//페이지 게시물 조회 전담 처리 함수

public List getRBList(PageUtil page) {
	return sqlSession.selectList("rbSQL.getList",page);
	
}
}
