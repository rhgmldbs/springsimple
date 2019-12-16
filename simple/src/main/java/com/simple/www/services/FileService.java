package com.simple.www.services;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintStream;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.simple.www.dao.FileDAO;
import com.simple.www.dao.MemberDAO;
import com.simple.www.util.FileUtil;

public class FileService {

	MemberDAO mDAO;
	FileDAO fDAO;
	public void setDAO(MemberDAO mDAO) {
			this.mDAO= mDAO;
	};
	public void setDAO(FileDAO fDAO) {
		this.fDAO= fDAO;
};
	//파일업로드를 처리할 함수
public String singleUpProc(MultipartFile upfile, HttpSession session) {
	//이 함수는 파일을 업로드 하기 위해서 컨트롤러에서 업로드할 파일의 정보를 받아와야 한다
	//그 정보는 MultipartFile 이라는 타입으로 전송이 될 것이고
	// 거기서 꺼내서 사용해야 한다.
	
	//저장이름을 기억할 변수
	String tmp = new String();
	String spath = session.getServletContext().getRealPath("resources/upload");
		/*
		 * String path= this.getClass().getResource("/").getPath(); int idx =
		 * path.indexOf("/WEB-INF"); path =path.substring(0,idx)+"/resources/upload";
		
	
	System.out.println("srvs path : " + path);
 */	
	System.out.println("srvs path: "+ spath);
	
	String rePath =spath.substring(0, spath.indexOf("\\metadata"));
	rePath= rePath +"\\git\\springsimple\\simple\\src\\main\\webapp\\resources\\upload";
	
	
	//먼저 클라이언트가 업로드한 원본이름을 알아낸다,
	String oriName = upfile.getOriginalFilename();
	
	
	if(oriName == null || oriName.length()==0){
		return "";
		
		
	}
	//	이 라인이 실행된다는 의미는 업로드 할 파일이 존재한다는 이야기 이다.
	// 혹시 업로드할 파일하고 중복되는 이름의 파일이 이미 존재하는지 검사해서
	// 있는 경우는 다른 이름으로 저장을 해야 한다.
	
	String saveName = FileUtil.rename(spath, oriName);
	
	//저장할 이름이 생겼으므로 준비된 변수에 기억해 놓는다.
	saveName = tmp;
	
	// 이제 업로드된 파일을 우리의 정상적인 경로에 저장한다.
	// 이 이름은 이후 데이터베이스에 등록할 때 사용해야 한다.
	// 따라서 이름을 기억해 놓은 필요가 생겼다.
	
	FileInputStream fin =null;
	BufferedInputStream bin =null;
	PrintStream ps =null;
	
	
	try {
		
		File file = new File(spath, saveName);
		upfile.transferTo(file);
		
		fin= new FileInputStream(file);
		bin = new BufferedInputStream(fin);
		
		
		
	} catch (Exception e) {
		e.printStackTrace();
		
	}
	
	
	
	return saveName;
	

}

//다중 파일 업로드 처리 함수 

public String[] uploadProc(HttpSession session, MultipartFile[] upfile) {
	
	
	String[] saveName = new String[upfile.length];

	for(int i =0; i<upfile.length;i++) {
		saveName [i] =singleUpProc(upfile[i],session);
		
	}
	
	return saveName;
}

}


	 