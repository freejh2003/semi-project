package org.kosta.matzip.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.kosta.matzip.model.CommentVO;
import org.kosta.matzip.model.PostDAO;
import org.kosta.matzip.model.PostVO;

public class PostDetailController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pno = request.getParameter("pno");
		PostDAO.getInstance().updateHit(pno);
		ArrayList<String> images = PostDAO.getInstance().findImageByPno(pno);
		PostVO pvo = PostDAO.getInstance().findPostByPno(pno);
		pvo.setPictures(images);
		ArrayList<CommentVO> clist = PostDAO.getInstance().getCommentList(pno);
		pvo.setCommentList(clist);
		
		request.setAttribute("pvo",pvo);
		request.setAttribute("url","../Post/postDetail.jsp");
		return "Template/home.jsp";
		//MemberVO mvor=new MemberVO();
		/*HttpSession session=request.getSession(false);
		if(session!=null) {
			System.out.println(pvo.toString());
			mvor.getRecentbean().addItem(pvo);
			ArrayList<PostVO> mvorlist=mvor.getRecentbean().getRecentList();
			session.setAttribute("mvor", mvorlist); 
		}*/
	}

}
