package org.kosta.matzip.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.matzip.model.MemberVO;
import org.kosta.matzip.model.PostDAO;
import org.kosta.matzip.model.PostVO;

public class PostDetailController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pno = request.getParameter("pno");
		MemberVO mvor=new MemberVO();
		ArrayList<String> images = PostDAO.getInstance().findImageByPno(pno);
		PostVO pvo = PostDAO.getInstance().findPostByPno(pno);	
		pvo.setPictures(images);
		HttpSession session=request.getSession(false);
		if(session!=null) {
			mvor.getRecentbean().addItem(pvo);
			session.setAttribute("mvor", mvor.getRecentbean().getRecentList()); 
		}
		request.setAttribute("pvo",pvo);
		request.setAttribute("url","../Post/postDetail.jsp");
		return "Template/home.jsp";
	}

}
