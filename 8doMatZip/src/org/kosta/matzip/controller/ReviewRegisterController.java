package org.kosta.matzip.controller;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.matzip.model.PostDAO;
import org.kosta.matzip.model.PostVO;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ReviewRegisterController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//윤주의 개발 경로
		String workspacePath="C:\\Users\\Administrator\\git\\semi-project\\8doMatZip\\WebContent\\pictures";
		int sizeLimit = 1024*1024*10;		 
		MultipartRequest multi = new MultipartRequest(request, workspacePath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());
		String command= multi.getParameter("command");
		System.out.println("registercontroller:"+command);
		if(command=="reviewregister" || command.equals("reviewregister"))	{
			String ptitle=multi.getParameter("title");
			String pcontent=multi.getParameter("content");
			int pstar =Integer.parseInt(multi.getParameter("pstar"));
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
			PostVO vo=new PostVO(ptitle, pcontent,pstar, paddress, ptime, ptel, pprice, petc,loc,sigungu, mid);
			String pno=PostDAO.getInstance().reviewRegister(vo, locno);
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
		}	//command = register
		else{ //command= updatepost
		HttpSession locsession = request.getSession(false); 
		String pno = multi.getParameter("pno");
     	String ptitle=multi.getParameter("title");
        String pcontent=multi.getParameter("content");
        int pstar =(Integer.parseInt(multi.getParameter("pstar")));
        int plike = PostDAO.getInstance().findPostByPno(pno).getPlike();
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
        int phit=(Integer.parseInt(multi.getParameter("phit")));
        String loc=multi.getParameter("loc");
        String sigungu=multi.getParameter("sigungu");
        locsession.setAttribute("loc",loc);
        locsession.setAttribute("sigungu",sigungu);
        PostVO pvo=new PostVO(pno,ptitle, pcontent,pstar,plike,paddress, ptime, ptel, pprice, petc,phit,loc,sigungu, mid);
        PostDAO.getInstance().updatePost(pvo);
        	// 이미지 찾아서 변경하는 부분
        ArrayList<String> pictures = PostDAO.getInstance().findImageByPno(pno);
        String filename="";
		String filename2="";
		  @SuppressWarnings("rawtypes")
		Enumeration files = multi.getFileNames();
		// 업로드한 파일들의 이름을 얻어옴
		  String file = (String)files.nextElement();
		  filename = multi.getFilesystemName(file);
		 
		  String file2 = (String)files.nextElement();
		  filename2 = multi.getFilesystemName(file2);
		  
		  pictures.set(0, filename);
		  pictures.set(1, filename2);
		  PostDAO.getInstance().updateImage(pno, pictures);
		  return "redirect:Post/postupdate_result1.jsp";
	}
	}
}

