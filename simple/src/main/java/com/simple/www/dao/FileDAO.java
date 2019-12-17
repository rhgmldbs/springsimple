package com.simple.www.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.simple.www.vo.FileVO;
import com.simple.www.vo.GalleryVO;

public class FileDAO {
   @Autowired
   SqlSessionTemplate sqlSession;
   
   //파일 정보 입력 전담 처리 함수
   public int insertPhoto(FileVO fVO) {
      return sqlSession.insert("mSQL.addPic", fVO);
   }
   //갤러리 파일 전담 처리 함수 
   public int insertgalley(GalleryVO gVO){
	   return sqlSession.insert("mSQL.addgallery",gVO);
   }
  //갤러리 파일 리스트 처리 함수
   public List<GalleryVO> gallerylist(){
	   List<GalleryVO> list =sqlSession.selectList("mSQL.gallerylist");
	   
	   return list;
	   
   }
   
   
}