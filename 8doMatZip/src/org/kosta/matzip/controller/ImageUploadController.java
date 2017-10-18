package org.kosta.matzip.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.matzip.model.PostDAO;
import org.kosta.matzip.model.PostVO;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ImageUploadController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
				String pno=request.getParameter("pno");
				String workspacePath="C:\\Users\\kosta\\git\\semi-project\\8doMatZip\\WebContent\\pictures";
			//WAS 업로드 경로 : 개발완료후에는 이 경로로 변경 
			//String savePath = request.getServletContext().getRealPath("upload");		 
				int sizeLimit = 1024*1024*10;		 
				MultipartRequest multi = new MultipartRequest(request, workspacePath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());
				System.out.println(multi.getParameter("command"));//만약 현 웹어플리케이션에서 업로드 서비스가 여러개라고 하면 command 를 이용해 조건처리해야 한다 
				// 전송받은 데이터가 파일일 경우 getFilesystemName()으로 파일 이름을 받아올 수 있다.
				String fileName = multi.getFilesystemName("pictures");
				System.out.println(fileName);
				PostVO pvo=new PostVO();
				// 다수의 파일을 쓸때는 getFilesystemNames 를 쓰면 된다.
				ArrayList<String> pictures=PostDAO.getInstance().findImageByPno(pno);
				//pvo.setPictures(pictures);
				//System.out.println("db insert전 pvo:"+pvo);
				PostDAO.getInstance().registerImage(pno, pictures);
				//request.setAttribute("pictures", pictures);
				return "redirect:DispatcherServlet?command=postDetail&pno="+pno;
			}
		}
