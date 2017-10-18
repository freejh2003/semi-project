package org.kosta.matzip.controller;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.matzip.model.PostDAO;
import org.kosta.matzip.model.PostVO;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ReviewRegisterController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String workspacePath="C:\\Users\\kosta\\git\\semi-project\\8doMatZip\\WebContent\\pictures";
		int sizeLimit = 1024*1024*10;		 
		MultipartRequest multi = new MultipartRequest(request, workspacePath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());
			String ptitle=multi.getParameter("title");
			System.out.println(ptitle);
			String pcontent=multi.getParameter("content");
			System.out.println(pcontent);
			String paddress=multi.getParameter("address");
			String startTime=multi.getParameter("startTime");
			String endTime=multi.getParameter("endTime");
			String ptime=startTime+"~"+endTime;
			String tel1=multi.getParameter("tel1");
			String tel2=multi.getParameter("tel2");
			String tel3=multi.getParameter("tel3");
			
			String ptel=tel1+"-"+tel2+"-"+tel3;
			
			String pprice=multi.getParameter("price");
			String petc=multi.getParameter("etc");
			String mid=multi.getParameter("mid");
			String loc=multi.getParameter("loc");
			String sigungu=multi.getParameter("sigungu");
			
			String locno=PostDAO.getInstance().findLocNo(loc, sigungu);
			PostVO vo=new PostVO(ptitle, pcontent, paddress, ptime, ptel, pprice, petc, mid);
			String pno=PostDAO.getInstance().reviewRegister(vo, locno);
			System.out.println("1");
			//ArrayList<String> pictures=new ArrayList<String>();
		
			// 업로드한 파일들을 Enumeration 타입으로 반환
			// Enumeration형은 데이터를 뽑아올때 유용한 인터페이스임.  Enumeration객체는 java.util 팩키지에 정의 되어있으므로
//			     java.util.Enumeration을 import 시켜야 함.
			String filename="";
			String filename2="";
			  @SuppressWarnings("rawtypes")
			Enumeration files = multi.getFileNames();
			  
			 
			// 업로드한 파일들의 이름을 얻어옴
			  String file = (String)files.nextElement();
			  filename = multi.getFilesystemName(file);
			 
			  String file2 = (String)files.nextElement();
			  filename2 = multi.getFilesystemName(file2);
			  
			 ArrayList<String> pictures=new ArrayList<String>();
			pictures.add(filename);
			pictures.add(filename2);
			PostDAO.getInstance().registerImage(pno, pictures);
			return "redirect:Post/postRegister_result1.jsp";
	}

}
